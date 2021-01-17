package com.project.Assesment1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User(null,null);
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
	public User(final JFrame homeFrame,Document document) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1360, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle(document.getString("name"));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 90, 1290, 5);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Hello");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 45));
		lblNewLabel.setBounds(30, 10, 115, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel(document.getString("name"));
		lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 45));
		lblUsername.setBounds(146, 10, 610, 70);
		contentPane.add(lblUsername);
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnNewButton.setBounds(1116, 10, 204, 70);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(30, 128, 178, 59);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dt. of Birth");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("SansSerif", Font.PLAIN, 35));
		lblNewLabel_1_1.setBounds(37, 208, 171, 59);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Occupation");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("SansSerif", Font.PLAIN, 35));
		lblNewLabel_1_2.setBounds(18, 292, 190, 59);
		contentPane.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField.setBounds(228, 128, 703, 59);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(document.getString("name"));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_1.setColumns(10);
		textField_1.setBounds(228, 208, 703, 59);
		contentPane.add(textField_1);
		textField_1.setText(document.getString("dtOfBirth"));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_2.setColumns(10);
		textField_2.setBounds(228, 292, 703, 59);
		contentPane.add(textField_2);
		textField_2.setText(document.getString("occup"));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Family Type");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 35));
		lblNewLabel_1_2_1.setBounds(10, 408, 198, 59);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Status");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_2.setFont(new Font("SansSerif", Font.PLAIN, 35));
		lblNewLabel_1_2_2.setBounds(51, 510, 149, 59);
		contentPane.add(lblNewLabel_1_2_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Single");
		JCheckBox chckbxJoint = new JCheckBox("Joint");

		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) chckbxJoint.setSelected(false);
				else chckbxJoint.setSelected(true);
			}
		});
		chckbxNewCheckBox.setSelected(document.getBoolean("family"));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxNewCheckBox.setBounds(249, 408, 137, 59);
		contentPane.add(chckbxNewCheckBox);
		
		chckbxJoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxJoint.isSelected()) chckbxNewCheckBox.setSelected(false);
				else chckbxNewCheckBox.setSelected(true);
			}
		});
		chckbxJoint.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxJoint.setSelected(!document.getBoolean("family"));
		chckbxJoint.setBounds(417, 408, 137, 59);
		contentPane.add(chckbxJoint);
		
		JCheckBox chckbxAlive = new JCheckBox("ALIVE");
		JCheckBox chckbxDead = new JCheckBox("DEAD");

		chckbxAlive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxAlive.isSelected()) chckbxDead.setSelected(false);
				else chckbxDead.setSelected(true);
			}
		});
		chckbxAlive.setSelected(document.getBoolean("status"));
		chckbxAlive.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxAlive.setBounds(249, 510, 137, 59);
		contentPane.add(chckbxAlive);
		
		chckbxDead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxDead.isSelected()) chckbxAlive.setSelected(false);
				else chckbxAlive.setSelected(true);
			}
		});
		chckbxDead.setFont(new Font("Tahoma", Font.PLAIN, 30));
		chckbxDead.setSelected(!document.getBoolean("status"));
		chckbxDead.setBounds(417, 510, 137, 59);
		contentPane.add(chckbxDead);
		
		JLabel lblNewLabel_2 = new JLabel("id");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(30, 647, 39, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(document.getString("userId"));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_3.setBounds(75, 626, 276, 76);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// save Info
				boolean check=false;
				try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    var database = mongoClient.getDatabase("baklol");
                    try {
                        database.createCollection("testUsers");
                        System.out.println("Collection created successfully");
                    } catch (MongoCommandException ef) {
                    	database.getCollection("users").drop();
                    }
                    MongoCollection < Document > collection = database.getCollection("testUsers");
                    
                    String nameString=textField.getText().trim();
            		String dtOfBirthString=textField_1.getText().trim();
            		String occupationString=textField_2.getText().trim();
            		boolean familyType=chckbxNewCheckBox.isSelected();
            		boolean status=chckbxAlive.isSelected();
            		String userId=lblNewLabel_3.getText();
            		if(nameString.trim().equals("") || dtOfBirthString.trim().equals("") || occupationString.trim().equals("")) return;
            		
            		var temp = new Document("userId",userId);
            		temp.append("name",nameString);
            		temp.append("dtOfBirth",dtOfBirthString);
            		temp.append("occup",occupationString);
            		temp.append("family",familyType);
            		temp.append("status",status);
                    
                    collection.updateOne(new Document("userId", lblNewLabel_3.getText()),new Document("$set",temp));
                    check=true;
                    
				}catch (Exception e2) {}
				
				if(check) JOptionPane.showMessageDialog(null,"UPDATED SUCCESSFULLY!!!");
				else JOptionPane.showMessageDialog(null,"FAILED");
				
			}
		});
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 50));
		btnNewButton_1.setBounds(988, 170, 317, 181);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("PRINT ");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// print
				boolean check=false;
				try {
					PrintWriter myWriter=new PrintWriter(new File(textField.getText()+"-Details.txt"));
					myWriter.print("*********************DETAILS**************************"+"\n");
					myWriter.print("NAME : "+textField.getText()+"\n");
					myWriter.print("DATE OF BIRTH : "+textField_1.getText()+"\n");
					myWriter.print("OCCUPATION : "+textField_2.getText()+"\n");
					myWriter.print("FAMILY : "+(chckbxNewCheckBox.isSelected()?"SINGLE":"JOINT")+"\n");
					myWriter.print("STATUS : "+(chckbxAlive.isSelected()?"ALIVE":"DEAD")+"\n");
					myWriter.print("ID : "+lblNewLabel_3.getText()+"\n");
					myWriter.flush();
					myWriter.close();
					check=true;
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(check) JOptionPane.showMessageDialog(null,"PRINTED SUCCESSFULLY!!!");
				else JOptionPane.showMessageDialog(null,"FAILED");
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("SansSerif", Font.PLAIN, 50));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_1.setBounds(988, 454, 317, 181);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//delete
				int res=JOptionPane.showConfirmDialog(null,"You sure wanna delete this user???");
				if(res==JOptionPane.OK_OPTION) {
					boolean check=false;
					try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
	                    var database = mongoClient.getDatabase("baklol");
	                    try {
	                        database.createCollection("testUsers");
	                        System.out.println("Collection created successfully");
	                    } catch (MongoCommandException ef) {
	                    	database.getCollection("users").drop();
	                    }
	                    MongoCollection < Document > collection = database.getCollection("testUsers");
	                    collection.deleteOne(Filters.eq("userId",document.getString("userId")));
	                    check=true;
					}catch (Exception e2) {
						// TODO: handle exception
					}
					if(check) {
						JOptionPane.showMessageDialog(null,"DELETED!!!");
						homeFrame.setVisible(true);
						dispose();
					}
					else JOptionPane.showMessageDialog(null,"FAILED!!!");
				}
			}
		});
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 50));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(613, 454, 310, 181);
		contentPane.add(btnNewButton_2);
	}
}
