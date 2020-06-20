package homeWork4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Links {
    WebDriver driver;


    @Test
    public void linksTest (){
        driver.get("https://www.w3schools.com/");
        List<WebElement> tagA = driver.findElements(By.tagName("a"));

        for(WebElement each:tagA){
            Assert.assertTrue(each.isEnabled());
        }

        for(WebElement each2:tagA){
            if (each2.isDisplayed()){
                System.out.println(each2.getText());
                System.out.println(each2.getAttribute("href"));
            }
        }

    }


    @BeforeMethod
    public void setUp () {
        driver = BrowserFactory.getDriver("chrome");


    }


    @AfterMethod
    public void tearDown (){
        driver.quit();
    }

}
