package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import database.JDBCUtil;
import model.User;


public class UserDao implements DaoInterface<User>{
	
	public static UserDao getInstance() {
		return new UserDao();
	}

	@Override
	public int add(User t) {
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql ="INSERT INTO User(UserName,password,fullname)"+
						"VALUES('"+t.getUserName()+"','"+t.getPassword()+"','"+t.getFullname()+"')";
			
			int check = st.executeUpdate(sql);
			
			System.out.println("there are "+check+" lines changed");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int update(User t) {
//		create connection
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE User SET "+
						"UserName ='"+t.getUserName()+"' "+
						",fullname ='"+t.getFullname()+"'"+
						",password = '"+t.getPassword()+"'";
			System.out.println(sql);
			int check = st.executeUpdate(sql);
			System.out.println("there are "+check+" lines changed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(User t) {
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM User "+ "WHERE "+" userName = '"+t.getUserName()+"' ";
			
			System.out.println(sql);
			int check = st.executeUpdate(sql);
			System.out.println("there are "+check+" lines changed");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	@Override
	public int distinct(User t) {
	
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT DISTINCT '"+t.getFullname()+"' from User";
			System.out.println(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> result = new ArrayList<User>();
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM User";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String UserName = rs.getString("UserName");
				String ps = rs.getString("password");
				String full = rs.getString("fullname");
				
				User b =new User(UserName, ps, full);
				result.add(b);
				
			}
			
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public User selectById(User t) {
		User result = new User();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "Select * from User where userName =?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getPassword());
		
			System.out.println(sql);
			ResultSet rs = pst.executeQuery(sql);
			
			while(rs.next()) {
				String userName = rs.getString("UserName");
				String ps = rs.getString("password");
				String fn = rs.getString("fullname");
				
				result = new User(userName, ps, fn);
						
			}
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<User> selectByCondition(String condition) {
		ArrayList<User> result = new ArrayList<User>();
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM User where "+ condition;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String UserName = rs.getString("UserName");
				String ps = rs.getString("password");
				String fn = rs.getString("fullname");
				
				User b = new User(UserName, ps, fn);
				result.add(b);
				
			}
			
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int distinct() {
		// TODO Auto-generated method stub
		return 0;
	}

	


	

}
