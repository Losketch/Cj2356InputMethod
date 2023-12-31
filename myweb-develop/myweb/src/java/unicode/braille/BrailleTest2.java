package unicode.braille;

import java.util.ArrayList;
import java.util.List;

public class BrailleTest2 {

    static List<String> shengmu = new ArrayList<String>();
    static List<String> yunmu = new ArrayList<String>();

    public static void main(String[] args) {
        // 聲母、韻母
        for (String sm : shengmu) {
            String[] sms = sm.split(" +");
            for (String ym : yunmu) {
                String[] yms = ym.split(" +");
                System.out.println(sms[0] + yms[0] + " " + sms[1] + yms[1]);
            }
        }
    }

    static {
        shengmu.add("12000000 b");
        shengmu.add("12340000 p");
        shengmu.add("10340000 m");
        shengmu.add("12040000 f");
        shengmu.add("10045000 d");
        shengmu.add("02345000 t");
        shengmu.add("10345000 n");
        shengmu.add("12300000 l");
        shengmu.add("12045000 g(j)");
        shengmu.add("10300000 k(q)");
        shengmu.add("12005000 h(x)");
        shengmu.add("00340000 zh");
        shengmu.add("12345000 ch");
        shengmu.add("10005600 sh");
        shengmu.add("02045000 r");
        shengmu.add("10305600 z");
        shengmu.add("10040000 c");
        shengmu.add("02340000 s");
        yunmu.add("00305000 a");
        yunmu.add("02000600 e(o)");
        yunmu.add("02040000 i");
        yunmu.add("10300600 u");
        yunmu.add("00340600 ü");
        yunmu.add("12305000 er");
        yunmu.add("02040600 ai");
        yunmu.add("02305000 ao");
        yunmu.add("02340600 ei");
        yunmu.add("12305600 ou");
        yunmu.add("12040600 ia");
        yunmu.add("00345000 iao");
        yunmu.add("10005000 ie");
        yunmu.add("12005600 iu");
        yunmu.add("12345600 ua");
        yunmu.add("10345600 uai");
        yunmu.add("02045600 ui");
        yunmu.add("10305000 uo");
        yunmu.add("02345600 üe");
        yunmu.add("12300600 an");
        yunmu.add("02300600 ang");
        yunmu.add("00305600 en");
        yunmu.add("00345600 eng");
        yunmu.add("10040600 ian");
        yunmu.add("10340600 iang");
        yunmu.add("12000600 in");
        yunmu.add("10000600 ing");
        yunmu.add("12045600 uan");
        yunmu.add("02305600 uang");
        yunmu.add("02005000 un");
        yunmu.add("02005600 ong");
        yunmu.add("12340600 üan");
        yunmu.add("00045600 ün");
        yunmu.add("10045600 iong");
    }
}
