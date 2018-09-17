package com.devx;

import java.util.Arrays;

public class NumberSubstract implements OperationStrategy {

    @Override
    public Number execute(Number a, Number b) {
        Number res = new Number(a.value, a.value.length + 1, a.isNegative);
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
