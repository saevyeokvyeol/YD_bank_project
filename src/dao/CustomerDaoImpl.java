package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Customer;
import service.CustomerService;

public class CustomerDaoImpl implements CustomerDao {
	private List<Customer> customers = new ArrayList<Customer>();

	/**
	 * 회원가입
	 * : 회원 정보를 받아 회원 리스트에 저장
	 * @param: Customer
	 * @return: Customer
	 * */
	@Override
	public Customer signup(Customer customer) {
		customers.add(customer);
		return customer;
	}

	/**
	 * 아이디 찾기
	 * : 회원 정보에 입력받은 아이디와 일치하는 정보가 있을 경우 리턴
	 * @param: String id
	 * @return: Customer
	 * */
	@Override
	public Customer findById(String id) {
		Customer customer = null;
		
		for (Customer C : customers) {
			if(id.equals(C.getId())) customer = C;
		}
		
		return customer;
	}
	
}
