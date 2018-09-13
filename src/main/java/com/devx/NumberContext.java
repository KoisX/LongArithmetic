package com.devx;

/*
* The program algorithm is
* implemented using Strategy pattern
*/
public class NumberContext {
    private OperationStrategy strategy;

    public NumberContext(){

    }

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public Number executeStrategy(Number a, Number b){
        return strategy.execute(a,b);
    }
}

