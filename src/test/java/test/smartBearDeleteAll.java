package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class smartBearDeleteAll {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void deleteAll(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBear.loginToSmartBear(driver);

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[1]//input"));
        for (WebElement e : checkBoxes){
            e.click();
        }
        for(WebElement w : checkBoxes){
            Assert.assertTrue(w.isSelected(), "checkbox is not selected");
        }
        WebElement deleteSelected = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteSelected.click();

        WebElement message = driver.findElement(By.id("ctl00_MainContent_orderMessage"));
        Assert.assertTrue(message.isDisplayed(), "The message is not displayed");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
