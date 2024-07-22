package org.wisam.service;

import org.wisam.model.Transaction;
import java.util.List;

/**
 * TransactionService interface defines the operations for managing Transaction entities.
 * It provides methods to add transactions and retrieve transactions by account number.
 */
public interface TransactionService {

    /**
     * Adds a new transaction.
     *
     * @param transaction The transaction to be added.
     */
    void addTransaction(Transaction transaction);

    /**
     * Retrieves all transactions for a specific account.
     *
     * @param accountNumber The account number for which transactions are to be retrieved.
     * @return A list of transactions for the specified account number.
     */
    List<Transaction> getTransactionsByAccount(int accountNumber);
}