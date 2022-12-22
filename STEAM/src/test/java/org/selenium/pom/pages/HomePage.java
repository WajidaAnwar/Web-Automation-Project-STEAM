package org.selenium.pom.pages;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BaseForm;
import org.selenium.pom.base.Browser;
import org.selenium.pom.elements.Button;
import org.selenium.pom.elements.Input;
import org.selenium.pom.elements.Text;
import org.selenium.pom.factory.WaitUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class HomePage extends BaseForm {

    private static final Button loginBtn= new Button(By.cssSelector("a[class='global_action_link']"));
    private static final Button communityPageButton= new Button(By.xpath("//a[normalize-space()='COMMUNITY']"));
    private static final Button aboutPageButton= new Button(By.xpath("//a[normalize-space()='ABOUT']"));
    private static final Button supportPageButton= new Button(By.xpath("//a[normalize-space()='SUPPORT']"));
    private static final Button homePageSearchButton= new Button(By.cssSelector("a[id='store_search_link'] img"));
    private static final Input searchField= new Input(By.cssSelector("#store_nav_search_term"));
    private static final Text firstSearchResult= new Text(By.cssSelector("#search_suggestion_contents"));

    public HomePage() {
        super(searchField);
    }


    public boolean isHomePageOpen() {
        return super.isPageOpen();
    }
    public void clickOnHomePageSearchButton(){
        homePageSearchButton.click();

    }
    public void clickLoginBtn(){
        loginBtn.click();
    }


    public void goToCommunityPage() {
        communityPageButton.click();
    }

    public void goToAboutPage() {
        aboutPageButton.click();
    }

    public void goToSupportPage() {
        supportPageButton.click();
    }

    public void clickOnSearchField(){
        searchField.click();
    }

    public void sendText(String text) {

        searchField.sendText(text);
    }

    public String getTextFromSearchField(){
        return searchField.getGivenInputFromInputField();
    }

    public void clickOnFirstSearchElement(){
       WaitUtils.getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id='searchterm_options'] a:nth-child(1)"))).click();
    }
    public boolean searchResults(){

        String itext = firstSearchResult.waitAndGetText();

        File f = new File("savetxt.txt");
        try{
            FileUtils.writeStringToFile(f, itext, Charset.defaultCharset());
        }catch(IOException exc){
            exc.printStackTrace();
        }

        List<WebElement> vs = Browser.getDriver().findElements(By.cssSelector("#search_suggestion_contents"));

        if(vs.size()>=1){
            return true;
        }else{
            return false;
        }
    }
}


