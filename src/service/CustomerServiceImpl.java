package service;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import dto.Customer;
import exception.DiscrepancyException;
import exception.DuplicationException;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = new CustomerDaoImpl();
	
	/**
	 * 회원가입
	 * : 회원 정보를 받아 회원 리스트에 저장
	 * @param: Customer, String checkPwd
	 * @return: Customer
	 * */
	@Override
	public Customer signup(Customer customer, String checkPwd) throws DuplicationException, DiscrepancyException {
		if (customerDao.findById(customer.getId()) != null) {
			throw new DuplicationException("아이디가 중복되었습니다.\n다른 아이디를 입력해주세요.");
		}
		
		if (!customer.getPassword().equals(checkPwd)) {
			throw new DiscrepancyException("비밀번호와 비밀번호 확인이 일치하지 않습니다.\n다시 입력해주세요.");
		}
		
		return customerDao.signup(customer);
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

}
