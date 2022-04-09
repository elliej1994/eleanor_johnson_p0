package dev.johnson.data;

import dev.johnson.entities.User;

public interface UserDao {

    //create
    User createUser(User user);
    //read
    User getUserById(int id);
    //update
    User updateUser(User user);
    //delete
    boolean deleteUser(int id);
}
