package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBear {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        username.sendKeys("Tester");
        password.sendKeys("test");
        WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
        login.click();
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println(links.size());
        for(WebElement e : links){
            System.out.println(e.getText());
        }

    }
    public static void loginToSmartBear(WebDriver driver) {

        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        username.sendKeys("Tester");
        password.sendKeys("test");
        WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
        login.click();
    }
}
