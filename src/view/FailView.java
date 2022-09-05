package view;

public class FailView {
	public static void printErrorMessage(Exception e) {
		System.out.println("\n" + e.getMessage());
	}
}
