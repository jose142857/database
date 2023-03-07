package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Book;


public class BookDao implements DaoInterface<Book>{
	
	public static BookDao getInstance() {
		return new BookDao();
	}

	@Override
	public int add(Book t) {
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql ="INSERT INTO book(bookName,publishYear,author)"+
						"VALUES('"+t.getBookName()+"','"+t.getPublishYear()+"','"+t.getAuthor()+"')";
			
			int check = st.executeUpdate(sql);
			
			System.out.println("there are "+check+" lines changed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int update(Book t) {
//		create connection
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "UPDATE book SET "+
						"bookName ='"+t.getBookName()+"' "+
						",publishYear ='"+t.getPublishYear()+"'"+
						",author = '"+t.getAuthor()+"'";
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
	public int delete(Book t) {
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "DELETE FROM BOOK "+ "WHERE "+" publishYear = '"+t.getPublishYear()+"' ";
			
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
	public int distinct(Book t) {
	
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT DISTINCT '"+t.getPublishYear()+"' from book";
			System.out.println(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<Book> selectAll() {
		ArrayList<Book> result = new ArrayList<Book>();
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM book";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String bookName = rs.getString("bookName");
				String au = rs.getString("author");
				int y = rs.getInt("publishYear");
				
				Book b = new Book(bookName, au, y);
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
	public Book selectById(Book t) {
		Book result = new Book(null, null, 0);
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "Select * from book where '"+t.getPublishYear()+"'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String bn = rs.getString("bookName");
				String au = rs.getString("author");
				int ply = rs.getInt("publishYear");
				
				result = new Book(bn, au, ply);
						
			}
			JDBCUtil.closeConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Book> selectByCondition(String condition) {
		ArrayList<Book> result = new ArrayList<Book>();
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql = "SELECT * FROM book where "+ condition;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String bookName = rs.getString("bookName");
				String au = rs.getString("author");
				int y = rs.getInt("publishYear");
				
				Book b = new Book(bookName, au, y);
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
	public ArrayList<Book> distinct() {
		// TODO Auto-generated method stub
		return null;
	}

	


	

}
