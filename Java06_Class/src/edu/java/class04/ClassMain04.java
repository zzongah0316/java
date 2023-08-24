package edu.java.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// 기본 생성자를 사용해서 Product 타입의 객체를 생성.
		Product product1 = new Product ();
		System.out.println(product1); // 메서드가 생성 안되어있을 때.
		System.out.println("상품 아이디: " + product1.productId );
		System.out.println("상품 이름: " + product1.productName);
		System.out.println("상품 가격: " + product1.productPrice);
		System.out.println("-------------------------------------------");
		product1.printProductInfo();
		
		// argument 3개를 갖는 생성자를 호출해서 product 타입의 객체를 생성
		Product product2 = new Product (1004, "맛나 과자", 3000);
		product2.printProductInfo();
	
		// argument 2개를 갖는 생성자를 호출해서 product 타입의 객체를 생성
		Product product3 = new Product (13, "맛없어 과자");
		product3.printProductInfo();
		product3.setProductPrice(1500);
		product3.printProductInfo();
		
		
	}
}
