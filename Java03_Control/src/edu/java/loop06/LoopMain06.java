package edu.java.loop06;

public class LoopMain06 {

	public static void main(String[] args) {
		// do-while 반복문(중괄호 끝에 ; 붙여줘야함.)
		int n=1;
		do { 
			// int n+1; -> 지역 변수라서 중괄호 나가서 while문에 작용X. 
			// n=1; -> 무한 반복.
			// n++; -> 2 ~ 11까지 출력된다.
			System.out.print(n+" ");
			n++;
		} while (n<=10);
		// do-while문은 반복 여부를 검사하기 전에 무조건 블록을 한 번 실행함!
		
		System.out.println();
		
		// for문과 while문은 반복 여부를 먼저 검사하고, 조건이 참이면 블록을 실행함.
		n=1;
		while (n>5) {
			System.out.print(n + " ");
			n++;
		}
		System.out.println();
		
		// do-while문은 반복 여부를 검사하기 전에 무조건 블록을 한 번 실행함!
		n=1; 
		do {
			System.out.print(n+" ");
			n++;
		} while (n>5);
		System.out.println();

	}

}
