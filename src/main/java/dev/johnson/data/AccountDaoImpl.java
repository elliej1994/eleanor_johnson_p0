package dev.johnson.data;

import dev.johnson.entities.Account;
import dev.johnson.utilities.ConnectionUtil;

import java.sql.*;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account createAccount(Account account) {

        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into account values(default,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1, account.getBalance());
            ps.setFloat(2,account.getSavingsBalance());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("account_id");
            account.setAccountId(generatedId);
            return account;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Account getAccountInfoById(int id) {


        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "select * from account where account_id = ?"; // select * from users left join account etc etc
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            Account account = new Account();
            account.setAccountId(rs.getInt("account_id"));
            account.setBalance(rs.getFloat("balance"));
            account.setSavingsBalance(rs.getFloat("savings_balance"));
            return account;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Account> getAllAccountInfo() {





        return null;
    }

    @Override
    public Account updateAccount(Account account) {




        return null;
    }

    @Override
    public boolean deleteAccountById(int id) {






        return false;
    }
}
