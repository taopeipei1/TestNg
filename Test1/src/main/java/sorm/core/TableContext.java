package sorm.core;

import sorm.bean.ColumnInfo;
import sorm.bean.TableInfo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 负责管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构
 */
public class TableContext {
    public static Map<String, TableInfo> tables =new HashMap<String, TableInfo>();
    public static Map<Class,TableInfo> poClassTableMap =new HashMap<Class, TableInfo>();

    private TableContext(){

    }
    static {
        try {
            Connection con = DBManager.getConn();
            DatabaseMetaData dbmd = con.getMetaData();
            ResultSet tableRet = dbmd.getTables(null,"%","%",new String[]{"TABLE"});
            while (tableRet.next()){
                String tableName=(String)tableRet.getObject("TABLE_NAME");
                TableInfo ti = new TableInfo(tableName,new ArrayList<ColumnInfo>()
                        ,new HashMap<String,ColumnInfo>());
                tables.put(tableName,ti);
                ResultSet set =dbmd.getColumns(null,"%",tableName,"%");
                while (set.next()){
                    ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"),
                            set.getString("TYPE_NAME"),0);
                    ti.getColumns().put(set.getString("COLUMN_NAME"),ci);
                }
                ResultSet set2 =dbmd.getPrimaryKeys(null,"%",tableName);
                while (set2.next()){
                    ColumnInfo ci2 = ti.getColumns().get(set2.getObject("COLUMN_NAME"));
                    ci2.setKeyType(1);
                    ti.getPrikey().add(ci2);
                }
                if (ti.getPrikey().size()>0){
                    ti.setOnlyPrikey(ti.getPrikey().get(0));
                }
            }
        }

         catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static Map<String,TableInfo> getTableInfos(){
        return tables;
    }

    public static void main(String[] args) {
        Map<String,TableInfo> tables = TableContext.getTableInfos();
        System.out.printf(tables.toString());
    }
}
