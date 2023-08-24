package edu.java.project.bk;

import java.io.Serializable;

public class BreakfastTable implements Serializable {
	public interface Entity {
		String TBL_NAME = "BREAKFASTS";
		String COL_ID = "FID";
		String COL_DAY = "DAY";
		String COL_DIARY = "DIARY";
		String COL_BFKCAL = "BFKCAL";
	}
	
	// field
	private int fid;
	private String day;
	private String diary;
	private double bfkcal;
	
	public BreakfastTable() {}

	public BreakfastTable(int fid, String day, String diary, double bfkcal) {
		this.fid = fid;
		this.day = day;
		this.diary = diary;
		this.bfkcal = bfkcal;
	}

	
	
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDiary() {
		return diary;
	}

	public void setDiary(String diary) {
		this.diary = diary;
	}

	public double getBfkcal() {
		return bfkcal;
	}

	public void setBfkcal(double bfkcal) {
		this.bfkcal = bfkcal;
	}

	@Override
	public String toString() {
		return "BreakfastTable [fid=" + fid + ", day=" + day + ", diary=" + diary + ", bfkcal=" + bfkcal + "]";
	}

	

	
}
