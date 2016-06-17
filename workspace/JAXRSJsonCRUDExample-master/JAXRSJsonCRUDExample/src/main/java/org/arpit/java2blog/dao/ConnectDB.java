package org.arpit.java2blog.dao;

import java.sql.*;

public class ConnectDB {

	private static ConnectDB instance = new ConnectDB();

	private ConnectDB() {

		try {
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	public static ConnectDB getInstance() {

		return instance;
	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
				"Bijoy@398");
		return connection;
	}
}




