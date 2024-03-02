package com.nist.billingsystem.bill;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loadingTextField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setTitle("Welcome Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -23, 598, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome to Electricity Billing System");
		welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(0, 52, 613, 78);
		panel.add(welcomeLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(128, 128, 255));
		progressBar.setBounds(31, 261, 504, 27);
		progressBar.setVisible(true);
		panel.add(progressBar);
		
		loadingTextField = new JTextField();
		loadingTextField.setText("Loading");
		loadingTextField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		loadingTextField.setEditable(false);
		loadingTextField.setBounds(44, 215, 162, 36);
		panel.add(loadingTextField);
		loadingTextField.setColumns(10);
		
		
		// Start a new thread for the loading process
        Thread loadingThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.setValue(i);
                    if (i % 2 == 0) {
                    	loadingTextField.setText("Loading..");
                    } else {
                    	loadingTextField.setText("Loading...");
                    }
                    if (i == 100) {
                    	loadingTextField.setVisible(false);
                    	Login login=new Login();
        				login.setVisible(true);
        				dispose();
                    }
                }
            }
        });
        loadingThread.start();
    }
}
