package controller;

import java.util.List;

import dto.Customer;
import dto.Grade;
import exception.DiscrepancyException;
import exception.DuplicationException;
import service.CustomerService;
import service.CustomerServiceImpl;
import session.Session;
//import session.SessionSet;
import view.FailView;
import view.Menu;
import view.SuccessView;

public class CustomerController {
	private CustomerService customerService = new CustomerServiceImpl();
	private Session session = Session.getInstance();
	
	public void signup(Customer customer, String checkPwd) {
		try {
			Customer signupedCustomer = customerService.signup(customer, checkPwd);
			SuccessView.printMessage(signupedCustomer.getName() + "님, 가입이 완료되었습니다.\n로그인 후 서비스를 이용해주세요.");
		} catch (Exception e) {
			FailView.printErrorMessage(e);
//			e.printStackTrace();
		}
	}
	
	public void login(Customer customer) {
		try {
			Customer loginUser = customerService.login(customer);
			session.setAttribute("loginUser", loginUser);
			if (loginUser.getId().equals("admin") && loginUser.getPassword().equals("admin")) {
				new Menu().adminMenu();
			} else {
				SuccessView.printMessage("< YD은행에 오신 것을 환영합니다, " + loginUser.getName() + "님 >");
				new Menu().userMenu();
			}
		} catch (Exception e) {
			FailView.printErrorMessage(e);
//			e.printStackTrace();
		}
	}
	
	public void logout() {
		SuccessView.printMessage("< " + ((Customer)session.getAttribute("loginUser")).getName() + "님은 로그아웃 되었습니다 >");
		session.removeAttribute("loginUser");
	}
	
	public void findAll() {
		try {
			List<Customer> customers = customerService.findAll();
			SuccessView.printCustomers(customers);
		} catch (Exception e) {
			FailView.printErrorMessage(e);
		}
	}
	
	public void findByGrade(int gradeId) {
		try {
			Grade grade = customerService.findByGrade(gradeId);
			SuccessView.printFindByGrade(grade);
		} catch (Exception e) {
			FailView.printErrorMessage(e);
//			e.printStackTrace();
		}
	}
	
	public void findByKeyword(int field, String keyword) {
		try {
			List<Customer> customers = customerService.findByKeyword(field, keyword);
			SuccessView.printFindByKeyword(field, keyword, customers);
		} catch (Exception e) {
			FailView.printErrorMessage(e);
			e.printStackTrace();
		}
	}
	
	public void customerInfo() {
		try {
			Customer sessionCustomer = (Customer)session.getAttribute("loginUser");
			Customer customer = customerService.customerInfo(sessionCustomer.getId());
			SuccessView.printCustomerInfo(customer);
		} catch (Exception e) {
//			e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}
	
	public void customerInfo(String id) {
		try {
			Customer customer = customerService.customerInfo(id);
			SuccessView.printCustomerInfo(customer);
		} catch (Exception e) {
//			e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}
}
