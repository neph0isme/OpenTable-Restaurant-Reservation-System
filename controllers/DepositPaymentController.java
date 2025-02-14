package controllers;

import models.Reservation;
import database.DatabaseManager;

public class DepositPaymentController {
    private DatabaseManager db;

    public DepositPaymentController() {
        this.db = new DatabaseManager();
    }

    // ✅ Updates reservation status after payment
    public void confirmPayment(Reservation reservation) {
        reservation.setReserveStatus(true);  // Mark as confirmed
        db.updateReservation(reservation);   // Save to database
    }
}
