package com.devx;

import java.util.Scanner;

public class App
{
    private static int start = 1;
    private static int end = 12;
    private static NumberContext ctx = new NumberContext();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean exit = false;
    private static int choice;
    private static boolean modulus = false;

    public static void main( String[] args ) {
        System.out.println("\n'Long arithmetic calculator' by Igor Konobas 2018");
        while (true) {
            printOperations();
            getChoice();
            if(exit) return;
            calculate();
            if (!shouldContinue()) break;
        }
    }

    public static void printOperations(){
        System.out.println("Choose the operation:");
        System.out.println("1) Addition(+)");
        System.out.println("2) Subtraction(-)");
        System.out.println("3) Multiplication(*)");
        System.out.println("4) Division(/)");
        System.out.println("5) Remainder(%)");
        System.out.println("6) Power(^)");
        System.out.println("7) Square root integer([sqrt])");
        System.out.println("8) Less(<)");
        System.out.println("9) Greater(>)");
        System.out.println("10) Equal(==)");
        System.out.println("11) Solve system");
        System.out.println("12) EXIT");
    }

    public static void getChoice(){
        while(true){
            System.out.print("\nOperation["+start+";"+end+"]:");
            choice =  Integer.parseInt(scanner.nextLine());
            if(choice<start || choice>end){
                System.out.println("Incorrect input. Try again.");
                continue;
            }else{
                switch (choice){
                    case 1:
                        ctx.setStrategy(new NumberAdd());
                        break;
                    case 2:
                        ctx.setStrategy(new NumberSubstract());
                        break;
                    case 3:
                        ctx.setStrategy(new NumberMultiplication());
                        break;
                    case 4:
                        ctx.setStrategy(new NumberDivision());
                        break;
                    case 5:
                        ctx.setStrategy(new NumberMod());
                        break;
                    case 6:
                        ctx.setShortStrategy(new NumberPower());
                        break;
                    case 8:
                        ctx.setBooleanStrategy(new NumberLessComparison());
                        break;
                    case 9:
                        ctx.setBooleanStrategy(new NumberGreaterComparison());
                        break;
                    case 10:
                        ctx.setBooleanStrategy(new NumberEqualComparison());
                        break;
                    case 11:
                        break;
                    case 12:
                        exit = true;
                        break;
                }
                break;
            }
        }
    }

    public static void calculate(){
        Number a;
        Number b;
        int n;
        switch (choice){
            case 1://+
            case 2://-
            case 3://*
            case 4:// /
            case 5:// %
                a = getNumber("First ");
                b = getNumber("Second ");
                System.out.println("Result:"+ctx.executeStrategy(a,b));
                break;
            case 6:
                a = getNumber("First ");
                n = getInt("Second ");
                System.out.println("Result:"+ctx.executeOperationWithShortStrategy(a,n));
                break;
            case 7:
                a= getNumber("The ");
                System.out.println("Result:"+a.sqrt());
                break;
            case 8:
            case 9:
            case 10:
                a = getNumber("First ");
                b = getNumber("Second ");
                System.out.println("Result:"+ctx.executeBooleanStrategy(a,b));
                break;
            case 11:
                Number[] A = new Number[]{new Number(2), new Number(3), new Number(2)};
                Number[] B = new Number[]{new Number(2), new Number(2), new Number(4)};
                Number[] M = new Number[]{new Number(6), new Number(7), new Number(8)};
                try {
                    CongruenceResult res = CongruenceSystemSolver.solve(A, B, M , 3);
                    System.out.println("x="+res.val+" (mod "+res.modulus+")");
                } catch (SystemHasNoSolutionException e) {
                    System.out.println(e.getMessage());
                }


        }

    }

    public static Number getNumber(String name){
        System.out.print(name+" operand:");
        String s = scanner.nextLine();
        return new Number(s);
    }

    public static int getInt(String name){
        System.out.print(name+" operand:");
        return scanner.nextInt();
    }

    public static boolean shouldContinue(){
        System.out.println("Would you like to continue?");
        while(true){
            System.out.print("(Y/N):");
            String r = scanner.nextLine();
            if(!(r.equals("Y") || r.equals("y") || r.equals("n") || r.equals("N"))){
                System.out.println("Incorrect input. Try again.");
            }else{
                if(r.equals("Y") || r.equals("y")) return true;
                if(r.equals("n") || r.equals("N")) return false;
            }
        }

    }
}
