package controllers;

import database.DatabaseManager;
import models.Reservation;
import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class ReservationController {
    private DatabaseManager db;

    public ReservationController() {
        this.db = DatabaseManager.getInstance(); 
    }

    public List<Reservation> getReservations() {
        return db.getReservations();
    }

    public List<Reservation> getReservationsByCustomer(String customerID) {
        List<Reservation> customerReservations = new ArrayList<>();
        for (Reservation r : db.getReservations()) {
            if (r.getCustomerName().equals(customerID)) { // ✅ Matches customerID
                customerReservations.add(r);
            }
        }
        return customerReservations;
    }

    public Reservation getReservationByID(String reservationID) {
        for (Reservation r : db.getReservations()) {
            if (r.getReserveID().equals(reservationID)) {
                return r;
            }
        }
        return null;
    }

    public Customer getCustomerByID(String customerID) {
        return db.getCustomerByUsername(customerID); // ✅ Uses getCustomerByUsername()
    }

    public void addReservation(Reservation reservation) {
        db.addReservation(reservation);
    }

    public void cancelReservation(String reservationID) {
        db.getReservations().removeIf(r -> r.getReserveID().equals(reservationID));
    }

    public void updateReservation(Reservation updatedReservation) {
        db.updateReservation(updatedReservation);
    }

    public void rateReservation(String reservationID, int rating) {
        for (Reservation r : db.getReservations()) {
            if (r.getReserveID().equals(reservationID)) {
                r.setRating(rating);
                db.updateReservation(r);
                break;
            }
        }
    }
}
