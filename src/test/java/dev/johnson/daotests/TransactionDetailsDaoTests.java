package dev.johnson.daotests;


import dev.johnson.data.TransactionDetailsDao;
import dev.johnson.data.TransactionDetailsDaoImpl;
import dev.johnson.entities.BankAccount;
import dev.johnson.entities.TransactionDetails;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class TransactionDetailsDaoTests {


    static TransactionDetailsDao transactionDetailsDao = new TransactionDetailsDaoImpl();
    static TransactionDetails testTransactionDetails = null;

    @Test
    @Order(1)
    public void create_transactiondetail_test (){

        TransactionDetails sample = new TransactionDetails(2,"March 15, 2022","Deposit",25.00);
        TransactionDetails savedRecord = transactionDetailsDao.createTransactionRecord(sample);
        TransactionDetailsDaoTests.testTransactionDetails = savedRecord;
        Assertions.assertNotEquals(0,savedRecord.getAccountNo());
    }



    }


