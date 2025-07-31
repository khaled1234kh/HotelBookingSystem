import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;


public class HotelBookingApp extends JFrame {
    
    // Data storage
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    
    // GUI components
    private JTabbedPane tabbedPane;
    private JTable roomTable, bookingTable;
    private DefaultTableModel roomTableModel, bookingTableModel;
    
    // Form fields
    private JTextField nameField, emailField, phoneField;
    private JComboBox<String> roomTypeCombo;
    private JTextField checkInField, checkOutField;
    private JSpinner guestSpinner;
    private JComboBox<String> paymentCombo;
    
    public HotelBookingApp() {
        setupData();
        setupGUI();
        loadSampleData();
        updateTables();
    }
    
    private void setupData() {
        // Initialize data structures
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        customers = new ArrayList<>();
    }
    
    private void setupGUI() {
        setTitle("Hotel Booking System - Simple & Functional");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        
        // Create tabbed pane
        tabbedPane = new JTabbedPane();
        
        // Add tabs
        tabbedPane.addTab("Rooms", createRoomPanel());
        tabbedPane.addTab("Bookings", createBookingPanel());
        tabbedPane.addTab("New Booking", createNewBookingPanel());
        
        add(tabbedPane);
    }
    
    private JPanel createRoomPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Room table
        String[] roomColumns = {"Room Number", "Type", "Price per Night", "Status"};
        roomTableModel = new DefaultTableModel(roomColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };
        roomTable = new JTable(roomTableModel);
        roomTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane roomScrollPane = new JScrollPane(roomTable);
        roomScrollPane.setBorder(BorderFactory.createTitledBorder("Available Rooms"));
        panel.add(roomScrollPane, BorderLayout.CENTER);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.addActionListener(e -> updateTables());
        buttonPanel.add(refreshBtn);
        
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createBookingPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Booking table
        String[] bookingColumns = {"Booking ID", "Customer", "Room", "Check-in", "Check-out", "Total Cost", "Status"};
        bookingTableModel = new DefaultTableModel(bookingColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table read-only
            }
        };
        bookingTable = new JTable(bookingTableModel);
        bookingTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane bookingScrollPane = new JScrollPane(bookingTable);
        bookingScrollPane.setBorder(BorderFactory.createTitledBorder("Current Bookings"));
        panel.add(bookingScrollPane, BorderLayout.CENTER);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        JButton cancelBtn = new JButton("Cancel Booking");
        cancelBtn.addActionListener(e -> cancelBooking());
        buttonPanel.add(cancelBtn);
        
        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.addActionListener(e -> updateTables());
        buttonPanel.add(refreshBtn);
        
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createNewBookingPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Customer Information
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        JLabel customerLabel = new JLabel("Customer Information");
        customerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(customerLabel, gbc);
        
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Full Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField(20);
        panel.add(nameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        emailField = new JTextField(20);
        panel.add(emailField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        phoneField = new JTextField(20);
        panel.add(phoneField, gbc);
        
        // Booking Information
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        JLabel bookingLabel = new JLabel("Booking Information");
        bookingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(bookingLabel, gbc);
        
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(new JLabel("Room Type:"), gbc);
        gbc.gridx = 1;
        roomTypeCombo = new JComboBox<>(new String[]{"Standard", "Deluxe", "Suite"});
        panel.add(roomTypeCombo, gbc);
        
        gbc.gridx = 0; gbc.gridy = 6;
        panel.add(new JLabel("Check-in Date:"), gbc);
        gbc.gridx = 1;
        checkInField = new JTextField("2024-08-01", 20);
        panel.add(checkInField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 7;
        panel.add(new JLabel("Check-out Date:"), gbc);
        gbc.gridx = 1;
        checkOutField = new JTextField("2024-08-03", 20);
        panel.add(checkOutField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 8;
        panel.add(new JLabel("Number of Guests:"), gbc);
        gbc.gridx = 1;
        guestSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 4, 1));
        panel.add(guestSpinner, gbc);
        
        gbc.gridx = 0; gbc.gridy = 9;
        panel.add(new JLabel("Payment Method:"), gbc);
        gbc.gridx = 1;
        paymentCombo = new JComboBox<>(new String[]{"Credit Card", "Cash", "Bank Transfer"});
        panel.add(paymentCombo, gbc);
        
        // Buttons
        gbc.gridx = 0; gbc.gridy = 10; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        JButton bookBtn = new JButton("Make Booking");
        bookBtn.addActionListener(e -> makeBooking());
        buttonPanel.add(bookBtn);
        
        JButton clearBtn = new JButton("Clear Form");
        clearBtn.addActionListener(e -> clearForm());
        buttonPanel.add(clearBtn);
        
        panel.add(buttonPanel, gbc);
        
        return panel;
    }
    
    private void makeBooking() {
        try {
            // Get form data
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String roomType = (String) roomTypeCombo.getSelectedItem();
            String checkIn = checkInField.getText().trim();
            String checkOut = checkOutField.getText().trim();
            int guests = (Integer) guestSpinner.getValue();
            String payment = (String) paymentCombo.getSelectedItem();
            
            // Basic validation
            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in name and email fields.");
                return;
            }
            
            // Find available room
            Room availableRoom = findAvailableRoom(roomType);
            if (availableRoom == null) {
                JOptionPane.showMessageDialog(this, "No rooms available for the selected type.");
                return;
            }
            
            // Create customer
            Customer customer = new Customer(name, email, phone);
            customers.add(customer);
            
            // Create booking
            Booking booking = new Booking(customer, availableRoom, checkIn, checkOut, guests, payment);
            bookings.add(booking);
            
            // Update room status
            availableRoom.setAvailable(false);
            
            // Update tables
            updateTables();
            
            // Clear form
            clearForm();
            
            // Show success message
            JOptionPane.showMessageDialog(this, 
                "Booking successful!\n" +
                "Booking ID: " + booking.getId() + "\n" +
                "Room: " + availableRoom.getNumber() + "\n" +
                "Total Cost: $" + String.format("%.2f", booking.getTotalCost()));
                
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error creating booking: " + ex.getMessage());
        }
    }
    
    private Room findAvailableRoom(String roomType) {
        for (Room room : rooms) {
            if (room.isAvailable() && room.getType().equals(roomType)) {
                return room;
            }
        }
        return null;
    }
    
    private void cancelBooking() {
        int selectedRow = bookingTable.getSelectedRow();
        if (selectedRow >= 0) {
            int bookingId = (Integer) bookingTableModel.getValueAt(selectedRow, 0);
            
            // Find the booking
            Booking bookingToCancel = null;
            for (Booking booking : bookings) {
                if (booking.getId() == bookingId) {
                    bookingToCancel = booking;
                    break;
                }
            }
            
            if (bookingToCancel != null) {
                // Confirm cancellation
                int confirm = JOptionPane.showConfirmDialog(this, 
                    "Are you sure you want to cancel this booking?", 
                    "Confirm Cancellation", 
                    JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    // Cancel booking
                    bookingToCancel.setStatus("Cancelled");
                    bookingToCancel.getRoom().setAvailable(true);
                    
                    // Update tables
                    updateTables();
                    
                    JOptionPane.showMessageDialog(this, "Booking cancelled successfully!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a booking to cancel.");
        }
    }
    
    private void clearForm() {
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        roomTypeCombo.setSelectedIndex(0);
        checkInField.setText("2024-08-01");
        checkOutField.setText("2024-08-03");
        guestSpinner.setValue(1);
        paymentCombo.setSelectedIndex(0);
    }
    
    private void updateTables() {
        // Update room table
        roomTableModel.setRowCount(0);
        for (Room room : rooms) {
            Object[] row = {
                room.getNumber(),
                room.getType(),
                "$" + String.format("%.2f", room.getPrice()),
                room.isAvailable() ? "Available" : "Occupied"
            };
            roomTableModel.addRow(row);
        }
        
        // Update booking table
        bookingTableModel.setRowCount(0);
        for (Booking booking : bookings) {
            Object[] row = {
                booking.getId(),
                booking.getCustomer().getName(),
                booking.getRoom().getNumber() + " (" + booking.getRoom().getType() + ")",
                booking.getCheckIn(),
                booking.getCheckOut(),
                "$" + String.format("%.2f", booking.getTotalCost()),
                booking.getStatus()
            };
            bookingTableModel.addRow(row);
        }
    }
    
    private void loadSampleData() {
        // Create sample rooms
        rooms.add(new Room(101, "Standard", 89.99, true));
        rooms.add(new Room(102, "Standard", 89.99, true));
        rooms.add(new Room(103, "Standard", 89.99, true));
        rooms.add(new Room(201, "Deluxe", 149.99, true));
        rooms.add(new Room(202, "Deluxe", 149.99, true));
        rooms.add(new Room(301, "Suite", 299.99, true));
        rooms.add(new Room(302, "Suite", 299.99, true));
        
        // Create sample customers and bookings
        Customer customer1 = new Customer("John Smith", "john@email.com", "555-0101");
        customers.add(customer1);
        
        Booking booking1 = new Booking(customer1, rooms.get(0), "2024-08-01", "2024-08-03", 2, "Credit Card");
        bookings.add(booking1);
        rooms.get(0).setAvailable(false);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HotelBookingApp().setVisible(true);
        });
    }
}

// Simple Room class
class Room {
    private int number;
    private String type;
    private double price;
    private boolean available;
    
    public Room(int number, String type, double price, boolean available) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.available = available;
    }
    
    public int getNumber() { return number; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}

// Simple Customer class
class Customer {
    private String name;
    private String email;
    private String phone;
    
    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}

// Simple Booking class
class Booking {
    private static int nextId = 1001;
    private int id;
    private Customer customer;
    private Room room;
    private String checkIn;
    private String checkOut;
    private int guests;
    private String paymentMethod;
    private String status;
    private double totalCost;
    
    public Booking(Customer customer, Room room, String checkIn, String checkOut, int guests, String paymentMethod) {
        this.id = nextId++;
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
        this.paymentMethod = paymentMethod;
        this.status = "Confirmed";
        this.totalCost = room.getPrice() * 2; // Assume 2 nights
    }
    
    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Room getRoom() { return room; }
    public String getCheckIn() { return checkIn; }
    public String getCheckOut() { return checkOut; }
    public int getGuests() { return guests; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalCost() { return totalCost; }
} 