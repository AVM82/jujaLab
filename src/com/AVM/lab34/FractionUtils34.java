package com.AVM.lab34;

import java.math.BigInteger;

/**
 * Created by AVM on 14.06.2016.
 *
 * Lab 34
 *
 * Реализовать метод, который преобразует BigInteger в битовую строку (String из '0' и '1')
 * toBitStr(new BigInteger("2")) = "10" toBitStr(new BigInteger("8")) = "1000"
 * toBitStr(new BigInteger("10")) = "1010"
 * toBitStr(new BigInteger("140")) = "10001100"
 *
 */
public class FractionUtils34 {
    public static String toBitStr(BigInteger arg) {
        /*BODY*/
        return arg.toString(2);
    }
}
