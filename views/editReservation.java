package views;

import controllers.ReservationController;
import models.Reservation;

import javax.swing.*;
import java.awt.*;

public class editReservation extends JFrame {
    private JTextField nameField, phoneField, emailField;
    private JSpinner paxSpinner;
    private ReservationController reservationController;
    private Reservation reservation;
    private String customerID;

    public editReservation(String reservationID, String customerID) {
        this.reservationController = new ReservationController();
        this.reservation = reservationController.getReservationByID(reservationID);
        this.customerID = customerID;

        getContentPane().setBackground(new Color(128, 255, 255));
        setTitle("Edit Reservation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        formPanel.add(new JLabel("Edit Pax Number:"));
        paxSpinner = new JSpinner(new SpinnerNumberModel(reservation.getReservePax(), 1, 100, 1));
        formPanel.add(paxSpinner);

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField(reservation.getCustomerName());
        formPanel.add(nameField);

        formPanel.add(new JLabel("Phone Number:"));
        phoneField = new JTextField(reservation.getPhoneNumber());
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField(reservation.getEmail());
        formPanel.add(emailField);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(e -> {
            reservation.setReservePax((int) paxSpinner.getValue());
            reservation.setCustomerName(nameField.getText());
            reservation.setPhoneNumber(phoneField.getText());
            reservation.setEmail(emailField.getText());

            reservationController.updateReservation(reservation);
            JOptionPane.showMessageDialog(this, "Reservation Updated Successfully!");
            new viewReserve(customerID).setVisible(true);
            dispose();
        });

        getContentPane().add(formPanel, BorderLayout.CENTER);
        getContentPane().add(btnSave, BorderLayout.SOUTH);
    }
}
