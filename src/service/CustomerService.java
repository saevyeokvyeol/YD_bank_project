package service;

import java.sql.SQLException;
import java.util.List;

import dto.Customer;
import dto.Grade;
import exception.DiscrepancyException;
import exception.DuplicationException;

public interface CustomerService {
	/**
	 * 회원가입
	 * : 회원 정보를 받아 회원 리스트에 저장
	 * @param: Customer, String checkPwd
	 * @return: Customer
	 * */
	public Customer signup(Customer customer, String checkPwd) throws DuplicationException, DiscrepancyException, SQLException;

	/**
	 * 로그인
	 * : 입력받은 로그인 정보를 회원 정보와 비교해 맞을 경우 로그인
	 * @param: Customer
	 * @return: Customer
	 * */
	public Customer login(Customer customer) throws DiscrepancyException, SQLException;

	/**
	 * 모든 회원 검색
	 * : 회원 테이블에 있는 모든 회원을 가져옴
	 * @return: List<Customer>
	 * */
	public List<Customer> findAll() throws SQLException;
	
	/**
	 * 키워드로 회원 검색
	 * : 회원 테이블에 있는 회원 중 키워드 검색에 걸리는 회원을 가져옴
	 * @param: String field(검색 컬럼), String keyword(검색 키워드)
	 * @return: List<Customer>
	 * */
	public List<Customer> findByKeyword(String field, String keyword) throws SQLException;
	
	/**
	 * 계좌로 회원 검색
	 * : 특정 계좌를 소유하고 있는 회원 검색
	 * @param: int accountId
	 * @return: Customer
	 * */
	public Customer findByAccountId(int accountId) throws SQLException;
	
	/**
	 * 등급별 회원 검색
	 * : 회원 테이블의 회원 중 특정 등급의 회원만 가져옴
	 * @param: int gradeId
	 * @return: List<Customer>
	 * */
	public List<Customer> findByGrade(int grade) throws SQLException;
	
	/**
	 * 등급 아이디로 회원 등급 검색
	 * : 등급 테이블에서 특정 등급 가져오기
	 * @param: int gradeId
	 * @return: Grade
	 * */
	public Grade findByGradeId(int gradeId) throws SQLException;
}
