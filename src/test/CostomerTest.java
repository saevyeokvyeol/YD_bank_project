package test;

import controller.CustomerController;
import dto.Customer;

public class CostomerTest {
	private CustomerController controller = new CustomerController();
	
	public void signupTest() {
		Customer customer = new Customer("yuda", "1234", "������");
		
		System.out.println("����");
		controller.signup(customer, customer.getPassword());
		
		System.out.println("\n����: ���̵� �ߺ�");
		controller.signup(customer, customer.getPassword());
		
		customer = new Customer("yuhyun", "1234", "������");

		System.out.println("\n����: ��й�ȣ ����ġ");
		controller.signup(customer, "1224");

		System.out.println("\n����");
		controller.signup(customer, customer.getPassword());
	}
	
	public static void main(String[] args) {
		CostomerTest test = new CostomerTest();
		test.signupTest();
	}
}
