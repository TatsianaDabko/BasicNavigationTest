package homeWork4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Cart {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void cartTest (){
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//span[@id='nav-search-submit-text']/following-sibling::input")).click();

        List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price']/span[@class='a-offscreen']"));
        int x = new Random().nextInt(price.size());
        x = x == 0 ? 1 : x;

        String originName = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[" + x + "]")).getText();

        String originPrice = "$" +
                driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[2])[" + x + "]")).getText() + "." +
                driver.findElement(By.xpath("(//span[@class='a-price']/span[2]/span[3])[" + x + "]")).getText();
                driver.findElement(By.xpath("(//span[@class='a-price-fraction'])[" + x + "]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Qty:']/following-sibling::span")).getText(), "1");
        Assert.assertEquals(driver.findElement(By.id("productTitle")).getText(), originName);
        Assert.assertEquals(driver.findElement(By.id("price_inside_buybox")).getText(), originPrice);
        Assert.assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());


    }


    @BeforeMethod
    public void setUp () {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
