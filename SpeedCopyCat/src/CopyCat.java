import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class CopyCat {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyCat window = new CopyCat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CopyCat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Speed Copy Cat");
		
		JLabel lblNewLabel = new JLabel(".../speedCopyCat");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		lblNewLabel.setBounds(30, 10, 670, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the path of Object");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(541, 77, 218, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MADE BY BMD 2020");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(1155, 10, 151, 50);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBackground(SystemColor.control);
		textField.setBounds(30, 124, 1255, 66);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter the path To copy");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(541, 220, 218, 44);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.DARK_GRAY);
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(30, 274, 1255, 66);
		frame.getContentPane().add(textField_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBounds(30, 515, 1261, 161);
		frame.getContentPane().add(progressBar);
		frame.setBounds(100, 100, 1330, 741);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel time = new JLabel("Time: ");
		time.setFont(new Font("Arial", Font.PLAIN, 35));
		time.setBounds(465, 395, 820, 58);
		frame.getContentPane().add(time);
		
		JButton btnNewButton = new JButton("COPY CAT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().equals("") || textField_1.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,"Enter the Path!!!");
					return;
				}
				new Cat(progressBar,time, textField.getText(),textField_1.getText()).start();
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 30));
		btnNewButton.setBounds(30, 369, 364, 115);
		frame.getContentPane().add(btnNewButton);
		
		
		
		
	}
}
