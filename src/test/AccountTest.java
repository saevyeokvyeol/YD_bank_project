package test;

import controller.AccountController;
import controller.CustomerController;
import dto.Customer;
import session.Session;

public class AccountTest {
	private AccountController accountController = new AccountController();
	private TestUtil util = new TestUtil();
	
	public void insertTest() {
		System.out.println("실패: 로그인X");
		accountController.insertAccount();
		
		System.out.println("\n성공: 로그인O");
		util.login(new Customer("test", "test"));
		accountController.insertAccount();
		
		util.delete("delete from account where id = 'test'");
	}
	
	public void findAllTest() {
		accountController.findAll();
	}
	
	public void findByAccountIdTest() {
		accountController.findByAccountId(10000);
		accountController.findByAccountId(10005);
		accountController.findByAccountId(10010);
	}
	
	public void findByIdTest() {
		System.out.println("계좌가 하나도 없을 때");
		util.login(new Customer("test", "test"));
		accountController.findById(true);

		System.out.println("\n계좌가 있을 때");
		util.login(new Customer("yuda", "1234"));
		accountController.findById(true);
	}
	
	public void updateClose() {
		util.login(new Customer("tset", "tset"));
		System.out.println("실패: 없는 계좌");
		accountController.updateClose(1000);
		System.out.println("\n실패: 아이디 불일치");
		accountController.updateClose(10022);
		System.out.println("\n실패: 잔고가 남은 계좌");
		accountController.updateClose(10009);
		System.out.println("\n실패: 이미 해지된 계좌");
		accountController.updateClose(10020);
		
		int success = 10021;
		System.out.println("\n성공");
		accountController.updateClose(success);
		
		util.delete("update account set state_id = 1 where account_id = " + success);
	}
	
	public static void main(String[] args) {
		AccountTest test = new AccountTest();
		
//		test.insertTest();
//		test.findByIdTest();
//		test.findAllTest();
//		test.findByAccountIdTest();
		test.updateClose();
	}
}
