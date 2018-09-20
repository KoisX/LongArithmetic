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

    private static final Object[] getNumbers(){
        return $(
            $(2,5),
            $(5,2),
            $(-2,3),
            $(15,4),
            $(0,0),
            $(-2,9),
            $(-9,2),
            $(2,-7),
            $(7,-2),
            $(19,1),
            $(5,5),
            $(-2, 30),
            $(30, -2),
            $(-2,-7),
            $(-7,-2)
        );
    }

    @Test
    @Parameters(method="getNumbers")
    public void operationMinus(int a, int b){
        NumberContext ctx = new NumberContext();
        ctx.setStrategy(new NumberSubstract());
        int exp = a-b;
        int res = Integer.parseInt(ctx.executeStrategy(new Number(a),new Number(b)).toString());
        assertTrue("Expected "+exp+" got "+res,exp==res);
    }

    @Test
    @Parameters(method="getNumbers")
    public void operationLessComparison(int a, int b){
        NumberContext ctx = new NumberContext();
        ctx.setBooleanStrategy(new NumberLessComparison());
        boolean exp = a<b;
        boolean res = ctx.executeBooleanStrategy(new Number(a),new Number(b));
        assertTrue("Expected "+exp+" got "+res,exp==res);
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
