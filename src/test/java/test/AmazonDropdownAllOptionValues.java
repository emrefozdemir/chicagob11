package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropdownAllOptionValues {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement departmentsDropdownInSearch = driver.findElement(By.id("searchDropdownBox"));

        Select departmentsDropdownInSearchList = new Select(departmentsDropdownInSearch);
        List<WebElement> allOptions = departmentsDropdownInSearchList.getOptions();

        for(WebElement a : allOptions){
            if(a.getText().length() == 0){
                System.out.println("FAILED");
            }
        }
        System.out.println("PASSED");

    }
}
