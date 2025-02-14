package views;

import controllers.DepositPaymentController;
import controllers.ReservationController;
import models.Reservation;
import models.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class depositPayment extends JFrame {
    private Reservation reservation;
    private ReservationController reservationController;
    private DepositPaymentController depositPaymentController;
    private Customer customer;

    public depositPayment(Reservation reservation, Customer customer) {
        this.reservation = reservation;
        this.customer = customer;
        this.reservationController = new ReservationController();
        this.depositPaymentController = new DepositPaymentController();

        setTitle("Deposit Payment");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // ----------------- Top Panel (Title) -----------------
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(128, 255, 255));
        JLabel titleLabel = new JLabel("Deposit Payment", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(titleLabel);

        // ----------------- Center Panel (Payment Methods) -----------------
        JPanel centerPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        centerPanel.setBackground(new Color(128, 255, 255));
        JLabel methodLabel = new JLabel("Choose Payment Method:", SwingConstants.CENTER);
        methodLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        centerPanel.add(methodLabel);

        JButton onlineBankingButton = new JButton("Online Banking");
        JButton eWalletButton = new JButton("E-Wallet");
        JButton cardButton = new JButton("Credit/Debit Card");

        centerPanel.add(onlineBankingButton);
        centerPanel.add(eWalletButton);
        centerPanel.add(cardButton);

        // ----------------- Bottom Panel (Back and Done Buttons) -----------------
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(128, 255, 255));
        JButton backButton = new JButton("Back");
        JButton doneButton = new JButton("Done");
        doneButton.setEnabled(false); // Initially disabled

        bottomPanel.add(backButton);
        bottomPanel.add(doneButton);

        // ----------------- Add Panels to the Frame -----------------
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        final String[] selectedPaymentMethod = {null};

        // ✅ Payment selection updates reservation and enables "Done" button
        ActionListener paymentListener = e -> {
            depositPaymentController.confirmPayment(reservation);
            doneButton.setEnabled(true);
        };

        onlineBankingButton.addActionListener(paymentListener);
        eWalletButton.addActionListener(paymentListener);
        cardButton.addActionListener(paymentListener);

        // ✅ Back button returns to PaxPage
        backButton.addActionListener(e -> {
            new PaxPage(reservation, customer).setVisible(true);
            dispose();
        });

        // ✅ Done button now correctly transitions to custOption
        doneButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Reservation confirmed!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // ✅ Open custOption with correct customer reference
            new custOption(customer).setVisible(true);
            dispose();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
