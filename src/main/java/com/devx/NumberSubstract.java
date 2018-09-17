package com.devx;

public class NumberSubstract implements OperationStrategy {

    public Number execute(Number a, Number b) {
        Number res = new Number(a.value, a.value.length + 1, a.isNegative);
        Number bNew = new Number(b.value, a.value.length + 1, b.isNegative);
        for(int i=0; i<res.value.length; ++i){
            res.value[i] -= bNew.value[i];
            if(res.value[i]<0){
                res.value[i] += Number.radix;
                res.value[i+1]--;
            }
        }
        return res;
    }


}
