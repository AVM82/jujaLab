package com.AVM.lab38;

/**
 * Created by AVM on 15.07.2016.
 */
public class TryAgainException extends Exception {
    public int tryAgain(int count){

        return --count;

    }


}
