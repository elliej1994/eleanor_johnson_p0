package dev.johnson.data;

import dev.johnson.entities.Account;

import java.util.List;

public interface AccountDao {
   //Create
    Account  createAccount(Account account);
    //Read
    Account getAccountInfoById(int id);
    List<Account> getAllAccountInfo();
    //Update
    Account updateAccount(Account account);
    //delete
    boolean deleteAccountById(int id);

}
