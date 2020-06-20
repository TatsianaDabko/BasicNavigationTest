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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MoreSpoons {
    WebDriver driver;

    @Test
    public void moreSpoonsTest (){

        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);

        List<WebElement> brands = driver.findElements(By.cssSelector("[aria-labelledby='p_89-title']>li"));
        for (WebElement each: brands){
            System.out.println(each.getText());
        }

        WebElement prime = driver.findElement(By.xpath("//li[@id='p_85/2470955011']//i[@class='a-icon a-icon-checkbox']"));
        prime.click();

        List<WebElement>brands2 = driver.findElements(By.xpath("//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base']"));


        for (int i = 0; i <brands2.size() ; i++) {
            for (int j = 0; j <brands.size() ; j++) {
                Assert.assertTrue(brands.get(i).getText().equals(brands2.get(j).getText()));
                System.out.println(brands2.get(i).getText()+ "="+brands.get(j).getText() );
            }
        }

    }

    @Test
    public void cheapSpoonsTest () {
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);

        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();

        List <WebElement> price =driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        List<WebElement>coin=driver.findElements(By.xpath("//span[@class='a-price-fraction']"));

        for (int i = 0; i <price.size() ; i++) {
            for (int j = 0; j <coin.size() ; j++) {
                Assert.assertTrue(Integer.parseInt(price.get(i).getText()) > 25 &&
                        Integer.parseInt(price.get(j).getText()) != 0);
            }


        }

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
