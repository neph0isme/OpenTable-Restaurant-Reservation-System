package models;

public class Restaurant {
    private String restaurantID;
    private String restaurantName;
    private String cuisineType;
    private String location;
    private int restPax;
    private double rating;
    private String staffID; // ✅ Links restaurant to staff

    public Restaurant(String restaurantID, String restaurantName, String cuisineType, 
                      String location, int restPax, double rating, String staffID) {
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.cuisineType = cuisineType;
        this.location = location;
        this.restPax = restPax;
        this.rating = rating;
        this.staffID = staffID;
    }

    // Getters
    public String getRestaurantID() { return restaurantID; }
    public String getName() { return restaurantName; }
    public String getCuisineType() { return cuisineType; }
    public String getLocation() { return location; }
    public int getRestPax() { return restPax; }
    public double getRating() { return rating; }
    public String getStaffID() { return staffID; }

    // Setters
    public void setRestaurantID(String restaurantID) { this.restaurantID = restaurantID; }
    public void setName(String restaurantName) { this.restaurantName = restaurantName; }
    public void setCuisineType(String cuisineType) { this.cuisineType = cuisineType; }
    public void setLocation(String location) { this.location = location; }
    public void setRestPax(int restPax) { this.restPax = restPax; }
    public void setRating(double rating) { this.rating = rating; }
    public void setStaffID(String staffID) { this.staffID = staffID; }
}
