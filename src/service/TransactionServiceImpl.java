package service;

import java.sql.SQLException;
import java.util.List;

import dao.AccountDaoImpl;
import dao.TransactionDao;
import dao.TransactionDaoImpl;
import dto.Account;
import dto.Transaction;

public class TransactionServiceImpl implements TransactionService {
	private TransactionDao transactionDao = new TransactionDaoImpl();

	/**
	 * 거래 생성
	 * @param: Transaction
	 * */
	@Override
	public void insertTransaction(Transaction transaction) throws SQLException {
		int result = transactionDao.save(transaction);
		if (result != 1) {
			throw new SQLException("거래가 완료되지 않았습니다.\n거래 내역을 확인해주세요.");
		}
	}

	/**
	 * 전체 거래 검색
	 * @return: List<Transaction>
	 * */
	@Override
	public List<Transaction> findAll() throws SQLException {
		return transactionDao.findAll();
	}

	/**
	 * 회원별 거래 검색
	 * @param: String id(회원 아이디)
	 * @return: List<Transaction>
	 * */
	@Override
	public List<Transaction> findById(String id) throws SQLException {
		List<Transaction> transactions = transactionDao.findById(id);
		return transactions;
	}

	/**
	 * 계좌별 거래 검색
	 * @param: int accountId(계좌 번호)
	 * @return: List<Transaction>
	 * */
	@Override
	public List<Transaction> findByAccountId(int accountId) throws SQLException {
		Account account = new AccountDaoImpl().findByAccountid(accountId);
		if (account == null) throw new SQLException(accountId + "에 해당하는 계좌가 존재하지 않습니다.");
		
		List<Transaction> transactions = transactionDao.findByAccountId(accountId);
		return transactions;
	}

	/**
	 * 거래 아이디로 거래 검색
	 * @param: int transactionId(거래 번호)
	 * @return: Transaction
	 * */
	@Override
	public Transaction findByTransactionId(int transactionId) throws SQLException {
		Transaction transaction = transactionDao.findByTransactionId(transactionId);
		return transaction;
	}

	/**
	 * 오늘 거래 검색
	 * @return: List<Transaction>
	 * */
	@Override
	public List<Transaction> findByToday() throws SQLException {
		return transactionDao.findByToday();
	}
}
