package ch08.sec11;


interface Vehicle{
	//추상메소드 
	void run(); //달리는 기능
}

//Vehicle부모인터페이스안의 추상메소드를 재정의(오버라이딩,재구현)한 자식 Bus클래스 만들기
class Bus implements Vehicle {
	@Override
	public void run() {
		//재구현
		System.out.println("버스가 달립니다");
	}
}
//Vehicle부모인터페이스안의 추상메소드를 재정의(오버라이딩,재구현)한 자식 Taxi클래스 만들기
class Taxi implements  Vehicle{
	@Override
	public void run() {
		//재구현
		System.out.println("택시가 달립니다");
	}
}

//운전자 클래스
class Driver{
	//Vehicle부모인터페이스를 구현 다양한 자식객체주소를 전달받기 위해
	//매개변수를 선언했다.
	void dirve(Vehicle vehicle) {  //new Bus();
		vehicle.run(); //부모인터페이스의 추상메소드를 구현한 자식객체의 메소드호출
	}
}

public class DriverExample {
	public static void main(String[] args) {
		//Driver클래스의 객체 생성
		Driver driver = new Driver();
		
		//Vehicle인터페이스를 구현한 자식객체들 생성
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		//Driver객체의 drive메소드 호출시 매개변수로 어떤 자식객체를 전달하는지에 따라
		//drive메소드 내부에서 호출되는 run()메소는 전달한 자식객체 내부의 오버라이딩해 놓은 메소드 호출되어
		//실행된다.
		driver.dirve(bus); //<- new Bus()객체 내부의 run메소드가 실행 
		driver.dirve(taxi);//<- new Taxi()객체 내부의 run메소드가 실행
		

	}

}











