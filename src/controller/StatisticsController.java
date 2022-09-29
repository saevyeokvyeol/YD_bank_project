package controller;

import java.util.List;
import java.util.Map;

import dto.Statistics;
import service.StatisticsService;
import service.StatisticsServiceImpl;
import view.FailView;
import view.SuccessView;

public class StatisticsController {
	private StatisticsService statisticsService = new StatisticsServiceImpl();
	
	public void statisticsSummary() {
		try {
			Map<String, Long> map = statisticsService.StatisticsSummary();
			SuccessView.printStatisticsSummary(map);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}
	
	public void findTransactionCount() {
		try {
			List<Statistics> statistics = statisticsService.findTransactionCount();
			SuccessView.printTransactionCount(statistics);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}
	
	public void findTransactionAmount() {
		try {
			List<Statistics> statistics = statisticsService.findTransactionAmount();
			SuccessView.printTransactionAmount(statistics);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.printErrorMessage(e);
		}
	}
}
