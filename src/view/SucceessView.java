package view;

import java.text.DecimalFormat;
import java.util.List;

import dto.Account;
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
	
	public static String getDate(String date) {
		return date.substring(0, 10);
	}
	
	public static void printMessage(String message) {
		System.out.println("\n" + message);
	}
	
	public static void printCustomers(List<Customer> customers) {
		System.out.println("\n아이디\t이름\t가입일");
		for (Customer c : customers) {
			System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getSignupDate());
		}
	}
	
	public static void printCustomerInfo(Customer customer) {

		System.out.println("\n- " + customer.getName() + " 님의 상세 정보");
		System.out.println("\n아이디: " + customer.getId());
		System.out.println("\n이름: " + customer.getName());
		System.out.println("전화 번호: " + getTel(customer.getTel()));
		System.out.println("가입일: " + customer.getSignupDate().substring(0, 10));
		System.out.println("\n등급: " + customer.getGrade().getGradeName());
		System.out.println("총 잔고: " + won.format(customer.getTotalBalance()) + "원");
		if (customer.getGradeId() != 6) {
			System.out.println("다음 등급까지 남은 금액: " + won.format(customer.getGrade().getGradeMaximum() + 1 - customer.getTotalBalance()) + "원");
		}
	}
	
	public static void printAccount(String message, Customer customer, List<Account> accounts) {
		printMessage(message);
		
		if (accounts.size() == 0) {
			System.out.println("개설된 계좌가 없습니다.\n계좌를 개설해주세요.");
		} else {
			System.out.println("계좌 번호\t잔액\t\t개설일\t\t최근 거래일");
			for (Account account : accounts) {
				System.out.print(account.getAccountId() + "\t\t" + won.format(account.getBalance()));
				if (account.getBalance() >= 100000) {
					System.out.print("\t");
				} else {
					System.out.print("\t\t");
				}
				System.out.println(getDate(account.getOpenDate()) + "\t" + getDate(account.getUpdateDate()));
			}
		}
	}
}
