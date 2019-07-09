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

public class SmartBearEditOrder {
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
        WebElement editForSteveJohns = driver.findElement(By.xpath("(//input[@type='image'])[3]"));
        editForSteveJohns.click();

        WebElement name = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        name.clear();
        name.sendKeys("Micheal Jordan");

        WebElement update = driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton"));
        update.click();

        List<WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));
        boolean check = false;
        for (WebElement e : names) {
            if(e.getText().equals("Micheal Jordan")){
              check = true;
            }
        }

        Assert.assertTrue(check,"Micheal Jordan is in the list");
    }
        @AfterClass
        public void tearDown(){
            driver.quit();
        }


}
