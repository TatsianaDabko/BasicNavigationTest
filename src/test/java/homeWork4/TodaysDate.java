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

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodaysDate {
    WebDriver driver;

    private By yearBy = (By.id("year"));
    private By monthBy = (By.id("month"));
    private By dayBy = (By.id("day"));




    @Test
    public void verifyTodaysDate (){
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();

        Select year = new Select(driver.findElement(yearBy));
        String year1 = year.getFirstSelectedOption().getText();
        Select month = new Select(driver.findElement(monthBy));
        String month1 = month.getFirstSelectedOption().getText();
        Select day = new Select (driver.findElement(dayBy));
        String day1 = day.getFirstSelectedOption().getText();

        LocalDate ymd = LocalDate.now();

        String todayExpected = DateTimeFormatter.ofPattern("yyyyMMMMdd").format(ymd);
        System.out.println(todayExpected);
        String todayActual = year1+month1+day1;
        System.out.println(todayActual);

        Assert.assertEquals(todayActual, todayExpected);



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
