package com.devx;

import java.util.Arrays;

public class NumberDivisionOnShort implements OperationWithShortStrategy {
    @Override
    public Number execute(Number a, int n) {
        Number res = new Number(a.value.length, false);
        int remainder = 0, cur;
        for(int i = res.value.length-1; i>=0; --i){
            cur = remainder * Number.radix + a.value[i];
            res.value[i] = cur/n;
            remainder = cur % n;
        }
        if(res.value[res.value.length-1]==0 && res.value.length!=1)
            res = new Number(Arrays.copyOfRange(res.value, 0, res.value.length-1), res.value.length-1,res.isNegative);

        return res;
    }
}
