package test;

import controller.AccountController;
import controller.CustomerController;
import dto.Customer;
import session.Session;

public class AccountTest {
	private AccountController accountController = new AccountController();
	private TestUtil test = new TestUtil();
	
	public void insertTest() {
		System.out.println("실패: 로그인X");
		accountController.insertAccount();
		
		System.out.println("\n성공: 로그인O");
		test.login(new Customer("test", "test"));
		accountController.insertAccount();
		
		test.delete("delete from account where id = 'test'");
	}
	
	public void findByIdTest() {
		System.out.println("계좌가 하나도 없을 때");
		test.login(new Customer("test", "test"));
		accountController.findById(true);

		System.out.println("\n계좌가 있을 때");
		test.login(new Customer("yuda", "1234"));
		accountController.findById(true);
	}
	
	public static void main(String[] args) {
		AccountTest test = new AccountTest();
		
//		test.insertTest();
		test.findByIdTest();
	}
}
