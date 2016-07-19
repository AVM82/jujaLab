package com.AVM.lab38;

/**
 * Created by AVM on 15.07.2016.
 */
public class BlockAccountException extends Exception {
    public void blockAccount(Account[] accounts, int[] delta, int count){
        for (int i = 0; i < count ; i++) {
            try {
                accounts[i].change(-delta[i]);
            } catch (Exception e) {
                System.out.printf("This should never happen!");
            }
        }



    }
}
