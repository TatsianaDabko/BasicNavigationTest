package homeWork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class cybertekSchoolPractice {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp (){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDown (){
    driver.quit();
    }

    @Test
    public void test1 (){
        WebElement regForm = driver.findElement(By.linkText("Registration Form"));
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("arguments[0].scrollIntoView(true)", regForm);
        regForm.click();

        WebElement birthBtn = driver.findElement(By.name("birthday"));
        jsc.executeScript("arguments[0].scrollIntoView(true)", birthBtn);
        birthBtn.sendKeys("wrong_dob");
        String actual = driver.findElement(By.xpath("//small[text()= 'The date of birth is not valid']")).getText();
        String expected = "The date of birth is not valid";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2 (){
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        WebElement regForm = driver.findElement(By.linkText("Registration Form"));
        jsc.executeScript("arguments[0].scrollIntoView(true)", regForm);
        regForm.click();
        WebElement c = driver.findElement(By.xpath("//label[text()='C++']"));
        WebElement java = driver.findElement(By.id("inlineCheckbox2"));
        WebElement javaSc = driver.findElement(By.id("inlineCheckbox3"));
        Assert.assertTrue(c.isDisplayed());
        Assert.assertTrue(java.isDisplayed());
        Assert.assertTrue(javaSc.isDisplayed());

    }

    @Test
    public void test3(){
        WebElement regForm = driver.findElement(By.linkText("Registration Form"));
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("arguments[0].scrollIntoView", regForm);
        regForm.click();
        driver.findElement(By.name("firstname")).sendKeys("a");
        WebElement wrongName = driver.findElement(By. xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(wrongName.isDisplayed());

    }

    @Test
    public void test4 (){
        WebElement regForm = driver.findElement(By.linkText("Registration Form"));
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc.executeScript("arguments[0].scrollIntoView(true)", regForm);
        regForm.click();
        driver.findElement(By.name("lastname")).sendKeys("a");
        WebElement wronglastName = driver.findElement(By.xpath("//small[text() ='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(wronglastName.isDisplayed());

    }


    @Test
    public void test5 (){
        WebElement regForm = driver.findElement(By.linkText("Registration Form"));
        JavascriptExecutor jsc = (JavascriptExecutor) driver;
        jsc. executeScript("arguments[0].scrollIntoView(true)", regForm);
        regForm.click();
        WebElement firstName= driver.findElement(By.name("firstname"));
        firstName.sendKeys("Tanya");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Dabko");
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Chupasa");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("student@mail.ru");
        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys("12345qwe");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("215-554-1953");
        WebElement gender= driver.findElement(By.cssSelector("[value='female']"));
        gender.click();
        WebElement birth = driver.findElement(By.name("birthday"));
        birth.sendKeys("08/11/1982");
        WebElement deprtment = driver.findElement(By.name("department"));
        Select departList = new Select(deprtment);
        departList.selectByValue("MPDC");

        WebElement job = driver.findElement(By.name("job_title"));
        Select jobOptions = new Select(job);
        jobOptions.selectByVisibleText("SDET");
        WebElement java = driver.findElement(By.id("inlineCheckbox2"));
        java.click();
        WebElement submit = driver.findElement(By.xpath("//button[text()='Sign up']"));
        submit.click();

        WebElement message = driver.findElement(By.tagName("p"));
        wait.until(ExpectedConditions.visibilityOf(message));
        String expected = "You've successfully completed registration!";
        String actual = message.getText();
        Assert.assertEquals(actual, expected);


    }



}
