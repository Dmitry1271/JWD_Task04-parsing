package by.tc.parsing.dao.parse.help.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cplus on 19.11.2017.
 */
public class TransformatorTest {
    @Test
    public void getEnumFromString() throws Exception {
        String expected = "GROWING_TIPS";
        String actual = Transformator.getEnumFromString(" growing-tips   ");
        Assert.assertEquals(expected, actual);
    }

}