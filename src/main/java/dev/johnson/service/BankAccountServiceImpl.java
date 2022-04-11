package dev.johnson.service;

import dev.johnson.data.BankAccountDao;
import dev.johnson.data.BankAccountDaoImpl;
import dev.johnson.entities.BankAccount;

public class BankAccountServiceImpl implements BankAccountService{
    BankAccountDao bankAccountDao = new BankAccountDaoImpl();


    @Override
    public BankAccount createBankAccount(double balance, String firstName, String lastName, String mobileNo, String userName, String password) {


        BankAccount bankAccount = new BankAccount(balance,firstName,lastName,mobileNo,userName,password);
        bankAccount =  bankAccountDao.createBankAccount(bankAccount);

        return bankAccount;
    }

    @Override
    public BankAccount makeDeposit(BankAccount bankAccount, double valToDeposit) {
        return null;
    }

    @Override
    public BankAccount makeWithdrawal(BankAccount bankAccount, double valToWithdraw) {
        return null;
    }

    @Override
    public void printBalance(BankAccount bankAccount) {

    }
}
