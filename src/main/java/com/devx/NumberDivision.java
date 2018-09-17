package com.devx;

public class NumberDivision implements OperationStrategy {
    @Override
    public Number execute(Number a, Number b) {
        return new Number(

        );
    }

    private void levelUp(Number n){
        for(int i=n.value.length; i>=1; --i ){
            n.value[i] = n.value[i-1];
        }

    }
}
