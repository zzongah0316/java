package edu.java.class06;


public class ClassMain06 {

	public static void main(String[] args) {
		Circle circle = new Circle(); // 기본 생성자 호출
		System.out.println(circle);
		System.out.println("반지름: " + circle.radius);
		System.out.println("둘레: " + circle.perimeter());
		System.out.println("넓이: " + circle.area());
		
		System.out.println("---------------------------------");
		
		Circle circle1 = new Circle (1.0); // argument를 갖는 생성자 호출
		circle1.printInfo();
		System.out.println("둘레: " + circle1.perimeter());
		System.out.println("넓이: " + circle1.area());
		
		System.out.println("---------------------------------");
		
		Circle circle2 = new Circle (4.3);
		System.out.println(circle2);
		System.out.println("원의 둘레: " + circle2.perimeter());
		
		System.out.println("---------------------------------");
		
		Circle circle3 = new Circle (5.2);
		System.out.println("원의 넓이: " + circle3.area());
		

	}

}
