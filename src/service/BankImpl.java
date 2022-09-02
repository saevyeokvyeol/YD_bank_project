package service;

import java.util.Scanner;

public class BankImpl implements Bank {
	private Scanner scanner = new Scanner(System.in);
	private int balance = 0;
	
	@Override
	public void deposit() {
		System.out.print("입금액 > ");
		int plus = scanner.nextInt();
		
		if (plus <= 0) {
			System.out.println("입금액은 0원보다 커야 합니다.");
		} else {
			balance += plus;
			System.out.println(plus + "원이 입금되었습니다.");
			this.nowBalance();
		}	
	}
	
	@Override
	public void withdraw() {
		System.out.print("출금액 > ");
		int minus = scanner.nextInt();

		if (minus <= 0) {
			System.out.println("출금액은 0원보다 커야 합니다.");
		} else if (balance < minus) {
			System.out.println("잔액이 부족해 출금할 수 없습니다.");
			this.nowBalance();
		} else {
			balance -= minus;
			System.out.println(minus + "원이 입금되었습니다.");
			this.nowBalance();
		}
	}
	
	@Override
	public void nowBalance() {
		System.out.println("현재 잔액: " + balance + "원");
	}
}
