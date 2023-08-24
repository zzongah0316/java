package edu.java.jdbc02;

import static edu.java.jdbc.model.Blog.Entity.*; // - 6.5
import static edu.java.jdbc.oracle.OracleConnect.*; // - 3

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;


public class JdbcMain02 {

	public static void main(String[] args) {
		// DB 테이블에 insert 하기:
		
		Scanner scanner = new Scanner(System.in); // - 11
		
		Connection conn = null; // - 2
		PreparedStatement stmt = null; // - 5
		try {
			// 오라클 드라이버를 등록 - 1
			DriverManager.registerDriver(new OracleDriver());
			
			// 오라클 DB에 접속
			conn = DriverManager.getConnection(URL, USER, PASSWORD); // - 4

			// SQL 문장(Statement)을 준비
			String sql = String.format("insert into %s (%s, %s, %s) values (?, ?, ?)", 
					TBL_NAME, COL_TITLE, COL_CONTENT, COL_AUTHOR); // - 6
			System.out.println(sql); // - 7
			
			// SQL 문장을 실행할 수 있는 Statement 타입 객체 생성.
			stmt = conn.prepareStatement(sql); // - 8
			
			// 제목, 내용 입력받기
			System.out.println("제목>>>>"); // - 12
			String title = scanner.nextLine(); // - 13
			System.out.println("내용>>>>"); // - 14
			String content = scanner.nextLine(); // - 15
			
			// SQL 문장에서 ? 부분을 채움.
			stmt.setString(1, title); // - 16
			stmt.setString(2, content); // - 17
			stmt.setString(3, "죵아"); // - 18
			
			// SQL 문장 실행
			int result = stmt.executeUpdate(); // - 19
			System.out.println(result + "개 행이 삽입됐습니다."); // - 20
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 사용했던 모든 리소스 해제
			try {
				stmt.close(); // - 9
				conn.close(); // - 10
			} catch (SQLException e) {
		
				e.printStackTrace();
			} 
		}

	}

}
