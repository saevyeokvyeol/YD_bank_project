package view;

import java.util.Scanner;

import controller.CustomerController;
import dto.Customer;
import service.Bank;
import service.BankImpl;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private Bank bank = new BankImpl();
	private CustomerController customerController = new CustomerController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("\n-----------------------------------");
			System.out.println("1. �α��� | 2. ȸ������ | 0. ����");
			System.out.println("-----------------------------------");
			
			System.out.print("�޴� ���� > ");
			
			int select = Integer.parseInt(scanner.nextLine());
			
			switch (select) {
			case 1:
				break;
			case 2:
				System.out.print("\n���̵� �Է� > ");
				String id = scanner.nextLine();
				
				System.out.print("��й�ȣ �Է� > ");
				String password = scanner.nextLine();
				
				System.out.print("��й�ȣ Ȯ�� > ");
				String checkPwd = scanner.nextLine();
				
				System.out.print("�̸� �Է� > ");
				String name = scanner.nextLine();
				customerController.signup(new Customer(id, password, name), checkPwd);
				break;
			case 0:
				this.bankExit();
			}
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
