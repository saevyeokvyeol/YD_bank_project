package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dto.Statistics;

public interface StatisticsService {
	/**
	 * 요약 통계 반환(전체 회원 수, 총 예치액, 총 거래 횟수, 총 거래 금액)
	 * @return: Map<String, Long>
	 * */
	public Map<String, Long> StatisticsSummary() throws SQLException;
	
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
