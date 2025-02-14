package database;

import models.Reservation;
import models.Customer;
import models.Staff;
import models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private List<Reservation> reservations = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Staff> staffList = new ArrayList<>();
    private List<Restaurant> restaurants = new ArrayList<>();

    private static DatabaseManager instance;

    public DatabaseManager() { // ✅ Private constructor for Singleton
        preloadData();
    }

    public static DatabaseManager getInstance() { // ✅ Fixed Singleton pattern
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    private void preloadData() {
        // ✅ Pre-Stored Customers
        customers.add(new Customer("liana02", "Liana Johari", "liana@gmail.com", "0122234466", "121212"));
        customers.add(new Customer("zulanep", "Zulhanif Ramli", "zul@gmail.com", "0165523433", "110404"));

        // ✅ Pre-Stored Staff
        staffList.add(new Staff("R001", "Amiezah", "rest123", "REST1"));
        staffList.add(new Staff("R002", "Harris", "rest456", "REST2"));

        // ✅ Pre-Stored Restaurants
        restaurants.add(new Restaurant("REST1", "Sushi Paradise", "Japanese Cuisine", "Shah Alam", 80, 4.5, "R001"));
        restaurants.add(new Restaurant("REST2", "Pasta Anjay", "Italian Cuisine", "Nilai", 60, 4.3, "R002"));

        // ✅ Pre-Stored Reservations
        reservations.add(new Reservation("B001", "REST1", 4, "liana02", "0122234466", "liana@gmail.com", "2025-02-15", "18:00", "20:00", true));
        reservations.add(new Reservation("B002", "REST2", 2, "zulanep", "0165523433", "zul@gmail.com", "2025-02-16", "19:00", "21:00", false));
    }

    // ✅ Fetch all reservations
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void updateReservation(Reservation updatedReservation) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReserveID().equals(updatedReservation.getReserveID())) {
                reservations.set(i, updatedReservation);
                break;
            }
        }
    }

    // ✅ Fetch customer by username
    public Customer getCustomerByUsername(String username) {
        for (Customer c : customers) {
            if (c.getUserID().equals(username)) {
                return c;
            }
        }
        return null;
    }

    // ✅ Fetch all customers
    public List<Customer> getCustomers() {
        return customers;
    }

    // ✅ Add a new customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // ✅ Fetch staff by username
    public Staff getStaffByUsername(String username) {
        for (Staff staff : staffList) {
            if (staff.getUserID().equals(username)) {
                return staff;
            }
        }
        return null;
    }

    // ✅ Fetch all restaurants
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    // ✅ Update restaurant details
    public void updateRestaurant(Restaurant updatedRestaurant) {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getRestaurantID().equals(updatedRestaurant.getRestaurantID())) {
                restaurants.set(i, updatedRestaurant);
                break;
            }
        }
    }
}
