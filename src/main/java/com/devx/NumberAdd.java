package com.devx;

import java.util.Arrays;

public class NumberAdd implements OperationStrategy {

    public Number execute(Number a, Number b) {
        /*In this section we will take into account
         * different signs of operands*/

        //one of them is +, another is -
        if (a.isNegative ^ b.isNegative) {
            NumberContext ctx = new NumberContext();
            Number res;
            ctx.setBooleanStrategy(new NumberGreaterComparison());
            ctx.setStrategy(new NumberSubstract());
            if(a.isNegative){
                a.setPositive();
                //if a is greater then b absolutely
                if(ctx.executeBooleanStrategy(a,b)){
                    res = ctx.executeStrategy(a,b);
                    res.setNegative();
                }else{
                    //if a is less then b absolutely
                    res = ctx.executeStrategy(b,a);
                }
                a.setNegative();
                return  res;
            }else{
                //if b is negative, but a is positive
                b.setPositive();
                //if a is greater then b absolutely
                if(ctx.executeBooleanStrategy(a,b)){
                    res = ctx.executeStrategy(b,a);
                }else{
                    //if a is less then b absolutely
                    res = ctx.executeStrategy(a,b);
                    res.setNegative();
                }
                b.setPositive();
                return res;

            }
        } else if (a.isNegative & b.isNegative) {
            //both operands are negative
            a.setPositive();
            b.setPositive();
            Number res = execute(a, b);
            a.setNegative();
            b.setNegative();
            res.setNegative();
            return res;
        }
        //case when both are positive

        //length of the array, where the result will be stored
        int length;

        //counting length of the resulting array
        if (a.value.length > b.value.length) {
            length = a.value.length + 1;
        } else {
            length = b.value.length + 1;
        }

        Number res = new Number(b.value, length + 1, b.isNegative);

        //addition
        for (int i = 0; i < length; ++i) {
            //res.value[i] += a.value[i];
            res.value[i] += (a.value.length > i) ? a.value[i] : 0;
            res.value[i + 1] += (res.value[i] / res.radix);
            res.value[i] %= res.radix;
        }

        //cut the first digit if it is zero, i.e. 0144
        int zeros = 0;
        for (int i = res.value.length - 1; i > 0; --i) {
            if (res.value[i] != 0) break;
            zeros++;
        }

        return new Number(Arrays.copyOfRange(res.value, 0, res.value.length - zeros), res.value.length - zeros, res.isNegative);
        }

}
