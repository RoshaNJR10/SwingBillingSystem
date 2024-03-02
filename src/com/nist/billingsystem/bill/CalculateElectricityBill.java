package com.nist.billingsystem.bill;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class CalculateElectricityBill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField meterTextField;
	private JTextField addressTextField;
	private JTextField unitsTextField;
	private JTextField nameTextField;
	private JComboBox monthComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculateElectricityBill frame = new CalculateElectricityBill();
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
	public CalculateElectricityBill() {
		setTitle("Register Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 612, 480);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel addNewCustomerLabel = new JLabel("Calculate Electricity Bill");
		addNewCustomerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addNewCustomerLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		addNewCustomerLabel.setBounds(141, 30, 282, 32);
		panel.add(addNewCustomerLabel);
		
		JLabel customerNameLabel = new JLabel("Customer Name");
		customerNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		customerNameLabel.setBounds(54, 155, 140, 32);
		panel.add(customerNameLabel);
		
		JLabel meterLabel = new JLabel("Meter No");
		meterLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		meterLabel.setBounds(54, 99, 140, 32);
		panel.add(meterLabel);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		addressLabel.setBounds(54, 214, 140, 32);
		panel.add(addressLabel);
		
		JLabel cityLabel = new JLabel("Units ");
		cityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cityLabel.setBounds(54, 267, 140, 32);
		panel.add(cityLabel);
		
		JLabel houseNumberLabel = new JLabel("Month");
		houseNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		houseNumberLabel.setBounds(54, 321, 140, 32);
		panel.add(houseNumberLabel);
		
		meterTextField = new JTextField();
		meterTextField.setColumns(10);
		meterTextField.setBounds(288, 99, 213, 32);
		panel.add(meterTextField);
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(288, 217, 213, 32);
		panel.add(addressTextField);
		
		unitsTextField = new JTextField();
		unitsTextField.setColumns(10);
		unitsTextField.setBounds(288, 270, 213, 32);
		panel.add(unitsTextField);
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String meterNumber= meterTextField.getText();
				String name=nameTextField.getText();
				String address= addressTextField.getText();
				float units= Float.parseFloat(unitsTextField.getText());
				String month = (String) monthComboBox.getSelectedItem();
				
				float billamount= (float) (units*9.210);
				String sql = "INSERT INTO elecricitybill(meterNumber,name,address,units,month,amount) VALUES (?, ?, ?, ?, ?,?)";
				PreparedStatement ps= null;
				 try {
					ps=DatabaseConnection.getConnection().prepareStatement(sql);
					ps.setString(1,	meterNumber);
					ps.setString(2, name);
					ps.setString(3, address);
					ps.setFloat(4,	units);
					ps.setString(5, month);
					ps.setFloat(6, billamount);
		            ps.executeUpdate();
				} catch (Exception e1) {
					System.out.println(e1);
				}
				 Operation operation = new Operation();
					operation.setVisible(true);
					dispose();
			}
		});
		calculateButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		calculateButton.setBounds(93, 410, 140, 32);
		panel.add(calculateButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operation operation = new Operation();
				operation.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnCancel.setBounds(312, 410, 140, 32);
		panel.add(btnCancel);
		
		monthComboBox = new JComboBox();
		monthComboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		monthComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		monthComboBox.setMaximumRowCount(12);
		monthComboBox.setBounds(288, 322, 213, 32);
		panel.add(monthComboBox);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(288, 158, 213, 32);
		panel.add(nameTextField);
	}
}
