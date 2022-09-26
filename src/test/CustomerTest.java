package test;

import controller.CustomerController;
import dto.Customer;
import session.Session;

public class CustomerTest {
	private CustomerController controller = new CustomerController();
	private TestUtil util = new TestUtil();
	
	public void signupTest() {
		controller.findAll();
		
		Customer customer = new Customer("rang", "8080", "김파랑", "01000000000");
		
		System.out.println("* 성공");
		controller.signup(customer, customer.getPassword());
		
		System.out.println("\n* 실패: 아이디 중복");
		controller.signup(customer, customer.getPassword());
		
		customer = new Customer("gang", "8989", "김빨강", "01011111111");

		System.out.println("\n* 실패: 비밀번호 불일치");
		controller.signup(customer, "8888");

		System.out.println("\n* 성공");
		controller.signup(customer, customer.getPassword());
		
		controller.findAll();
		
		util.delete("delete from customer where id in ('rang', 'gang')");
	}
	
	public void loginTest() {
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

		System.out.println("\n* 성공: 일반 고객");
		controller.login(new Customer("yuda", "1234"));
		loginUser = (Customer)session.getAttribute("loginUser");
		if (loginUser != null) {
			System.out.println(loginUser.getName() + " 로그인 성공");
		}

		System.out.println("\n* 성공: 관리자");
		controller.login(new Customer("admin", "admin"));
		loginUser = (Customer)session.getAttribute("loginUser");
		if (loginUser != null) {
			System.out.println(loginUser.getName() + " 로그인 성공");
		}
	}
	
	public void customerIntoTest() {
		System.out.println("실패: 없는 아이디");
		controller.customerInfo("yyyy");
		
		System.out.println("---------------");
		
		System.out.println("성공: 있는 아이디, Prestige 등급");
		controller.customerInfo("yuda");
		
		System.out.println("---------------");
		
		System.out.println("성공: 있는 아이디, Honor 등급");
		controller.customerInfo("mina");
	}
	
	public static void main(String[] args) {
		CustomerTest test = new CustomerTest();
//		test.signupTest();
		test.loginTest();
//		test.customerIntoTest();
	}
}
