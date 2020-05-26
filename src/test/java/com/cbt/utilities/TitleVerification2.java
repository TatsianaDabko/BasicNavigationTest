package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {


    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://wayfair.com/", "https://walmart.com", "https://westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        for (String site: urls){
            driver.get(site);
            driver.manage().window().maximize();
            String title = driver.getTitle().replace(" ", "").toLowerCase();
            String url = driver.getCurrentUrl();
            if (url.equalsIgnoreCase(title)){
                System.out.println("Test PASSED for " + url  + "url contains "+ driver.getTitle());
            } else{
                System.out.println("test FAILED for " + url + "url does NOT contains "+ driver.getTitle());
                System.out.println();
            }


        }

        driver.quit();
    }
}
