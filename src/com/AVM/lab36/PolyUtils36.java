package com.AVM.lab36;

import java.math.BigInteger;

/**
 * Created by AVM on 22.06.2016.
 *
 * Реализовать произведение полиномов,
 * то есть нам дают полиномы f1 = x + 1 в виде [1, 1] и f2 = x + 1 в виде [1, 1]
 * то мы должны вычислить (x + 1) * (x + 1) = x*x + 2*x + 1 в виде [1, 2, 1]
 * Есть нам дают полиномы f1 = 10*x*x + 1 в виде [10, 0, 1] и f2 = -x
 * в виде [-1, 0] то мы должны вычислить (10*x*x + 1) * (-x) = -10*x*x*x -x в виде [-10, 0, -1, 0]
 *
 */
public class PolyUtils36 {
    public static BigInteger[] mul(BigInteger[] x, BigInteger[] y) {
        /*BODY*/

        BigInteger[] mul = new BigInteger[x.length + y.length - 1];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                if (mul[j+i] == null){

                    mul[j+i] = x[i].multiply(y[j]);
                }
                else{

                    mul[j+i] = mul[j+i].add(x[i].multiply(y[j]));
                }
            }
        }


        return mul;
    }
}
