package edu.java.project.weight;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import edu.java.project.decorate.RoundedButton;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Weight extends JFrame {
	
	private static final String[] COLUNM_NAMES = {"내 몸무게", "내 키", "비만도", "측정 날짜"};

	private final JPanel contentPane = new JPanel();
	private Component parent;
	private JTextField textWeight;
	private JTable table;

	
	
	
	private DefaultTableModel model;
	private List<WeightTable> weightTableList;
	
	private final WeightDaoImpl dao = WeightDaoImpl.getInstance();
	private JTextField textHeight;
	private JScrollPane scrollPane;
	

	
	

	/**
	 * Launch the application.
	 */
	public static void showMyFrame(Component parent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Weight frame = new Weight(parent);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
	}
	
	public void notifyContactUpdate() {
		resetTableModel();
		
	}
	

	private void resetTableModel() {
		model = new DefaultTableModel(null, COLUNM_NAMES);
		table.setModel(model);
		
//		loadWeightData();
		
	}
	

	private void loadWeightData() {
		System.out.println("sdffffffffffffffffffffff");
		weightTableList = dao.read();
		for(WeightTable w : weightTableList) {
			Object [] row = {w. getWeight()+"KG", w.getHeight()+"CM", w.getBMI(), w.getTime()};
			model.addRow(row);
		}
		
	}

	/**
	 * Create the frame.
	 */
	
		
	public Weight(Component parent) {
		
		this.parent = parent;
		
		setTitle("Weight");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 100;
		int y = 100;
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x-5, y, 637, 520);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWeight = new JLabel("내 몸무게");
		lblWeight.setForeground(new Color(128, 64, 0));
		lblWeight.setFont(new Font("EF_jejudoldam", Font.BOLD, 25));
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		
	
		lblWeight.setBounds(74, 81, 115, 47);
		contentPane.add(lblWeight);
		
		textWeight = new JTextField();
		textWeight.setBackground(new Color(255, 255, 255));
		textWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textWeight.setBounds(261, 92, 96, 30);
		contentPane.add(textWeight);
		textWeight.setColumns(10);
		
		JButton btnNewButton = new RoundedButton("확인");
		btnNewButton.setFont(new Font("EF_jejudoldam", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insert();
				
			}
		});
		btnNewButton.setBounds(393, 87, 89, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new RoundedButton("삭제");
		btnNewButton_1.setFont(new Font("EF_jejudoldam", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnNewButton_1.setBounds(393, 144, 89, 38);
		contentPane.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 225, 575, 227);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Sandoll 삼립호빵체 TTF Basic", Font.PLAIN, 13));
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 0, 0));
		Object[][] data = {};
		model = new DefaultTableModel(data, COLUNM_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblHeight = new JLabel("내 키");
		lblHeight.setForeground(new Color(128, 64, 0));
		lblHeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeight.setFont(new Font("EF_jejudoldam", Font.BOLD, 25));
		lblHeight.setBounds(84, 138, 77, 47);
		contentPane.add(lblHeight);
		
		textHeight = new JTextField();
		textHeight.setBackground(new Color(255, 255, 255));
		textHeight.setColumns(10);
		textHeight.setBounds(261, 145, 96, 30);
		contentPane.add(textHeight);
		
		
		List<ImageIcon> imageicon = new ArrayList<>();
		imageicon.add(new ImageIcon("image/weight0317.jpg"));
		JLabel lblNewLabel = new JLabel(imageicon.get(0));
		lblNewLabel.setBounds(0, 0, 621, 481);
		contentPane.add(lblNewLabel);
		
		
		System.out.println("asdf");
	
		loadWeightData();
		
		System.out.println("iopiop");
		
	}

	protected void delete() {
		int row = table.getSelectedRow();
		int confirm = JOptionPane.showConfirmDialog(
				Weight.this, 
				"정말로 삭제하시겠습니까?", 
				"삭제 확인", 
				JOptionPane.YES_NO_OPTION);
		if(row == -1) {
			JOptionPane.showMessageDialog(contentPane, "삭제할 정보를 선택해주세요!", "선택", JOptionPane.YES_NO_OPTION);
			return;
		}
		int id = weightTableList.get(row).getId();
		dao.delete(id);
		model.removeRow(row);
		JOptionPane.showMessageDialog(contentPane, "삭제 성공 !");
	}

	protected void insert() {
		int id = 0;
		double weight = 0.0;
		double height = 0.0;
		String bmi = null;
		LocalDateTime createdTime = null;
		try {
			
		weight = Double.parseDouble(textWeight.getText());
		height = Double.parseDouble(textHeight.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "몸무게와 키 다시 확인해주세요!", "몸무게 & 키 오류", JOptionPane.CANCEL_OPTION);
			return;
		}
		
		WeightTable weightTable = new WeightTable (id, weight, height, bmi, createdTime);
		
		Object [] row = {
				weightTable.getWeight() + "Kg",
				weightTable.getHeight() + "CM",
				weightTable.getBMI(),
				weightTable.getTime()
				};

		
		dao.create(weightTable);
		JOptionPane.showMessageDialog(contentPane, "저장 성공 !");
		resetTableModel();
		loadWeightData();
	
	}
}
