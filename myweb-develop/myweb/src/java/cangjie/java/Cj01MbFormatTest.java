package cangjie.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cangjie.java.util.IOUtils;

/**
 * 碼表的一些操作<br />
 * IOUtils中有碼表去重和排序
 * 
 * @author t
 */
public class Cj01MbFormatTest {

    private static String mbsBaseDir = Cj00AllInOneTest.mbsBaseDir;
    private static String destFile = mbsBaseDir + "rawmb\\result-code_cha.txt";

    private static String mb2allInOne = Cj00AllInOneTest.mb2allInOne;
    private static String mb3allInOne = Cj00AllInOneTest.mb3allInOne;
    private static String mb5allInOne = Cj00AllInOneTest.mb5allInOne;
    private static String mb6allInOne = Cj00AllInOneTest.mb6allInOne;
    private static String karinaallInOne = Cj00AllInOneTest.nihonAllInOne; // 日語假名
    private static String zyfhsallInOne = Cj00AllInOneTest.zyfhsallInOne; // 注音符號
    private static String pinyinallInOne = Cj00AllInOneTest.pinyinallInOne; // 拼音
    private static String sghmallInOne = Cj00AllInOneTest.sghmallInOne; // 四角號碼
    private static String cjyhallInOne = Cj00AllInOneTest.cjyhallInOne; // 雅虎奇摩
    private static String cjmsallInOne = Cj00AllInOneTest.cjmsallInOne; // 微軟倉頡
    private static String koreaallInOne = Cj00AllInOneTest.koreaAllInOne; // 朝鮮諺文

    // 倉頡三五六、雅虎、微軟，幾個的交集
    public static String cj356hyms_allInOne = mbsBaseDir + "cjmb" + File.separator + "intersection-cj356hyms.txt";

    public static void main(String[] args) throws Exception {
        getCjMbsIntersection();
    }

    /**
     * 求倉頡三五六、雅虎、微軟，幾個的交集
     */
    public static void getCjMbsIntersection() throws Exception {
        List<String> lines3 = IOUtils.readLines(mb3allInOne, true);
        List<String> lines5 = IOUtils.readLines(mb5allInOne, true);
        List<String> lines6 = IOUtils.readLines(mb6allInOne, true);
        List<String> linescjyh = IOUtils.readLines(cjyhallInOne, true);
        List<String> linescjms = IOUtils.readLines(cjmsallInOne, true);

        @SuppressWarnings("unchecked")
        Set<String> inter = MbCompare6Test.getIntersection(lines3, lines5, lines6, linescjyh, linescjms);
        IOUtils.writeFile(cj356hyms_allInOne, inter);
        IOUtils.orderCodeFile(cj356hyms_allInOne);

        int interSize = inter.size();
        int lines3size = lines3.size();
        int lines5size = lines5.size();
        int lines6size = lines6.size();
        int linescjyhsize = linescjyh.size();
        int linescjmssize = linescjms.size();
        lines3.removeAll(inter);
        lines5.removeAll(inter);
        lines6.removeAll(inter);
        linescjyh.removeAll(inter);
        linescjms.removeAll(inter);
        System.out.println(lines3size + "-" + interSize + "=" + (lines3size - interSize) + "=" + lines3.size());
        System.out.println(lines5size + "-" + interSize + "=" + (lines5size - interSize) + "=" + lines5.size());
        System.out.println(lines6size + "-" + interSize + "=" + (lines6size - interSize) + "=" + lines6.size());
        System.out
                .println(linescjyhsize + "-" + interSize + "=" + (linescjyhsize - interSize) + "=" + linescjyh.size());
        System.out
                .println(linescjmssize + "-" + interSize + "=" + (linescjmssize - interSize) + "=" + linescjms.size());
    }

    /**
     * 讀碼表：編碼在前，空一格，文字在後<br />
     * 如：ab 明
     */
    public static List<String> readCode_CharMb(String filename) {
        return IOUtils.readLines(filename, true);
    }

    /***
     * 讀碼表：編碼在前，不空格，後跟一串文字<br />
     * 如：ab明冐
     */
    public static List<String> readCodeChaChaMb(String filename) throws Exception {
        List<String> all = new ArrayList<String>(IOUtils.readLines(filename, true));

        List<String> res = new ArrayList<String>();
        String pattern = "[a-z]+";
        for (String line : all) {
            char[] chars = line.toCharArray();
            String code = "";
            List<String> chas = new ArrayList<String>();
            for (int i = 0; i < chars.length; i++) {
                Character ch = chars[i];
                if (ch.toString().matches(pattern)) {
                    code += ch.toString();
                } else {
                    if (ch < 100) {
                        System.out.println(ch);
                    }
                    chas.add(ch.toString());
                }
            }
            for (String str : chas) {
                res.add(code + " " + str);
            }
        }
        return res;
    }

    /***
     * 讀碼表：文字在前，空一格，編碼在後<br />
     * 如：明 ab
     */
    public static List<String> readCha_CodeMb(String filename) throws Exception {
        List<String> all = new ArrayList<String>(IOUtils.readLines(filename, true));

        List<String> res = new ArrayList<String>();
        for (String line : all) {
            if (line.contains(" ")) {
                String[] splits = line.split(" +");
                String cha = splits[0];
                String cod = splits[1];

                res.add(cod + " " + cha);
            } else {
                System.out.println("readCha_CodeMb碼表错誤：" + line);
            }
        }
        return res;
    }

    /**
     * 讀碼表：引號編碼等於引號文字<br />
     * 如："a"="日"
     * 
     * @author t
     * @time 2017-2-24下午9:16:56
     */
    public static List<String> read_quoteCodeEQquoteCharMb(String filename) throws Exception {
        List<String> all = new ArrayList<String>(IOUtils.readLines(filename, true));

        List<String> res = new ArrayList<String>();
        String pattern = "^\".*\"=\".*\"$";
        int index = 0;
        for (String line : all) {
            index++;
            if (line.matches(pattern)) {
                String[] spliteq = line.split("=");
                String cod = spliteq[0].substring(1, spliteq[0].length() - 1);
                String cha = spliteq[1].substring(1, spliteq[1].length() - 1);

                res.add(cod + " " + cha);
            } else {
                System.out.println("read_quoteCodeEQquoteCharMb碼表错誤：" + index + " " + line);
            }
        }
        return res;
    }

}
