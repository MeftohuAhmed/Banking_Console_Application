package org.wisam.service;

import org.wisam.dao.AccountDAO;
import org.wisam.dao.TransactionDAO;
import org.wisam.dao.AccountDAOImpl;
import org.wisam.dao.TransactionDAOImpl;
import org.wisam.model.Account;
import org.wisam.model.Transaction;

import java.util.Date;
import java.util.List;

/**
 * AccountServiceImpl class implements the AccountService interface and provides
 * concrete implementations for the operations to manage Account entities.
 */
public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;
    private TransactionDAO transactionDAO;

    /**
     * Constructor initializes the DAO implementations for account and transaction.
     */
    public AccountServiceImpl() {
        this.accountDAO = new AccountDAOImpl();
        this.transactionDAO = new TransactionDAOImpl();
    }

    /**
     * Creates a new account.
     *
     * @param account The account to be created.
     */
    @Override
    public void createAccount(Account account) {
        accountDAO.addAccount(account);
    }

    /**
     * Retrieves an account by account number.
     *
     * @param accountNumber The account number of the account to retrieve.
     * @return The account with the specified account number, or null if not found.
     */
    @Override
    public Account retrieveAccount(int accountNumber) {
        return accountDAO.getAccount(accountNumber);
    }

    /**
     * Retrieves an account by username.
     *
     * @param username The username of the account to retrieve.
     * @return The account with the specified username, or null if not found.
     */
    @Override
    public Account retrieveAccountByUsername(String username) {
        return accountDAO.getAccountByUsername(username);
    }

    /**
     * Updates an existing account.
     *
     * @param account The account with updated details.
     */
    @Override
    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
    }

    /**
     * Deletes an account by account number.
     *
     * @param accountNumber The account number of the account to delete.
     */
    @Override
    public void deleteAccount(int accountNumber) {
        accountDAO.deleteAccount(accountNumber);
    }

    /**
     * Retrieves all accounts.
     *
     * @return A list of all accounts.
     */
    @Override
    public List<Account> getAllAccounts() {
        return accountDAO.getAllAccounts();
    }

    /**
     * Transfers funds from one account to another.
     *
     * @param fromAccount The account number of the source account.
     * @param toAccount The account number of the target account.
     * @param amount The amount to transfer.
     * @throws IllegalArgumentException If the source account has insufficient funds or if any account is invalid.
     */
    @Override
    public void transferFunds(int fromAccount, int toAccount, double amount) {
        Account sourceAccount = accountDAO.getAccount(fromAccount);
        Account targetAccount = accountDAO.getAccount(toAccount);
        if (sourceAccount != null && targetAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            targetAccount.setBalance(targetAccount.getBalance() + amount);
            accountDAO.updateAccount(sourceAccount);
            accountDAO.updateAccount(targetAccount);

            Transaction sourceTransaction = new Transaction();
            sourceTransaction.setAccountNumber(fromAccount);
            sourceTransaction.setAmount(-amount);
            sourceTransaction.setDate(new Date());

            Transaction targetTransaction = new Transaction();
            targetTransaction.setAccountNumber(toAccount);
            targetTransaction.setAmount(amount);
            targetTransaction.setDate(new Date());
            transactionDAO.addTransaction(sourceTransaction);
            transactionDAO.addTransaction(targetTransaction);
        } else {
            throw new IllegalArgumentException("Insufficient funds or invalid account");
        }
    }

    /**
     * Retrieves the transaction history for a specific account.
     *
     * @param accountNumber The account number for which transactions are to be retrieved.
     * @return A list of transactions for the specified account number.
     */
    @Override
    public List<Transaction> getTransactionsByAccount(int accountNumber) {
        return transactionDAO.getTransactionsByAccount(accountNumber);
    }
}