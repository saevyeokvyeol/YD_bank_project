package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.Account;
import dto.Customer;
import dto.Transaction;
import util.DbUtil;

public class TransactionDaoImpl implements TransactionDao {
	private Properties profile = DbUtil.getProfile();
	private CustomerDao customerDao = new CustomerDaoImpl();
	private AccountDao accountDao = new AccountDaoImpl();

	/**
	 * 거래 생성
	 * @param: Transaction
	 * @return: int
	 * */
	@Override
	public int save(Transaction transaction) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = profile.getProperty("transaction.save");
		if (transaction.getTransactionClassId() == 1) {
			sql = profile.getProperty("transaction.saveDeposit");
		} else if (transaction.getTransactionClassId() == 2) {
			sql = profile.getProperty("transaction.saveWithdraw");
		}
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			Account depositAccount = null;
			Account withdrawAccount = null;
			if (transaction.getTransactionClassId() != 1) {
				withdrawAccount = accountDao.findByAccountid(transaction.getWithdrawAccountId());
				if (withdrawAccount == null || !withdrawAccount.getId().equals(transaction.getCustomer().getId())) {
					System.out.println(withdrawAccount.getId() + ", " + transaction.getCustomer().getId());
					throw new SQLException("출금할 계좌 번호가 잘못되었습니다. 다시 확인해주세요.");
				} else if (transaction.getTransactionAmount() > withdrawAccount.getBalance()) {
					throw new SQLException("잔액이 부족해 출금 처리가 완료되지 않았습니다.");
				}
			}
			
			if (transaction.getTransactionClassId() != 2) {
				depositAccount = accountDao.findByAccountid(transaction.getDepositAccountId());
				if (depositAccount == null) {
					throw new SQLException("입금할 계좌 번호가 잘못되었습니다. 다시 확인해주세요.");
				}
			}
			
			ps = con.prepareStatement(sql);
			ps.setString(1, transaction.getCustomer().getId());
			

			if (transaction.getTransactionClassId() == 3) {
				ps.setInt(2, depositAccount.getAccountId());
				ps.setInt(3, withdrawAccount.getAccountId());
				ps.setInt(4, transaction.getTransactionClassId());
				ps.setLong(5, transaction.getTransactionAmount());
			} else {
				if (depositAccount != null) {
					ps.setInt(2, depositAccount.getAccountId());
				} else {
					ps.setInt(2, withdrawAccount.getAccountId());
				}
				ps.setInt(3, transaction.getTransactionClassId());
				ps.setLong(4, transaction.getTransactionAmount());
			}
			
			result = ps.executeUpdate();
			int re = 0;
			
			if (transaction.getTransactionClassId() != 1) {
				re = accountDao.withdraw(con, withdrawAccount.getAccountId(), transaction.getTransactionAmount());
				if (re != 1) throw new SQLException("출금 오류로 이체가 완료되지 않았습니다.\n다시 시도해주세요.");
				
				re = customerDao.withdraw(con, withdrawAccount.getId(), transaction.getTransactionAmount());
				if (re != 1) throw new SQLException("출금 오류로 이체가 완료되지 않았습니다.\n다시 시도해주세요.");
			}
			
			if (transaction.getTransactionClassId() != 2) {
				re = accountDao.deposit(con, depositAccount.getAccountId(), transaction.getTransactionAmount());
				if (re != 1) throw new SQLException("입금 오류로 이체가 완료되지 않았습니다.\n다시 시도해주세요.");
				
				re = customerDao.deposit(con, depositAccount.getId(), transaction.getTransactionAmount());
				if (re != 1) throw new SQLException("입금 오류로 이체가 완료되지 않았습니다.\n다시 시도해주세요.");
			}
			
			con.commit();
		} finally {
			con.rollback();
			DbUtil.close(con, ps);
		}
		
		return result;
	}

	/**
	 * 전체 거래 검색
	 * @return: List<Transaction>
	 * */
	@Override
	public List<Transaction> findAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("transaction.findAll");
		List<Transaction> transactions = new ArrayList<>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getLong(6), rs.getString(7));
				transactions.add(transaction);
			}
		} finally {
			DbUtil.close(con, ps);
		}
		return transactions;
	}

	/**
	 * 회원별 거래 검색
	 * @param: String id(회원 아이디)
	 * @return: List<Transaction>
	 * */
	@Override
	public List<Transaction> findById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("transaction.findById");
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Transaction transaction = new Transaction(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getLong(6), rs.getString(7));
				transactions.add(transaction);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return transactions;
	}

	/**
	 * 계좌별 거래 검색
	 * @param: int accountId(계좌 번호)
	 * @return: List<Transaction>
	 * */
	@Override
	public List<Transaction> findByAccountId(int accountId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 거래 아이디로 거래 검색
	 * @param: int transactionId(거래 번호)
	 * @return: Transaction
	 * */
	@Override
	public Transaction findByTransactionId(int transactionId) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("transaction.findByTransactionId");
		Transaction transaction = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, transactionId);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				transaction = new Transaction(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getLong(6), rs.getString(7));
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return transaction;
	}
}
