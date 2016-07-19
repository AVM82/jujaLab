package com.AVM.lab38;

/**
 * Created by AVM on 15.07.2016.
 *
 *
**/
public class AccountManager {
    public static boolean transfer(Account[] accounts, int[] delta) {
        /*BODY*/
        for (int i = 0; i < accounts.length ; i++) {
            try {

                accounts[i].change(delta[i]);

            } catch (TryAgainException e) {

                i = e.tryAgain(i);


            } catch (BlockAccountException e) {

                e.blockAccount(accounts, delta, i);
                return false;
            }
        }

        return true;
    }

}

