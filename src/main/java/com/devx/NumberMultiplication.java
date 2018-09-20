package com.devx;

import java.util.Arrays;

public class NumberMultiplication implements OperationStrategy {

    @Override
    public Number execute(Number a, Number b) {
        int length = a.value.length + b.value.length + 1;
        Number temp = new Number(length, false);
        for(int i=0; i<a.value.length; ++i){
            for(int j=0; j<b.value.length; ++j){
                temp.value[i+j] += a.value[i] * b.value[j];
            }
        }
        for(int k=0; k<length-1; ++k){
            temp.value[k+1] += temp.value[k]/Number.radix;
            temp.value[k] %= Number.radix;
        }

        /*
        Find the sign of the result
        we'll use boolean algebra simpleficvation
        of the expression !(a.isNegative ^ b.isNegative)
        */
        temp.setSign(a.isNegative == b.isNegative);

        //cut the first digit if it is zero, i.e. 0144
        int zeros=0;
        for(int i=temp.value.length-1; i>0; --i){
            if(temp.value[i]!=0) break;
            zeros++;
        }

        return  new Number(Arrays.copyOfRange(temp.value, 0, temp.value.length-zeros), temp.value.length-zeros, temp.isNegative);
    }
}
