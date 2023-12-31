package cangjie.java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cangjie.java.util.IOUtils;

/**
 * http://sijiao.911cha.com/00000.html<br />
 * 911查詢網上的四角號碼和拼音下載
 * 
 * @author t
 * @time 2017-2-12下午2:05:14
 */
@Deprecated
public class FourCornerPinyin911Test {

    private static String htmlsBaseDir = "src\\java\\cangjie\\html\\";

    public static void main(String[] args) throws Exception {
        // downLoadAllPages();

        // System.out.println(getCodeCharPysByCode("00000"));

        resolve4goCharsAndPyChars();
    }

    /**
     * 生成四角碼表和拼音碼表，並寫入文件
     * 
     * @author t
     * @time 2017-2-12下午5:29:49
     */
    public static void resolve4goCharsAndPyChars() throws Exception {
        List<String> allCodeCharPys = new ArrayList<String>();
        for (int i = 0; i < 100000; i++) {
            List<String> codeCharPys = getCodeCharPysByCode(formatNum(i, 5));
            if (null != codeCharPys && !codeCharPys.isEmpty()) {
                allCodeCharPys.addAll(codeCharPys);
                System.out.println(i + "完成。");
            }
        }
        System.out.println();

        Set<String> codechars = new HashSet<String>();
        Set<String> pinychars = new HashSet<String>();
        for (String ccp : allCodeCharPys) {
            String[] parts = ccp.split("_");
            if (parts.length != 3) {
                System.out.println("沒有拼音的: " + ccp);
                // System.exit(1);
            }
            String acc = parts[0] + " " + parts[1];
            if (!codechars.contains(acc)) {
                codechars.add(acc);
            }
            if (parts.length == 3) {
                String transpy = transPinyin(parts[2]);
                if (null != transpy) {
                    String apc = transpy + " " + parts[1];
                    if (!pinychars.contains(apc)) {
                        pinychars.add(apc);
                    }
                }
            }
        }
        System.out.println("拼音總數：" + pinychars.size());
        System.out.println("四角號碼總數：" + codechars.size());

        // 寫文件
        IOUtils.writeFile(htmlsBaseDir + "codechars.txt",
                new ArrayList<String>(codechars));
        IOUtils.writeFile(htmlsBaseDir + "pinychars.txt",
                new ArrayList<String>(pinychars));
    }

    /**
     * 接收zhǔ格式的拼音，換成zhu3<br />
     */
    private static String transPinyin(String py) {
        if (null == py || "".equals(py.trim())) {
            return null;
        }
        String result = null;
        String targets = "āáǎàōóǒòêēéěèīíǐìūúǔùǖǘǚǜü";
        String a1 = null;
        for (int i = 0; i < py.length(); i++) {
            Character ch = py.charAt(i);
            if (targets.contains(ch.toString())) {
                a1 = ch.toString();
                break;
            }
        }
        if (null == a1) {
            result = py + "5";
        } else {
            result = doTansPinyin(py, a1);
        }
        return result;
    }

    // āáǎàōóǒòêēéěèīíǐìūúǔùǖǘǚǜüˉˊˇˋ˙
    private static String doTansPinyin(String py, String a1) {
        Map<String, String> a1a = new HashMap<String, String>();
        a1a.put("ā", "a1");
        a1a.put("á", "a2");
        a1a.put("ǎ", "a3");
        a1a.put("à", "a4");
        // ōóǒò
        a1a.put("ō", "o1");
        a1a.put("ó", "o2");
        a1a.put("ǒ", "o3");
        a1a.put("ò", "o4");
        // ēéěè
        a1a.put("ē", "e1");
        a1a.put("é", "e2");
        a1a.put("ě", "e3");
        a1a.put("è", "e4");
        // īíǐì
        a1a.put("ī", "i1");
        a1a.put("í", "i2");
        a1a.put("ǐ", "i3");
        a1a.put("ì", "i4");
        // ūúǔù
        a1a.put("ū", "u1");
        a1a.put("ú", "u2");
        a1a.put("ǔ", "u3");
        a1a.put("ù", "u4");
        // ǖǘǚǜ
        a1a.put("ǖ", "v1");
        a1a.put("ǘ", "v2");
        a1a.put("ǚ", "v3");
        a1a.put("ǜ", "v4");
        a1a.put("ü", "v5");

        String anum = a1a.get(a1);
        String result = py.replace(a1, anum.substring(0, 1));
        return result + anum.substring(1);
    }

    /** 數字num長度固定cnt位 */
    private static String formatNum(Integer num, int cnt) {
        String aaa = num.toString();
        int add = cnt - aaa.length();
        for (int i = 1; i <= add; i++) {
            aaa = "0" + aaa;
        }
        return aaa;
    }

    /** 得到“四角碼_漢字_拼音”的列表 */
    public static List<String> getCodeCharPysByCode(String input)
            throws Exception {
        String fileName = input + ".html";
        File file = new File(htmlsBaseDir + fileName);

        String line;
        try {
            line = readAppointedLineNumber(file, 48);
            if (null != line
                    && !line.contains("<a href=\"http://zidian.911cha.com/")) {
                System.out.println(input);
                System.exit(1);
            }
        } catch (Exception e) {
            return null;
        }

        String start = "_blank\">";
        String end = "</a>";
        // <span>zhǔ</span>主
        // <span></span>䜃<span class="ziqu">A</span>
        List<String> parts = new ArrayList<String>();
        String tempLine = line;
        do {
            tempLine = tempLine.substring(tempLine.indexOf(start)
                    + start.length());

            parts.add(tempLine.substring(0, tempLine.indexOf(end)));
            tempLine = tempLine.substring(tempLine.indexOf(end) + end.length());
        } while (tempLine.indexOf(start) != -1);

        List<String> codeCharPys = new ArrayList<String>();
        for (String part : parts) {
            String codeCharPy = input + "_";
            part = part.replace("<span>", "");
            String strs[] = part.split("</span>");
            codeCharPy += ((strs[1].indexOf("<span") == -1) ? strs[1] : strs[1]
                    .substring(0, strs[1].indexOf("<span")));
            codeCharPy += "_" + strs[0];

            codeCharPys.add(codeCharPy);
        }
        return codeCharPys;
    }

    // 读取文件指定行。
    private static String readAppointedLineNumber(File sourceFile,
            int lineNumber) throws Exception {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
            if ((lines - lineNumber) == 0) {
                break;
            }
        }
        reader.close();
        in.close();
        return s;
    }

    public static void downLoadAllPages() {
        for (int i = 0; i < 10; i++) {
            new Thread(new DownloadThread(i * 10000, (i + 1) * 10000)).start();
        }
    }
    
    static class DownloadThread implements Runnable {

        String prefix = "http://sijiao.911cha.com/";
        String suffix = ".html";
        
        int start;
        int end;
        
        DownloadThread(int s, int e) {
            this.start = s;
            this.end = e;
        }
        
        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                downLoadOnePage(prefix + formatNum(i, 5) + suffix);
            }
        }
        
    }

    /**
     * 下載一個頁面
     */
    private static void downLoadOnePage(String url) {
        InputStream inStream = null;
        OutputStream fs = null;
        File destFile = null;
        try {
            destFile = new File(htmlsBaseDir
                    + url.substring(url.lastIndexOf("/")));
            if (destFile.exists()) {
                if (destFile.length() == 0) {
                    destFile.delete();
                } else {
                    return;
                }
            }
            destFile.createNewFile();

            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj
                    .openConnection();
            conn.setConnectTimeout(10 * 1000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept-Language", "zh-CN");
            conn.setRequestProperty("Charset", "UTF-8");
            // 一定要設置接收類型: Accept=""都可以，但不能没有，否則找不到文件
            conn.setRequestProperty(
                    "Accept",
                    "*/*, image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                            + "application/x-shockwave-flash, application/xaml+xml, "
                            + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                            + "application/x-ms-application, application/vnd.ms-excel, "
                            + "application/vnd.ms-powerpoint, application/msword");

            inStream = conn.getInputStream();
            fs = new FileOutputStream(destFile);

            byte[] buffer = new byte[5120];
            int byteread = 0;
            while ((byteread = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteread);
            }

            try {
                Thread.sleep((long) (Math.random() * 5));
            } catch (InterruptedException e1) {
            }
        } catch (Exception e) {
            try {
                if (null != destFile && destFile.exists()) {
                    destFile.delete();
                }
            } catch (Exception e1) {
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
            System.out.println(sdf.format(new Date()) + " " + e.getMessage());
            if (null != e.getCause()) {
                System.out.println(e.getCause().getMessage());
            }
            System.out.println();
            if (!url.equals(e.getMessage())) {
                try {
                    if (null != fs) {
                        fs.flush();
                        fs.close();
                    }
                } catch (Exception e1) {
                }
                try {
                    if (null != inStream) {
                        inStream.close();
                    }
                } catch (Exception e1) {
                }
                try {
                    Thread.sleep((long) (Math.random() * 5));
                } catch (InterruptedException e1) {
                }

                downLoadOnePage(url);
            }
        } finally {
            try {
                if (null != fs) {
                    fs.flush();
                    fs.close();
                }
            } catch (Exception e) {
            }
            try {
                if (null != inStream) {
                    inStream.close();
                }
            } catch (Exception e) {
            }
        }
    }
}
