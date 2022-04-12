package dev.johnson.data;

import dev.johnson.entities.BankAccount;

import dev.johnson.utilities.ArrayList;
import dev.johnson.utilities.ConnectionUtil;
import dev.johnson.utilities.List;

import java.sql.*;

public class BankAccountDaoImpl implements BankAccountDao {


    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = " insert into bankaccount (balance, firstname, lastname, cust_mobile_no, username, password) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, bankAccount.getBalance());
            ps.setString(2, bankAccount.getFirstName());
            ps.setString(3, bankAccount.getLastName());
            ps.setString(4, bankAccount.getMobileNo());
            ps.setString(5, bankAccount.getUserName());
            ps.setString(6, bankAccount.getPassword());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int accNo = rs.getInt("account_no");

            System.out.println(accNo + "blah");
            bankAccount.setAccountNo(accNo);
            return bankAccount;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public BankAccount getBankAccountByMobileNo(String mobileNo) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = " select *from bankaccount where cust_mobile_no = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mobileNo);

            ResultSet rs = ps.executeQuery();
            rs.next();
            BankAccount bankAccount = new BankAccount();
            bankAccount.setAccountNo(rs.getInt("account_no"));
            bankAccount.setBalance(rs.getDouble("balance")); // check here for issues w/ typecast from numeric sql to double
            bankAccount.setFirstName(rs.getString("firstname"));
            bankAccount.setLastName(rs.getString("lastname"));
            bankAccount.setMobileNo(rs.getString("cust_mobile_no"));
            bankAccount.setUserName(rs.getString("username"));
            bankAccount.setPassword(rs.getString("password"));
            return bankAccount;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public BankAccount getBankAccountByAccNo(int accNo) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = " select * from bankaccount where account_no = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();
            rs.next();
            BankAccount bankAccount = new BankAccount();
            bankAccount.setAccountNo(rs.getInt("account_no"));
            bankAccount.setBalance(rs.getDouble("balance")); // check here for issues w/ typecast from numeric sql to double
            bankAccount.setFirstName(rs.getString("firstname"));
            bankAccount.setLastName(rs.getString("lastname"));
            bankAccount.setMobileNo(rs.getString("cust_mobile_no"));
            bankAccount.setUserName(rs.getString("username"));
            bankAccount.setPassword(rs.getString("password"));
            return bankAccount;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public BankAccount updateBankAccount(BankAccount bankAccount) {

        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "update bankaccout set balance = ?, firstname = ?, lastname = ?, cust_mobile_no = ?, username = ?, password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, bankAccount.getBalance());
            ps.setString(2, bankAccount.getFirstName());
            ps.setString(3, bankAccount.getLastName());
            ps.setString(4, bankAccount.getMobileNo());
            ps.setString(5, bankAccount.getUserName());
            ps.setString(6, bankAccount.getPassword());
            ps.executeUpdate();
            return bankAccount;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteUserByAccNo(int accNo) {

        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "delete from bankaccount where account_no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accNo);
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

