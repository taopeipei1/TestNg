package testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeCourdePageFactory {
    WebDriver driver;
    @FindBy(xpath = "//a[text()='实战课程']")
    WebElement freeCourseLinK;
    @FindBy(xpath = "//a[text()='运维&测试']")
    WebElement mainTainanceTestLink;
    @FindBy(xpath = "//a[text()='测试']")
    WebElement tstLink;
    @FindBy(xpath = "//a[text()='案例']")
    WebElement exampleLink;
    @FindBy(xpath = "//h3[text()='web端功能自动化定位元素']")
    WebElement courseLink;
    public  FreeCourdePageFactory(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickfreeCourseLinK(){
        freeCourseLinK.click();
    }
    public void clickmainTainanceTestLink(){
        mainTainanceTestLink.click();
    }
    public void clicktstLink(){
        tstLink.click();
    }
    public void clickexampleLink(){
        exampleLink.click();
    }
    public void clickcourseLink(){
        courseLink.click();
    }
}
