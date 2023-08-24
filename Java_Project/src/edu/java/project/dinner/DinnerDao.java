package edu.java.project.dinner;

import java.util.List;

import edu.java.project.dinner.DinnerTable.Entity.*;

public interface DinnerDao {

	List<DinnerTable> read();
	
	DinnerTable read(int fid);
	
	int creat(DinnerTable dinnerTable);
	
	int creatFoodsDinner(DinnerTable dinnerTable);
	
	int update(DinnerTable dinnerTable);
	
	List<DinnerTable> read(String keyword);
	
	int delete(int fid);
	
}
