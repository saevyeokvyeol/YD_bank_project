package view;

import java.text.DecimalFormat;
import java.util.List;

import dto.Customer;

public class SucceessView {
	private static DecimalFormat won = new DecimalFormat("#,###");
	
	public static String getTel(String tel) {
		StringBuffer sb = new StringBuffer();
		sb.append(tel);
		sb.insert(3, '-');
		sb.insert(8, '-');
		return sb.toString();
	}
	
	public static void printSignup(Customer customer) {
		System.out.println("\n" + customer.getName() + "님, 가입이 완료되었습니다.\n로그인 후 서비스를 이용해주세요.");
	}
	
	public static void printCustomers(List<Customer> customers) {
		System.out.println("\n아이디\t이름\t가입일");
		for (Customer c : customers) {
			System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getSignupDate());
		}
	}
	
	public static void printCustomerInfo(Customer customer) {

		System.out.println("\n- " + customer.getId() + " 님의 상세 정보");
		System.out.println("\n이름: " + customer.getName());
		System.out.println("전화 번호: " + getTel(customer.getTel()));
		System.out.println("가입일: " + customer.getSignupDate().substring(0, 10));
		System.out.println("\n등급: " + customer.getGrade().getGradeName());
		System.out.println("총 잔고: " + won.format(customer.getTotalBalance()) + "원");
		if (customer.getGradeId() != 6) {
			System.out.println("다음 등급까지 남은 금액: " + won.format(customer.getGrade().getGradeMaximum() + 1 - customer.getTotalBalance()) + "원");
		}
	}
}
