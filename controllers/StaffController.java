package controllers;

import database.DatabaseManager;
import models.Staff;

public class StaffController {
    private DatabaseManager db;

    public StaffController() {
        this.db = new DatabaseManager();
    }

    public Staff getStaffByUsername(String username) {
        return db.getStaffByUsername(username);
    }
}
