package dev.johnson.service;

import dev.johnson.entities.BankAccount;
import dev.johnson.entities.TransactionDetails;

public interface TransactionDetailsService {

    public TransactionDetails createTransactionDetailRecord(int accNo);
    public void printTransRecord(BankAccount bankAccount);
}
