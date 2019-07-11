package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AmazonDropdownDefaultValue {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        WebElement departmentsDropdownInSearch = driver.findElement(By.id("searchDropdownBox"));

        Select departmentsDropdownInSearchOptions = new Select(departmentsDropdownInSearch);

        String searchDropdown = departmentsDropdownInSearchOptions.getFirstSelectedOption().getText();
        System.out.println(searchDropdown);

    }

}
