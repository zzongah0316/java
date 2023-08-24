package edu.java.project.dinner;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.java.project.decorate.RoundedButton;
import edu.java.project.food.Food;
import edu.java.project.weight.WeightDaoImpl;
import edu.java.project.weight.WeightTable;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Dinner extends JFrame {
	private static final String[] COLUNM_NAMES = {"날짜", "식단", "저녁 총 칼로리"};


	private JPanel contentPane;
	private JTextField textDate;
	private JLabel lblDate_1;
	private JTextField textDinnerKcal;
	private JTextField textDinnerAKcal;
	private JButton btnPlus;
	private JButton btnResult;
	private JLabel lblDate_2;
	
	private DefaultTableModel model;
	private List<DinnerTable> dinnerTableList;
	private final DinnerDaoImpl dao = DinnerDaoImpl.getInstance();
	
	private JTable table;
	private Component parent;
	double plus = 0.0;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnSearch;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTextArea textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	private Food app;

	/**
	 * Launch the application.
	 */
	public static void showDinner(Component parent, Food app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dinner frame = new Dinner(parent,app);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void notifyDinnerUpdate() {
		resetTableModel();	
		
	}
	
	private void resetTableModel() {
		model = new DefaultTableModel(null, COLUNM_NAMES);
		loadDinnerData();
		table.setModel(model);	
	}
	
	private void loadDinnerData() {
		System.out.println("작동");
		dinnerTableList = dao.read();
		
		
		for(DinnerTable d : dinnerTableList) {
			System.out.println(d.getDay());//230419
			//23-04-19, 23/04/19
			String input = d.getDay();
	        SimpleDateFormat inputFormat = new SimpleDateFormat("yyMMdd");
	        Date date;
			try {
				date = inputFormat.parse(input);
				SimpleDateFormat outputFormat = new SimpleDateFormat("yy/MM/dd");
				String output = outputFormat.format(date);
				System.out.println(output);
				Object [] row = {output, d.getDiary(), d.getDinnerkcal()+"kcal"};
				model.addRow(row);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

	/**
	 * Create the frame.
	 */
	public Dinner(Component parent, Food app) {
		this.parent = parent;
		this.app = app;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		int x = 100;
		int y = 100;
		if(parent != null) {
			x = parent.getX();
			y = parent.getY();
		}
		setBounds(x-100, y, 943, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("저녁 식단 다이어리");
		lblNewLabel.setForeground(new Color(128, 64, 0));
		lblNewLabel.setFont(new Font("Sandoll 삼립호빵체 TTF Basic", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(131, 10, 220, 88);
		contentPane.add(lblNewLabel);
		
		textDate = new JTextField();
		textDate.setBounds(504, 20, 232, 37);
		contentPane.add(textDate);
		textDate.setColumns(10);
		
		JLabel lblDate = new JLabel("날짜");
		lblDate.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDate.setForeground(new Color(128, 64, 0));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(443, 19, 72, 37);
		contentPane.add(lblDate);
		
		lblDate_1 = new JLabel("칼로리 계산기");
		lblDate_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDate_1.setForeground(new Color(128, 64, 0));
		lblDate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1.setBounds(504, 103, 140, 37);
		contentPane.add(lblDate_1);
		
		textDinnerKcal = new JTextField();
		textDinnerKcal.setColumns(10);
		textDinnerKcal.setBounds(516, 150, 116, 43);
		contentPane.add(textDinnerKcal);
		
		textDinnerAKcal = new JTextField();
		textDinnerAKcal.setBounds(730, 147, 158, 49);
		contentPane.add(textDinnerAKcal);
		textDinnerAKcal.setColumns(10);
		
		btnPlus = new RoundedButton("+");
		btnPlus.setFont(new Font("굴림", Font.PLAIN, 10));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double msg = Double.parseDouble(textDinnerKcal.getText());
				plus += msg;
				textDinnerKcal.setText("");
			}
		});
		
		
		btnPlus.setBounds(644, 126, 44, 37);
		contentPane.add(btnPlus);
		
		btnResult = new RoundedButton("=");
		btnResult.setFont(new Font("굴림", Font.PLAIN, 10));
		btnResult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textDinnerKcal.getText().equals("")) {
				textDinnerAKcal.setText(String.valueOf(plus)+"Kcal");
				textDinnerKcal.setText("");
				} else {
					double msg = Double.parseDouble(textDinnerKcal.getText());
					plus += msg;
					textDinnerAKcal.setText(String.valueOf(plus)+"Kcal");
					textDinnerKcal.setText("");
				}
			}
		});
		btnResult.setBounds(644, 174, 44, 37);
		contentPane.add(btnResult);
		
		lblDate_2 = new JLabel("하루 총 열량");
		lblDate_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDate_2.setForeground(new Color(128, 64, 0));
		lblDate_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_2.setBounds(730, 103, 140, 37);
		contentPane.add(lblDate_2);
		
		btnAdd = new RoundedButton("저장");
		btnAdd.setFont(new Font("EF_jejudoldam", Font.PLAIN, 13));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addBreakfast();
			}
		});
		btnAdd.setBounds(24, 464, 90, 37);
		contentPane.add(btnAdd);
		
		btnUpdate = new RoundedButton("수정");
		btnUpdate.setFont(new Font("EF_jejudoldam", Font.PLAIN, 13));
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateBreakf();
			}
		});
		btnUpdate.setBounds(131, 464, 90, 37);
		contentPane.add(btnUpdate);
		
		btnSearch = new RoundedButton("검색");
		btnSearch.setFont(new Font("EF_jejudoldam", Font.PLAIN, 13));
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectDay();
			}
		});
		btnSearch.setBounds(244, 464, 90, 37);
		contentPane.add(btnSearch);
		
		btnDelete = new RoundedButton("삭제");
		btnDelete.setFont(new Font("EF_jejudoldam", Font.PLAIN, 13));
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteBk();
			}
		});
		btnDelete.setBounds(353, 464, 90, 37);
		contentPane.add(btnDelete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(484, 233, 419, 272);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Sandoll 삼립호빵체 TTF Basic", Font.PLAIN, 13));
		Object[][] data = {};
		model = new DefaultTableModel(data, COLUNM_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		textField = new JTextArea();
		textField.setBounds(24, 98, 419, 356);
		contentPane.add(textField);
		
		lblNewLabel_1 = new JLabel("<html>* 주의사항 : <br> 숫자 "
				+ "6개로 적어주세요 <br> ex) 2023년 4월 21일 <br> ->     230421</html>");
		lblNewLabel_1.setBounds(771, 10, 156, 68);
		contentPane.add(lblNewLabel_1);
		
		
		List<ImageIcon> imageicon = new ArrayList<>();
		imageicon.add(new ImageIcon("image/lunch4.jpg"));
		lblNewLabel_2 = new JLabel(imageicon.get(0));
		lblNewLabel_2.setBounds(0, 0, 927, 527);
		contentPane.add(lblNewLabel_2);
		loadDinnerData();
		app.notifyContactUpdate();
		
		
		
		
	}

	protected void selectDay() {
		String keyword = JOptionPane.showInputDialog(contentPane, "<html>검색할 날짜를 입력해주세요 <br> ex) 2023년 4월 21일 -> 230421 <html>", "날짜 검색");
		System.out.println("keyword = " + keyword);
		if (keyword == null) {
			JOptionPane.showMessageDialog(contentPane, "검색어를 입력하세요...");
			return; // 메서드 종료.
		}
		
		dinnerTableList = dao.read(keyword); // 검색 결과
		
		model = new DefaultTableModel(null, COLUNM_NAMES);
		for (DinnerTable d : dinnerTableList) {
			Object[] row = {d.getDay(), d.getDiary(), d.getDinnerkcal()};
			model.addRow(row);
		}
		table.setModel(model);
		
	}

	protected void deleteBk() {
		int row = table.getSelectedRow();
		int confirm = JOptionPane.showConfirmDialog(
				Dinner.this, 
				"정말로 삭제하시겠습니까?", 
				"삭제 확인", 
				JOptionPane.YES_NO_OPTION);
		if(row == -1) {
			JOptionPane.showMessageDialog(contentPane, "삭제할 정보를 선택해주세요!", "선택", JOptionPane.CANCEL_OPTION);
			return;
		}
		int fid = dinnerTableList.get(row).getFid();
		dao.delete(fid);
		model.removeRow(row);
		app.notifyContactUpdate();
		JOptionPane.showMessageDialog(contentPane, "삭제 성공 !");
	}

	protected void updateBreakf() {
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(contentPane, 
					"업데이트할 행을 먼저 선택하세요", 
					"경고", 
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		int cid = dinnerTableList.get(row).getFid();
		app.notifyContactUpdate();
		DinnerUpdate.showDinnerUpdate(contentPane, cid, Dinner.this);
		table.setModel(model);
	}

	private void addBreakfast() {
		int fid = 0;
		String day = null;
		String diary = null;
		Double dinnerkcal = 0.0;
		try {
			
			// 날짜 반드시 기입하게 하자!
			
			if(textDate.getText().length() != 6 && textDate.getText().equals("")) {
				JOptionPane.showMessageDialog(contentPane, "날짜 잘못 기입했습니다!! ", "날짜 오류", JOptionPane.CANCEL_OPTION);
				return;
			} else {
		day = textDate.getText();
		diary = textField.getText();
		dinnerkcal = plus;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "날짜 & 글자 수 & 열량 확인해주세요!! ", "날짜 & 글자 수 & 열량 오류", JOptionPane.CANCEL_OPTION);
			return;
		}
		
		DinnerTable dinnerTable = new DinnerTable (fid, day, diary, dinnerkcal);
		
		
		dao.creat(dinnerTable);
		dao.creatFoodsDinner(dinnerTable);
		JOptionPane.showMessageDialog(contentPane, "저장 성공 !");
		textField.setText("");
		textDate.setText("");
		textDinnerAKcal.setText("");
		
	
		loadDinnerData();
		app.notifyContactUpdate();
	}
}
