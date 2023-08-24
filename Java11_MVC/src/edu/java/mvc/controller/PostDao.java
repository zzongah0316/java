package edu.java.mvc.controller;

import edu.java.mvc.model.Post;

public interface PostDao {

	String title(Post t);
	
	String content(Post c);
	
	String author(Post a);
	
	
	 
}
