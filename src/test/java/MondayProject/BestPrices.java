package MondayProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.nio.IntBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BestPrices {
        @Test
        public static void BestPrices() throws InterruptedException {
            /*EMRE*/
        /*I want to get the best prices first when searching for flights.*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");
        WebElement flight = driver.findElement(By.cssSelector("#tab-flight-tab-hp"));
        flight.click();

        WebElement flyingFrom = driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']"));
        flyingFrom.click();
        flyingFrom.clear();
        flyingFrom.sendKeys("chi");
        Thread.sleep(3000);
        flyingFrom.sendKeys(Keys.DOWN);
        flyingFrom.sendKeys(Keys.ENTER);

        WebElement flyingTo = driver.findElement(By.xpath("//input[@id='flight-destination-hp-flight']"));
        flyingTo.click();
        flyingTo.clear();
        flyingTo.sendKeys("turkey");
        Thread.sleep(3000);
        flyingTo.sendKeys(Keys.DOWN);
        flyingTo.sendKeys(Keys.ENTER);

        WebElement departing = driver.findElement(By.cssSelector("#flight-departing-hp-flight"));
        departing.click();

        WebElement arrowOnCalendarForDeparting = driver.findElement(By.xpath
                ("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']"));
        arrowOnCalendarForDeparting.click();
        /*to see the next month*/

        WebElement departingDay = driver.findElement(By.xpath("(//button[@data-month='8'])[5]"));
        departingDay.click();
        /*selecting Sep 5*/

        WebElement returning = driver.findElement(By.id("flight-returning-hp-flight"));
        returning.click();

        WebElement arrowOnCalendarForReturning = driver.findElement(By.xpath
                ("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']"));
        arrowOnCalendarForReturning.click();

        WebElement returningDay = driver.findElement(By.xpath("(//button[@data-month='8'])[25]"));
        returningDay.click();
        /*selecting Sep 25*/

        WebElement search = driver.findElement(By.xpath
                ("(//button[@class='btn-primary btn-action gcw-submit'])[1]"));
        search.click();

        List<WebElement> listOfPrices = driver.findElements(By.id("listing-price-dollars"));
        listOfPrices.size();

        for(int i = 0; i < listOfPrices.size()-1; i++){
            if(Integer.valueOf(listOfPrices.get(i).getText().replace("$","").replace(",",""))
                    > Integer.valueOf(listOfPrices.get(i+1).getText().replace("$","").replace(",",""))){
                System.out.println("Best prices verification FAILED");
            }
        }
        System.out.println("Best prices verification PASSED");
            driver.quit();
    }
}
