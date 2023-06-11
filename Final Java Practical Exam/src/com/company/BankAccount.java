package com.company;

public class BankAccount implements calculateInterest{
    String AccountNo, AccountName;
    int Balance;

    public String displayBalance(){
        return "The Balance for this account is " + this.Balance;
    }
    public String deposit(){
        return calculateInterest();
    }
    public String withdraw(){
        return calculateInterest();
    }
    public String calculateInterest(){
        return"Calculating Interest";}
}
