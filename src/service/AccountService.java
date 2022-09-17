package service;

import java.sql.SQLException;
import java.util.List;

import dto.Account;
import dto.AccountState;

public interface AccountService {
	/**
	 * 계좌 개설
	 * @param: Account
	 * @return: Account
	 * */
	public Account insertAccount(Account account) throws SQLException;
	
	/**
	 * 계좌 상태 변경
	 * @param: Account
	 * @return: int(1일 경우 성공, 아닐 경우 실패)
	 * */
	public int updateAccountState(Account account) throws SQLException;
	
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
	 * @param: String id, boolean state(true일 경우 사용 중 계좌만, false일 경우 모든 계좌)
	 * @return: List<Account>
	 * */
	public List<Account> findById(String id, boolean state) throws SQLException;
	
	/**
	 * 계좌 상태 아이디로 계좌 상태 검색
	 * @param: int stateId
	 * @return: AccountState
	 * */
	public AccountState findByStateId(int stateId) throws SQLException;
}