package com.AVM.lab35;

import java.math.BigInteger;

/**
 *  Предположим, что мы работаем с полиномами и храним их в виде последовательности коэффициентов.
 *  То есть полином f = 1 * x*x*x + 2*x*x + 3*x + 4 представляем в виде [1, 2, 3, 4] точнее
 *  new BigInteger[] {
 *  new BigInteger("1"),
 *  new BigInteger("2"),
 *  new BigInteger("3"),
 *  new BigInteger("4"),
 *  }
 *  Полином f = 10 * x*x - 100 представляем в виде [10, 0, -100] точнее
 *
 *  new BigInteger[] {
 *  new BigInteger("10"),
 *  new BigInteger("0"),
 *  new BigInteger("-100"),
 *  }
 *  Реализовать вычисление полинома в точке, то есть нам, скажем, дают полином f = 2*x*x*x - 3*x в виде [2, 0, -3, 0] и точку 100, а мы должны вычислить 2*100*100*100 - 3*100 = 2000000 - 300 = 1999700
 *  Created by AVM on 16.06.2016.
 */

public class PolyUtils {
    public static BigInteger eval(BigInteger[] poly, BigInteger arg) {
        /*BODY*/
        BigInteger solution = new BigInteger("0") ;
        for (int i = 0; i < poly.length-1; i++) {
            solution = solution.add(getPart(poly.length - i, poly[i], arg));
        }

    return solution.add(poly[poly.length-1]);
    }

    private static BigInteger getPart(int index, BigInteger bigInteger, BigInteger arg) {
        BigInteger b = bigInteger;
        for (int i = 0; i < index-1; i++) {
            b= b.multiply(arg);
        }
        return b;
    }
}
