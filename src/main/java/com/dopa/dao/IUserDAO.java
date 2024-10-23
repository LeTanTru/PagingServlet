package com.dopa.dao;

import java.util.List;

import com.dopa.model.User;

public interface IUserDAO {
	List<User> getAllUsers();

	int countUsers();

	List<User> getTop3();

	List<User> getUserPerPage(int offset, int userPerPage);
}
