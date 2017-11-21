package by.tc.parsing.controller.validator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cplus on 21.11.2017.
 */
public class PageParamValidatorTest {
    @Test
    public void isValidPageParam1() throws Exception {
        boolean actual = PageParamValidator.isValidPageParam("12",15);
        Assert.assertTrue(actual);
    }
    @Test
    public void isValidPageParam2() throws Exception {
        boolean actual = PageParamValidator.isValidPageParam("45",15);
        Assert.assertFalse(actual);
    }
    @Test
    public void isValidPageParam3() throws Exception {
        boolean actual = PageParamValidator.isValidPageParam("-12",15);
        Assert.assertFalse(actual);
    }
    @Test
    public void isValidPageParam4() throws Exception {
        boolean actual = PageParamValidator.isValidPageParam("1d6",15);
        Assert.assertFalse(actual);
    }
    @Test
    public void isValidPageParam5() throws Exception {
        boolean actual = PageParamValidator.isValidPageParam("0",15);
        Assert.assertFalse(actual);
    }

}