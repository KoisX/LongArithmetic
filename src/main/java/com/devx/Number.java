package com.devx;

import java.lang.NumberFormatException;
import java.lang.IllegalArgumentException;

public class Number {
    //Digits are stored in VALUE from right to left
    private int[] value;//Array of number digits
    private boolean isNegative;

    public Number(){
        /*
        * value is set null by default,
        * isNegative is set 0 by default
        * */
    }

    public Number(String number){
        if(isNumber(number)){
            char firstChar = number.charAt(0);
            if(firstChar=='+' || firstChar=='-'){
                number = number.substring(1);
                if(firstChar=='-'){
                    isNegative = true;
                }
            }
            char[] digits = number.toCharArray();
            value = new int[digits.length];
            for(int i=0; i<digits.length; ++i){
                value[i] = Character.getNumericValue((digits[digits.length - (i + 1)]));
            }
        }
        else throw new IllegalArgumentException("Argument can't be casted to an integer");
    }

    public Number(int number){

    }

    private boolean isNumber(String number){
        try{
            int n = Integer.parseInt(number);
        }catch (NumberFormatException exc){
            return  false;
        }
        return true;
    }
}
