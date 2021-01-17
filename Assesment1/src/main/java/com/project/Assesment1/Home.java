package com.project.Assesment1;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoCommandException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public JFrame getTheFrame() {
		return this.frame;
	}
	public int firstShowThemMyIdentity() {
		JOptionPane.showMessageDialog(null,"NAME : BISWAMOHAN DWARI"+"\n"+"REGD_NO : 1941012331"+"\n"+
	"**THIS IS MY PROJECT.I HAVE MADE IT**");
		return JFrame.EXIT_ON_CLOSE;
	}
	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(50, 20, 1360, 760);
		frame.setDefaultCloseOperation(this.firstShowThemMyIdentity());
		frame.getContentPane().setLayout(null);
		frame.setTitle("PERSON ID-BASE");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 529, 703);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/images/pic1.jpg")));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PERSON ID-BASE");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 45));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(627, 43, 638, 62);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(634, 147, 110, 51);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(634, 227, 110, 37);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		textField.setBounds(777, 154, 501, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(777, 226, 501, 43);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check=false;
				String nameString=textField.getText().toLowerCase().trim();
				String passwString=new String(passwordField.getPassword());
				Document docu=null;
				
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
                    whereDbObject.put("userId",passwString);
                    FindIterable<Document> cursor=collection.find(whereDbObject);
                    Document document=cursor.first();
                    if(document!=null) {
                    	if(!document.get("name").toString().toLowerCase().equals(nameString)) return;
                    	check=true;
                    	docu=document;
                    }
                                        
				}catch (Exception e2) {}
				
				if(check) {
					User user=new User(getTheFrame(),docu);
					frame.setVisible(false);
					user.setVisible(true);
					textField.setText("");
					passwordField.setText("");
				} else JOptionPane.showMessageDialog(null,"INVALID AUTHENTICATION!!!");
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 30));
		btnNewButton.setBounds(1111, 297, 167, 62);
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(628, 388, 650, 5);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(946, 390, 8, 281);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_4 = new JLabel("MADE BY BISWAMOHAN 2021");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(1015, 692, 321, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("if your a new user");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 35));
		lblNewLabel_5.setBounds(612, 456, 296, 85);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("ADD USER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser addUser=new AddUser(frame);
				frame.setVisible(false);
				addUser.setVisible(true);
			}
		});
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.setBounds(652, 551, 195, 62);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("for a guest");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.PLAIN, 35));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(982, 467, 283, 62);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("GUEST IN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guest guest=new Guest(getTheFrame());
				frame.setVisible(false);
				guest.setVisible(true);
			}
		});
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.setBounds(1027, 551, 195, 62);
		frame.getContentPane().add(btnNewButton_2);
		
		
		
	
	}
}
