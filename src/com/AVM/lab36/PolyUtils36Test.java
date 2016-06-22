package com.AVM.lab36;


import org.junit.Test;

import java.math.BigInteger;

import static com.AVM.lab36.PolyUtils36.mul;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by AVM on 22.06.2016.
 *
 */
public class PolyUtils36Test {

    @Test
    public void test(){
        BigInteger[] res = {new BigInteger("2"), new BigInteger("-3"),new BigInteger("6"),
                new BigInteger("-7"),new BigInteger("9"),new BigInteger("-2"),new BigInteger("-10"),new BigInteger("14"),
                new BigInteger("0"),new BigInteger("-3")};

        BigInteger[] y = {new BigInteger("1"), new BigInteger("0"),new BigInteger("1"),new BigInteger("-2"),new BigInteger("0"),new BigInteger("3")};

        BigInteger[] x = {new BigInteger("2"), new BigInteger("-3"),new BigInteger("4"),new BigInteger("0"),new BigInteger("-1")};


        assertEquals(toString(mul(x,y)),"2-36-79-2-10140-3");

    }


    public String toString(BigInteger[] arr) {
        super.toString();
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i].toString();

        }
        return str;

    }
}
