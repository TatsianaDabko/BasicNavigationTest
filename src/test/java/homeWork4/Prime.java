package homeWork4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Prime {
    WebDriver driver;

    @Test
    public void primeTest (){
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);

        String firstPrime = driver.findElement(By.xpath("//span[@class='sb_3XafbQtX sb_25yic0YU sb_CyFsQ0hU'][contains(text(),'Riveira Wooden Spoons for Cooking 6-Piece Bamboo U')]")).getText();

        WebElement checkBox = driver.findElement(By.xpath("//li[@id='p_85/2470955011']//i[@class='a-icon a-icon-checkbox']"));
        checkBox.click();

        String checkBox2 = driver.findElement(By.xpath("//span[contains(text(),'Riveira Wooden Spoons for Cooking 6-Piece Bamboo U')]")).getText();
        Assert.assertEquals(firstPrime, checkBox2);

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
