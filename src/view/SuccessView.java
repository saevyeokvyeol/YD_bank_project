package view;

import java.text.DecimalFormat;
import java.util.List;

import dto.Account;
import dto.Customer;
import dto.Grade;
import dto.Transaction;

public class SuccessView {
	private static DecimalFormat won = new DecimalFormat("#,###");
	
	private static String getTel(String tel) {
		StringBuffer sb = new StringBuffer();
		sb.append(tel);
		sb.insert(3, '-');
		sb.insert(8, '-');
		return sb.toString();
	}
	
	private static String getDate(String date) {
		return date.substring(0, 10);
	}
	
	public static void printMessage(String message) {
		System.out.println("\n" + message);
	}
	
	public static void printFindCustomerAll(List<Customer> customers) {
		System.out.println("\n< YD뱅크 전체 회원 목록 : 총 " + customers.size() + "명 >");
		printCustomers(customers);
	}
	
	public static void printFindByGrade(Grade grade) {
		System.out.println("\n< YD뱅크 " + grade.getGradeName() + " 회원 목록 : 총 " + grade.getCustomers().size() + "명 >");
		printCustomers(grade.getCustomers());
	}
	
	public static void printCustomers(List<Customer> customers) {
		if (customers.size() == 0) {
			System.out.println("고객 목록이 존재하지 않습니다.");
		} else {
			System.out.println("\n아이디\t이름\t전화번호\t등급\t\t가입일\t\t잔고");
			for (Customer c : customers) {
				String grade = c.getGrade().getGradeName();
				System.out.print(c.getId() + "\t" + c.getName() + "\t" + getTel(c.getTel()) + "\t"+ grade + "\t");
				if (grade.length() < 8) {
					System.out.print("\t");
				}
				System.out.println(getDate(c.getSignupDate()) + "\t" + won.format(c.getTotalBalance()) + "원");
			}			
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
	
	public static void printTransaction(Transaction transaction) {
		String transactionClass = null;
		if (transaction.getTransactionClassId() == 1) {
			transactionClass = "현금 입금";
		} else if (transaction.getTransactionClassId() == 2) {
			transactionClass = "현금 출금";
		} else if (transaction.getTransactionClassId() == 3) {
			transactionClass = "계좌 이체";
		}
		
		System.out.println("\n▒▒▒▒▒ 거래 명세서 ▒▒▒▒▒");
		System.out.println("거래자명: " + transaction.getCustomer().getName());		
		System.out.println("거래 종류: " + transactionClass + "\n");
		if (transaction.getTransactionClassId() != 1) {
			System.out.println("출금 계좌: " + transaction.getWithdrawAccountId());
		}
		if (transaction.getTransactionClassId() != 2) {
			System.out.println("입금 계좌: " + transaction.getDepositAccountId());
		}
		
		System.out.println("\n거래 금액: " + won.format(transaction.getTransactionAmount()) + "원");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
	}
	
	public static void printTransactionsFindById(List<Transaction> transactions) {
		System.out.println("거래 내역");
		System.out.println("\t거래 종류\t거래자명\t출금 계좌\t입금 계좌\t거래 금액\t\t거래 일자");
		
		for (Transaction t : transactions) {
			String transactionClass = null;
			if (t.getTransactionClassId() == 1) {
				transactionClass = "현금 입금";
			} else if (t.getTransactionClassId() == 2) {
				transactionClass = "현금 출금";
			} else if (t.getTransactionClassId() == 3) {
				transactionClass = "계좌 이체";
			}
			
			System.out.print(t.getTransactionId() + "\t" + transactionClass + "\t" + t.getId() + "\t\t");
			
			if (t.getWithdrawAccountId() == 0) {
				System.out.print("ATM 출금\t");
			} else {
				System.out.print(t.getWithdrawAccountId() + "\t\t");
			}
			if (t.getDepositAccountId() == 0) {
				System.out.print("ATM 입금\t");
			} else {
				System.out.print(t.getDepositAccountId() + "\t\t");
			}
			System.out.print(won.format(t.getTransactionAmount()) + "원");
			if (t.getTransactionAmount() >= 10000) {
				System.out.print("\t\t");
			} else {
				System.out.print("\t\t\t");
			}
			System.out.println(t.getTransactionDate());
		}
	}
}
