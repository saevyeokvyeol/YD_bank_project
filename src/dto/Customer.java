package dto;

import java.util.List;

public class Customer {
	private String id;
	private String password;
	private String name;
	private String tel;
	private int gradeId;
	private String signupDate;
	private String updateDate;
	private Long totalBalance;
	
	private Grade grade;
	private List<Account> accounts;
	private List<Transaction> transactions;
	
	public Customer() {}

	public Customer(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public Customer(String id, String password, String name, String tel) {
		this(id, password);
		this.name = name;
		this.tel = tel;
	}

	public Customer(String id, String password, String name, String tel, int gradeId, String signupDate, String updateDate, Long totalBalance) {
		this(id, password, name, tel);
		this.gradeId = gradeId;
		this.signupDate = signupDate;
		this.updateDate = updateDate;
		this.totalBalance = totalBalance;
	}
	
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
	
	public String getTel() {
		return tel;
	}
	
	public int getGradeId() {
		return gradeId;
	}

	public String getSignupDate() {
		return signupDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public Long getTotalBalance() {
		return totalBalance;
	}
	
	public Grade getGrade() {
		return grade;
	}
	
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	public void setTransactions(List<Account> accounts) {
		this.accounts = accounts;
	}
}
