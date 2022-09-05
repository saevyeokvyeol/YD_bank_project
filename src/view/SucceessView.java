package view;

import dto.Customer;

public class SucceessView {
	public static void printSignup(Customer customer) {
		System.out.println("\n" + customer.getName() + "님, 가입이 완료되었습니다.\n로그인 후 서비스를 이용해주세요.");
	}
}
