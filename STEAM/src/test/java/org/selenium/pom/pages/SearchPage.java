package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseForm;
import org.selenium.pom.elements.Button;

public class SearchPage extends BaseForm {

    public static Button searchButton=new Button(By.cssSelector("button[type='submit'] span"));

    public SearchPage() {
        super(searchButton);
    }

    public  boolean isSearchPageDisplayed(){
        return super.isPageOpen();

    }
    public void clickOnSearchButton(){
        searchButton.click();;
    }

}
