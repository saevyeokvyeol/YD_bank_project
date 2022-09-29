package service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.StatisticsDao;
import dao.StatisticsDaoImpl;
import dto.Statistics;

public class StatisticsServiceImpl implements StatisticsService {
	private StatisticsDao statisticsDao = new StatisticsDaoImpl();

	/**
	 * 요약 통계 반환(전체 회원 수, 총 예치액, 총 거래 횟수, 총 거래 금액)
	 * @return: Map<String, Long>
	 * */
	@Override
	public Map<String, Long> StatisticsSummary() throws SQLException {
		Long totalCustomer = statisticsDao.findTotalCustomer();
		Long todayCustomer = statisticsDao.findTodayCustomer();
		Long totalBalance = statisticsDao.findTotalBalance();
		Long totalTransactionCount = statisticsDao.findTotalTransactionCount();
		Long totalTransactionAmount = statisticsDao.findTotalTransactionAmount();
		Long totalTransactionTodayCount = statisticsDao.findTotalTransactionTodayCount();
		Long totalTransactionTodayAmount = statisticsDao.findTotalTransactionTodayAmount();
		
		Map<String, Long> map = new HashMap<>();
		map.put("totalCustomer", totalCustomer);
		map.put("todayCustomer", todayCustomer);
		map.put("totalBalance", totalBalance);
		map.put("totalTransactionCount", totalTransactionCount);
		map.put("totalTransactionAmount", totalTransactionAmount);
		map.put("totalTransactionTodayCount", totalTransactionTodayCount);
		map.put("totalTransactionTodayAmount", totalTransactionTodayAmount);
		
		return map;
	}

	/**
	 * 거래 횟수 많은 회원 검색
	 * @return: List<Statistics>
	 * */
	@Override
	public List<Statistics> findTransactionCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 거래 액수 많은 회원 검색
	 * @return: List<Statistics>
	 * */
	@Override
	public List<Statistics> findTransactionAmount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
