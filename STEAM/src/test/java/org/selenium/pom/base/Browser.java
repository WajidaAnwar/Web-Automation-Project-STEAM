package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class Browser {
    public static WebDriver driver;
    protected ExpectedCondition<WebElement> condition;
    public static WebDriver getDriver(){

        if(driver==null){
            driver= new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver=null;
    }
}
