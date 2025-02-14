package models;

public class Reservation {
    private String reserveID;
    private String restaurantID;
    private int reservePax;
    private String customerName;
    private String phoneNumber;
    private String email;
    private String date;
    private String startTime;
    private String endTime;
    private boolean reserveStatus;
    private int rating; // ✅ Keeps rating feature

    public Reservation(String reserveID, String restaurantID, int reservePax, String customerName,
                       String phoneNumber, String email, String date, String startTime,
                       String endTime, boolean reserveStatus) {
        this.reserveID = reserveID;
        this.restaurantID = restaurantID;
        this.reservePax = reservePax;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reserveStatus = reserveStatus;
        this.rating = 0; // ✅ Default rating is 0 (not rated)
    }

    public String getReserveID() {
        return reserveID;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public int getReservePax() {
        return reservePax;
    }

    public void setReservePax(int reservePax) {
        this.reservePax = reservePax;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerID) { // Ensure this stores ID, not name
        this.customerName = customerID;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) { // ✅ Added method
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { // ✅ Added method
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) { // ✅ Already added
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) { // ✅ Already added
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) { // ✅ Already added
        this.endTime = endTime;
    }

    public boolean isReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(boolean reserveStatus) {
        this.reserveStatus = reserveStatus;
    }

    // ✅ Existing rating feature remains
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Invalid rating! Rating must be between 1 and 5.");
        }
    }
}
