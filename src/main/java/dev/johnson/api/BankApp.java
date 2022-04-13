package dev.johnson.api;

import dev.johnson.data.BankAccountDao;
import dev.johnson.data.BankAccountDaoImpl;
import dev.johnson.entities.BankAccount;
import dev.johnson.service.BankAccountService;
import dev.johnson.service.BankAccountServiceImpl;
import dev.johnson.utilities.List;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class BankApp {

    public static BankAccountService bankAccountService = new BankAccountServiceImpl(new BankAccountDaoImpl());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to the StruggleIndustries(TM) Banking Terminal");
        System.out.println("1. Create New Account \n2. Forgot username? \n3.Login \n4.Exit");
        int input = scanner.nextInt();
        scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.println("We're happy to welcome you to our family of just good enough products");
                    System.out.println("Please enter your first name :");
                    String fName = scanner.nextLine();
                    System.out.println("Please enter your last name :");
                    String lName = scanner.nextLine();
                    System.out.println("Please enter your preffered Phone number :");
                    String mobileNo = scanner.nextLine();
                    System.out.println("Please enter your desired username:");
                    String userName = scanner.nextLine();
                    System.out.println("Please enter the password you would like to set, please keep a copy for your own records. ");
                    String password = scanner.nextLine();
                    BankAccount bankAccount = BankApp.bankAccountService.createBankAccount(0, fName, lName, mobileNo, userName, password);
                    System.out.println("Your new account has been created!" + bankAccount);
                    break;
                case 2:
                    System.out.println("Enter the phone number associated with the account");
                    String phoneNo = scanner.nextLine();
                    BankAccount x = BankApp.bankAccountService.getUserNameByMobileNo(phoneNo);
                    System.out.println("Your username is: " + x.getUserName());
                    System.out.println("1. Create New Account \n2. Forgot username? \n3.Login \n4.Exit");
                    input = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Login Terminal");
                    System.out.println("--------------------------------");
                    System.out.println("Enter your username: \n");
                    String accountUserName = scanner.nextLine();
                    System.out.println("Enter your password: \n");
                    String accPass = scanner.nextLine();
                    BankAccount b = BankApp.bankAccountService.login(accountUserName, accPass);
                    System.out.println("Your balance is: $" + b.getBalance() + " .\n Your account number is " + b.getAccountNo());

                    System.out.println("1.Make deposit. \n2.Withdrawal ");
                    int input2 = scanner.nextInt();
                    scanner.nextLine();

                    switch (input2) {

                        case 1:
                            System.out.println("Enter the amount you'd like to be deposited");
                            Double val = scanner.nextDouble();
                            BankAccount a = bankAccountService.makeDeposit(b, val);
                            System.out.println("Your balance is now: " + a.getBalance() + " Thank you for your continued patronage.");
                            break;
                        case 2:
                            System.out.println("Enter the amount you'd like withdrawn");
                            Double val1 = scanner.nextDouble();
                            BankAccount j = bankAccountService.makeWithdrawal(b, val1);
                            System.out.println("Your balance is now: " + j.getBalance() + " \nPress 3 to Exit");
                            break;
                        default:
                            System.out.println("The selection was invalid");
                    }
                case 4:
                    System.out.println("Exiting...Have a great day!");
                    System.exit(4);
                    break;
                default:
                    System.out.println("The selection was invalid");

            }

        }
    }
