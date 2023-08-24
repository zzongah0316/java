package edu.java.project.food;

import static edu.java.project.oracle.OracleConnectWeight.*;
import static edu.java.project.food.FoodTable.Entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;


public class FoodDaoImpl implements FoodDao{
	
	private static FoodDaoImpl instance = null;
	private FoodDaoImpl() {}
	public static FoodDaoImpl getInstance() {
		if(instance == null) {
			instance = new FoodDaoImpl();
		}
		return instance;
	}

	private Connection getConnection() throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return conn;
	}
	
	private void closeResources(Connection conn, Statement stmt) throws SQLException {
		stmt.close();
		conn.close();
	}
	
	private void closeResources (Connection conn, Statement stmt, ResultSet rs ) throws SQLException {
		rs.close();
		stmt.close();
		conn.close();
	}
	
//	private static final String SQL_SELECT_ALL ="select B.DAY days, B.BFKCAL BFKCAL, L.LUNCHKCAL LUNCHKCAL, D.DINNERKCAL DINNERKCAL, ( B.BFKCAL + L.LUNCHKCAL + D.DINNERKCAL ) AS ALLKCAL from BREAKFASTS B, LUNCHS L, DINNERS D where B.FID = L.FID and L.FID = D.FID and B.DAY = L.DAY and L.DAY = D.DAY order by B.DAY";
//			"select " +COL_BDAY+ ", " 
//			+ COL_BFKCAL + ", " + COL_LUNCHKCAL + ", " + COL_DINNERKCAL + ", " 
//					+ "( B.BFKCAL + L.LUNCHKCAL + D.DINNERKCAL ) AS ALLKCAL"
//			+ " from " + TBL_BNAME + ", " + TBL_LNAME + ", " + TBL_DNAME
//			+ " where " + COL_BID + " = " + COL_LID 
//			+ " and " + COL_LID + " = " + COL_DID
//			+ " and " + COL_BDAY + " = " + COL_LDAY
//			+ " and " + COL_LDAY+ " = " + COL_DDAY
//			+ " order by B.DAY";

	
	@Override
	public List<FoodTable> read() {
		ArrayList<FoodTable> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT f1.DAY, "
				+ "  COALESCE(SUM(f1.BFKCAL), SUM(f2.BFKCAL)) AS BFKCAL, "
				+ "  COALESCE(SUM(f1.LUNCHKCAL), SUM(f2.LUNCHKCAL)) AS LUNCHKCAL, "
				+ "  COALESCE(SUM(f1.DINNERKCAL), SUM(f2.DINNERKCAL)) AS DINNERKCAL, "
				+ "  (COALESCE(SUM(f1.BFKCAL), SUM(f2.BFKCAL)) + COALESCE(SUM(f1.LUNCHKCAL), SUM(f2.LUNCHKCAL)) + COALESCE(SUM(f1.DINNERKCAL), SUM(f2.DINNERKCAL))) AS ALLKCAL "
				+ "FROM foods f1 "
				+ "LEFT JOIN foods f2 ON f1.DAY = f2.DAY AND f2.BFKCAL != 0 AND f1.FID != f2.FID "
				+ "GROUP BY f1.DAY";
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			System.out.println("sql: " + sql);
			
			while(rs.next()) {
				
				String day = rs.getString("day");
				double bfkcal = rs.getDouble("BFKCAL");
				double lunchkcal = rs.getDouble("LUNCHKCAL");
				double dinnerkcal = rs.getDouble("DINNERKCAL");
				double allkacl = rs.getDouble("ALLKCAL");
				
				System.out.println("day  "+day);
				
				FoodTable foodtable = new FoodTable(day, bfkcal, lunchkcal, dinnerkcal, allkacl);
				list.add(foodtable);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("list:" + list.toString());
		return list;
	}
	
}
