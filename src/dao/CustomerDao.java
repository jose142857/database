package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import database.JDBCUtil;
import model.Book;
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
						",adress='"+t.getAdress()+"' "+
						"WHERE id='"+t.getId()+"'";
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
		ArrayList<Customer> result = new ArrayList<Customer>();
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM customer";
			System.out.println(sql);
					
		ResultSet rs =	st.executeQuery(sql);
		
		while(rs.next()) {
			String name = rs.getString("name");
			String adr = rs.getString("adress");
			int age = rs.getInt("age");
			int id = rs.getInt("id");
			
			Customer cus = new Customer(name,adr,age,id);
			result.add(cus);
			
		}
		
		JDBCUtil.closeConnection(con);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public Customer selectById(Customer t) {
		Customer result = null;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM customer " + "WHERE id ='"+t.getId()+"' ";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String adr = rs.getString("adress");
				int id = rs.getInt("id");
				
				result = new Customer(name, adr, age, id);
				
				
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return result ;
		
	}

	@Override
	public ArrayList<Customer> selectByCondition(String condition) {
ArrayList<Customer> result = new ArrayList<Customer>();
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM customer WHERE "+ condition;
			System.out.println(sql);
					
		ResultSet rs =	st.executeQuery(sql);
		
		while(rs.next()) {
			String name = rs.getString("name");
			String adr = rs.getString("adress");
			int age = rs.getInt("age");
			int id = rs.getInt("id");
			
			Customer cus = new Customer(name,adr,age,id);
			result.add(cus);
			
		}
		
		JDBCUtil.closeConnection(con);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int distinct(Customer t) {
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT DISTINCT '"+t.getAge()+"' from book";
			System.out.println(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}

	@Override
	public ArrayList<Book> distinct() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
