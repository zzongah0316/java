package edu.java.array04;

import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {
	        // 정수 5개를 저장할 수 있는 배열을 선언.
	        // 0 이상 9 이하의 정수 난수 5개를 배열에 저장.(for문 사용)
	        // 배열의 내용을 출력.
	        // 배열의 모든 원소의 합을 계산하고 출력.(sum 변수 사용하기)
	        // 배열 원소들의 평균을 double 타입으로 계산하고 출력.

		int[] numbers = new int [5];
		Random random = new Random();
        for (int i=0; i<numbers.length; i++) {
        	int r = random.nextInt(0,9);
        	numbers[i] = r;
        } 
        int sum = 0;
        for(int x : numbers) {
        	System.out.print(x+" ");
        	sum = sum+x;
        }
        System.out.println();
        System.out.println("합은 "+sum);
        double a = sum/5.0;
        System.out.println("평균은 "+a);
        //System.out.println("평균은"+(double)sum/numbers.length);
    
        
       //선생님 풀이
        // 정수 5개를 저장할 수 있는 배열을 선언.
           //int[] numbers = new int [5];
        // 0 이상 9 이하의 정수 난수 5개를 배열에 저장.(for문 사용)
           /* Random random = new Random();
            * numbers[0] = 난수;
            * numbers[1} = 새로운 난수;
            * .
            * .
            * .
            * for (int i=0; i<numbers.length; i++) {
            *   numbers[i]  = random.nextInt(0,9);
            *   }
            */ 
        // 배열의 내용을 출력.
	       /* for(int x : numbers) { 순서대로 반복한다는 뜻?
        	* System.out.print(x+" ");
        	* sum = sum+x;
            * }
            */ 
	    // 배열의 모든 원소의 합을 계산하고 출력.(sum 변수 사용하기)
	        /* int sum=0;
	         * sum = sum + numbers[0]; -(1)
	         * sum = (1) + numbers[1]; -(2)
	         * sum = (2) + numbers[2]; 
	         * (1)
	         *  for(int i=0; i,numbers.length; i++) {
	         *   sum = sum + numbers[i]; => sum += numbers[i]
	         *   System.out.println("sum = " + sum) => 중괄호 안에 넣으면 중간 과정 확인할 수 있음.
	         *   }
	         * (2)
	         *  for (int x : numbers) {
	         *     sum +=x;
	         *     }
	         *   System.out.println("sum = " + sum) 
	         */
        // 배열 원소들의 평균을 double 타입으로 계산하고 출력.
	        /* double average = (double) sum / numbers.length;
	         * System.out.println("average =" + average)
	         */
         
        
        
        // 배열의 원소들 중 최댓값을 찾고 출력.
          int max = numbers[0];   // 배열의 첫번째(인덱스 0번 위치의) 원소를 최댓값이라고 가정.
          for (int z : numbers) { // 배열 numbers의 모든 원소들을 순회하면서 
        	  if( max < z ) {     // 배열에서 읽은 값이 max보다 크다면
        		  max=z; }        // max의 값을 z로 변경.
         } System.out.println("최댓값 = " + max);
        
        // 배열의 원소들 중 최솟값을 찾고 출력.
         int min = numbers[0];
         for (int m : numbers) {
       	  if( min > m ) {
       		  min=m; }
        } System.out.println("최솟값 = " + min);
         
	    


	}

}
