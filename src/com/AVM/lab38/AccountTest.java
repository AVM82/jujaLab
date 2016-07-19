package com.AVM.lab38;

/**
 * Created by AVM on 19.07.2016.
 */
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;


public class AccountTest {
    Account[] testAccounts = new Account[3];
    int[] testDelta = {100, 343, 245};
    int[] amountArray = {10, 5, 25};

    class NoException extends Account{

        public NoException(int amount) {
            super(amount);
        }

        @Override
        public void change(int delta) throws TryAgainException, BlockAccountException {
            amount = amount + delta;
        }
    }

    class BlockException extends Account{

        public BlockException(int amount) {
            super(amount);
        }

        @Override
        public void change(int delta) throws TryAgainException, BlockAccountException {
            throw new BlockAccountException();
        }
    }
    class TwoTryAgain extends Account{

        public TwoTryAgain(int amount) {
            super(amount);
        }

        public int countCall = 0;

        @Override
        public void change(int delta) throws TryAgainException, BlockAccountException {
            if (countCall < 2) {
                countCall++;
                throw new TryAgainException();
            } else {
                amount = amount + delta;
            }

        }
    }


    @Test
    public void noException(){

        for (int i = 0; i < testAccounts.length; i++) {
            testAccounts[i] = new NoException(amountArray[i]);
        }
        assertTrue(AccountManager.transfer(testAccounts,testDelta));
        assertEquals(110,testAccounts[0].getAmount());
        assertEquals(348,testAccounts[1].getAmount());
        assertEquals(270,testAccounts[2].getAmount());

    }
    @Test
    public void blockException(){

        for (int i = 0; i < testAccounts.length - 1; i++) {
            testAccounts[i] = new NoException(amountArray[i]);
        }
        testAccounts[2] = new BlockException(amountArray[2]);

        assertFalse(AccountManager.transfer(testAccounts,testDelta));
        assertEquals(10,testAccounts[0].getAmount());
        assertEquals(5,testAccounts[1].getAmount());
        assertEquals(25,testAccounts[2].getAmount());

    }
    @Test
    public void twoTryAgainException(){

        for (int i = 0; i < testAccounts.length - 1; i++) {
            testAccounts[i] = new NoException(amountArray[i]);
        }
        TwoTryAgain tryAgain = new TwoTryAgain(amountArray[2]);
        testAccounts[2] = tryAgain;

        assertTrue(AccountManager.transfer(testAccounts,testDelta));
        assertEquals(2,tryAgain.countCall);
        assertEquals(110,testAccounts[0].getAmount());
        assertEquals(348,testAccounts[1].getAmount());
        assertEquals(270,testAccounts[2].getAmount());

    }
    @Test
    public void allException(){

        testAccounts[0] = new NoException(amountArray[0]);
        TwoTryAgain tryAgain = new TwoTryAgain(amountArray[1]);
        testAccounts[1] = tryAgain;
        testAccounts[2] = new BlockException(amountArray[2]);

        assertFalse(AccountManager.transfer(testAccounts,testDelta));
        assertEquals(2,tryAgain.countCall);
        assertEquals(10,testAccounts[0].getAmount());
        assertEquals(5,testAccounts[1].getAmount());
        assertEquals(25,testAccounts[2].getAmount());

    }


}
