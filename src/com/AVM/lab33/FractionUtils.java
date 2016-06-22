package com.AVM.lab33;

import java.math.BigInteger;

/**
 * Created by AVM on 14.06.2016.
 *
 * Lab 33
 * Предположим, что мы работаем с дробями, представляя их как пару BigInteger-ов.
 * 2/3 будем представлять как BigInteger[] x = {new BigInteger("2"), new BigInteger("3")};
 * Реализовать метод, который обеспечивает - сложение дробей 1/3 + 1/3 = 2/3
 * 1/2 + 1/3 = 5/6 - итоговая дробь должна быть несократимой
 * 1/2 + 1/2 = 1/1 (а не 2/2) 2/3 - 1/6 = 1/2 (а не 3/6) 1/2 + (-1)/2 = 0/1 (а не 0/2)
 * --- P.S. Возможно, вам потребуется метод BigInteger.gcd().
 *
 */
public class FractionUtils {
    public static BigInteger[] sum(BigInteger[] x, BigInteger[] y) {
        /*BODY*/
        BigInteger denominator;
        denominator = getDenominator(x[1], y[1]);
        BigInteger[] sum = new BigInteger[2];
        sum[0] = x[0].multiply(denominator.divide(x[1])).add(y[0].multiply(denominator.divide(y[1])));
        sum[1] = denominator;
        BigInteger b = sum[0].gcd(sum[1]);
        sum[0] = sum[0].divide(b);
        sum[1] = sum[1].divide(b);
        return sum;
    }

    private static BigInteger getDenominator(BigInteger x, BigInteger y){
        BigInteger biggest = getBiggestBigInteger(x,y);
        BigInteger denominator = biggest;

        while ((denominator.remainder(x).floatValue() != 0) || (denominator.remainder(y).floatValue() != 0)){
            denominator = denominator.add(biggest);
        }
        return denominator;
    }

    private static BigInteger getBiggestBigInteger(BigInteger x, BigInteger y) {
        BigInteger biggest;
        if (x.compareTo(y) > 0){
            biggest = x;
        }
        else{
            biggest = y;
        }
        return biggest;
    }

}
