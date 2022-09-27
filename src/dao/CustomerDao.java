package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dto.Customer;
import dto.Grade;

public interface CustomerDao {
	/**
	 * 회원가입
	 * : 회원 정보를 받아 회원 리스트에 저장
	 * @param: Customer
	 * @return: Customer
	 * */
	public Customer signup(Customer customer) throws SQLException;

	/**
	 * 총 예치액 출금 처리
	 * @param: Connection con, String id, Long amount
	 * @return: int
	 * */
	public int withdraw(Connection con, String id, Long amount) throws SQLException;
	
	/**
	 * 총 예치액 입금 처리
	 * @param: Connection con, String id, Long amount
	 * @return: int
	 * */
	public int deposit(Connection con, String id, Long amount) throws SQLException;

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
	 * 키워드로 회원 검색
	 * : 회원 테이블에 있는 회원 중 키워드 검색에 걸리는 회원을 가져옴
	 * @param: int field(검색 컬럼), String keyword(검색 키워드)
	 * @return: List<Customer>
	 * */
	public List<Customer> findByKeyword(int field, String keyword) throws SQLException;
	
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
	public List<Customer> findByGrade(int gradeId) throws SQLException;
	
	/**
	 * 등급 아이디로 회원 등급 검색
	 * : 등급 테이블에서 특정 등급 가져오기
	 * @param: int gradeId
	 * @return: Grade
	 * */
	public Grade findByGradeId(int gradeId) throws SQLException;
	
	/**
	 * 회원의 등급 수정
	 * @param: String id, Long totalBalance
	 * @return: int
	 * */
	public int updateCustomerGrade(Connection con, String id, Long totalBalance) throws SQLException;
}