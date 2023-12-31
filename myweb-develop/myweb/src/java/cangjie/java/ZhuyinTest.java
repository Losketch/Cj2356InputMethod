package cangjie.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import cangjie.java.util.IOUtils;

/**
 * 注音符號碼表生成
 * 
 * @author t
 * @time 2016-12-3上午12:40:06
 */
public class ZhuyinTest {

    private static String mbBaseDir = "src\\java\\cangjie\\mb\\";

    private static String destFile = "zyfh-allInOne.txt";

    public static void main(String[] args) throws Exception {
        List<String> finalResults = new ArrayList<String>();
        finalResults.add("encode=UTF-8");
        finalResults.add("name=注音符號");
        finalResults.add("key=abcdefghijklmnopqrstuvwxyz");
        finalResults.add("len=6");
        finalResults.add("wildcard=*");
        finalResults.add("commit=1 6 0");
        finalResults.add("");
        finalResults.add("[DATA]");

        List<String> shengmu = new ArrayList<String>();
        List<String> yunmu = new ArrayList<String>();
        shengmu.add("b ㄅ");
        shengmu.add("p ㄆ");
        shengmu.add("m ㄇ");
        shengmu.add("f ㄈ");
        shengmu.add("d ㄉ");
        shengmu.add("t ㄊ");
        shengmu.add("n ㄋ");
        shengmu.add("l ㄌ");
        shengmu.add("g ㄍ");
        shengmu.add("k ㄎ");
        shengmu.add("h ㄏ");
        shengmu.add("j ㄐ");
        shengmu.add("q ㄑ");
        shengmu.add("x ㄒ");
        shengmu.add("zh ㄓ");
        shengmu.add("ch ㄔ");
        shengmu.add("sh ㄕ");
        shengmu.add("r ㄖ");
        shengmu.add("z ㄗ");
        shengmu.add("c ㄘ");
        shengmu.add("s ㄙ");

        // 34個加幾個
        yunmu.add("a ㄚ");
        yunmu.add("o ㄛ");
        yunmu.add("e ㄜ");
        yunmu.add("i ㄧ");
        yunmu.add("u ㄨ");
        yunmu.add("v ㄩ");
        yunmu.add("yu ㄩ"); // 加
        yunmu.add("ai ㄞ");
        yunmu.add("ei ㄟ");
        yunmu.add("ui ㄨㄟ");
        yunmu.add("ao ㄠ");
        yunmu.add("ou ㄡ");
        yunmu.add("iu ㄧㄡ");
        yunmu.add("iou ㄧㄡ"); // 加
        yunmu.add("ie ㄧㄝ");
        yunmu.add("ve ㄩㄝ");
        yunmu.add("yue ㄩㄝ"); // 加
        yunmu.add("er ㄦ");
        yunmu.add("an ㄢ");
        yunmu.add("en ㄣ");
        yunmu.add("in ㄧㄣ");
        yunmu.add("un ㄨㄣ");
        yunmu.add("vn ㄩㄣ");
        yunmu.add("yun ㄩㄣ"); // 加
        yunmu.add("ang ㄤ");
        yunmu.add("eng ㄥ");
        yunmu.add("ing ㄧㄥ");
        yunmu.add("ong ㄨㄥ");
        yunmu.add("ung ㄨㄥ"); // 加
        yunmu.add("ia ㄧㄚ");
        yunmu.add("iao ㄧㄠ");
        yunmu.add("ian ㄧㄢ");
        yunmu.add("iang ㄧㄤ");
        yunmu.add("iong ㄩㄥ");
        yunmu.add("iung ㄩㄥ"); // 加
        yunmu.add("yung ㄩㄥ"); // 加
        yunmu.add("vng ㄩㄥ"); // 加
        yunmu.add("ua ㄨㄚ");
        yunmu.add("uo ㄨㄛ");
        yunmu.add("uai ㄨㄞ");
        yunmu.add("uang ㄨㄤ");
        yunmu.add("uan ㄨㄢ");

        print(shengmu);
        System.out.println();
        print(yunmu);

        List<String> tempResults = new ArrayList<String>();
        for (String s : shengmu) {
            String[] ss = s.split(" ");
            for (String y : yunmu) {
                String[] yy = y.split(" ");
                tempResults.add(ss[0] + yy[0] + " " + ss[1] + yy[1]);
            }
        }
        // 韻母的处理
        tempResults.addAll(yunmu);
        // 〇聲母大寫22個
        tempResults.add("yi ㄧ");
        tempResults.add("wu ㄨ");
        tempResults.add("yu ㄩ");
        tempResults.add("wei ㄨㄟ");
        tempResults.add("you ㄧㄡ");
        tempResults.add("ye ㄧㄝ");
        tempResults.add("yue ㄩㄝ");
        tempResults.add("yin ㄧㄣ");
        tempResults.add("wen ㄨㄣ");
        tempResults.add("weng ㄨㄥ");
        tempResults.add("yun ㄩㄣ");
        tempResults.add("ying ㄧㄥ");
        tempResults.add("ya ㄧㄚ");
        tempResults.add("yao ㄧㄠ");
        tempResults.add("yan ㄧㄢ");
        tempResults.add("yang ㄧㄤ");
        tempResults.add("yong ㄩㄥ");
        tempResults.add("yung ㄩㄥ");
        tempResults.add("wa ㄨㄚ");
        tempResults.add("wo ㄨㄛ");
        tempResults.add("wai ㄨㄞ");
        tempResults.add("wang ㄨㄤ");
        tempResults.add("wan ㄨㄢ");
        // 幾個特殊的
        tempResults.add("zhi ㄓ");
        tempResults.add("chi ㄔ");
        tempResults.add("shi ㄕ");
        tempResults.add("ri ㄖ");
        tempResults.add("zi ㄗ");
        tempResults.add("ci ㄘ");
        tempResults.add("si ㄙ");
        tempResults.add("nue ㄋㄩㄝ");
        tempResults.add("lue ㄌㄩㄝ");
        tempResults.add("jue ㄐㄩㄝ");
        tempResults.add("que ㄑㄩㄝ");
        tempResults.add("xue ㄒㄩㄝ");

        // 都加上聲調
        Collections.sort(tempResults);
        for (String s : tempResults) {
            finalResults.add(s);
            String[] ss = s.split(" ");
            finalResults.add(ss[0] + "q " + ss[1] + "ˉ");
            finalResults.add(ss[0] + "qq " + ss[1] + "ˊ");
            finalResults.add(ss[0] + "qqq " + ss[1] + "ˇ");
            finalResults.add(ss[0] + "qqqq " + ss[1] + "ˋ");
            finalResults.add(ss[0] + "qqqqq " + ss[1] + "˙");
        }

        finalResults.addAll(shengmu);
        finalResults.add("q ˉ");
        finalResults.add("qq ˊ");
        finalResults.add("qqq ˇ");
        finalResults.add("qqqq ˋ");
        finalResults.add("qqqqq ˙");
        print(finalResults);

        IOUtils.writeFile(mbBaseDir + destFile, finalResults);
    }

    /** 打印 */
    private static void print(Collection<String> c) {
        for (String str : c) {
            System.out.println(str);
        }
    }
}
