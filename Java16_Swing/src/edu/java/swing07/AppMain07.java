package edu.java.swing07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {
	// JTable에서 사용할 컬럼 이름들
	private static final String[] COLUNM_NAMES = {"국어", "영어", "수학", "총점", "평균"};
	
	private DefaultTableModel model; // 테이블의 행, 열에 대한 정보를 갖는 객체
	private JFrame frame;
	private JLabel lblIKorean;
	private JTextField textKorean;
	private JTextField textEnglish;
	private JTextField textMath;
	private JLabel lblEnglish;
	private JLabel lblMath;
	private JButton btnInsert;
	private JButton btnDelete;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppMain07 window = new AppMain07();
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
	public AppMain07() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("굴림", Font.BOLD, 20));
		frame.setBounds(100, 100, 450, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblIKorean = new JLabel("국어");
		lblIKorean.setHorizontalAlignment(SwingConstants.CENTER);
		lblIKorean.setFont(new Font("굴림", Font.BOLD, 25));
		lblIKorean.setBounds(12, 10, 73, 53);
		frame.getContentPane().add(lblIKorean);
		
		textKorean = new JTextField();
		textKorean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textKorean.setBounds(97, 10, 325, 53);
		frame.getContentPane().add(textKorean);
		textKorean.setColumns(10);
		
		lblEnglish = new JLabel("영어");
		lblEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnglish.setFont(new Font("굴림", Font.BOLD, 25));
		lblEnglish.setBounds(12, 73, 73, 53);
		frame.getContentPane().add(lblEnglish);
		
		textEnglish = new JTextField();
		textEnglish.setColumns(10);
		textEnglish.setBounds(97, 73, 325, 53);
		frame.getContentPane().add(textEnglish);
		
		lblMath = new JLabel("수학");
		lblMath.setHorizontalAlignment(SwingConstants.CENTER);
		lblMath.setFont(new Font("굴림", Font.BOLD, 25));
		lblMath.setBounds(12, 136, 73, 53);
		frame.getContentPane().add(lblMath);
		
		textMath = new JTextField();
		textMath.setColumns(10);
		textMath.setBounds(97, 136, 325, 53);
		frame.getContentPane().add(textMath);
		
		btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertScoreToTable();
			}
		});
		btnInsert.setFont(new Font("굴림", Font.BOLD, 25));
		btnInsert.setBounds(27, 215, 107, 62);
		frame.getContentPane().add(btnInsert);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteRowFromTable();
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 25));
		btnDelete.setBounds(293, 215, 107, 62);
		frame.getContentPane().add(btnDelete);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 287, 410, 266);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		Object[][] data = {}; // 테이블에 사용할 데이터
		model = new DefaultTableModel(data, COLUNM_NAMES);
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

	private void deleteRowFromTable() {
		
			// 1. 테이블에서 삭제하기 위해 선택된 행의 인덱스를 찾음.
			int index = table.getSelectedRow();
			if(index == -1) { // 테이블에서 아무 행도 선택되지 않은 경우.
				JOptionPane.showMessageDialog(frame, "삭제할 행을 선택하세요", "경고", JOptionPane.WARNING_MESSAGE);
				// TODO
				return; // 메서드 종료
			}
			// 2. 해당 인덱스의 행을 테이블 모델에서 삭제 
			// TODO
			int confirm = JOptionPane.showConfirmDialog(
					frame, 
					index + " 인덱스 행을 정말 삭제하시겠습니까?", 
					"삭제 확인", 
					JOptionPane.YES_NO_OPTION);
			if(confirm == JOptionPane.YES_OPTION) {
				model.removeRow(index); //삭제
			}
			
			
		
			
			
			
	 }
	

	private void insertScoreToTable() {
		try {
			// 1. JTextFiled에서 3과목의 점수를 읽음.
			int korean = Integer.parseInt(textKorean.getText());
			int english = Integer.parseInt(textEnglish.getText());
			int math = Integer.parseInt(textMath.getText());
			// 2. Score 타입 객체 생성
			Score score = new Score(korean, english, math);
			// 내가 품
//			Score score = new Score();
//			score.setKorean(Integer.parseInt(textKorean.getText()));
//			score.setEnglish(Integer.parseInt(textEnglish.getText()));
//			score.setMath(Integer.parseInt(textMath.getText())); 
			Object[]row = {score.getKorean(), score.getEnglish(), score.getMath(), score.getTotal(), score.getMean()}; //입력
			if(score.getKorean()>100 || score.getEnglish()>100 || score.getMath()>100 || 
					score.getKorean()<0 || score.getEnglish()<0 || score.getMath()<0) {
				JOptionPane.showMessageDialog(frame, "점수를 다시 입력하세요", "입력 ERROR", 
						JOptionPane.ERROR_MESSAGE);
				// 모든 JTextField의 입력 내용을 지움
				clearAllTextFields();
			} else {
				model.addRow(row); //입력
				// 모든 JTextField의 입력 내용을 지움
				clearAllTextFields();
			}
					
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "점수를 다시 입력하세요", "입력 ERROR", JOptionPane.ERROR_MESSAGE);
			// 모든 JTextField의 입력 내용을 지움
			clearAllTextFields();
			return; // 메서드 종료
			
			
			
		}
		
		
		}
		private void clearAllTextFields() {
			textKorean.setText("");
			textEnglish.setText("");
			textMath.setText("");
	}
}
