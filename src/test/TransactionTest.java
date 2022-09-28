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
	
	public void findAll() {
		controller.findAll();
	}
	
	public void findById() {
		util.login(new Customer("test", "test"));
		controller.findById(null);
	}
	
	public static void main(String[] args) {
		TransactionTest test = new TransactionTest();
//		test.insertTransactionTest();
//		test.findById();
		test.findAll();
	}
}
