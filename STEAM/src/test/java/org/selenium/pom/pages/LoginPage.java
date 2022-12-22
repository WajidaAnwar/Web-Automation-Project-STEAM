package org.selenium.pom.pages;
import org.openqa.selenium.By;
import org.selenium.pom.base.BaseForm;
import org.selenium.pom.elements.Button;
import org.selenium.pom.elements.Input;
import org.selenium.pom.elements.Text;

public class LoginPage extends BaseForm {
    private static final Button signInButton= new Button(By.cssSelector("button[type='submit']"));
    private static final Input inputAccountNameFld= new Input(By.cssSelector("div[class='newlogindialog_TextField_2KXGK'] input[type='text']"));
    private static final Input inputPasswordFld= new Input(By.cssSelector("input[type='password']"));
    private static final Text errorMsgForInvalidLogin= new Text(By.cssSelector(".newlogindialog_FormError_1Mcy9"));
    private static final Button loadingPopUpForSignIn= new Button(By.cssSelector(".newlogindialog_LoadingContainer_OYHj3"));

    public LoginPage(){
        super(signInButton);
    }
    public boolean isLoginPageOpen(){
        return super.isPageOpen();
}
    public void clickSignInButton(){
        signInButton.click();
    }
    public void sendTextInAccountNameFld(String text){
        inputAccountNameFld.sendText(text);

    }

    public void sendTextInPasswordFld(String text){
        inputPasswordFld.sendText(text);

    }
    public boolean checkIfErrorMessageIsDisplayed(){
        return errorMsgForInvalidLogin.isDisplayed();
    }
    public boolean checkIfLoadingPopUpIsDisplayedWhileSignIn(){
        return loadingPopUpForSignIn.isDisplayed();
    }
}
