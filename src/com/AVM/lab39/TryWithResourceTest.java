package com.AVM.lab39;

import org.junit.*;
import org.junit.Test;

import static com.AVM.lab39.Test.*;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by AVM on 21.07.2016.
 */
public class TryWithResourceTest {

    @Test
    public void test1(){
        assertEquals("OK",firstTest());


    }
    @Test
    public void test2(){
        assertEquals("OK",secondTest());

    }
    @Test
    public void test3() throws Throwable {
        assertEquals("OK",thirdTest());

    }
    @Test
    public void test4() throws Throwable {
        assertEquals("OK",fourthTest());

    }

}

