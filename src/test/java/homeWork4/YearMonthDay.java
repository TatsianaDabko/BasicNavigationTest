package homeWork4;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class YearMonthDay {
    WebDriver driver;

    @Test
    public void dateTest (){
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();

        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select (driver.findElement(By.id("month")));
        Select day = new Select (driver.findElement(By.id("day")));
        String dayActual = day.getFirstSelectedOption().getText();

        Random random = new Random();
        int indexYear = random.nextInt(100);
        int indexMonth = random.nextInt(12);

        List<WebElement> years = driver.findElements(By.cssSelector("[id='year']>option"));
        List <WebElement> months = driver.findElements(By.cssSelector("[id='month']>option"));


        int i=0;

        while(i<=100){
            year.selectByVisibleText(years.get(indexYear).getText());
            month.selectByVisibleText("January");
            month.selectByVisibleText(months.get(indexMonth).getText());
            i++;
        }

        LocalDate ymd = LocalDate.now();
        String today = DateTimeFormatter.ofPattern("yyyyMMMMdd").format(ymd);
        Assert.assertTrue(today.contains(dayActual));




//        int index = random.nextInt(12);
//        year.selectByIndex(index);
//
//        month.selectByVisibleText("January");
//        String monthActual = month.getFirstSelectedOption().getText();
//
//        LocalDate ymd = LocalDate.now();
//        String today = DateTimeFormatter.ofPattern("yyyyMMMMdd").format(ymd);
//
//        Assert.assertEquals(monthActual, "January");
//        Assert.assertTrue(today.contains(dayActual));
//
//        month.getAllSelectedOptions();
//
//        System.out.println( month.getFirstSelectedOption().getText());
//        Assert.assertTrue(today.contains(dayActual));


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



