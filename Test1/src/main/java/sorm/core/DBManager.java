package sorm.core;

import sorm.bean.Configuration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 根据配置信息，维持链接对象的管理(增加链接池的功能)
 */
public class DBManager {
    private static Configuration conf;
    static {
        Properties pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        conf =new Configuration();
        conf.setDriverClassName(pros.getProperty("driverClassName"));
        conf.setPassword(pros.getProperty("password"));
        conf.setPoPackage(pros.getProperty("poPackage"));
        conf.setSrcPatg(pros.getProperty("srcPatg"));
        conf.setUrl(pros.getProperty("url"));
        conf.setUsername(pros.getProperty("username"));
        conf.setusingDB(pros.getProperty("usingDB"));


    }
    public static Connection getConn(){
        try {
            Class.forName(conf.getDriverClassName());
            return DriverManager.getConnection(conf.getUrl(),conf.getUsername(),conf.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void close(ResultSet rs, Statement ps,Connection con){
        try {
            if(rs !=null){
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(ps !=null){
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if(con !=null){
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
