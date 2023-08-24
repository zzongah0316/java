package edu.java.class08;



/**
 * 은행 계좌 클래스.
 * 필드: 계좌번호, 잔액.
 * 메서드: 입금, 출금, 이체, 정보 출력.
 */

public class Account {
	
	// field
    int accountNo; // 계좌번호
    double balance; // 잔고
    
    
    // argument 2개를 갖는 생성자 -> 없었으면 기본 생성자 가지고 있지만 이미 생성해서 기본 생성자 가지고 있지 않음.
    public Account (int accountNo, double balance) {
    	this.accountNo = accountNo;
    	this.balance = balance;
    } 
    // 생성자와 메서드의 차이: 메서드는 리턴 타입 필수, 생성자는 리턴 타입 필요X, 
    // 생성자와 클래스는 이름이 같아야 함.
    
    
    // method
    /**
     * 입금(deposit)
     * 
     * @param amount 입금액(double).
     * @return 입금 후 잔액.
     */
    // TODO
    public double deposit (double amount) {
    	balance += amount;
    	return balance;
    }
    
    
    /**
     * 출금(withdraw)
     * 
     * @param amount 출금액(double).
     * @return 입금 후 잔액.
     */
    // TODO
    public double withdraw (double amount) {
    	balance -= amount;
    	return balance;
    }
    
    /**
     * 이체(transfer).
     * 
     * @param to 이체할 은행 계좌 객체(Accout 타입 객체).
     * @param amount 이체할 금액(double).
     * @return true.
     */
    // TODO
    public boolean transfer (Account to, double amount) {
    	// 이체: (1)내 계좌 출금
//    	balance -= amount ;
    	this.withdraw(amount);
    	// (2)다른 계좌 입금.
//    	to.balance += amount ;
    	to.deposit(amount);
    	return true;	
    }
    
    /**
     * 정보 출력(printInfo).
     * 계좌 번호와 잔고를 출력.
     */
	public void printInfo() {
		System.out.printf("계좌 번호: %d, 잔고: %f\n", this.accountNo, this.balance);
	}

}
