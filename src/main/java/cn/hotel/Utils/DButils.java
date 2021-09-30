package cn.hotel.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DButils{
	
	private static String uername = "root";
	private static String password = "root";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3336/hotel";
	
	public static Connection getConnection() {		
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url,uername,password);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
