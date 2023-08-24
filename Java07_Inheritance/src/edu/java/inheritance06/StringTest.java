package edu.java.inheritance06;

public class StringTest {

	public static void main(String[] args) {
		// 상수(constant): final로 선언된 변수 
		// 리터럴(literal): 만들어진 값.
		 final int x = 1; // x -> 상수, 1 -> 리터럴
		 
		 String s1 = "hello"; // s1 -> 상수X / 변수,  "hello" -> 리터럴
		 String s2 = "hello";
		 System.out.println(s1==s2);
		 // true -> JVM은 같은 문자열 리터럴은 두 번 생성하지 않음.
		 // s1, s2 같은 주소 값
		
		 String s3 = new String("hello");
		 String s4 = new String("hello");
		 System.out.println(s3==s4);
		 // false -> 생성자는 호출할 때마다 새로운 객체를 힙(heap) 메모리에 생성.
		 // new로 새로 생성했기 때문에 s3, s4 다른 주소 값

	}

}
