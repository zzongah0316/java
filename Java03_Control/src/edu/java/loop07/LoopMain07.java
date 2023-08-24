package edu.java.loop07;

public class LoopMain07 {

	public static void main(String[] args) {
		// 2중 반복문 
		for (int dan=2; dan<10; dan++) { 
		     System.out.println("--- "+ dan + "단 ---");
		 for(int n=1; n<10; n++) {
      // System.out.println(dan + " x " + n + " = " + (dan * n));
			 System.out.printf("%d x %d = %d\n", dan, n, dan * n);
		 } // 변수 n 은 사라짐.
		} // 변수 dan 은 사라짐.
		
		System.out.println("\n===========\n");
		
		// while문을 사용한 구구단 출력.
		// (1) 내가 푼 것.
		int dan=2; 
		while (dan<10) {
			System.out.println("--- " + dan + "단 --- ");
			dan++;
			
		int n=1;
		while (n<10) {
			System.out.println((dan-1)+ " x "+ n + " = " + ((dan-1)*n));
			n++;
			}
		}
		
	   System.out.println("\n===========\n");
	
	// (2) 선생님이 푼 것.
	    int x=2;
	    while (x<10) {
		    System.out.println("--- "+ x + "단 ---");
		// 구구단 출력
		int y=1;
		while (y<10) {
			System.out.printf("%d x %d = %d\n", x, y, x*y);
			y++;
		}
		x++;
}
	    
	    // (3) 선생님이 푼 것.
	    int i=2;
	    int q=1;
	    while(i<10) {
	    	System.out.println("--- "+ i + "단 ---");
	    // 구구단 출력
	     q=1;
	    while(q<10) {
	    	System.out.printf("%d x %d = %d\n", i, q, i*q);
			q++;
	    } 
	      i++;
}
	    }
	}

