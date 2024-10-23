package com.dopa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;

import com.dopa.dao.IGenericDAO;
import com.dopa.utils.DBUtils;

public class GenericDAOImpl<T> extends DBUtils implements IGenericDAO<T> {

	private final Function<ResultSet, T> mapper;

	public GenericDAOImpl(Function<ResultSet, T> mapper) {
		this.mapper = mapper;
	}

	@Override
	public int insert(String sql, Object... params) throws Exception {
		return executeUpdate(sql, params);
	}

	@Override
	public int update(String sql, Object... params) throws Exception {
		return executeUpdate(sql, params);
	}

	@Override
	public int delete(String sql, Object... params) throws Exception {
		return executeUpdate(sql, params);
	}

	@Override
	public T findById(String sql, Object... params) throws Exception {
		return executeQuerySingle(sql, mapper, params);
	}

	@Override
	public List<T> findAll(String sql, Object... params) throws Exception {
		return executeQueryList(sql, mapper, params);
	}

	@Override
	public List<T> findAll(String sql) throws SQLException, Exception {
		return executeQueryList(sql, mapper);
	}

	@Override
	public int countAll(String sql) throws Exception {
		return count(sql);
	}

	@Override
	public List<T> find(String sql) throws SQLException, Exception {
		return executeQueryList(sql, mapper);
	}

	@Override
	public List<T> find(String sql, Object... params) throws SQLException, Exception {
		return executeQueryList(sql, mapper, params);
	}

}