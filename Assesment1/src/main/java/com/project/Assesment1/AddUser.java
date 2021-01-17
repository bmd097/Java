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
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AddUser extends JFrame {

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
					AddUser frame = new AddUser(null);
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
	public AddUser(final JFrame homeFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1360, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("ADD USER");
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 90, 1290, 5);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Add USER");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 45));
		lblNewLabel.setBounds(30, 10, 471, 70);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res=JOptionPane.showConfirmDialog(null,"So you don't want to resister,ha???");
				if(res==JOptionPane.OK_OPTION) {
					homeFrame.setVisible(true);
					dispose();
				}
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
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_1.setColumns(10);
		textField_1.setBounds(228, 208, 703, 59);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_2.setColumns(10);
		textField_2.setBounds(228, 292, 703, 59);
		contentPane.add(textField_2);
		
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
		chckbxNewCheckBox.setSelected(true);
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
		chckbxAlive.setSelected(true);
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
		chckbxDead.setBounds(417, 510, 137, 59);
		contentPane.add(chckbxDead);
		
		JLabel lblNewLabel_2 = new JLabel("id");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(30, 647, 39, 45);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("58945");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_3.setBounds(75, 626, 276, 76);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setText(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+""+Calendar.getInstance().get(Calendar.MINUTE)+""+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
				+""+(Calendar.getInstance().get(Calendar.MONDAY)+1)+""+Calendar.getInstance().get(Calendar.YEAR)%100+"");
		
		
		JButton btnNewButton_1_1 = new JButton("ADD USER");
		btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
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
        		boolean check=false;
        		// THE BACKEND PART
                try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    var database = mongoClient.getDatabase("baklol");
                    try {
                        database.createCollection("testUsers");
                        System.out.println("Collection created successfully");
                    } catch (MongoCommandException ef) {
                    	database.getCollection("users").drop();
                    }
                    MongoCollection < Document > collection = database.getCollection("testUsers");
        		
                    collection.insertOne(temp);
                    check=true;
                }catch (Exception ef) {
        			System.exit(0);
        		}finally {
					JOptionPane.showMessageDialog(null,check?"SUCCESSFULLY ADDED!!!":"FAILED!!!");
					homeFrame.setVisible(true);
					dispose();
				}
              
        	}
        });
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("SansSerif", Font.PLAIN, 50));
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1_1.setBounds(789, 451, 503, 221);
		contentPane.add(btnNewButton_1_1);
	}
}
