package com.company;

public class SavingsAccount extends BankAccount{

    public String calculateInterest(){
        double fee = 0.0;
        if (Balance < 0){
            fee = (Balance * (-1));
            fee = fee * 0.04;
        }
        return "Your daily charge is " + fee;
    }
}
