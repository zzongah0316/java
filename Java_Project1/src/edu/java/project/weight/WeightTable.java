package edu.java.project.weight;

import java.io.Serializable;
import java.time.LocalDateTime;

public class WeightTable implements Serializable {
	public interface Entity {
		String TBL_NAME = "WEIGHTS";
		String COL_ID = "ID";
		String COL_WEIGHT = "WEIGHT";
		String COL_HEIGHT = "HEIGHT";
		String COL_BMI = "BMI";
		String COL_CREATED_TIME = "CREATEDTIME";
	}
	
	// field
	private Integer id;
	private double weight;
	private double height;
	private String bmi;
	private LocalDateTime createdTime;
	
	public WeightTable() {}
	
	public WeightTable (int id, double weight, double height, String bmi, LocalDateTime createdTime) {
		this.id = id;
		this.weight = weight;
		this.height = height;
		this.createdTime = createdTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public LocalDateTime getTime() {
		return createdTime;
	}

	public void setTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public String getBMI() {
		double bmi = this.weight/((this.height/100)*(this.height/100));
		if(bmi>=0 && bmi<18.5) {
			return "저체중";
		} else if (bmi>=18.5 && bmi<22.9) {
			return "정상체중";
		} else if (bmi>=22.9 && bmi<24.9) {
			return "과체중";
		} else if (bmi>=24.9 && bmi<39.9) {
			return "비만";
		} else {
			return "심각한 비만";
		}
	}
	

}
