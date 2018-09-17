package com.devx;

import java.util.Arrays;

public class NumberSubstract implements OperationStrategy {

    @Override
    public Number execute(Number a, Number b) {

        //case when answer is equal to zero
        if(a.value[0]==0 || b.value[0]==0)
            return new Number(0);

        /*In this section we will take into account
         * different signs of operands*/
        NumberContext ctx = new NumberContext();
        Number res;
        ctx.setBooleanStrategy(new NumberGreaterComparison());
        ctx.setStrategy(new NumberAdd());
        if(a.isNegative ^ b.isNegative){
            if(a.isNegative){
                a.setPositive();
                res = ctx.executeStrategy(a,b);
                res.setNegative();
                a.setNegative();
                return res;
            }else{//case when b is negative
                b.setPositive();
                res = ctx.executeStrategy(a,b);
                b.setNegative();
                return res;
            }
        }else if(a.isNegative & b.isNegative){
            a.setPositive();
            b.setPositive();

            //TODO:refactor res = ...
            if(ctx.executeBooleanStrategy(a,b)){
                //case when a is greater then b absolutely
                a.setNegative();
                res = ctx.executeStrategy(b, a);
            }else{
                //case when b is greater then a absolutely
                b.setNegative();
                res = ctx.executeStrategy(b,a);
            }

            if(!a.isNegative) a.setNegative();
            if(!b.isNegative) b.setNegative();
            return res;
        }

        //this code will be reached only in case when both operands are positive

        res = new Number(a.value, a.value.length + 1, a.isNegative);
        Number bNew = new Number(b.value, Math.max(a.value.length + 1, b.value.length + 1 ), b.isNegative);
        for(int i=0; i<res.value.length; ++i){
            res.value[i] -= bNew.value[i];
            if(res.value[i]<0){
                res.value[i] += Number.radix;
                res.value[i+1]--;
            }
        }
        int zeros = 0;
        for (int i = res.value.length - 1; i > 0; --i) {
            if (res.value[i] != 0) break;
            zeros++;
        }

        return new Number(Arrays.copyOfRange(res.value, 0, res.value.length - zeros), res.value.length - zeros, res.isNegative);
    }


}
