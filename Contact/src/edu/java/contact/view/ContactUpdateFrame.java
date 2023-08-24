package edu.java.contact.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact.controller.ContactDaoImpl;

public class ContactUpdateFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel buttonPanel;
	private JLabel lblName;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JLabel lblEmail;
	private JButton btnCreate;
	private JLabel lblPhone;
	
	private Component parent; // 부모 컴포넌트(JFrame)을 저장하기 위한 필드.
	private int cid; // 업데이트할 연락처의 인덱스를 저장하기 위한 필드.
	private ContactMain app; // 업데이트 성공한 후 알림 메서드를 호출하기 위한 객체.
	
	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
	

	/**
	 * Launch the application.
	 */
	public static void showContactUpdateFrame(Component parent, int cid, ContactMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUpdateFrame frame = new ContactUpdateFrame(parent, cid, app);
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
	public ContactUpdateFrame(Component parent, int cid, ContactMain app) {
		this.parent = parent; // 순서 중요 좌표 먼저하고
		this.cid = cid;
		this.app = app;
		initialize(); // GUI 컴포넌트들을 생성하고 초기화.
		readContact();
	}
	
	private void readContact() {
		Contact contact = dao.read(cid);
		textName.setText(contact.getName());
		textPhone.setText(contact.getPhone());
		textEmail.setText(contact.getEmail());
	}
	
	public void initialize() {
		setTitle("새 연락처 저장");
		
		// 닫기(x) 버튼의 기본 동작을 현재 창만 닫기(dispose)로 설정.
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// JFrame이 화면에 보이는 좌표
		int x = 100;
		int y = 100;
		if(parent !=null) {
			x = parent.getX();
			y = parent.getY();
		}
		
		setBounds(x, y, 414, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.BOLD, 25));
		lblName.setBounds(12, 25, 74, 43);
		panel.add(lblName);
		
		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.BOLD, 18));
		textName.setBounds(151, 27, 220, 43);
		panel.add(textName);
		textName.setColumns(10);
		
		lblPhone = new JLabel("전화번호");
		lblPhone.setFont(new Font("굴림", Font.BOLD, 25));
		lblPhone.setBounds(10, 88, 112, 43);
		panel.add(lblPhone);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("굴림", Font.BOLD, 18));
		textPhone.setColumns(10);
		textPhone.setBounds(151, 90, 220, 43);
		panel.add(textPhone);
		
		lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("굴림", Font.BOLD, 25));
		lblEmail.setBounds(10, 154, 98, 43);
		panel.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("굴림", Font.BOLD, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(151, 154, 220, 43);
		panel.add(textEmail);
		
		buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		btnCreate = new JButton("수정완료");
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateContact();	
			}
		});
		btnCreate.setFont(new Font("굴림", Font.BOLD, 25));
		buttonPanel.add(btnCreate);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 현재 창 닫기
			}
		});
		btnCancel.setFont(new Font("굴림", Font.BOLD, 25));
		buttonPanel.add(btnCancel);
	}

	private void updateContact() {
		// JTcxtField에서 업데이트 정보들을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		Contact contact = new Contact(cid, name, phone, email);
		
		int confirm = JOptionPane.showConfirmDialog(
				ContactUpdateFrame.this, 
				"정말로 업데이트할까요?", 
				"업데이트 확인", 
				JOptionPane.YES_NO_OPTION);
		if(confirm == JOptionPane.YES_OPTION) {
			dao.update(contact); // 리스트를 수정하고, 파일에 업데이트
			app.notifyContactUpdate();// ContactMain 프레임에 있는 테이블을 갱신하기 위해서 
			dispose(); // 현재 창 닫기
		}
		
		
	}


		
	}

