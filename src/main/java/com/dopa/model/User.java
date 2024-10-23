package com.dopa.model;

public class User {
	private int uid;
	private String user;
	private String pass;
	private int isSeller;
	private int isAdmin;

	public User() {
		super();
	}

	public User(int uid, String user, String pass, int isSeller, int isAdmin) {
		super();
		this.uid = uid;
		this.user = user;
		this.pass = pass;
		this.isSeller = isSeller;
		this.isAdmin = isAdmin;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIsSeller() {
		return isSeller;
	}

	public void setIsSeller(int isSeller) {
		this.isSeller = isSeller;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "UserModel [uid=" + uid + ", user=" + user + ", pass=" + pass + ", isSeller=" + isSeller + ", isAdmin="
				+ isAdmin + "]";
	}

}
