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

public class MainDepartment {
    WebDriver driver;


    @Test
    public void mainDepartmentTest (){
    driver.get("https://www.amazon.com/gp/site-directory");
    List<WebElement> allBtn = driver.findElements(By.cssSelector("[id='searchDropdownBox']>option"));
    List <WebElement> allBtn2=driver.findElements(By.xpath("//h2"));

    int notPresent = 0;
    for(WebElement every: allBtn){
        for(WebElement every2: allBtn2){
            String each = every.getText();
            String each2=every2.getText();

            if(each.equals(each2)){
                System.out.println("Department main "+ each);
                System.out.println("Department bellow "+each2);
            }else{
                notPresent++;
            }
        }
    }
        System.out.println(notPresent);

        Assert.assertTrue(notPresent>0);
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