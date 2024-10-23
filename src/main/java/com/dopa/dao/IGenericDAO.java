package com.dopa.dao;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<T> {

	int insert(String sql, Object... params) throws SQLException, Exception;

	int update(String sql, Object... params) throws SQLException, Exception;

	int delete(String sql, Object... params) throws SQLException, Exception;

	T findById(String sql, Object... params) throws SQLException, Exception;
	
	List<T> find(String sql) throws SQLException, Exception;

	List<T> find(String sql, Object... params) throws SQLException, Exception;

	List<T> findAll(String sql) throws SQLException, Exception;

	List<T> findAll(String sql, Object... params) throws SQLException, Exception;
	
	int countAll(String sql) throws Exception;
}
