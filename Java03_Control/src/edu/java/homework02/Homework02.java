package edu.java.homework02;

import java.util.Random;

public class Homework02 {

	public static void main(String[] args) {
		/*
		 * 문제 1. 아래와 같이 출력하세요.
		 *
		 **
		 ***
		 ****
		 *****
		 */
	
//		같이 알려주신 풀이
//		for (int x = 1; x < 7; x++) { // 줄 갯수
//			for (int y = 1; y < x; y++) { // 별의 갯수
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//		System.out.println("-----");
		
		/* 선생님 풀이
		 * (1) for문 방법
		 * for (int x=1; x<=5; x++) {
		 *     for (int y=1; y<=x; y++) {
		 *         System.out.print('*');
		 *   }
		 *     System.out.println();
		 *  }
		 *     
		 * (2) while문 방법
		 * int line=1; 
		 * while(line<=5) {
		 *     int count=1; 
		 *     while(count <= line) {   
		 *         System.out.print('*'); 
		 *         count++;
		 *      }
		 *      System.out.println();
		 *      line++;
		 *   }      
		 */
		
		
		for(int x=1; x<6; x++) {
			System.out.println();
			for(int y=1; y<6; y++) {
				System.out.print("*");
				if(x==y) {
					break;
			} 
			}
		}
		System.out.println();
		System.out.println("-----");
		
		// ctrl+shift+F: 코드 포맷팅(자동 정렬)

		
		
		
		/*
		 * 문제 2. 아래와 같이 출력하세요.
		 *
		 **
		 ***
		 ****
		 *****
		 ****
		 ***
		 **
		 *
		 */
		
		/* 선생님 풀이
		 * (1) for문 방법
		 * for (int x=1; x<=5; x++) {
		 *     for (int y=1; y<=x; y++) {
		 *         System.out.print('*');
		 *   }
		 *     System.out.println();
		 * }
		 * for(int x=4; x>=1; x--) {
		 *    for(int y=1; y<=x; y++) {
		 *       System.out.print('*');
		 *    }
		 *    System.out.println();
		 * }  
		 * 
		 * (2) for문 방법 2
		 * for (int x=1; x<=5; x++) {
		 *     for (int y=1; y<=x; y++) {
		 *         System.out.print('*');
		 *   }
		 *     System.out.println();
		 * }
		 * for(int x=1; x<=4; x++) {
		 *    for(int y=4; y>=x; y--) {
		 *       System.out.print('*');
		 *    }
		 *    System.out.println();
		 * }
		 * 
		 * (3) for문 방법 3
		 * for (int x=1; x<=9; x++) {
		 *     if (x<=5) {
		 *     for (int y=1; y<=x; y++) {
		 *         System.out.print('*');
		 *   }
		 *     
		 * } else {
		 *      for (int y=4; y>=(x-5); x--) {
		 *          System.out.print('*');
		 *    }
		 *     
		 *  }
		 * 	   System.out.println();
		 * }
		 */
		
          for(int x=1; x<7; x++) {
			System.out.println();
			for(int y=1; y<7; y++) {
				System.out.print("*");
				if(x==y) {
					break;
			} 
			}if(x==6) {
				for(int a=4; a>0; a--) {
					System.out.println();
					for(int b=1; b<5; b++) {
						System.out.print("*");
						if(a==b) {
							break;
						}
					}
				}
			}
			}
		
        System.out.println();
		System.out.println("-----");
		
//		for (int x = 1; x < 7; x++) { // 줄 갯수
//			for (int y = 1; y < x; y++) { // 별의 갯수
//				System.out.print("* ");
//			}
//			System.out.println();
//		}
//		for (int x=5; x>0; x--) { // 별의 갯수
//			for (int y=1; y<x; y++) { // 줄 갯수
//				System.out.print("* ");
//
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//		System.out.println("-----");
		
		
		
		
		
		/*
		 * 문제 3. 주사위 2개를 던졌을 때 나오는 주사위 눈을 (x, y) 형식으로 출력하세요. 두 눈의 합이 5가 되면 출력을 멈추세요.
		 * (1)힌트: Random 타입의 nextInt(start, end) 메서드를 사용. 
		 * (2)힌트: 무한 루프-> for( ; ; ) {...}, while (true) {...} 
		 * 출력 결과 예시: (2, 4) (6, 1) (3, 3) (4, 1)
		 */
		
		/* 선생님 풀이
		 * (1)
		 * Random rand = new Random();
		 * for(;;) {  or  while(true) {    -> 무한 반복문.
		 *     int dice1 = rand.nextInt(6) + 1;
		 *     int dice2 = rand.nextInt(1, 7);
		 *     System.out.printf("(%d, %d)\n", dice1, dice2);
		 *     if (dice1 + dice2 ==5) { 주사위 두 눈의 합이 5가 되면
		 *         break;
		 *      }
		 *   }  
		 */
		
		
		
		Random random = new Random();
	    for ( ; ;) {
	    	int r = random.nextInt(1,7);
			int a = random.nextInt(1,7);
	    	System.out.print("(" +r+ "," +a+ ")");
			if((r+a)==5) {
				break;
			}
	    }

	}

}
