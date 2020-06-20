package homeWork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TempMailAddress9 {
    WebDriver driver;


    private By statusCodeBy= (By.linkText("Status Codes"));
    private By statusCode200By=(By.linkText("200"));
    private By statusCode301By=(By.linkText("301"));
    private By statusCode404By=(By.linkText("404"));
    private By statusCode500By=(By.linkText("500"));
    private By notify200By =(By.xpath("//p[contains(text(), 'This page returned a 200 status code.')]"));
    private By notify301By =(By.xpath("//p[contains(text(), 'This page returned a 301 status code.')]"));
    private By notify404By =(By.xpath("//p[contains(text(), 'This page returned a 404 status code.')]"));
    private By notify500By =(By.xpath("//p[contains(text(), 'This page returned a 500 status code.')]"));



    @Test(dataProvider="testData")
    public void test9 (By statusCodeDataBy, By notifyDataBy){
        WebElement statusCode = driver.findElement(statusCodeBy);
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("arguments[0].scrollIntoView(true)", statusCode);
        statusCode.click();
        String code = driver.findElement(statusCodeDataBy).getText();
        driver.findElement(statusCodeDataBy).click();

        String notify = driver.findElement(notifyDataBy).getText();
        Assert.assertTrue(notify.contains("This page returned a "+code+" status code"));
    }

    @DataProvider ( name= "testData")
    public Object[][] testData () {
        return new Object[][]{{statusCode200By, notify200By},
                {statusCode301By, notify301By},
                {statusCode404By, notify404By},
                {statusCode500By, notify500By}
        };
    }


        @BeforeMethod
        public void setUp () {
            driver = BrowserFactory.getDriver("chrome");
            driver.get("https://practice-cybertekschool.herokuapp.com");
            driver.manage().window().maximize();
        }


        @AfterMethod
        public void tearDown () {
            driver.quit();
        }


}
