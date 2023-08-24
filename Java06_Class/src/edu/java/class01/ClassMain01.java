package edu.java.class01;

// 객체 지향 프로그래밍(Object-Oriented Programming) 언어: Java(절차 지향 프로그래밍도 가능), C++, C#, ...
// 절차 지향 프로그래밍(Procedural Programming): C(class 개념 없어서 객체 지향 프로그래밍 불가능), ...
// 객체(object): 대상. 프로그램에서 사용하려는 대상.(ex)붕어빵, 문자열)
// 인스턴스(instance): 실제로 만들어진(생성된) 객체.(ex)진열된 붕어빵 하나하나, 안녕하세요...)
// 클래스(class): object를 설계한 코드.(ex)붕어빵 틀, String)
// -> 객체가 가질 수 있는 데이터(값)을 변수로 선언하고, 
// -> 객체가 가질 수 있는 기능들을 메서드로 정의한 코드.
// -> 데이터 타입(변수를 선언할 때 사용).

public class ClassMain01 {

	public static void main(String[] args) {
		String s1 = "hello, java";
		String s2 = new String("안녕하세요");
		
		System.out.println("s1 길이 = " + s1.length());
		System.out.println("s2 길이 = " + s2.length());
		System.out.println(s1.concat("!!!"));
		System.out.println(s2.concat("..."));
		

	}
	

}
