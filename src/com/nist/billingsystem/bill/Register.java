package com.nist.billingsystem.bill;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Register extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField customerNametextField;
    private JTextField meterNumbertextField;
    private JTextField addressTextField;
    private JTextField cityTextField;
    private JTextField houseNumberTextField;
    private JTextField emailTextField;
    private JTextField phoneNumberTextField;
    private boolean isUpdateMode = false; // Flag to determine if it's update mode
    private JTextField idTextField;
    private Object[] rowData;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    
    public Register(boolean isEditMode, Object[] rowData) {
        // Set the frame properties
        setTitle(isEditMode ? "Update Customer" : "Register Customer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 626, 587);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Initialize other components...
        
        // Set the edit mode flag
        this.isUpdateMode = isEditMode;

        // Set the data in the fields if it's in edit mode
        if (isEditMode && rowData != null) {
            setDataInFields(rowData);
        }
    }
    private void setDataInFields(Object[] rowData) {
        // Set data in the respective text fields
        customerNametextField.setText(rowData[1].toString());
        meterNumbertextField.setText(rowData[2].toString());
        addressTextField.setText(rowData[3].toString());
        cityTextField.setText(rowData[4].toString());
        houseNumberTextField.setText(rowData[5].toString());
        emailTextField.setText(rowData[6].toString());
        phoneNumberTextField.setText(rowData[7].toString());

        // If ID field is available, set data in it
        if (idTextField != null && rowData.length > 0) {
            idTextField.setText(rowData[0].toString());
        }
    }
    public Register() {
        setTitle("Register Customer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 626, 587);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 10, 612, 540);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel addNewCustomerLabel = new JLabel("Add New Customer");
        addNewCustomerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addNewCustomerLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        addNewCustomerLabel.setBounds(157, 30, 228, 32);
        panel.add(addNewCustomerLabel);

        JLabel customerNameLabel = new JLabel("Customer Name");
        customerNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        customerNameLabel.setBounds(54, 99, 140, 32);
        panel.add(customerNameLabel);

        JLabel meterLabel = new JLabel("Meter No");
        meterLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        meterLabel.setBounds(54, 148, 140, 32);
        panel.add(meterLabel);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        addressLabel.setBounds(54, 197, 140, 32);
        panel.add(addressLabel);

        JLabel cityLabel = new JLabel("City");
        cityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        cityLabel.setBounds(54, 256, 140, 32);
        panel.add(cityLabel);

        JLabel houseNumberLabel = new JLabel("House Number");
        houseNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        houseNumberLabel.setBounds(54, 309, 140, 32);
        panel.add(houseNumberLabel);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        emailLabel.setBounds(54, 358, 140, 32);
        panel.add(emailLabel);

        JLabel phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        phoneNumberLabel.setBounds(54, 409, 140, 32);
        panel.add(phoneNumberLabel);

        customerNametextField = new JTextField();
        customerNametextField.setBounds(288, 102, 213, 32);
        panel.add(customerNametextField);
        customerNametextField.setColumns(10);

        meterNumbertextField = new JTextField();
        meterNumbertextField.setColumns(10);
        meterNumbertextField.setBounds(288, 148, 213, 32);
        panel.add(meterNumbertextField);

        addressTextField = new JTextField();
        addressTextField.setColumns(10);
        addressTextField.setBounds(288, 197, 213, 32);
        panel.add(addressTextField);

        cityTextField = new JTextField();
        cityTextField.setColumns(10);
        cityTextField.setBounds(288, 259, 213, 32);
        panel.add(cityTextField);

        houseNumberTextField = new JTextField();
        houseNumberTextField.setColumns(10);
        houseNumberTextField.setBounds(288, 309, 213, 32);
        panel.add(houseNumberTextField);

        emailTextField = new JTextField();
        emailTextField.setColumns(10);
        emailTextField.setBounds(288, 361, 213, 32);
        panel.add(emailTextField);

        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setColumns(10);
        phoneNumberTextField.setBounds(288, 412, 213, 32);
        panel.add(phoneNumberTextField);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerName = customerNametextField.getText();
                String meterNumber = meterNumbertextField.getText();
                String address = addressTextField.getText();
                String city = cityTextField.getText();
                String houseNumber = houseNumberTextField.getText();
                String email = emailTextField.getText();
                String phoneNumber = phoneNumberTextField.getText();

                String sql = "";
                if (!isUpdateMode) {
                    // Add new customer
                    sql = "INSERT INTO customer(customername, meternumber,address,city,housenumber,email,phonenumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
                } else {
                    // Update existing customer
                    sql = "UPDATE customer SET customername=?, meternumber=?, address=?, city=?, housenumber=?, email=?, phonenumber=? WHERE id=?";
                }

                PreparedStatement ps = null;
                try {
                    ps = DatabaseConnection.getConnection().prepareStatement(sql);
                    ps.setString(1, customerName);
                    ps.setString(2, meterNumber);
                    ps.setString(3, address);
                    ps.setString(4, city);
                    ps.setString(5, houseNumber);
                    ps.setString(6, email);
                    ps.setString(7, phoneNumber);

                    if (isUpdateMode) {
                        // Set the ID for update mode
                    	idTextField.setEnabled(true);
                        ps.setInt(8, Integer.parseInt(idTextField.getText()));
                    }

                    ps.executeUpdate();
                } catch (Exception e1) {
                    System.out.println(e1);
                }

                Operation operation = new Operation();
                operation.setVisible(true);
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnNewButton.setBounds(96, 478, 140, 32);
        panel.add(btnNewButton);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the form
                dispose();
            }
        });
        btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnCancel.setBounds(319, 478, 140, 32);
        panel.add(btnCancel);
        
        idTextField = new JTextField();
        idTextField.setBounds(464, 61, 37, 19);
        idTextField.setEnabled(false);
        panel.add(idTextField);
        idTextField.setColumns(10);
    }

    public void setUpdateMode(boolean isUpdateMode) {
        // Set the flag for update mode
        this.isUpdateMode = isUpdateMode;
    }

    // Add getters and setters for idTextField if needed
}
