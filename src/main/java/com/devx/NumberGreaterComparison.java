package com.devx;

public class NumberGreaterComparison implements BooleanStrategy {
    @Override
    //check if a > b --> true
    public boolean execute(Number a, Number b) {

        if(a.isNegative!=b.isNegative){
            if(a.isNegative) return false;
            else return true;
        }

        //case when both number are negative
        if(a.isNegative && b.isNegative){
            int length = a.value.length;
            if (a.value.length > b.value.length) {
                return false;
            } else {
                if (a.value.length < b.value.length) {
                    return true;
                } else {
                    for (int i = length-1; i >=0; --i) {
                        if (a.value[i] > b.value[i]) {
                            return false;
                        }
                        if (a.value[i] < b.value[i]) {
                            return true;
                        }
                    }
                }
            }
        }


        int length = a.value.length;
        if (a.value.length > b.value.length) {
            return true;
        } else {
            if (a.value.length < b.value.length) {
                return false;
            } else {
                for (int i = length-1; i >=0; --i) {
                    if (a.value[i] > b.value[i]) {
                        return true;
                    }
                    if (a.value[i] < b.value[i]) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
