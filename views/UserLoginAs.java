package views;

import javax.swing.*;

import models.Customer;

import java.awt.*;

public class UserLoginAs extends JFrame {
    public UserLoginAs() {
    	getContentPane().setBackground(new Color(0, 128, 192));
        setTitle("Login As");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Login As...", SwingConstants.CENTER);
        titleLabel.setBounds(10, 254, 564, 22);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        getContentPane().add(titleLabel);
        JButton staffLoginBtn = new JButton("Staff");
        staffLoginBtn.setBounds(173, 324, 227, 26);
        getContentPane().add(staffLoginBtn);
        JButton customerLoginBtn = new JButton("Customer");
        customerLoginBtn.setBounds(173, 287, 227, 26);
        getContentPane().add(customerLoginBtn);
        
        JLabel lblNewLabel = new JLabel("Welcome to");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 85, 564, 14);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("OpenTable");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 110, 564, 58);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Restaurant reservation System");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(10, 176, 564, 14);
        getContentPane().add(lblNewLabel_2);
        
                customerLoginBtn.addActionListener(e -> {
                    new CustomerLogin().setVisible(true); // ✅ Opens Customer login page
                    dispose();
                });
        
                staffLoginBtn.addActionListener(e -> {
                    new RestStaffLogin().setVisible(true); // ✅ Opens Staff login page
                    dispose();
                });

        setVisible(true);
    }

}
