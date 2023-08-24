package edu.java.project.lunch;

import static edu.java.project.oracle.OracleConnectWeight.*;
import static edu.java.project.bk.BreakfastTable.Entity.COL_ID;
import static edu.java.project.lunch.LunchTable.Entity.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;



public class LunchDaoImpl implements LunchDao{

	private static LunchDaoImpl instance = null;
	private LunchDaoImpl () {}
	public static LunchDaoImpl getInstance() {
		if(instance == null) {
			instance = new LunchDaoImpl();
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
	public List<LunchTable> read() {
		ArrayList<LunchTable> list = new ArrayList<>();
		
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
				double lunchkcal = rs.getDouble(COL_LUNCHKCAL);
				
				LunchTable lunchTable = new LunchTable (fid, day, diary, lunchkcal);
				list.add(lunchTable);
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
	public List<LunchTable> read(String keyword) { 
		ArrayList<LunchTable> list = new ArrayList<>(); // select 결과를 저장하고 리턴하기 위한 변수.
	
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
				double lunchkcal = rs.getDouble(COL_LUNCHKCAL);
				
				LunchTable lunchTable = new LunchTable (fid, day, diary, lunchkcal);
				list.add(lunchTable);
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
			+ " (" + COL_DAY + ", " + COL_DIARY + ", " + COL_LUNCHKCAL + ") "
			+ "values (?, ?, ?)";
	@Override
	public int creat (LunchTable breakfastTable) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			
			stmt.setString(1, breakfastTable.getDay());
			stmt.setString(2, breakfastTable.getDiary());
			stmt.setDouble(3, breakfastTable.getLunchkcal());
			
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
			+ " set " + COL_DAY + " = ?, " + COL_DIARY + " = ?, " + COL_LUNCHKCAL + " = ?"
			+ " where " + COL_ID + " = ?";
	@Override
	public int update(LunchTable breakfastTable) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			
			
			stmt.setString(1, breakfastTable.getDay());
			stmt.setString(2, breakfastTable.getDiary());
			stmt.setDouble(3, breakfastTable.getLunchkcal());
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
		return result;
		

	}
	
	private static final String SQL_DELETE =
			"delete from " + TBL_NAME
			+ " where " + COL_ID + " = ?";
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
	public LunchTable read(int fid) {
		LunchTable lunchTable = null; // select 결과를 저장하고 리턴하기 위한 변수.
		
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
				Double lunchkcal = rs.getDouble(COL_LUNCHKCAL);
				lunchTable = new LunchTable(fid, day, diary, lunchkcal);
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
		
		return lunchTable;
	}
	@Override
	public int creatFoodsLunch(LunchTable lunchTable) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into foods(FID, DAY, LUNCHKCAL) (select FID, DAY, LUNCHKCAL from LUNCHS )"; 
		
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
