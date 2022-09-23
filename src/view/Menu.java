package view;

import java.util.Scanner;

import controller.AccountController;
import controller.CustomerController;
import controller.TransactionController;
import dto.Customer;
import dto.Transaction;
import service.Bank;
import service.BankImpl;
import session.Session;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private Bank bank = new BankImpl();
	private CustomerController customerController = new CustomerController();
	private AccountController accountController = new AccountController();
	private TransactionController transactionController = new TransactionController();
	private boolean run = true;
	
	public void mainMenu() {
		while(run) {
			System.out.println("\n-----------------------------------");
			System.out.println(" 1. 로그인 | 2. 회원가입 | 0. 종료");
			System.out.println("-----------------------------------");

			System.out.print("메뉴 선택 > ");
			
			int select = Integer.parseInt(scanner.nextLine());
			
			switch (select) {
			case 1:
				System.out.print("\n아이디 입력 > ");
				String loginId = scanner.nextLine();

				System.out.print("비밀번호 입력 > ");
				String loginPwd = scanner.nextLine();
				customerController.login(new Customer(loginId, loginPwd));
				break;
			case 2:
				System.out.print("\n아이디 입력 > ");
				String id = scanner.nextLine();
				
				System.out.print("비밀번호 입력 > ");
				String password = scanner.nextLine();
				
				System.out.print("비밀번호 확인 > ");
				String checkPwd = scanner.nextLine();
				
				System.out.print("이름 입력 > ");
				String name = scanner.nextLine();
				
				System.out.print("전화번호 입력 > ");
				String tel = scanner.nextLine();
				customerController.signup(new Customer(id, password, name, tel), checkPwd);
				break;
			case 0:
				this.bankExit();
			}
		}
	}
	
	public void userMenu() {
		while (run) {
			System.out.println("\n---------------------------------------------------------------------------");
			System.out.println(" 1. 거래하기 | 2. 내 정보 확인 | 3. 내 계좌 확인 | 4. 최근 거래 확인 | 4. 신규 계좌 생성 | 9. 로그아웃 | 0. 종료");
			System.out.println("---------------------------------------------------------------------------");
			System.out.print("메뉴 선택 > ");

			int select = Integer.parseInt(scanner.nextLine());
			
			switch (select) {
			case 1:
				transactionMenu();
				break;
			case 2:
				customerController.customerInfo();
				break;
			case 3:
				accountController.findById(true);
				break;
			case 4:
				accountController.insertAccount();
				break;
			case 9:
				customerController.logout();
				return;
			case 0:
				this.bankExit();
			}
		}
	}
	
	public void transactionMenu() {
		while (run) {
			System.out.println("\n-------------------------------------------------------------------");
			System.out.println(" 1. 현금 입금 | 2. 현금 출금 | 3. 계좌 이체 | 9. 뒤로 가기 | 0. 종료");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("메뉴 선택 > ");

			int select = Integer.parseInt(scanner.nextLine());
			int depositAccount = 0;
			int withdrawAccount = 0;
			Long amount = 0L;
			switch (select) {
			case 1:
				System.out.println("입금할 계좌 번호를 입력하세요.");
				System.out.print("> ");
				depositAccount = Integer.parseInt(scanner.nextLine());

				System.out.println("입금할 액수를 입력하세요.");
				System.out.print("> ");
				amount = (long) Integer.parseInt(scanner.nextLine());
				transactionController.insertTransaction(new Transaction(depositAccount, 0, 1, amount));
				return;
			case 2:
				System.out.println("출금할 계좌 번호를 입력하세요.");
				System.out.print("> ");
				withdrawAccount = Integer.parseInt(scanner.nextLine());

				System.out.println("출금할 액수를 입력하세요.");
				System.out.print("> ");
				amount = (long) Integer.parseInt(scanner.nextLine());
				transactionController.insertTransaction(new Transaction(0, withdrawAccount, 2, amount));
				return;
			case 3:
				System.out.println("입금할 계좌 번호를 입력하세요.");
				System.out.print("> ");
				depositAccount = Integer.parseInt(scanner.nextLine());
				
				System.out.println("출금할 계좌 번호를 입력하세요.");
				System.out.print("> ");
				withdrawAccount = Integer.parseInt(scanner.nextLine());

				System.out.println("이체할 액수를 입력하세요.");
				System.out.print("> ");
				amount = (long) Integer.parseInt(scanner.nextLine());
				transactionController.insertTransaction(new Transaction(depositAccount, withdrawAccount, 3, amount));
				return;
			case 9:
				return;
			case 0:
				this.bankExit();
			}
		}
	}
	
	public void bankExit() {
		this.run = false;
		System.out.println("\nYD뱅크를 종료합니다.");
		System.out.println("이용해주셔서 감사합니다.");
		System.out.println("\n`8.`8888.      ,8' 8 888888888o.                8 888888888o            .8.          b.             8 8 8888     ,88' \r\n"
						+ " `8.`8888.    ,8'  8 8888    `^888.             8 8888    `88.         .888.         888o.          8 8 8888    ,88'  \r\n"
						+ "  `8.`8888.  ,8'   8 8888        `88.           8 8888     `88        :88888.        Y88888o.       8 8 8888   ,88'   \r\n"
						+ "   `8.`8888.,8'    8 8888         `88           8 8888     ,88       . `88888.       .`Y888888o.    8 8 8888  ,88'    \r\n"
						+ "    `8.`88888'     8 8888          88           8 8888.   ,88'      .8. `88888.      8o. `Y888888o. 8 8 8888 ,88'     \r\n"
						+ "     `8. 8888      8 8888          88           8 8888888888       .8`8. `88888.     8`Y8o. `Y88888o8 8 8888 88'      \r\n"
						+ "      `8 8888      8 8888         ,88           8 8888    `88.    .8' `8. `88888.    8   `Y8o. `Y8888 8 888888<       \r\n"
						+ "       8 8888      8 8888        ,88'           8 8888      88   .8'   `8. `88888.   8      `Y8o. `Y8 8 8888 `Y8.     \r\n"
						+ "       8 8888      8 8888    ,o88P'             8 8888    ,88'  .888888888. `88888.  8         `Y8o.` 8 8888   `Y8.   \r\n"
						+ "       8 8888      8 888888888P'                8 888888888P   .8'       `8. `88888. 8            `Yo 8 8888     `Y8. ");
	}
}
