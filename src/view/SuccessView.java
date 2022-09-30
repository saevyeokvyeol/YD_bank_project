package view;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import dto.Account;
import dto.Customer;
import dto.Grade;
import dto.Statistics;
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
	
	public static void printFindByKeyword(int field, String keyword, List<Customer> customers) {
		String searchField = null;
		switch (field) {
		case 1:
			searchField = "아이디";
			break;
		case 2:
			searchField = "이름";
			break;
		case 3:
			searchField = "전화번호";
			break;
		case 4:
			searchField = "계좌번호";
			break;
		}
		System.out.println("\n< " + searchField + " '" + keyword + "' 검색 결과: 총 " + customers.size() + "명>");
		printCustomers(customers);
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

		System.out.println("\n< " + customer.getName() + " 님의 상세 정보 >");
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
	
	public static void printFindAccountAll(List<Account> accounts) {
		System.out.println("\n< 전체 계좌 목록 : 총 " + accounts.size() + "개 >");
		printAccounts(accounts);
	}
	
	public static void printFindAccountByAccountId(int accountId, Account account) {
		
		System.out.print("\n< 계좌 번호 '" + accountId + "' 검색 결과");
		if (account == null) {
			System.out.println(": 입력한 계좌 번호와 일치하는 정보가 존재하지 않습니다 >");
		} else {
			System.out.println(" >");
			System.out.println("아이디\t계좌 번호\t잔액\t\t\t개설일\t\t최근 거래일");
			System.out.print(account.getId() + "\t" + account.getAccountId() + "\t\t" + won.format(account.getBalance()) + "원\t");
			if (account.getBalance() <= 10000000000L) {
				System.out.print("\t");
			}
			System.out.print(getDate(account.getOpenDate()) + "\t" + getDate(account.getUpdateDate()));
			if (account.getStateId() == 2) System.out.println("\t해지");
			else System.out.println();
		}				
	}
	
	public static void printFindAccountById(Customer customer, List<Account> accounts) {
		System.out.println("\n< " + customer.getName() + " 님의 계좌 목록: 총 " + accounts.size() + "개 >");
		printAccounts(accounts);
	}
	
	public static void printAccounts(List<Account> accounts) {
		
		if (accounts.size() == 0) {
			System.out.println("계좌 목록이 존재하지 않습니다.");
		} else {
			System.out.println("아이디\t계좌 번호\t잔액\t\t\t개설일\t\t최근 거래일");
			for (Account account : accounts) {
				System.out.print(account.getId() + "\t" + account.getAccountId() + "\t\t" + won.format(account.getBalance()) + "원\t");
				if (account.getBalance() < 10000) {
					System.out.print("\t\t");
				} else if (account.getBalance() < 10000000000L) {
					System.out.print("\t");
				}
				System.out.print(getDate(account.getOpenDate()) + "\t" + getDate(account.getUpdateDate()));
				if (account.getStateId() == 2) System.out.println("\t해지");
				else System.out.println();
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
	
	public static void printfindTransactionAll(List<Transaction> transactions) {
		System.out.println("\n< YD뱅크 전체 거래 내역: 총 " + transactions.size() + "건 >");
		printTransactions(transactions);
	}
	
	public static void printTransactionsFindById(Customer customer, List<Transaction> transactions) {
		System.out.println("\n< " + customer.getName() + " 님의 거래 내역 >");
		printTransactions(transactions);
	}
	
	public static void printTransactionsFindByAccountId(int accountId, List<Transaction> transactions) {
		System.out.println("\n< 계좌 번호 '" + accountId + "' 거래 내역 >");
		printTransactions(transactions);
	}
	
	public static void printTransactionsFindByTransactionId(int transactionId, List<Transaction> transactions) {
		System.out.println("\n< 거래 번호 '" + transactionId + "' 거래 내역 >");
		printTransactions(transactions);
	}
	
	public static void printFindTransactionByToday(List<Transaction> transactions) {
		System.out.println("\n< " + LocalDate.now() + " 거래 내역 >");
		printTransactions(transactions);
	}
	
	public static void printTransactions(List<Transaction> transactions) {
		if (transactions.size() == 0) {
			System.out.println("거래 내역이 존재하지 않습니다.");
		} else {
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
	
	public static void printStatisticsSummary(Map<String, Long> map) {
		System.out.println("\n< YD뱅크 전체 통계 요약 >");
		System.out.println("전체 회원: " + map.get("totalCustomer") + "명");
		System.out.println("오늘 가입 회원: " + map.get("todayCustomer") + "명");
		System.out.println("\n전체 예치금: " + won.format(map.get("totalBalance")) + "원");
		System.out.println("\n전체 거래 횟수: " + map.get("totalTransactionCount") + "건");
		System.out.println("전체 거래액: " + won.format(map.get("totalTransactionAmount")) + "원");
		System.out.println("오늘 거래 횟수: " + map.get("totalTransactionTodayCount") + "건");
		System.out.println("오늘 거래액: " + won.format(map.get("totalTransactionTodayAmount")) + "원");
	}
	
	public static void printTransactionCount(List<Statistics> statistics) {
		System.out.println("\n< YD뱅크 회원 거래 횟수 통계 >");
		if (statistics.size() == 0) {
			System.out.println("거래 내역이 존재하지 않아 통계를 가져올 수 없습니다.");
		} else {
			int score = 0;
			System.out.println("\t아이디\t거래자명\t등급\t\t가입일\t\t\t거래 횟수");
			for (Statistics s : statistics) {
				System.out.print(++score + "\t" + s.getCustomer().getId() + "\t" + s.getCustomer().getName() + "\t\t" + s.getCustomer().getGrade().getGradeName() + "\t");
				if (s.getCustomer().getGrade().getGradeName().length() < 8) System.out.print("\t"); 
				System.out.println(s.getCustomer().getSignupDate() + "\t" + s.getValue() + "건");
			}
		}
	}
	
	public static void printTransactionAmount(List<Statistics> statistics) {
		System.out.println("\n< YD뱅크 회원 거래 액수 통계 >");
		if (statistics.size() == 0) {
			System.out.println("거래 내역이 존재하지 않아 통계를 가져올 수 없습니다.");
		} else {
			int score = 0;
			System.out.println("\t아이디\t거래자명\t등급\t\t가입일\t\t\t거래액");
			for (Statistics s : statistics) {
				System.out.print(++score + "\t" + s.getCustomer().getId() + "\t" + s.getCustomer().getName() + "\t\t" + s.getCustomer().getGrade().getGradeName() + "\t");
				if (s.getCustomer().getGrade().getGradeName().length() < 8) System.out.print("\t"); 
				System.out.println(s.getCustomer().getSignupDate() + "\t" + won.format(s.getValue()) + "원");
			}
		}
	}
}
