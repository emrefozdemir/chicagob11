package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class removeName extends TestBase {

    public void removeName(WebDriver driver, String name){
       WebElement givenName = driver.findElement(By.xpath
               ("//td[.='" + name + "']"));
       WebElement nameCheckBox = driver.findElement(By.xpath
               ("//td[.='" + name + "']/../td[1]"));
       nameCheckBox.click();

       WebElement deleteSelected = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
       deleteSelected.click();

    }

    @Test
    public void smartTest(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBear.loginToSmartBear(driver);
        removeName(driver,"Susan McLaren");
    }


}
