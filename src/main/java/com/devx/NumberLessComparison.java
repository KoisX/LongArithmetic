package com.devx;

public class NumberLessComparison implements BooleanStrategy {
    //check if a > b --> true
    @Override
    public boolean execute(Number a, Number b) {
        int length = a.value.length;
        if(a.value.length > b.value.length){
            return false;
        }
        else{
            if(a.value.length < b.value.length){
                return true;
            }
            else{
                for(int i=0; i<length; ++i){
                    if(a.value[i]>b.value[i]){
                        return false;
                    }
                    if(a.value[i]<b.value[i]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

