package qqtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class CrmTest {
    public static void main(String[] args) {
        String baseURL="http://cscrmsso.array.yw.zj.chinamobile.com/loginFrame.jsp";
        System.setProperty("webdriver.ie.driver", "D:\\study\\自动化环境配置\\IEDriverServer_2.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
        driver.findElement(By.name("login_user")).sendKeys("lumin1");
        driver.findElement(By.name("login_password")).sendKeys("password1");
        driver.findElement(By.name("veryCode")).sendKeys("asiainfo");
        driver.findElement(By.name("submitButtom")).click();


    }

}

 class A{
    private static A a =null;
    private A(){

    }
    public static synchronized A getInstance(){
        if(a==null){
            a = new A();

        }
        return a;

    }
}

class B{
    private static final B b=new B();
    private B(){

    }
    public static B getInstance(){
        return b;
    }
}

class C{
    private static C c =null;
    private C(){

    }
    public static C getInstance(){
        if(c==null){
            synchronized (C.class){
                if(c==null){
                    c = new C();
                }
            }
        }
        return c;
    }
}