package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChoosingSelect {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://54.148.96.210/web/login");
        WebElement email = driver.findElement(By.id("login"));
        email.sendKeys("in_manuf_manager@info.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("kop98tfgQ68");
        WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();
        WebElement Manufacturing = driver.findElement(By.xpath("//a[@href='/web#menu_id=415&action=']"));
        Manufacturing.click();
        WebElement Create = driver.findElement(By.xpath("//button[@accesskey='c']"));
        Create.click();
        WebElement productDropDown = driver.findElement(By.xpath("(//div[@class='o_input_dropdown'])[1]"));
        productDropDown.click();



    }
}
