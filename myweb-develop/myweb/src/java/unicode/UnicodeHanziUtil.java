package unicode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 統一碼漢字工具类<br/>
 * 參見http://yedict.com/zsts.htm<br/>
 * http://www.haomeili.net/code/unicode?wd=
 * 
 * @author fszhouzz@qq.com
 * @time 2017年12月11日上午9:37:37
 */
public class UnicodeHanziUtil {

    /** 漢字基本區 */
    public static int[] baseRange = { 0x4E00, 0x9FA5 };
    /** 基本補充 */
    public static int[] base2Range = { 0x9FA6, 0x9FFF };
    /** 擴展A */
    public static int[] AextRange = { 0x3400, 0x4DBF };
    /** 擴展B */
    public static int[] BextRange = { 0x20000, 0x2A6DF };
    /** 擴展C */
    public static int[] CextRange = { 0x2A700, 0x2B734 };
    /** 擴展D */
    public static int[] DextRange = { 0x2B740, 0x2B81D };
    /** 擴展E */
    public static int[] EextRange = { 0x2B820, 0x2CEA1 };
    /** 擴展F */
    public static int[] FextRange = { 0x2CEB0, 0x2EBE0 };
    /** 擴展G */
    public static int[] GextRange = { 0x30000, 0x3134F };

    /** Private Use Area 私用區 */
    public static int[] privateUserArea = { 0xE000, 0xF8FF };
    public static int[] privateUserArea2 = { 0xF0000, 0x10fffd };

    private static List<String> list = new ArrayList<String>();

    private static Map<String, List<Integer>> nameRangeMap = new LinkedHashMap<String, List<Integer>>();

    static {
        list.add("0000 0019 C0控制符");
        list.add("0020 007E 基本拉丁文");
        list.add("007F 007F C0控制符");
        list.add("0080 009F C1控制符");
        list.add("00A0 00FF 拉丁文補充1");
        list.add("0100 017F 拉丁文擴展A");
        list.add("0180 024F 拉丁文擴展B");
        list.add("0250 02AF 國際音標擴展");
        list.add("02B0 02FF 空白修飾字母");
        list.add("0300 036F 結合讀音符號");
        list.add("0370 03E1 希臘文1");
        list.add("03E2 03EF 科普特文");
        list.add("03F0 03FF 希臘文2");
        list.add("0400 04FF 西里爾字母");
        list.add("0500 052F 西里爾補充");
        list.add("0530 058F 亞美尼亞語");
        list.add("0590 05FF 希伯來文");
        list.add("0600 06FF 阿拉伯文");
        list.add("0700 074F 敘利亞文");
        list.add("0750 077F 阿拉伯文補充");
        list.add("0780 07BF 馬爾代夫語");
        list.add("07C0 077F 西非書面語言");
        list.add("0800 083F 撒馬利亞文");
        list.add("0840 085F 曼達安文");
        list.add("0860 086F 敘利亞文補充");
        list.add("0900 097F 天城文");
        list.add("0980 09FF 孟加拉文");
        list.add("0A00 0A7F 果魯穆奇字母");
        list.add("0A80 0AFF 古吉拉特文");
        list.add("0B00 0B7F 奥里亞文");
        list.add("0B80 0BFF 泰米爾文");
        list.add("0C00 0C7F 泰盧固文");
        list.add("0C80 0CFF 卡納達文");
        list.add("0D00 0D7F 馬拉雅拉姆文");
        list.add("0D80 0DFF 僧伽羅語");
        list.add("0E00 0E7F 泰文");
        list.add("0E80 0EFF 老撾文");
        list.add("0F00 0FFF 藏文");
        list.add("1000 109F 緬甸語");
        list.add("10A0 10FF 格魯吉亞語");
        list.add("1100 11FF 朝鮮文字母");
        list.add("1200 137F 埃塞俄比亞語");
        list.add("1380 139F 埃塞俄比亞補充");
        list.add("13A0 13FF 切羅基語");
        list.add("1400 167F 加拿大土著音節");
        list.add("1680 169F 歐甘字母");
        list.add("16A0 16FF 如尼文");
        list.add("1700 171F 塔加拉語");
        list.add("1720 173F 哈努諾文");
        list.add("1740 175F 布迪文");
        list.add("1760 177F 塔格巴努亞文");
        list.add("1780 17FF 高棉語");
        list.add("1800 18AF 蒙古文");
        list.add("18B0 18FF 加拿大土著音節擴展");
        list.add("1900 194F 林布文");
        list.add("1950 197F 德宏傣文");
        list.add("1980 19DF 新傣仂語");
        list.add("19E0 19FF 高棉語記號");
        list.add("1A00 1A1F 布吉文");
        list.add("1A20 1AAF 西雙版納傣文");
        list.add("1AB0 1AFF 結合讀音符號擴展");
        list.add("1B00 1B7F 巴里語");
        list.add("1B80 1BB0 巽他語");
        list.add("1BC0 1BFF 巴塔克文");
        list.add("1C00 1C4F 雷布查語");
        list.add("1C50 1C7F 奥奇基文");
        list.add("1C80 1C8F 西里爾擴展C");
        list.add("1C90 1CBF 格魯吉亞語擴展");
        list.add("1CC0 1CCF 巽他語補充");
        list.add("1CD0 1CFF 吠陀梵語");
        list.add("1D00 1D7F 語音學擴展");
        list.add("1D80 1DBF 語音擴展補充");
        list.add("1DC0 1DFF 結合讀音符號補充");
        list.add("1E00 1EFF 拉丁文擴展附加");
        list.add("1F00 1FFF 希臘語擴展");
        list.add("2000 206F 常用標點");
        list.add("2070 209F 上標及下標");
        list.add("20A0 20CF 貨幣符號");
        list.add("20D0 20FF 組合用記號");
        list.add("2100 214F 字母式符號");
        list.add("2150 218F 數字形式");
        list.add("2190 21FF 箭頭");
        list.add("2200 22FF 數學運算符");
        list.add("2300 23FF 雜項工業符號");
        list.add("2400 243F 控制圖片");
        list.add("2440 245F 光學識別符");
        list.add("2460 24FF 封閉字母數字");
        list.add("2500 257F 製表符");
        list.add("2580 259F 方塊元素");
        list.add("25A0 25FF 幾何圖形");
        list.add("2600 26FF 雜項符號");
        list.add("2700 27BF 裝飾符號");
        list.add("27C0 27EF 雜項數學符號A");
        list.add("27F0 27FF 追加箭頭A");
        list.add("2800 28FF 盲文點字模型");
        list.add("2900 297F 追加箭頭B");
        list.add("2980 29FF 雜項數學符號B");
        list.add("2A00 2AFF 追加數學運算符");
        list.add("2B00 2BFF 雜項符號和箭頭");
        list.add("2C00 2C5F 格拉哥里字母");
        list.add("2C60 2C7F 拉丁文擴展C");
        list.add("2C80 2CFF 古埃及語");
        list.add("2D00 2D2F 格魯吉亞語補充");
        list.add("2D30 2D7F 提非納文");
        list.add("2D80 2DDF 埃塞俄比亞擴展");
        list.add("2E00 2E7F 追加標點");
        list.add("2E80 2EFF 中日韓部首補充");
        list.add("2F00 2FDF 康熙字典部首");
        list.add("2FF0 2FFF 表意文字描述符");
        list.add("3000 303F 中日韓符號標點");
        list.add("3040 309F 日文平假名");
        list.add("30A0 30FF 日文片假名");
        list.add("3100 312F 注音字母");
        list.add("3130 318F 朝鮮文兼容字母");
        list.add("3190 319F 象形字註釋標志");
        list.add("31A0 31BF 注音字母擴展");
        list.add("31C0 31EF 中日韓筆畫");
        list.add("31F0 31FF 片假名語音擴展");
        list.add("3200 32FF 封閉中日韓文字月份");
        list.add("3300 33FF 中日韓兼容");
        list.add("3400 4DBF 中日韓擴展A");
        list.add("4DC0 4DFF 易經六十四卦");
        list.add("4E00 9FFF 中日韓漢字基本區");
        list.add("A000 A48F 彝文音節");
        list.add("A490 A4CF 彝文字根");
        list.add("A4D0 A4FF 老傈僳文");
        list.add("A500 A63F 瓦伊語");
        list.add("A640 A69F 西里爾擴展B");
        list.add("A6A0 A6FF 巴姆穆語");
        list.add("A700 A71F 聲調修飾字母");
        list.add("A720 A7FF 拉丁文擴展D");
        list.add("A800 A82F 錫爾赫特文");
        list.add("A830 A83F 普通印度數字形式");
        list.add("A840 A87F 八思巴字");
        list.add("A880 A8DF 索拉什特拉文");
        list.add("A8E0 A8FF 天城文擴展");
        list.add("A900 A92F 克耶字母");
        list.add("A930 A95F 勒姜文");
        list.add("A960 A97F 朝鮮文字母擴展A");
        list.add("A980 A9DF 爪哇語");
        list.add("A9E0 A9FF 緬甸語擴展B");
        list.add("AA00 AA5F 占族文");
        list.add("AA60 AA7F 緬甸語擴展A");
        list.add("AA80 AADF 越南傣文");
        list.add("AAE0 AAFF 曼尼普爾語擴展");
        list.add("AB00 AB2F 埃塞俄比亞擴展A");
        list.add("AB30 AB6F 拉丁文擴展E");
        list.add("AB70 ABBF 切羅基補充");
        list.add("ABC0 ABFF 曼尼普爾語");
        list.add("AC00 D7AF 朝鮮文音節");
        list.add("D7B0 D7FF 朝鮮文字母擴展B");
        list.add("D800 DBFF UTF16前導代理區");
        list.add("DC00 DFFF UTF16後尾代理區");
        list.add("E000 F8FF 私用區");
        list.add("F900 FAFF 中日韓兼容表意");
        list.add("FB00 FB4F 字母表達形式");
        list.add("FB50 FDFF 阿拉伯表達形式A");
        list.add("FE00 FE0F 變量選擇符1");
        list.add("FE10 FE1F 豎排形式");
        list.add("FE20 FE2F 組合用半符號");
        list.add("FE30 FE4F 中日韓兼容符號");
        list.add("FE50 FE6F 小型變體形式");
        list.add("FE70 FEFF 阿拉伯表達形式B");
        list.add("FF00 FFEF 半角及全角形式");
        list.add("FFF0 FFFF 特殊");
        list.add("10000 1007F 線性文字B音節");
        list.add("10080 100FF 線性文字B表意");
        list.add("10100 1013F 爱琴海數字");
        list.add("10140 1018F 古希臘數字");
        list.add("10190 101CF 古羅馬希臘記數");
        list.add("101D0 101FF 斐斯托斯圓盤");
        list.add("10280 1029F 呂基亞字母");
        list.add("102A0 102DF 卡里安文");
        list.add("102E0 102FF 科普特閏餘數字");
        list.add("10300 1032F 古意大利文");
        list.add("10330 1034F 哥特字母");
        list.add("10350 1037F 舊彼爾姆字母");
        list.add("10380 1039F 烏加里特語");
        list.add("103A0 103DF 古波斯語");
        list.add("10400 1044F 德瑟列特文");
        list.add("10450 1047F 蕭伯納字母");
        list.add("10480 104AF 奥斯馬尼亞文");
        list.add("104B0 104FF 奥色治文");
        list.add("10500 1052F 愛爾巴桑文");
        list.add("10530 1056F 高加索阿爾巴尼亞文");
        list.add("10600 1077F 線性文字A");
        list.add("10800 1083F 塞浦路斯音節文字");
        list.add("10840 1085F 亞蘭帝國文");
        list.add("10860 1087F 帕爾邁拉文");
        list.add("10880 108AF 納巴泰文");
        list.add("108E0 108FF 哈特拉文");
        list.add("10900 1091F 腓尼基文");
        list.add("10920 1093F 呂底亞文");
        list.add("10980 1099F 麥羅埃象形");
        list.add("109A0 109FF 麥羅埃草書");
        list.add("10A00 10A5F 佉盧文");
        list.add("10A60 10A7F 舊南阿拉伯文");
        list.add("10A80 10A9F 舊北阿拉伯文");
        list.add("10AC0 10AFF 摩尼教文字");
        list.add("10B00 10B3F 阿維斯陀語");
        list.add("10B40 10B5F 帕提亞銘文");
        list.add("10B60 10B7F 巴拉維銘文");
        list.add("10B80 10BAF 巴拉維聖詩");
        list.add("10C00 10C4F 老土耳其字母");
        list.add("10C80 10CFF 舊匈牙利文");
        list.add("10D00 10D3F 哈乃斐羅興亞文字");
        list.add("10E60 10E7F 魯米數字符號");
        list.add("10F00 10F2F 舊索格代亞納文");
        list.add("10F30 10F6F 索格代亞納文");
        list.add("11000 1107F 婆羅米文");
        list.add("11080 110CF 凱提文");
        list.add("110D0 110FF 索拉僧平字母");
        list.add("11100 1114F 查克瑪文");
        list.add("11150 1117F 瑪哈賈尼文");
        list.add("11180 111DF 夏拉達文");
        list.add("111E0 111FF 僧伽羅古數字");
        list.add("11200 1124F 可吉文");
        list.add("11280 112AF 穆爾塔尼文");
        list.add("112B0 112FF 庫達瓦迪文");
        list.add("11300 1137F 古蘭塔文");
        list.add("11400 1147F 尼瓦爾文");
        list.add("11480 114DF 邁蒂利文");
        list.add("11580 115FF 悉曇文");
        list.add("11600 1165F 莫迪文");
        list.add("11660 1167F 蒙古文補充");
        list.add("11680 116CF 塔克里字母");
        list.add("11700 1173F 阿霍姆文");
        list.add("11800 1184F 多格拉文");
        list.add("118A0 118FF 瓦蘭齊地文");
        list.add("11A00 11A4F 扎納巴扎方塊字");
        list.add("11A50 11AAF 索永布字母");
        list.add("11AC0 11AFF PauCinHau");
        list.add("11C00 11C6F 拜庫施吉文");
        list.add("11C70 11CBF 瑪爾欽文");
        list.add("11D00 11D5F 瑪薩拉姆岡德文");
        list.add("11D60 11DAF Gunjala岡德文");
        list.add("11EE0 11EFF 望加錫文");
        list.add("12000 123FF 楔形文");
        list.add("12400 1247F 楔形文數字和符號");
        list.add("12480 1254F 早期王朝楔形文");
        list.add("13000 1342F 埃及象形文");
        list.add("16800 16A3F 巴姆穆語補充");
        list.add("1B000 1B0FF 假名補充");
        list.add("1D000 1D0FF 拜占庭音樂符號");
        list.add("1D100 1D1FF 音樂符號");
        list.add("1D200 1D24F 古希臘音樂符號");
        list.add("1D300 1D35F 太玄經符號");
        list.add("1D360 1D37F 算籌");
        list.add("1D400 1D7FF 數學字母數字");
        list.add("1F000 1F02F 麻將子");
        list.add("1F030 1F09F 多米諾骨牌");
        list.add("1F0A0 1F0FF 撲克牌");
        list.add("1F100 1F1FF 封閉式字母數字補");
        list.add("1F200 1F2FF 封閉表意補充");
        list.add("1F300 1F5FF 雜項符號和形符");
        list.add("1F600 1F64F 表情");
        list.add("1F680 1F6FF 運輸和地圖符號");
        list.add("1F700 1F77F 煉金術符號");
        list.add("20000 2A6DF 中日韓擴展B");
        list.add("2A700 2B73F 中日韓擴展C");
        list.add("2B740 2B81F 中日韓擴展D");
        list.add("2B820 2CEAF 中日韓擴展E");
        list.add("2CEB0 2EBE0 中日韓擴展F");
        list.add("2F800 2FA1F 中日韓兼容表意補");
        list.add("30000 3134F 中日韓擴展G");
        list.add("E0000 E007F 標記");
        list.add("E0100 E01EF 變量選擇符17+");
        list.add("F0000 FFFFD 補充私用區A");
        list.add("100000 10FFFD 補充私用區B");

        for (String line : list) {
            String[] parts = line.split(" +");
            List<Integer> range = new ArrayList<Integer>();
            try {
                range.add(Integer.parseInt(parts[0], 16));
                range.add(Integer.parseInt(parts[1], 16));
            } catch (Exception e) {
            }
            String name = parts[2];
            nameRangeMap.put(name, range);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getRangeNameByChar("龜"));

        System.out.println(isInPrivateUserArea(""));
        System.out.println(isInhanziCompt("兀"));

        for (int i = 0; i < 0xFFFFF; i++) {
            String str = UnicodeConvertUtil.getStringByUnicode(i);
            if (isInhanziCompt(str)) {
                System.out.println(str);
            }
        }
    }

    /**
     * 是否在私用區
     * 
     * @param charStr
     *            一個字符
     * @return
     */
    public static boolean isInPrivateUserArea(String charStr) {
        if (null == charStr || "".equals(charStr) || charStr.toCharArray().length > 2) {
            return false;
        }
        int start1 = 0xF0000;
        int end1 = 0x10FFFD;
        int start2 = 0xE000;
        int end2 = 0xF8FF;
        List<Integer> codes = UnicodeConvertUtil.getUnicodeListFromStr(charStr);
        int code = codes.get(0); // 只取第一個
        return (code >= start1 && code <= end1) || (code >= start2 && code <= end2);
    }

    /**
     * 是否在漢字兼容或兼容擴展區
     * 
     * @param charStr
     *            一個字符
     * @return
     */
    public static boolean isInhanziCompt(String charStr) {
        if (null == charStr || "".equals(charStr) || charStr.toCharArray().length > 2) {
            return false;
        }
        int start1 = 0x2F800;
        int end1 = 0x2FA1F; // 中日韓兼容表意補
        int start2 = 0xF900;
        int end2 = 0xFAFF;
        List<Integer> codes = UnicodeConvertUtil.getUnicodeListFromStr(charStr);
        int code = codes.get(0); // 只取第一個
        return (code >= start1 && code <= end1) || (code >= start2 && code <= end2);
    }

    /**
     * 按字符，取得它在統一碼中所在區名字
     */
    public static String getRangeNameByChar(String charStr) {
        if (null == charStr || "".equals(charStr) || charStr.toCharArray().length > 2) {
            return "";
        }
        List<Integer> codes = UnicodeConvertUtil.getUnicodeListFromStr(charStr);
        int code = codes.get(0); // 只取第一個
        for (String name : nameRangeMap.keySet()) {
            List<Integer> range = (List<Integer>) nameRangeMap.get(name);
            if (code >= range.get(0) && code <= range.get(range.size() - 1)) {
                return name;
            }
        }
        return "";
    }
}
