package com.zy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	// 配置数据库的连接属性
	private static String DriverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String Url = "jdbc:sqlserver://db.duduchewang.cn:1433;SelectMethod=cursor"; //不连接具体的库
	private static String username = "sa";
	private static String password = "devduduW0#xoV%S";

	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private static Statement statement = null;

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		if (conn != null) {
			return conn;
		}
		Class.forName(DriverClass);
		conn = DriverManager.getConnection(Url, username, password);
		return conn;
	}

	/**
	 * 获取preparedstatment
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static PreparedStatement getPreStatement(String sql) throws Exception {
		if (pst != null) {
			return pst;
		}
		pst = getConnection().prepareStatement(sql);
		return pst;
	}

	/**
	 * 获取satement
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Statement getStatement() throws Exception {
		if (statement != null) {
			return statement;
		}
		statement = getConnection().createStatement();
		return statement;
	}

	/**
	 * 查询数据库
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static ResultSet queryByStament(String sql) throws Exception {
		statement = getStatement();
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	
	/**
	 * 关闭连接
	 */
	public static void close() {
		if(statement!=null)
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(pst!=null)
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
