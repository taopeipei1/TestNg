package tencent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FindElementsMethods {
    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void beforeTest(){
        //定位驱动
        String driverPath = System.getProperty("user.dir")+"\\src\\main\\resources\\driver\\geckodriver.exe";
        System.out.println(driverPath);
        //定位浏览器启动脚本
        System.setProperty("webdriver.firefox.bin","D:\\study\\Learning\\tools\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver",driverPath);
        driver=new FirefoxDriver();
        baseUrl="https://www.taobao.com/";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @AfterTest
    public void afterTest(){
       /* driver.quit();*/
        System.out.println("close firefox!!!");
    }
    @Test
    public void Test() throws InterruptedException {
        driver.findElement(By.linkText("天猫超市")).click();
        Set<String> handles =driver.getWindowHandles();
        String[] ghandles= handles.toArray(new String[0]);
        driver.switchTo().window(ghandles[ghandles.length-1]);
        Thread.sleep(1000);
        driver.findElement(By.id("mq")).sendKeys("红酒");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div[3]/form/fieldset/div/button")).click();
        Thread.sleep(3000);
        ((JavascriptExecutor)driver).executeScript("scrollTo(0,1000)");
        Thread.sleep(1000);
        String ptitle =driver.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/div[4]/ul/li[1]/div/h3/a")).getText();

        System.out.println("================="+ptitle);
        if(ptitle.contains("中粮长城红酒干红葡萄酒窖酿赤霞珠")){
            Assert.assertEquals(1,1);
        }else {
            Assert.assertEquals(0,1);
        }


    }
}
