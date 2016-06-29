package com.AVM.lab37;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by AVM on 29.06.2016.
 */
public class StringUtilsTest {

    @Test
    public void test1(){

        assertEquals(StringUtils.rightShift("ABCDE", 3), "CDEAB");

    }

    @Test
    public void test2(){

        assertEquals(StringUtils.rightShift("ABCDE", 0), "ABCDE");

    }

    @Test
    public void test3(){

        assertEquals(StringUtils.rightShift("ABCDE", 1), "EABCD");

    }

    @Test
    public void test4(){

        assertEquals(StringUtils.rightShift("ABCDE", 7), "DEABC");

    }
    @Test
    public void test5(){

        assertEquals(StringUtils.rightShift("ABCDE", 6), "EABCD");

    }
    @Test
    public void test6(){

        assertEquals(StringUtils.rightShift("ABCDE", 7), "DEABC");

    }
    @Test
    public void test7(){

        assertEquals(StringUtils.rightShift("ABCDE", -2), "CDEAB");

    }
    @Test
    public void test8(){

        assertEquals(StringUtils.rightShift("ABCDE", -7), "CDEAB");

    }
    @Test
    public void test9(){

        assertEquals(StringUtils.rightShift("ABCDE", -1), "BCDEA");

    }
    @Test
    public void test10(){

        assertEquals(StringUtils.rightShift("ABC", 100), "CAB");

    }
    @Test
    public void test11(){

        assertEquals(StringUtils.rightShift("", -1000000), "");

    }
    @Test
    public void test12(){

        assertEquals(StringUtils.rightShift("0123456789", Integer.MIN_VALUE), "8901234567");

    }




}
