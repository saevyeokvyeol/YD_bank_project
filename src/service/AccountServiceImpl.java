package service;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import dao.AccountDao;
import dao.AccountDaoImpl;
import dto.Account;
import dto.Customer;
import exception.DiscrepancyException;
import exception.NotExistRecodeException;
import session.Session;

public class AccountServiceImpl implements AccountService {
	private AccountDao accountDao = new AccountDaoImpl();
	private Session session = Session.getInstance();

	/**
	 * 계좌 개설
	 * @param: String id
	 * */
	@Override
	public void insertAccount(String id) throws SQLException {
		int result = accountDao.save(id);
		if (result != 1) throw new SQLException("오류로 인해 계좌가 생성되지 않았습니다.\n다시 시도해주세요.");
	}

	/**
	 * 계좌 상태 변경
	 * @param: int accountId
	 * */
	@Override
	public void updateAccountState(int accountId) throws SQLException, NotExistRecodeException, DiscrepancyException {
		Account account = accountDao.findByAccountid(accountId);
		Customer customer = (Customer)session.getAttribute("loginUser");
		
		if (account == null) throw new NotExistRecodeException("올바르지 않은 계좌 정보입니다.");
		else if (!customer.getId().equals("admin") && !customer.getId().equals(account.getId())) throw new DiscrepancyException("자신이 소유한 계좌만 해지할 수 있습니다.");
		else if (account.getBalance() != 0) throw new DiscrepancyException("잔고가 있는 계좌는 해지할 수 없습니다.\n남은 잔고: " + new DecimalFormat("#,###").format(account.getBalance()));
		else if (account.getStateId() == 2) throw new DiscrepancyException("이미 해지된 계좌입니다.");
		
		int result = accountDao.updateClose(account);
		if (result != 1) throw new SQLException("계좌 해지에 오류가 발생했습니다.\n잠시 후 다시 시도해주세요.");
	}

	/**
	 * 전체 계좌 검색
	 * @return: List<Account>
	 * */
	@Override
	public List<Account> findAll() throws SQLException {
		List<Account> accounts = accountDao.findAll();
		return accounts;
	}

	/**
	 * 계좌 번호로 계좌 검색
	 * @param: int accountId
	 * @return: Account
	 * */
	@Override
	public Account findByAccountid(int accountId) throws SQLException {
		Account account = accountDao.findByAccountid(accountId);
		return account;
	}

	/**
	 * 회원 아이디로 계좌 검색
	 * @param: String id, boolean state(true일 경우 사용 중 계좌만, false일 경우 모든 계좌)
	 * @return: List<Account>
	 * */
	@Override
	public List<Account> findById(String id, boolean state) throws SQLException {
		List<Account> accounts = accountDao.findById(id, state);
		return accounts;
	}
}
