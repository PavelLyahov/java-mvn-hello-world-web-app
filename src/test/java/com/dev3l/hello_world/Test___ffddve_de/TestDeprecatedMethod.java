package com.dev3l.hello_world.Test___ffddve_de;

import org.junit.Assert;
import org.junit.Test;
import utils.Util;

public class TestDeprecatedMethod {

    @Test
    public void testDeprecatedMethod() {
        Assert.assertEquals("deprecated", Util.depricatedMethod());
    }
}
