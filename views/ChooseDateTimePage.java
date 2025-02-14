package views;

import controllers.ReservationController;
import models.Customer;
import models.Reservation;

import javax.swing.*;
import java.awt.*;

public class ChooseDateTimePage extends JFrame {
    private JComboBox<String> comboBoxYear, comboBoxMonth, comboBoxDay;
    private JComboBox<String> comboBoxFrom, comboBoxTo;
    private Reservation reservation;
    private ReservationController reservationController;
	private Customer customer;

    public ChooseDateTimePage(Reservation reservation, Customer customer) {
        this.reservation = reservation;
        this.customer = customer;
        this.reservationController = new ReservationController();

        getContentPane().setBackground(new Color(128, 255, 255));
        setTitle("Choose Date & Time");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblSelectDate = new JLabel("SELECT DATE:");
        lblSelectDate.setBounds(60, 95, 100, 21);
        getContentPane().add(lblSelectDate);

        JLabel lblSelectTime = new JLabel("SELECT TIME:");
        lblSelectTime.setBounds(60, 209, 100, 13);
        getContentPane().add(lblSelectTime);

        JLabel lblFrom = new JLabel("FROM:");
        lblFrom.setBounds(91, 236, 40, 13);
        getContentPane().add(lblFrom);

        JLabel lblTo = new JLabel("TO:");
        lblTo.setBounds(104, 266, 40, 13);
        getContentPane().add(lblTo);

        // Year ComboBox (2025 - 2030)
        comboBoxYear = new JComboBox<>();
        for (int year = 2025; year <= 2030; year++) {
            comboBoxYear.addItem(String.valueOf(year));
        }
        comboBoxYear.setBounds(130, 138, 93, 21);
        getContentPane().add(comboBoxYear);

        // Month ComboBox
        comboBoxMonth = new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"});
        comboBoxMonth.setBounds(300, 138, 93, 21);
        getContentPane().add(comboBoxMonth);

        // Day ComboBox (1 - 31)
        comboBoxDay = new JComboBox<>();
        for (int day = 1; day <= 31; day++) {
            comboBoxDay.addItem(String.valueOf(day));
        }
        comboBoxDay.setBounds(470, 138, 93, 21);
        getContentPane().add(comboBoxDay);

        JLabel lblYear = new JLabel("YEAR");
        lblYear.setBounds(91, 142, 40, 13);
        getContentPane().add(lblYear);

        JLabel lblMonth = new JLabel("MONTH");
        lblMonth.setBounds(250, 142, 50, 13);
        getContentPane().add(lblMonth);

        JLabel lblDay = new JLabel("DAY");
        lblDay.setBounds(437, 142, 30, 13);
        getContentPane().add(lblDay);

        // Time ComboBoxes
        comboBoxFrom = new JComboBox<>();
        comboBoxTo = new JComboBox<>();
        for (int hour = 0; hour < 24; hour++) {
            String time = String.format("%02d:00", hour);
            comboBoxFrom.addItem(time);
            comboBoxTo.addItem(time);
        }
        comboBoxFrom.setBounds(144, 232, 93, 21);
        getContentPane().add(comboBoxFrom);

        comboBoxTo.setBounds(144, 262, 93, 21);
        getContentPane().add(comboBoxTo);

        // Next Button
        JButton btnNext = new JButton("Next");
        btnNext.setBounds(276, 319, 83, 21);
        btnNext.addActionListener(e -> saveDateTimeAndProceed());
        getContentPane().add(btnNext);
        
        JButton btnBack = new JButton("back");
        btnBack.setBounds(10, 11, 89, 23);
        getContentPane().add(btnBack);
        
        btnBack.addActionListener(e -> {
            new selectPicture(customer).setVisible(true);         
            dispose();
        });
    }

    private void saveDateTimeAndProceed() {
        String date = comboBoxDay.getSelectedItem() + " " + comboBoxMonth.getSelectedItem() + " " + comboBoxYear.getSelectedItem();
        String startTime = (String) comboBoxFrom.getSelectedItem();
        String endTime = (String) comboBoxTo.getSelectedItem();

        reservation.setDate(date);
        reservation.setStartTime(startTime);
        reservation.setEndTime(endTime);

        reservationController.updateReservation(reservation); // ✅ Updates reservation
        new PaxPage(reservation, customer).setVisible(true); // ✅ Passes reservation to next step
        dispose();
    }
}
