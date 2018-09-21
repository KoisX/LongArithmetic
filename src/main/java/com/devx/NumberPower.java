package com.devx;

public class NumberPower implements OperationWithNumber {
    @Override
    public Number execute(Number a, int b) {
        if(b<=0){
            throw new IllegalArgumentException("Power must be > 0");
        }

        Number res = new Number(a);
        NumberContext ctx = new NumberContext();
        ctx.setStrategy(new NumberMultiplication());

        for(int i=0; i<b-1; ++i){
            res = ctx.executeStrategy(res, a);
        }

        return res;
    }
}
