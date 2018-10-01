package com.devx;

/*
* Class responsible for solving
* either systems of equations or
* single equations
* */
public class CongruenceSystemSolver {

    /**
     * General pattern ax = b (mod m)
     * @param A Number array
     * @param B Number array
     * @param M Number array
     * @param n int
     * @return
     */
    public static CongruenceResult solve(Number[] A, Number[] B, Number[] M, int n) throws SystemHasNoSolutionException{
        Number x = new Number(0);
        Number mod = new Number(1);

        final Number zero = new Number(0);

        NumberContext multEq, subtrLess, modulus, divGr, add;

        multEq = new NumberContext();
        multEq.setStrategy(new NumberMultiplication());
        multEq.setBooleanStrategy(new NumberEqualComparison());

        subtrLess = new NumberContext();
        subtrLess.setStrategy(new NumberSubstract());
        subtrLess.setBooleanStrategy(new NumberLessComparison());

        divGr = new NumberContext();
        divGr.setStrategy(new NumberDivision());
        divGr.setBooleanStrategy(new NumberGreaterComparison());

        modulus = new NumberContext();
        modulus.setStrategy(new NumberMod());

        add = new NumberContext();
        add.setStrategy(new NumberAdd());

        Number r1, r2, x1, x2, r, q, t, b;

        for(int i=0; i<n; ++i){

            r1 = multEq.executeStrategy(A[i], mod);
            r2 = M[i];
            x1 = new Number(1);
            x2 = new Number(0);
            r = new Number(1);

            while(multEq.executeBooleanStrategy(r, zero)){
                q = divGr.executeStrategy(r1, r2);
                t = subtrLess.executeStrategy(x1, multEq.executeStrategy(q, x2));
                x1 = new Number(x2);
                x2 = new Number(t);
                r = subtrLess.executeStrategy(r1, multEq.executeStrategy(q, r2));
                r1 = new Number(r2);
                r2 = new Number(r);
            }

            b = subtrLess.executeStrategy(B[i], multEq.executeStrategy(A[i], x));

            if(!multEq.executeBooleanStrategy(modulus.executeStrategy(b, r1) , zero)){
                throw new SystemHasNoSolutionException("Congruance system has no solution");
            }

            x = add.executeStrategy(x, multEq.executeStrategy(mod, multEq.executeStrategy(b, divGr.executeStrategy(x1, r1))));
            mod = multEq.executeStrategy(mod, divGr.executeStrategy(M[i], r1));

        }

        if(subtrLess.executeBooleanStrategy(x, zero)||(divGr.executeBooleanStrategy(x, mod)&&multEq.executeBooleanStrategy(x, mod))){
            x = subtrLess.executeStrategy(x, multEq.executeStrategy(mod, divGr.executeStrategy(x, mod)));
        }

        return new CongruenceResult(x, mod);
    }
}
