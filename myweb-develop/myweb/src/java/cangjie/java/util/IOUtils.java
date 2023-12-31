package cangjie.java.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class IOUtils {

    // 注意\\t之前還有一個字符，没有顯示出来，不要看漏了
    public static String blankPatn = "[﻿\\t\\n\\x0B\\f\\r]";

    private static String mbsBaseDir = "src\\java\\cangjie\\mb\\";

    public static void main(String[] args) throws Exception {
        // String line = "﻿昌明";
        // System.out.println(line);
        // line = line.replaceAll(blankPatn, "");
        // System.out.println(line);

        orderCodeFile(mbsBaseDir + "cj6-more.txt");
    }

    /**
     * 碼表去重，重寫文件
     */
    public static Set<String> uniqueCodeFile(String filename) throws Exception {
        System.out.println("去重：" + filename);
        List<String> allphrases = new ArrayList<String>(IOUtils.readLines(filename, true));

        Set<String> duplicated = new LinkedHashSet<String>();
        Set<String> uniques = new LinkedHashSet<String>();
        for (String ph : allphrases) {
            if (!uniques.contains(ph)) {
                uniques.add(ph);
                continue;
            }
            if (!duplicated.contains(ph)) {
                duplicated.add(ph);
            }
        }
        IOUtils.writeFile(filename, uniques);
        return duplicated;
    }

    /**
     * 碼表排序，先按編碼先后，再按長度
     */
    public static void orderCodeFile(String filename) throws Exception {
        doOrderCodeFile(filename, false);
    }

    /**
     * 碼表排序，先按編碼先后，再按長度。長度相同時，保持原來的顺序。
     */
    public static void orderCodeFileRaw(String filename) throws Exception {
        doOrderCodeFile(filename, true);
    }
    
    private static void doOrderCodeFile(String filename, final boolean remainOrder) throws Exception {
        System.out.println("排序：" + filename);
        List<String> allphrases = new ArrayList<String>(IOUtils.readLines(filename, true));

        Collections.sort(allphrases, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                if (str1.contains(" ") && str2.contains(" ")) {
                    String[] keyVal1 = str1.split(" +");
                    String[] keyVal2 = str2.split(" +");
                    // 編碼同，長度又不相等
                    if (keyVal1[0].equals(keyVal2[0]) && str1.length() != str2.length()) {
                        // 不等則短的在前
                        return str1.length() - str2.length();
                    } else {
                        return (remainOrder ? 0 : str1.compareTo(str2));
                    }
                } else {
                    // 如果不是碼表，看長度
                    // 長度相等
                    if (str1.length() == str2.length()) {
                        return (remainOrder ? 0 : str1.compareTo(str2));
                    } else {
                        // 不等則短的在前
                        return str1.length() - str2.length();
                    }
                }
            }
        });
        IOUtils.writeFile(filename, allphrases);
    }

    /**
     * 讀碼表文件<br />
     * noBlank=true, 會去首尾格，中間也只留單個空格
     */
    public static List<String> readLines(String fileName, Boolean noBlank) {
        try {
            if (null == noBlank) {
                noBlank = false;
            }
            InputStream in = new FileInputStream(fileName);
            return readLines(in, noBlank);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> readLines(InputStream in, Boolean noBlank) {
        if (null == noBlank) {
            noBlank = false;
        }
        List<String> result = new ArrayList<String>();
        InputStreamReader isr = null;
        BufferedReader br = null;
        String str = null;
        try {
            isr = new InputStreamReader(in, "UTF-8");
            br = new BufferedReader(isr);
            while ((str = br.readLine()) != null) {
                if (!"".equals(str)) {
                    String line = str.trim(); // 去首尾
                    if (noBlank) {
                        line = line.replaceAll("( )\\1+", "$1"); // 中间一个空
                        line = line.replaceAll(blankPatn, ""); // 去空白字符
                    }
                    if (!line.startsWith("#")) {
                        result.add(line);
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            try {
                br.close();
            } catch (IOException e) {
            }
            try {
                in.close();
            } catch (Exception e) {
            }
        }
        return result;
    }
    
    /**
     * 原樣讀取文件
     * 
     * @author fszhouzz@qq.com
     * @time 2020年10月11日 下午7:23:26
     * @param fileName
     * @return
     */
    public static List<String> readLinesRaw(String fileName) {
        try {
            InputStream in = new FileInputStream(fileName);
            return readLinesRaw(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> readLinesRaw(InputStream in) {
        List<String> result = new ArrayList<String>();
        InputStreamReader isr = null;
        BufferedReader br = null;
        String str = null;
        try {
            isr = new InputStreamReader(in, "UTF-8");
            br = new BufferedReader(isr);
            while ((str = br.readLine()) != null) {
                result.add(str);
            }
        } catch (Exception e) {
        } finally {
            try {
                br.close();
            } catch (IOException e) {
            }
            try {
                in.close();
            } catch (Exception e) {
            }
        }
        return result;
    }

    /**
     * 寫碼表到文件<br />
     * 如果目標文件已經存在，會被重建
     */
    public static void writeFile(String fileName, Collection<String> results) throws Exception {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        if (file.exists() == false) {
            file.createNewFile();
        }
        OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        BufferedWriter br = new BufferedWriter(osr);
        for (String str : results) {
            br.write(str);
            br.newLine();// 换行
        }
        br.flush();
        br.close();
    }

    /**
     * 文件複製
     * 
     * @author t
     * @time 2016-12-18上午11:01:06
     */
    public static void copyFile(String src, String dest) throws Exception {
        InputStream is = IOUtils.class.getResourceAsStream(src);
        File destFile = new File(dest);
        if (destFile.exists()) {
            destFile.delete();
        }
        destFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(destFile);
        byte[] buffer = new byte[1024];
        int byteCount = 0;
        while ((byteCount = is.read(buffer)) != -1) {
            fos.write(buffer, 0, byteCount);
        }
        fos.flush();
        is.close();
        fos.close();
    }
}
