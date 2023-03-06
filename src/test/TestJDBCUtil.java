package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
		
		try {
			Statement st = connection.createStatement();
			String sql = "INSERT INTO `book` (`bookName`, `publishYear`, `author`) "
					+ "VALUES ('\\'number\\'', '2022', '\\'Daisy\\'')";
		int check = st.executeUpdate(sql);
			System.out.println(check);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JDBCUtil.closeConnection(connection);
	}

}
