package pl.trollsystems.mtms.service;


import pl.trollsystems.mtms.model.SplitReadout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadoutParser {
    public static void main(String[] args) {
//        https://mkyong.com/java/java-how-to-split-a-string/
//         String REGEX_MAIN = "#F|#T|#M|#I|#G|#E|#X";
        String REGEX_MAIN = "#";
        String s = "#F/a=0#T/s=703454459/p=22.04.16,22:00:41+08/m=703454401#M/b=+0.1103834+1.1050978+11.413574+0.9947100+8.9399995+0.1102827+1.1053321+11.429443+0.9950699+9.0900001+0.1102806+1.1053328+11.397705+0.9950600+9.1800003+0.1103652+1.1054149+11.413574+0.9950600+9.1099996+0.1102231+1.1054673+11.429443+0.9952499+9.0200004+0.1102379+1.1055756+11.413574+0.9953299+8.9300003+0.1102356+1.1056935+11.413574+0.9954699+8.7200002+0.1102290+1.1058555+11.413574+0.9956300+8.4799995+0.1102998+1.1059556+11.413574+0.9956600+8.0500001+0.1102587+1.1060949+11.413574+0.9958499+7.8899998+0.1102256+1.1062601+11.397705+0.9960299+7.8600001+0.1102090+1.1064486+11.429443+0.9962499+6.9800000+0.1101046+1.1066167+11.429443+0.9965100+6.1999998+0.1102691+1.1068092+11.397705+0.9965499+5.3800001+0.1103923+1.1068673+11.413574+0.9964900+4.6799998+0.1103362+1.1068792+11.413574+0.9965499+4.2500000/c=+1+1#I/n=656/s=31/b=99/e=9.20/f=21.15/h=26/v=+3.918#G/a=Measurement#E/e#X/a=15973";

//        Pattern pattern = Pattern.compile(REGEX_MAIN);
//        String[] result = pattern.split(s);
        String[] result = s.split("(?=#F)|(?=#T)|(?=#M)|(?=#I)|(?=#G)|(?=#E)|(?=#X)");
//        for (String str : result) {
//            System.out.println(str);
//        }
//        System.out.println("---------------------------------");
        parseData(result);
    }

    private static void parseData(String[] result) {

        List<String[]> listResult = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            String[] resultParse = result[i].split("(?=/s=)|(?=/p=)|(?=/m=)|(?=/b=)|(?=/c=)|(?=/n=)|(?=/e=)|(?=/f=)|(?=/v=)|(?=/a=)|(?=/h=)");
            listResult.add(resultParse);
        }
//    private SplitReadout splitReadout;
        for (String[] s : listResult) {
            System.out.println(Arrays.toString(s));
            storeReadout(s);
        }
    }

    private  void storeReadout(String[] s) {
        switch (s[0]) {
            case "#T":
                splitReadout.set_Ts(s[1]);
                splitReadout.set_Tp(s[2]);
                splitReadout.set_Tm(s[3]);
                break;
            case "#M":
                break;
            case "#I":
                break;
            case "#G":
                break;
            case "#X":
                break;
            default:
        }
        System.out.println(splitReadout);
    }
}
