package edu.java.project.model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import edu.java.project.decorate1.RoundedButton;
import edu.java.project.food.Food;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;






public class MainModel {

	private JFrame frmSlimDiary;
	private JButton btnNewButton;
	private JPanel panel;
	private Food app;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainModel window = new MainModel();
					window.frmSlimDiary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public MainModel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSlimDiary = new JFrame();
		frmSlimDiary.setTitle("Slim Diary");
		frmSlimDiary.setBounds(100, 100, 625, 550);
		frmSlimDiary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSlimDiary.getContentPane().setLayout(null);
		
	
		
		btnNewButton = new RoundedButton("시작하기");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(176, 227, 240));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Model.showMyFrame(frmSlimDiary, app);
			}
		});
		btnNewButton.setFont(new Font("EF_jejudoldam", Font.BOLD, 30));
		btnNewButton.setBounds(189, 354, 247, 43);
		frmSlimDiary.getContentPane().add(btnNewButton);
		
		List<ImageIcon> imageicon = new ArrayList<>();
		imageicon.add(new ImageIcon("image/mainmodeljpg.jpg"));
		
		JLabel panel = new JLabel(imageicon.get(0));
		panel.setBounds(0, 0, 609, 511);
		frmSlimDiary.getContentPane().add(panel);
		
		

		
		
	}
}
