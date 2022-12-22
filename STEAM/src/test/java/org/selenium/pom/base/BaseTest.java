package org.selenium.pom.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void maximizeWindow(){
        Browser.getDriver().manage().window().maximize();
    }
    @AfterMethod
    public static void quit(){
        Browser.quitDriver();
    }
}
