package homeWork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TempMailAddress {
    WebDriver driver;
    WebDriverWait wait;
    private By emailBy = (By.id("email"));
    private By signupBy=(By.xpath("//a[contains(text(), 'Sign Up For Mailing List')]"));
    private By fullnameBy=(By.cssSelector("[name='full_name']"));
    private By emailcyberBy=(By.cssSelector("[name='email']"));
    private By submitBy=(By.cssSelector("[name='wooden_spoon']"));
    private By messageBy=(By.className("subheader"));
    private By answerBy =(By.xpath("//tbody[@id='schranka']/tr[1]"));
    private By thanksBy =(By.id("predmet"));

    private By fileUploadBy = (By.xpath("//a[text()='File Upload']"));
    private By uploadBy = (By.id("file-upload"));
    private By uploadBtnBy = (By.id("file-submit"));



    @Test
    public void test6(){
        driver.get("https://www.tempmailaddress.com/");
        driver.manage().window().maximize();
        String email = driver.findElement(emailBy).getText();

        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        WebElement signUpBtn=driver.findElement(signupBy);
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("arguments[0].scrollIntoView(true)", signUpBtn);
        signUpBtn.click();

        driver.findElement(fullnameBy).sendKeys("Tanya Dabko");
        driver.findElement(emailcyberBy).sendKeys(email);

        driver.findElement(submitBy).click();

        WebElement massege1 = driver.findElement(messageBy);
        String actual=massege1.getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertTrue(massege1.isDisplayed());
        Assert.assertEquals(actual, expected);

        driver.navigate().to("https://www.tempmailaddress.com/");
        WebElement answer = driver.findElement(answerBy);
        String actual1=answer.getText();
      //  String expected1 = "do-not-reply@practice.cybertekschool.com";
        Assert.assertTrue(actual1.contains("practice.cybertekschool.com"));
       // Assert.assertEquals(actual1, expected1);
        answer.click();

        String actual3 = driver.findElement(thanksBy).getText();
        String expected3 = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actual3, expected3);
    }


    @Test
    public void test7 (){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();

        driver.findElement(fileUploadBy).click();
        driver.findElement(By.cssSelector("#file-upload")).sendKeys("/Users/sergey/Desktop/123.docx");
        driver.findElement(uploadBtnBy).click();

        String expected = "File Uploaded!";
        String actual = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actual, expected);
    }



    @Test
    public void test8 (){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.cssSelector("#myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("[value='Submit']")).click();
        WebElement select = driver.findElement(By.id("result"));
        Assert.assertTrue(select.isDisplayed());
        String expected = "You selected: United States of America";
        String actual = select.getText();
        Assert.assertEquals(actual, expected);

    }



    @BeforeMethod
    public void setUp (){
        driver= BrowserFactory.getDriver("chrome");


        wait=new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
