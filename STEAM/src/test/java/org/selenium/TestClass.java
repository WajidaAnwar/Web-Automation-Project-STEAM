package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.factory.DriverUtil;
import org.selenium.pom.factory.RandomUtil;
import org.selenium.pom.factory.StringUtils;
import org.selenium.pom.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class TestClass extends BaseTest {
    @Test
    public void invalidLogin() throws Exception {
        //Navigate to main page
        DriverUtil.openUrl("https://store.steampowered.com/");

        //check if main page is open
        HomePage homePage= new HomePage();
        Assert.assertTrue(homePage.isHomePageOpen(),"Home page is not open");

        //click login button
        homePage.clickLoginBtn();

        //check if login page is open
        LoginPage loginPage=new LoginPage();
        Assert.assertTrue(loginPage.isLoginPageOpen());

        //Input random strings as credentials
        String text= RandomUtil.getString(5,false);
        loginPage.sendTextInAccountNameFld(text);
        String text1= RandomUtil.getString(5,false);
        loginPage.sendTextInPasswordFld(text1);

        //click sign in button
        loginPage.clickSignInButton();

        //check if loading element is displayed
        Assert.assertTrue(loginPage.checkIfLoadingPopUpIsDisplayedWhileSignIn());

        //check if error text is displayed
        Assert.assertTrue(loginPage.checkIfErrorMessageIsDisplayed());

    }

    @Test
    public void numberOfGamers(){
        //Navigate to main page
        DriverUtil.openUrl("https://store.steampowered.com/");

        //click on about button
        HomePage homePage= new HomePage();
        homePage.goToAboutPage();

        //check if about page is open
        AboutPage aboutPage=new AboutPage();
        Assert.assertTrue(aboutPage.isAboutPageOpen(),"About page is not open");

        //compare number of players online and ingame
        Assert.assertTrue(StringUtils.numberOfInGamePlayers() < StringUtils.numberOfOnlinePlayers(), "Number of ingame players is not less than number of online players as expected");

        //aboutPage.playerComparison();

        //click on store Button
        aboutPage.goToStorePage();

        //check if store page is open
        homePage.isHomePageOpen();
    }

    @Test
    public void gameInfo() throws IOException {
        //navigate to main page
        DriverUtil.openUrl("https://store.steampowered.com/");

        //check if main page is open
        HomePage homePage=new HomePage();
        homePage.isHomePageOpen();

        String stringInSearchField="Dark Jungle";
        homePage.sendText(stringInSearchField);


        //Check if list of search results is displayed
        Assert.assertTrue(homePage.searchResults(),"List of search result is not displayed as expected");

        //click on first game in the list
        homePage.clickOnFirstSearchElement();

        //check if game page is open
        GamePage gamePage= new GamePage();
        Assert.assertTrue(gamePage.isPageOpen(),"Game Page is not open");

        //check if displayed info is equal to saved info
        BufferedReader br = new BufferedReader(new FileReader("savetxt.txt"));
        String gameName= br.readLine();
        String gamePrice=br.readLine();
        Assert.assertEquals(gameName,gamePage.getGameName(),"Displayed and saved named are not same");
        Assert.assertEquals(gamePrice,gamePage.getGamePrice(),"Dispalyed and saved prices are not same");
    }

    }



