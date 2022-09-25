package controller;

import java.util.List;

import dto.Customer;
import dto.Transaction;
import exception.DoNotLoginException;
import service.TransactionService;
import service.TransactionServiceImpl;
import session.Session;
import view.FailView;
import view.SuccessView;

public class TransactionController {
	private TransactionService transactionService = new TransactionServiceImpl();
	private Session session = Session.getInstance();
	
	public void insertTransaction(Transaction transaction) {
		try {
			Customer customer = (Customer) session.getAttribute("loginUser");
			if (customer == null) throw new DoNotLoginException("로그인 후 이용해주세요.");
			transaction.setCustomer(customer);
			transactionService.insertTransaction(transaction);
			SuccessView.printMessage("거래가 완료되었습니다.");
			SuccessView.printTransaction(transaction);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}
	
	public void findById(String id) {
		try {
			if (id == null) {
				Customer customer = (Customer) session.getAttribute("loginUser");
				if (customer == null) throw new DoNotLoginException("로그인 후 이용해주세요.");
				id = customer.getId();
			}
			List<Transaction> transactions = transactionService.findById(id);
			SuccessView.printTransactionsFindById(transactions);
		} catch (Exception e) {
			FailView.printErrorMessage(e);
		}
	}
}
