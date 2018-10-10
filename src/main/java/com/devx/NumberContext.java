package com.devx;

/*
* The program algorithm is
* implemented using Strategy pattern
*/
public class NumberContext {
    private OperationStrategy strategy;
    private BooleanStrategy booleanStrategy;
    private OperationWithNumber shortStrategy;

    public NumberContext(){

    }

    public void setStrategy(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setShortStrategy(OperationWithNumber strategy) {
        this.shortStrategy = strategy;
    }

    public void setBooleanStrategy(BooleanStrategy booleanStrategy){
        this.booleanStrategy = booleanStrategy;
    }

    public Number executeStrategy(Number a, Number b){
        return strategy.execute(a,b);
    }

    public Number executeStrategy(Number a, Number b, int n){
        return strategy.execute(a,b, n);
    }

    public boolean executeBooleanStrategy(Number a, Number b){
        return booleanStrategy.execute(a,b);
    }

    public Number executeOperationWithShortStrategy(Number a, int n){
        return shortStrategy.execute(a,n);
    }

    public Number executeOperationWithShortStrategy(Number a, int n, int mod){
        return shortStrategy.execute(a,n, mod);
    }
}

