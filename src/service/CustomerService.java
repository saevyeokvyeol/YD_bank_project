package service;

import dto.Customer;
import exception.DiscrepancyException;
import exception.DuplicationException;

public interface CustomerService {
	/**
	 * 회원가입
	 * : 회원 정보를 받아 회원 리스트에 저장
	 * @param: Customer, String checkPwd
	 * @return: Customer
	 * */
	public Customer signup(Customer customer, String checkPwd) throws DuplicationException, DiscrepancyException;

	/**
	 * 로그인
	 * : 입력받은 로그인 정보를 회원 정보와 비교해 맞을 경우 로그인
	 * @param: Customer
	 * @return: Customer
	 * */
	public Customer login(Customer customer) throws DiscrepancyException;
}
