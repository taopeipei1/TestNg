package sorm.bean;

/**
 * 管理配置信息
 */
public class Configuration {
    public Configuration() {
    }

    public Configuration(String driverClassName, String url, String username,
                         String password, String srcPatg, String poPackage,String usingDB) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
        this.srcPatg = srcPatg;
        this.poPackage = poPackage;
        this.usingDB= usingDB;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public String getusingDB() {
        return usingDB;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSrcPatg() {
        return srcPatg;
    }

    public void setSrcPatg(String srcPatg) {
        this.srcPatg = srcPatg;
    }

    public String getPoPackage() {
        return poPackage;
    }

    public void setPoPackage(String poPackage) {
        this.poPackage = poPackage;
    }
    public void setusingDB(String usingDB) {
        this.usingDB = usingDB;
    }

    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String srcPatg;
    private String poPackage;
    private String usingDB;

}
