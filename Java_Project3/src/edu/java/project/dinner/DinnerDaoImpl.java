package edu.java.project.dinner;

import static edu.java.project.oracle.OracleConnectWeight.*;
import static edu.java.project.dinner.DinnerTable.Entity.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;



public class DinnerDaoImpl implements DinnerDao{

	private static DinnerDaoImpl instance = null;
	private DinnerDaoImpl () {}
	public static DinnerDaoImpl getInstance() {
		if(instance == null) {
			instance = new DinnerDaoImpl();
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
	public List<DinnerTable> read() {
		ArrayList<DinnerTable> list = new ArrayList<>();
		
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
				double dinnerkcal = rs.getDouble(COL_DINNERKCAL);
				
				DinnerTable dinnerTable = new DinnerTable (fid, day, diary, dinnerkcal);
				list.add(dinnerTable);
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
	public List<DinnerTable> read(String keyword) { 
		ArrayList<DinnerTable> list = new ArrayList<>(); // select 결과를 저장하고 리턴하기 위한 변수.
	
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
				double dinnerkcal = rs.getDouble(COL_DINNERKCAL);
				
				DinnerTable dinnerTable = new DinnerTable (fid, day, diary, dinnerkcal);
				list.add(dinnerTable);
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
			+ " (" + COL_DAY + ", " + COL_DIARY + ", " + COL_DINNERKCAL + ") "
			+ "values (?, ?, ?)";
	@Override
	public int creat (DinnerTable dinnerTable) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			
			stmt.setString(1, dinnerTable.getDay());
			stmt.setString(2, dinnerTable.getDiary());
			stmt.setDouble(3, dinnerTable.getDinnerkcal());
			
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
			+ " set " + COL_DAY + " = ?, " + COL_DIARY + " = ?, " + COL_DINNERKCAL + " = ?"
			+ " where " + COL_ID + " = ?";
	@Override
	public int update(DinnerTable dinnerTable) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			
			
			stmt.setString(1, dinnerTable.getDay());
			stmt.setString(2, dinnerTable.getDiary());
			stmt.setDouble(3, dinnerTable.getDinnerkcal());
			stmt.setInt(4, dinnerTable.getFid());
			
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
	public int delete(int fid) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			
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
	public DinnerTable read(int fid) {
		DinnerTable dinnerTable = null; // select 결과를 저장하고 리턴하기 위한 변수.
		
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
				Double dinnerkcal = rs.getDouble(COL_DINNERKCAL);
				dinnerTable = new DinnerTable(fid, day, diary, dinnerkcal);
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
		
		return dinnerTable;
	}
	@Override
	public int creatFoodsDinner(DinnerTable dinnerTable) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into foods(FID, DAY, DINNERKCAL) (select FID, DAY, DINNERKCAL from DINNERS )"; 
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			
			
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
