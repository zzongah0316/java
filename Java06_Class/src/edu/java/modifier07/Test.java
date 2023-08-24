package edu.java.modifier07;

public class Test {
	int x; // 인스턴스 필드(static 안 붙은 것)
	static int y; // static 필드
	
	// 인스턴스 메서드 
	public void printInfo() {
		System.out.println("---instance method---");
		System.out.println("x = " + this.x); // this. 생략 가능 
		System.out.println("y = " + y); 
		// -> this는 인스턴스에만 사용하므로 this.y는 사용X, Test.y로 사용 가능 // Test. 생략 가능
		// -> 인스턴스 메서드는 static 필드/메서드를 사용할 수 있음.
		System.out.println("---------------------");
	}
	
	
	
	// static public void printStaticInfo() {} -> public과 static 둘의 순서는 상관X
	public static void printStaticInfo() { 
		System.out.println("---static method---");
//		System.out.println("x = " + x); -> static 메서드는 static 인스턴스만 사용 가능. 따라서, 작동X
		// -> static 메서드에서 인스턴스 필드/메서드를 사용할 수 없기 때문에.
		System.out.println("y = " + y);
		System.out.println("-------------------");
	}

}
