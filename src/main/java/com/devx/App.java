package com.devx;

public class App 
{
    public static void main( String[] args )
    {
        //Just for testing sake. TODO:get rid of it
        NumberContext context = new NumberContext();
        context.setStrategy(new NumberAdd());
        context.setShortStrategy(new NumberDivisionOnShort());
        //Number res = context.executeStrategy(new Number("-10"), new Number("-6"));
        //context.setBooleanStrategy(new NumberLessComparison());
        //boolean resbool = context.executeBooleanStrategy(new Number("2"), new Number("6"));
        Number res = context.executeOperationWithShortStrategy(new Number(11), -5);
   }
}
