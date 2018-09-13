package com.devx;

public class Number {
    //Digits are stored in VALUE from right to left
    public int[] value;//Array of number digits
    public boolean isNegative;
    public static final int radix = 10;

    public Number(){
        /*
        * value is set null by default,
        * isNegative is set 0 by default
        * */
    }

    //deep cloning
    public Number(Number old){
        this.value = new int[old.value.length];
        this.isNegative = old.isNegative;
        for(int i=0; i<old.value.length; ++i){
            this.value[i] = old.value[i];
        }
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

    /*
    Initialize Number with an array of len length
    and fill it with values from v (free space may appear)
    */
    public Number(int[] v, int len, boolean isNeg){
        if(len<v.length) {
            throw new IllegalArgumentException("Length parameter should be equal or greater then the length of the array ");
        }
        this.value = new int[len];
        this.isNegative = isNeg;
        for(int i=0;i<v.length; ++i){
            this.value[i] = v[i];
        }
    }

    public Number(int number){
        this(Integer.toString(number));
    }

    //TODO:after testing change modifier to private
    public boolean isNumber(String number){
        if(number.isEmpty()) return false;
        for(int i = 0; i < number.length(); i++) {
            if(i == 0 && number.charAt(i) == '-') {
                if(number.length() == 1) return false;
                else continue;
            }
            if(Character.digit(number.charAt(i),radix) < 0) return false;
        }
        return true;
    }

}
