package org.wisam.service;

import org.wisam.model.Account;
import org.wisam.model.Transaction;

import java.util.List;

/**
 * AccountService interface defines the operations for managing Account entities.
 * It provides methods for account creation, retrieval, update, deletion, funds transfer,
 * and transaction history retrieval.
 */
public interface AccountService {

    /**
     * Creates a new account.
     *
     * @param account The account to be created.
     */
    void createAccount(Account account);

    /**
     * Retrieves an account by account number.
     *
     * @param accountNumber The account number of the account to retrieve.
     * @return The account with the specified account number, or null if not found.
     */
    Account retrieveAccount(int accountNumber);

    /**
     * Retrieves an account by username.
     *
     * @param username The username of the account to retrieve.
     * @return The account with the specified username, or null if not found.
     */
    Account retrieveAccountByUsername(String username);

    /**
     * Updates an existing account.
     *
     * @param account The account with updated details.
     */
    void updateAccount(Account account);

    /**
     * Deletes an account by account number.
     *
     * @param accountNumber The account number of the account to delete.
     */
    void deleteAccount(int accountNumber);

    /**
     * Retrieves all accounts.
     *
     * @return A list of all accounts.
     */
    List<Account> getAllAccounts();

    /**
     * Transfers funds from one account to another.
     *
     * @param fromAccount The account number of the source account.
     * @param toAccount The account number of the target account.
     * @param amount The amount to transfer.
     * @throws IllegalArgumentException If the source account has insufficient funds or if any account is invalid.
     */
    void transferFunds(int fromAccount, int toAccount, double amount);

    /**
     * Retrieves the transaction history for a specific account.
     *
     * @param accountNumber The account number for which transactions are to be retrieved.
     * @return A list of transactions for the specified account number.
     */
    List<Transaction> getTransactionsByAccount(int accountNumber);
}