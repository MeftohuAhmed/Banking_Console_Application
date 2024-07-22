package org.wisam.dao;

import org.wisam.model.Account;
import java.util.List;

/**
 * AccountDAO interface defines the CRUD operations for managing Account entities.
 * It provides methods to add, retrieve, update, delete, and get all accounts.
 */
public interface AccountDAO {

    /**
     * Adds a new account to the database.
     *
     * @param account The account to be added.
     */
    void addAccount(Account account);

    /**
     * Retrieves an account from the database by account number.
     *
     * @param accountNumber The account number of the account to retrieve.
     * @return The account with the specified account number, or null if not found.
     */
    Account getAccount(int accountNumber);

    /**
     * Retrieves an account from the database by username.
     *
     * @param username The username of the account to retrieve.
     * @return The account with the specified username, or null if not found.
     */
    Account getAccountByUsername(String username);

    /**
     * Updates an existing account in the database.
     *
     * @param account The account with updated details.
     */
    void updateAccount(Account account);

    /**
     * Deletes an account from the database by account number.
     *
     * @param accountNumber The account number of the account to delete.
     */
    void deleteAccount(int accountNumber);

    /**
     * Retrieves all accounts from the database.
     *
     * @return A list of all accounts.
     */
    List<Account> getAllAccounts();
}