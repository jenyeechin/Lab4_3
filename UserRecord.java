package my.edu.tarc.lab4_3;

import my.edu.tarc.lab4_3.UserContract.User;

public class UserRecord {
	private String name;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString(){
		return User.COLUMN_NAME + ":" + this.name + 
				"," + User.COLUMN_EMAIL + ":" + this.email;
	}

}
