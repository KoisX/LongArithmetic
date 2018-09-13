package com.devx;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static  org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class NumberTest {

    private static final Object[] getCharacs(){
        return $(
          $("12345"),
          $("-38485"),
          $("0"),
          $("-99999999999999999999999999999999999999999999999999999999999999999999999")
        );
    }

    private static final Object[] getWrongNumber(){
        return $(
            $("123a5"),
            $("a94614917644379"),
            $("123912639127373872361923.9"),
            $("123-22")
        );
    }

    @Test
    @Parameters(method="getCharacs")
    public void characterIsTrue(String n){
        Number number = new Number(n);
        assertEquals(true, number.isNumber(n));
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getWrongNumber")
    public void characterIsFalse(String n){
        Number number = new Number(n);
        assertFalse(number.isNumber(n));
    }
}
