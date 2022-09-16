package view;

import java.util.List;

import dto.Customer;

public class SucceessView {
	public static void printSignup(Customer customer) {
		System.out.println("\n" + customer.getName() + "님, 가입이 완료되었습니다.\n로그인 후 서비스를 이용해주세요.");
	}
	
	public static void printCustomers(List<Customer> customers) {
		System.out.println("\n아이디\t이름\t가입일");
		for (Customer c : customers) {
			System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getSignupDate());
		}
		
	}
}
