package edu.java.project.food;

public class FoodDto {
	private String day;
	private double bfkCal;
	private double lunchkCal;
	private double dinnerkCal;
	private double allkCal;
	public FoodDto(String day, double bfkCal, double lunchkCal, double dinnerkCal, double allkCal) {
		this.day = day;
		this.bfkCal = bfkCal;
		this.lunchkCal = lunchkCal;
		this.dinnerkCal = dinnerkCal;
		this.allkCal = allkCal;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public double getBfkCal() {
		return bfkCal;
	}
	public void setBfkCal(double bfkCal) {
		this.bfkCal = bfkCal;
	}
	public double getLunchkCal() {
		return lunchkCal;
	}
	public void setLunchkCal(double lunchkCal) {
		this.lunchkCal = lunchkCal;
	}
	public double getDinnerkCal() {
		return dinnerkCal;
	}
	public void setDinnerkCal(double dinnerkCal) {
		this.dinnerkCal = dinnerkCal;
	}
	public double getAllkCal() {
		return allkCal;
	}
	public void setAllkCal(double allkCal) {
		this.allkCal = allkCal;
	}
	@Override
	public String toString() {
		return "FoodDto [day=" + day + ", bfkCal=" + bfkCal + ", lunchkCal=" + lunchkCal + ", dinnerkCal=" + dinnerkCal
				+ ", allkCal=" + allkCal + "]";
	}
	
}
