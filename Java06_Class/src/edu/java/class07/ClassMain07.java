package edu.java.class07;


public class ClassMain07 {

	public static void main(String[] args) {
//		Score score = new Score();
//		System.out.println(score);
//		System.out.println("java 점수: " + score.java);
//		System.out.println("sql 점수: " + score.sql);
//		System.out.println("html 점수: " + score.html);
		
//		System.out.println("-------------------------------");
		
		
//		Score score1 = new Score(70, 80, 90); 
//		System.out.println("java 점수: " + score1.java);
//		System.out.println("sql 점수: " + score1.sql);
//		System.out.println("html 점수: " + score1.html);
		
		
		System.out.println("-------------------------------");

		// argument를 갖는 생성자를 호출해서 Score 객체를 생성. 
		Score score2 = new Score(65, 75, 80);
		score2.printScore();
		System.out.println("총점: " + score2.getTotal());
		System.out.println("평균: " + score2.getAverage());
		
		System.out.println("-------------------------------");
		
		
		
		
		/*------------------------------------*/
//		String emptyString= "";
//		System.out.println("길이: " + emptyString.length());
     //	String nullString = null;
     //	System.out.println("길이: " + nullString.length());
	 // -> NullPointerException 발생
	 // null: 생성된 걕체가 없다.
 	 // 데이터 타입의 기본값:
     // (1) boolean - false, (2) 정수 - 0, (3) 실수 - 0.0 (4) 참조(클래스) 타입 - null
		
		
		
		
		
		
		
		System.out.println("-------------------------------");
		
		
		
		Student student = new Student(1004, "서정아", score2);
		student.printStudent();
//		
//		System.out.println("-------------------------------");
//		
//		Score score3 = new Score(65, 70, 80);
//		System.out.println("세 과목 총점: " + score3.getTotal());
//		
//		System.out.println("-------------------------------");
//		
//		Score score4 = new Score(95, 72, 80);
//		System.out.println("세 과목 평균: " + score4.getAverage());
		
		
		
		

	}

}
