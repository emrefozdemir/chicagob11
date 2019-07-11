package recap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandles {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test
    public void cybertekWindow(){
        String mainHandle = driver.getWindowHandle();
        WebElement cybertekSchool = driver.findElement(By.xpath("//a[.='Cybertek School']"));
        cybertekSchool.click();
        cybertekSchool.click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        System.out.println(windows.size());
        driver.switchTo().window(it.next());
        driver.switchTo().window(it.next());

        Assert.assertTrue(driver.getTitle().equals("Cybertek"));

    }
}
