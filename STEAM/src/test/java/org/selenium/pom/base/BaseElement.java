package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.factory.WaitUtils;



public abstract class BaseElement {
    private  By locator;

public BaseElement(By loc){
    locator=loc;
}
    protected  WebElement find(){

        return WaitUtils.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public  boolean isDisplayed(){
        return find().isDisplayed();
    }
    public  void click(){
        find().click();
    }
    public  void sendText(String text){
        find().sendKeys(text);
    }

    public  String waitAndGetText(){
        return WaitUtils.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
    public String getGivenInputFromInputField(){
        return WaitUtils.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute("value");

    }

}

