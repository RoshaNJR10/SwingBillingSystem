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
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField usernameTextField;
	private JTextField addressTextField;
	private JTextField emailTextField;
	private JTextField phoneNumberTextField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegister frame = new AdminRegister();
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
	public AdminRegister() {
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
		
		JLabel addNewCustomerLabel = new JLabel("Create Account");
		addNewCustomerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addNewCustomerLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		addNewCustomerLabel.setBounds(157, 30, 185, 32);
		panel.add(addNewCustomerLabel);
		
		JLabel customerNameLabel = new JLabel("Name");
		customerNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		customerNameLabel.setBounds(54, 99, 140, 32);
		panel.add(customerNameLabel);
		
		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		userNameLabel.setBounds(54, 148, 140, 32);
		panel.add(userNameLabel);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		addressLabel.setBounds(54, 197, 140, 32);
		panel.add(addressLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		emailLabel.setBounds(54, 256, 140, 32);
		panel.add(emailLabel);
		
		JLabel phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		phoneNumberLabel.setBounds(54, 309, 140, 32);
		panel.add(phoneNumberLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(288, 102, 213, 32);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(288, 148, 213, 32);
		panel.add(usernameTextField);
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(288, 197, 213, 32);
		panel.add(addressTextField);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(288, 259, 213, 32);
		panel.add(emailTextField);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(288, 309, 213, 32);
		panel.add(phoneNumberTextField);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullName= nameTextField.getText();
				String userName= usernameTextField.getText();
				String address= addressTextField.getText();
				String email= emailTextField.getText();
				int phoneNumber= Integer.parseInt( phoneNumberTextField.getText());
				String password= passwordField.getText().toString();
				String confirmPassword= confirmPasswordField.getText().toString();
				
				String sql = "INSERT INTO admin(fullname, username, address, email, phonenumber, password,confirmpassword) VALUES (?, ?, ?, ?, ?, ?,?)";
				PreparedStatement ps= null;
				 try {
					ps=DatabaseConnection.getConnection().prepareStatement(sql);
					ps.setString(1, fullName);
		            ps.setString(2, userName);
		            ps.setString(3, address);
		            ps.setString(4, email);
		            ps.setInt(5, phoneNumber);
		            ps.setString(6, password);
		            ps.setString(7, confirmPassword);
		            
		            ps.executeUpdate();
				} catch (Exception e1) {
					System.out.println(e1);
				}
				 Login login = new Login();
					login.setVisible(true);
					dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(54, 473, 140, 32);
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnCancel.setBounds(322, 473, 140, 32);
		panel.add(btnCancel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		passwordLabel.setBounds(54, 368, 140, 32);
		panel.add(passwordLabel);
		
		JLabel confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		confirmPasswordLabel.setBounds(54, 417, 140, 32);
		panel.add(confirmPasswordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(288, 368, 213, 32);
		panel.add(passwordField);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(288, 417, 213, 32);
		panel.add(confirmPasswordField);
	}
}
