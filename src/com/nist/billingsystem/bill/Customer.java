package com.nist.billingsystem.bill;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Customer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Customer frame = new Customer();
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
    public Customer() {
        setTitle("Customer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 936, 434);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 902, 377);
        contentPane.add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 882, 256);
        panel.add(scrollPane);

        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        scrollPane.setViewportView(table);
        DefaultTableModel model = new DefaultTableModel(
                new Object[][] {},
                new String[] { "Id", "Customer Name", "Meter No", "Address", "City", "HouseNo", "Email",
                        "PhoneNumber" });

        populateTable(model);
        table.setModel(model);
        table.getColumnModel().getColumn(1).setPreferredWidth(84);
        table.getColumnModel().getColumn(1).setMinWidth(20);

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Object[] rowData = new Object[model.getColumnCount()];
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        rowData[i] = table.getValueAt(selectedRow, i);
                    }
                    openRegisterFrame(true, rowData);
                }
            }
        });
        editButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        editButton.setBounds(84, 301, 150, 35);
        panel.add(editButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Object id = table.getValueAt(selectedRow, 0);
                    model.removeRow(selectedRow);
                }
            }
        });
        deleteButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        deleteButton.setBounds(416, 301, 150, 35);
        panel.add(deleteButton);
    }

    private void populateTable(DefaultTableModel model) {
        String sql = "SELECT id,customername,meternumber,address,city,housenumber,email,phonenumber from customer";
        model.setRowCount(0); // Clear existing rows
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String customerName = rs.getString("customername");
                String meterNumber = rs.getString("meternumber");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String housenumber = rs.getString("housenumber");
                String email = rs.getString("email");
                long phoneNumber = rs.getLong("phonenumber");

                model.addRow(new Object[] { id, customerName, meterNumber, address, city, housenumber, email,
                        phoneNumber });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openRegisterFrame(boolean isEditMode, Object[] rowData) {
        Register registerFrame = new Register(isEditMode, rowData);
        registerFrame.setVisible(true);
        dispose();
    }
}
