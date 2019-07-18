package qqtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class QqLoginTest {
    private WebDriver driver;
    private String baseurl;
    @BeforeClass
    public void beforeclass(){
        baseurl="https://mail.qq.com";
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseurl);

    }
    @Test
    public void testLogin() throws Exception{
    driver.switchTo().frame("login_frame");
    driver.findElement(By.xpath(".//*[@id='u']")).sendKeys("1916853003");
    driver.findElement(By.xpath(".//*[@id='p']")).sendKeys("tpp82219341");
    driver.findElement(By.id("login_button")).click();
    Thread.sleep(3000);
    WebElement welcome = null;
        try {
            welcome=driver.findElement(By.xpath(".//d[test()='tpp']"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(welcome!=null);
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
