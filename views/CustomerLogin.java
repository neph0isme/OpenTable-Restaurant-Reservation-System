package views;

import controllers.CustomerController;
import models.Customer;

import javax.swing.*;
import java.awt.*;

public class CustomerLogin extends JFrame {
    private JTextField txt_username, txt_pass;
    private CustomerController customerController;

    public CustomerLogin() {
        customerController = new CustomerController();

        setTitle("Customer Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 660, 480);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 255, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTitle = new JLabel("Login as Customer", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitle.setBounds(170, 97, 294, 37);
        contentPane.add(lblTitle);

        addFormFields(contentPane);
        addButtons(contentPane);
    }

    private void addFormFields(JPanel contentPane) {
        JLabel lblUsername = new JLabel("Username", SwingConstants.RIGHT);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername.setBounds(181, 178, 92, 14);
        contentPane.add(lblUsername);

        txt_username = new JTextField();
        txt_username.setBounds(283, 177, 132, 20);
        contentPane.add(txt_username);

        JLabel lblPassword = new JLabel("Password", SwingConstants.RIGHT);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword.setBounds(196, 219, 77, 14);
        contentPane.add(lblPassword);

        txt_pass = new JPasswordField();
        txt_pass.setBounds(283, 218, 132, 20);
        contentPane.add(txt_pass);
    }

    private void addButtons(JPanel contentPane) {
        JButton loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        loginButton.setBounds(283, 266, 89, 23);
        contentPane.add(loginButton);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(283, 407, 89, 23);
        contentPane.add(btnBack);

        JLabel lblNoAccount = new JLabel("Do not have an account yet?", SwingConstants.CENTER);
        lblNoAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNoAccount.setBounds(196, 326, 242, 25);
        contentPane.add(lblNoAccount);

        JLabel lblCreateAccount = new JLabel("Create an account", SwingConstants.CENTER);
        lblCreateAccount.setForeground(Color.BLUE);
        lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblCreateAccount.setBounds(255, 351, 140, 14);
        lblCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new CustomerSignUp().setVisible(true);
                dispose();
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCreateAccount.setForeground(Color.BLACK);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCreateAccount.setForeground(Color.BLUE);
            }
        });
        contentPane.add(lblCreateAccount);

        loginButton.addActionListener(e -> login());
        btnBack.addActionListener(e -> {
            new UserLoginAs().setVisible(true);
            dispose();
        });
    }

    private void login() {
        String username = txt_username.getText();
        String password = txt_pass.getText();
        Customer loggedInCustomer = customerController.validateCustomerLogin(username, password);

        if (loggedInCustomer != null) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            new custOption(loggedInCustomer).setVisible(true); // ✅ Properly pass customer object
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Login Unsuccessful", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
