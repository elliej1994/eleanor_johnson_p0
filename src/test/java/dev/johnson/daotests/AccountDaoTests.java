package dev.johnson.daotests;

import dev.johnson.data.AccountDao;
import dev.johnson.data.AccountDaoImpl;
import dev.johnson.entities.Account;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AccountDaoTests {

    static AccountDao accountDao = new AccountDaoImpl();
    static Account testAccount = null;

    @Test
   public void create_account_test(){

        Account sample = new Account(0, 1500.00F,500.00F);
        Account savedAccount = accountDao.createAccount(sample);
        AccountDaoTests.testAccount = savedAccount;
        Assertions.assertNotEquals(0,savedAccount.getAccountId());
    }

    @Test
    public void get_account_info_by_id_test(){
        Account retrievedAccount = accountDao.getAccountInfoById(testAccount.getAccountId());
        System.out.println(retrievedAccount);
        Assertions.assertNotEquals(0,retrievedAccount.getAccountId());


    }

}
