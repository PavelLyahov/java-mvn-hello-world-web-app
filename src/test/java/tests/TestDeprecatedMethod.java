package tests;

import org.junit.Assert;
import org.junit.Test;
import utils.Util;

public class TestDeprecatedMethod {

    @Test
    public void testDeprecatedMethod() {
        Assert.assertEquals("deprecated", Util.depricatedMethod());
    }
}