package model;

public class User {
	private String userName;
	private String password;
	private String fullname;
	
	public User() {
		super();
	}

	public User(String userName, String password, String fullname) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullname = fullname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", fullname=" + fullname + "]";
	}
	
	
	
	
	
	
	

}
