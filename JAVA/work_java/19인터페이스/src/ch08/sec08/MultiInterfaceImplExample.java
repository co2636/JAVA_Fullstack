package ch08.sec08;

// 전원을 켜고, 끄는 추상메소드를 설계해 놓은 인터페이스 
interface RemoteControl {
	// 추상메소드 
	/* public abstract */ void turnOn();
									  void turnOff();
}

// 검색 기능을 추상메소드로 설계해 놓은 인터페이스 
interface Searchable {
	// 추상메소드 
	void search(String url);
	
}
// 전원을 켜고, 끄고, 검색을 구현하기위한 SmartTelevision 자식클래스 새롭게 설계 
class SmartTelevision implements RemoteControl, Searchable{

	// 두 부모인터페이스 내부에 작성된 모든 추상메소드를 강제로 오버라이딩 해야 함 
	@Override
	public void search(String url) { // Searchable 인터페이스의 추상메소드 오버라이딩 
		System.out.println(url + "을 검색합니다.");
		
	}
	@Override
	public void turnOn() { //  RemoteControl 인터페이스의 추상메소드 오버라이딩 
		System.out.println("TV를 켭니다.");
		
	}
	@Override
	public void turnOff() { //  RemoteControl 인터페이스의 추상메소드 오버라이딩 
		System.out.println("TV를 끕니다.");
		
	}

}

public class MultiInterfaceImplExample {

	public static void main(String[] args) {
		// 업캐스팅 : 부모인터페이스 자료형의 참조변수에 자식객체의 주소를 저장 
		RemoteControl rc = new SmartTelevision();
		
		//업캐스팅 후 부모인터페이스 자료형의 참조변수 rc 로 뒤에 생성된 SmartTelevision 객체의 멤버는 
		// RemoteControl 인터페이스에 만들어 놓은 turnOn(), turnOff() 메소드만 호출해서 사용할 수 있다. 
		rc.turnOn();
		rc.turnOff();
		// Searchable 부모인터페이스에 정의한 메소드 이므로 RemoteControl 부모인터페이스 참조변수로 호출이 불가능함 
		// rc.search("https://www.naver.com");
		
		// 업캐스팅 
		Searchable searchable = new SmartTelevision();
//							sarchable.turnOn(); // 호출 불가능 
//							sarchable.turnOff(); // 호출 불가능 
							
		searchable.search("https://www.youtube.com"); // 호출 가능 
		
	}

}
