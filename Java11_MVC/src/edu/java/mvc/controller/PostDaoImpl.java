package edu.java.mvc.controller;

import edu.java.mvc.model.Post;

public class PostDaoImpl implements PostDao {

	private static PostDaoImpl instance = null;
	
	private PostDaoImpl() {};
	
	public static PostDaoImpl getInstance() {
		if (instance == null) {
			instance = new PostDaoImpl();
		}
		return instance;
	}
	
	private static final int MAX_LENGTH = 1;
	private Post[] posts = new Post[MAX_LENGTH];
	private int count = 0;
	
	public boolean isMemoryAvailable() {
		return count < MAX_LENGTH;
	}
	
	public boolean isValidIndex(int index) {
		return (index>=0) && (index<count);
	}

	@Override
	public String title(Post t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String content(Post c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String author(Post a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
