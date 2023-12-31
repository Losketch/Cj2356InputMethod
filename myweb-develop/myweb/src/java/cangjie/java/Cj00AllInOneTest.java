package cangjie.java;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cangjie.java.util.IOUtils;
import cangjie.java.util.PhraseUtils;
import wugniu.WugniuRawMbTest;
import wugniu.WugniuRuiAnMbTest;

public class Cj00AllInOneTest {

    public static String mbsBaseDir = "src\\java\\cangjie\\mb\\";
    // 取自倉頡平臺2012所帶碼表
    public static String mb26000 = mbsBaseDir + "cjmb" + File.separator
            + "cj2-6763.txt";
    // 倉頡三代引用GitHub上的 Arthurmcarthur/Cangjie3-Plus 碼表
    public static String mb330000 = mbsBaseDir + "cjmb" + File.separator
            + "cj3-Arthur-30000.txt";
    public static String mb380000 = mbsBaseDir + "cjmb" + File.separator
            + "cj3-Arthur-80000.txt";
    public static String mb3cangjie3sup = mbsBaseDir + "cjmb" + File.separator
            + "cj3-Arthur_supplement.txt";
    public static String mb3more = mbsBaseDir + "cjmb" + File.separator
            + "cj3-more.txt";
    // 倉頡五代引用 Jackchows/Cangjie5 碼表，99碼表上參考03五代製成
    public static String mb5cangjie5 = mbsBaseDir + "cjmb" + File.separator
            + "cj5-Jackchows-Cangjie5.txt";
    public static String mb5cangjie5sup = mbsBaseDir + "cjmb" + File.separator
            + "cj5-Jackchows-Cangjie5_supplement.txt";
    public static String mb5more = mbsBaseDir + "cjmb" + File.separator
            + "cj5-more.txt";

    // 取用倉頡輸入法羣共享中的cj6-70000碼表等，並整合了雪齋團隊整理的碼表
    public static String mb6newDict = mbsBaseDir + "cjmb" + File.separator
            + "cj6-dict.txt";
    public static String mb6more = mbsBaseDir + "cjmb" + File.separator
            + "cj6-more.txt";
    public static String mb6morePua = mbsBaseDir + "cjmb" + File.separator
            + "cj6-pua.txt";
    // 自製碼表
    public static String mb6compat1000 = mbsBaseDir + "cjmb" + File.separator
            + "cj6-compat1000.txt";
    public static String mb6simParts400 = mbsBaseDir + "cjmb" + File.separator
            + "cj6-simPart400.txt";
    public static String mb6japkore200 = mbsBaseDir + "cjmb" + File.separator
            + "cj6-japkorea.txt";
    public static String mb6unif7473 = mbsBaseDir + "cjmb" + File.separator
            + "cj6-unicodef7473.txt";
    public static String mb6morePhrase = mbsBaseDir + "cjmb" + File.separator
            + "cj6-morePhrase.txt";
    // 各代所有碼表合一
    public static String mb2allInOne = mbsBaseDir + "allInOne" + File.separator
            + "allInOne-cj2.txt";
    public static String mb3allInOne = mbsBaseDir + "allInOne" + File.separator
            + "allInOne-cj3.txt";
    public static String mb5allInOne = mbsBaseDir + "allInOne" + File.separator
            + "allInOne-cj5.txt";
    public static String mb6allInOne = mbsBaseDir + "allInOne" + File.separator
            + "allInOne-cj6.txt";
    // 詞組
    public static String phraseOriginFile = mbsBaseDir + "phrases.txt";
    public static String mb3phrase = mbsBaseDir + "cjmb" + File.separator
            + "cj3-phrase.txt";
    public static String mb5phrase = mbsBaseDir + "cjmb" + File.separator
            + "cj5-phrase.txt";
    public static String mb6phrase = mbsBaseDir + "cjmb" + File.separator
            + "cj6-phrase.txt";

    // 四角號碼，參照911查詢網底四角號碼查詢而製作的碼表
    public static String mbsghm27000 = mbsBaseDir + "sghm-27000.txt";
    public static String mbsghm27000no5 = mbsBaseDir + "sghm-27000-5.txt";
    public static String sghmphrase = mbsBaseDir + "sghm-phrase.txt";
    public static String sghmallInOne = mbsBaseDir + "allInOne" + File.separator
            + "allInOne-sghm.txt";

    // 日文，自製碼表，並取維基上《日語常用漢字一覧表》中的字和詞，編碼後加入碼表中
    public static String mbnippon200 = mbsBaseDir + "karina-kana200.txt";
    public static String mbnipponKanjiMore = mbsBaseDir
            + "karina-moreKanji.txt";
    public static String mbnipponMoreSymbol = mbsBaseDir
            + "karina-moreSymbol.txt";
    public static String nihonAllInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-karina.txt";

    // 韓文，自製碼表，主要由榕樹葉編碼，韓文漢字基本取自Mdict字典《标准韩国语词典.txt》《韩文汉字词典.txt》和百度文庫的《韩语常用汉字对照》
    public static String mbkoreaOther = mbsBaseDir + "korea-other.txt";
    public static String koreaMoreSymbol = mbsBaseDir + "korea-moreSymbol.txt";
    public static String koreaHanja = mbsBaseDir + "korea-hanja.txt";
    public static String koreaAllInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-korea.txt";

    // 曾版湘潭話拼音
    public static String sionTanTseng3000 = mbsBaseDir
            + "sionTanTseng-3000.txt";
    // 上海吳語（老派）
    public static String wugniuLopha30000 = WugniuRawMbTest.resultFile;
    // 甌越瑞安吳語
    public static String wugniuRuiAn11400 = WugniuRuiAnMbTest.mbBaseDir 
            + "瓯越瑞安auyue_lodzen-order.txt";
    // 注音符號，自製碼表，只能打符號，不能打漢字
    public static String zyfhs5000 = mbsBaseDir + "zyfh-5000.txt";
    // 粵語拼音，整合兩個碼表GitHub上rime-aca的粵拼⁺正寫字碼表、
    // MDict字典粤语发声字典081217.mdx簡化字碼表，對簡化字更友好。
    // 聲調用英文字母v底個數表示
    public static String jyutping20000 = mbsBaseDir + "jyutping-allInOne.txt";
    // 普語拼音，用網上找的碼表，聲調改用英文字母m底個數表示
    public static String pinyin26000 = mbsBaseDir + "pinyin-26000.txt";
    public static String pinyinIpa = mbsBaseDir + "pinyin-ipa.txt";
    // 兩個是伊卂Ejsoon推薦的碼表。
    public static String cjyh80000 = mbsBaseDir + "cjmb" + File.separator
            + "cjyahoo-80000.txt"; // 雅虎奇摩
    public static String cjms59000 = mbsBaseDir + "cjmb" + File.separator
            + "cjms-59000.txt"; // 微軟倉頡
    // 對應MacOSX10.5Cangjie-Arthurmcarthur20200719.txt
    public static String cjmacOsx10520000 = mbsBaseDir + "cjmb" + File.separator
            + "cj5-MacOSX10.5.txt"; // MacX10.5
    // 合一
    public static String sionTanTsengAllInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-sionTanTseng.txt"; // 曾版湘潭話拼音
    public static String wugniuLophaAllInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-wugniuLopha.txt"; // 上海吳語（老派）
    public static String wugniuRuiAnAllInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-wugniuRuiAn.txt"; // 甌越瑞安吳語
    public static String zyfhsallInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-zyfh.txt"; // 注音符號
    public static String pinyinallInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-pinyin.txt"; // 普語拼音
    public static String cjyhallInOne = mbsBaseDir + "allInOne" + File.separator
            + "allInOne-cjyahoo.txt"; // 雅虎奇摩
    public static String cjmsallInOne = mbsBaseDir + "allInOne" + File.separator
            + "allInOne-cjms.txt"; // 微軟倉頡
    public static String cjmacosx105allInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-cjmacosx105.txt"; // MacX10.5
    // 粵語拼音，整合兩個碼表github上rime-aca的粵拼⁺正寫字碼表、
    // mdict字典粤语发声字典081217.mdx簡化字碼表，對簡化字更友好。
    public static String jyutpingAllInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-jyutping.txt";

    // 滿文，自製碼表，參考網上下載的《滿文滿語學習教程完整版.pdf》内容。
    public static String manjuMoreOther = mbsBaseDir + "manju-moreOther.txt";
    public static String manjuAllInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-manju.txt";

    // 國際音標
    public static String phonetic200 = mbsBaseDir + "phonetic-allInOne.txt";
    public static String phoneticAllInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-phonetic.txt";

    // 中古漢語拼音
    public static String koxhanh30000 = mbsBaseDir + "koxhanh-30000.txt";
    public static String koxhanhAllInOne = mbsBaseDir + "allInOne"
            + File.separator + "allInOne-koxhanh.txt";

    public static void main(String[] args) throws Exception {
        // 電腦輸入法碼表
        generateAllInOnes(false, true, true, false, false);
    }

    /**
     * 生成整合碼表
     * 
     * @param allWithHeaders
     *            是否加入文件頭
     * @param cjwithPhrases
     *            是否加入詞組
     * @param cj6withPhrases6
     *            六代是否加入詞組
     * @param otherImWithPhrases
     *            其他輸入法是否加入詞組
     * @param withPua
     *            是否加入私用區
     * @throws Exception
     */
    public static void generateAllInOnes(boolean allWithHeaders,
            boolean cjwithPhrases, boolean cj6withPhrases6,
            boolean otherImWithPhrases, boolean withPua) throws Exception {
        boolean otherWithPhrases = otherImWithPhrases; // 其他輸入法是否加入詞組
        boolean withPhrases = cjwithPhrases; // 是否加入詞組
        boolean withPhrases6 = cj6withPhrases6; // 六代是否加入詞組

        boolean withHeaders = allWithHeaders; // 是否加入文件頭

        // 整理词组
        if (withPhrases || withPhrases6) {
            readPhraseFile();
        }

        // 曾版湘潭話拼音
        String[] sionTanTseng = new String[] { sionTanTseng3000 };
        genAllInOne("曾版湘潭話", sionTanTseng, sionTanTsengAllInOne, withHeaders);

        // 上海吳語（老派）
        String[] wugniuLopha = new String[] { wugniuLopha30000 };
        genAllInOne("上海吳語", wugniuLopha, wugniuLophaAllInOne, withHeaders);

        // 甌越瑞安吳語
        String[] wugniuRuiAn = new String[] { wugniuRuiAn11400 };
        genAllInOne("甌越瑞安", wugniuRuiAn, wugniuRuiAnAllInOne, withHeaders);

        // 中古漢語
        String[] mbkoxhanh = new String[] { koxhanh30000 };
        genAllInOne("中古漢語", mbkoxhanh, koxhanhAllInOne, withHeaders);

        // 國際音標
        String[] mbipa = new String[] { phonetic200 };
        genAllInOne("國際音標", mbipa, phoneticAllInOne, withHeaders);

        // 滿文
        String[] mbmanju = new String[] { manjuMoreOther };
        genAllInOne("圈點滿文", mbmanju, manjuAllInOne, withHeaders);

        // 注音符號
        String[] mbzyfh = new String[] { zyfhs5000 };
        genAllInOne("注音符號", mbzyfh, zyfhsallInOne, withHeaders);

        // 粵語拼音
        String[] mbjyutping = new String[] { jyutping20000 };
        genAllInOne("粵語拼音", mbjyutping, jyutpingAllInOne, withHeaders);

        // 普語拼音
        String[] mbpinyin = new String[] { pinyinIpa, pinyin26000 };
        genAllInOne("普語拼音", mbpinyin, pinyinallInOne, withHeaders);

        // 日文
        String[] mbjapan = new String[] { mbnippon200, mbnipponMoreSymbol,
                mbnipponKanjiMore };
        genAllInOne("日文假名", mbjapan, nihonAllInOne, withHeaders);

        // 韓文
        String[] mbkorea = new String[] { mbkoreaOther, koreaMoreSymbol,
                koreaHanja };
        genAllInOne("朝鮮諺文", mbkorea, koreaAllInOne, withHeaders);

        // 四角號碼
        if (otherWithPhrases) {
            List<String> mbfilesghm = new ArrayList<String>();
            mbfilesghm.add(mbsghm27000no5);
            genRawCjPhrases(phraseOriginFile, sghmphrase, mbfilesghm);
        }
        // 生成allInOne文件
        String[] mbsghm = new String[] { mbsghm27000, sghmphrase };
        if (!otherWithPhrases) {
            mbsghm[mbsghm.length - 1] = null;
        }
        genAllInOne("四角號碼", mbsghm, sghmallInOne, withHeaders);

        // 雅虎奇摩
        String[] mbyahoo = new String[] { cjyh80000 };
        genAllInOne("雅虎奇摩", mbyahoo, cjyhallInOne, withHeaders);

        // 微軟倉頡
        String[] mbcjms = new String[] { cjms59000 };
        genAllInOne("微軟倉頡", mbcjms, cjmsallInOne, withHeaders);

        // MacX10.5
        String[] mbcjmacos = new String[] { cjmacOsx10520000 };
        genAllInOne("MacX10.5", mbcjmacos, cjmacosx105allInOne, withHeaders);

        // 詞組編碼6
        if (withPhrases6) {
            List<String> mbfiles6 = new ArrayList<String>();
            mbfiles6.add(mb6newDict);
            mbfiles6.add(mb6more);
            genRawCjPhrases(phraseOriginFile, mb6phrase, mbfiles6);
        }
        // 生成allInOne文件6
        String[] mbs6 = new String[] { mb6newDict, mb6more, mb6simParts400,
                mb6japkore200, mb6compat1000, mb6morePua, mb6morePhrase,
                mb6phrase };
        if (!withPhrases6) {
            mbs6[mbs6.length - 1] = null;
            mbs6[mbs6.length - 2] = null;
        }
        if (!withPua) {
            mbs6[mbs6.length - 3] = null;
        }
        genAllInOne("倉頡六代", mbs6, mb6allInOne, withHeaders);

        // 詞組編碼5
        if (withPhrases) {
            List<String> mbfiles5 = new ArrayList<String>();
            mbfiles5.add(mb5cangjie5);
            mbfiles5.add(mb5more);
            genRawCjPhrases(phraseOriginFile, mb5phrase, mbfiles5);
        }
        // 生成allInOne文件5
        String[] mbs5 = new String[] { mb5cangjie5, mb5cangjie5sup, mb5more,
                mb5phrase };
        if (!withPhrases) {
            mbs5[mbs5.length - 1] = null;
        }
        genAllInOne("倉頡五代", mbs5, mb5allInOne, withHeaders);

        // 詞組編碼3
        if (withPhrases) {
            List<String> mbfiles3 = new ArrayList<String>();
            mbfiles3.add(mb380000);
            genRawCjPhrases(phraseOriginFile, mb3phrase, mbfiles3);
        }
        // 生成allInOne文件3
        String[] mbs3 = new String[] { mb330000, mb380000, mb3cangjie3sup,
                mb3more, mb3phrase };
        if (!withPhrases) {
            mbs3[mbs3.length - 1] = null;
        }
        genAllInOne("倉頡三代", mbs3, mb3allInOne, withHeaders);

        // 生成allInOne文件2
        String[] mbs2 = new String[] { mb26000 };
        genAllInOne("倉頡二代", mbs2, mb2allInOne, withHeaders);
    }

    /**
     * 词組原始表，去重、排序
     */
    public static void readPhraseFile() throws Exception {
        IOUtils.uniqueCodeFile(phraseOriginFile);
        IOUtils.orderCodeFile(phraseOriginFile);
    }

    /**
     * 生成詞組碼表<br />
     * srcPhraseFile 詞組源文件<br />
     * destPhrasesFile 詞組編碼後的目標文件<br />
     * mbfile 常用版字集碼表
     */
    private static void genRawCjPhrases(String srcPhraseFile,
            String destPhrasesFile, List<String> mbfile) throws Exception {
        System.out.println("生成：" + destPhrasesFile);
        // 常用版所有字符
        Set<String> cj6Set = new LinkedHashSet<String>(
                IOUtils.readLines(mbfile.get(0), true));
        if (mbfile.size() > 1) {
            for (int index = 1; index < mbfile.size(); index++) {
                cj6Set.addAll(IOUtils.readLines(mbfile.get(index), true));
            }
        }
        // 做成映射，字符為鍵，編碼列表爲值
        Map<String, List<String>> charCodesMap = PhraseUtils
                .getMbSetMapByChar(cj6Set);
        // 所有詞組
        List<String> allphrases = new ArrayList<String>(
                IOUtils.readLines(srcPhraseFile, true));
        // 六代詞組
        List<String> resPhrases = new ArrayList<String>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()) + "开始。");

        int count = 0;
        for (String phr : allphrases) {
            // 词組的編碼列表
            List<String> phrcods = PhraseUtils.getPhraseCode(phr, charCodesMap);
            if (null != phrcods && !phrcods.isEmpty()) {
                for (String cod : phrcods) {
                    resPhrases.add(cod + " " + phr);
                    count++;
                }
            } else {
                System.out.println("没有编碼：" + phr);
            }
            if (count >= 10000) {
                System.out.println(
                        sdf.format(new Date()) + ": " + resPhrases.size());
                IOUtils.writeFile(destPhrasesFile, resPhrases);
                count = 0;
            }
        }
        System.out.println(sdf.format(new Date()) + "结束：" + resPhrases.size());
        IOUtils.writeFile(destPhrasesFile, resPhrases);

        // IOUtils.orderCodeFile(destPhrasesFile);
    }

    /**
     * 生成allInOne文件
     * 
     * @param name
     *            目標碼表名字
     * @param mbs
     *            要合併的碼表
     * @param 生成的目標文件
     * @author t
     * @time 2016-12-15下午11:36:15
     */
    private static void genAllInOne(String name, String[] mbs, String destFile,
            boolean withHeaders) throws Exception {
        System.out.println(destFile);
        Set<String> codeLines = new LinkedHashSet<String>();

        List<String> destFileHeads = new ArrayList<String>();
        destFileHeads.add("encode=UTF-8");
        destFileHeads.add("name=" + name);
        destFileHeads.add("key=abcdefghijklmnopqrstuvwxyz");
        destFileHeads.add("len=6");
        destFileHeads.add("wildcard=*");
        destFileHeads.add("commit=1 6 0");
        destFileHeads.add("");
        destFileHeads.add("[DATA]");
    if (withHeaders) {
        codeLines.addAll(destFileHeads);
    }

    // 在这里添加上述提到的代码，创建父目录
    // 获取目标文件的父目录
    File destFileObj = new File(destFile);
    File destParentDir = destFileObj.getParentFile();

    // 如果父目录不存在，则创建它
    if (!destParentDir.exists()) {
        destParentDir.mkdirs();
    }
    
    for (int i = 0; i < mbs.length; i++) {
            if (null == mbs[i]) {
                continue;
            }
            List<String> temp = IOUtils.readLines(mbs[i], true);
            for (String code : temp) {
                if (!codeLines.contains(code)) {
                    codeLines.add(code);
                }
            }
        }
        System.out.println("所有行數：" + codeLines.size());
        IOUtils.writeFile(destFile, new ArrayList<String>(codeLines));
    }

}
