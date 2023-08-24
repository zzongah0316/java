package edu.java.loop05;

public class LoopMain05 {

	public static void main(String[] args) {
		// 1 ~ 10 정수들을 오름차순으로 한 줄에 출력
		for (int i=1; i<=10; i++) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		// 차이: 변수가 for문 안에 있어서 지역변수가 되지만 밑(while 반복문)에는 지역 변수 X
		
		
		// while 반복문
		int n=1;
		while (n<=10) { // 반복할 조건
			System.out.print(n+" ");
			n++;
		}
		
		System.out.println();
		
		
		// 출력 결과 : 1 3 5 7 9
		for (int a=-1; a<9;) {
			 a = (a+2);
			System.out.print(a+" ");
		}
		/* 선생님 풀이
		 *  for(int i=1; i<10; i+=2) { 
		 *  System.out.print(i+" ");
		 *  }
		 */
		
		System.out.println();
		
		int x=1;
		while (x<=10) { 
			System.out.print(x+" ");
			x+=2;
		}
		/* 선생님 풀이
		 *  n = 1; (이미 위에 변수 n 선언함 그래서 선언 안해도 됨.) 
		 *  while (n<10){
		 *  System.out.print(n+" ");
		 *  n+=2;
		 */
		
		System.out.println();
		
		n=1;
		while (n<10) {
			if(n%2==1) {
				System.out.print(n+" ");
				// (1) n++;
			}
			n++;
		}
	}

}
