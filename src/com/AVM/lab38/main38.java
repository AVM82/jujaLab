package com.AVM.lab38;

import java.util.Arrays;

/**
 * Created by AVM on 19.07.2016.
 */

public class main38 {
    public static void main(String[] args) {
        Account[] testAccounts = new Account[3];
        int[] testDelta = {100, 343, 245};
        int[] amountArray = {10, 5, 25};
        for (int i = 0; i < testAccounts.length; i++) {
            testAccounts[i] = new Account(amountArray[i]) {
                @Override
                public void change(int delta) throws TryAgainException, BlockAccountException {
                    amount = amount + delta;
                }
            };
        }

        System.out.println(AccountManager.transfer(testAccounts, testDelta));
    }
}
