package MondayProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BundleAndSave {
    @Test
    public static void BundleAndSave() throws InterruptedException {
        /*EMRE*/
        /*I want to bundle flight and hotel and get savings*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");
        WebElement bundleAndSave = driver.findElement(By.id("primary-header-package"));
        bundleAndSave.click();
        Thread.sleep(5000);
        WebElement origin = driver.findElement(By.xpath("//input[@id='package-origin-plp-fh']"));
        origin.click();
        origin.clear();
        origin.sendKeys("chi");
        Thread.sleep(3000);
        origin.sendKeys(Keys.DOWN);
        origin.sendKeys(Keys.ENTER);

        WebElement destination = driver.findElement(By.cssSelector("#package-destination-plp-fh"));
        destination.click();
        destination.sendKeys("new");
        Thread.sleep(3000);
        destination.sendKeys(Keys.DOWN);
        destination.sendKeys(Keys.ENTER);

        WebElement departing = driver.findElement(By.id("package-departing-plp-fh"));
        departing.click();
        WebElement jul2019ForDeparting = driver.findElement(By.xpath("//caption[contains(text(),'Aug 2019')]"));
        WebElement departingDay = driver.findElement(By.xpath("(//button[@data-day='29'])[2]"));

        if(jul2019ForDeparting.getText().contains("Aug 2019")){
        departingDay.click();
        /*selecting August 29*/
        }

        Thread.sleep(3000);
        WebElement returning = driver.findElement(By.cssSelector("#package-returning-plp-fh"));
        returning.click();
        WebElement jul2019ForReturning = driver.findElement(By.xpath("//caption[contains(text(),'Aug 2019')]"));
        WebElement returningDay = driver.findElement(By.xpath("(//button[@data-day='30'])[1]"));
        if(jul2019ForReturning.getText().contains("Aug 2019")) {
            returningDay.click();
            /*selecting August 30*/
        }

        WebElement search = driver.findElement(By.id("search-button-plp-fh"));
        search.click();

        driver.quit();

    }
}
