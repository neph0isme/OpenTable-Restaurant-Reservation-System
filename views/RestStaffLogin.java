package views;

import controllers.StaffController;
import models.Staff;

import javax.swing.*;
import java.awt.*;

public class RestStaffLogin extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private StaffController staffController;

    public RestStaffLogin() {
        this.staffController = new StaffController();

        setTitle("Restaurant Staff Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBackground(new Color(255, 128, 192));

        formPanel.add(new JLabel("Username:"));
        usernameField = new JTextField(20);
        formPanel.add(usernameField);

        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> validateLogin());

        getContentPane().add(formPanel, BorderLayout.CENTER);
        getContentPane().add(loginButton, BorderLayout.SOUTH);
    }

    private void validateLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        Staff staff = staffController.getStaffByUsername(username);

        if (staff != null && staff.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            new staffView(staff).setVisible(true); // ✅ Passes the Staff object
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
