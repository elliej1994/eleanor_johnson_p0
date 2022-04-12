package dev.johnson.service;

import dev.johnson.data.BankAccountDao;
import dev.johnson.data.BankAccountDaoImpl;
import dev.johnson.data.TransactionDetailsDao;
import dev.johnson.data.TransactionDetailsDaoImpl;
import dev.johnson.entities.BankAccount;
import dev.johnson.entities.TransactionDetails;

public class BankAccountServiceImpl implements BankAccountService{
    BankAccountDao bankAccountDao = new BankAccountDaoImpl();
    TransactionDetailsDao transactionDetailsDao = new TransactionDetailsDaoImpl();


    @Override
    public BankAccount createBankAccount(double balance, String firstName, String lastName, String mobileNo, String userName, String password) {


        BankAccount bankAccount = new BankAccount(balance,firstName,lastName,mobileNo,userName,password);
        bankAccount =  bankAccountDao.createBankAccount(bankAccount);

        return bankAccount;
    }


    @Override
    public BankAccount makeDeposit(BankAccount bankAccount, double valToDeposit, String dateOfTrans, String typeOfTrans, double transAmt) {

        //utilizing earlier dreated bankAccount isnt to set the balance by calling the get bal then adding the double passed in,
        //then using the dataobject to apply the updated features in this case simply updating the
       bankAccount.setBalance(bankAccount.getBalance() + valToDeposit);
       bankAccount = bankAccountDao.updateBankAccount(bankAccount);

        TransactionDetails transactionDetails = new TransactionDetails(bankAccount.getAccountNo(),dateOfTrans,typeOfTrans,transAmt);
        transactionDetails = transactionDetailsDao.createTransactionRecord(transactionDetails);



       return bankAccount;



    }

    @Override
    public BankAccount makeWithdrawal(BankAccount bankAccount, double valToWithdraw) {
        return null;
    }

    @Override
    public void printBalance(BankAccount bankAccount) {

    }
}
