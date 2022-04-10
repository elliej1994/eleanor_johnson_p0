package dev.johnson.daotests;

import dev.johnson.data.BankAccountDao;
import dev.johnson.data.BankAccountDaoImpl;
import dev.johnson.entities.BankAccount;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BankAccountDaoTests {

    static BankAccountDao accountDao = new BankAccountDaoImpl();
    static BankAccount testAccount = null;

    @Test
   public void create_account_test(){

        BankAccount sample = new BankAccount(0,10.50F,"Dummy Jane Doe", "555-555-5555","jdoe57","ahjslk^*45");
        BankAccount savedAccount = accountDao.createBankAccount(sample);
        BankAccountDaoTests.testAccount = savedAccount;
        Assertions.assertNotEquals(0,savedAccount.getAccountNo());
    }

    @Test
    public void get_account_by_mobileNo_test(){

        BankAccount retrievedAccount = accountDao.getBankAccountByMobileNo(testAccount.getCustMobileNo());
        System.out.println(retrievedAccount);
        Assertions.assertEquals(0, retrievedAccount.getAccountNo());


    }


}
