package org.wisam.dao;

import org.wisam.model.Transaction;
import java.util.List;

/**
 * TransactionDAO interface defines the operations for managing Transaction entities.
 * It provides methods to add transactions and retrieve transactions by account number.
 */
public interface TransactionDAO {

    /**
     * Adds a new transaction to the database.
     *
     * @param transaction The transaction to be added.
     */
    void addTransaction(Transaction transaction);

    /**
     * Retrieves all transactions for a specific account from the database.
     *
     * @param accountNumber The account number for which transactions are to be retrieved.
     * @return A list of transactions for the specified account number.
     */
    List<Transaction> getTransactionsByAccount(int accountNumber);
}