package views;

import controllers.CustomerController;
import javax.swing.*;
import java.awt.*;

public class CustomerSignUp extends JFrame {
    private JTextField txt_fname, txt_lname, txt_phone, txt_username, txt_pass, txt_email;
    private CustomerController customerController;

    public CustomerSignUp() {
        customerController = new CustomerController(); // ✅ Use controller

        setTitle("Create New Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 713, 576);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 255, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Create New Account", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTitle.setBounds(208, 51, 262, 35);
        contentPane.add(lblTitle);

        addFormFields(contentPane);
        addButtons(contentPane);
    }

    private void addFormFields(JPanel contentPane) {
        String[] labels = {"First Name", "Last Name", "Phone No.", "Username", "Password", "Email"};
        int yOffset = 130;
        JTextField[] fields = {txt_username = new JTextField(), txt_pass = new JTextField(),
                txt_fname = new JTextField(), txt_lname = new JTextField(),
                txt_phone = new JTextField(), txt_email = new JTextField()};

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i], SwingConstants.RIGHT);
            label.setFont(new Font("Tahoma", Font.PLAIN, 16));
            label.setBounds(180, yOffset, 108, 20);
            contentPane.add(label);

            fields[i].setBounds(309, yOffset, 125, 20);
            contentPane.add(fields[i]);
            yOffset += 40;
        }
    }

    private void addButtons(JPanel contentPane) {
        JButton btnCreateAcc = new JButton("CREATE ACCOUNT");
        btnCreateAcc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCreateAcc.setBounds(258, 374, 175, 29);
        contentPane.add(btnCreateAcc);

        JLabel lblExisting = new JLabel("Have an existing account?");
        lblExisting.setHorizontalAlignment(SwingConstants.CENTER);
        lblExisting.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblExisting.setBounds(231, 414, 191, 19);
        contentPane.add(lblExisting);

        JLabel lblLogin = new JLabel("Login", SwingConstants.CENTER);
        lblLogin.setForeground(Color.BLUE);
        lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLogin.setBounds(406, 414, 64, 19);
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new CustomerLogin().setVisible(true);
                dispose();
            }
        });
        contentPane.add(lblLogin);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(305, 503, 89, 23);
        contentPane.add(btnBack);

        btnBack.addActionListener(e -> {
            new UserLoginAs().setVisible(true);
            dispose();
        });

        btnCreateAcc.addActionListener(e -> createAccount());
    }

    private void createAccount() {
        // ✅ Call controller instead of handling logic here
        boolean success = customerController.createCustomer(
                txt_username.getText(), txt_fname.getText(), txt_lname.getText(),
                txt_email.getText(), txt_phone.getText(), txt_pass.getText()
        );

        if (success) {
            JOptionPane.showMessageDialog(this, "Account created successfully!");
            new CustomerLogin().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error: Missing required fields!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
