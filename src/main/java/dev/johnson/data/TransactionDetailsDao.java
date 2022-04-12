package dev.johnson.data;

import dev.johnson.entities.TransactionDetails;
import dev.johnson.utilities.ArrayList;

public interface TransactionDetailsDao {

    //create
    public TransactionDetails createTransactionRecord(TransactionDetails transactionDetails);
    //read
    public TransactionDetails getTransRecordByTransNo(int transNo);
    //update
    public TransactionDetails updateTransactionRecord(TransactionDetails user);
    //delete
    boolean deleteTransactionRecord(int transNo);

    public ArrayList<TransactionDetails> getAllTransRecords (int accNo);
}
