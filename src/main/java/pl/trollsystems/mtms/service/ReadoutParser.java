package pl.trollsystems.mtms.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.trollsystems.mtms.model.RawReadout;
import pl.trollsystems.mtms.model.Readout;
import pl.trollsystems.mtms.model.SplitReadoutWithoutTransmiterParameter;
import pl.trollsystems.mtms.model.TransmitterParameterReadout;
import pl.trollsystems.mtms.repository.RawReadoutRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ReadoutParser {
     
    private List<Readout> readouts = new ArrayList<>();

    public List<Readout> parseByFactor(List<RawReadout> rawReadouts) {
//        String REGEX_MAIN = "#";
//        https://mkyong.com/java/java-how-to-split-a-string/
//        String REGEX_MAIN = "#F|#T|#M|#I|#G|#E|#X";
//        String s = "#F/a=0#T/s=703454459/p=22.04.16,22:00:41+08/m=703454401#M/b=+0.1103834+1.1050978+11.413574+0.9947100+8.9399995+0.1102827+1.1053321+11.429443+0.9950699+9.0900001+0.1102806+1.1053328+11.397705+0.9950600+9.1800003+0.1103652+1.1054149+11.413574+0.9950600+9.1099996+0.1102231+1.1054673+11.429443+0.9952499+9.0200004+0.1102379+1.1055756+11.413574+0.9953299+8.9300003+0.1102356+1.1056935+11.413574+0.9954699+8.7200002+0.1102290+1.1058555+11.413574+0.9956300+8.4799995+0.1102998+1.1059556+11.413574+0.9956600+8.0500001+0.1102587+1.1060949+11.413574+0.9958499+7.8899998+0.1102256+1.1062601+11.397705+0.9960299+7.8600001+0.1102090+1.1064486+11.429443+0.9962499+6.9800000+0.1101046+1.1066167+11.429443+0.9965100+6.1999998+0.1102691+1.1068092+11.397705+0.9965499+5.3800001+0.1103923+1.1068673+11.413574+0.9964900+4.6799998+0.1103362+1.1068792+11.413574+0.9965499+4.2500000/c=+1+1#I/n=656/s=31/b=99/e=9.20/f=21.15/h=26/v=+3.918#G/a=Measurement#E/e#X/a=15973";

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
//            transmitterParameterReadout.setId(1L);


            //TODO save DB and get ID
            //co 30min (16 odczytów) -> 3x na dobę

            int PERIOD_OF_READOUT_MINUT = 30;
            int QUANTITY_READOUTS_IN_PACKAGE = 16;

            for (int i = 0; i < QUANTITY_READOUTS_IN_PACKAGE; i++) {
                Readout readout = new Readout();

                SplitReadoutWithoutTransmiterParameter splitReadoutWithoutTransmiterParameter = splitReadoutQueue.remove();

                readout.setReadoutDataTime(stopDateTimeReading.minusMinutes(PERIOD_OF_READOUT_MINUT * (QUANTITY_READOUTS_IN_PACKAGE - i)));
                readout.setpD(splitReadoutWithoutTransmiterParameter.getpD());
                readout.setpBaro(splitReadoutWithoutTransmiterParameter.getpBaro());
                readout.settBaro(splitReadoutWithoutTransmiterParameter.gettBaro());
                readout.setP1(splitReadoutWithoutTransmiterParameter.getP1());
                readout.settOb1(splitReadoutWithoutTransmiterParameter.gettOb1());
                readout.setTransmitterParameterReading(transmitterParameterReadout);
                readouts.add(readout);
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
