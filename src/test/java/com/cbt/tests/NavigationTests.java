package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StartingUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {
        testInChrome();
        testInFirefox();
        testInEdge();
    }

    public static void testInChrome()    {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        String title = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String title2 = driver.getTitle();
        driver.navigate().back();
        StartingUtility.verifyEquals("Google", title);
        driver.navigate().forward();
        StartingUtility.verifyEquals("Etsy - Shop for handmade, " +
                "vintage, custom, and unique gifts for everyone", title2);

        driver.quit();

    }

    public static void testInFirefox (){
        WebDriver driver=BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        String title3 =driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String title4 = driver.getTitle();
        driver.navigate().back();
        StartingUtility.verifyEquals("Google", title3);
        driver.navigate().forward();
        StartingUtility.verifyEquals("Etsy - Shop for handmade, " +
                "vintage, custom, and unique gifts for everyone", title4);

        driver.quit();

    }

    public static void testInEdge(){
        WebDriver driver = BrowserFactory.getDriver("edge");
        driver.get("https://google.com");
        String title5=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String title6 = driver.getTitle();
        driver.navigate().back();
        StartingUtility.verifyEquals("Google", title5);
        driver.navigate().forward();
        StartingUtility.verifyEquals("Etsy - Shop for handmade, " +
                "vintage, custom, and unique gifts for everyone", title6);

        driver.quit();
    }




}
