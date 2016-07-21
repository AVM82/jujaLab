package com.AVM.ReverseString;

import org.junit.Test;

import static com.AVM.ReverseString.ReverseString.reverseByArray;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by AVM on 20.07.2016.
 */
public class ReverseStringTest {

    @Test
    public void reverseString(){
        String candidate = "\uD852\uDDF0";
        assertEquals("\uD852\uDDF0",reverseByArray(candidate));

    }

}
