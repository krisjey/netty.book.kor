package com.github.nettybook.ch8;

public class SavingAccount {
    private int balance = 1000000;

    public int withdraw(int amount) {
        balance = balance - amount;
        return balance;
    }

    public int deposit(int amount) {
        balance = balance + amount;
        return balance;
    }
}
