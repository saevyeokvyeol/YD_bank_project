package controller;

import java.sql.SQLException;

import dto.Customer;
import exception.DoNotLoginException;
import service.AccountService;
import service.AccountServiceImpl;
import session.Session;
import view.FailView;
import view.SucceessView;

public class AccountController {
	private AccountService accountService = new AccountServiceImpl();
	private Session session = Session.getInstance();

	public void insertAccount() {
		try {
			Customer customer = (Customer) session.getAttribute("loginUser");
			
			if (customer == null) throw new DoNotLoginException("YD뱅크 회원만 계좌 개설이 가능합니다.\n로그인 후 이용해주세요");
			
			accountService.insertAccount(customer.getId());
			SucceessView.printMessage("계좌가 개설되었습니다.");
		} catch (Exception e) {
//			e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}
}
