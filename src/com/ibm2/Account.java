package com.ibm2;

/**
 * Created by tianf on 2016/8/8.
 */
public class Account {

    String holderName;
    float amount;
    public Account(String name, float amt) {
        holderName = name;
        amount = amt;
    }
    public
    synchronized void deposit(float amt) {
        amount += amt;
    }
    public
    synchronized void withdraw(float amt) {
        amount -= amt;
    }
    public float checkBalance() {
        return amount;
    }
}
