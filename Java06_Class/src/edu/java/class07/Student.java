package edu.java.class07;

public class Student {
	// field
	int stuNo; // 학생 번호(학번)
	String name; // 학생 이름
	Score score; // 학생 (Java, SQL, HTML)시험 점수
	
	
	// constructor
	// (1) 기본 생성자
	public Student() {
		
	}
	
	// (2) stuNo, name, score를 초기화할 수 있는 생성자
	public Student(int stuNo, String name, Score score) {
		this.stuNo = stuNo;
		this.name = name;
		this.score = score;
	}
//	public Student(int stuNo, String name, int java, int sql, int html) {
//		this.stuNo = stuNo;
//		this.name = name;
//		this.score = new Score(java, sql, html);
//	}

	
	// method
	// printStudent - 학번, 이름, 세 과목 점수, 총점, 평균을 출력하는 메서드.
	public void printStudent () {
		System.out.printf("학번: %d, 이름: %s, java 점수: %d, sql 점수: %d, html 점수: %d, 총점: %d, 평균: %f\n",
				stuNo, name, score.java, score.sql, score.html, score.getTotal(), score.getAverage());
	}

}
