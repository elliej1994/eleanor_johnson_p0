package dev.johnson.service;

import dev.johnson.entities.BankAccount;

public interface BankAccountService {

    public BankAccount createBankAccount(double balance, String firstName, String lastName, String mobileNo, String userName, String password);
    public BankAccount makeDeposit(BankAccount bankAccount, double valToDeposit, String dateOfTrans, String typeOfTrans, double transAmt);
    public BankAccount makeWithdrawal(BankAccount bankAccount, double valToWithdraw);
    public void printBalance(BankAccount bankAccount);

}
