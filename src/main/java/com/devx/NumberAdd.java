package com.devx;

import java.util.Arrays;

public class NumberAdd implements OperationStrategy {

    public Number execute(Number a, Number b) {
        //length of the array, where the result will be stored
        int length;

        //TODO:виділять памяті на один елемент більше!
        Number res = new Number(b);

        //counting length of the resulting array
        if(a.value.length > b.value.length){
            length = a.value.length + 1;
        }else{
            length = b.value.length + 1;
        }

        //addition
        for(int i=0; i<length; ++i){
            res.value[i] += a.value[i];
            res.value[i+1] += (res.value[i] / res.radix);
            res.value[i] %= res.radix;
        }

        //cut the first digit if it is zero, i.e. 0144
        if(res.value[res.value.length-1]==0){
            res.value = Arrays.copyOfRange(res.value, 1, res.value.length-1);
        }

        return  res;
    }
}
