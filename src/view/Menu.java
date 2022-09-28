package view;

import java.util.Scanner;

import controller.AccountController;
import controller.CustomerController;
import controller.TransactionController;
import dto.Customer;
import dto.Transaction;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private CustomerController customerController = new CustomerController();
	private AccountController accountController = new AccountController();
	private TransactionController transactionController = new TransactionController();
	private boolean run = true;
	
	/**
	 * 메인 메뉴
	 * */
	public void mainMenu() {
		while(run) {
			System.out.println("\n[ 1. 로그인 | 2. 회원가입 | 0. 종료 ]");

			System.out.print("> ");
			
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
			default:
				System.out.println("올바르지 않은 메뉴를 선택하셨습니다.");
			}
		}
	}
	
	/**
	 * 고객 메뉴
	 * */
	public void userMenu() {
		while (run) {
			System.out.println("\n[ 1. 거래하기 | 2. 내 정보 확인 | 3. 내 계좌 확인 | 4. 내 거래 내역 확인 | 5. 신규 계좌 생성 | 6. 내 계좌 해지 | 9. 로그아웃 | 0. 종료 ]");
			System.out.print("> ");

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
				
				break;
			case 5:
				accountController.insertAccount();
				break;
			case 6:
				System.out.print("계좌 번호 입력 > ");
				int accountId = Integer.parseInt(scanner.nextLine());
				accountController.updateClose(accountId);
				break;
			case 9:
				customerController.logout();
				return;
			case 0:
				this.bankExit();
			default:
				System.out.println("올바르지 않은 메뉴를 선택하셨습니다.");
			}
		}
	}
	
	/**
	 * 거래 메뉴
	 * */
	public void transactionMenu() {
		while (run) {
			System.out.println("\n[ 1. 현금 입금 | 2. 현금 출금 | 3. 계좌 이체 | 9. 뒤로 가기 | 0. 종료 ]");
			System.out.print("> ");

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
				transactionController.insertTransaction(new Transaction(depositAccount, null, 1, amount));
				return;
			case 2:
				System.out.println("출금할 계좌 번호를 입력하세요.");
				System.out.print("> ");
				withdrawAccount = Integer.parseInt(scanner.nextLine());

				System.out.println("출금할 액수를 입력하세요.");
				System.out.print("> ");
				amount = (long) Integer.parseInt(scanner.nextLine());
				transactionController.insertTransaction(new Transaction(null, withdrawAccount, 2, amount));
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
			default:
				System.out.println("올바르지 않은 메뉴를 선택하셨습니다.");
			}
		}
	}
	
	/**
	 * 관리자 메뉴
	 * */
	public void adminMenu() {
		while (run) {
			System.out.println("\n[ 1. 회원 관리 | 2. 계좌 관리 | 3. 거래 관리 | 4. 통계 보기 | 9. 로그아웃 | 0. 종료 ]");
			System.out.print("> ");

			int select = Integer.parseInt(scanner.nextLine());
			switch (select) {
			case 1:
				this.adminCustomerMenu();
			case 2:
				this.adminAccountMenu();
			case 9:
				return;
			case 0:
				this.bankExit();
			default:
				System.out.println("올바르지 않은 메뉴를 선택하셨습니다.");
			}
		}
	}
	
	/**
	 * 회원 관리 메뉴(관리자)
	 * */
	public void adminCustomerMenu() {
		while (run) {
			System.out.println("\n[ 1. 전체 회원 보기 | 2. 등급별 회원 보기 | 3. 회원 검색 | 9. 뒤로 가기 | 0. 종료 ]");
			System.out.print("> ");

			int select = Integer.parseInt(scanner.nextLine());
			switch (select) {
			case 1:
				customerController.findAll();
				break;
			case 2:
				System.out.println("[ 1. General | 2. Family | 3. Royal | 4. Honor | 5. Prestige ]");
				System.out.print("> ");
				int gradeId = Integer.parseInt(scanner.nextLine());
				customerController.findByGrade(gradeId);
				break;
			case 3:
				this.adminCustomerSearchMenu();
				break;
			case 9:
				customerController.logout();
				return;
			case 0:
				this.bankExit();
			default:
				System.out.println("올바르지 않은 메뉴를 선택하셨습니다.");
			}
		}
	}
	
	/**
	 * 키워드로 회원 검색 메뉴(관리자)
	 * */
	public void adminCustomerSearchMenu() {
		while (run) {
			System.out.println("\n[ 1. 아이디로 검색 | 2. 이름으로 검색 | 3. 전화번호로 검색 | 4. 계좌 번호로 검색 | 9. 뒤로 가기 | 0. 종료]");
			System.out.print("> ");

			int select = Integer.parseInt(scanner.nextLine());
			if (select > 0 && select < 5) {
				System.out.print("검색 키워드 입력 > ");
				String keyword = scanner.nextLine();
				customerController.findByKeyword(select, keyword);
				return;
			} else if (select == 9) {
				return;
			} else if (select == 0) {
				this.bankExit();
			} else {
				System.out.println("올바르지 않은 메뉴를 선택하셨습니다.");
			}
		}
	}
	
	/**
	 * 계좌 관리 메뉴(관리자)
	 * */
	public void adminAccountMenu() {
		while (run) {
			System.out.println("\n[ 1. 전체 계좌 보기 | 2. 계좌 검색 | 3. 계좌 해지 처리 | 9. 뒤로 가기 | 0. 종료 ]");
			System.out.print("> ");

			int select = Integer.parseInt(scanner.nextLine());
			int accountId = 0;
			switch (select) {
			case 1:
				accountController.findAll();
				break;
			case 2:
				System.out.print("계좌 번호 입력 > ");
				accountId = Integer.parseInt(scanner.nextLine());
				accountController.findByAccountId(accountId);
				break;
			case 3:
				System.out.print("계좌 번호 입력 > ");
				accountId = Integer.parseInt(scanner.nextLine());
				accountController.updateClose(accountId);
				break;
			case 9:
				customerController.logout();
				return;
			case 0:
				this.bankExit();
			default:
				System.out.println("올바르지 않은 메뉴를 선택하셨습니다.");
			}
		}
	}
	
	/**
	 * 거래 관리 메뉴(관리자)
	 * */
	public void adminTransactionMenu() {
		while (run) {
			System.out.println("\n[ 1. 전체 거래 보기 | 2. 일일 거래 보기 | 3. 회원별 거래 보기 | 4. 계좌별 거래 보기 | 5. 거래 검색 | 9. 뒤로 가기 | 0. 종료 ]");
			System.out.print("> ");

			int select = Integer.parseInt(scanner.nextLine());
			switch (select) {
			case 1:
				transactionController.findAll();
				break;
			case 2:
				transactionController.findByToday();
				break;
			case 3:
				System.out.println("아이디 입력 > ");
				String id = scanner.nextLine();
				transactionController.findById(id);
				break;
			case 4:
				System.out.println("아이디 입력 > ");
				int accountId = Integer.parseInt(scanner.nextLine());
				transactionController.findByAccountId(accountId);
				break;
			case 5:
				System.out.print("거래 번호 입력 > ");
				int transactionId = Integer.parseInt(scanner.nextLine());
				transactionController.findByTransactionId(transactionId);
				break;
			case 9:
				customerController.logout();
				return;
			case 0:
				this.bankExit();
			default:
				System.out.println("올바르지 않은 메뉴를 선택하셨습니다.");
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
