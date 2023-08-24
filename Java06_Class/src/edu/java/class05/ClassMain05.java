package edu.java.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		// 기본 생성자를 이용한 Rectangle 객체 생성
		Rectangle rectangle1 = new Rectangle ();
		System.out.println(rectangle1);
		System.out.println("가로 길이: " + rectangle1.width);
		System.out.println("세로 길이: " + rectangle1.height);
		rectangle1.width = 1.0; // 생성된 rectangle1 직사각형 객체의 가로 길이(width)를 변경.
		rectangle1.height = 2.0; // 생성된 rectangle1 직사각형 객체의 세로 길이(height)를 변경.
		
		System.out.println("--------------------------------------------");
		
		// System.out.println(rectangle1.perimeter(3, 4)); -> 메서드를 이용하는게 아님.
		System.out.println(rectangle1.perimeter());
		System.out.println(rectangle1.area());
		
		System.out.println("--------------------------------------------");
		
		// argument를 갖는 생성자를 이용한 Rectangle 객체 생성.
		Rectangle rectangle2 = new Rectangle (4, 3);
		System.out.println(rectangle2);
		System.out.println(rectangle2.width + ", " + rectangle2.height);
		
		System.out.println("둘레: " + rectangle2.perimeter());
		System.out.println("넓이: " + rectangle2.area());
		
		

	}

}
