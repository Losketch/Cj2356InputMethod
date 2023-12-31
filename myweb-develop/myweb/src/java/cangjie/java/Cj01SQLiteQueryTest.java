package cangjie.java;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SQLite查詢
 * 
 * 
 * @author fszhouzz@qq.com
 * @time 2018年10月8日 下午11:20:21
 */
public class Cj01SQLiteQueryTest {
    private static String mbsBaseDir = Cj00AllInOneTest.mbsBaseDir;

    public static final String TYPE_CODE_CJGEN2 = "cj2";
    public static final String TYPE_CODE_CJGEN3 = "cj3";
    public static final String TYPE_CODE_CJGEN35 = "cj35"; // 三五代
    public static final String TYPE_CODE_CJGEN5 = "cj5";
    public static final String TYPE_CODE_CJGEN6 = "cj6";
    public static final String TYPE_CODE_ZYFH = "zyfh"; // 注音符號
    public static final String TYPE_CODE_KARINA = "karina"; // 日語oen假名
    public static final String TYPE_CODE_PINYIN = "pinyin"; // 官話拼音
    public static final String TYPE_CODE_JYUTPING = "jyutp"; // 粵語拼音
    public static final String TYPE_CODE_SIGOHAOMA = "sghm"; // 四角號碼
    public static final String TYPE_CODE_CJGENYAHOO = "cjyhqm"; // 雅虎奇摩
    public static final String TYPE_CODE_CJGENMS = "cjms"; // 微軟倉頡
    public static final String TYPE_CODE_CJGENKOREA = "korea"; // 朝鮮諺文
    public static final String TYPE_CODE_CJGENMANJU = "manju"; // 圈點滿文
    public static final String TYPE_CODE_CJGEN_IPA = "ipa"; // 國際音標
    public static final String TYPE_CODE_CJGEN_KOXHANH = "kohan"; // 中古漢語
    // 倉頡碼表的交集
    public static final String TYPE_CODE_CJINTERSECT = "cjcommon";

    private static String dbName = "cjmbdb.db";
    private static String genTbName = "t_mb_type"; // 碼表名表
    private static String genClNameId = "_id";
    private static String genClNameGen = "type_code";
    private static String genClNameName = "type_name";
    private static String mbTbName = "t_mb_content"; // 碼表
    private static String mbClNameId = "_id";
    private static String mbClNameGen = "type_code";
    private static String mbClNameCod = "mb_code";
    private static String mbClNameVal = "mb_char";
    private static String mbClNameOrder = "mb_order_no"; // 序號列
    private static String mbTbNameIntersect = "t_mb_content_intersect"; // 交集碼表
    private static String mbClNameIdIntersect = "_id";
    private static String mbClNameCodIntersect = "mb_code";
    private static String mbClNameValIntersect = "mb_char";
    private static String mbClNameOrderIntersect6 = "mb_order_6"; // 序號列6
    private static String mbClNameOrderIntersect5 = "mb_order_5"; // 序號列5
    private static String mbClNameOrderIntersect3 = "mb_order_3"; // 序號列3
    private static String mbClNameOrderIntersectyh = "mb_order_yh"; // 序號列yh
    private static String mbClNameOrderIntersectms = "mb_order_ms"; // 序號列ms

    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            String mbdbFile = mbsBaseDir + "mbdb" + File.separator + "cjmbdb.db";
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + mbdbFile);
            System.out.println("Opened database successfully");

            String sql = getQuerySql(new String[] { TYPE_CODE_CJGEN6, TYPE_CODE_CJINTERSECT }, "", "buhjm");
            System.out.println(sql);
            
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String cod = rs.getString(mbClNameCod);
                String val = rs.getString(mbClNameVal);
                int order = rs.getInt(mbClNameOrder);
                System.out.println(cod + " " + val + " " + order);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 得到查询語句字串
     * 
     * @author fszhouzz@qq.com
     * @time 2018年10月8日 下午10:58:18
     * @param typeArr
     * @param cha
     * @param code
     * @return
     */
    private static String getQuerySql(String[] typeArr, String cha, String code) {
        // 輸入法類型條件
        List<String> types = new ArrayList<String>(Arrays.asList(typeArr));
        boolean unionIntersect = false;
        for (int i = types.size() - 1; i >= 0; i--) {
            if (TYPE_CODE_CJINTERSECT.equals(types.get(i))) {
                unionIntersect = true;
                types.remove(i);
            }
        }

        String typeCodeSql = " and " + mbClNameGen + " = '" + types.get(0) + "' ";
        // 當前輸入條件
        String chaSql = "";
        if (null != cha && !"".equals(cha.trim())) {
            chaSql = " and " + mbClNameVal + " = '" + cha + "' ";
        }
        String codeSql = "";
        if (null != code && !"".equals(code.trim())) {
            codeSql = " and " + mbClNameCod + " = '" + code + "' ";
        }
        // 排序
        String orderSql = " order by " + mbClNameCod + " asc, " + mbClNameOrder + " desc ";

        StringBuilder sql = new StringBuilder();
        sql.append(" select ");
        sql.append(mbClNameId + ", ");
        sql.append(mbClNameGen + ", ");
        sql.append(mbClNameCod + ", ");
        sql.append(mbClNameVal + ", ");
        sql.append(mbClNameOrder);
        sql.append(" from ");
        sql.append(mbTbName);
        sql.append(" where 1=1 ");
        sql.append(typeCodeSql);
        sql.append(chaSql);
        sql.append(codeSql);
        if (unionIntersect) {
            sql.append(" union all select ");
            sql.append(mbClNameIdIntersect + ", ");
            sql.append("'" + TYPE_CODE_CJINTERSECT + "' as " + mbClNameGen + ", ");
            sql.append(mbClNameCodIntersect + ", ");
            sql.append(mbClNameValIntersect + ", ");
            String colName = getColOrderName(types.get(0));
            sql.append(colName + " " + mbClNameOrder);
            sql.append(" from ");
            sql.append(mbTbNameIntersect);
            sql.append(" where 1=1 ");
            sql.append(chaSql);
            sql.append(codeSql);
        }
        return "select * from (" + sql.toString() + ") t " + orderSql;
    }

    private static String getColOrderName(String typeName) {
        String colName = mbClNameOrder;
        if (TYPE_CODE_CJGEN6.equals(typeName)) {
            colName = mbClNameOrderIntersect6;
        } else if (TYPE_CODE_CJGEN5.equals(typeName)) {
            colName = mbClNameOrderIntersect5;
        } else if (TYPE_CODE_CJGEN3.equals(typeName)) {
            colName = mbClNameOrderIntersect3;
        } else if (TYPE_CODE_CJGENYAHOO.equals(typeName)) {
            colName = mbClNameOrderIntersectyh;
        } else if (TYPE_CODE_CJGENMS.equals(typeName)) {
            colName = mbClNameOrderIntersectms;
        }
        return colName;
    }
}
