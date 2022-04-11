package dev.johnson.data;

import dev.johnson.entities.TransactionDetails;
import dev.johnson.utilities.ArrayList;

public interface TransactionDetailsDao {

    //create
    TransactionDetails createTransactionRecord(TransactionDetails transactionDetails);
    //read
    TransactionDetails getTransRecordByTransNo(int transNo);
    //update
    TransactionDetails updateTransactionRecord(TransactionDetails user);
    //delete
    boolean deleteTransactionRecord(int transNo);

    ArrayList<TransactionDetails> getAllTransRecords (int accNo);
}
