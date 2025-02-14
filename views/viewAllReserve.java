package views;

import controllers.ReservationController;
import models.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class viewAllReserve extends JFrame {
    private ReservationController reservationController;

    public viewAllReserve() {
        this.reservationController = new ReservationController();

        setTitle("View All Reservations");
        setSize(649, 511);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        List<Reservation> reservations = reservationController.getReservations();
        String[] columnNames = {"Reservation ID", "Customer ID", "Restaurant ID", "Pax", "Status"};
        String[][] data = new String[reservations.size()][5];

        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            data[i] = new String[]{r.getReserveID(), r.getCustomerName(), r.getRestaurantID(),
                    String.valueOf(r.getReservePax()), r.isReserveStatus() ? "Confirmed" : "Pending"};
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> {
            dispose();
        });

        buttonPanel.add(btnBack);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
}
