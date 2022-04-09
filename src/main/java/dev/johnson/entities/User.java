package dev.johnson.entities;


import java.util.Objects;

public class User {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private Integer userAccountNumber;


    public User(){}

    public User(Integer userId, String firstName, String lastName, String userName, String passWord, Integer userAccountNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.userAccountNumber = userAccountNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Integer getUserAccountNumber() {
        return userAccountNumber;
    }

    public void setUserAccountNumber(Integer userAccountNumber) {
        this.userAccountNumber = userAccountNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userAccountNumber=" + userAccountNumber +
                '}';
    }
}





