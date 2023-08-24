package edu.java.project.bk;

import static edu.java.project.oracle.OracleConnectWeight.*;
import static edu.java.project.bk.BreakfastTable.Entity.*;

import java.awt.Component;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import oracle.jdbc.driver.OracleDriver;



public class BreakfastDaoImpl implements BreakfastDao{

	private static BreakfastDaoImpl instance = null;
	private BreakfastDaoImpl () {}
	public static BreakfastDaoImpl getInstance() {
		if(instance == null) {
			instance = new BreakfastDaoImpl();
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
			"select * from " + TBL_NAME + " order by " + COL_DAY;
	@Override
	public List<BreakfastTable> read() {
		ArrayList<BreakfastTable> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int fid = rs.getInt(COL_ID);
				String day = rs.getString(COL_DAY);
				String diary = rs.getString(COL_DIARY);
				double bfkcal = rs.getDouble(COL_BFKCAL);
				
				BreakfastTable breakfastTable = new BreakfastTable (fid, day, diary, bfkcal);
				list.add(breakfastTable);
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
	

	private static final String SQL_SELECT_BY_DAY = 
			"select * from Breakfasts " 
					+ " where lower(day) like lower(?)"
					+ " order by DAY";
	@Override
	public List<BreakfastTable> read(String keyword) { 
		ArrayList<BreakfastTable> list = new ArrayList<>(); // select 결과를 저장하고 리턴하기 위한 변수.
	
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_BY_DAY);
			stmt = conn.prepareStatement(SQL_SELECT_BY_DAY);
			
			String key = "%" + keyword + "%";
			System.out.println("keyword=" + keyword + " , key=" + key);
			
		
			stmt.setString(1, key);
			rs = stmt.executeQuery();
			if(rs.next()) { // 검색된 행(row) 데이터가 있다면 
				int fid = rs.getInt(COL_ID);
				String day = rs.getString(COL_DAY);
				String diary = rs.getString(COL_DIARY);
				double bfkcal = rs.getDouble(COL_BFKCAL);
				
				BreakfastTable breakfastTable = new BreakfastTable (fid, day, diary, bfkcal);
				list.add(breakfastTable);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			closeResources(conn, stmt, rs);
			} catch (Exception e) { // Exception으로 바꾸기
				e.printStackTrace();
			}
		}
	
		return list;
	}
	
	
	private static final String SQL_INSERT =
			"insert into " + TBL_NAME
			+ " (" + COL_DAY + ", " + COL_DIARY + ", " + COL_BFKCAL + ") "
			+ "values (?, ?, ?)";
	@Override
	public int creat (BreakfastTable breakfastTable) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
		
			stmt.setString(1, breakfastTable.getDay());
			stmt.setString(2, breakfastTable.getDiary());
			stmt.setDouble(3, breakfastTable.getBfkcal());
			
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
	
	private static final String SQL_UPDATE = 
			"update " + TBL_NAME 
			+ " set " + COL_DAY + " = ?, " + COL_DIARY + " = ?, " + COL_BFKCAL + " = ?"
			+ " where " + COL_ID + " = ?";
	private static final String SQL_UPDATE1 = 
			"update FOODS" 
			+ " set " + COL_DAY + " = ?, "   + COL_BFKCAL + " = ?"
			+ " where " + COL_ID + " = ?";
	
	@Override
	public int update(BreakfastTable breakfastTable) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			
			
			stmt.setString(1, breakfastTable.getDay());
			stmt.setString(2, breakfastTable.getDiary());
			stmt.setDouble(3, breakfastTable.getBfkcal());
			stmt.setInt(4, breakfastTable.getFid());
			
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
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE1);
			
			
			stmt.setString(1, breakfastTable.getDay());
			stmt.setDouble(2, breakfastTable.getBfkcal());
			stmt.setInt(3, breakfastTable.getFid());
			
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
			+ " where " + COL_ID+ " = ?";
	private static final String SQL_DELETE1 =
			"delete from FOODS" 
			+ " where " + COL_ID+ " = ?";
	@Override
	public int delete(int fid) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			System.out.println("fid : " + fid);
			System.out.println("SQL_DELETE:"+SQL_DELETE);
			
			stmt.setInt(1, fid);
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
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_DELETE1);
			System.out.println("fid : " + fid);
			System.out.println("SQL_DELETE:"+SQL_DELETE);
			
			stmt.setInt(1, fid);
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

	private static final String SQL_SELECT_BY_ID = 
			"select * from " + TBL_NAME + " where " + COL_ID  + " = ?" ;
	@Override
	public BreakfastTable read(int fid) {
		BreakfastTable breakfastTable = null; // select 결과를 저장하고 리턴하기 위한 변수.
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			System.out.println(SQL_SELECT_BY_ID);
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			
			stmt.setInt(1, fid);
			rs = stmt.executeQuery();
			if(rs.next()) { // 검색된 행(row) 데이터가 있다면 
				int id = rs.getInt(COL_ID);
				String day = rs.getString(COL_DAY);
				String diary = rs.getString(COL_DIARY);
				Double bfkcal = rs.getDouble(COL_BFKCAL);
				breakfastTable = new BreakfastTable(fid, day, diary, bfkcal);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (Exception e) { // Exception으로 바꾸기
				e.printStackTrace();
			}
		}
		
		return breakfastTable;
	}
	@Override
	public int creatFoodsBF(BreakfastTable breakTable) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into foods(FID, DAY, BFKCAL) (select FID, DAY, BFKCAL from BREAKFASTS )"; 
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			
			System.out.println("creatFoodsBF sql : "+sql);
			
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
