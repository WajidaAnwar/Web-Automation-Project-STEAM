package org.selenium.pom.base;

public abstract class BaseForm{


    private final BaseElement uniqueElement;
    public BaseForm(BaseElement uniq){
        uniqueElement=uniq;
    }

    public  boolean isPageOpen(){
        return uniqueElement.isDisplayed();
    }



}
