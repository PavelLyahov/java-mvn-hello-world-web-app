package com.dev3l.hello_world.Test___ffddve_de;

import org.junit.Test;
import utils.Util;


public class FailedTest {
    @Test
    public void doesntCompile() {
        try {  Util.depricatedMethod();}
        catch (Throwable t) {
            System.out.println("Catch error");
        }
        myPow(1, 2);
        Util.depricatedMethod();
        Util.depricatedMethod();
        Util.depricatedMethod();
    }

    public static int myPow(int num, int exponent) {
        //num = num * myPow(num, exponent - 1); // Noncompliant
        return 0;  // this is never reached
    }
}
