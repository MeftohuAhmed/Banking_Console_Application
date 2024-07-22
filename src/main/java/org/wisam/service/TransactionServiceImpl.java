package org.wisam.service;

import org.wisam.dao.TransactionDAO;
import org.wisam.dao.TransactionDAOImpl;
import org.wisam.model.Transaction;
import java.util.List;

/**
 * TransactionServiceImpl class implements the TransactionService interface and provides
 * concrete implementations for the operations to manage Transaction entities.
 */
public class TransactionServiceImpl implements TransactionService {
    private TransactionDAO transactionDAO;

    /**
     * Constructor initializes the DAO implementation for transactions.
     */
    public TransactionServiceImpl() {
        this.transactionDAO = new TransactionDAOImpl();
    }

    /**
     * Adds a new transaction.
     *
     * @param transaction The transaction to be added.
     */
    @Override
    public void addTransaction(Transaction transaction) {
        transactionDAO.addTransaction(transaction);
    }

    /**
     * Retrieves all transactions for a specific account.
     *
     * @param accountNumber The account number for which transactions are to be retrieved.
     * @return A list of transactions for the specified account number.
     */
    @Override
    public List<Transaction> getTransactionsByAccount(int accountNumber) {
        return transactionDAO.getTransactionsByAccount(accountNumber);
    }
}