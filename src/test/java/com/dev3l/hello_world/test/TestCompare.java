package com.dev3l.hello_world.test;

import org.junit.Assert;
import org.junit.Test;
import utils.User;

public class TestCompare {

    @Test
    public static void testOverloadedCompareMethod() {
        Assert.assertEquals(1, new User().compareTo(1));
    }
}
