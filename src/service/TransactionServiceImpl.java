package service;

import java.sql.SQLException;
import java.util.List;

import dao.TransactionDao;
import dao.TransactionDaoImpl;
import dto.Transaction;

public class TransactionServiceImpl implements TransactionService {
	private TransactionDao transactionDao = new TransactionDaoImpl();

	@Override
	public void insertTransaction(Transaction transaction) throws SQLException {
		int result = transactionDao.save(transaction);
		if (result != 1) {
			throw new SQLException("거래가 완료되지 않았습니다.\n거래 내역을 확인해주세요.");
		}
	}

	@Override
	public List<Transaction> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findById() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findByAccountId() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findByTransactionId() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findByTransactionClassId() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
