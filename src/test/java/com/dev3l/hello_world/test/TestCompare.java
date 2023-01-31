package com.dev3l.hello_world.test;

import org.junit.Assert;
import org.junit.Test;
import utils.User;

public class TestCompare {

    @Test
    public void testOverloadedCompareMethod() {
        Assert.assertEquals(1, new User("Jack").compareTo(1));
    }
}
