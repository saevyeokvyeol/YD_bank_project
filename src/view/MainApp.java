package view;

import java.util.ArrayList;
import java.util.List;

import dto.Customer;

public class MainApp {
	public static List<Customer> costomers = new ArrayList<Customer>();

	public static void main(String[] args) {
		Menu menu = new Menu();
		System.out.println("* * * * * * * * YD¹ðÅ© * * * * * * * *");
		menu.mainMenu();
	}

}