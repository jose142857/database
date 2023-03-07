package test;

import java.util.ArrayList;

import dao.BookDao;
import dao.CustomerDao;
import model.Customer;

public class TestCustomerDao {
	public static void main(String[] args) {
//		Customer ctm1 = new Customer("van","hanoi",18,1);
//		Customer ctm2 = new Customer("vuong","hanoi",28,1);
////		CustomerDao.getInstance().add(ctm1);
//		
//		CustomerDao.getInstance().update(ctm2);
////		CustomerDao.getInstance().delete(ctm2);
//		
//		ArrayList<Customer> list = CustomerDao.getInstance().selectAll();
//		for(Customer cus : list ) {
//			System.out.println(cus.toString());
//		}
		
		
		System.out.println("----------------------------");
		Customer find = new Customer();
		find.setId(1);
		Customer cus1 = CustomerDao.getInstance().selectById(find);
		System.out.println(cus1);
		
		
//		System.out.println("----------------------------");
//		ArrayList<Customer> list1 = CustomerDao.getInstance().selectByCondition("age<28");
//		for(Customer cus : list1 ) {
//			System.out.println(cus.toString());
		}
		
	}


