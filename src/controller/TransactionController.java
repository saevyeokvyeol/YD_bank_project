package controller;

import dto.Customer;
import dto.Transaction;
import service.TransactionService;
import service.TransactionServiceImpl;
import session.Session;
import view.FailView;
import view.SucceessView;

public class TransactionController {
	private TransactionService transactionService = new TransactionServiceImpl();
	private Session session = Session.getInstance();
	
	public void insertTransaction(Transaction transaction) {
		try {
			Customer customer = (Customer) session.getAttribute("loginUser");
			transaction.setCustomer(customer);
			transactionService.insertTransaction(transaction);
			SucceessView.printMessage("거래가 완료되었습니다.");
			SucceessView.printTransaction(transaction);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}
}
