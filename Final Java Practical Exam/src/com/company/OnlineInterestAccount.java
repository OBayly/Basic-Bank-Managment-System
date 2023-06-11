package com.company;

public class OnlineInterestAccount extends BankAccount {

    public String calculateInterest() {
        return "The Expected amount of interest is " + (this.Balance * 0.02);
    }
}