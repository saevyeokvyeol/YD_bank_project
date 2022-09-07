package test;

import controller.CustomerController;
import dto.Customer;
import session.Session;

public class CustomerTest {
	private CustomerController controller = new CustomerController();
	
	public void signupTest() {
		Customer customer = new Customer("yuda", "1234", "김유다");
		
		System.out.println("* 성공");
		controller.signup(customer, customer.getPassword());
		
		System.out.println("\n* 실패: 아이디 중복");
		controller.signup(customer, customer.getPassword());
		
		customer = new Customer("yuhyun", "1234", "김유현");

		System.out.println("\n* 실패: 비밀번호 불일치");
		controller.signup(customer, "1224");

		System.out.println("\n* 성공");
		controller.signup(customer, customer.getPassword());
	}
	
	public void loginTest() {
		Customer customer = new Customer("yuda", "1234", "김유다");
		controller.signup(customer, customer.getPassword());
		
		Session session = Session.getInstance();
		
		System.out.println("\n* 실패: 아이디 불일치");
		Customer wrongCustomer = new Customer("yuhyun", "1234");
		controller.login(wrongCustomer);
		Customer loginUser = (Customer)session.getAttribute("loginUser");
		if (loginUser != null) {
			System.out.println(loginUser.getName() + " 로그인 성공");
		}

		System.out.println("\n* 실패: 비밀번호 불일치");
		wrongCustomer = new Customer("yuda", "1224");
		controller.login(wrongCustomer);
		loginUser = (Customer)session.getAttribute("loginUser");
		if (loginUser != null) {
			System.out.println(loginUser.getName() + " 로그인 성공");
		}

		System.out.println("\n* 성공");
		controller.login(customer);
		loginUser = (Customer)session.getAttribute("loginUser");
		if (loginUser != null) {
			System.out.println(loginUser.getName() + " 로그인 성공");
		}
	}
	
	public static void main(String[] args) {
		CustomerTest test = new CustomerTest();
//		test.signupTest();
		test.loginTest();
	}
}
