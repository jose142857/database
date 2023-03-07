package test;

import dao.UserDao;
import model.User;

public class TestUserDao {
	public static void main(String[] args) {
//		User u1 = new User("thinv", "12211", "nguyen van thi");
//		UserDao.getInstance().add(u1);
		
		
		
//		User u2 = new User();
//		u2.setUserName("thinv");
//		User b = UserDao.getInstance().selectById(u2);
//		System.out.println(b.toString());
		
//		hack system
		
		User u2 = new User("x\' or 1=1; -- ", "", "");
		
		User b = UserDao.getInstance().selectById(u2);
		System.out.println(b.toString());
		
	}
	
	
	
	
	

}
