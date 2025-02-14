package views;

import controllers.RestaurantController;
import models.Restaurant;

import javax.swing.*;
import java.awt.*;

public class UpdRestDet extends JFrame {
    private JTextField restaurantNameField, cuisineTypeField, locationField;
    private JSpinner paxSpinner;
    private RestaurantController restaurantController;
    private Restaurant restaurant;

    public UpdRestDet(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.restaurantController = new RestaurantController();

        setTitle("Update Restaurant Details");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);

        JLabel label = new JLabel("Restaurant Name:");
        label.setBounds(0, 1, 287, 69);
        formPanel.add(label);
        restaurantNameField = new JTextField(restaurant.getName());
        restaurantNameField.setBounds(297, 1, 287, 69);
        formPanel.add(restaurantNameField);

        JLabel label_1 = new JLabel("Type of Cuisine:");
        label_1.setBounds(0, 80, 287, 69);
        formPanel.add(label_1);
        cuisineTypeField = new JTextField(restaurant.getCuisineType());
        cuisineTypeField.setBounds(297, 80, 287, 69);
        formPanel.add(cuisineTypeField);

        JLabel label_2 = new JLabel("Location:");
        label_2.setBounds(0, 159, 287, 69);
        formPanel.add(label_2);
        locationField = new JTextField(restaurant.getLocation());
        locationField.setBounds(297, 159, 287, 69);
        formPanel.add(locationField);

        JLabel label_3 = new JLabel("Number of Pax:");
        label_3.setBounds(0, 238, 287, 69);
        formPanel.add(label_3);
        paxSpinner = new JSpinner(new SpinnerNumberModel(restaurant.getRestPax(), 1, 100, 1));
        paxSpinner.setBounds(297, 238, 287, 69);
        formPanel.add(paxSpinner);

        getContentPane().add(formPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(142, 318, 299, 23);
        formPanel.add(saveButton);

        // ✅ Added Back button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(485, 377, 89, 23);
        formPanel.add(btnBack);

        saveButton.addActionListener(e -> saveRestaurantDetails());

        // ✅ Back button returns to staffView
        btnBack.addActionListener(e -> {
            new staffView(null).setVisible(true); // Navigate back to staffView
            dispose();
        });
    }

    private void saveRestaurantDetails() {
        restaurant.setName(restaurantNameField.getText());
        restaurant.setCuisineType(cuisineTypeField.getText());
        restaurant.setLocation(locationField.getText());
        restaurant.setRestPax((int) paxSpinner.getValue());

        restaurantController.updateRestaurant(restaurant);
        JOptionPane.showMessageDialog(this, "Restaurant details updated successfully!");
    }
}
