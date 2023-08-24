package edu.java.contact.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.model.Contact;
import edu.java.contact.controller.ContactDaoImpl;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {

	private final ContactDaoImpl dao = ContactDaoImpl.getInstance();
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
	private ContactMain app; // notifyContactCreated 메서드를 가지고 있는 객체.
	

	/**
	 * Launch the application.
	 */
	public static void showContactCreateFrame(Component parent, ContactMain app) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactCreateFrame frame = new ContactCreateFrame(parent, app);
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
	public ContactCreateFrame(Component parent, ContactMain app) {
		this.parent = parent; // 순서 중요 좌표 먼저하고
		this.app = app;
		initialize(); // GUI 컴포넌트들을 생성하고 초기화.
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
		
		btnCreate = new JButton("저장");
		btnCreate.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewContact();
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

	private void createNewContact() {
		// JTextField에서 이름/전화번호/이메일을 읽음.
		String name = textName.getText();
		String phone = textPhone.getText();
		String email = textEmail.getText();
		
		// contact 타입 객체 생성.
		Contact contact = new Contact(0, name, phone, email);
		
		// 리스트에 추가. 파일 업데이트 -> DAO
		dao.create(contact);
		
		// ContanctMain에게 새 연락처가 저장됐다고 알려줌.
		app.notifyContactCreated();
		
		// 현재 창 닫기
		dispose();
		
	}
}
