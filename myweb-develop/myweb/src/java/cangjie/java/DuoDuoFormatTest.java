package cangjie.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cangjie.java.util.IOUtils;

/**
 * 多多格式碼表生成工具
 * 
 * @author fsz
 * @time 2017年9月25日下午3:32:02
 */
public class DuoDuoFormatTest {

    private static String destFileDir = "src\\java\\cangjie\\mb\\duoduo\\mb\\";

    private static String mb2allInOne = Cj00AllInOneTest.mb2allInOne;
    private static String mb3allInOne = Cj00AllInOneTest.mb3allInOne;
    private static String mb5allInOne = Cj00AllInOneTest.mb5allInOne;
    private static String mb6allInOne = Cj00AllInOneTest.mb6allInOne;
    private static String karinaallInOne = Cj00AllInOneTest.nihonAllInOne; // 日語假名
    private static String zyfhsallInOne = Cj00AllInOneTest.zyfhsallInOne; // 注音符號
    private static String pinyinallInOne = Cj00AllInOneTest.pinyinallInOne; // 拼音
    private static String jyutpingAllInOne = Cj00AllInOneTest.jyutpingAllInOne; // 粵語拼音
    private static String sghmallInOne = Cj00AllInOneTest.sghmallInOne; // 四角號碼
    private static String cjyhallInOne = Cj00AllInOneTest.cjyhallInOne; // 雅虎奇摩
    private static String cjmsallInOne = Cj00AllInOneTest.cjmsallInOne; // 微軟倉頡
    private static String koreaallInOne = Cj00AllInOneTest.koreaAllInOne; // 朝鮮諺文
    private static String manjuallInOne = Cj00AllInOneTest.manjuAllInOne; // 圈點滿文
    private static String koxhanhAllInOne = Cj00AllInOneTest.koxhanhAllInOne; // 中古漢語

    public static void main(String[] args) throws Exception {
        // 生成碼表，倉頡全都加入詞組
        boolean cjwithPhrases = true;
        boolean otherImWithPhrases = false;
        Cj00AllInOneTest.generateAllInOnes(false, cjwithPhrases, true, otherImWithPhrases, false);
        
        List<String> mbs = new ArrayList<String>();
        mbs.add(mb2allInOne);
        mbs.add(mb3allInOne);
        mbs.add(mb5allInOne);
        mbs.add(mb6allInOne);
//        mbs.add(karinaallInOne);
//        mbs.add(zyfhsallInOne);
//        mbs.add(pinyinallInOne);
//        mbs.add(sghmallInOne);
//        mbs.add(cjyhallInOne);
//        mbs.add(cjmsallInOne);
//        mbs.add(koreaallInOne);
//        mbs.add(manjuallInOne);
//        mbs.add(jyutpingAllInOne);
//        mbs.add(koxhanhAllInOne);

        generateDuoDuoMb(mbs);

    }

    /**
     * 生成多多格式的碼表
     * 
     * @author fsz
     * @time 2017年9月25日下午3:10:02
     * @param mbs
     * @throws Exception
     */
    public static void generateDuoDuoMb(List<String> mbs) throws Exception {
        if (null != mbs) {
            for (String fileName : mbs) {
                String shortFileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                String dduoFileName = shortFileName.substring(0, shortFileName.lastIndexOf(".")) + "-duoduo."
                        + shortFileName.substring(shortFileName.lastIndexOf(".") + 1);
                List<String> lines = IOUtils.readLines(fileName, true);
                if (null != lines && !lines.isEmpty()) {
                    writeDuoDuoMb(destFileDir, dduoFileName, lines);
                }
            }
        }
    }

    /**
     * 写多多碼表
     * 
     * @time 2017年9月25日下午3:18:51
     * @param destFileDir2
     * @param dduoFileName
     * @param lines
     * @throws Exception
     */
    public static void writeDuoDuoMb(String destFileDir, String dduoFileName, List<String> lines) throws Exception {
        File dir = new File(destFileDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(destFileDir + dduoFileName);
        if (file.exists()) {
            file.delete();
        }

        System.out.println("開始多多碼表生成：" + destFileDir + dduoFileName);
        List<String> res = new ArrayList<String>();
        for (String line : lines) {
            if (line.contains(" ")) {
                String[] splits = line.split(" +");
                String cod = splits[0];
                String cha = splits[1];

                res.add(cha + "\t" + cod);
            } else {
                System.out.println("Mb碼表错誤：" + line);
            }
        }
        IOUtils.writeFile(destFileDir + dduoFileName, res);
    }
}
