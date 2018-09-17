package com.devx;

public class App 
{
    public static void main( String[] args )
    {
        //Just for testing sake. TODO:get rid of it
        NumberContext context = new NumberContext();
        context.setStrategy(new NumberAdd());
        Number res = context.executeStrategy(new Number("10000"), new Number("-10001"));
        //context.setBooleanStrategy(new NumberEqualComparison());
        //boolean resbool = context.executeBooleanStrategy(new Number("222"), new Number("222"));

   }
}
