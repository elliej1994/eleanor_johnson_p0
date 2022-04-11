package dev.johnson.daotests;

import dev.johnson.entities.BankAccount;
import dev.johnson.entities.TransactionDetails;
import dev.johnson.service.BankAccountService;
import dev.johnson.service.BankAccountServiceImpl;
import dev.johnson.service.TransactionDetailsService;
import dev.johnson.service.TransactionDetailsServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class BankAccountServiceTests {

    static BankAccountService bankAccountService = new BankAccountServiceImpl();
    static BankAccount testAccount;

    static TransactionDetailsService transactionDetailsService = new TransactionDetailsServiceImpl();
    static TransactionDetails transactionDetails;

    @Test
    @Order(1)
    public void create_bankaccount(){
        testAccount = bankAccountService.createBankAccount(50.00,"Joe","Dirt","867-530-9999","jdirty78","pass1234578");
        System.out.println(testAccount.getAccountNo());
        Assertions.assertNotEquals(0,testAccount.getAccountNo());
    }





}
