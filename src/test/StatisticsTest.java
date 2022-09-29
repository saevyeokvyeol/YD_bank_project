package test;

import controller.StatisticsController;

public class StatisticsTest {
	private StatisticsController controller = new StatisticsController();
	private TestUtil util = new TestUtil();
	
	public void statisticsSummaryTest() {
		controller.statisticsSummary();
	}
	
	public void statisticsCountTest() {
		controller.findTransactionCount();
	}
	
	public void statisticsAmountTest() {
		controller.findTransactionAmount();
	}
	
	public static void main(String[] args) {
		StatisticsTest test = new StatisticsTest();

//		test.statisticsSummaryTest();
		test.statisticsCountTest();
		test.statisticsAmountTest();
	}
}
