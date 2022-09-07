package controller;

import dto.Customer;
import exception.DiscrepancyException;
import exception.DuplicationException;
import service.CustomerService;
import service.CustomerServiceImpl;
import session.Session;
//import session.SessionSet;
import view.FailView;
import view.Menu;
import view.SucceessView;

public class CustomerController {
	private CustomerService customerService = new CustomerServiceImpl();
	private Session session = Session.getInstance();
	
	public void signup(Customer customer, String checkPwd) {
		try {
			Customer signupedCustomer = customerService.signup(customer, checkPwd);
			SucceessView.printSignup(signupedCustomer);
		} catch (DuplicationException e) {
			FailView.printErrorMessage(e);
//			e.printStackTrace();
		} catch (DiscrepancyException e) {
			FailView.printErrorMessage(e);
//			e.printStackTrace();
		}
	}
	
	public void login(Customer customer) {
		try {
			Customer loginUser = customerService.login(customer);
			
			session.setAttribute("loginUser", loginUser);
			new Menu().userMenu();
		} catch (DiscrepancyException e) {
			FailView.printErrorMessage(e);
//			e.printStackTrace();
		}
	}
	
	public void logout() {
		session.removeAttribute("loginUser");
	}
}
