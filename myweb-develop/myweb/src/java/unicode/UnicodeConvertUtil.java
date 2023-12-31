package unicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 統一碼轉換工具
 * 
 * 
 * @author fszhouzz@qq.com
 * @time 2018年10月18日 下午11:55:45
 */
public class UnicodeConvertUtil {

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("18b0", 16));

        String str = "aaaa圍，取𬺰45";
        List<Integer> list = getUnicodeListFromStr(str);
        System.out.println(Arrays.toString(list.toArray()));

        List<String> str16 = getUnicodeStr4ListFromStr(str);
        System.out.println(Arrays.toString(str16.toArray()));
    }

    /** 按統一碼編號範圍，取到對应的字符集合 */
    public static Set<String> getStringSet(int[] range) {
        return getStringSet(range[0], range[1]);
    }

    /** 按統一碼編號起止，取到對应的字符集合 */
    public static Set<String> getStringSet(int start, int end) {
        Set<String> set = new LinkedHashSet<String>();
        for (int i = start; i <= end; i++) {
            String res = getStringByUnicode(i);
            if (!set.contains(res)) {
                set.add(res);
            }
        }
        return set;
    }

    /** 按統一碼編號，取到對应的字符 */
    public static String getStringByUnicode(int unicode) {
        return new String(Character.toChars(unicode));
    }

    /** 按統一碼16進制字符串，取到對应的字符 */
    public static String getStringByUnicodeStr(String unicode) {
        String pattern = "[0-9a-fA-F]+";
        if (!unicode.matches(pattern)) {
            return null;
        }
        try {
            return getStringByUnicode(Integer.parseInt(unicode, 16));
        } catch (Exception e) {
        }
        return null;
    }

    /** 字符串轉統一碼16進制字符串列表 */
    public static List<String> getUnicodeStr4ListFromStr(String str) {
        List<Integer> ints = getUnicodeListFromStr(str);
        if (null == ints || ints.isEmpty()) {
            return null;
        }
        List<String> list = new ArrayList<String>();
        for (Integer i : ints) {
            String hex = Integer.toHexString(i);
            while (hex.length() < 4) {
                hex = "0" + hex;
            }
            list.add(hex.toUpperCase());
        }
        return list;
    }

    /** 字符串轉統一碼列表 */
    public static List<Integer> getUnicodeListFromStr(String str) {
        if (null == str || str.length() == 0) {
            return null;
        }
        String bitemp = getBinaryStrFromStr(str, "UTF-8");
        return getUnicodeListFromBinaryStr(bitemp);
    }

    public static List<Integer> getUnicodeListFromBinaryStr(String bitemp) {
        if (null == bitemp) {
            return null;
        }
        List<Integer> codes = new ArrayList<Integer>();
        while (true) {
            Pattern p = Pattern.compile("^([1]+).*");
            Matcher m = p.matcher(bitemp);
            if (m.find()) {
                int len = m.group(1).length();
                String part = bitemp.substring(0, len * 8);
                bitemp = bitemp.substring(len * 8);
                StringBuilder bits = new StringBuilder();
                bits.append(part.substring(len + 1, 8));
                for (int i = 1; i < len; i++) {
                    int begin = 8 * i + 2;
                    int end = (i + 1) * 8;
                    bits.append(part.substring(begin, end));
                }
                codes.add(getIntFromBinaryString(bits.toString()));
            } else {
                String part = bitemp.substring(0, 8);
                bitemp = bitemp.substring(8);
                codes.add(getIntFromBinaryString(part));
            }
            if (bitemp.length() <= 0) {
                break;
            }
        }
        return codes;
    }

    public static String getStrFromBinaryStr(String bitemp) {
        List<Integer> codes = UnicodeConvertUtil
                .getUnicodeListFromBinaryStr(bitemp);
        String res = "";
        for (Integer one : codes) {
            res += UnicodeConvertUtil.getStringByUnicode(one);
        }
        return res;
    }

    public static String getBinaryStrFromStr(String str, String charSet) {
        if (null == str || str.length() == 0) {
            return null;
        }
        byte[] bys = null;
        try {
            bys = str.getBytes(charSet);
        } catch (Exception e) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte by : bys) {
            sb.append(getBinaryStrFromInt(by, 8));
        }
        return sb.toString();
    }

    /**
     * 整數轉化成二進制串
     * 
     * @param num
     *            整數
     * @param bitCnt
     *            位數
     * @return
     */
    public static String getBinaryStrFromInt(int num, int bitCnt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitCnt; i++) {
            sb.append(num & 1);
            num = num >>> 1;
        }
        return sb.reverse().toString();
    }

    /**
     * 二進制串轉化成數字
     */
    public static Integer getIntFromBinaryString(String biStr) {
        if (null == biStr) {
            return null;
        }
        return Integer.parseInt(biStr, 2);
    }
}
