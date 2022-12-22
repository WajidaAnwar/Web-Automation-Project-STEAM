package org.selenium.pom.factory;

import java.util.Random;
public class RandomUtil {

    static String STRING_ARRAY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String SPECIAL_SYMBOLS = "!@#$%*";

    public static String getString(int stringLength, boolean flag) throws Exception {

        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        if (stringLength < 0) {
            return new String("Error");
        }
        for (int i = 0; i < stringLength; i++) {

            if (flag == false) {
                int index = random.nextInt(STRING_ARRAY.length());
                char randomChar = STRING_ARRAY.charAt(index);
                sb.append(randomChar);
            } else {
                int index = random.nextInt(STRING_ARRAY.length());
                char randomChar = STRING_ARRAY.charAt(index);
                int indexS = random.nextInt(SPECIAL_SYMBOLS.length());
                char randomCharsp = SPECIAL_SYMBOLS.charAt(indexS);
                sb.append(randomChar);
                sb.append(randomCharsp);

            }
        }

        sb.setLength(stringLength);

        String randomString = sb.toString();
        return randomString;
    }

}