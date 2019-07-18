package testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestngSelenium {
    private  WebDriver driver;
    private String baseUR;
    FreeCourdePageFactory freeCourse;
    @BeforeClass
    @Parameters({"browser"})
    public void setBaseUR(String browser) throws IOException {
        baseUR = "https://coding.imooc.com";
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","D:\\study\\自动化环境配置\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver","D:\\study\\自动化环境配置\\IEDriverServer_2.exe");
            driver = new InternetExplorerDriver();
        }
        freeCourse = new FreeCourdePageFactory(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUR);
    }
    @Test
    public void testLogin() throws InterruptedException {
        driver.findElement(By.xpath(".//*[@id='js-signin-btn']")).click();
        driver.findElement(By.xpath(".//*[@id='signup-form']/div[1]/input")).sendKeys("15869165982");
        driver.findElement(By.xpath(".//*[@id='signup-form']/div[2]/input")).sendKeys("82219341");
        driver.findElement(By.xpath(".//*[@id='signup-form']/div[5]/input")).click();
        Thread.sleep(3000);
        freeCourse.clickfreeCourseLinK();
        freeCourse.clickmainTainanceTestLink();
        freeCourse.clicktstLink();









    }

    public void cleanUp(){
        driver.quit();
    }


}
