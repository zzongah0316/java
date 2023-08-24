package edu.java.loop08;

public class LoopMain08 {

	public static void main(String[] args) {
		
		// 구구단 2단은 2x2까지, 3단은 3x3까지, 4단은 4x4까지, ..., 9단은 9x9까지 출력.
		for(int dan=2; dan<10; dan++) {
			 System.out.println("--- "+ dan + "단 ---");
			for (int n=1; n<6; n++) {
				System.out.printf("%d x %d = %d\n", dan, n, dan*n);
				if(dan==n) { 
					break;
					} // end if
				
			} // end for(y)
		} // end for(x)
		
		System.out.println("\n===========\n");
        
		int dan=2;
		while (dan<10) {
			System.out.println("--- "+ dan + "단 ---");
			int n=1;
			while (n<10) {
				System.out.printf("%d x %d = %d\n", dan, n, dan * n);
				if(dan==n) { 
					break;
	                }
				n++;
			} dan++;
		
		}
	
		System.out.println("\n===========\n");
		
		for(int x=2; x<10; x++) {
			 System.out.println("--- "+ x + "단 ---");
			for (int y=1; y<(x+1); y++) {
				System.out.printf("%d x %d = %d\n", x, y, x * y);
			}
		
		}
		
		System.out.println("\n===========\n");
		
		int x=2;
		while (x<10) {
			System.out.println("--- "+ x + "단 ---");
			int y=1;
			while (y<(x+1)) {
				System.out.printf("%d x %d = %d\n", x, y, x * y);
               y++;
			} x++;
		
		}
		
		
		
		// 선생님이 푼 것
		// 내가 for문에서 break사용한 방법 똑같음.
		// for문에서 break없이 사용한 방법에서 y<(x+1) 대신 y<=x로 사용하심.
		
	
				
	}

}
