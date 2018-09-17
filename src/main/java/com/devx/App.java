package com.devx;

public class App 
{
    public static void main( String[] args )
    {
        //Just for testing sake. TODO:get rid of it
        NumberContext context = new NumberContext();
        context.setStrategy(new NumberMultiplication());
        Number res = context.executeStrategy(new Number("-6"), new Number("1"));
        //context.setBooleanStrategy(new NumberEqualComparison());
        //boolean resbool = context.executeBooleanStrategy(new Number("222"), new Number("222"));

   }
}
