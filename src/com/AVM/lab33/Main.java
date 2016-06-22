package com.AVM.lab33;

import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        BigInteger[] x = {new BigInteger("29"), new BigInteger("30")};
        BigInteger[] y = {new BigInteger("44"), new BigInteger("45")};

        FractionUtils fractionUtils = new FractionUtils();
        System.out.println(Arrays.toString(fractionUtils.sum(x,y)));



    }
}
