package dev.johnson.servicetests;


import dev.johnson.entities.TransactionDetails;
import dev.johnson.service.TransactionDetailsService;
import dev.johnson.service.TransactionDetailsServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class TransactionDetailServiceTests {

    static TransactionDetailsService transactionDetailsService = new TransactionDetailsServiceImpl();
    static TransactionDetails testTransaction;

    @Test
    @Order(1)
    public void create_transRecord_test()
    {

        testTransaction = transactionDetailsService.createTransactionDetailRecord(1,"March 15, 2022","Deposit",25);
        System.out.println(testTransaction.getAccountNo());
        Assertions.assertNotEquals(0,testTransaction.getAccountNo());


    }



}
