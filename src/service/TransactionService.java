package service;

import java.sql.SQLException;
import java.util.List;

import dto.Transaction;

public interface TransactionService {
	/**
	 * 거래 생성
	 * @param: Transaction
	 * @return: int
	 * */
	public int insertTransaction(Transaction transaction) throws SQLException;
	
	/**
	 * 계좌 출금 처리
	 * @param: int accountId, Long amount
	 * @return: int
	 * */
	public int withdraw(int accountId, Long amount) throws SQLException;
	
	/**
	 * 계좌 입금 처리
	 * @param: int accountId, Long amount
	 * @return: int
	 * */
	public int deposit(int accountId, Long amount) throws SQLException;
	
	/**
	 * 전체 거래 검색
	 * @return: List<Transaction>
	 * */
	public List<Transaction> findAll() throws SQLException;
	
	/**
	 * 회원별 거래 검색
	 * @param: String id(회원 아이디)
	 * @return: List<Transaction>
	 * */
	public List<Transaction> findById() throws SQLException;
	
	/**
	 * 계좌별 거래 검색
	 * @param: int accountId(계좌 번호)
	 * @return: List<Transaction>
	 * */
	public List<Transaction> findByAccountId() throws SQLException;
	
	/**
	 * 거래 아이디로 거래 검색
	 * @param: int transactionId(거래 번호)
	 * @return: List<Transaction>
	 * */
	public List<Transaction> findByTransactionId() throws SQLException;
	
	/**
	 * 거래 분류별 거래 검색
	 * @param: int findByTransactionClassId(거래 번호)
	 * @return: List<Transaction>
	 * */
	public List<Transaction> findByTransactionClassId() throws SQLException;
}
