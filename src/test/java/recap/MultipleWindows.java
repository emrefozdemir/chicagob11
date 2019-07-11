package recap;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindows extends TestBase {

   @Test
    public void multipleWindows(){
       driver.get("http://practice.cybertekschool.com/windows");
       ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
       ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
       ((JavascriptExecutor) driver).executeScript("window.open('http://amazon.com','_blank');");
       ((JavascriptExecutor) driver).executeScript("window.open('http://instagram.com','_blank');");


       for(String handle : driver.getWindowHandles()){
               driver.switchTo().window(handle);
               if(driver.getTitle().equals("Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone")){
                   break;
           }
       }
       System.out.println(driver.getCurrentUrl());

   }
}
