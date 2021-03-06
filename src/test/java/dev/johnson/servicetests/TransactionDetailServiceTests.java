package dev.johnson.servicetests;


import dev.johnson.entities.TransactionDetails;
import dev.johnson.service.TransactionDetailsService;
import dev.johnson.service.TransactionDetailsServiceImpl;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class TransactionDetailServiceTests {

    static TransactionDetailsService transactionDetailsService = new TransactionDetailsServiceImpl();
    static TransactionDetails testTransaction;

    @Test
    @Order(1)
    public void create_transRecord_test()
    {

        testTransaction = transactionDetailsService.createTransactionDetailRecord(6,"March 1, 2022","Deposit",25);
        System.out.println(testTransaction.getAccountNo());
        Assertions.assertNotEquals(0,testTransaction.getAccountNo());

    }
}
