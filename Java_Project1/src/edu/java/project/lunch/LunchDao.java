package edu.java.project.lunch;

import java.util.List;

import edu.java.project.lunch.LunchTable;

public interface LunchDao {

	List<LunchTable> read();
	
	LunchTable read(int fid);
	
	int creat(LunchTable lunchTable);
	
	int creatFoodsLunch(LunchTable lunchTable);
	
	int update(LunchTable lunchTable);
	
	List<LunchTable> read(String keyword);
	
	int delete(int fid);
	
}
