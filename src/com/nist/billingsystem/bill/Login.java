package com.nist.billingsystem.bill;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 498, 282);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel userNameLabel = new JLabel("Username");
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		userNameLabel.setBounds(29, 40, 148, 26);
		panel.add(userNameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		passwordLabel.setBounds(29, 98, 148, 26);
		panel.add(passwordLabel);
		
		
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		userNameTextField.setBounds(243, 40, 187, 26);
		panel.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(243, 98, 187, 25);
		panel.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=userNameTextField.getText();
				String password = passwordField.getText().toString();
				
				boolean check = false;
		        String sql = "SELECT * FROM admin WHERE username=? AND password=?";
		        PreparedStatement ps=null;
		        try {
					ps=DatabaseConnection.getConnection().prepareStatement(sql);
					ps.setString(1, username);
					ps.setString(2, password);
					ResultSet rs=ps.executeQuery();
					while(rs.next())
					{
						check=true;
					}
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
		        
		        if(check==true) {
				Operation operation = new Operation();
				operation.setVisible(true);
				dispose();
		        }
		        else {
		        	JOptionPane.showMessageDialog(Login.this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		loginButton.setBackground(new Color(255, 255, 255));
		loginButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		loginButton.setBounds(265, 149, 153, 34);
		panel.add(loginButton);
		
		JLabel lblNewLabel = new JLabel("Didnt have account? Signup Here");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		lblNewLabel.setBounds(145, 220, 190, 13);
		panel.add(lblNewLabel);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminRegister register = new AdminRegister();
				register.setVisible(true);
				dispose();
			}
		});
		registerButton.setBounds(316, 215, 85, 21);
		panel.add(registerButton);
		
		
		
		

	}
}
