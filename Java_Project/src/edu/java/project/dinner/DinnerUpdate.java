package edu.java.project.dinner;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.project.bk.BreakfastTable;
import edu.java.project.decorate.RoundedButton;
import edu.java.project.bk.BreakfastDaoImpl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class DinnerUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField textDayU;
	private JTextField textBfU;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JTextField textDiaryU;
	
	private Component parent;
	private Dinner app;
	
	private final DinnerDaoImpl dao = DinnerDaoImpl.getInstance();
	private int fid;
	private JLabel lblNewLabel_2;
	private JPanel panel;
	

	

	/**
	 * Launch the application.
	 */
	public static void showDinnerUpdate (Component parent, int fid, Dinner app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DinnerUpdate frame = new DinnerUpdate(parent, fid, app);
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
	public DinnerUpdate(Component parent, int fid, Dinner app) {
		this.parent = parent;
		this.fid = fid;
		this.app = app;
		initialize();
		readBreakfastTable();
	}
	
	


	private void readBreakfastTable() {
		DinnerTable dinnerTable = dao.read(fid);
		textDayU.setText(dinnerTable.getDay());
		textBfU.setText(String.valueOf(dinnerTable.getDinnerkcal()));
		textDiaryU.setText(dinnerTable.getDiary());
	}

	public void initialize(){
		int x = 100;
		int y = 100;
		if(app !=null) {
			x = app.getX();
			y = app.getY();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(x+50, y+20, 820, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textDayU = new JTextField();
		textDayU.setBounds(64, 68, 266, 31);
		contentPane.add(textDayU);
		textDayU.setColumns(10);
		
		lblNewLabel = new JLabel("변경할 날짜");
		lblNewLabel.setForeground(new Color(128, 64, 0));
		lblNewLabel.setFont(new Font("Sandoll 삼립호빵체 TTF Basic", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(64, 33, 104, 25);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("변경할 저녁 열량");
		lblNewLabel_1.setForeground(new Color(128, 64, 0));
		lblNewLabel_1.setFont(new Font("Sandoll 삼립호빵체 TTF Basic", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(591, 84, 104, 31);
		contentPane.add(lblNewLabel_1);
		
		textBfU = new JTextField();
		textBfU.setColumns(10);
		textBfU.setBounds(544, 125, 204, 31);
		contentPane.add(textBfU);
		
		lblNewLabel_1_1 = new JLabel("변경할 식단");
		lblNewLabel_1_1.setForeground(new Color(128, 64, 0));
		lblNewLabel_1_1.setFont(new Font("Sandoll 삼립호빵체 TTF Basic", Font.PLAIN, 18));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(64, 138, 104, 31);
		contentPane.add(lblNewLabel_1_1);
		
		textDiaryU = new JTextField();
		textDiaryU.setColumns(10);
		textDiaryU.setBounds(64, 179, 684, 126);
		contentPane.add(textDiaryU);
		
		JButton btnfinish = new RoundedButton("완료");
		btnfinish.setFont(new Font("EF_jejudoldam", Font.PLAIN, 12));
		btnfinish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateBreakfast();
			}
		});
		btnfinish.setBounds(479, 325, 121, 37);
		contentPane.add(btnfinish);
		
		JButton btndispose = new RoundedButton("취소");
		btndispose.setFont(new Font("EF_jejudoldam", Font.PLAIN, 12));
		btndispose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btndispose.setBounds(642, 325, 121, 37);
		contentPane.add(btndispose);
		
		lblNewLabel_2 = new JLabel("<html>* 주의사항 : <br> 숫자 "
				+ "6개로 적어주세요 <br> ex) 2023년 4월 21일 <br> ->     230421</html>");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 11));
		lblNewLabel_2.setBounds(344, 40, 121, 75);
		contentPane.add(lblNewLabel_2);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 203, 151));
		panel.setBounds(38, 22, 739, 354);
		contentPane.add(panel);
	}

	private void updateBreakfast() {
		String day = textDayU.getText();
		Double dinnerkcal = Double.parseDouble(textBfU.getText());
		String diary = textDiaryU.getText();
		
		DinnerTable dinnerTable = new DinnerTable(fid, day, diary, dinnerkcal);
		int confirm = JOptionPane.showConfirmDialog(
				DinnerUpdate.this, 
				"정말로 수정하시겠습니까?", 
				"업데이트 확인", 
				JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			dao.update(dinnerTable); // 리스트를 수정하고, 파일에 업데이트
			app.notifyDinnerUpdate();// ContactMain 프레임에 있는 테이블을 갱신하기 위해서 
			JOptionPane.showMessageDialog(contentPane, "수정 성공 !");
			dispose();
	}
}
}
