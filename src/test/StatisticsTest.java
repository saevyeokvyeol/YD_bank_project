package test;

import controller.StatisticsController;

public class StatisticsTest {
	private StatisticsController controller = new StatisticsController();
	private TestUtil util = new TestUtil();
	
	public void statisticsSummaryTest() {
		controller.statisticsSummary();
	}
	
	public static void main(String[] args) {
		StatisticsTest test = new StatisticsTest();

		test.statisticsSummaryTest();
	}
}
