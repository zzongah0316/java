package edu.java.homework01;

public class Homework02 {

	public static void main(String[] args) {
		  // 369 게임 출력
        /* 실행 결과
            1   2   *   4   5   *   7   8   *   10  
            11  12  *   14  15  *   17  18  *   20  
            21  22  *   24  25  *   27  28  *   *   
            *   *   *   *   *   *   *   *   *   40  
            41  42  *   44  45  *   47  48  *   50  
            51  52  *   54  55  *   57  58  *   *   
            *   *   *   *   *   *   *   *   *   70  
            71  72  *   74  75  *   77  78  *   80  
            81  82  *   84  85  *   87  88  *   *   
            *   *   *   *   *   *   *   *   *   100
         */
        for(int n=1; n<101; n++) {
        	// 나머지가 3,6,9인 수를 거름.  
        	// 일정범위안에 숫자들을 표시한다.
        	if(((30<n && n<40) && (n%3==0)) || ((60<n && n<70) && (n%3==0)) || ((90<n && n<100) && (n%3==0)))  {
        		System.out.print("**"+"\t"); 
        	} else if (n%10==3 || n%10==6 || n%10==9 || (29<n && n<40) || (59<n && n<70) || (89<n && n<100)) {
        		System.out.print("*" + "\t");	
        	} else {
        		System.out.print(n+"\t");
        	} if(n%10==0){
        	  	System.out.println();
        	}
        }
       
        System.out.println("--------------------------------------------------------------------------");
        
        
        // 선생님 풀이
        // (1)
         for (int a=1; a<=100; a++){
             int a1=a%10; // a을 10으로 나눈 나머지 -> 1의 자릿수
             int a10=a/10; // a을 10으로 나눈 몫 -> 10의 자릿수
             
             // 1의 자릿수가 3 또는 6 또는 9인 경우
             boolean condition1 = (a1==3) || (a1==6) || (a1==9); 
             // => a1%3==0; ex)10%10=0 0%3==0 이므로 10의 배수 모두 *이 되므로 오류.
             
             // 10의 자릿수가 3 또는 6 또는 9인 경우
             boolean condition2 = (a10==3) || (a10==6) || (a10==9); 
             
             
             // 숫자를 출력할 것인지, "*"를 출력할 것인 지.
            if (condition1 && condition2) {
            	 System.out.print("**\t");
             } else if (condition1 || condition2) {
            	 System.out.print("*\t");
             } else {
        	 System.out.print(a+"\t");
           
        	 // 줄 바꿈을 할 것인 지, 아닌 지
             } if (a%10==0) { // 10의 배수이면(숫자 또는 *를 한 줄에 10개를 출력했으면)
        	 System.out.println(); // 줄 바꿈
         }
         }
       
	}

}
