package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OpenXcell {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12 , TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com/");

        List<WebElement> links = driver.findElements(By.xpath("//body//a"));
//        System.out.println(links.size());
//        int counter = 0;
//        for(WebElement l : links){
//            System.out.println(l.getText());
//            if(l.getText().isEmpty()){
//                counter++;
//            }
//        }
//        System.out.println(counter);


        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        System.out.println(inputs.size());

        for(WebElement i : inputs){
            System.out.println(i.getAttribute("type"));
        }

    }
}
