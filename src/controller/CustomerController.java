package controller;

import dto.Customer;
import exception.DiscrepancyException;
import exception.DuplicationException;
import service.CustomerService;
import service.CustomerServiceImpl;
import view.FailView;
import view.SucceessView;

public class CustomerController {
	private CustomerService customerService = new CustomerServiceImpl();
	
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
}
