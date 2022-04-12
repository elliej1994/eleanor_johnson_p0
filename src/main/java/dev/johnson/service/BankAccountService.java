package dev.johnson.service;

import dev.johnson.entities.BankAccount;
import dev.johnson.utilities.List;

public interface BankAccountService {

    public BankAccount createBankAccount(double balance, String firstName, String lastName, String mobileNo, String userName, String password);

    public BankAccount makeDeposit(BankAccount bankAccount, double valToDeposit);

    public BankAccount makeWithdrawal(BankAccount bankAccount, double valToWithdraw);

    boolean login(String userName);

    BankAccount login(String userName, String password);

    public void printBalance(BankAccount bankAccount);

    List<BankAccount> getAllAccounts (int accNo);

}
