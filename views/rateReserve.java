package views;

import controllers.ReservationController;
import javax.swing.*;
import java.awt.*;

public class rateReserve extends JFrame {
    private ReservationController reservationController;
    private String reservationID;
    private String customerID;

    public rateReserve(String reservationID, String customerID) {
        this.reservationController = new ReservationController();
        this.reservationID = reservationID;
        this.customerID = customerID;

        getContentPane().setBackground(new Color(128, 255, 255));
        setTitle("Rate Reservation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(220, 300);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(7, 1));

        JLabel lblText = new JLabel("Rate your reservation (1-5 stars):", SwingConstants.CENTER);
        getContentPane().add(lblText);

        ButtonGroup group = new ButtonGroup();
        JRadioButton[] starButtons = new JRadioButton[5];
        for (int i = 0; i < 5; i++) {
            starButtons[i] = new JRadioButton((i + 1) + " Star");
            getContentPane().add(starButtons[i]);
            group.add(starButtons[i]);
        }

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(e -> {
            for (int i = 0; i < 5; i++) {
                if (starButtons[i].isSelected()) {
                    reservationController.rateReservation(reservationID, i + 1);
                    JOptionPane.showMessageDialog(this, "Thank you for your rating!");
                    new viewReserve(customerID).setVisible(true);
                    dispose();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Please select a rating.");
        });

        getContentPane().add(btnSubmit);
    }
}
