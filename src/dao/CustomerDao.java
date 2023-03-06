package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Customer;

public class CustomerDao implements DaoInterface<Customer> {
	
	public static CustomerDao getInstance() {
		return new CustomerDao();
	}

	@Override
	public int add(Customer t) {
		
		Connection con = JDBCUtil.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO customer(name,age,adress)"
					+ "values('"+t.getName()+"','"+t.getAge()+"','"+t.getAdress()+"')";
			System.out.println(sql);
					
		int check =	st.executeUpdate(sql);
		System.out.println(check + " lines changed");
		
		JDBCUtil.closeConnection(con);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int update(Customer t) {
		Connection con = JDBCUtil.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "UPDATE customer "+
						"SET "+
						" name='"+ t.getName()+"' "+
						",age='"+ t.getAge()+"' "+
						"WHERE adress='"+t.getAdress()+"'";
			System.out.println(sql);
					
		int check =	st.executeUpdate(sql);
		System.out.println(check + " lines changed");
		
		JDBCUtil.closeConnection(con);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	

	@Override
	public int delete(Customer t) {
		Connection con = JDBCUtil.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "DELETE FROM customer "+
						"WHERE "+
						"age = '"+t.getAge()+"'";
			System.out.println(sql);
					
		int check =	st.executeUpdate(sql);
		System.out.println(check + " lines changed");
		
		JDBCUtil.closeConnection(con);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer selectById(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
