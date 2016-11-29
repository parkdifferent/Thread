package Task;

/**
 * Created by tianf on 2016/8/22.
 */


import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @createtime: 2012-10-19 下午03:29:35
 *
 * @version: 将 表结构生成 实体类
 */
public class CopyOfSqlFiledUtil {
    private static String srcDirectory = "c:/xxx/";// 存放.java源文件的目录
    private static String classDirectory = "c:/xxx/class/";// 存放.class的目录
    private static String classPackage = "com.xxx.entity";// 对应bean对象的包名

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/xxx?useUnicode=true&amp;characterEncoding=GBK";
    private static String user = "xxx";
    private static String pass = "xxx";
    private static Set<String> columnTypeSet = new HashSet<String>();

    private final static  String decollator = "★";  // 分隔符

    private  static void init() {
        // 设置一个目录
        File dir = new File(CopyOfSqlFiledUtil.srcDirectory);
        File dir2 = new File(CopyOfSqlFiledUtil.classDirectory);
        if (!dir.exists()) {
            dir.mkdir();// 如果这个目录不存在，则创建一个用来存入源文件
        }
        if (!dir2.exists()) {
            dir2.mkdir();// 如果这个目录不存在，则创建一个用来存入源文件
        }
    }

    private static void getJavaFile(String tableName, List<String> columnList)
            throws Exception {
        System.out.println("a::" + tableName);
        String columnName = "";
        String zhushi = "";
        String columnType = "";
        String columnType4Obj = "";
        if (columnList != null && !columnList.isEmpty()) {
            StringBuffer fileContent = new StringBuffer();
            // 生成一个包
            fileContent.append("package ");
            fileContent.append(CopyOfSqlFiledUtil.classPackage);
            fileContent.append(";\n\n");

            // 生成类声明类这一行
            fileContent.append("public class ");
            fileContent.append(tableName);
            fileContent.append(" implements java.io.Serializable {\n\n");

            // 生成构造方法
            // fileContent.append("\tprivate " + tableName + "(){\n");
            // fileContent.append("\t}\n");

            for (String columnMessage : columnList) {
                if (columnMessage != null && columnMessage.contains(decollator)) {
                    String[] columns = columnMessage.split(decollator);
                    columnName = columns[0];
                    zhushi = columns[1];
                    columnType = columns[2];
                    columnType4Obj = jdbc2objMap.get(columnType.toUpperCase());

                    // System.err.println("columnName="+columnName+" , zhushi="+zhushi+" , columnType="+columnType+" , columnType4Obj="+columnType4Obj);
                    // 生成javaBean的私有属性
                    fileContent.append("\n\t private " + columnType4Obj + " ");
                    fileContent
                            .append(columnName.toString() + ";\t//" + zhushi);

                }
            }
            fileContent.append("\n");
            fileContent.append("\n\n\n\t/*下面是取得属性值的get方法*/");
            for (String columnMessage : columnList) {
                if (columnMessage != null && columnMessage.contains(decollator)) {
                    String[] columns = columnMessage.split(decollator);
                    columnName = columns[0];
                    zhushi = columns[1];
                    columnType = columns[2];
                    columnType4Obj = jdbc2objMap.get(columnType.toUpperCase());

                    // 生成get方法
                    fileContent.append("\n\t public ");
                    fileContent.append(columnType4Obj);
                    fileContent.append(" get");
                    fileContent.append(columnName.toString().substring(0, 1)
                            .toUpperCase());
                    fileContent.append(columnName.toString().substring(1));
                    fileContent.append("(){\n");
                    fileContent.append("\t\t return this."
                            + columnName.toString() + ";\n\t}");
                    // fileContent.append("\n");
                }
            }

            // 生成set方法
            fileContent.append("\n");
            fileContent.append("\n\n\n\t/*下面是设置属性值的set方法*/");
            for (String columnMessage : columnList) {
                if (columnMessage != null && columnMessage.contains(decollator)) {
                    String[] columns = columnMessage.split(decollator);
                    columnName = columns[0];
                    zhushi = columns[1];
                    columnType = columns[2];
                    columnType4Obj = jdbc2objMap.get(columnType.toUpperCase());
                    // 生成set方法
                    fileContent.append("\n\t public void set");
                    fileContent.append(columnName.toString().substring(0, 1)
                            .toUpperCase());
                    fileContent.append(columnName.toString().substring(1));
                    fileContent.append("( " + columnType4Obj + "\t");
                    fileContent.append(columnName.toString());
                    fileContent.append(" ){\n");
                    fileContent.append("\t\tthis.");
                    fileContent.append(columnName.toString());
                    fileContent.append("=");
                    fileContent.append(columnName.toString());
                    fileContent.append(";\n\t}");
                    fileContent.append("\n");

                }
            }
            fileContent.append("}");

            // 形成一个.java文件
            java.io.FileWriter file = new java.io.FileWriter(
                    CopyOfSqlFiledUtil.srcDirectory + "/" + tableName + ".java");
            file.write(fileContent.toString());
            file.close();
            file = null;
            // 编译成.class文件
            String[] arg = new String[] { "-d", CopyOfSqlFiledUtil.classDirectory,
                    CopyOfSqlFiledUtil.srcDirectory + "/" + tableName + ".java" };
           // com.sun.tools.javac.Main javac = new com.sun.tools.javac.Main();
           // int statues = javac.compile(arg);
          //  System.out.println("OK" + statues);
            String className = CopyOfSqlFiledUtil.classPackage + ".";
            className += tableName;
        }

    }

    /**
     * 驼峰转化为 大写 xxCar 转换为 xx_car
     *
     * @param param
     * @return
     */
    public static String camel4underline(String param) {
        Pattern p = Pattern.compile("[A-Z]");
        if (param == null || param.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i, mc.end() + i, "_"
                    + mc.group().toLowerCase());
            i++;
        }

        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    private static String changeStyle(String str, boolean toCamel) {
        if (str == null || str.isEmpty())
            return str;
        if (toCamel) {
            String[] s = str.split("_");
            String temp = "";
            for (int i = 0; i < s.length; i++) {
                String m = s[i].substring(0, 1).toUpperCase()
                        + s[i].substring(1);
                temp += m;
            }
            return temp;
        } else {
            return camel4underline(str);
        }
    }

    /**
     *
     * @param jdbcType
     * @return
     */
    private static String switchIt(String jdbcType) {
        return jdbc2objMap.get(jdbcType);
    }

    /**
     * 得到某个表的所有字段信息
     *
     * @param tableName
     * @param conn
     * @return xxx_source|状态|TINYINT
     * @throws Exception
     */
    private static List<String> getColumnsByTableName(String tableName,
                                                      Connection conn) throws Exception {
        List<String> columns = new ArrayList<String>();
        ResultSet rSet = null;
        try {
            if (conn == null) {
                conn = getConnection();
            }
            DatabaseMetaData dbms = conn.getMetaData();
            rSet = dbms.getColumns(null, null, tableName, null);
            while (rSet.next()) {
                String columnName = rSet.getString("COLUMN_NAME");
                String remark = rSet.getString("REMARKS");
                String typeName = rSet.getString("TYPE_NAME");
                columnTypeSet.add(typeName);
                // System.err.println(columnName + "|" + remark + "|" +
                // typeName);
                columns.add(columnName + decollator + remark + decollator + typeName);
            }
            return columns;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 得到 conn 数据库的 所有表名称
     *
     * @param conn
     * @return
     * @throws Exception
     */
    private static List<String> getAllTableName(Connection conn)
            throws Exception {
        List<String> tableNames = new ArrayList<String>();
        ResultSet rSet = null;
        try {
            if (conn == null) {
                conn = getConnection();
            }
            DatabaseMetaData dbms = conn.getMetaData();
            rSet = dbms.getTables(null, null, null, null);
            while (rSet.next()) {
                // System.out.println("talbeName :" + rSet.getString(3));
                String tableName = rSet.getString(3);
                tableNames.add(tableName);
            }
            return tableNames;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (rSet != null) {
                rSet.close();
            }
        }
    }

    /**
     * 得到一个数据库连接
     *
     * @return
     */
    private static Connection getConnection() throws Exception {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private static Map<String, String> jdbc2objMap = new HashMap<String, String>();
    static {
        jdbc2objMap.put("CHAR", "String");
        jdbc2objMap.put("VARCHAR", "String");
        jdbc2objMap.put("LONGVARCHAR", "String");
        jdbc2objMap.put("TEXT", "String");
        jdbc2objMap.put("NUMERIC", "java.math.BigDecimal");
        jdbc2objMap.put("DECIMAL", "java.math.BigDecimal");
        jdbc2objMap.put("BIT", "boolean");
        jdbc2objMap.put("INT", "int");
        jdbc2objMap.put("INT UNSIGNED", "int");
        jdbc2objMap.put("TINYINT", "int");
        jdbc2objMap.put("TINYINT UNSIGNED", "int");
        jdbc2objMap.put("SMALLINT", "int");
        jdbc2objMap.put("TINYINT UNSIGNED", "int");
        jdbc2objMap.put("INTEGER", "int");
        jdbc2objMap.put("INTEGER UNSIGNED", "int");
        jdbc2objMap.put("BIGINT", "long");
        jdbc2objMap.put("BIGINT UNSIGNED", "long");
        jdbc2objMap.put("REAL", "float");
        jdbc2objMap.put("FLOAT", "double");
        jdbc2objMap.put("DOUBLE", "double");
        jdbc2objMap.put("BINARY", "byte[]");
        jdbc2objMap.put("VARBINARY", "byte[]");
        jdbc2objMap.put("LONGVARBINARY", "byte[]");
        jdbc2objMap.put("DATE", "java.util.Date");
        jdbc2objMap.put("DATETIME", "java.util.Date");
        jdbc2objMap.put("TIME", "java.util.Date");
        jdbc2objMap.put("TIMESTAMP", "java.util.Date");
    }

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            init();
            conn = getConnection();
            List<String> tables = getAllTableName(conn);
            List<String> list = null;
            if(tables!=null && !tables.isEmpty()){
                for(String table : tables){
                    if(table.startsWith("xxx_")){
                        list = getColumnsByTableName(table, conn);
                        getJavaFile(changeStyle(table,true), list);
                    }
                }
            }
            if(columnTypeSet!=null && !columnTypeSet.isEmpty()){
                for (Iterator iterator = columnTypeSet.iterator(); iterator.hasNext();) {
                    String string = (String) iterator.next();
                    System.err.println(string);

                }
            }
            //System.out.println(changeStyle("xxx", false));
        } catch (Exception e) {
        } finally {
            conn.close();
        }
    }
}