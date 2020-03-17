package sorm.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 存储表信息
 */
public class TableInfo {
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnInfo> columns) {
        this.columns = columns;
    }

    public ColumnInfo getOnlyPrikey() {
        return onlyPrikey;
    }

    public void setOnlyPrikey(ColumnInfo onlyPrikey) {
        this.onlyPrikey = onlyPrikey;
    }


    public List<ColumnInfo> getPrikey() {
        return Prikey;
    }

    public void setPrikey(List prikey) {
        Prikey = prikey;
    }

    public TableInfo(String tname, ArrayList<ColumnInfo> Prikey, HashMap<String, ColumnInfo> columns) {
        this.tname = tname;
        this.columns = columns;
        this.Prikey = Prikey;
    }

    public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPrikey) {
        this.tname = tname;
        this.columns = columns;
        this.onlyPrikey = onlyPrikey;
    }

    private String tname;
    private Map<String,ColumnInfo> columns;
    private ColumnInfo onlyPrikey;
    private List<ColumnInfo> Prikey;

}
