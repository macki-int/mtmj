package pl.trollsystems.mtms.service;

import org.junit.jupiter.api.Test;
import pl.trollsystems.mtms.model.RawReadout;
import pl.trollsystems.mtms.model.Readout;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ReadoutParserTest {

//    @Test
//    public void shouldParseByMainFactor() {
//        //given
//        RawReadout rawReadout = new RawReadout();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        rawReadout.setId(1L);
//        rawReadout.setFileName("000000_00 A.txt");
//        rawReadout.setReading("#F/a=0#T/s=704635259/p=22.04.30,14:00:40+08/m=704635201#M/b=+0.1060674+1.0981121+11.835693+0.9920499-1.5700000+0.1059414+1.0981221+11.851806+0.9921699+3.5699999+0.1057745+1.0981055+11.851806+0.9923299+5.9699997+0.1057929+1.0981798+11.851806+0.9923899+7.7600002+0.1056595+1.0981359+11.867431+0.9924799+9.7100000+0.1058231+1.0980808+11.867431+0.9922599+11.659999+0.1056474+1.0980266+11.851806+0.9923800+13.020000+0.1057816+1.0980154+11.835693+0.9922400+14.000000+0.1057512+1.0980001+11.867431+0.9922500+15.130000+0.1058900+1.0978530+11.867431+0.9919599+16.149999+0.1058675+1.0976502+11.851806+0.9917699+17.149999+0.1060557+1.0975620+11.867431+0.9915100+18.020000+0.1060687+1.0974719+11.867431+0.9914100+18.659999+0.1062510+1.0972872+11.883544+0.9910499+18.969999+0.1063562+1.0971460+11.867431+0.9907999+19.309999+0.1063182+1.0970362+11.883544+0.9907199+19.340000/c=+1+1#I/n=656/s=31/b=99/e=9.20/f=21.15/h=35/v=+3.918#G/a=Measurement#E/e#X/a=3010");
//        rawReadout.setTransmisionDateTime(LocalDateTime.parse("2022-04-30 18:42:55", formatter));
//        rawReadout.setRawImport(false);
//
//        RawReadout rawReadout1 = new RawReadout();
//        rawReadout1.setId(1L);
//        rawReadout1.setFileName("000000_01 A.txt");
//        rawReadout1.setReading("#F/a=0#T/s=704750459/p=22.05.01,22:00:39+08/m=704750401#M/b=+0.1062692+1.0938599+11.922363+0.9876000+20.350000+0.1062908+1.0936652+11.906250+0.9873899+20.059999+0.1063956+1.0934597+11.922363+0.9870599+20.569999+0.1066150+1.0933809+11.937988+0.9867799+20.889999+0.1065334+1.0932404+11.937988+0.9867099+20.819999+0.1065367+1.0930882+11.937988+0.9865599+20.879999+0.1064811+1.0930227+11.937988+0.9865400+20.110000+0.1063866+1.0930120+11.937988+0.9866200+19.520000+0.1063067+1.0929536+11.937988+0.9866499+18.770000+0.1061930+1.0929636+11.906250+0.9867799+17.969999+0.1061177+1.0930825+11.922363+0.9869600+17.250000+0.1060724+1.0931458+11.937988+0.9871000+16.389999+0.1059565+1.0932465+11.969726+0.9872900+15.239999+0.1058630+1.0933487+11.922363+0.9875000+14.310000+0.1058943+1.0933359+11.937988+0.9874400+13.569999+0.1059057+1.0932378+11.954101+0.9873300+12.970000/c=+1+1#I/n=656/s=31/b=99/e=9.20/f=21.15/h=34/v=+3.918#G/a=Measurement#E/e#X/a=15543");
//        rawReadout1.setTransmisionDateTime(LocalDateTime.parse("2022-05-01 18:00:55", formatter));
//        rawReadout1.setRawImport(false);
//
//
//        List<RawReadout> rawReadoutList = new ArrayList<>();
//        rawReadoutList.add(rawReadout);
//        rawReadoutList.add(rawReadout1);
//
//        ReadoutParser readoutParser = new ReadoutParser();
//
//        //when
//        Readout r = new Readout();
//        List<Readout> readoutList = readoutParser.parseByFactor(rawReadoutList);
//
//        //then
//        r = readoutList.get(0);
//        assertEquals("22.04.30,14:00:40+08", r.getTransmitterParameterReading().getStartMeasureDataTime());
//        assertEquals("656", r.getTransmitterParameterReading().getSerialNumber());
//        assertEquals("31", r.getTransmitterParameterReading().getSignalLevel());
//        assertEquals("99", r.getTransmitterParameterReading().getBatteryCapacity());
//        assertEquals("35", r.getTransmitterParameterReading().getHumidity());
//        assertEquals("+3.918", r.getTransmitterParameterReading().getBatteryVoltage());
//        assertEquals("000000_00 A.txt", r.getTransmitterParameterReading().getFileName());
//        assertEquals("2022-04-30T04:00:59", r.getReadoutDataTime().toString());
//        assertEquals("0.1060674", r.getpD().toString());
//        assertEquals("-1.57", r.gettOb1().toString());
//
//        r = readoutList.get(16);
//        assertEquals("22.05.01,22:00:39+08", r.getTransmitterParameterReading().getStartMeasureDataTime());
//        assertEquals("656", r.getTransmitterParameterReading().getSerialNumber());
//        assertEquals("31", r.getTransmitterParameterReading().getSignalLevel());
//        assertEquals("99", r.getTransmitterParameterReading().getBatteryCapacity());
//        assertEquals("34", r.getTransmitterParameterReading().getHumidity());
//        assertEquals("+3.918", r.getTransmitterParameterReading().getBatteryVoltage());
//        assertEquals("000000_01 A.txt", r.getTransmitterParameterReading().getFileName());
//        assertEquals("2022-05-01T12:00:59", r.getReadoutDataTime().toString());
//        assertEquals("0.1062692", r.getpD().toString());
//        assertEquals("20.35", r.gettOb1().toString());
//
//        r = readoutList.get(17);
//        assertEquals("22.05.01,22:00:39+08", r.getTransmitterParameterReading().getStartMeasureDataTime());
//        assertEquals("656", r.getTransmitterParameterReading().getSerialNumber());
//        assertEquals("31", r.getTransmitterParameterReading().getSignalLevel());
//        assertEquals("99", r.getTransmitterParameterReading().getBatteryCapacity());
//        assertEquals("34", r.getTransmitterParameterReading().getHumidity());
//        assertEquals("+3.918", r.getTransmitterParameterReading().getBatteryVoltage());
//        assertEquals("000000_01 A.txt", r.getTransmitterParameterReading().getFileName());
//        assertEquals("2022-05-01T12:30:59", r.getReadoutDataTime().toString());
//        assertEquals("0.1062908", r.getpD().toString());
//        assertEquals("20.059999", r.gettOb1().toString());
//
//    }

//    @Test
//    public void givenLocalDateTime_whenUsingPlusSeconds_thenAddSeconds() {
////    given
//        long seconds = 704635259L;
//        LocalDateTime expectedDataTime = LocalDateTime.of(2022, Month.APRIL, 30, 12, 00, 59);
//        ReadoutParser readoutParser = new ReadoutParser();
//
////    when
//        LocalDateTime caclculateDataTime = readoutParser.calcDateTimeAddSeconds(seconds);
//
////    then
//        assertEquals(caclculateDataTime, expectedDataTime);
//    }


//    @Test
//    public void givenStringArrayAndReturnDeque() {
//        //given
//        ReadoutParser readoutParser = new ReadoutParser();
//
//        String[] strings = {"+0.1060674", "+1.0981121", "+11.835693", "+0.9920499", " +1.5700000",
//                "+0.1059414", "+1.0981221", "+11.851806", "+0.9921699", "+3.5699999"};
//
//        //when
//        Deque<SplitReadoutWithoutTransmiterParameter> readoutDeque = readoutParser.convertStringArrayToSplitReadout(strings);
//
//        //then
//
//        assertEquals(readoutDeque.size(),2);
//        assertEquals(readoutDeque.peek().getpD(),0.1060674);
//        assertEquals(readoutDeque.peek().getpBaro(),1.0981121);
//        assertEquals(readoutDeque.peek().gettBaro(),11.835693);
//        assertEquals(readoutDeque.peek().getP1(),0.9920499);
//        assertEquals(readoutDeque.peek().gettOb1(),1.5700000);
//    }

}