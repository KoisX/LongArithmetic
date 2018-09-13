package com.devx;

public class App 
{
    public static void main( String[] args )
    {
        NumberContext context = new NumberContext();
        context.setStrategy(new NumberAdd());
        Number res = context.executeStrategy(new Number("110"), new Number("50"));


    }
}
