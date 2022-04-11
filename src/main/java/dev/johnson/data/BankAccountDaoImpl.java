package dev.johnson.data;

import dev.johnson.entities.BankAccount;

import dev.johnson.utilities.ConnectionUtil;
import dev.johnson.utilities.List;

import java.sql.*;

public class BankAccountDaoImpl implements BankAccountDao {

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {

        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into bankaccountinfo values (default,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1,bankAccount.getBalance());
            ps.setString(2,bankAccount.getCustName());
            ps.setString(3,bankAccount.getCustMobileNo());
            ps.setString(4,bankAccount.getUserName());
            ps.setString(5,bankAccount.getPassWord());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("account_no");
            bankAccount.setAccountNo(generatedId);
            return bankAccount;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public BankAccount getBankAccountByMobileNo(String mobileNo) {
    BankAccount bankAccount = null;
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from bankaccountinfo where cust_mobile_no = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mobileNo);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {

                int accNo = rs.getInt("account_no");
                Float balance = rs.getFloat("balance");
                String custName = rs.getString("cust_name");
                String custMobileNo = rs.getString("cust_mobile_no");
               String username = rs.getString("username");
                String password = rs.getString("password");
                 bankAccount = new BankAccount(accNo,balance,custName,custMobileNo,username,password);
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return bankAccount;
    }

    @Override
    public BankAccount getBankAccountByUserName(String userName) {
        return null;
    }

    @Override
    public BankAccount updateBankAccount(BankAccount bankAccount) {
        return null;
    }

    @Override
    public int deleteUserByAccNo(int accNo) {
        return 0;
    }

    @Override
    public void makeDeposit(String userName, float val) {

        try {
            String sql = "{call makedeposit (?,?)}";
            Connection conn = ConnectionUtil.createConnection();
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1,userName);
            cs.setFloat(2,val);
            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void makeWithdrawal(int accNo, float withdrawVal) {

    }

    @Override
    public List<BankAccount> getBankAccounts() {
        return null;
    }



}

