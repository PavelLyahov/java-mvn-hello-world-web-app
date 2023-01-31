package com.dev3l.hello_world.test;

import org.junit.Assert;
import org.junit.Test;
import utils.User;

public class TestEqualsWithoutHashCode {

    @Test
    public static void testEqualsWithoutHashCode() {
        User user = new User("Jack");
        Assert.assertEquals(new User("Jack"), user);
    }
}
