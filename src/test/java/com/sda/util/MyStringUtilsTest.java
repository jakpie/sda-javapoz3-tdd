package com.sda.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Szymon on 2017-08-28.
 */
public class MyStringUtilsTest {

    @Test
    public void shouldReturnValueWithCapitalLetters() {
        String givenValue = "ALA MA KOTA";
        boolean result = MyStringUtils.isUpperCase(givenValue);

        Assert.assertTrue("Expected value contains lower cases", result);
    }

    @Test
    public void shouldReturnFalseForValueWithLowerCases() {
        String givenValue = "ala ma kota";
        boolean result = MyStringUtils.isUpperCase(givenValue);

        Assert.assertFalse("Result is true", result);
    }

    @Test
    public void shouldReturnFalseForMixCaseValue() {
        String givenValue = "AlA ma KoTa";
        boolean result = MyStringUtils.isUpperCase(givenValue);

        Assert.assertFalse("Result is true", result);
    }

    @Test
    public void shouldReturnFalseForNullValue() {
        String givenValue = null;
        boolean result = MyStringUtils.isUpperCase(givenValue);

        Assert.assertFalse("Result is true", result);
    }
}
