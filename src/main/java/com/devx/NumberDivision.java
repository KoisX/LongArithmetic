package com.devx;

public class NumberDivision implements OperationStrategy {
    @Override
    public Number execute(Number a, Number b) {
        //change isNeg when implementin signed operations
        Number res =  new Number(a.value.length, false);
        Number curValue =  new Number(a.value.length, false);
        for(int i = a.value.length-1; i>=0; --i){

        }

        //заглушка
        return  new Number();
    }
}
