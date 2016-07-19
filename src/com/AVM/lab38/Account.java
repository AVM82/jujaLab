package com.AVM.lab38;

/**
 * Created by AVM on 15.07.2016.
 */
abstract public class Account {
    protected int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public abstract void change(int delta) throws TryAgainException, BlockAccountException;

    public int getAmount() {
        return amount;
    }
}
