package test;

import java.util.ArrayList;

import dao.BookDao;
import dao.CustomerDao;
import database.JDBCUtil;
import model.Book;

public class TestBookDao {
	public static void main(String[] args) {
		Book b1 = new Book("A", "peter", 2015);
		Book b2 = new Book("B", "Crouch", 2018);
//		BookDao.getInstance().add(b2);
//		BookDao.getInstance().add(b1);
		Book b3 = new Book ("number","Daisy",2022);
		
//		Book b5 = new Book();
//		b5.setPublishYear(2011);
//		BookDao.getInstance().delete(b5);
		
		
//		BookDao.getInstance().update(b2);
		Book b10 = new Book();
		b10.setPublishYear(2010);
		
		Book b11 = BookDao.getInstance().selectById(b10);
		System.out.println(b11);
		
		ArrayList<Book> list_2 = BookDao.getInstance().selectByCondition("publishYear>2010");
		for(Book i : list_2) {
			System.out.println(i);
		}
		
		
		
		
//		ArrayList<Book> list_1 = BookDao.getInstance().selectAll();
//		for (Book b :list_1) {
//			System.out.println(b.toString());
//		}
	}

}
