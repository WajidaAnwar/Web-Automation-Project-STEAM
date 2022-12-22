package org.selenium.pom.factory;

import org.selenium.pom.pages.AboutPage;

import static org.selenium.pom.pages.AboutPage.getNumberOfPlayersOnline;

public class StringUtils {
    public StringUtils(){

    }
    public static int numberOfOnlinePlayers(){
        String numberOfOnlineGamers_string= getNumberOfPlayersOnline().replaceAll("[^0-9.]", "");
        StringBuilder sbf = new StringBuilder("");
        sbf.append(numberOfOnlineGamers_string);
        int numberOfOnlineGamers= Integer.parseInt(String.valueOf(sbf));
        return numberOfOnlineGamers;
    }

    public static int numberOfInGamePlayers(){
        String numberOfInGamePlayers_string= AboutPage.getNumberOfPlayersInGame().replaceAll("[^0-9.]", "");
        StringBuilder sbf = new StringBuilder("");
        sbf.append(numberOfInGamePlayers_string);
        int numberOfInGamePlayers= Integer.parseInt(String.valueOf(sbf));
        return numberOfInGamePlayers;
    }
}
