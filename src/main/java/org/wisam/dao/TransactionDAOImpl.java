package org.wisam.dao;

import org.wisam.model.Transaction;
import org.wisam.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TransactionDAOImpl class implements the TransactionDAO interface and provides
 * concrete implementations for the operations to manage Transaction entities.
 */
public class TransactionDAOImpl implements TransactionDAO {
    private Connection connection;

    /**
     * Constructor initializes the database connection using DatabaseConnection utility.
     */
    public TransactionDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    /**
     * Adds a new transaction to the database.
     *
     * @param transaction The transaction to be added.
     */
    @Override
    public void addTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions (account_number, amount, date) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, transaction.getAccountNumber());
            ps.setDouble(2, transaction.getAmount());
            ps.setTimestamp(3, new Timestamp(transaction.getDate().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves all transactions for a specific account from the database.
     *
     * @param accountNumber The account number for which transactions are to be retrieved.
     * @return A list of transactions for the specified account number.
     */
    @Override
    public List<Transaction> getTransactionsByAccount(int accountNumber) {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transactions WHERE account_number = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setAccountNumber(rs.getInt("account_number"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setDate(rs.getTimestamp("date"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}