package org.selenium.pom.factory;

import org.selenium.pom.base.Browser;

public class DriverUtil extends Browser{

    public static void openUrl(String url){
        Browser.getDriver().navigate().to(url);
    }
    public static void navigateTo(String url){
        Browser.getDriver().navigate().to(url);

    }
    public static void refreshPage(){
        Browser.getDriver().navigate().refresh();
    }
    public static void goToPreviousPage(){
        Browser.getDriver().navigate().back();
    }
}
