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
import java.util.Random;

public class Days {
    WebDriver driver;



    @Test
    public void dayTest () {
       List<WebElement> weekDays= driver.findElements(By.xpath("//label"));
       List <WebElement> checkBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));

       Random random = new Random ();

        int fridayCount = 0;

        while(fridayCount!=3){
            int index = random.nextInt(7);
            if(checkBoxes.get(index).isEnabled()){
                checkBoxes.get(index).click();
                String days = weekDays.get(index).getText();
                System.out.println(days);
                checkBoxes.get(index).click();
            }

            if(weekDays.get(index).getText().equals("Friday")) {
                fridayCount++;
            }
        }
        Assert.assertTrue(fridayCount==3);

    }





    @BeforeMethod
    public void setUp () {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.manage().window().maximize();
    }




    @AfterMethod
    public void tearDown (){
        driver.quit();
    }

}
