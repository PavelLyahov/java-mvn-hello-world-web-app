package com.dev3l.hello_world.test;

import org.junit.Assert;
import org.junit.Test;
import utils.Util;

public class TestDeprecatedMethod {

    @Test
    public static void testDeprecatedMethod() {
        Assert.assertEquals("deprecated", Util.depricatedMethod());
    }
}
