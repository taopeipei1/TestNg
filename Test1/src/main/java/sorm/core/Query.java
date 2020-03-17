package sorm.core;

import java.awt.*;

public interface Query {
    public int executeDML(String sql,Object[] params);
    public void insert(Object obj);
    public void delete(Class clazz,int id);
    public void delete(Object obj);
    public int  update(Object obj,String[] fieldNames);

    /**
     *
      * @param sql 查询SQL
     * @param clazz 封装数据的javabean类的Class对象
     * @param params sql的参数
     * @return  查询到的结果
     */
    public List queryRows(String sql,Class clazz,Object[] params);
    public Object queryUniqueRow(String sql,Class clazz,Object[] params);
    public Object queryValue(String sql,Object[] params);
    public Number queryNumber(String sql,Object[] params);




}
