package dev.johnson.data;


import dev.johnson.entities.BankAccount;
import dev.johnson.utilities.List;

public interface BankAccountDao {

 //create
 public BankAccount createBankAccount(BankAccount bankAccount);
 //read
 public BankAccount getBankAccountByMobileNo(String mobileNo);
 public BankAccount getBankAccountByAccNo(int accNo);
 //update
public BankAccount updateBankAccount(BankAccount bankAccount);
//delete
 boolean deleteUserByAccNo(int accNo);


 BankAccount createLogin(BankAccount bankAccount);
 int getLogin(String userName, String password);
 boolean getLogin(String userName);


//List<BankAccount> getAllAccounts(int accNo);


 List<BankAccount> getAllAccounts();
}
