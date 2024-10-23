package com.dopa.service.impl;

import java.util.List;

import com.dopa.dao.IUserDAO;
import com.dopa.dao.impl.UserDAOImpl;
import com.dopa.model.User;
import com.dopa.service.IUserService;

public class UserServiceImpl implements IUserService {

	IUserDAO userDAO = new UserDAOImpl();

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public int countUsers() {
		return userDAO.countUsers();
	}

	@Override
	public List<User> getTop3() {
		return userDAO.getTop3();
	}

	@Override
	public List<User> getUserPerPage(int offset, int userPerPage) {
		return userDAO.getUserPerPage(offset, userPerPage);
	}

}
