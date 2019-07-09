package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }
    @Test(priority = 1)
    public void Alert(){
        WebElement alertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String excepted = "You successfuly clicked an alert";
        Assert.assertEquals(result.getText(),excepted);

    }

    @Test(priority = 2)
    public void Confirm(){
        WebElement confirmButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirmButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String excepted = "You clicked: Ok";
        Assert.assertEquals(result.getText(),excepted);
    }

    @Test(priority = 3)
    public void Promt() throws InterruptedException {
        WebElement promtButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        promtButton.click();

        Alert alert = driver.switchTo().alert();
        String input = "something";
        alert.sendKeys(input);
        alert.accept();
        WebElement result = driver.findElement(By.cssSelector("#result"));
        String excepted = "You entered: " + input;
        Assert.assertEquals(result.getText(),excepted);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
