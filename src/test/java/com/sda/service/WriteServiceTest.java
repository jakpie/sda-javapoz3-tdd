package com.sda.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * Created by Szymon on 2017-08-28.
 */
public class WriteServiceTest {

    private WriteService writeService;

    @Before
    public void init() {
        writeService = new WriteService();
    }

    @Test
    public void shouldReturnMessageWithGivenName() {
        String givenName = "Szymon";
        String actualValue = writeService.action(givenName);
        String expectedValue = "Hello, " + givenName;

        Assert.assertEquals("Messages are not the same", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageWithNameAsNull() {
        String givenValue = null;
        String actualValue = writeService.action(givenValue);
        String expectedValue = "Hello, my friend";

        Assert.assertEquals("Messages are not the same", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageWithGivenEmptyName() {
        String givenValue = "";
        String actualValue = writeService.action(givenValue);
        String expectedValue = "Hello, my friend";

        Assert.assertEquals("Messages are not the same", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnShoutMessageWithGivenCapitalName() {
        String givenValue = "ANNA";
        String expectedValue = "HELLO, ANNA!";
        String actualValue = writeService.action(givenValue);

        Assert.assertEquals("Message not correct for the capital name",
                expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageWithGivenNameFilledWithSpaces() {
        String givenValue = "    ";
        String expectedValue = "Hello, my friend";
        String actualValue = writeService.action(givenValue);

        Assert.assertEquals("Message is not correct", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageForGivenMultipleNames() {
        String givenValue = "Jon,Martin,Ela";
        String expectedValue = "Hello, Jon, Martin and Ela";
        String actualValue = writeService.action(givenValue);

        Assert.assertEquals("Message for given values is invalid",
                expectedValue, actualValue);
//        name = "Jon,Martin,Ela" -> "Hello, Jon, Martin and Ela"
//        name = "Jon, Martin, Ela" -> "Hello, Jon, Martin and Ela"
    }

    @Test
    public void shouldReturnShoutMessageForGivenCapitalNames() {
        String givenValues = "JON,MARTIN,ELA";
        String expectedValue = "HELLO, JON, MARTIN and ELA!";
        String actualValue = writeService.action(givenValues);

        Assert.assertEquals("No shout or incorrect message", expectedValue, actualValue);
    }

//    @Test
    private void clientTest() {
        Assert.assertEquals("Hello, Bob", writeService.action("Bob"));
        Assert.assertEquals("Hello, my friend", writeService.action(null));
        Assert.assertEquals("Hello, my friend", writeService.action(""));
        Assert.assertEquals("Message for given values is invalid",
                "HELLO, JON, MARTIN and ELA!", writeService.action("JON,MARTIN,ELA"));
    }


}
