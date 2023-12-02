package Boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.AdminController;
import Entity.*;
import java.util.*;

// This class assumes that you have an established database connection 
// and the AdminController is properly set up to handle database operations.

public class AdminViewPanel extends JPanel {
    private JTextField flightNumberField, crewIDField, destCountryField, destCityField, originCountryField, originCityField, capacityField, departureDateField, arrivalDateField, aircraftIDField,aircraftModelField;
    private JButton submitButton;
    private AdminController adminController; // Assume this is properly initialized

    // Components for the flights tab
    private JTable flightsTable;
    private JButton addFlightButton, removeFlightButton, modifyFlightButton;

    // Components for the crew tab
    private JTable crewTable;
    private JButton addCrewButton, removeCrewButton;

    // Other components for aircraft, destinations, and users would be added similarly

    public AdminViewPanel(AdminController adminControl) {
        this.adminController = adminControl;
        setLayout(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add tabs
        tabbedPane.add("Flights", createFlightsPanel());
        //tabbedPane.add("Crew", createCrewPanel());
        //tabbedPane.add("Aircraft", createAircraftPanel());
        //tabbedPane.add("Destinations", createDestinationsPanel());
        //tabbedPane.add("Users", createUsersPanel());
        // More tabs for additional features

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createFlightsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Components like buttons, tables, etc. would be initialized and added here
        // For example:
        //flightsTable = new JTable(); // This should be populated with flight data
        Map<String, Flight> flightMap = adminController.browseAllFlights();

        String[] columnNames = {
            "Flight Number",
            "Destination Country", 
            "Destination City",
            "Origin Country",
            "Origin City",
            "Departure Date",
            "Arrival Date"
        };        

        addFlightButton = new JButton("Add Flight");
        removeFlightButton = new JButton("Remove Flight");
        modifyFlightButton = new JButton("Modify Flight");

        // Add action listeners to your buttons
        addFlightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open add flight dialog or panel
            }
        });

        removeFlightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Remove selected flight
            }
        });

        modifyFlightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Modify selected flight
            }
        });

        // Add components to the panel
        panel.add(new JScrollPane(flightsTable), BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(addFlightButton);
        buttonsPanel.add(removeFlightButton);
        buttonsPanel.add(modifyFlightButton);
        panel.add(buttonsPanel, BorderLayout.SOUTH);

        return panel;
    }
public void showAddFlightDialog() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Add Flight");
        dialog.setLayout(new GridLayout(0, 2));
        dialog.setSize(300, 400); // Set the size of the dialog
        dialog.setLocationRelativeTo(this); // Center it relative to the AdminPanel

        add(new JLabel("Flight Number:"));
        flightNumberField = new JTextField(20);
        add(flightNumberField);

        add(new JLabel("Crew ID:"));
        crewIDField = new JTextField(20);
        add(crewIDField);

        add(new JLabel("Destination Country:"));
        destCountryField = new JTextField(20);
        add(destCountryField);

        add(new JLabel("Destination City:"));
        destCityField = new JTextField(20);
        add(destCityField);

        add(new JLabel("Origin Country:"));
        originCountryField = new JTextField(20);
        add(originCountryField);

        add(new JLabel("Origin City:"));
        originCityField = new JTextField(20);
        add(originCityField);

        add(new JLabel("Capacity:"));
        capacityField = new JTextField(20);
        add(capacityField);

        add(new JLabel("Departure Date:"));
        departureDateField = new JTextField(20);
        add(departureDateField);

        add(new JLabel("Arrival Date:"));
        arrivalDateField = new JTextField(20);
        add(arrivalDateField);

        add(new JLabel("Aircraft ID:"));
        aircraftIDField = new JTextField(20);
        add(aircraftIDField);
        add(new JLabel("Aircraft Model:"));
        aircraftModelField = new JTextField(20);
        add(aircraftModelField);



        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String flightNumber = flightNumberField.getText();
                String crewID = crewIDField.getText();
                String departureDate = departureDateField.getText();
                String destCountry = destCountryField.getText();
                String destCity = destCityField.getText();
                String originCountry = originCountryField.getText();
                String originCity = originCityField.getText();
                int capacity = Integer.parseInt(capacityField.getText());
                int aircraftID = Integer.parseInt(aircraftIDField.getText());
                String aircraftModel = aircraftModelField.getText();
                String depTime= departureDateField.getText();
                String arrTime = arrivalDateField.getText();
                Location origin = new Location(originCity,originCountry);//might edit them to check if location exists
                Location dest = new Location(destCity,destCountry);
                Aircraft ac = new Aircraft(aircraftID);
                ac.setAircraftModel(aircraftModel);
                Flight flight = new Flight(flightNumber,crewID,dest,origin,capacity,depTime,arrTime,ac);
                adminController.addFlightInfo(flight);
                System.out.println("flight added by admin successfully");
                
            }
        });
}
    
    // Similar methods for creating other panels like createCrewPanel, createAircraftPanel, etc.

}