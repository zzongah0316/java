package edu.java.inheritance06;

import java.util.Objects;

public class User {
	// field
	private String userId;
	private String password;
	
	
	// 생성자: (1) 기본 생성자, (2) argument 2개를 갖는 생성자.
	public User() {}
	
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	
	// getters & setters
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	// toString() override: "User(UserId = ..., password = ...)"
	@Override
	public String toString () {
//		return String.format("(UserId = %s , password = %s)", this.userId, this.password);

		return "User(userId = " + this.userId
				+ ", Password = " + this.password + ")";
	}
	
	// equals() override: 두 객체의 userId가 같으면 true, 그렇지 않으면 false. 
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj instanceof User) { 
			User other = (User) obj; 
//			result = (this.userId == other.userId) && (this.password == other.password);
//		}
//			return result;
			if(this.userId != null && this.userId.equals(other.userId)) { // 문자열이기 때문에 ==말고 equals 쓰기
				result = true;
			} else if (this.userId==null && other.userId==null) { // 값이 null일때도 true가 나오게 하는 방법.
				result = true;
			}
		}
		return result;
	}

	// hashCode() override 
	// equals()의 리턴 값이 true이면 hashCode()의 리턴 값이 같다.
	public int hashCode() {
		// return Objects.hash(userId, password);
		if (this.userId == null) {
			return 0;
		} else {
			return this.userId.hashCode();
		}
	}
}



