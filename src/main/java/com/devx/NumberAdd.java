package com.devx;

import java.util.Arrays;

public class NumberAdd implements OperationStrategy {

    public Number execute(Number a, Number b) {
        //length of the array, where the result will be stored
        int length;

        //counting length of the resulting array
        if(a.value.length > b.value.length){
            length = a.value.length + 1;
        }else{
            length = b.value.length + 1;
        }

        Number res = new Number(b.value, length+1);

        //addition
        for(int i=0; i<length; ++i){
            //res.value[i] += a.value[i];
            res.value[i] += (a.value.length > i)?a.value[i]:0;
            res.value[i+1] += (res.value[i] / res.radix);
            res.value[i] %= res.radix;
        }

        //cut the first digit if it is zero, i.e. 0144
        /*if(res.value[res.value.length-1]==0){
            res.value = Arrays.copyOfRange(res.value, 0, res.value.length);
        }*/
        int zeros=0;
        for(int i=res.value.length-1; i>0; --i){
            if(res.value[i]!=0) break;
            zeros++;
        }

        return  new Number(Arrays.copyOfRange(res.value, 0, res.value.length-zeros), res.value.length-zeros);
    }
}
