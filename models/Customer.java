package models;

public class Customer {
    private String userID;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;

    public Customer(String userID, String name, String email, String phoneNumber, String password) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getUserID() { 
    	return userID; 
    	}
    
    public String getName() { 
    	return name; 
    	}
    
    public String getPassword() { 
    	return password; 
    	}


    public String getEmail() { 
    	return email; 
    	}
    
    public void setEmail(String email) { 
    	this.email = validateEmail(email); 
    	}

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = validatePhoneNumber(phoneNumber); }

    private String validateEmail(String email) {
        if (email.contains("@")) {
            return email;
        } else {
            throw new IllegalArgumentException("Invalid Email Format");
        }
    }

    private String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\d{10,12}")) { // Allows numbers between 10-12 digits
            return phoneNumber;
        } else {
            throw new IllegalArgumentException("Invalid Phone Number Format");
        }
    }
}
