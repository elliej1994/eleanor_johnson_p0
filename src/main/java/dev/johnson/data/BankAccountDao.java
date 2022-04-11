package dev.johnson.data;


import dev.johnson.entities.BankAccount;
import dev.johnson.utilities.List;

public interface BankAccountDao {

 //create
 public BankAccount createBankAccount(BankAccount bankAccount);

 //read
 public BankAccount getBankAccountByMobileNo(String mobileNo);
 public BankAccount getBankAccountByUserName(String userName);

 //update
public BankAccount updateBankAccount(BankAccount bankAccount);
 public List<BankAccount> getAllBankAccounts();

//delete
 boolean deleteUserByAccNo(int accNo);








}
