package edu.java.method02;

import java.util.Random;

public class MethodMain02 {
    
	public static void main(String[] args) {
		// argument를 가지고, 리턴 값이 있는 메서드 작성/호출 연습.
		 
		// 같은 클래스 안에서 작성한 메서드인 경우에는 메서드 이름으로만 호출하면 됨.
		double result = add(1, 2); // 메서드 호출. argument -> 1, 2
		System.out.println(result);
		
		double sub = subtract(5, 3);  // double sub 대신 그냥 result 써도 된다. (같은 타입의 result 변수 선언했기 때문에)
		System.out.println(sub);
		
		double multi = multiply(7, 9); // double multi 대신 그냥 result 써도 된다.(같은 타입의 result 변수 선언했기 때문에)
		System.out.println(multi);
		
		double divi = divide(9, 3); // double divi 대신 그냥 result 써도 된다.(같은 타입의 result 변수 선언했기 때문에)
		System.out.println(divi);
		
		boolean is = isEven(2); 
		System.out.println(is);
		
		
	    int[] make = makeArray(5);
	    for(int z : make) {
	    System.out.print(z+" ");
	    }
	}
    /**
     * 실수 2개를 전달받아서, 덧셈 결과를 리턴하는 메서드.
     * @param x 실수(double) 타입.
     * @param y 실수(double) 타입.
     * @return x+y.
     */
	public static double add(double x, double y) { // x, y 타입 각각 다 써야함, 파라미트 값(double x, double y)은 초기화가 되어있다고 생각하면 된다.
	// double x; -> 이름이 같아서 못사용함 (이 중괄호 안에서는)
    // 메서드 정의(선언)
	// 메서드 수식서 - public static
	// 메서드 리턴 타입 - double
	// 메서드 이름 - add
	// 파라미터(parameter) - double x, double y	
		return x+y; //->리턴 문장, x+y->리턴 값.
	} 
	
	 /**
     * subtract
     * 숫자 2개를 전달받아서, 뺄셈의 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x - y.
     */
     public static double subtract(double x, double y) {
    	 return x-y;
     }
    
    /**
     * multiply
     * 숫자 2개 전달받아서 곱셈 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x * y.
     */
     public static double multiply(double x, double y) {
    	 return x *y;
     }
    
    /**
     * divide
     * 숫자 2개를 전달받아서, 나눗셈 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x / y.
     */
     public static double divide (double x, double y) {
    	 return x/y;
     }
    
    /**
     * isEven
     * 정수가 짝수인 지 아닌 지를 리턴하는 메서드.
     * @param n 짝수인 지 홀수인 지 검사할 정수.
     * @return n이 짝수이면 true, 그렇지 않으면 false.
     */
     public static boolean isEven (int n) {
//  (1) boolean result = false; //짝수인 지, 홀수인 지를 저장할 변수.
//    	if(n%2==0) {
//    		return true;
//    	} else {
//    		result = false;
//    	}
//    	return result;

//   (2) if(n%2==0) {
//    		 return true;
//    	 } else {
//    		 return false;
//    	 } 
 
    	 boolean result = (n%2==0) ? true : false;
    	 return result;
    	
//  (4) return n%2==0; 

     }
    	// return 의미: 메서드가 끝났다, 호출한다.
     
    /**
     * makeArray
     * argument로 전달된 배열의 길이 크기의 정수 배열을 생성하고,
     * 임의의 난수들로 배열을 초기화해서 리턴하는 함수.
     * @param length 배열의 길이. 양의 정수.
     * @return length개의 난수들로 초기화된 정수 배열.
     */
     public static int[] makeArray(int length) {
       	Random random = new Random();
       	int[] a  = new int[length];
    	for (int x=0; x<a.length; x++) { // a.length 대신 length만 써도 된다. 같은 의미니까
    		a[x] = random.nextInt(10); // 10이 길이를 말하는게 아니라 배열의 원소 하나하나의 범위
     	} return a;
    }

	
}
	

