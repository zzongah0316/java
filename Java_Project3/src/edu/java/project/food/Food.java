package edu.java.project.food;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.java.project.bk.Breakfast;
import edu.java.project.decorate1.RoundedButton;
import edu.java.project.dinner.Dinner;
import edu.java.project.lunch.Lunch;
import edu.java.project.model.Model;
import edu.java.project.weight.WeightTable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JLabel;

public class Food extends JFrame {
	private static final String[] COLUNM_NAMES = {"날짜", 
			"아침 칼로리", "점심 칼로리", "저녁 칼로리", "하루 총 칼로리"};

	private DefaultTableModel model;
	private List<FoodTable> foodTableList;
	
	private final FoodDaoImpl dao = FoodDaoImpl.getInstance();
	private JPanel contentPane;
	private JTable table;
	private Component parent;

	/**
	 * Launch the application.
	 */
	public static void showMyFrame(Component parent, Food app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Food frame = new Food(parent, app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void notifyContactUpdate() {
		System.out.println("notifyContactUpdate in");
		resetTableModel();
		loadFoodtData();
		
	}
	

	private void resetTableModel() {
		model = new DefaultTableModel(null, COLUNM_NAMES);
		table.setModel(model);
//		loadWeightData();	
	}
	
	
	
	private void loadFoodtData() {
		System.out.println("sdffffffffffffffffffffff");
		foodTableList = dao.read();
		for(FoodTable f : foodTableList) {
			Object [] row = {f.getDay(), f.getBfkcal(), f.getLunchkcal(), f.getDinnerkcal(), f.getAllkcal()};
			model.addRow(row);
		}
		table.setModel(model);
	}

	/**
	 * Create the frame.
	 */
	public Food(Component parent, Food app) {
		this.parent = parent;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 100;
		int y = 100;
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x-90, y+20, 803, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBF = new RoundedButton("아침");
		btnBF.setFont(new Font("EF_jejudoldam", Font.BOLD, 20));
		btnBF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Breakfast.showBK(parent, Food.this);
			}
		});
		btnBF.setBounds(24, 105, 158, 49);
		contentPane.add(btnBF);
		
		JButton btnLunch = new RoundedButton("점심");
		btnLunch.setFont(new Font("EF_jejudoldam", Font.BOLD, 20));
		btnLunch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Lunch.showLunch(parent, Food.this);
			}
		});
		btnLunch.setBounds(24, 191, 158, 49);
		contentPane.add(btnLunch);
		
		JButton btnDinner = new RoundedButton("저녁");
		btnDinner.setFont(new Font("EF_jejudoldam", Font.BOLD, 20));
		btnDinner.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Dinner.showDinner(parent, Food.this);
			}
		});
		btnDinner.setBounds(24, 276, 158, 49);
		contentPane.add(btnDinner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(214, 48, 550, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Sandoll 삼립호빵체 TTF Basic", Font.PLAIN, 13));
		Object[][] data = {};
		model = new DefaultTableModel(data, COLUNM_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		List<ImageIcon> imageicon = new ArrayList<>();
		imageicon.add(new ImageIcon("image/food3.jpg"));
		JLabel lblNewLabel = new JLabel(imageicon.get(0));
		lblNewLabel.setBounds(0, 0, 787, 399);
		contentPane.add(lblNewLabel);
		
		model = new DefaultTableModel(null, COLUNM_NAMES);
		loadFoodtData();
		
	}
}
