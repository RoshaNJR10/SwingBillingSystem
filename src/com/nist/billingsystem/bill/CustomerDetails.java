package com.nist.billingsystem.bill;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerDetails extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField meterTextField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerDetails frame = new CustomerDetails();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CustomerDetails() {
        setTitle("Deposit Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 753, 565);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 735, 508);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel searchMeterByNumberLabel = new JLabel("Search By Meter Number");
        searchMeterByNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        searchMeterByNumberLabel.setBounds(10, 30, 168, 32);
        panel.add(searchMeterByNumberLabel);

        meterTextField = new JTextField();
        meterTextField.setBounds(201, 38, 109, 24);
        panel.add(meterTextField);
        meterTextField.setColumns(10);

        JLabel sortbyMonthLabel = new JLabel("Sortby Month");
        sortbyMonthLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        sortbyMonthLabel.setBounds(384, 30, 109, 32);
        panel.add(sortbyMonthLabel);

        JComboBox searchComboBox_1 = new JComboBox();
        searchComboBox_1.setModel(new DefaultComboBoxModel(new String[] { "January", "February", "March", "April",
                "May", "June", "July", "August", "September", "October", "November", "December" }));
        searchComboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        searchComboBox_1.setBounds(501, 31, 126, 31);
        panel.add(searchComboBox_1);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String meterNumber = meterTextField.getText();
                String selectedMonth = (String) searchComboBox_1.getSelectedItem();
                searchByMeterNumberAndMonth(meterNumber, selectedMonth);
        	}
        });
        
       
        searchButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        searchButton.setBounds(189, 88, 137, 32);
        panel.add(searchButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 156, 715, 176);
        panel.add(scrollPane);

        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        scrollPane.setViewportView(table);
        populateTableFromDatabase();
    }

    private void populateTableFromDatabase() {
        String sql = "SELECT meterNumber, name, month, units, amount FROM elecricitybill";
        DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "Meter", "Name", "Month",
                "Units", "Total Amount" });
        table.setModel(model);
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String meterNumber = rs.getString("meternumber");
                String name = rs.getString("name");
                String month = rs.getString("month");
                float units = rs.getFloat("units");
                float totalBill = rs.getFloat("amount");
                

                model.addRow(new Object[] { meterNumber, name, month, units, totalBill,  });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void searchByMeterNumberAndMonth(String meterNumber, String month) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows

        String sql = "SELECT meterNumber, name, month, units, amount FROM elecricitybill WHERE meterNumber = ? AND month = ?";
        try {
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.setString(1, meterNumber);
            ps.setString(2, month);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String meterNum = rs.getString("meternumber");
                String name = rs.getString("name");
                String monthValue = rs.getString("month");
                float units = rs.getFloat("units");
                float totalAmount = rs.getFloat("amount");

                model.addRow(new Object[] { meterNum, name, monthValue, units, totalAmount });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
