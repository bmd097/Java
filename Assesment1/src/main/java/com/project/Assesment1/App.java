package com.project.Assesment1;

import java.awt.EventQueue;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

/**
 * Hello world!
 *
 */
public class App 
{ 

	
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello Earth!" );
        
        // THE FRONTEND PART   
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.getTheFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
}
