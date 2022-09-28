package test;

import controller.TransactionController;
import dto.Customer;
import dto.Transaction;

public class TransactionTest {
	private TransactionController controller = new TransactionController();
	private TestUtil util = new TestUtil();
	
	public void insertTransactionTest() {
		util.login(new Customer("test", "test"));
		controller.insertTransaction(new Transaction(10009, 10008, 3, (long) 1000));

		controller.insertTransaction(new Transaction(10008, 0, 1, (long) 2000));
//
		controller.insertTransaction(new Transaction(0, 10008, 2, (long) 3000));
	}
	
	public void findAllTest() {
		controller.findAll();
	}
	
	public void findByIdTest() {
		controller.findById("yuda");
		util.login(new Customer("test", "test"));
		controller.findById(null);
	}
	
	public void findByTransactionIdTest() {
		controller.findByTransactionId(1);
		controller.findByTransactionId(22);
	}
	
	public void findByTodayTest() {
		controller.findByToday();
	}
	
	public void findByAccountIdTest() {
		controller.findByAccountId(1000);
		controller.findByAccountId(10000);
		controller.findByAccountId(10001);
		controller.findByAccountId(10009);
	}
	
	public static void main(String[] args) {
		TransactionTest test = new TransactionTest();
//		test.insertTransactionTest();
//		test.findByIdTest();
//		test.findAllTest();
//		test.findByTransactionIdTest();
//		test.findByTodayTest();
		test.findByAccountIdTest();
	}
}
