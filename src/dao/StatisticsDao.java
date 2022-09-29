package dao;

import java.sql.SQLException;
import java.util.List;

import dto.Statistics;

public interface StatisticsDao {
	/**
	 * 전체 회원 수 반환
	 * @return: Long
	 * */
	public Long findTotalCustomer() throws SQLException;
	
	/**
	 * 오늘 가입한 회원 수 반환
	 * @return: Long
	 * */
	public Long findTodayCustomer() throws SQLException;

	/**
	 * 총 예치액 반환
	 * @return: Long
	 * */
	public Long findTotalBalance() throws SQLException;
	
	/**
	 * 총 거래 횟수 반환
	 * @return: Long
	 * */
	public Long findTotalTransactionCount() throws SQLException;

	/**
	 * 총 거래 금액 반환
	 * @return: Long
	 * */
	public Long findTotalTransactionAmount() throws SQLException;
	
	/**
	 * 오늘 거래 횟수 반환
	 * @return: Long
	 * */
	public Long findTotalTransactionTodayCount() throws SQLException;

	/**
	 * 오늘 거래 금액 반환
	 * @return: Long
	 * */
	public Long findTotalTransactionTodayAmount() throws SQLException;
	
	/**
	 * 거래 횟수 많은 회원 검색
	 * @return: List<Statistics>
	 * */
	public List<Statistics> findTransactionCount() throws SQLException;

	/**
	 * 거래 액수 많은 회원 검색
	 * @return: List<Statistics>
	 * */
	public List<Statistics> findTransactionAmount() throws SQLException;
}
