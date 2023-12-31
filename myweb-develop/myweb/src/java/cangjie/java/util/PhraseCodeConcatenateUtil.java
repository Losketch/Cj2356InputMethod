package cangjie.java.util;

import java.util.List;

/**
 * 按各字編码生成詞組編碼
 * 
 * @author fszhouzz@qq.com
 * @time 2017年12月16日 下午3:32:19
 */
public class PhraseCodeConcatenateUtil {

    public static String generateTempPhraseCodeOneAll(List<String> list) {
        String all = "";
        for (String str : list) {
            all += str;
        }
        return all;
    }

    // 按各字編码生成詞組編碼，方法類奇趣
    // 一個字，直接返回。
    // 兩個字：首尾+一二尾，沒有就不取。
    // 三個字：正好作爲三部分；
    // 四個字：一二、三、四字，作爲三部分；
    // 五個字及以上：一二字、三至倒數第二字、末字，作爲三部分。
    // 三部分的取碼：首尾+首尾+尾，或首尾+全+首尾；
    // 第二部分只有一個碼時，第三部分就可以取兩碼，否则第三部分只能取尾碼
    public static String generateTempPhraseCodeOneQq(List<String> list) {
        String code = "";
        if (list.size() == 1) {
            // 一個字，直接返回
            code = list.get(0).split(" +")[0];
        } else if (list.size() == 2) {
            // 兩個字：首尾+一二尾
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];

            code += code1.charAt(0);
            if (code1.length() > 1) {
                code += code1.charAt(code1.length() - 1);
            }
            code += code2.charAt(0);
            if (code2.length() > 1) {
                code += code2.charAt(1);
            }
            if (code2.length() > 2) {
                code += code2.charAt(code2.length() - 1);
            }
        } else if (list.size() >= 3) {
            // 三個字
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];
            if (list.size() >= 4) {
                code1 += code2;
                code2 = list.get(2).split(" +")[0];
                if (list.size() >= 5) {
                    code2 += list.get(list.size() - 2).split(" +")[0];
                }
            }
            String code3 = list.get(list.size() - 1).split(" +")[0];

            // code1
            code += code1.charAt(0);
            if (code1.length() > 1) {
                code += code1.charAt(code1.length() - 1);
            }
            // code2
            boolean code3has2 = true; // 第三部分要取兩碼
            code += code2.charAt(0);
            if (code2.length() > 1) {
                code += code2.charAt(code2.length() - 1);
                code3has2 = false;
            }
            // code3
            if (code3has2 && code3.length() > 1) {
                code += code3.charAt(0);
            }
            code += code3.charAt(code3.length() - 1);
        }
        return code;
    }

    // 按各字編码生成詞組編碼，方法一
    // 一個字，直接返回。
    // 兩個字：首尾+一二尾，沒有就不取。
    // 三個字：正好作爲三部分；
    // 四個字：一二、三、四字，作爲三部分；
    // 五個字及以上：一二字、三至倒數第二字、末字，作爲三部分。
    // 三部分的取碼：首尾+首尾+尾，沒有就算了
    public static String generateTempPhraseCodeOneSimple(List<String> list) {
        String code = "";
        if (list.size() == 1) {
            // 一個字，直接返回
            code = list.get(0).split(" +")[0];
        } else if (list.size() == 2) {
            // 兩個字：首尾+一二尾
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];

            code += code1.charAt(0);
            if (code1.length() > 1) {
                code += code1.charAt(code1.length() - 1);
            }
            code += code2.charAt(0);
            if (code2.length() > 1) {
                code += code2.charAt(1);
            }
            if (code2.length() > 2) {
                code += code2.charAt(code2.length() - 1);
            }
        } else if (list.size() >= 3) {
            // 三個字
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];
            if (list.size() >= 4) {
                code1 += code2;
                code2 = list.get(2).split(" +")[0];
                if (list.size() >= 5) {
                    code2 += list.get(list.size() - 2).split(" +")[0];
                }
            }
            String code3 = list.get(list.size() - 1).split(" +")[0];

            // code1
            code += code1.charAt(0);
            if (code1.length() > 1) {
                code += code1.charAt(code1.length() - 1);
            }
            // code2
            code += code2.charAt(0);
            if (code2.length() > 1) {
                code += code2.charAt(code2.length() - 1);
            }
            // code3
            code += code3.charAt(code3.length() - 1);
        }
        return code;
    }

    // 按各字編码生成詞組編碼方法二，都拼出五碼，沒有就算了
    // 一個字，直接返回
    // 兩個字，5碼，每字取1首尾、2首二尾碼
    // 三個字，5碼，1首、2首、3首二尾
    // 四個字，5碼，1首、2首、3首、4首尾
    // 五字以上，5碼，1首、2首、3首、4首、-1尾
    public static String generateTempPhraseCodeOne5555light(List<String> list) {
        String code = "";
        if (list.size() == 1) {
            // 一個字，直接返回
            code = list.get(0).split(" +")[0];
        } else if (list.size() == 2) {
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];

            code += code1.charAt(0);
            if (code1.length() > 1) {
                code += code1.charAt(code1.length() - 1);
            }
            code += code2.charAt(0);
            if (code2.length() > 1) {
                code += code2.charAt(1);
            }
            if (code2.length() > 2) {
                code += code2.charAt(code2.length() - 1);
            }
        } else if (list.size() == 3) {
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];
            String code3 = list.get(2).split(" +")[0];

            code += code1.charAt(0);
            code += code2.charAt(0);
            code += code3.charAt(0);
            if (code3.length() > 1) {
                code += code3.charAt(1);
            }
            if (code3.length() > 2) {
                code += code3.charAt(code3.length() - 1);
            }
        } else if (list.size() == 4) {
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];
            String code3 = list.get(2).split(" +")[0];
            String code4 = list.get(3).split(" +")[0];

            code += code1.charAt(0);
            code += code2.charAt(0);
            code += code3.charAt(0);
            code += code4.charAt(0);
            if (code4.length() > 1) {
                code += code4.charAt(code4.length() - 1);
            }
        } else {
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];
            String code3 = list.get(2).split(" +")[0];
            String code4 = list.get(3).split(" +")[0];
            String code5 = list.get(list.size() - 1).split(" +")[0];

            code += code1.charAt(0);
            code += code2.charAt(0);
            code += code3.charAt(0);
            code += code4.charAt(0);
            code += code5.charAt(code5.length() - 1);
        }
        return code;
    }

    // 按各字編码生成詞組編碼方法二
    // 一個字，直接返回
    // 兩個字，4碼，每字取首尾兩碼，只一碼的，算首又算尾，所以重複它就得了
    // 三個字，4碼，首、首、首尾
    // 四個字，5碼，首、首、首、首尾
    // 五字以上，5碼，首、首、首、首、尾
    public static String generateTempPhraseCodeOne4455(List<String> list) {
        String code = "";
        if (list.size() == 1) {
            // 一個字，直接返回
            code = list.get(0).split(" +")[0];
        } else if (list.size() == 2) {
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];

            code += code1.charAt(0);
            code += code1.charAt(code1.length() - 1);
            code += code2.charAt(0);
            code += code2.charAt(code2.length() - 1);
        } else if (list.size() == 3) {
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];
            String code3 = list.get(2).split(" +")[0];

            code += code1.charAt(0);
            code += code2.charAt(0);
            code += code3.charAt(0);
            code += code3.charAt(code3.length() - 1);
        } else if (list.size() == 4) {
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];
            String code3 = list.get(2).split(" +")[0];
            String code4 = list.get(3).split(" +")[0];

            code += code1.charAt(0);
            code += code2.charAt(0);
            code += code3.charAt(0);
            code += code4.charAt(0);
            code += code4.charAt(code4.length() - 1);
        } else {
            String code1 = list.get(0).split(" +")[0];
            String code2 = list.get(1).split(" +")[0];
            String code3 = list.get(2).split(" +")[0];
            String code4 = list.get(3).split(" +")[0];
            String code5 = list.get(list.size() - 1).split(" +")[0];

            code += code1.charAt(0);
            code += code2.charAt(0);
            code += code3.charAt(0);
            code += code4.charAt(0);
            code += code5.charAt(code5.length() - 1);
        }
        return code;
    }

}
