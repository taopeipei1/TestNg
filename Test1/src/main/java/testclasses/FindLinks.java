package testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindLinks {
    private  WebDriver driver;
    private String baseUR;
    FreeCourdePageFactory freeCourse;
    public static List<WebElement>  clickableLinks(WebDriver driver){
        List<WebElement> linksToClick = new ArrayList<WebElement>();
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        elements.addAll(driver.findElements(By.tagName("img")));
        for (WebElement e:elements) {
            if(e.getAttribute("href") != null){
                linksToClick.add(e);
            }

        }
        return linksToClick;
    }
    public static String linkStatus(URL url){
        try {
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.connect();
            String responseMessage = http.getResponseMessage();
            http.disconnect();
            return responseMessage;

        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @BeforeClass
    public void setUp() throws Exception{
        baseUR = "https://coding.imooc.com/pay/cart";
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testFindLinks() throws InterruptedException{
        driver.get(baseUR);
        List<WebElement> linkList = clickableLinks(driver);
        for (WebElement link:linkList
             ) {
            String href = link.getAttribute("href");
            try {
                System.out.println("URL "+href+" ----return  "+linkStatus(new URL(href)));
            } catch (MalformedURLException e) {
                System.out.println("URL "+href+" ----return  "+e.getMessage());
            }

        }
    }
}
