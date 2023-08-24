package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AppMain04 {

	private JFrame frame;
	private JButton btnLeft;
	private JButton btnRight;
	private int i = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain04 window = new AppMain04();
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
	public AppMain04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		List<ImageIcon> imageicon = new ArrayList<>();
		imageicon.add(new ImageIcon("images/1053-300x350.jpg"));
		imageicon.add(new ImageIcon("images/30-300x350.jpg"));
		imageicon.add(new ImageIcon("images/613-300x350.jpg"));
		imageicon.add(new ImageIcon("images/743-300x350.jpg"));
		imageicon.add(new ImageIcon("images/974-300x350.jpg"));
		
		JLabel lblImages = new JLabel(imageicon.get(i));
		lblImages.setBounds(70, 10, 300, 350);
		frame.getContentPane().add(lblImages);
		
		btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				i--;
				if(i<0) {
					i=0;
					lblImages.setIcon(null);
					lblImages.setText("이미지가 없습니다.");
					
				} else {
					lblImages.setIcon(imageicon.get(i));
				}
			}
		});
		btnLeft.setFont(new Font("굴림", Font.BOLD, 18));
		btnLeft.setBounds(12, 376, 97, 58);
		frame.getContentPane().add(btnLeft);
		
		btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				if(i>=5) {
					i = imageicon.size()-1;
					lblImages.setIcon(null);
					lblImages.setText("이미지가 없습니다.");
				} else {
					lblImages.setIcon(imageicon.get(i));
				}
	
			}
		});
		btnRight.setFont(new Font("굴림", Font.BOLD, 18));
		btnRight.setBounds(325, 376, 97, 58);
		frame.getContentPane().add(btnRight);
	}

	

	
	

}
