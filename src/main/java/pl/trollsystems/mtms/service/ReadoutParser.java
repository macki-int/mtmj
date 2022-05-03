package pl.trollsystems.mtms.service;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.trollsystems.mtms.model.RawReadout;
import pl.trollsystems.mtms.model.Readout;
import pl.trollsystems.mtms.model.SplitReadoutWithoutTransmiterParameter;
import pl.trollsystems.mtms.model.TransmitterParameterReadout;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ReadoutParser {
    //period: 30min (16 readouts in one package) -> sending 3 times per day
    int PERIOD_OF_READOUT_MINUTES = 30;
    int QUANTITY_READOUTS_IN_PACKAGE = 16;
    private List<Readout> readouts = new ArrayList<>();

    @Bean
    public List<Readout> parseByFactor(List<RawReadout> rawReadouts) {

//        String REGEX_MAIN = "#";
//        https://mkyong.com/java/java-how-to-split-a-string/
//        String REGEX_MAIN = "#F|#T|#M|#I|#G|#E|#X";

        for (RawReadout rawReadout : rawReadouts) {

            TransmitterParameterReadout transmitterParameterReadout = new TransmitterParameterReadout();

            LocalDateTime stopDateTimeReading = rawReadout.getTransmisionDateTime();
            Queue<SplitReadoutWithoutTransmiterParameter> splitReadoutQueue = new LinkedList<>();

            String[] resultMainFactorParse = parseByMainFactor(rawReadout);
            List<String[]> resultSubmainFactorParse = parseBySubFactor(resultMainFactorParse);

            for (String[] s : resultSubmainFactorParse) {
                String[] resultReadoutDetailParse;

                switch (s[0]) {
                    case "#T":
                        stopDateTimeReading = calcDateTimeAddSeconds(Long.parseLong(s[1].substring(3, s[1].length())));
                        transmitterParameterReadout.setStartMeasureDataTime(s[2].substring(3, s[2].length()));
                        break;
                    case "#M":
                        resultReadoutDetailParse = parseReadoutDetail(s[1].substring(3, s[1].length()));
                        splitReadoutQueue = convertStringArrayToSplitReadout(resultReadoutDetailParse);
                        break;
                    case "#I":
                        transmitterParameterReadout.setSerialNumber(s[1].substring(3, s[1].length()));
                        transmitterParameterReadout.setSignalLevel(s[2].substring(3, s[2].length()));
                        transmitterParameterReadout.setBatteryCapacity(s[3].substring(3, s[3].length()));
                        transmitterParameterReadout.setHumidity(s[6].substring(3, s[6].length()));
                        transmitterParameterReadout.setBatteryVoltage(s[7].substring(3, s[7].length()));
                }
            }
            transmitterParameterReadout.setFileName(rawReadout.getFileName());

            RestTemplate restTemplate = new RestTemplate();

            TransmitterParameterReadout transmitterPR = restTemplate.
                    postForObject("http://localhost:8081/transmiter-params",
                            transmitterParameterReadout, TransmitterParameterReadout.class);



            for (int i = 0; i < QUANTITY_READOUTS_IN_PACKAGE; i++) {
                Readout readout = new Readout();

                SplitReadoutWithoutTransmiterParameter splitReadoutWithoutTransmiterParameter = splitReadoutQueue.remove();

                readout.setReadoutDataTime(stopDateTimeReading.minusMinutes(PERIOD_OF_READOUT_MINUTES * (QUANTITY_READOUTS_IN_PACKAGE - i)));
                readout.setpD(splitReadoutWithoutTransmiterParameter.getpD());
                readout.setpBaro(splitReadoutWithoutTransmiterParameter.getpBaro());
                readout.settBaro(splitReadoutWithoutTransmiterParameter.gettBaro());
                readout.setP1(splitReadoutWithoutTransmiterParameter.getP1());
                readout.settOb1(splitReadoutWithoutTransmiterParameter.gettOb1());
                readout.setTransmitterParameterReading(transmitterPR);

                restTemplate.postForObject("http://localhost:8081/readouts",
                        readout, Readout.class);

                readouts.add(readout);
            }

            if (transmitterPR.getId() > 0) {
                rawReadout.setRawImport(true);

                restTemplate.put("http://localhost:8081/rawreadouts/mark-imports",
                        rawReadout, RawReadout.class);
            }
        }
        return readouts;
    }

    private String[] parseByMainFactor(RawReadout rawReadout) {
        String s = rawReadout.getReading();
        String[] result = s.split("(?=#F)|(?=#T)|(?=#M)|(?=#I)|(?=#G)|(?=#E)|(?=#X)");

        return result;
    }

    private List<String[]> parseBySubFactor(String[] result) {
        List<String[]> listResult = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            String[] resultParse = result[i].split("(?=/s=)|(?=/p=)|(?=/m=)|(?=/b=)|(?=/c=)|(?=/n=)|(?=/e=)|(?=/f=)|(?=/v=)|(?=/a=)|(?=/h=)");
            listResult.add(resultParse);
        }

        return listResult;
    }

    private String[] parseReadoutDetail(String s) {
        String[] result = s.split("(?=\\+)|(?=-)");

        return result;
    }

    private Queue<SplitReadoutWithoutTransmiterParameter> convertStringArrayToSplitReadout(String[] result) {
        Queue<SplitReadoutWithoutTransmiterParameter> splitReadoutDeque = new LinkedList<>();

        for (int i = 0; i < result.length; i += 5) {
            SplitReadoutWithoutTransmiterParameter splitReadout = new SplitReadoutWithoutTransmiterParameter();

            splitReadout.setpD(Double.parseDouble(result[i]));
            splitReadout.setpBaro(Double.parseDouble(result[i + 1]));
            splitReadout.settBaro(Double.parseDouble(result[i + 2]));
            splitReadout.setP1(Double.parseDouble(result[i + 3]));
            splitReadout.settOb1(Double.parseDouble(result[i + 4]));

            splitReadoutDeque.add(splitReadout);
        }
        return splitReadoutDeque;
    }

    private LocalDateTime calcDateTimeAddSeconds(long seconds) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime calculateDataTime = LocalDateTime.parse("2000-01-01 00:00:00", formatter);

        return calculateDataTime.plusSeconds(seconds);
    }

}
