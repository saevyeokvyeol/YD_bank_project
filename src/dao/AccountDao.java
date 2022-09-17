package dao;

import java.sql.SQLException;
import java.util.List;

import dto.Account;

public interface AccountDao {
	/**
	 * 계좌 개설
	 * @param: Account
	 * @return: Account
	 * */
	public Account insertAccount(Account account) throws SQLException;
	
	/**
	 * 전체 계좌 검색
	 * @return: List<Account>
	 * */
	public List<Account> findAll() throws SQLException;

	/**
	 * 계좌 번호로 계좌 검색
	 * @param: String accountId
	 * @return: Account
	 * */
	public Account findByAccountid(String accountId) throws SQLException;

	/**
	 * 회원 아이디로 계좌 검색
	 * @param: String id
	 * @return: List<Account>
	 * */
	public List<Account> findById(String id) throws SQLException;
	
	/**
	 * 계좌 상태 아이디로 계좌 상태 검색
	 * @param: int stateId
	 * @return: accountState
	 * */
}