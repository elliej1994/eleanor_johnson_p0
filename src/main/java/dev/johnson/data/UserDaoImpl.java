package dev.johnson.data;

import dev.johnson.entities.User;
import dev.johnson.utilities.ConnectionUtil;

import java.sql.*;

public class UserDaoImpl implements UserDao{


    @Override
    public User createUser(User user) {
        try {
            Connection conn = ConnectionUtil.createConnection();
            String sql = "insert into users values(default,?,?,?,?,default)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setString(3,user.getUserName());
            ps.setString(4,user.getPassWord());


            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("user_id");
            user.setUserId(generatedId);
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }
}
