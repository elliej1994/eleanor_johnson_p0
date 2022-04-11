package dev.johnson.daotests;

import dev.johnson.data.BankAccountDao;
import dev.johnson.data.BankAccountDaoImpl;
import dev.johnson.entities.BankAccount;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountDaoTests {

    static BankAccountDao accountDao = new BankAccountDaoImpl();
    static BankAccount testAccount = null;

    @Test
    @Order(1)
   public void create_account_test(){

        BankAccount sample = new BankAccount(0,10.50F,"Dummy Jane Doe", "555-555-5555","jdoe57","ahjslk^*45");
        BankAccount savedAccount = accountDao.createBankAccount(sample);
        BankAccountDaoTests.testAccount = savedAccount;
        Assertions.assertNotEquals(0,savedAccount.getAccountNo());
    }

    @Test
    @Order(2)
    public void get_account_by_mobileNo_test(){

        BankAccount retrievedAccount = accountDao.getBankAccountByMobileNo(testAccount.getCustMobileNo());
        System.out.println(retrievedAccount);
        Assertions.assertEquals("Dummy Jane Doe", retrievedAccount.getCustName());
    }

    @Test
    @Order(3)
    public void make_deposit_test(){
    BankAccount sample = new BankAccount(55,750F,"John Denver","867-530-9999","denbo52","tookmehome");
    BankAccount savedAccount = accountDao.createBankAccount(sample);
    savedAccount.deposit("denbo52",100);
    Assertions.assertEquals(850,savedAccount.getBalance());

    }


}
