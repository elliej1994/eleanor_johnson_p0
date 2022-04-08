package dev.johnson.services;

import dev.johnson.entities.Account;

public interface AccountService {

    Account registerNewCheckingAccount(Account account);
    Account registerNewSavingsAccount(Account account);
    Account registerNewCheckingAndSavingsAccount(Account  account);
    Account createNewAccount(Account account);
    Account makeDeposit (double depositValue);
    Account makeWithdrawal (double withdrawalValue);
    Account viewBalance(double getBalance);
    Account transferFunds(double transferFunds);
    Account joinAccounts (Account account);




}
