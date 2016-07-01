package com.AVM.lab37;

/**
 * Created by AVM on 24.06.2016.
 */
public class main37 {
    public static void main(String[] args) {

        String s = "ABCDE";
        int offset = 3;

        System.out.println(s);

        System.out.println("Offset to right: "+ offset);

        System.out.println(StringUtils.rightShift(s, offset));


    }
}


