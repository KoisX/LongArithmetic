package com.devx;

public class NumberDivision implements OperationStrategy {
    @Override
    public Number execute(Number a, Number b) {
        NumberContext ctx = new NumberContext();
        NumberContext ctxEqual = new NumberContext();
        ctxEqual.setBooleanStrategy(new NumberEqualComparison());
        ctx.setShortStrategy(new NumberMultiplicationOnShort());
        ctx.setBooleanStrategy(new NumberLessComparison());
        ctx.setStrategy(new NumberSubstract());

        Number res = new Number(a.value.length, false);
        Number curValue = new Number(a.value.length, false);
        Number cur;

        int x,l,r, m;

        for(int i=a.value.length-1; i>=0; --i){
            curValue = ctx.executeOperationWithShortStrategy(curValue, Number.radix);
            curValue.value[0] = a.value[i];

            x=0; l=0; r= Number.radix;

            while(l<=r){
                m = (l+r)>>1;
                cur = ctx.executeOperationWithShortStrategy(b, m);
                if (ctx.executeBooleanStrategy(cur, curValue) || ctxEqual.executeBooleanStrategy(cur, curValue)) {
                    x = m;
                    l = m+1;
                }else{
                    r = m-1;
                }
            }

            res.value[i] = x;
            curValue = ctx.executeStrategy(curValue, ctx.executeOperationWithShortStrategy(b, x));

        }
        return res;
    }

}
