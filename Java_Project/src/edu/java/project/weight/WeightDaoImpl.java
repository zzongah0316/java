package edu.java.project.weight;

import static edu.java.project.oracle.OracleConnectWeight.*;
import static edu.java.project.weight.WeightTable.Entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;



public class WeightDaoImpl implements WeightDao {
	
	private static WeightDaoImpl instance = null;
	private WeightDaoImpl () {}
	public static WeightDaoImpl getInstance() {
		if(instance == null) {
			instance = new WeightDaoImpl();
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
	
	
	private static final String SQL_SELECT_ALL =
			"select * from " + TBL_NAME + " order by " + COL_ID;
	@Override
	public List<WeightTable> read() {
		ArrayList<WeightTable> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_ALL);
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(COL_ID);
				double weight = rs.getDouble(COL_WEIGHT);
				double height = rs.getDouble(COL_HEIGHT);
				String bmi = rs.getString(COL_BMI);
				LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
				
				WeightTable weightTable = new WeightTable (id, weight, height, bmi, createdTime);
				list.add(weightTable);
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
		return list;
	}

	
	private static final String SQL_INSERT =
			"insert into " + TBL_NAME
			+ " (" + COL_WEIGHT + ", " + COL_HEIGHT + ", " + COL_BMI + ") "
			+ "values (?, ?, ?)";
	@Override
	public int create(WeightTable weightTable) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			System.out.println(SQL_INSERT);
			stmt = conn.prepareStatement(SQL_INSERT);
			
			stmt.setDouble(1, weightTable.getWeight());
			stmt.setDouble(2, weightTable.getHeight());
			stmt.setString(3, weightTable.getBMI());
			
			result = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	private static final String SQL_DELETE =
			"delete from " + TBL_NAME
			+ " where " + COL_ID + " = ?";

	@Override
	public int delete(int id) {
		int result = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			System.out.println(SQL_DELETE);
			stmt = conn.prepareStatement(SQL_DELETE);
			
			stmt.setInt(1, id);
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	

}
