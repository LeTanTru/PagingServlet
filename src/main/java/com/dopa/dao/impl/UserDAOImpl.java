package com.dopa.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dopa.dao.IUserDAO;
import com.dopa.model.User;

public class UserDAOImpl extends GenericDAOImpl<User> implements IUserDAO {

	public UserDAOImpl() {
		super(rs -> {
			try {
				int id = rs.getInt(1);
				String user = rs.getString(2);
				String pass = rs.getString(3);
				int isSeller = rs.getInt(4);
				int isAdmin = rs.getInt(5);
				return new User(id, user, pass, isSeller, isAdmin);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		});
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM account";
		List<User> list = new ArrayList<User>();
		try {
			list = this.findAll(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int countUsers() {
		String sql = "SELECT COUNT(*) FROM account";
		try {
			return count(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User> getTop3() {
		String sql = "SELECT * FROM account LIMIT 3";
		try {
			return findAll(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<User>();
	}

	@Override
	public List<User> getUserPerPage(int offset, int userPerPage) {
		String sql = "SELECT * FROM account ORDER BY uID LIMIT ? OFFSET ?";
		Object[] params = { userPerPage, offset };
		try {
			return find(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
