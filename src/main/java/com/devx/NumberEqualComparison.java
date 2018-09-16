package com.devx;

/*
* Implemented for signed comparisons
* */
public class NumberEqualComparison implements BooleanStrategy {

    //check if a==b --> true
    @Override
    public boolean execute(Number a, Number b) {
        if(a.value.length != b.value.length)
            return false;
        if(a.isNegative != b.isNegative){
            return false;
        }
        for (int i = 0; i < a.value.length; ++i) {
            if (a.value[i] > b.value[i]) {
                return false;
            }
        }
        return true;
    }
}
