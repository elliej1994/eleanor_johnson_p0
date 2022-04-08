package dev.johnson.entities;

import dev.johnson.utilities.List;

import java.util.Objects;

public class Account {

    private Integer accountId;

    private Float balance;
    private Float savingsBalance;
    private List<Account> accountList;

    public Account(){}

    public Account(Integer accountId, Float balance, Float savingsBalance) {
        this.accountId = accountId;
        this.balance = balance;
        this.savingsBalance = savingsBalance;

    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }


    public float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(Float savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) && Objects.equals(balance, account.balance) && Objects.equals(savingsBalance, account.savingsBalance) && Objects.equals(accountList, account.accountList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, balance, savingsBalance, accountList);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", savingsBalance=" + savingsBalance +
                ", accountList=" + accountList +
                '}';
    }
}
