package views;

import controllers.ReservationController;
import models.Customer;
import models.Reservation;

import javax.swing.*;
import java.awt.*;

public class PaxPage extends JFrame {
    private JTextField nameField, phoneField, emailField;
    private JSpinner paxSpinner;
    private Reservation reservation;
    private Customer customer;
    private ReservationController reservationController;

    public PaxPage(Reservation reservation, Customer customer) {
        this.reservation = reservation;
        this.customer = customer;
        this.reservationController = new ReservationController();

        setTitle("Pax Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350); 
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        formPanel.setBackground(new Color(128, 255, 255));

        formPanel.add(new JLabel("Choose pax:"));
        paxSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
        formPanel.add(paxSpinner);

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        nameField.setText(customer.getName());
        formPanel.add(nameField);

        formPanel.add(new JLabel("Phone Number:"));
        phoneField = new JTextField(20);
        phoneField.setText(customer.getPhoneNumber());
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField(20);
        emailField.setText(customer.getEmail());
        formPanel.add(emailField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(new Color(128, 255, 255));

        JButton btnBack = new JButton("Back"); 
        JButton btnConfirm = new JButton("Confirm"); 

        btnConfirm.addActionListener(e -> saveReservationDetails());
        btnBack.addActionListener(e -> {
            new ChooseDateTimePage(reservation, customer).setVisible(true);
            dispose();
        });

        buttonPanel.add(btnBack);
        buttonPanel.add(btnConfirm);

        getContentPane().add(formPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void saveReservationDetails() {
        reservation.setReservePax((int) paxSpinner.getValue());
        reservation.setCustomerName(customer.getUserID());
        reservation.setPhoneNumber(phoneField.getText());
        reservation.setEmail(emailField.getText());

        reservationController.updateReservation(reservation);
        JOptionPane.showMessageDialog(this, "Reservation Updated!");

        new depositPayment(reservation, customer).setVisible(true);
        dispose();
    }
}
