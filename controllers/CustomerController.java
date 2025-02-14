package controllers;

import models.Customer;
import database.DatabaseManager;

public class CustomerController {
    private DatabaseManager db;

    public CustomerController() {
        this.db = DatabaseManager.getInstance(); // ✅ Singleton pattern
    }

    public boolean createCustomer(String username, String firstName, String lastName, String email, String phone, String password) {
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            return false; 
        }
        Customer newCustomer = new Customer(username, firstName + " " + lastName, email, phone, password);
        db.addCustomer(newCustomer);
        return true;
    }

    public Customer getCustomerByUsername(String username) {
        return db.getCustomerByUsername(username);
    }

    public Customer validateCustomerLogin(String username, String password) {
        Customer customer = db.getCustomerByUsername(username);
        if (customer != null && customer.getPassword().equals(password)) {
            return customer;
        }
        return null;
    }
}
