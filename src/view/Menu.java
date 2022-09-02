package view;

import java.util.Scanner;

import service.Bank;
import service.BankImpl;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	public Bank bank = new BankImpl();
	
	public void mainMenu() {
		System.out.println("\n-----------------------------------");
		System.out.println("1. 로그인 | 2. 회원가입 | | 0. 종료");
		System.out.println("-----------------------------------");

		System.out.print("메뉴 선택 > ");

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
			System.out.println("1. 입금하기 | 2. 출금하기 | 3. 잔고 확인 | 9. 로그아웃 | 0. 종료");
			System.out.println("----------------------------------------------------------------");
			System.out.print("메뉴 선택 > ");

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
		System.out.println("YD뱅크를 종료합니다.");
		System.out.println("이용해주셔서 감사합니다");
	}
}
