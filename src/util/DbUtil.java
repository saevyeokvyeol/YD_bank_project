package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtil {
	private static Properties profile = new Properties();
	
	static {
		try {
			profile.load(new FileInputStream("resources/dbInfo.properties"));
			profile.load(new FileInputStream("resources/bankQuery.properties"));
			
			Class.forName(profile.getProperty("driverName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getProfile() {
		return profile;
	}
	
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(
				profile.getProperty("url"), 
				profile.getProperty("userName"), 
				profile.getProperty("userPass"));
		return connection;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("DB연결");
			Connection connection = DbUtil.getConnection();
			System.out.println("connection: " + connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection connection, Statement statement) {
		try {
			if (statement != null) statement.close();
			if (connection != null) connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null) resultSet.close();
			DbUtil.close(connection, statement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
