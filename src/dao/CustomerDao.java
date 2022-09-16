package dao;

import java.sql.SQLException;
import java.util.List;

import dto.Customer;

public interface CustomerDao {
	/**
	 * 회원가입
	 * : 회원 정보를 받아 회원 리스트에 저장
	 * @param: Customer
	 * @return: Customer
	 * */
	public Customer signup(Customer customer) throws SQLException;

	/**
	 * 아이디 찾기
	 * : 회원 정보에 입력받은 아이디와 일치하는 정보가 있을 경우 리턴
	 * @param: String id
	 * @return: Customer
	 * */
	public Customer findById(String id) throws SQLException;
	
	/**
	 * 모든 회원 검색
	 * : 회원 테이블에 있는 모든 회원을 가져옴
	 * @return: List<Customer>
	 * */
	public List<Customer> findAll() throws SQLException;
	
	/**
	 * 등급별 회원 검색
	 * */
	public List<Customer> 
}
