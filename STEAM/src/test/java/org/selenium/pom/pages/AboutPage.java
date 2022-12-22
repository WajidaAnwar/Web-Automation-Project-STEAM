
package org.selenium.pom.pages;

        import org.openqa.selenium.By;
        import org.selenium.pom.base.BaseForm;
        import org.selenium.pom.elements.Button;
        import org.selenium.pom.elements.Text;


public class AboutPage extends BaseForm {

    private static final Text onlineGamers= new Text(By.xpath("(//div[@class='online_stat'])[1]"));
    private static final Text inGamePlayers= new Text(By.xpath("(//div[@class='online_stat'])[2]"));
    private static final Button installSteamButton = new Button(By.cssSelector("div[id='about_greeting'] a[class='about_install_steam_link']"));
    private static final Button storePageButton= new Button(By.xpath("//a[normalize-space()='STORE']"));

    public AboutPage(){
        super(installSteamButton);
    }

    public void clickHelpButton(){
        installSteamButton.click();
    }

    public boolean isAboutPageOpen() {
        return super.isPageOpen();
    }

    public static String getNumberOfPlayersOnline(){
        return onlineGamers.waitAndGetText();

    }
    public static String getNumberOfPlayersInGame(){
        return inGamePlayers.waitAndGetText();

    }

    public void goToStorePage(){
        storePageButton.click();
    }

}




