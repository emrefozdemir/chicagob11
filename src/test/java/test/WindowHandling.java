package test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandling {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test
    public void windowsHandle(){
        String mainHandle = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();
        System.out.println(driver.getWindowHandles().size());

        Set<String> windows = driver.getWindowHandles();

        for(String handle : driver.getWindowHandles()){
            if(!handle.equals(mainHandle)){
                driver.switchTo().window(handle);
                System.out.println(driver.getTitle());
                break;
            }
        }
        String expected = driver.getTitle();
        Assert.assertTrue("New Window".equals(expected));

    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}
