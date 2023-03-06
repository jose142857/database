package test;

import java.util.ArrayList;

import dao.BookDao;
import dao.CustomerDao;
import model.Customer;

public class TestCustomerDao {
	public static void main(String[] args) {
		Customer ctm1 = new Customer("van","hanoi",18);
		Customer ctm2 = new Customer("vuong","hanoi",28);
//		CustomerDao.getInstance().add(ctm1);
		
//		CustomerDao.getInstance().update(ctm2);
//		CustomerDao.getInstance().delete(ctm2);
		
		ArrayList<Customer> list = CustomerDao.getInstance().selectAll();
		for(Customer cus : list ) {
			System.out.println(cus.toString());
		}
	}

}
