package cangjie.java.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//詞組的編碼工具
public class PhraseUtils {
    private static String mbBaseDir = "src\\java\\cangjie\\mb\\";
    // 倉頡六所有字符 //
    private static String cj6file = "sghm-20000.txt";

    // 詞組中可以有的符號，但不編碼
    private static String marks = "、，˙·；（）";

    public static void main(String[] args) {
        Set<String> cj6Set = new LinkedHashSet<String>(
                IOUtils.readLines(mbBaseDir + cj6file, true));
        Map<String, List<String>> charCodesMap = PhraseUtils
                .getMbSetMapByChar(cj6Set);

        String phrases[] = { "亦爲", "約翰˙克利斯多夫", "泡泡", "暗暗", "一心一意", "暑熱", "而已" };
        for (String phrase : phrases) {
            System.out.println(phrase + "："
                    + getCjcodesByPhrase(phrase, charCodesMap));
            System.out.println(phrase + "："
                    + getPhraseCode(phrase, charCodesMap));
        }
    }

    // 按碼表得到詞組的編碼
    //
    // 參數 mapByChar 單字的碼表做成的映射，字符為鍵，編碼列表爲值，getMbSetMapByChar()可以生成
    // 參數 phrase 詞組，如暑熱
    public static List<String> getPhraseCode(String phrase,
            Map<String, List<String>> mapByChar) {
        List<String> codes = getCjcodesByPhrase(phrase, mapByChar);
        if (!isCodesCorrect(codes, phrase)) {
            return null;
        }
        return getPhraseCodeByCjCodes(codes);
    }

    /**
     * 驗證是否正確
     * 
     * @author t
     * @time 2016-12-16上午12:05:51
     */
    private static boolean isCodesCorrect(List<String> codes, String phrase) {
        String tempPhrase = new String(phrase);
        for (int i = tempPhrase.length() - 1; i >= 0; i--) {
            Character c = tempPhrase.charAt(i);
            if (marks.contains(c.toString())) {
                tempPhrase = tempPhrase.replaceAll(c.toString(), "");
                i = tempPhrase.length(); // 不減1，因为要--
            } else {
                // 如果某字沒有編碼，返回false
                boolean coded = false;
                for (String code : codes) {
                    if (code.indexOf(c.toString()) != -1) {
                        coded = true;
                    }
                }
                if (!coded) {
                    return false;
                }
            }
        }
        // 如果得到的編碼個數比詞組長度都短，説明使用的編碼集不足，返回false
        return codes.size() >= tempPhrase.length();
    }

    // 把單字的碼表做成映射，字符為鍵，編碼列表爲值
    // 參數 set 單字的碼表，如：[a 日, a 曰, aa 昌, aa 昍, aaa 晶, aaa 晿,...
    public static Map<String, List<String>> getMbSetMapByChar(Set<String> set) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String codes : set) {
            if (codes.contains(" ")) {
                String[] keyVal = codes.split(" +");
                String cod = keyVal[0];
                String val = keyVal[1];
                if (!map.keySet().contains(val)) {
                    map.put(val, new ArrayList<String>());
                }
                map.get(val).add(cod);
            } else {
                System.out.println("碼表不對，如：" + codes);
            }
        }
        return map;
    }

    // 按字符的編碼，得到他們所組成的詞組編碼
    //
    // 參數 codes 詞組中每個字可能的編碼，卽getCjcodesByPhrase()返回的格式
    // 返回值 可能的詞組編碼，如：[aagif, aagkf]
    private static List<String> getPhraseCodeByCjCodes(List<String> codes) {
        List<ArrayList<String>> splitCodes = splitCodeParts(codes);
        return generateTempPhraseCode(splitCodes);
    }

    // 按一個词組，得到各個漢字的編碼，漢字不去重
    //
    // 參數 mapByChar 把單字的碼表做成映射，字符為鍵，編碼列表爲值
    // 參數 phrase 詞組，如暑熱
    // 返回值 返回如：[aqa 暑, aqia 暑, gif 熱, gkf 熱]
    private static List<String> getCjcodesByPhrase(String phrase,
            Map<String, List<String>> mapByChar) {
        List<String> codes = new ArrayList<String>();
        for (int i = 0; i < phrase.length(); i++) {
            Character c = phrase.charAt(i);
            List<String> charCodes = mapByChar.get(c.toString());
            // 不能是符號
            if (!marks.contains(c.toString()) && null != charCodes
                    && !charCodes.isEmpty()) {
                for (String code : charCodes) {
                    codes.add(code + " " + c.toString());
                }
            }
        }
        return codes;
    }

    // 如果字有多个编码，会生成列表的多个元素
    private static List<ArrayList<String>> splitCodeParts(List<String> codes) {
        List<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        List<String> charList = new ArrayList<String>();
        List<ArrayList<String>> codeLists = new ArrayList<ArrayList<String>>();
        int resIndex = 0;
        for (int n = 0; n < codes.size(); n++) {
            String s = codes.get(n);
            String[] keyVal = s.split(" +");
            String cod = keyVal[0];
            String val = keyVal[1];

            // 與前一字一樣，但是新編碼
            if (n != 0 && charList.get(resIndex - 1).equals(val)
                    && !codeLists.get(resIndex - 1).contains(cod)) {
                codeLists.get(resIndex - 1).add(cod);
            } else {
                charList.add(val);
                ArrayList<String> codeList = new ArrayList<String>();
                codeList.add(cod);
                codeLists.add(codeList);

                resIndex++;
            }
        }
        lists.add(new ArrayList<String>());
        for (ArrayList<String> codeList : codeLists) {
            for (int index = 0; index < codeList.size(); index++) {
                String code = codeList.get(index);

                if (index == 0) {
                    for (ArrayList<String> list : lists) {
                        list.add(code);
                    }
                } else { // 加倍
                    List<ArrayList<String>> tempLists = new ArrayList<ArrayList<String>>();
                    for (ArrayList<String> list : lists) {
                        tempLists.add(new ArrayList<String>(list.subList(0,
                                list.size() - 1)));
                    }
                    for (ArrayList<String> list : tempLists) {
                        list.add(code);
                    }
                    lists.addAll(tempLists);
                }
            }
        }
        return lists;
    }

    /**
     * 按各字編码生成詞組編碼
     * 
     * @author fszhouzz@qq.com
     * @time 2017年12月16日 下午3:32:52
     * @param list
     * @return
     */
    private static List<String> generateTempPhraseCode(
            List<ArrayList<String>> list) {
        // 不用set就可能重複編碼同一个词
        Set<String> codes = new LinkedHashSet<String>();
        String tempcode = null;
        for (ArrayList<String> one : list) {
            tempcode = PhraseCodeConcatenateUtil.generateTempPhraseCodeOneAll(one);
            if (!codes.contains(tempcode)) {
                codes.add(tempcode);
            }
        }
        codes.add(tempcode);
        return new ArrayList<String>(codes);
    }
}