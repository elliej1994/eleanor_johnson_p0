package dev.johnson.data;

import dev.johnson.entities.BankAccount;
import dev.johnson.entities.TransactionDetails;
import dev.johnson.utilities.ArrayList;
import dev.johnson.utilities.ConnectionUtil;

import java.sql.*;

public class TransactionDetailsDaoImpl implements TransactionDetailsDao {

    @Override
    public TransactionDetails createTransactionRecord(TransactionDetails transactionDetails) {

        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = " insert into transactiondetails (account_no,date_of_transaction,type_of_transaction,transaction_amount) values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,transactionDetails.getAccountNo());
            ps.setString(2, transactionDetails.getDateOfTrans());
            ps.setString(3, transactionDetails.getTypeOfTrans());
            ps.setDouble(4, transactionDetails.getTransAmt());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int transNo = rs.getInt("trans_no");
            transactionDetails.setTransNo(transNo);

            return transactionDetails;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public TransactionDetails getTransRecordByTransNo(int transNo) {
        return null;
    }

    @Override
    public TransactionDetails updateTransactionRecord(TransactionDetails user) {
        return null;
    }

    @Override
    public boolean deleteTransactionRecord(int transNo) {
        return false;
    }

    @Override
    public ArrayList<TransactionDetails> getAllTransRecords(int accNo) {
        return null;
    }
}
