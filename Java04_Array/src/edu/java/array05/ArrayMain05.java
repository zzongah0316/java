package edu.java.array05;

import java.util.Random;

public class ArrayMain05 {

	public static void main(String[] args) {
		                                                    // int count = 10; // 배열의 길이(원소 개수)
	                                                        // String male = "Male";
		                                                    // String female = "Female";
		                                                    //
		// int 10개를 저장할 수 있는 배열을 선언.           //
		int[] genderCodes = new int[10];                    // int[] genderCodes = new int[count]; 
		
		// 배열에 난수(0,1) 10개를 저장.
		Random random = new Random();
        for (int i=0; i<genderCodes.length; i++) {          // for (int i=0; i<count; i++) { 
        	int r = random.nextInt(2); // -> genderCodes[i] = random.nextInt(2);
        	genderCodes[i] = r;        // 2개의 난수를 저장
        } 
		
		// 배열의 내용을 출력.
         for(int a : genderCodes){
        	 System.out.print(a+" ");
         }
		System.out.println();
		
		// 문자열 10개를 저장할 수 있는 배열(genders)을 선언.  
		String [] genders = new String [10];                // String [] genders = new String [count];   
		
		// genderCodes의 값이 0이면 "Male", 1이면 "Female"을 문자열 배열에 저장.
		for(int i=0; i<genders.length; i++) {               // for(int i=0; i<count; i++) {
			if(genderCodes[i]==0) {
			 genders[i]="Male";
			} else {
			 genders[i]="Female";
			}
		}
		
		// 문자열 배열 genders의 내용을 출력.
		for(String z : genders) {
			System.out.print(z+" ");
		}
		System.out.println();
		
		// 문자열 배열에 저장된 "Male"의 개수, "Female"의 개수를 출력.
		int s = 0;
		for(int f : genderCodes) {
			s+=f;
		} 
		int m = (genders.length-s);
		System.out.println("Male의 개수: "+m);
		System.out.println("Female의 개수: "+s);
		
		// (힌트) 두 숫자 x, y가 같은 지 비교: x==y
	     

        // (힌트) 두 문자열 x, y가 같은 지 비교: x.equals(y) -> 문자에는 " " 붙이기.
           //    내가 풀고 있던 것.
           		int c =0;
           		for(int b=0; b<genders.length; b++) {
           			if(genders[b].equals("Male")) {
           				c+=1;
           			} 
           		} System.out.println("Male의 개수: " + c);
           				
		// 선생님이 푸신 것
        int numOfMales = 0; // "Male"의 개수를 저장할 변수.
		int numOfFemales = 0; // "Female"의 개수를 저장할 변수.
		for(String q : genders) { // 배열 genders의 원소들을 순서대로 반복하면서
			if(q.equals("Male")) { // 배열에서 읽은 값이 "Male" 과 같으면
				numOfMales++; // 남성의 숫자를 1증가
			} else if (q.equals("Female")) { // 배열에서 읽은 값이 "Female"과 같으면
				
				numOfFemales++; // 여성의 숫자를 1증가
			}	
		}
		System.out.println("# of male = " + numOfMales);
		System.out.println("# of female = " + numOfFemales);
		
		
	}

}
