package dev.johnson.service;

import dev.johnson.entities.BankAccount;
import dev.johnson.entities.TransactionDetails;

public interface TransactionDetailsService {

    public TransactionDetails createTransactionDetailRecord(int accountNo, String dateOfTrans, String typeOfTrans, double transAmt);
    public void printTransRecord(BankAccount bankAccount, int accountNo);
}
