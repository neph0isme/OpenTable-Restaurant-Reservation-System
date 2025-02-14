package models;

public class Staff extends User {
    private String restaurantID;

    public Staff(String userID, String name, String password, String restaurantID) {
        super(userID, name, password);
        this.restaurantID = restaurantID;
    }

    public String getRestaurantID() { return restaurantID; }
    public void setRestaurantID(String restaurantID) { this.restaurantID = restaurantID; }
}
