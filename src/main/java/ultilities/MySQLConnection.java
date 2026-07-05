package ultilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	public static Connection getMySQLConnection() {
		String hostname = "localhost";
		String dbName = "automationfc2";
		String userName = "root";
		String password = "automationfc";
		return getMySQLConnection(hostname, dbName, userName, password);
	}

	private static Connection getMySQLConnection(String hostname, String dbName, String userName, String password) {
		Connection conn = null;
		try {
			// Java 6 tu dong tim kiem Driver thich hop - ko bat buoc co dong nay
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String connectionURL = "jdbc:mysql://" + hostname + ":3306/" + dbName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
