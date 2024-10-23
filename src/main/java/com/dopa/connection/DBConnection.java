package com.dopa.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.dopa.constants.Constant;

public class DBConnection {
	public Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(Constant.DB_URL, Constant.USER_NAME, Constant.PASSWORD);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new DBConnection().getConnection());
	}
}
