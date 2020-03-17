package sorm.bean;

/**
 * 封装表中一个字段的信息
 */
public class ColumnInfo {
    public ColumnInfo() {

    }

    public ColumnInfo(String name, String dateType, int keyType) {
        this.name = name;
        this.dateType = dateType;
        this.keyType = keyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public int getKeyType() {
        return keyType;
    }

    public void setKeyType(int keyType) {
        this.keyType = keyType;
    }

    private String name;
    private String dateType;
    private int keyType;
}
