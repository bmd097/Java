package com.project.Assesment1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Guest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guest frame = new Guest(null);
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
	public Guest(final JFrame homeFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1360, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("HELLO GUEST!!!");
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 100, 1290, 5);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Welcome GUEST");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 60));
		lblNewLabel.setBounds(22, 21, 489, 69);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton.setBounds(1102, 20, 210, 70);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Search By Name");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(240, 195, 240, 53);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Search By Occupation");
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(209, 372, 302, 53);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		textField.setBounds(21, 258, 678, 69);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		textField_1.setColumns(10);
		textField_1.setBounds(21, 445, 678, 69);
		contentPane.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(749, 115, 5, 600);
		contentPane.add(separator_1);
		
		JButton btnNewButton_1 = new JButton("ALIVE LIST");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// alive list
				try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    var database = mongoClient.getDatabase("baklol");
                    try {
                        database.createCollection("testUsers");
                        System.out.println("Collection created successfully");
                    } catch (MongoCommandException ef) {
                    	database.getCollection("users").drop();
                    }
                    MongoCollection < Document > collection = database.getCollection("testUsers");
                    
                    BasicDBObject whereDbObject=new BasicDBObject();
                    whereDbObject.put("status",true);
                    
                    try (MongoCursor<Document> cur = collection.find(whereDbObject).iterator()) {
 
                    	AllDetails allDetails=new AllDetails(cur);
                    	allDetails.setVisible(true);
                    	
    	            }
                    
				}catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(860, 167, 387, 201);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("DEAD LIST");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// dead list
				try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    var database = mongoClient.getDatabase("baklol");
                    try {
                        database.createCollection("testUsers");
                        System.out.println("Collection created successfully");
                    } catch (MongoCommandException ef) {
                    	database.getCollection("users").drop();
                    }
                    MongoCollection < Document > collection = database.getCollection("testUsers");
                    
                    BasicDBObject whereDbObject=new BasicDBObject();
                    whereDbObject.put("status",false);
                    
                    try (MongoCursor<Document> cur = collection.find(whereDbObject).iterator()) {
                    	
                    	AllDetails allDetails=new AllDetails(cur);
                    	allDetails.setVisible(true);
    	            }
                    
				}catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_1.setBounds(860, 467, 387, 201);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// search
				try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    var database = mongoClient.getDatabase("baklol");
                    try {
                        database.createCollection("testUsers");
                        System.out.println("Collection created successfully");
                    } catch (MongoCommandException ef) {
                    	database.getCollection("users").drop();
                    }
                    MongoCollection < Document > collection = database.getCollection("testUsers");
                    
                    BasicDBObject whereDbObject=new BasicDBObject();
                    if(!textField.getText().trim().equals(""))
                    	whereDbObject.put("name",textField.getText());
                    else whereDbObject.put("occup",textField_1.getText());
                    
                    try (MongoCursor<Document> cur = collection.find(whereDbObject).iterator()) {
                    	
                    	AllDetails allDetails=new AllDetails(cur);
                    	allDetails.setVisible(true);
    	            }
                    
				}catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 45));
		btnNewButton_2.setBounds(144, 569, 427, 99);
		contentPane.add(btnNewButton_2);
	}
}
