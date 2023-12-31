package cangjie.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cangjie.java.util.IOUtils;

/**
 * MacOSX10.5Cangjie-Arthurmcarthur20200719<br/>
 * 生成cj5-MacOSX10.5.txt
 * 
 * @author fszhouzz@qq.com
 * @time 2020年10月11日 下午4:20:02
 */
public class MacOSX105Test {

    public static String mbsBaseDir = "src\\java\\cangjie\\mb\\cjmb\\";

    private static String srcFile = "MacOSX10.5Cangjie-Arthurmcarthur20200719.txt";

    private static String destFile = "cj5-MacOSX10.5.txt";

    public static void main(String[] args) throws Exception {
        String file = mbsBaseDir + srcFile;
        List<String> lines = IOUtils.readLines(file, false);
        Map<String, List<String>> codeCharsList = new HashMap<String, List<String>>();
        for (String line : lines) {
            String[] keyVal = line.trim().split("\\t");
            String code = keyVal[1];
            String val = keyVal[0];
            List<String> chars = codeCharsList.get(code);
            if (null == chars) {
                codeCharsList.put(code, new ArrayList<String>());
                chars = codeCharsList.get(code);
            }
            chars.add(val);
        }
        List<String> codes = new ArrayList<String>(codeCharsList.keySet());
        Collections.sort(codes);
        List<String> res = new ArrayList<String>();
        for (String code : codes) {
            List<String> chars = codeCharsList.get(code);
            for (String val : chars) {
                res.add(code + "  " + val);
            }
        }
        IOUtils.writeFile(mbsBaseDir + destFile, res);
    }
}
