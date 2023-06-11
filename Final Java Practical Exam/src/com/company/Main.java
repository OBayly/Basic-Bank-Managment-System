package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean Continue = true;
        BankAccount[] bankAccounts = new BankAccount[10];

        for (int i = 0; i < 5; i++) {
            bankAccounts[i] = new OnlineInterestAccount();

        }
        for (int i = 5; i < 10; i++) {
            bankAccounts[i] = new SavingsAccount();
        }
        System.out.println("Welcome");

        //Parsing input and checking to confirm only numbers present
        Boolean AccMatchFound;
        String AccountNoMatch;
        int AccountNo;
        do {
            do {
                System.out.println("Input an account number: ");
                AccountNoMatch = sc.nextLine();
                Pattern AccPattern = Pattern.compile("[0-9]");
                Matcher AccMatcher = AccPattern.matcher(AccountNoMatch);
                AccMatchFound = AccMatcher.find();
                System.out.println();
                System.out.println("Invalid Account Number. Please try again.");
                System.out.println();
            }
            while (!AccMatchFound);
            AccountNo = Integer.parseInt(AccountNoMatch);

            if (AccountNo >= 0 || AccountNo <= 10) {

                //Allows user to access multiple accounts
                Boolean LogOut = true;
                System.out.println();
                System.out.println("Account Number Accepted");
                do {
                    if (AccountNo >= 0 || AccountNo > 5) {
                        System.out.println("Account Type: Online Interest Account");
                    } else {
                        System.out.println("Account Type: Savings Account");
                    }
                    System.out.println();
                    System.out.println("What would you like to do today?");
                    System.out.println("1. Display Balance");
                    System.out.println("2. Deposit Money");
                    System.out.println("3. Withdraw Money");
                    System.out.println("4. Log Out");
                    Boolean Decision = false;
                    int j = sc.nextInt();
                    switch (j) {
                        //Display Account Balance
                        case 1:
                            do {
                                Decision = true;
                                System.out.println();
                                System.out.println(bankAccounts[AccountNo].displayBalance());
                                System.out.println();
                                System.out.println("Continue? ");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                int k = sc.nextInt();
                                switch (k) {
                                    case 1:
                                        Decision = false;
                                        System.out.println();
                                        break;
                                    case 2:
                                        Continue = false;
                                }
                            } while (Decision == true);
                            break;

                        //Deposit Money
                        case 2:
                            Decision = true;
                            do {
                                System.out.println("How much Money would you like to deposit? ");
                                System.out.println();

                                int moneyDeposited = sc.nextInt();
                                //Add deposited money to overall bank balance
                                bankAccounts[AccountNo].Balance += moneyDeposited;
                                System.out.println("Money Deposited: " + moneyDeposited);

                                if (AccountNo >= 0 || AccountNo < 5) {
                                    System.out.println(bankAccounts[AccountNo].deposit());
                                } else
                                    System.out.println();
                                System.out.println("Deposit More Money?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                int k = sc.nextInt();
                                switch (k) {
                                    case 1:
                                        break;
                                    case 2:
                                        Decision = false;
                                        System.out.println();
                                        break;
                                }
                            } while (Decision == true);
                            break;

                        //Withdraw Money
                        case 3:
                            Decision = true;
                            do {
                                System.out.println("How much Money would you like to Withdraw? ");
                                System.out.println();

                                int moneyWithdrawn = sc.nextInt();
                                //Add deposited money to overall bank balance
                                bankAccounts[AccountNo].Balance -= moneyWithdrawn;
                                System.out.println("Money Withdrawn: " + moneyWithdrawn);

                                if (AccountNo >= 5 || AccountNo < 10) {
                                    System.out.println(bankAccounts[AccountNo].withdraw());
                                } else {
                                }

                                System.out.println("Withdraw More Money?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                int k = sc.nextInt();
                                switch (k) {
                                    case 1:
                                        break;
                                    case 2:
                                        Decision = false;
                                        System.out.println();
                                        break;
                                }
                            } while (Decision == true);
                            break;

                        //Log Out
                        case 4:
                            LogOut = false;
                            System.out.println();
                            System.out.println("Log Out Successful");
                            break;

                    }
                } while (LogOut == true);
                System.out.println();
                System.out.println("Access another Account? ");
                System.out.println("1. Yes");
                System.out.println("2. No");
                int j = sc.nextInt();

                switch (j) {
                    case 1:
                        break;
                    case 2:
                        System.out.println();
                        System.out.println();
                        System.out.println("System Shutdown Successful");
                        System.out.println();
                        Continue = false;
                }
            } else {
                System.out.println("Please enter a valid bank Account");
            }
        } while (Continue == true);
    }
}