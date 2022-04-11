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

        BankAccount sample = new BankAccount(50.75,"Jane","Doe","555-555-5555", "jdee67", "pass1234");
        BankAccount savedAccount = accountDao.createBankAccount(sample);
        BankAccountDaoTests.testAccount = savedAccount;
        Assertions.assertNotEquals(0,savedAccount.getAccountNo());
    }

//    @Test
//    @Order(2)
//    public void get_account_by_mobileNo_test(){
//
//
//    }
//
//    @Test
//    @Order(3)
//    public void make_deposit_test(){
//
//
//
//    }


}
