package MondayProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Practice {

    public static void main(String[] args) throws InterruptedException {


        /*EMRE*/
        /*I want to be able to shedule a roundtrip flight.*/
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
//        Thread.sleep(3000);
        flyingFrom.sendKeys(Keys.DOWN);
        flyingFrom.sendKeys(Keys.ENTER);


        WebElement flyingTo = driver.findElement(By.xpath("//input[@id='flight-destination-hp-flight']"));
        flyingTo.click();
        flyingTo.clear();
        flyingTo.sendKeys("turkey");
//        Thread.sleep(3000);
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
        /*selecting Sep 29*/

        WebElement search = driver.findElement(By.xpath
                ("(//button[@class='btn-primary btn-action gcw-submit'])[1]"));
        search.click();

//        Thread.sleep(10000);
        WebElement selectFly = driver.findElement(By.xpath("//button[@class='btn-secondary btn-action t-select-btn']"));
        selectFly.click();

//        Thread.sleep(3000);
        WebElement selectThisFare = driver.findElement(By.xpath("(//button[@class='btn-secondary btn-action t-select-btn'])[1]"));
        selectThisFare.click();

//        Thread.sleep(3000);
        WebElement selectSecondFly =driver.findElement(By.xpath("(//button[@class='btn-secondary btn-action t-select-btn'])[1]"));
        selectSecondFly.click();

//        Thread.sleep(3000);
        WebElement selectThisFare2 = driver.findElement(By.xpath("(//button[@class='btn-secondary btn-action t-select-btn'])[1]"));
        selectThisFare2.click();

//        Thread.sleep(7000);
        WebElement noThanks = driver.findElement(By.xpath("//a[@id='forcedChoiceNoThanks']"));
        noThanks.click();



    }
}
