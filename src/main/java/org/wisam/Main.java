package org.wisam;

import org.wisam.controller.AccountController;

/**
 * Main class to start the ATM application.
 */
public class Main {
    /**
     * The main method to start the application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Create an instance of AccountController and start the application
        AccountController accountController = new AccountController();
        accountController.start();
    }
}