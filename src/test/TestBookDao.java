package test;

import dao.BookDao;
import database.JDBCUtil;
import model.Book;

public class TestBookDao {
	public static void main(String[] args) {
		Book b1 = new Book("A", "peter", 2015);
		Book b2 = new Book("B", "Crouch", 2018);
//		BookDao.getInstance().add(b2);
		Book b3 = new Book ("number","Daisy",2022);
		
		BookDao.getInstance().delete(b2);
	}

}
