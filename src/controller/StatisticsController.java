package controller;

import java.util.Map;

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
}
