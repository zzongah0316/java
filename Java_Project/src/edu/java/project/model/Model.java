package edu.java.project.model;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import edu.java.project.decorate.RoundedButton;
import edu.java.project.food.Food;
import edu.java.project.weight.Weight;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Model extends MainModel {
	
	private final JFrame frmKcal = new JFrame();
	private Component parent;
	
	private Food app;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void showMyFrame (Component parent, Food app){
				try {
					Model window = new Model(parent, app);
					window.frmKcal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public Model(Component parent, Food app){
		this.parent = parent;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int x = 100; 
		int y = 100;
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		frmKcal.setTitle("Slim Diary");
		
		
		frmKcal.setBounds(x+155, y+50, 297, 385);
		frmKcal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKcal.getContentPane().setLayout(null);
		
		JButton btnNewButton = new RoundedButton("몸무게");
		btnNewButton.setText("체중 관리");
		btnNewButton.setFont(new Font("EF_jejudoldam", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(parent, "상처받지 않기!!", "약속", JOptionPane.WARNING_MESSAGE);
				Weight.showMyFrame(parent);
				
			}
		});
		btnNewButton.setBounds(80, 64, 114, 59);
		frmKcal.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new RoundedButton("식단");
		btnNewButton_1.setFont(new Font("EF_jejudoldam", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Food.showMyFrame(parent, app);
			}
		});
		btnNewButton_1.setBounds(80, 212, 114, 53);
		frmKcal.getContentPane().add(btnNewButton_1);
		
		List<ImageIcon> imageicon = new ArrayList<>();
		imageicon.add(new ImageIcon("image/model2.jpg"));
		lblNewLabel = new JLabel(imageicon.get(0));
		lblNewLabel.setBounds(0, 0, 281, 346);
		frmKcal.getContentPane().add(lblNewLabel);
		
		
		
	
	}
}
