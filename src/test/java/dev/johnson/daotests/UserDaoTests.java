package dev.johnson.daotests;

import dev.johnson.data.UserDao;
import dev.johnson.data.UserDaoImpl;
import dev.johnson.entities.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class UserDaoTests {

    static UserDao userDao = new UserDaoImpl();
    static User testUser = null;


@Test
    public void create_user_test(){
    User sample = new User(0,"Jane", "Doe","jdoe85","password1234",0);
    User savedUser = userDao.createUser(sample);
    UserDaoTests.testUser = savedUser;
    Assertions.assertNotEquals(0,savedUser.getUserId());

    


}

}
