package dao;


import java.sql.Connection;
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
			String sql = "DELETE FROM BOOK "+ "WHERE "+" bookName = '"+t.getBookName()+"' ";
			
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
	public ArrayList<Book> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book selectById(Book t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Book> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
