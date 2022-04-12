package dev.johnson.service;

import dev.johnson.data.BankAccountDao;
import dev.johnson.data.BankAccountDaoImpl;
import dev.johnson.data.TransactionDetailsDao;
import dev.johnson.data.TransactionDetailsDaoImpl;
import dev.johnson.entities.BankAccount;
import dev.johnson.entities.TransactionDetails;

public class TransactionDetailsServiceImpl implements TransactionDetailsService{

TransactionDetailsDao transactionDetailsDao = new TransactionDetailsDaoImpl();
BankAccountDao  bankAccountDao = new BankAccountDaoImpl();

    @Override
    public TransactionDetails createTransactionDetailRecord(int accountNo, String dateOfTrans, String typeOfTrans, double transAmt) {

        TransactionDetails transactionDetails = new TransactionDetails(accountNo,dateOfTrans,typeOfTrans,transAmt);
        transactionDetails = transactionDetailsDao.createTransactionRecord(transactionDetails);

        return transactionDetails;
    }

    @Override
    public void printTransRecord(BankAccount bankAccount, int accountNo) {

    }
}
