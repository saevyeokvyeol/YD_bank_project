package service;

import java.sql.SQLException;
import java.util.List;

import dto.Account;
import dto.AccountState;
import exception.DiscrepancyException;
import exception.NotExistRecodeException;

public interface AccountService {
	/**
	 * 계좌 개설
	 * @param: String id
	 * */
	public void insertAccount(String id) throws SQLException;
	
	/**
	 * 계좌 상태 변경
	 * @param: int accountId
	 * */
	public void updateAccountState(int accountId) throws SQLException, NotExistRecodeException, DiscrepancyException;
	
	/**
	 * 전체 계좌 검색
	 * @return: List<Account>
	 * */
	public List<Account> findAll() throws SQLException;

	/**
	 * 계좌 번호로 계좌 검색
	 * @param: int accountId
	 * @return: Account
	 * */
	public Account findByAccountid(int accountId) throws SQLException;

	/**
	 * 회원 아이디로 계좌 검색
	 * @param: String id, boolean state(true일 경우 사용 중 계좌만, false일 경우 모든 계좌)
	 * @return: List<Account>
	 * */
	public List<Account> findById(String id, boolean state) throws SQLException;
}