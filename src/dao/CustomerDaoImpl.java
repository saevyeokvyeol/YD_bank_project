package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Customer;

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
	 * 로그인
	 * : 입력받은 로그인 정보를 회원 정보와 비교해 맞을 경우 로그인
	 * @param: Customer
	 * @return: Customer
	 * */
	@Override
	public Customer login(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(String id) {
		Customer customer = null;
		
		for (Customer C : customers) {
			if(id.equals(C.getId())) customer = C;
		}
		
		return customer;
	}
	
}
