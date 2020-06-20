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

import java.util.List;

public class DepartmentStore {

    WebDriver driver;

    @Test
    public void amazonTest () {
        driver.get("https://www.amazon.com");

        WebElement allBtn = driver.findElement(By.cssSelector("[class ='nav-search-label']"));
        String allText = allBtn.getText();

        Assert.assertEquals(allText, "All");

        List<WebElement> allOptions = driver.findElements(By.cssSelector("[id='searchDropdownBox']>option"));

        int notSorted = 0;
        for (int i = 0; i <allOptions.size()-1; i++) {
        String value = allOptions.get(i).getText();
        String valueNext = allOptions.get(i+1).getText();
        if(value.compareTo(valueNext)>0){
            notSorted++;
        }
        }

        Assert.assertTrue(notSorted>0);

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
