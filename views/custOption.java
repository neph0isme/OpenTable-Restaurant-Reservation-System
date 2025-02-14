package views;

import models.Customer;

import javax.swing.*;
import java.awt.*;

public class custOption extends JFrame {
    private Customer customer;

    public custOption(Customer customer) {
    	getContentPane().setBackground(new Color(128, 255, 255)); 
        this.customer = customer;

        setTitle("Pick Your Options");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JButton btnViewRest = new JButton("View Restaurant");
        btnViewRest.setBounds(129, 120, 140, 23);
        getContentPane().add(btnViewRest);

        JButton btnViewReserve = new JButton("View Reserve");
        btnViewReserve.setBounds(129, 175, 140, 23);
        getContentPane().add(btnViewReserve);

        JLabel lblText = new JLabel("Welcome, " + (customer != null ? customer.getName() : "Guest"));
        lblText.setHorizontalAlignment(SwingConstants.TRAILING);
        lblText.setBounds(44, 58, 209, 14);
        getContentPane().add(lblText);

        btnViewRest.addActionListener(e -> {
            new selectPicture(customer).setVisible(true); // ✅ Pass customer
            dispose();
        });

        btnViewReserve.addActionListener(e -> {
            new viewReserve(customer.getUserID()).setVisible(true); // ✅ Pass customer ID
            dispose();
        });

        // ✅ Add logout button
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(129, 220, 140, 23);
        getContentPane().add(btnLogout);

        btnLogout.addActionListener(e -> {
            new UserLoginAs().setVisible(true);
            dispose();
        });
    }
}
