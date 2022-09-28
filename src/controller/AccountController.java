package controller;

import java.sql.SQLException;
import java.util.List;

import dto.Account;
import dto.Customer;
import exception.DoNotLoginException;
import service.AccountService;
import service.AccountServiceImpl;
import session.Session;
import view.FailView;
import view.SuccessView;

public class AccountController {
	private AccountService accountService = new AccountServiceImpl();
	private Session session = Session.getInstance();

	public void insertAccount() {
		try {
			Customer customer = (Customer) session.getAttribute("loginUser");
			
			if (customer == null) throw new DoNotLoginException("YD뱅크 회원만 계좌 개설이 가능합니다.\n로그인 후 이용해주세요");
			
			accountService.insertAccount(customer.getId());
			SuccessView.printMessage("계좌가 개설되었습니다.");
		} catch (Exception e) {
//			e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}
	
	public void findAll() {
		try {
			List<Account> accounts = accountService.findAll();
			SuccessView.printFindAccountAll(accounts);
		} catch (Exception e) {
			// e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}

	public void findById(boolean state) {
		try {
			Customer customer = (Customer)session.getAttribute("loginUser");
			List<Account> accounts = accountService.findById(customer.getId(), state);
			SuccessView.printFindAccountById((Customer)session.getAttribute("loginUser"), accounts);
		} catch (SQLException e) {
			// e.printStackTrace();
			FailView.printErrorMessage(e);
		}	
	}
	
	public void findByAccountId(int accountId) {
		try {
			Account account = accountService.findByAccountid(accountId);
			SuccessView.printFindAccountByAccountId(accountId, account);
		} catch (Exception e) {
			// e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}
	
	public void updateClose(int accountId) {
		try {
			accountService.updateAccountState(accountId);
			SuccessView.printMessage(accountId + " 계좌가 해지되었습니다.");
		} catch (Exception e) {
			// e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}
	
}
