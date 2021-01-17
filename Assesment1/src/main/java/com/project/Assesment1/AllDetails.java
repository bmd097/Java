package com.project.Assesment1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.bson.Document;

import com.mongodb.client.MongoCursor;

import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AllDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllDetails frame = new AllDetails(null);
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
	public AllDetails(MongoCursor<Document> cur) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1114, 758);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<String> list = new JList<>();
		list.setFont(new Font("SansSerif", Font.PLAIN, 25));
		list.setBounds(10, 79, 1080, 632);
		contentPane.add(list);
		
		DefaultListModel<String> model=new DefaultListModel<>();
		list.setModel(model);
		
		JLabel lblNewLabel = new JLabel("*****ENTRIES*****");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 1080, 59);
		contentPane.add(lblNewLabel);
		
		while (cur.hasNext()) { 	
	        var doc = cur.next();
	        String responseString="";
	        responseString+=doc.getString("name")+" | ";
	        responseString+=doc.getString("dtOfBirth")+" | ";
	        responseString+=doc.getString("occup")+" | ";
	        responseString+=(doc.getBoolean("family")?"SINGLE":"JOINT")+" | ";
	        responseString+=(doc.getBoolean("status")?"ALIVE":"DEAD");
	        model.addElement(responseString);
	    }
	}
}
