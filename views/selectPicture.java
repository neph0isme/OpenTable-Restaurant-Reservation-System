package views;

import controllers.ReservationController;
import models.Customer;
import models.Reservation;

import javax.swing.*;
import java.awt.*;

public class selectPicture extends JFrame {
    private ReservationController reservationController;
    private Customer customer;

    public selectPicture(Customer customer) { // ✅ Pass customer
        this.customer = customer;
        this.reservationController = new ReservationController();

        getContentPane().setBackground(new Color(128, 255, 255));
        getContentPane().setLayout(null);

        // ✅ Load first restaurant image
        ImageIcon originalIcon1 = new ImageIcon("pictures\\PASTA GUI.png");
        Image img1 = originalIcon1.getImage().getScaledInstance(294, 100, Image.SCALE_SMOOTH);
        JLabel lblNewLabel = new JLabel(new ImageIcon(img1));
        lblNewLabel.setBounds(40, 108, 294, 100);
        getContentPane().add(lblNewLabel);

        // ✅ Load second restaurant image
        ImageIcon originalIcon2 = new ImageIcon("pictures\\sushii.png");
        Image img2 = originalIcon2.getImage().getScaledInstance(294, 100, Image.SCALE_SMOOTH);
        JLabel lblNewLabel_1 = new JLabel(new ImageIcon(img2));
        lblNewLabel_1.setBounds(40, 244, 294, 100);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("CHOOSE YOUR RESTAURANT");
        lblNewLabel_2.setBounds(241, 27, 219, 43);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        getContentPane().add(lblNewLabel_2);

        // ✅ Button for first restaurant (Pasta)
        JButton btnRest1 = new JButton("Choose");
        btnRest1.setBounds(486, 147, 85, 21);
        getContentPane().add(btnRest1);

        btnRest1.addActionListener(e -> {
            Reservation newReservation = new Reservation(generateNewReservationID(), "REST1", 0, customer.getUserID(), "", "", "", "", "", false);
            new ChooseDateTimePage(newReservation, customer).setVisible(true);
            dispose();
        });

        // ✅ Button for second restaurant (Sushi)
        JButton btnRest2 = new JButton("Choose");
        btnRest2.setBounds(486, 281, 85, 21);
        getContentPane().add(btnRest2);
        
        JButton btnBack = new JButton("back");
        btnBack.setBounds(10, 11, 89, 23);
        getContentPane().add(btnBack);
        
        JLabel lblNewLabel_3 = new JLabel("Cuisine: Italian");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(344, 136, 98, 14);
        getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("Cuisine: Japanese");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3_1.setBounds(344, 270, 114, 21);
        getContentPane().add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_3_2 = new JLabel("Rating: 4.5 star");
        lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3_2.setBounds(344, 161, 98, 21);
        getContentPane().add(lblNewLabel_3_2);
        
        JLabel lblNewLabel_3_3 = new JLabel("Rating: 4.3 star");
        lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3_3.setBounds(344, 302, 98, 21);
        getContentPane().add(lblNewLabel_3_3);
        
        btnBack.addActionListener(e -> {
            new custOption(customer).setVisible(true);
            dispose();
        });

        btnRest2.addActionListener(e -> {
            Reservation newReservation = new Reservation(generateNewReservationID(), "REST2", 0, customer.getUserID(), "", "", "", "", "", false);
            new ChooseDateTimePage(newReservation, customer).setVisible(true);
            dispose();
        });
        
        

        setTitle("Select Restaurant");
        setSize(650, 451);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String generateNewReservationID() {
        int maxID = 0;
        for (Reservation r : reservationController.getReservations()) {
            String id = r.getReserveID().substring(1);
            int num = Integer.parseInt(id);
            if (num > maxID) {
                maxID = num;
            }
        }
        return String.format("B%03d", maxID + 1);
    }
}
