package com.devx;

public class App 
{
    public static void main( String[] args )
    {
        //Just for testing sake. TODO:get rid of it
        NumberContext context = new NumberContext();
        context.setStrategy(new NumberMultiplication());
        //Number res = context.executeStrategy(new Number("-6"), new Number("1"));
        context.setBooleanStrategy(new NumberLessComparison());
        boolean resbool = context.executeBooleanStrategy(new Number("2"), new Number("6"));

   }
}
