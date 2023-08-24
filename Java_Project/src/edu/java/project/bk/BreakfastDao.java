package edu.java.project.bk;

import java.util.List;

import edu.java.project.bk.BreakfastTable;

public interface BreakfastDao {

	List<BreakfastTable> read();
	
	BreakfastTable read(int fid);
	
	int creat(BreakfastTable breakTable);
	
	// 아침 칼로리 프레임 저장 버튼 누를 때 푸드 테이블에 아침 데이터 저장
	int creatFoodsBF(BreakfastTable breakTable);

	
	int update(BreakfastTable breakTable);
	
	
	List<BreakfastTable> read(String keyword);
	
	int delete(int fid);
	
}
