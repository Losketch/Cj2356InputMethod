package cangjie.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import cangjie.java.util.IOUtils;
import unicode.UnicodeConvertUtil;
import unicode.UnicodeHanziUtil;

/**
 * 三五代倉頡碼表對比
 */
public class MbCompare35Test {

    public static String mbsBaseDir = "src\\java\\cangjie\\mb\\";
    public static String mb36000 = mbsBaseDir + "cjmb" + File.separator + "oldmb" + File.separator + "cj3-6763.txt";
    public static String mb310000 = mbsBaseDir + "cjmb" + File.separator + "oldmb" + File.separator + "cj3-13053.txt";
    public static String mb320000 = mbsBaseDir + "cjmb" + File.separator + "oldmb" + File.separator + "cj3-20902.txt";
    public static String mb370000 = mbsBaseDir + "cjmb" + File.separator + "oldmb" + File.separator + "cj3-70000.txt";

    public static String mb58000 = mbsBaseDir + "cjmb" + File.separator + "oldmb" + File.separator + "cj5-8300.txt";
    public static String mb510000 = mbsBaseDir + "cjmb" + File.separator + "oldmb" + File.separator + "cj5-13053.txt";
    public static String mb520000 = mbsBaseDir + "cjmb" + File.separator + "oldmb" + File.separator + "cj5-20902.txt";
    public static String mb570000 = mbsBaseDir + "cjmb" + File.separator + "oldmb" + File.separator + "cj5-70000.txt";

    public static void main(String[] args) throws Exception {
        System.out.println("compareCangjie3: ");
        compareCangjie3();

        System.out.println("compareCangjie5: ");
        compareCangjie5();
    }

    public static void compareCangjie5() throws Exception {
        Set<String> list1 = new LinkedHashSet<String>(IOUtils.readLines(Cj00AllInOneTest.mb5cangjie5, true));
        list1.addAll(IOUtils.readLines(Cj00AllInOneTest.mb5cangjie5sup, true));
        list1.addAll(IOUtils.readLines(Cj00AllInOneTest.mb5more, true));

        Set<String> list2 = new LinkedHashSet<String>();
        list2.addAll(new LinkedHashSet<String>(IOUtils.readLines(mb58000, true)));
        list2.addAll(new LinkedHashSet<String>(IOUtils.readLines(mb510000, true)));
        list2.addAll(new LinkedHashSet<String>(IOUtils.readLines(mb520000, true)));
        list2.addAll(new LinkedHashSet<String>(IOUtils.readLines(mb570000, true)));

        List<String> list3 = compareGetDiff(list1, list2);
        for (String str : list3) {
            System.out.println(str);
        }
        System.out.println(list3.size());
        
        getNotIncludedCharsAF(list1);
    }

    public static void compareCangjie3() throws Exception {
        Set<String> list1 = new LinkedHashSet<String>(IOUtils.readLines(Cj00AllInOneTest.mb330000, true));
        list1.addAll(IOUtils.readLines(Cj00AllInOneTest.mb380000, true));
        list1.addAll(IOUtils.readLines(Cj00AllInOneTest.mb3more, true));

        Set<String> list2 = new LinkedHashSet<String>();
        list2.addAll(new LinkedHashSet<String>(IOUtils.readLines(mb36000, true)));
        list2.addAll(new LinkedHashSet<String>(IOUtils.readLines(mb310000, true)));
        list2.addAll(new LinkedHashSet<String>(IOUtils.readLines(mb320000, true)));
        list2.addAll(new LinkedHashSet<String>(IOUtils.readLines(mb370000, true)));

        List<String> list3 = compareGetDiff(list1, list2);
        for (String str : list3) {
            System.out.println(str);
        }
        System.out.println("old cj3 more: " + list3.size());
        
        getNotIncludedCharsAF(list1);
    }

    /**
     * 各個區漢字是否都有了
     * 
     * @param list1
     */
    public static void getNotIncludedCharsAF(Set<String> list1) {
        Set<String> chars = new LinkedHashSet<String>();
        for (String line : list1) {
            if (line.contains(" ")) {
                String[] splits = line.split(" +");
                String cha = splits[1];
                chars.add(cha);
            }
        }
        Set<String> set = UnicodeConvertUtil.getStringSet(UnicodeHanziUtil.baseRange);
        set.addAll(UnicodeConvertUtil.getStringSet(UnicodeHanziUtil.base2Range));
        set.addAll(UnicodeConvertUtil.getStringSet(UnicodeHanziUtil.AextRange));
        set.addAll(UnicodeConvertUtil.getStringSet(UnicodeHanziUtil.BextRange));
        set.addAll(UnicodeConvertUtil.getStringSet(UnicodeHanziUtil.CextRange));
        set.addAll(UnicodeConvertUtil.getStringSet(UnicodeHanziUtil.DextRange));
        // set.addAll(UnicodeConvertUtil.getStringSet(UnicodeHanziUtil.EextRange));
        //  set.addAll(UnicodeConvertUtil.getStringSet(UnicodeHanziUtil.FextRange));
        set.removeAll(chars);
        System.out.println("getNotIncludedCharsAF: " + set.size() + ": " + set);
    }

    /**
     * 求碼表的交集
     */
    public static Set<String> getIntersection(Collection<String>... sets) {
        Set<String> inters = new LinkedHashSet<String>();
        if (null != sets) {
            List<Set<String>> sets2 = new ArrayList<Set<String>>();
            for (Collection<String> set : sets) {
                sets2.add(new HashSet<String>(set));
            }
            for (Collection<String> set : sets2) {
                for (String code : set) {
                    if (!inters.contains(code) && isInAllSet(code, sets2)) {
                        inters.add(code);
                    }
                }
            }
        }
        return inters;
    }

    /** 一個编码是否在所有集合中都含有 */
    private static boolean isInAllSet(String code, List<Set<String>> sets) {
        if (null != sets && null != code && code.length() > 0) {
            for (Set<String> set : sets) {
                if (!set.contains(code)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 比较碼表的不同，newSet中有，而set1中沒有的行
     * 
     * @author t
     * @time 2017-1-3上午12:02:52
     */
    public static List<String> compareGetDiff(Collection<String> set1, Collection<String> newSet) throws Exception {
        List<String> diff = new ArrayList<String>();

        for (String n : newSet) {
            if (!set1.contains(n)) {
                diff.add(n);
            }
        }
        return diff;
    }

    /**
     * 比较碼表的不同：在碼表newSet中有，而在set1中沒有的字符
     */
    public static List<String> compareGetDiffChars(Collection<String> set1, Collection<String> newSet) {
        List<String> diff = new ArrayList<String>();

        Set<String> oldChars = new HashSet<String>();
        for (String line : set1) {
            if (line.contains(" ")) {
                String[] splits = line.split(" +");
                String cha = splits[1];
                oldChars.add(cha);
            }
        }

        for (String n : newSet) {
            if (n.contains(" ")) {
                String[] splits = n.split(" +");
                String cha = splits[1];
                if (!oldChars.contains(cha)) {
                    diff.add(n);
                }
            }
        }
        return diff;
    }
}
