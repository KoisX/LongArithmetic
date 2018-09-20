package com.devx;

public class NumberMultiplicationOnShort implements OperationWithShortStrategy {
    @Override
    public Number execute(Number a, int n) {
        Number res = new Number(a.value.length, false);
        int r=0;
        for(int i=0; i<res.value.length /*| (r!=0)*/; ++i){
            res.value[i]  =a.value[i] * Math.abs(n) + r;
            r = res.value[i]/Number.radix;
            res.value[i] -= r * Number.radix;
        }
        /*
        Find the sign of the result
        we'll use boolean algebra simpleficvation
        of the expression !(a.isNegative ^ b.isNegative)
        */
        res.setSign(a.isNegative == (n<0));

        //if(res.value[res.value.length]!=0){
           // res = new Number(Arrays.copyOfRange(res.value, 0, res.value.length-1), res.value.length-1,res.isNegative);
        //}

        return res;
    }
}
