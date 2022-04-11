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
        return null;
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
    public boolean deleteUserByAccNo(int accNo) {
        return false;
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return null;
    }
}

