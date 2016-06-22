package com.AVM.lab35;

import java.math.BigInteger;

/**
 * Created by AVM on 16.06.2016.
 */
public class main35 {
    public static void main(String[] args) {
//        BigInteger[] x = {new BigInteger("2"), new BigInteger("0"), new BigInteger("-3"), new BigInteger("0")};
//        BigInteger[] x = {new BigInteger("1")};
//
//        System.out.println(PolyUtils.eval(x,new BigInteger("1")));
        BigInteger[] poly = {
                new BigInteger("1"),
                new BigInteger("0")
        };
        BigInteger arg = new BigInteger("2");
        BigInteger expected = new BigInteger("2");
        BigInteger actual = PolyUtils.eval(poly, arg);

        if (!expected.equals(actual)) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }



    }


