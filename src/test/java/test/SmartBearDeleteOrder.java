package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearDeleteOrder {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void deleteOrder() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBear.loginToSmartBear(driver);
        WebElement markSmith = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector"));
        markSmith.click();

        WebElement deleteSelected = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteSelected.click();

        List<WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));
        boolean check = true;
        for (WebElement e : names) {
           if(e.getText().equals("Mark Smith")){
               check = false;
           }
        }
        Assert.assertTrue(check);
    }
        @AfterClass
        public void tearDown(){
            driver.quit();
        }





}
