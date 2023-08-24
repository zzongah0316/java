package edu.java.method03;

import java.util.Random;

public class MethodMain03 {
	
	public static int[] makeTestArray (int n) {
		int[] arr = new int[n];
		
		Random random = new Random();
		for(int i =0; i<n; i++) {
			arr[i] = random.nextInt(10);
		}
		return arr;
	}
	
	public static void printTestArray(int[] arr) {
		System.out.print("[ ");
		for(int x : arr) {
			System.out.print(x+" ");
		}
		System.out.print("]");
		System.out.println();
		// void 타입의 메서드에서는 return; 문을 생략해도 됨.
		return;
	}
	

	public static void main(String[] args) {
	   // 메서드 기능 테스트를 위한 배열 만들기
		int[] arr = makeTestArray(5);
		
	   // 테스트 데이터 출력하기
		
		printTestArray(arr);
		
		int result = sum(arr);
		System.out.println("sum = "+ result);
		
		double re = mean(arr);
		System.out.println("average = "+ re);
		
		result = max(arr);
		System.out.println("max = "+ result);
		
		result = maxAt(arr);
		System.out.println("maxAt = arr["+result+"]");
		
		result = min(arr);
		System.out.println("min = "+ result);
		
		result = minAt(arr);
		System.out.println("minAt = arr["+result+"]");
	}
	
	/**
     * sum
     * 정수 배열의 모든 원소들의 합을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 합.
     */
	 public static int sum (int[] arr) {
		 int s =0;
		 for(int array : arr) {
				s+=array;
		 } return s;
		  }
		
	
	 /**
     * mean
     * 정수 배열의 모든 원소들의 평균을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 평균.(소수점까지 계산=double)
     */
//	 public static double mean (int[] arr) {
//		 int x=0;
//		 int y=0;
//		 for(int array : arr) {
//			 x+=array;
//			 y++;
//		 } double average = (double) x / y;
//		 return average;
//	 }
	 public static double mean (int[] arr) {
		// 평균 = 합계 /개수;
		 return (double) sum(arr)/ arr.length;
	 }
	 
	 /**
	 * max
	 * 정수 배열에서 최댓값을 찾아서 리턴.
	 * @param arr 정수 배열.
	 * @return 배열 arr의 원소들 중 최댓값.
	 */
	 public static int max (int[] arr) {
		 int max = arr[0];
		 for(int array : arr) {
//			 if(max<array) {
//				 max=array;
//			 } 
			 max = (max<array) ? array : max ;
		 } return max;
	 }
	
	 /**
	 * maxAt
     * 정수 배열에서 최댓값의 인덱스 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최댓값의 인덱스.
     * 최댓값이 여러개 있는 경우, 첫번째 최댓값의 인덱스.
     */
	 public static int maxAt (int[] arr) {
		 int max = arr[0]; // 배열의 최댓값을 저장할 변수.
		 int a = 0; // 배열의 최댓값의 인덱스를 저장할 변수.
         for(int i=0; i<arr.length; i++) { // i 0말고 1부터 시작해도 됨. 0해서 한번더 돌려도 됨. 배열의 원소들을 순서대로 반복하면서
			 if(max<arr[i]) {  // 배열에서 읽은 값이 max보다 크다면
				 max=arr[i]; // max값을 배열에서 읽은 값으로 변경
				 a=i; // 최댓값의 인덱스를 현재 인덱스 i로 변경.
			 }
		 } return a;
	 }
	 // int index =0;
	 // for (int i=1; i<arr.length; i++) {
	 //     if(arr[index]<arr[i])
	 //        index=i;
     //     }
	 //   }   
	 //  return index;
	 // }
	 
	 
	 /**
	 * min
	 * 정수 배열에서 최솟값을 찾아서 리턴.
	 * @param arr 정수 배열.
	 * @return 배열 arr의 원소들 중 최솟값.
	 */
	 public static int min (int[] arr) {
		 int min = arr[0];
		 for(int array : arr) {
			 if (min>array) {
				 min=array;
			 }
		 } return min;
	 }  
	 
	 /**
	 * minAt
	 * 정수 배열에서 최솟값의 인덱스 리턴.
	 * @param arr 정수 배열.
	 * @return 배열 arr의 원소들 중 최솟값의 인덱스.
	 * 최솟값이 여러개 있는 경우, 첫번째 최솟값의 인덱스.
	 */
	 public static int minAt (int[] arr) {
//		 int min = arr[0];
//		 int b = 0;
//		 for(int i=0; i<arr.length; i++) {
//			 if(min>arr[i]) {
//				 min=arr[i];
//				 b=i;
//			 }
//		 }	 return b;
//	 }
	 // 최솟값을 찾음.
	 // 배열의 원소들을 순서대로 반복하면서, 그 원소가 최솟값인 지 검사.
	 // 최솟값을 찾았으면 반복을 종료.
		 int result = min(arr);
		 int index = 0 ; //배열의 인덱스
		 //배열의 원소들을 순서대로 반복하면서, 그 원소가 최솟값인 지 검사.
		 for(index=0; index<arr.length; index++ ) {  
			 if(arr[index]==result) {
				 break; // 최솟값을 찾았으면 반복을 종료.
			 }
			}
		
	      return index;
	 }
}
