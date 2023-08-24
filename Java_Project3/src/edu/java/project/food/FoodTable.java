package edu.java.project.food;

public class FoodTable {
	public interface Entity {
		String TBL_NAME = "FOODS F";
		String TBL_BNAME = "BREAKFASTS B";
		String TBL_LNAME = "LUNCHS L";
		String TBL_DNAME = "DINNERS D";
		String COL_ID = "F.FID";
		String COL_BID = "B.FID";
		String COL_LID = "L.FID";
		String COL_DID = "D.FID";
		String COL_BDAY = "B.DAY";
		String COL_LDAY = "L.DAY";
		String COL_DDAY = "D.DAY";		
		String COL_BFKCAL = "B.BFKCAL";
		String COL_LUNCHKCAL = "L.LUNCHKCAL";
		String COL_DINNERKCAL = "D.DINNERKCAL";
		String COL_ALLKCAL = "ALLKCAL";
	}
		
	// field
	private String day;
	private double bfkcal;
	private double lunchkcal;
	private double dinnerkcal;
	private double allkcal;
	
	public FoodTable() {}

	public FoodTable(String day, double bfkcal, double lunchkcal, double dinnerkcal, double allkcal) {

		this.day = day;
		this.bfkcal = bfkcal;
		this.lunchkcal = lunchkcal;
		this.dinnerkcal = dinnerkcal;
		this.allkcal = allkcal;
	}
	

	

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public double getBfkcal() {
		return bfkcal;
	}

	public void setBfkcal(double bfkcal) {
		this.bfkcal = bfkcal;
	}

	public double getLunchkcal() {
		return lunchkcal;
	}

	public void setLunchkcal(double lunchkcal) {
		this.lunchkcal = lunchkcal;
	}

	public double getDinnerkcal() {
		return dinnerkcal;
	}

	public void setDinnerkcal(double dinnerkcal) {
		this.dinnerkcal = dinnerkcal;
	}


	public double getAllkcal() {
		double allkcal = this.bfkcal + this.lunchkcal + this.dinnerkcal;
		return allkcal;
	}
	
	public void setAllkcal(double allkcal) {
		this.allkcal = allkcal;
	}

	@Override
	public String toString() {
		return "FoodTable [day=" + day + ", bfkcal=" + bfkcal + ", lunchkcal=" + lunchkcal + ", dinnerkcal="
				+ dinnerkcal + ", allkcal=" + allkcal + "]";
	}

	

	


}
