package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Apple {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.apple.com/");
    }
    @Test
    public void windowsHandling(){
        String rightClickandENter = Keys.chord(Keys.CONTROL, Keys.ENTER);
        List<WebElement> listOfLinks = driver.findElements(By.xpath("(//ul[@class='ac-gf-directory-column-section-list'])[2]/li/a"));

        for(WebElement e : listOfLinks){
            e.sendKeys(rightClickandENter);
        }

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        System.out.println(driver.getWindowHandles().size());

        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

    }
}
