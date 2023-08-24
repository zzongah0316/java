package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.callback.TextInputCallback;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class AppMain03 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea textArea;
	private JButton btnadd;
	private JButton btnminus;
	private JButton btnX;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain03 window = new AppMain03();
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
	public AppMain03() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 829, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label1 = new JLabel(" num1");
		label1.setForeground(new Color(0, 0, 0));
		label1.setFont(new Font("Cambria", Font.BOLD, 19));
		label1.setBackground(new Color(255, 0, 0));
		label1.setBounds(12, 25, 157, 58);
		frame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel(" num2");
		label2.setFont(new Font("Cambria", Font.BOLD, 19));
		label2.setBounds(12, 101, 157, 58);
		frame.getContentPane().add(label2);
		
		btnadd = new JButton("+");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double msg = Integer.parseInt(textField.getText());
				double msg2 = Integer.parseInt(textField_1.getText());
				double adds = msg + msg2;
				textArea.setText(String.valueOf(adds));
			}
		});

		btnadd.setFont(new Font("굴림", Font.BOLD, 23));
		btnadd.setBounds(21, 180, 107, 58);
		frame.getContentPane().add(btnadd);
		
		btnminus = new JButton("-");
		btnminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int msg = Integer.parseInt(textField.getText());
				int msg2 = Integer.parseInt(textField_1.getText());
				int minuss = msg - msg2;
				textArea.setText(String.valueOf(minuss));
			}
		});
		btnminus.setFont(new Font("굴림", Font.BOLD, 23));
		btnminus.setBounds(140, 180, 107, 58);
		frame.getContentPane().add(btnminus);
		
		btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double msg = Integer.parseInt(textField.getText());
				double msg2 = Integer.parseInt(textField_1.getText());
				double x = msg * msg2;
				textArea.setText(String.valueOf(x));
				
			}
		});
		btnX.setFont(new Font("굴림", Font.BOLD, 23));
		btnX.setBounds(269, 180, 107, 58);
		frame.getContentPane().add(btnX);
		
		btnNewButton = new JButton("/");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double msg = Integer.parseInt(textField.getText());
				double msg2 = Integer.parseInt(textField_1.getText());
				double result = msg / msg2;
				textArea.setText(String.valueOf(result));
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 23));
		btnNewButton.setBounds(404, 180, 107, 58);
		frame.getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 30));
		textArea.setText("(3)");
		textArea.setBounds(12, 248, 501, 183);
		frame.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("(1)");
		textField.setBounds(215, 20, 296, 63);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("(2)");
		textField_1.setBounds(215, 101, 296, 58);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		

	}
}
