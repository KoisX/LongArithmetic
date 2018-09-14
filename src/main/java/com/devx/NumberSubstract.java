package com.devx;

public class NumberSubstract implements OperationStrategy {

    public Number execute(Number a, Number b) {
        ComparAndLenRes resTemp = ComparisonAndLength(a,b);
        if(resTemp.k==NumberComparison.FIRST_IS_GREATER){
            return  difference(a,b, resTemp.len);
        }
        if(resTemp.k==NumberComparison.SECOND_IS_GREATER){
            return difference(b,a,resTemp.len);
        }
        //if numbers are equal
        return new Number(0);
    }

    private Number difference(Number x, Number y, int length){
        //!isNEg set to false
        //change when implementing signed operations

        //result
        Number z = new Number(length, false);
        for(int i=0; i<(length-1); ++i){
            if(i<(length-1)){
                x.value[i+1]--;
                z.value[i] += Number.radix + x.value[i];
            }else{
                z.value[i] += x.value[i];
            }

            z.value[i] -= y.value[i];

            if(z.value[i] / Number.radix > 0){
                z.value[i]++;
                z.value[i]%=Number.radix;
            }
        }

        return z;
    }

    private enum NumberComparison{
        FIRST_IS_GREATER,
        SECOND_IS_GREATER,
        ARE_EQUAL,
    }

    private ComparAndLenRes ComparisonAndLength(Number a, Number b){
        NumberComparison k = NumberComparison.ARE_EQUAL;
        int length = a.value.length;
        if(a.value.length > b.value.length){
            length = a.value.length;//WTF we need this line of code?
            k =  NumberComparison.FIRST_IS_GREATER;
        }
        else{
            if(a.value.length < b.value.length){
                length = b.value.length;
                k = NumberComparison.SECOND_IS_GREATER;
            }
            else{
                for(int i=0; i<length; ++i){
                    if(a.value[i]>b.value[i]){
                        k = NumberComparison.FIRST_IS_GREATER;
                        break;
                    }
                    if(a.value[i]<b.value[i]){
                        k= NumberComparison.SECOND_IS_GREATER;
                        break;
                    }
                }
            }
        }
        return new ComparAndLenRes(k, length);
    }

    private class ComparAndLenRes{
        private NumberComparison k;
        private int len;

        public ComparAndLenRes(NumberComparison n, int len){
            this.len = len;
            this.k = n;
        }

        public NumberComparison getK(){
            return  k;
        }

        public int getLen(){
            return len;
        }
    }
}
