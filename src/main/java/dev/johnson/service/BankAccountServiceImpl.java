package dev.johnson.service;

import dev.johnson.data.BankAccountDao;
import dev.johnson.data.BankAccountDaoImpl;
import dev.johnson.entities.BankAccount;
import dev.johnson.utilities.List;

public class BankAccountServiceImpl implements BankAccountService{

   private BankAccountDao bankAccountDao;


    public BankAccountServiceImpl(BankAccountDaoImpl bankAccountDao) {
        this.bankAccountDao = bankAccountDao;
    }


    @Override
    public BankAccount createBankAccount(double balance, String firstName, String lastName, String mobileNo, String userName, String password) {

        BankAccount bankAccount = new BankAccount(balance,firstName,lastName,mobileNo,userName,password);
        bankAccount =  bankAccountDao.createBankAccount(bankAccount);

        return bankAccount;
    }


    @Override
    public BankAccount makeDeposit(BankAccount bankAccount, double valToDeposit) {

        //utilizing earlier dreated bankAccount isnt to set the balance by calling the get bal then adding the double passed in,
        //then using the dataobject to apply the updated features in this case simply updating the
       bankAccount.setBalance(bankAccount.getBalance() + valToDeposit);
       bankAccount = bankAccountDao.updateBankAccount(bankAccount);


        return bankAccount;
    }

    @Override
    public BankAccount makeWithdrawal(BankAccount bankAccount, double valToWithdraw) {
            bankAccount.setBalance(bankAccount.getBalance()- valToWithdraw);
            bankAccount = bankAccountDao.updateBankAccount(bankAccount);

        return bankAccount;
    }

    @Override
    public boolean login(String userName) {
        return bankAccountDao.getLogin(userName);
    }

    @Override
    public BankAccount login(String userName, String password) {

        return bankAccountDao.getBankAccountByAccNo(bankAccountDao.getLogin(userName, password));
    }

    @Override
    public void printBalance(BankAccount bankAccount) {
        System.out.println("Your balance is " + bankAccount.getBalance() + " and your account number is "+ bankAccount.getAccountNo());

    }

    @Override
    public List<BankAccount> getAllAccounts(int accNo) {
        return bankAccountDao.getAllAccounts(accNo);
    }

}
