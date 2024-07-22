package org.wisam.dao;

import org.wisam.model.Account;
import org.wisam.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AccountDAOImpl class implements the AccountDAO interface and provides
 * concrete implementations for the CRUD operations to manage Account entities.
 */
public class AccountDAOImpl implements AccountDAO {
    private Connection connection;

    /**
     * Constructor initializes the database connection using DatabaseConnection utility.
     */
    public AccountDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    /**
     * Adds a new account to the database.
     *
     * @param account The account to be added.
     */
    @Override
    public void addAccount(Account account) {
        String query = "INSERT INTO accounts (account_number, username, password, balance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, account.getAccountNumber());
            ps.setString(2, account.getUsername());
            ps.setString(3, account.getPassword());
            ps.setDouble(4, account.getBalance());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves an account from the database by account number.
     *
     * @param accountNumber The account number of the account to retrieve.
     * @return The account with the specified account number, or null if not found.
     */
    @Override
    public Account getAccount(int accountNumber) {
        Account account = null;
        String query = "SELECT * FROM accounts WHERE account_number = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                account = new Account();
                account.setAccountNumber(rs.getInt("account_number"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setBalance(rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    /**
     * Retrieves an account from the database by username.
     *
     * @param username The username of the account to retrieve.
     * @return The account with the specified username, or null if not found.
     */
    @Override
    public Account getAccountByUsername(String username) {
        Account account = null;
        String query = "SELECT * FROM accounts WHERE username = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                account = new Account();
                account.setAccountNumber(rs.getInt("account_number"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setBalance(rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    /**
     * Updates an existing account in the database.
     *
     * @param account The account with updated details.
     */
    @Override
    public void updateAccount(Account account) {
        String query = "UPDATE accounts SET username = ?, password = ?, balance = ? WHERE account_number = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.setDouble(3, account.getBalance());
            ps.setInt(4, account.getAccountNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an account from the database by account number.
     *
     * @param accountNumber The account number of the account to delete.
     */
    @Override
    public void deleteAccount(int accountNumber) {
        String query = "DELETE FROM accounts WHERE account_number = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, accountNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves all accounts from the database.
     *
     * @return A list of all accounts.
     */
    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM accounts";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Account account = new Account();
                account.setAccountNumber(rs.getInt("account_number"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setBalance(rs.getDouble("balance"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}