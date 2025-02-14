package views;

import controllers.RestaurantController;
import controllers.StaffController;
import models.Restaurant;
import models.Staff;

import javax.swing.*;
import java.awt.*;

public class staffView extends JFrame {
    private RestaurantController restaurantController;
    private Staff staff;

    public staffView(Staff staff) {
    	getContentPane().setBackground(new Color(255, 128, 192));
        this.restaurantController = new RestaurantController();
        this.staff = staff;

        setTitle("Staff View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JButton btnAllRes = new JButton("View All Reservation");
        btnAllRes.setBounds(54, 113, 172, 23);
        getContentPane().add(btnAllRes);

        JButton btnEditRestDetails = new JButton("Edit Restaurant Details");
        btnEditRestDetails.setBounds(54, 170, 172, 23);
        getContentPane().add(btnEditRestDetails);

        JLabel lblHeader = new JLabel("Staff View");
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblHeader.setBounds(10, 43, 264, 14);
        getContentPane().add(lblHeader);

        JButton btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(97, 227, 89, 23);
        getContentPane().add(btnLogOut);

        btnAllRes.addActionListener(e -> new viewAllReserve().setVisible(true));

        btnEditRestDetails.addActionListener(e -> {
            Restaurant restaurant = restaurantController.getRestaurantByStaffID(staff.getUserID());
            if (restaurant != null) {
                new UpdRestDet(restaurant).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No restaurant found for this staff.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnLogOut.addActionListener(e -> {
            new UserLoginAs().setVisible(true);
            dispose();
        });
    }
}
