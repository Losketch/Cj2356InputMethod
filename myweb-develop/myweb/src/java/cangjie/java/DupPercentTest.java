package cangjie.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cangjie.java.util.IOUtils;

// 計算重碼率
public class DupPercentTest {

    public static void main(String[] args) {

        // dupPercent(new String[] { //Cj00AllInOneTest.sghmallInOne,
        // Cj00AllInOneTest.mb68000,
        // Cj00AllInOneTest.mb610000,
        // Cj00AllInOneTest.mb620000,
        // Cj00AllInOneTest.mb670000
        // });

//        List<String> trueMb36000 = getNoXCodeTable(Cj00AllInOneTest.mb36000,
//                Cj00AllInOneTest.mb370000);
//        List<String> trueMb56000 = getNoXCodeTable(Cj00AllInOneTest.mb58000,
//                Cj00AllInOneTest.mb570000);
//        System.out.println("統計三代簡化字部分編碼：");
//        doCountDupPercent(trueMb36000);
//        System.out.println("統計五代簡化字部分編碼：");
//        doCountDupPercent(trueMb56000);
    }

    /** 從mb370000中取出mb36000中所有文字的編碼 */
    private static List<String> getNoXCodeTable(String mb36000, String mb370000) {
        List<String> line6000 = IOUtils.readLines(mb36000, true);
        Set<String> charSet = new HashSet<String>();
        for (String line : line6000) {
            if (line.contains(" ")) {
                String[] keyVal = line.split(" +");
                String val = keyVal[1];

                if (!charSet.contains(val)) {
                    charSet.add(val);
                }
            }
        }

        List<String> result = new ArrayList<String>();
        List<String> line70000 = IOUtils.readLines(mb370000, true);
        for (String line : line70000) {
            if (line.contains(" ")) {
                String[] keyVal = line.split(" +");
                String cod = keyVal[0];
                String val = keyVal[1];

                if (charSet.contains(val) && !cod.startsWith("z")) {
                    result.add(line);
                }
            }
        }
        return result;
    }

    private static void dupPercent(String[] files) {
        for (String file : files) {
            List<String> lines = IOUtils.readLines(file, true);
            System.out.println("文件名：" + file);
            doCountDupPercent(lines);
        }
    }

    private static void doCountDupPercent(List<String> lines) {
        Map<String, Set<String>> codVals = new HashMap<String, Set<String>>();
        for (String line : lines) {
            if (line.contains(" ")) {
                String[] keyVal = line.split(" +");
                String cod = keyVal[0];
                String val = keyVal[1];

                Set<String> vals = codVals.get(cod);
                if (null == vals) {
                    vals = new HashSet<String>();
                }
                vals.add(val);
                codVals.put(cod, vals);
            }
        }
        System.out.println("編碼總數：" + codVals.keySet().size());
        int cntVals = 0; // 總字數
        // <碼長，<編碼，字集>>
        Map<Integer, Map<String, Set<String>>> longCodeCnts = new HashMap<Integer, Map<String, Set<String>>>();
        // <重碼個數，<編碼，字集>>
        Map<Integer, Map<String, Set<String>>> cntCodeCnts = new HashMap<Integer, Map<String, Set<String>>>();
        // 有重複的編碼
        Set<String> dupCods = new HashSet<String>();
        for (String c : codVals.keySet()) {
            cntVals += codVals.get(c).size();
            if (codVals.get(c).size() > 1) {
                dupCods.add(c);
            }
            // 碼長<編碼，字集>
            Map<String, Set<String>> longCodeCnt = longCodeCnts.get(c.length());
            if (null == longCodeCnt) {
                longCodeCnt = new HashMap<String, Set<String>>();
            }
            longCodeCnt.put(c, codVals.get(c));
            longCodeCnts.put(c.length(), longCodeCnt);
            // 重碼個數，<編碼，字集>
            Map<String, Set<String>> cntCodeCnt = cntCodeCnts.get(codVals
                    .get(c).size());
            if (null == cntCodeCnt) {
                cntCodeCnt = new HashMap<String, Set<String>>();
            }
            cntCodeCnt.put(c, codVals.get(c));
            cntCodeCnts.put(codVals.get(c).size(), cntCodeCnt);
        }
        System.out.println("總字數：" + cntVals);
        System.out.println("有重複的編碼個數：" + dupCods.size());
        System.out.println("其中按碼長：");
        for (Integer lon : longCodeCnts.keySet()) {
            Map<String, Set<String>> map = longCodeCnts.get(lon);
            int cnttemp = 0;
            for (String c : map.keySet()) {
                cnttemp += map.get(c).size();
            }
            System.out.println("碼長為" + lon + "的有" + map.keySet().size() + "個編碼"
                    + (map.keySet().size() <= 20 ? map.keySet() : "") + "，共"
                    + cnttemp + "字");
        }
        System.out.println("按重碼數：");
        List<Integer> cnts = new ArrayList<Integer>();
        cnts.addAll(cntCodeCnts.keySet());
        Collections.sort(cnts);
        for (Integer cnt : cnts) {
            Map<String, Set<String>> map = cntCodeCnts.get(cnt);
            int cnttemp = 0;
            for (String c : map.keySet()) {
                cnttemp += map.get(c).size();
            }
            System.out.println("編碼字數為" + cnt + "的有" + map.keySet().size()
                    + "個編碼" + (map.keySet().size() <= 20 ? map.keySet() : "")
                    + "，共" + cnttemp + "字");
        }
        System.out.println();
    }

}
