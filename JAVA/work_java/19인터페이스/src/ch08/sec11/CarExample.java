package ch08.sec11;

// 부모인터페이스 역할을 함
interface Tire{
	// 추상메소드
	void roll(); // 굴러간다는 의미의 메소드 
}

// Tire 부모인터페이스의 roll 추상메소드를 구현한 (메소드오버라이딩한) 자식 HankookTire 클래스 만들기 
class HankookTire implements Tire{

	@Override
	public void roll() {
		System.out.println("한국 타이어가 굴러갑니다.");
	}
}

//Tire 부모인터페이스의 roll 추상메소드를 구형한 (재정의, 메소드 오버라이딩)
// 자식 KumhoTire 클래스 만들기 
class KumhoTire implements Tire{

	@Override
	public void roll() {
		System.out.println("금호 타이어가 굴러갑니다.");
	}
}

// Car 클래스 만들기 
class Car{
	// 변수(필드)
	// ->  금호타이어 또는 한국타이어 클래스의 객체의 주소를 저장할 변수
	// 부모인터페이스 자료형 참조변수 = new  자식클래스의 생성자호출();
	Tire tire1 = new HankookTire(); //  <- new KumhoTire(); 나중에 대신 저장 
	Tire tire2 = new HankookTire(); //  <-new KumhoTire(); 나중에 대신 저장 
	
	// 메소드(함수)
	void run() {
		// this.tire1 이라고하는것은 Car 객체 메모리에 포함되어 있는 Tire 인터페이스 자료형의 참조변수 tire1에 저장된 new HankookTire() 객체 메모리에 접근한다는 의미이다.
		// 그리고 this.tire1.roll(); 이라고 하는것은 new 로 만든 HankookTire 객체 메모리안에 메소드 오버라이딩 해놓은 roll 메소드 호출
		this.tire1.roll();
		this.tire2.roll();
	}
}

public class CarExample {

	public static void main(String[] args) {
		//Car 클래스의 객체생성(자동차 객체 생성)
		Car myCar = new Car();
		
		// run() 인스턴스 메소드 호출 
		myCar.run();
		
		// 타이어의 종류 교체 
		// 금호 타이어 객체로 변경
		// 참고. Car객체의 인스턴스변수 tire1, tire2 두 개 모두 new KumhoTire() 객체를 2개 생성해서 모두 저장 
		//		저장할 수 있는 이유 - 모두 Tire 부모인터페이스 자료의 참조변수 tire1, tire2로 선언되어 있음 
		myCar.tire1 = new KumhoTire(); // 업캐스팅 
		myCar.tire2 = new KumhoTire(); // 업캐스팅 
		
		//run() 인스턴스 메소드 호출 
		myCar.run();
		
	}

}
