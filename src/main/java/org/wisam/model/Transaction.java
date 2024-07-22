package org.wisam.model;

import java.util.Date;

/**
 * Transaction class represents a transaction entity with an ID, account number,
 * amount, and date.
 */
public class Transaction {
    private int id;
    private int accountNumber;
    private double amount;
    private Date date;

    /**
     * Gets the transaction ID.
     *
     * @return The transaction ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the transaction ID.
     *
     * @param id The transaction ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the account number associated with the transaction.
     *
     * @return The account number.
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number associated with the transaction.
     *
     * @param accountNumber The account number to set.
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the transaction amount.
     *
     * @return The transaction amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the transaction amount.
     *
     * @param amount The transaction amount to set.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the date of the transaction.
     *
     * @return The transaction date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the transaction.
     *
     * @param date The transaction date to set.
     */
    public void setDate(Date date) {
        this.date = date;
    }
}