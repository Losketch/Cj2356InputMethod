package cangjie.java;

import java.util.ArrayList;
import java.util.List;

import cangjie.java.util.IOUtils;

/**
 * 碼表美化一下
 * 
 * @author fszhouzz@qq.com
 * @time 2018年1月23日上午11:10:32
 */
public class MbBeautifyTest {

    public static void main(String[] args) throws Exception {
        String file = "src\\java\\hangul\\file\\korea-12000.txt";
        doBeautify(file);
    }

    /**
     * 碼表美化一下
     * 
     * @author fszhouzz@qq.com
     * @param file
     * @throws Exception
     */
    private static void doBeautify(String file) throws Exception {
        List<String> lines = IOUtils.readLines(file, true);
        List<String> res = doBeautify(lines);
        IOUtils.writeFile(file, res);
    }

    /**
     * 碼表美化一下
     * 
     * @author fszhouzz@qq.com
     * @param lines
     * @return
     * @throws Exception
     */
    private static List<String> doBeautify(List<String> lines) throws Exception {
        List<String> res = new ArrayList<String>();
        int maxCodeLen = 0;

        for (String line : lines) {
            if (line.contains(" ")) {
                String[] parts = line.split(" ");
                if (parts[0].length() > maxCodeLen) {
                    maxCodeLen = parts[0].length();
                }
            }
        }

        for (String line : lines) {
            if (line.contains(" ")) {
                String[] parts = line.split(" ");
                String spaces = " ";
                for (int i = parts[0].length(); i < maxCodeLen; i++) {
                    spaces += " ";
                }
                res.add(parts[0] + spaces + parts[1]);
            }
        }
        return res;
    }
}
