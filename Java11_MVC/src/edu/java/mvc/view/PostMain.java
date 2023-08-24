package edu.java.mvc.view;

import java.util.Scanner;

import edu.java.mvc.controller.PostDaoImpl;
import edu.java.mvc.menu.Menu;


public class PostMain {
	
	private final Scanner scanner = new Scanner(System.in);
	private final PostDaoImpl dao = PostDaoImpl.getInstance();	

	public static void main(String[] args) {
		System.out.println("블로그 작성 플로그램");
		
		PostMain app = new PostMain();
		
		boolean run = true;
		while (run) {
			int n = app.showMainMenu();
			Menu menu = Menu.getValue(n);
			switch (menu) {
			case QUIT:
				run = false;
				break;
			case TITLE:
				break;
			case CONTENT:
				break;
			case AUTHOR:
				break;
			case CREATEDTIME:
				break;
			case MODIFIEDTIME:
				break;
			default:
					System.out.println("메인 메뉴 번호 확인해보세요");
			}
			
		}
		
		System.out.println("프로그램 종료");

	}

	private int showMainMenu() {
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("[0]종료 [1]제목 [2]내용 [3]작성자 [4]작성 날짜 [5]수정 날짜");
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("선택 -> ");
		int n = inputNumber();
		return n;
	}

	private int inputNumber() {
		while (true) {
			try {
				int n = Integer.parseInt(scanner.nextLine());
				return n;
			} catch (NumberFormatException e) {
				System.out.println("정수 입력>> ");
			}
		}
	}

}
