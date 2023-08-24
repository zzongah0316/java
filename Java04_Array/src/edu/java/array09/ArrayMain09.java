package edu.java.array09;

import java.util.Random;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ArrayMain09 {

	public static void main(String[] args) {
		// 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언.
		int[][] array = new int[3][];
		
        // 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개 저장.
//	    array[0] = new int[2];
//	    array[1] = new int[3];
//	    array[2] = new int[4];
		Random random = new Random ();
		for(int i=0; i<array.length; i++) {
			array[i] = new int[i+2];
			for(int j=0; j<array[i].length; j++) {
		// 저장하는 난수의 범위는 0 이상 100 이하.
				array[i][j] = random.nextInt(101);
			}
		} 
	 
	    
        // 저장하는 난수의 범위는 0 이상 100 이하.
		
//		for(int i=0; i<array.length; i++) {
//			for(int j=0; j<array[i].length; j++) {
//				int r = random.nextInt(0,101); 
//				array[i][j] = r;
//			}
//			
//		}
		
        // 2차원 배열의 원소들을 출력.
		for(int[] member: array) {
			for(int x : member) {
				System.out.print(x+" ");
			} 
			System.out.println();
		}
		

//		for(int i=0; i<array.length; i++) {
//			for(int j=0; j<array[i].length; j++) {
//				int r = random.nextInt(0,101);
//				array[i][j] = r;
//				System.out.print(r+" ");
//			} System.out.println();
//		}
		
		
        // 2차원 배열의 모든 원소들의 합을 계산하고 출력.
		int sum = 0; // 배열의 원소들의 합을 저장하기 위한 변수.
		int count = 0; // 배열의 원소들의 개수를 저장하기 위한 변수.
		for(int[] member : array) {
				for(int q : member) {
					sum+=q; // 배열에서 읽은 값은 합계에 더함.
					count++; // 배열의 원소의 개수는 1 증가.
			}    
		} 
		System.out.println("sum = "+sum);
		System.out.println("count = "+ count);
		
		
        
		// 2차원 배열의 모든 원소들의 평균을 계산하고 출력.
//		int divisor=0;
//		for(int i=0; i<array.length; i++) {
//			divisor+=array[i].length;
//		}
//		System.out.println("divisor = "+divisor);
//		System.out.println("average = "+((double)sum/divisor));
		double average = (double) sum / count;
		System.out.println("average = "+ average);
		
        // 최댓값을 찾고 출력.
		int max = array [0][0]; // 최댓값을 배열이 인덱스 [0,0] 위치의 원소라고 가정.
		for(int[] member : array) {
			for(int z : member) {
//				if(max<z) {
//					max=z;
//				}
				max = (z>max) ? z : max;
			}
		}
		System.out.print("max = " + max);
		
		System.out.println();
		
        // 최솟값을 찾고 출력.
		int min = array [0][0];
		for(int[] member : array) { // 2차원 배열의 원소인 1차원 배열들에 대해서
			for(int z : member) { // 그 1차원 배열의 각 원소(정수)들에 대해서
				if(min>z) {
					min=z;
				}
			}
		}
		System.out.print("min = " + min);
	}

}
