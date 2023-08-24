package edu.java.project.weight;

import java.util.List;

public interface WeightDao {
	/**
	 * 
	 * @return
	 */
	List<WeightTable> read();
	
	/**
	 * 
	 * @param weightTable
	 * @return
	 */
	int create(WeightTable weightTable);
		
	/**
	 * 
	 * @param id
	 * @return
	 */
	int delete(int id);
	
}
