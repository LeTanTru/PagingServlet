package com.dopa.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.dopa.connection.DBConnection;

public class DBUtils extends DBConnection {

	protected void setParameters(PreparedStatement ps, Object... params) throws SQLException {
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				if (params[i] instanceof Integer) {
					ps.setInt(i + 1, (Integer) params[i]);
				} else if (params[i] instanceof String) {
					ps.setString(i + 1, (String) params[i]);
				} else if (params[i] instanceof Double) {
					ps.setDouble(i + 1, (Double) params[i]);
				} else if (params[i] instanceof Boolean) {
					ps.setBoolean(i + 1, (Boolean) params[i]);
				} else if (params[i] instanceof Long) {
					ps.setLong(i + 1, (Long) params[i]);
				} else if (params[i] instanceof Float) {
					ps.setFloat(i + 1, (Float) params[i]);
				} else if (params[i] instanceof Date) {
					ps.setDate(i + 1, (Date) params[i]);
				} else if (params[i] instanceof Timestamp) {
					ps.setTimestamp(i + 1, (Timestamp) params[i]);
				} else {
					ps.setObject(i + 1, params[i]);
				}
			}
		}
	}

	public int executeUpdate(String sql, Object... params) throws Exception {
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			setParameters(ps, params);

			return ps.executeUpdate();

		}
	}

	public <T> T executeQuerySingle(String sql, Function<ResultSet, T> mapper, Object... params) throws Exception {
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			setParameters(ps, params);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return mapper.apply(rs);
			}
			return null;
		}
	}

	public <T> List<T> executeQueryList(String sql, Function<ResultSet, T> mapper, Object... params) throws Exception {
		List<T> results = new ArrayList<T>();

		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			setParameters(ps, params);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				results.add(mapper.apply(rs));
			}

		}

		return results;
	}

	public int count(String sql) throws Exception {
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		}
		return 0;
	}
}
