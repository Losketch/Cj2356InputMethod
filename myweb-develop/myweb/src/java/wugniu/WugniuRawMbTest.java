package wugniu;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cangjie.java.util.IOUtils;

/**
 * 上海吳語（老派），引用上海閒話abc（tzyyiggnih）、吳語越音（zhufya）的碼表，版本2016.05.14。拼寫方案採用《吳語拉丁式注音法》。2020年10月鬼島人推薦使用。
 * 
 * @author fszhouzz@qq.com
 * @time 2020年11月16日 下午10:12:23
 */
public class WugniuRawMbTest {

    public static String mbBaseDir = "src\\java\\wugniu\\mb\\";
    public static String resultFile = mbBaseDir + "wugniu_good2order.txt";

    public static void main(String[] args) throws Exception {
        resolveWugniuRawMb("wugniu_lopha.dict.yaml", "wugniu_good1.txt");
        orderWugniuMb("wugniu_good1.txt", resultFile);
    }

    private static void orderWugniuMb(String srcFile, String destFile)
            throws Exception {
        List<String> lines = IOUtils.readLinesRaw(mbBaseDir + srcFile);
        List<String> res = new ArrayList<String>();
        for (String line : lines) {
            String[] parts = line.split(" +");
            res.add(parts[1] + " " + parts[0]);
        }
        IOUtils.writeFile(resultFile, res);
        Set<String> dups = IOUtils.uniqueCodeFile(resultFile);
        System.out.println(dups);
        IOUtils.orderCodeFile(resultFile);
    }

    private static void resolveWugniuRawMb(String srcFile, String destFile)
            throws Exception {
        List<String> lines = IOUtils.readLinesRaw(mbBaseDir + srcFile);
        List<String> res = new ArrayList<String>();
        for (String str : lines) {
            boolean check = null != str && !str.matches("^[#-.a-z].*")
                    && str.trim().length() > 0;
            if (check) {
                String[] parts = str.trim().split("\t| ");
                String one = null;
                for (String part : parts) {
                    if (null == one) {
                        one = part + " ";
                        continue;
                    }
                    if (!part.matches("^[0-9]+.*")) {
                        // 多余的百分号
                        one += part.replace("%", "");
                    }
                }
                // 必須要有英文
                boolean checkCode = one.matches("^[^a-z]+.*[a-z]+.*");
                if (checkCode) {
                    System.out.println(one);
                    res.add(one);
                }
            }
        }
        IOUtils.writeFile(mbBaseDir + destFile, res);
    }

}
