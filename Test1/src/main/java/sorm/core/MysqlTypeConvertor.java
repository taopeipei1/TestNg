package sorm.core;

public class MysqlTypeConvertor implements TypeConvertor {

    public String datebaseType2JavaType(String columnType) {
        if("varchar".equals(columnType)||"char".equals(columnType)){
            return "String";
        }else if("int".equals(columnType)
                ||"tinyint".equals(columnType)
                ||"smallint".equals(columnType)
                ||"integer".equals(columnType)){
            return "integer";

        }else if("bigInt".equals(columnType)){
            return "long";
        }else if("clob".equals(columnType)||"float".equals(columnType)){
            return "java.sqL.Clob";
        }else if("blob".equals(columnType)||"float".equals(columnType)){
            return "java.sqL.Blob";
        }
        return null;
    }

    public String javaType2DatabaseType(String javaDataType) {
        return null;
    }
}
