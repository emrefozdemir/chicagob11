package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Redfin {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void contains50Kand175k() throws InterruptedException {
        driver.get("https://www.redfin.com/");
        WebElement searchBoxInput = driver.findElement(By.xpath("(//input[@name='searchInputBox'])[1]"));
        searchBoxInput.sendKeys("Naperville");

        WebElement searchButton = driver.findElement(By.xpath("(//button[@class='inline-block SearchButton clickable float-right'])[1]"));
        searchButton.click();

        WebElement firstDropDown = driver.findElement(By.xpath("(//span[@data-rf-test-name='Select'])[2]"));
        firstDropDown.click();

        List<WebElement> firstList = driver.findElements(By.xpath("//div[@class='container']/div"));

    }
}