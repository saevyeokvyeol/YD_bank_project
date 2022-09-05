package test;

import controller.CustomerController;
import dto.Customer;

public class CostomerTest {
	private CustomerController controller = new CustomerController();
	
	public void signupTest() {
		Customer customer = new Customer("yuda", "1234", "김유다");
		
		System.out.println("성공");
		controller.signup(customer, customer.getPassword());
		
		System.out.println("\n실패: 아이디 중복");
		controller.signup(customer, customer.getPassword());
		
		customer = new Customer("yuhyun", "1234", "김유현");

		System.out.println("\n실패: 비밀번호 불일치");
		controller.signup(customer, "1224");

		System.out.println("\n성공");
		controller.signup(customer, customer.getPassword());
	}
	
	public static void main(String[] args) {
		CostomerTest test = new CostomerTest();
		test.signupTest();
	}
}
