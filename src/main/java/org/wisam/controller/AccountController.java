package org.wisam.controller;

import org.wisam.model.Account;
import org.wisam.service.AccountService;
import org.wisam.service.AccountServiceImpl;

import java.util.Scanner;

/**
 * AccountController class is responsible for handling user interactions and
 * controlling the flow of the application. It interacts with the AccountService
 * to perform various operations such as signing up, signing in, checking balance,
 * transferring funds, and viewing transactions.
 */
public class AccountController {
    private AccountService accountService;
    private Scanner scanner;

    /**
     * Constructor initializes the AccountService and Scanner.
     */
    public AccountController() {
        this.accountService = new AccountServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    /**
     * The start method displays the main menu and handles user input for
     * various actions like signing up, signing in, and exiting the application.
     */
    public void start() {
        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    signIn();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Handles user input for signing up a new account. Prompts the user for
     * account details and creates a new account using the AccountService.
     */
    private void signUp() {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter initial balance: ");
        double balance = scanner.nextDouble();

        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setUsername(username);
        account.setPassword(password);
        account.setBalance(balance);

        accountService.createAccount(account);
        System.out.println("Account created successfully.");
    }

    /**
     * Handles user input for signing in. Prompts the user for username and
     * password, and if the credentials are correct, navigates to the user menu.
     */
    private void signIn() {
        System.out.println("Enter username: ");
        String username = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();

        Account account = accountService.retrieveAccountByUsername(username);
        if (account != null && account.getPassword().equals(password)) {
            userMenu(account);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    /**
     * Displays the user menu and handles user input for various actions like
     * checking balance, transferring funds, viewing transactions, and logging out.
     */
    private void userMenu(Account account) {
        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Transfer Funds");
            System.out.println("3. View Transactions");
            System.out.println("4. Logout");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance(account);
                    break;
                case 2:
                    transferFunds(account);
                    break;
                case 3:
                    viewTransactions(account);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Displays the current balance of the user's account.
     */
    private void checkBalance(Account account) {
        System.out.println("Current Balance: " + account.getBalance());
    }

    /**
     * Handles user input for transferring funds. Prompts the user for target
     * account number and amount, and performs the transfer using the AccountService.
     */
    private void transferFunds(Account account) {
        System.out.println("Enter target account number: ");
        int targetAccountNumber = scanner.nextInt();
        System.out.println("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        try {
            accountService.transferFunds(account.getAccountNumber(), targetAccountNumber, amount);
            System.out.println("Transfer successful.");
        } catch (IllegalArgumentException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
    }

    /**
     * Displays the transaction history of the user's account.
     */
    private void viewTransactions(Account account) {
        accountService.getTransactionsByAccount(account.getAccountNumber()).forEach(transaction -> {
            System.out.println("Transaction ID: " + transaction.getId());
            System.out.println("Account Number: " + transaction.getAccountNumber());
            System.out.println("Amount: " + transaction.getAmount());
            System.out.println("Date: " + transaction.getDate());
            System.out.println("-----------------------------");
        });
    }
}