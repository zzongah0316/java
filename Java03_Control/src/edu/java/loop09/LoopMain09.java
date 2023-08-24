package edu.java.loop09;

import java.util.Scanner;

public class LoopMain09 {

	public static void main(String[] args) {
		boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정할 변수. 
		int balance = 0; // 은행 예금 잔고를 의미함.
		Scanner scanner = new Scanner(System.in);
		
		while(run) { // while(run=true)이므로 무한 루프
			System.out.println("----------------------------------------");
			System.out.println("   1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------------------");
			System.out.println("선택> ");
			
			int menu = scanner.nextInt();
			switch (menu) { 
			case 1: {
				System.out.println("예금 금액 입력> ");
				int a = scanner.nextInt();
				System.out.println("예금 금액: "+ a + "원");
				balance = (a+ balance);
			}
				break;
			case 2:{
				System.out.println("출금 금액 입력> ");
				int b = scanner.nextInt();
				System.out.println("출금 금액: "+ b + "원");
				balance = (balance -b);
			}
				break;
			case 3:{
				System.out.println("잔고: "+ balance + "원");
			}
				break;
			case 4: 
				run = false;
				break; // switch문을 종료
			default:
			}
			
		}
		System.out.println("프로그램 종료");
		
		
		
		/* 선생님 풀이
		 * boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정할 변수. 
		int balance = 0; // 은행 예금 잔고를 의미함.
		Scanner scanner = new Scanner(System.in);
		
		while(run) { // while(run=true)이므로 무한 루프
			System.out.println("----------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------------------");
			System.out.println("선택> ");
			
			int menu = scanner.nextInt();
			switch (menu) { 
			case 1: {
				System.out.println("예금액> ");
				int money = scanner.nextInt();
			    balance += money;
			}
				break;
			case 2:{
				System.out.println("출금 금액 입력> ");
				int money2 = scanner.nextInt();
				balance -= money2;
			}
				break;
			case 3:{
				System.out.println("잔고: "+ balance + "원");
			}
				break;
			case 4: 
				run = false; 
				break; // switch문을 종료
			default:
			     System.out.println("메뉴를 잘못 입력했습니다. 다시 선택해주세요.");
			}
			
		}
		System.out.println("프로그램 종료");
		 */

	}

}
