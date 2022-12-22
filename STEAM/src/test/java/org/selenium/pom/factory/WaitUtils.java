package org.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.base.Browser;

import java.time.Duration;

public class WaitUtils {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static ExpectedCondition<WebElement> condition;

    public WaitUtils(){

    }
    public static WebDriverWait getWait(){
        driver= Browser.getDriver();
        return wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
}
