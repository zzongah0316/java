package edu.java.mvc.menu;

public enum Menu {
	QUIT, TITLE, CONTENT, AUTHOR, CREATEDTIME, MODIFIEDTIME, UNKNOWN;
	
	public static Menu getValue(int m) {
		Menu[] menu = values();
		if(m>=0 && m<menu.length) {
			return menu[m];
		} else {
			return menu[menu.length - 1];
		}
		
	}

}
