package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Account;

public class AccountDaoImpl implements AccountDao {
	List<Account> accounts = new ArrayList<Account>();

	/**
	 * 계좌 개설
	 * @param: Account
	 * @return: Account
	 * */
	@Override
	public Account insertAccount(Account account) {
		account.createAccountId();
		account.createOpenDate();
		accounts.add(account);
		return account;
	}

	/**
	 * 계좌 번호로 계좌 검색
	 * @param: String accountId
	 * @return: Account
	 * */
	@Override
	public Account findByAccountid(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 회원 아이디로 계좌 검색
	 * @param: String id
	 * @return: List<Account>
	 * */
	@Override
	public List<Account> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}