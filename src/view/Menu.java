package view;

import java.util.Scanner;

import service.Bank;
import service.BankImpl;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	public Bank bank = new BankImpl();
	
	public void mainMenu() {
		System.out.println("\n-----------------------------------");
		System.out.println("1. �α��� | 2. ȸ������ | | 0. ����");
		System.out.println("-----------------------------------");

		System.out.print("�޴� ���� > ");

		int select = scanner.nextInt();
		
		switch (select) {
		case 1:
			break;
		case 2:
			break;
		case 0:
			this.bankExit();
		}
	}
	
	public void userMenu() {
		boolean run = true;
		while (run) {
			System.out.println("\n----------------------------------------------------------------");
			System.out.println("1. �Ա��ϱ� | 2. ����ϱ� | 3. �ܰ� Ȯ�� | 9. �α׾ƿ� | 0. ����");
			System.out.println("----------------------------------------------------------------");
			System.out.print("�޴� ���� > ");

			int select = scanner.nextInt();
			
			switch (select) {
			case 1:
				bank.deposit();
				break;
			case 2:
				bank.withdraw();
				break;
			case 3:
				bank.nowBalance();
				break;
			case 0:
				this.bankExit();
				run = false;
			}
		}
	}
	
	public void bankExit() {
		System.out.println("YD��ũ�� �����մϴ�.");
		System.out.println("�̿����ּż� �����մϴ�");
	}
}
