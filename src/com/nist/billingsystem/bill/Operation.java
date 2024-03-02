package com.nist.billingsystem.bill;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Operation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operation frame = new Operation();
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
	public Operation() {
		setTitle("Admin Task");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 621, 292);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Admin Dashboard");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(98, 28, 357, 35);
		panel.add(lblNewLabel);
		
		JButton addCustomerButton = new JButton("Add Customer");
		addCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register = new Register();
				register.setVisible(true);
				dispose();
			}
		});
		addCustomerButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		addCustomerButton.setBounds(41, 134, 123, 35);
		panel.add(addCustomerButton);
		
		JButton viewDetailsButton = new JButton("View Details");
		viewDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 CustomerDetails customer = new CustomerDetails();
				 customer.setVisible(true);
				 dispose();
			}
		});
		viewDetailsButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		viewDetailsButton.setBounds(246, 134, 123, 35);
		panel.add(viewDetailsButton);
		
		JButton billGenerateButton = new JButton("Bill Generate");
		billGenerateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculateElectricityBill bill = new  CalculateElectricityBill();
				bill.setVisible(true);
				dispose();
			}
		});
		billGenerateButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		billGenerateButton.setBounds(442, 134, 123, 35);
		panel.add(billGenerateButton);
	}

}
