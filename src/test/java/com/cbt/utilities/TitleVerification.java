package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {


    public static void main(String[] args) {

        List<String> urls = Arrays.asList
                        ("http://practice.cybertekschool.com/",
                         "http://practice.cybertekschool.com/dropdown",
                         "http://practice.cybertekschool.com/login");


        WebDriver driver=BrowserFactory.getDriver("chrome");
       for (String url: urls){
           driver.get(url);
           driver.manage().window().maximize();
           String expected = "Practice";
           System.out.print("Title test for " + url + " ");
           StartingUtility.verifyEquals(expected, driver.getTitle());

           String expectedURL = "http://practice.cybertekschool.com";
           String actual = driver.getCurrentUrl();
           if (actual.contains(expectedURL)){
           System.out.println("URL test PASSED for "+ url);
       }

        }
       driver.quit();

    }
}
