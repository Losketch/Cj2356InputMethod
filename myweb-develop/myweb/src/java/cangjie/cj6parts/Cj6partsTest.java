package cangjie.cj6parts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 漢文典庫編碼：4297~4590<br/>
 * http://hanculture.com/dic/v.php?id=4589<br/>
 * 圖片編號bzaa-bzzk
 * 
 * 
 * @author 日月遞炤
 * @time 2017年11月30日 下午8:22:55
 */
public class Cj6partsTest {

    static int a = 0;
    
    public static void main(String[] args) {
        String preffix = "BZ";
        List<String> appendix = new ArrayList<String>();
        for (Character c = 'A'; c <= 'Z'; c++) {
            for (Character b = 'A'; b <= 'Z'; b++) {
                appendix.add(c.toString() + b.toString());
            }
        }
        List<String> res = new ArrayList<String>();
        for (String app : appendix) {
            res.add(preffix + app);
        }
        System.out.println(res);

        String destDir = "src\\java\\cangjie\\cj6parts\\img\\";
        String baseUrl = "http://hanculture.com/m4/b/";
        for (String re : res) {
            String fileName = re + ".BMP";
            download(baseUrl, destDir, fileName);
        }
        
        System.out.println(a);
    }

    public static void download(String baseUrl, String destDir, String fileName) {
        InputStream inStream = null;
        FileOutputStream fs = null;
        String absoluteName = destDir + fileName;
        String urlStr = baseUrl + fileName;
        File dest = null;
        
        boolean finished = false;
        try {
            dest = new File(absoluteName);
            if (dest.exists()) {
                return;
            }
            dest.createNewFile();

            URL urlObj = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept-Language", "zh-CN");
            conn.setRequestProperty("Charset", "UTF-8");
            // 一定要設置接收類型: Accept=""都可以，但不能没有，否則找不到文件
            conn.setRequestProperty("Accept",
                    "*/*, image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
                            + "application/x-shockwave-flash, application/xaml+xml, "
                            + "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
                            + "application/x-ms-application, application/vnd.ms-excel, "
                            + "application/vnd.ms-powerpoint, application/msword");

            inStream = conn.getInputStream();
            fs = new FileOutputStream(dest);
            
            System.out.println(absoluteName);
            byte[] buffer = new byte[1024];
            int byteread = 0;
            while ((byteread = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteread);
            }
            
            finished = true;
        } catch (Exception e) {
            if (e instanceof FileNotFoundException) {
                System.out.println((++a) + "下載文件不存在：" + absoluteName + " 地址：" + urlStr);
            } else {
                System.out.println("下載失败：" + absoluteName + " 地址：" + urlStr);
            }
            try {
                // 删除它
                if (null != dest && dest.exists()) {
                    dest.delete();
                }
            } catch (Exception ed) {
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
        
        // 成功了就休息下
        if (finished) {
            sleepForAWhile();
        }
    }
    
    /**
     * 休息一下子
     * 
     * @author t
     */
    private static void sleepForAWhile() {
        try {
            long mi = new Random().nextInt(5) + 5;
            Thread.sleep(mi * 1000L);
            System.out.println("休息了" + mi + "秒鐘");
        } catch (Exception e) {
        }
    }
}
