package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cangjie.java.util.IOUtils;

public class TheClass {
    public static void main(String[] args) throws Exception {
        String destFile = "C:\\Users\\日月遞炤\\Desktop\\新建文件夹\\allInOne-cj6-qq.txt";
        toQQMbformat("C:\\Users\\日月遞炤\\Desktop\\新建文件夹\\allInOne-cj6-duoduo.txt", destFile);

    }

    private static void toQQMbformat(String file, String destFile) throws Exception {
        List<String> lines = IOUtils.readLines(file, true);
        System.out.println(lines.get(0));

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String line : lines) {
            if (line.contains(" ")) {
                String[] parts = line.split(" ");
                List<String> one = map.get(parts[1]);
                if (null == one) {
                    one = new ArrayList<String>();
                }
                one.add(parts[0]);
                map.put(parts[1], one);
            }
        }

        List<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys);
        List<String> res = new ArrayList<String>();
        int index = 0;
        for (String key : keys) {
            List<String> ones = map.get(key);
            index = 0;
            for (String val : ones) {
                res.add(key + "=" + (++index) + "," + val);
            }
        }

        System.out.println(res.size());
        IOUtils.writeFile(destFile, res);
    }

    private static void testFlayweight() {
        String str1 = "和諧";
        String str2 = "社會";
        String str3 = "和諧社會";
        String str4;
        str4 = str1 + str2;
        System.out.println(str3 == str4);
        str4 = (str1 + str2).intern();
        System.out.println(str3 == str4);
    }

    public static void amethod() {
        Long a = 1L;
        Long b = 2L;
        if (a > b) {
            System.out.println("Long a > b");
        } else {
            System.out.println("no >.");
        }
    }
}
