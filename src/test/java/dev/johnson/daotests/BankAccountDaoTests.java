package dev.johnson.daotests;

import dev.johnson.data.BankAccountDao;
import dev.johnson.data.BankAccountDaoImpl;
import dev.johnson.entities.BankAccount;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountDaoTests {

    static BankAccountDao accountDao = new BankAccountDaoImpl();
    static BankAccount testAccount = null;

    @Test
    @Order(1)
   public void create_account_test(){

        BankAccount sample = new BankAccount(50.75,"Joe","Dirt","555-555-5555", "jdirty45", "pass1234");
        BankAccount savedAccount = accountDao.createBankAccount(sample);
        BankAccountDaoTests.testAccount = savedAccount;
        Assertions.assertNotEquals(0,savedAccount.getAccountNo());
    }

    @Test
    @Order(2)
    public void get_acc_byMobile_test(){
    BankAccount bankAccount =  accountDao.getBankAccountByMobileNo(testAccount.getMobileNo());
    Assertions.assertEquals(bankAccount.getMobileNo(),testAccount.getMobileNo());

    }

    @Test
    @Order(3)
    public void get_account_by_accNo_test(){
        BankAccount bankAccount = accountDao.getBankAccountByAccNo(testAccount.getAccountNo());
        Assertions.assertEquals(bankAccount.getAccountNo(),testAccount.getAccountNo());


    }

}
