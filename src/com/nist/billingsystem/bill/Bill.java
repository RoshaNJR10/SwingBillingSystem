package com.nist.billingsystem.bill;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.util.ArrayList;

public class Bill extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idTextField,nameTextField,priceTextField,quantityTextField;
	private JTable table;
	JLabel totalField;

	static ArrayList<ProductDto> productList=new ArrayList<ProductDto>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 657);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(142, 134, 113));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(10, 10, 494, 592);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Billing System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(113, 53, 269, 50);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(42, 176, 116, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Name :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(42, 239, 148, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(42, 299, 116, 30);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quantity :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(42, 358, 116, 30);
		panel.add(lblNewLabel_1_3);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idTextField.setText("");
				nameTextField.setText("");
				quantityTextField.setText("");
				priceTextField.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(282, 452, 158, 50);
		panel.add(btnClear);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int id=Integer.parseInt( idTextField.getText());
				String name= nameTextField.getText();
				int quant=Integer.parseInt( quantityTextField.getText());
				float price=Float.parseFloat( priceTextField.getText());
				
				ProductDto product=new ProductDto(id, name, quant, price);
				productList.add(product);
				
				updateTable();
				
				idTextField.setText("");
                nameTextField.setText("");
                quantityTextField.setText("");
                priceTextField.setText("");	
				}catch(Exception exc) {
					System.out.println(exc.toString());
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBounds(75, 452, 158, 50);
		panel.add(btnAdd);
		
		idTextField = new JTextField();
		idTextField.setForeground(new Color(0, 0, 0));
		idTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		idTextField.setBounds(204, 176, 259, 30);
		panel.add(idTextField);
		idTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nameTextField.setColumns(10);
		nameTextField.setBounds(204, 240, 259, 30);
		panel.add(nameTextField);
		
		priceTextField = new JTextField();
		priceTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		priceTextField.setColumns(10);
		priceTextField.setBounds(204, 299, 259, 30);
		panel.add(priceTextField);
		
		quantityTextField = new JTextField();
		quantityTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		quantityTextField.setColumns(10);
		quantityTextField.setBounds(204, 358, 259, 30);
		panel.add(quantityTextField);
		
		JPanel billpane = new JPanel();
		billpane.setBackground(new Color(255, 255, 255));
		billpane.setBounds(514, 10, 494, 542);
		contentPane.add(billpane);
		billpane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("ABC Company");
		lblNewLabel_2.setBounds(196, 43, 143, 22);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		billpane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Banepa-07, Godamchowk");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_2_1.setBounds(158, 70, 207, 22);
		billpane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("+977-9841******, abcompany@gmail.com");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_2_1_1.setBounds(96, 88, 314, 39);
		billpane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("=================================================================");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(20, 125, 474, 13);
		billpane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("=================================================================");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setBounds(20, 20, 474, 13);
		billpane.add(lblNewLabel_3_1_1);
	
        String[] column = {"Product Id", "Product Name", "Quantity", "Price","Amount"};
        DefaultTableModel tablemodel = new DefaultTableModel(column, 0);
        table = new JTable(tablemodel);
        JScrollPane table_1 = new JScrollPane(table);
        table_1.setBounds(20, 148, 464, 354);
        billpane.add(table_1);
        
        JLabel lblNewLabel_3 = new JLabel("Total Amount :");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_3.setBounds(128, 512, 166, 31);
        billpane.add(lblNewLabel_3);
        
        totalField = new JLabel("");
        totalField.setHorizontalAlignment(SwingConstants.RIGHT);
        totalField.setVerticalAlignment(SwingConstants.BOTTOM);
        totalField.setFont(new Font("Tahoma", Font.BOLD, 18));
        totalField.setBounds(318, 512, 166, 28);
        billpane.add(totalField);
	
		JButton btnAdd_1 = new JButton("Print");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean print=table.print();
					if(!print) {
						JOptionPane.showMessageDialog(null, "unable to print!!!");
					}
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnAdd_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd_1.setBounds(850, 562, 158, 50);
		contentPane.add(btnAdd_1);
		 
}
	 private void updateTable() {
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0); // Clear the table before adding the updated product list
	        float totalAmount=0;
	        for (ProductDto product : productList) {
	        	float amount=product.price*product.quantity;
	        	totalAmount=totalAmount+amount;
	            model.addRow(new Object[]{
	                    product.id,
	                    product.name,
	                    product.quantity,
	                    product.price,
	                    amount,
	            });
	        }
	        totalField.setText(String.valueOf(totalAmount));
}}