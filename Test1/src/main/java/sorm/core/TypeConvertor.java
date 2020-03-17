package sorm.core;

/**
 * 负责JAVA类型和数据库类型的互相转换
 */
public interface TypeConvertor {
    public String datebaseType2JavaType(String columnType);
    public String javaType2DatabaseType(String javaDataType);
}
