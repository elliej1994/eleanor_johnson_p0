package dev.johnson.entities;

import dev.johnson.data.BankAccountDao;
import dev.johnson.data.BankAccountDaoImpl;

public class BankAccount {

    private int accountNo;
    private Float balance;
    private String custName;
    private String custMobileNo;
    private String userName;
    private String passWord;

    //constructors
    public BankAccount(){}
    public BankAccount(int accountNo, Float balance, String custName, String custMobileNo, String userName, String passWord) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.custName = custName;
        this.custMobileNo = custMobileNo;
        this.userName = userName;
        this.passWord = passWord;
    }

    //get/set


    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustMobileNo() {
        return custMobileNo;
    }

    public void setCustMobileNo(String custMobileNo) {
        this.custMobileNo = custMobileNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    //overrides


    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNo=" + accountNo +
                ", balance=" + balance +
                ", custName='" + custName + '\'' +
                ", custMobileNo='" + custMobileNo + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public void deposit(String userName, float val){
        if (val > 0){
            balance += val;
            setBalance(balance);
            BankAccountDao bankAccountDao = new BankAccountDaoImpl();
            bankAccountDao.makeDeposit(userName,val);
            System.out.println("Your deposit of " +val +" was successful. Your current balance is now: $" +balance);
        }else {
            System.out.println("Invalid value, enter a number larger than 0.");
        }


    }

}
