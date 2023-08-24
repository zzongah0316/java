package edu.java.project.lunch;

import java.io.Serializable;

public class LunchTable implements Serializable {
	public interface Entity {
		String TBL_NAME = "LUNCHS";
		String COL_ID = "FID";
		String COL_DAY = "DAY";
		String COL_DIARY = "DIARY";
		String COL_LUNCHKCAL = "LUNCHKCAL";
	}
	
	// field
	private int fid;
	private String day;
	private String diary;
	private double lunchkcal;
	
	public LunchTable() {}

	public LunchTable(int fid, String day, String diary, double lunchkcal) {
		this.fid = fid;
		this.day = day;
		this.diary = diary;
		this.lunchkcal = lunchkcal;
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

	public double getLunchkcal() {
		return lunchkcal;
	}

	public void setLunchkcal(double lunchkcal) {
		this.lunchkcal = lunchkcal;
	}

	@Override
	public String toString() {
		return "LunchTable [fid=" + fid + ", day=" + day + ", diary=" + diary + ", lunchkcal=" + lunchkcal + "]";
	}

	

	

	
}
