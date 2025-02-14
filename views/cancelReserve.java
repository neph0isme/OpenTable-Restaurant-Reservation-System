package views;

import controllers.ReservationController;
import javax.swing.*;
import java.awt.*;

public class cancelReserve extends JFrame {
    private ReservationController reservationController;
    private String reservationID;
    private String customerID;

    public cancelReserve(String reservationID, String customerID) {
        this.reservationController = new ReservationController();
        this.reservationID = reservationID;
        this.customerID = customerID;

        getContentPane().setBackground(new Color(128, 255, 255));
        setTitle("Cancel Reservation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblText = new JLabel("Do You Want To Cancel This Booking?");
        lblText.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblText.setHorizontalAlignment(SwingConstants.CENTER);
        lblText.setBounds(10, 112, 562, 33);
        getContentPane().add(lblText);

        JButton btnYes = new JButton("Yes");
        btnYes.setBounds(146, 194, 128, 40);
        getContentPane().add(btnYes);

        JButton btnNo = new JButton("No");
        btnNo.setBounds(305, 194, 128, 40);
        getContentPane().add(btnNo);

        // ✅ Cancel reservation and return to viewReserve
        btnYes.addActionListener(e -> {
            reservationController.cancelReservation(reservationID);
            JOptionPane.showMessageDialog(this, "Your booking has been canceled.");
            new viewReserve(customerID).setVisible(true);
            dispose();
        });

        btnNo.addActionListener(e -> {
            new viewReserve(customerID).setVisible(true);
            dispose();
        });
    }
}
