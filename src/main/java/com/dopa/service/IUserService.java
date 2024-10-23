package com.dopa.service;

import java.util.List;

import com.dopa.model.User;

public interface IUserService {
	List<User> getAllUsers();

	int countUsers();

	List<User> getTop3();
	
	List<User> getUserPerPage(int offset, int userPerPage);
}
