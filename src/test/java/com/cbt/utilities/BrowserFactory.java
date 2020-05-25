package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
    }


  public static WebDriver getDriver (String browserType){
      WebDriver driver = null;

      switch (browserType.toLowerCase()){
          case "chrome":
              WebDriverManager.chromedriver().setup();
              driver=new ChromeDriver();
              break;
          case "firefox":
              WebDriverManager.firefoxdriver().setup();
              driver=new FirefoxDriver();
              break;
          case "edge":
              WebDriverManager.edgedriver().setup();
              driver=new EdgeDriver();
          case "safari":
              return null;
      }
    return driver;
  }



}
