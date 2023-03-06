package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			String username = "root";
			String password = "";
			String url = "jdbc:mySQL://localhost:3306/bookStore";
			
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
		
	}
	
	public static void closeConnection(Connection c) {
		if (c!=null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}
	public static void printInfor(Connection c) {
			if ( c!=null) {
				try {
					DatabaseMetaData con = c.getMetaData();
					System.out.println(con.getDatabaseProductName());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	

}

