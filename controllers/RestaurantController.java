package controllers;

import database.DatabaseManager;
import models.Restaurant;
import java.util.List;

public class RestaurantController {
    private DatabaseManager db;

    public RestaurantController() {
        this.db = new DatabaseManager();
    }

    public void updateRestaurant(Restaurant restaurant) {
        db.updateRestaurant(restaurant);
    }

    // ✅ Added this method to fetch a restaurant by staff ID
    public Restaurant getRestaurantByStaffID(String staffID) {
        List<Restaurant> restaurants = db.getRestaurants();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getStaffID().equals(staffID)) {
                return restaurant; // ✅ Returns the restaurant managed by the given staff ID
            }
        }
        return null; // If no restaurant is found
    }
}
