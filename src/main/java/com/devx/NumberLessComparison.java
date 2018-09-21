package com.devx;

public class NumberLessComparison implements BooleanStrategy {
    //check if a > b --> true
    @Override
    public boolean execute(Number a, Number b) {

        if(a.isNegative!=b.isNegative){
            if(a.isNegative) return true;
            else return false;
        }

        //case when both number are negative
        if(a.isNegative && b.isNegative){
            int length = a.value.length;
            if(a.value.length > b.value.length){
                return true;
            }
            else{
                if(a.value.length < b.value.length){
                    return false;
                }
                else{
                    for(int i=0; i<length; ++i){
                        if(a.value[i]>b.value[i]){
                            return true;
                        }
                        if(a.value[i]<b.value[i]){
                            return false;
                        }
                    }
                }
            }
        }

        int length = a.value.length;
        if(a.value.length > b.value.length){
            return false;
        }
        else{
            if(a.value.length < b.value.length){
                return true;
            }
            else{
                for(int i=0; i<length; ++i){//з ыншого боку треба звырять!!!!!
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

