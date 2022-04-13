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


        int input;
        do {
            System.out.println("Welcome to the Ambiguous Corporate Industries(TM) Banking Terminal");
            System.out.println("1. Create New Account \n2. Forgot username? \n3.Login \n4.Exit");
            input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1:
                    System.out.println("We're happy to welcome you to our contractual family!");
                    System.out.println("Please enter your first name:");
                    String fName = scanner.nextLine();
                    System.out.println("Please enter your last name:");
                    String lName = scanner.nextLine();
                    System.out.println("Please enter your preferred Phone number:");
                    String mobileNo = scanner.nextLine();
                    System.out.println("Please enter your desired username:");
                    String userName = scanner.nextLine();
                    System.out.println("Please enter your desired password,  please keep a copy for your own records.");
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

                    System.out.println("A.Make deposit. \nB.Withdrawal ");
                    String branch = scanner.nextLine().toUpperCase();
                    scanner.nextLine();

                    switch (branch) {

                        case "A":
                            System.out.println("Enter the amount you'd like to have deposited:");
                            Double val = scanner.nextDouble();
                            BankAccount a = bankAccountService.makeDeposit(b, val);
                            System.out.println(a.getFirstName()+ " your balance is now: " + a.getBalance() + " Thank you for your continued patronage.");
                            break;
                        case "B":
                            System.out.println("Enter the amount you'd like to have withdrawn:");
                            Double val1 = scanner.nextDouble();
                            BankAccount j = bankAccountService.makeWithdrawal(b, val1);
                            if((j.getBalance()-val1)<0) {
                                System.out.println("Your balance is now: " + (j.getBalance()- 35 )+ " \nPlease be aware there is a $35 charge associated with each overdraft.");
                            }else System.out.println("Your balance is now:" + j.getBalance());
                           break;
                        default:
                            System.out.println("The selection was invalid");
                    }
                case 4:
                    System.out.println("...exiting...");
                    break;
                default:
                    System.out.println("The selection was invalid");
            }
        }
        while (input !=4 );
    }
}
