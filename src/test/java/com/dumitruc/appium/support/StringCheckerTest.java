package com.dumitruc.appium.support;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dima on 08/02/2014.
 */
public class StringCheckerTest {

    @Test
    public void parseTransactionId() {

        Pattern pattern = Pattern.compile("^.*Transaction ID:+(\\S*)\\..*");
        Matcher matcher = pattern.matcher("Transaction ID:ABVGD.");

        int i = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println("Parsed size: " + matcher.groupCount());
            System.out.println("Parsed string: " + matcher.group(1));
            i++;
            System.out.println("==>" + i);
        }
    }
}
