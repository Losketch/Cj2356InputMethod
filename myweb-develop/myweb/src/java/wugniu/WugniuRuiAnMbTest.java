package wugniu;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cangjie.java.util.IOUtils;

/**
 * 瑞安吳語、甌越瑞安碼表整理
 * 
 * @author fszhouzz@qq.com
 * @time 2020年11月16日 下午10:12:23
 */
public class WugniuRuiAnMbTest {

    public static String mbBaseDir = "src\\java\\wugniu\\mb\\";

    public static void main(String[] args) throws Exception {
        orderWugniuMb("瓯越瑞安auyue_lodzen-11400.txt", 
                "瓯越瑞安auyue_lodzen-order.txt");
        orderWugniuMb("瑞安吳語nniu_lodzen-10800.txt", 
                "瑞安吳語nniu_lodzen-order.txt");
    }

    private static void orderWugniuMb(String srcFile, String destFile)
            throws Exception {
        List<String> lines = IOUtils.readLinesRaw(mbBaseDir + srcFile);
        List<String> res = new ArrayList<String>();
        for (String line : lines) {
            String[] parts = line.split(" +");
            res.add(parts[0] + " " + parts[1]);
        }
        IOUtils.writeFile(mbBaseDir + destFile, res);
        Set<String> dups = IOUtils.uniqueCodeFile(mbBaseDir + destFile);
        System.out.println(dups);
        IOUtils.orderCodeFileRaw(mbBaseDir + destFile);
    }
}
