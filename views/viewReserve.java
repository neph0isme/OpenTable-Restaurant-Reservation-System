package views;

import controllers.ReservationController;
import models.Customer;
import models.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class viewReserve extends JFrame {
    private ReservationController reservationController;
    private String customerID;
    private Customer customer;

    public viewReserve(String customerID) {
        this.reservationController = new ReservationController();
        this.customerID = customerID;
        this.customer = reservationController.getCustomerByID(customerID); // ✅ Retrieve customer

        setTitle("View Reservations");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        List<Reservation> reservations = reservationController.getReservationsByCustomer(customerID);
        String[] columnNames = {"Reservation ID", "Restaurant ID", "Pax", "Date", "Time", "Status"};
        String[][] data = new String[reservations.size()][6];

        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            data[i] = new String[]{r.getReserveID(), r.getRestaurantID(),
                    String.valueOf(r.getReservePax()), r.getDate(),
                    r.getStartTime() + " - " + r.getEndTime(),
                    r.isReserveStatus() ? "Confirmed" : "Pending"};
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            new custOption(customer).setVisible(true);
            dispose();
        });

        JButton btnCancel = new JButton("Cancel Reservation");
        btnCancel.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String reservationID = (String) table.getValueAt(selectedRow, 0);
                new cancelReserve(reservationID, customerID).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a reservation to cancel.");
            }
        });

        JButton btnEdit = new JButton("Edit Reservation");
        btnEdit.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String reservationID = (String) table.getValueAt(selectedRow, 0);
                new editReservation(reservationID, customerID).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a reservation to edit.");
            }
        });

        JButton btnRate = new JButton("Rate Reservation");
        btnRate.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String reservationID = (String) table.getValueAt(selectedRow, 0);
                new rateReserve(reservationID, customerID).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a reservation to rate.");
            }
        });

        buttonPanel.add(btnBack);
        buttonPanel.add(btnCancel);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnRate);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
}
