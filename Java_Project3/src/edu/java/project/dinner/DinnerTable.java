package edu.java.project.dinner;

import java.io.Serializable;

public class DinnerTable implements Serializable {
	public interface Entity {
		String TBL_NAME = "DINNERS";
		String COL_ID = "FID";
		String COL_DAY = "DAY";
		String COL_DIARY = "DIARY";
		String COL_DINNERKCAL = "DINNERKCAL";
	}
	
	// field
	private int fid;
	private String day;
	private String diary;
	private double dinnerkcal;
	
	public DinnerTable() {}

	public DinnerTable(int fid, String day, String diary, double dinnerkcal) {
		this.fid = fid;
		this.day = day;
		this.diary = diary;
		this.dinnerkcal = dinnerkcal;
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

	public double getDinnerkcal() {
		return dinnerkcal;
	}

	public void setDinnerkcal(double dinnerkcal) {
		this.dinnerkcal = dinnerkcal;
	}

	@Override
	public String toString() {
		return "DinnerTable [fid=" + fid + ", day=" + day + ", diary=" + diary + ", dinnerkcal=" + dinnerkcal + "]";
	}

	
	

	
}
