package edu.java.class08;

public class ClassMain08 {

	public static void main(String[] args) {
		Account account = new Account(1004, 1000); // 계좌 생성
        account.printInfo(); // 계좌 정보 출력
//		System.out.println("계좌번호: " + account.accountNo);   -> 내가 푼 것
//		System.out.println("잔고: " + account.balance +"원");
//		System.out.println("--------------------");
//		System.out.println("입금 후 잔액: " + account.deposit(1500));
//		System.out.println("출금 후 잔액: " + account.withdraw(500));
//		System.out.println("--------------------");
//		Account to = new Account(1026, 3000);
//		System.out.println("계좌번호: " + to.accountNo);
//		System.out.println("잔고: " + to.balance +"원");
//		System.out.println("--------------------");
//		System.out.println("이체 확인: " + account.transfer(to, 800));
//		System.out.println("이체 후 to의 잔액: " + to.balance);
//		System.out.println("이체 후 내 잔액: " + account.balance);
//		System.out.println("--------------------");
//		account.printInfo();
        
        double balance = account.deposit(1000); // 1000원 입금.
        System.out.println("balance = " + balance); // 입금 후 잔액
        account.printInfo();
        
        account.withdraw(500); // 500원 출금
        account.printInfo();
        
        Account account2 = new Account(129, 10000);  // 2번째 계좌 생성
        account2.printInfo();
        
        account.transfer(account2, 500); // account 계좌에서 account2 계좌로 500원을 이체.
        account.printInfo();
        account2.printInfo();
        
		

	}

}
