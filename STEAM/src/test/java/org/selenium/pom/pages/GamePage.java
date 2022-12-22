package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseForm;
import org.selenium.pom.elements.Button;
import org.selenium.pom.elements.Text;

import java.io.FileNotFoundException;

public class GamePage extends BaseForm {
    private static final Button addToCartButton= new Button(By.cssSelector("a[id='btn_add_to_cart_738119'] span"));
    private static final Text gameName= new Text(By.id("appHubAppName"));
    private static final Text gamePrice= new Text(By.cssSelector(".game_purchase_price.price"));
    public GamePage() throws FileNotFoundException {
        super(addToCartButton);
    }
    public String getGameName(){
        return gameName.waitAndGetText();
    }
    public String getGamePrice(){
        return gamePrice.waitAndGetText();
    }

}
