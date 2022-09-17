package service;

import java.sql.SQLException;
import java.util.List;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import dto.Customer;
import dto.Grade;
import exception.DiscrepancyException;
import exception.DuplicationException;
import exception.NotExistRecodeException;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = new CustomerDaoImpl();

	/**
	 * 회원가입
	 * : 회원 정보를 받아 회원 리스트에 저장
	 * @param: Customer, String checkPwd
	 * @return: Customer
	 * @throws SQLException 
	 * */
	@Override
	public Customer signup(Customer customer, String checkPwd) throws DuplicationException, DiscrepancyException, SQLException {
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
	 * @throws SQLException 
	 * */
	@Override
	public Customer login(Customer customer) throws DiscrepancyException, SQLException {
		Customer dbCustomer = customerDao.findById(customer.getId());
		
		if(dbCustomer == null || !dbCustomer.getPassword().equals(customer.getPassword())) {
			throw new DiscrepancyException("아이디 혹은 비밀번호가 올바르지 않습니다.");
		}
		
		return dbCustomer;
	}
	
	/**
	 * 모든 회원 검색
	 * : 회원 테이블에 있는 모든 회원을 가져옴
	 * @return: List<Customer>
	 * */
	@Override
	public List<Customer> findAll() throws SQLException {
		List<Customer> customers = customerDao.findAll();
		return customers;
	}

	/**
	 * 아이디로 회원 정보 검색
	 * : 회원 아이디로 회원 정보 검색
	 * @param: String id
	 * @return: Customer
	 * */
	public Customer customerInfo(String id) throws SQLException, NotExistRecodeException {
		Customer customer = customerDao.findById(id);
		if (customer == null) throw new NotExistRecodeException("회원 정보 검색에 오류가 발생해 관련 정보를 가져올 수 없습니다.");
		
		Grade grade = customerDao.findByGradeId(customer.getGradeId());
		if (grade == null) throw new NotExistRecodeException("등급 산정에 오류가 발생해 관련 정보를 가져올 수 없습니다.");
		customer.setGrade(grade);
		
		return customer;
	}

	/**
	 * 키워드로 회원 검색
	 * : 회원 테이블에 있는 회원 중 키워드 검색에 걸리는 회원을 가져옴
	 * @param: String field(검색 컬럼), String keyword(검색 키워드)
	 * @return: List<Customer>
	 * */
	@Override
	public List<Customer> findByKeyword(String field, String keyword) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 계좌로 회원 검색
	 * : 특정 계좌를 소유하고 있는 회원 검색
	 * @param: int accountId
	 * @return: Customer
	 * */
	@Override
	public Customer findByAccountId(int accountId) throws SQLException, NotExistRecodeException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 등급별 회원 검색
	 * : 회원 테이블의 회원 중 특정 등급의 회원만 가져옴
	 * @param: int gradeId
	 * @return: List<Customer>
	 * */
	@Override
	public List<Customer> findByGrade(int grade) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
