package ex2;

/*
 		
 */
// 은행 계좌 클래스(설계도)
class Account{
	
	private long balance; // 잔고가 저장될 변수 
	
	public Account() {} // 기본생성자 
	
	public long getBalance() { // 잔고 반환(리턴)
		return balance;
	}
	// 예금을 하여 잔고 금액을 변경하기 위한 메소드 
	public void deposit(int money) {
		this.balance += money;
	}
	// 출금을 위한 메소드 
	//	throws  키워드를 이용해 사용자 정의 발생 예외가 메소드 내부에서 발생하면 withdraw 메소드를 호출한 코드 줄로 가서 예외 처리 하라 
	public void withdraw(int money) throws InsufficientException{
		if(balance < money) {
			// 잔고 부족 출력 
			
			// 개발자가 강제로 예외를 발생시키는 코드를 작성해 놓을 수 있다.
			// throw 예약어를 사용해야 한다.
			// 문법  ->  throw new 강제로 발생시킬사용자정의예외클래스의 객체생성();
			throw new InsufficientException("잔고 부족 : " + (money - balance) + " 모자람");
		}
		// 잔고에서 차감 
		balance -= money;
	}
}
// 사용자 정의 예외 클래스 만들기 (발생한 예외 메세지 출력 + 예외 처리 메소드)
// 
class InsufficientException extends Exception{
		//	기본생성자  
		public InsufficientException() {  }
		
		// 예외메세지 하나를 매개변수로 전달 받는 생성자 
		public InsufficientException(String message) {
				super(message); // 부모 생성자 호출 
		}
}

public class AccountExample {

	public static void main(String[] args) {
		// Account 클래스의 객체 생성 
		Account account = new Account();
	
		// 10000 예금 하기 
		account.deposit(10000);
		
		// 10000원 예금 후 잔고 확인 
		System.out.println("예금액 : " + account.getBalance());
			
		// 30000원 출금 하기  -  withdraw(30000) 메소드 호출!
		//  참고 . 예금한 금액은 10000 인데 30000 을 출금하려고해서 개발자가 직접 만든 사용자정의예외처리종류 클래스의 객체를 생성해 강제로 예외를 발생시킴 
		try {
			account.withdraw(30000);  // <-- 메소드 호출한 곳!
		}catch(InsufficientException e) {
			// 발생한 예외의 이유 출력 
			String message = e.getMessage();
			System.out.println(message);
		}
		
		System.out.println("프로그램 종료");
	}

}
