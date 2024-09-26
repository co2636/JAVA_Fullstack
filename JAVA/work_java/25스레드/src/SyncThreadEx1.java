
// 화장실 클래스 (설계도)  <---------- 스레드 아님 
class Toilet{
	
	public synchronized void openDoor(String name) {
		// 가족 구성원 가족 스레드들 중에서 화장실 문으로 입장하는 것을 보여주기 위해 출력 
		System.out.println(name + " 화장실 문으로 입장함");
		
		// 대변을 보는 시간을 억번 반복해서 출력
		for(int i=0; i<100000000; i++) {
			// i 변수값이 10000 이 되면 효과를 출력
			if(i == 10000) {
				System.out.println(name + " : 끄으응~~~");
			}
		}
		// 대변을 다 본 효과 출력
		System.out.println(name + " : 아~ 시원해~ ");
		
	}	
}

// 가족 설계도 (보조작업역할을 하는 클래스)  <----------- 각각 가족 단위로 스레드 객체 생성될 것임 
class Family extends Thread{
	//공용으로 사용할 화장실(Toilet 클래스의 객체) 주소를 저장할 참조변수 선언 
	Toilet toilet ;
	// 가족의 구성원 중에서 한 사람(보조 작업 스레드 Family 객체)의 이름을 저장할 변수 선언 
	String who;
	
	// 생성자 - 화장실(new Toilet();) 객체의 주소, Family 스레드 객체의 주소를 매개변수로 받아 초기화할 생성자 
	public Family(Toilet toilet , String who) {
		this.toilet = toilet;
		this.who = who;
	}
	// 화장실 문으로 특정 Family 가족객체가 들어가서 대변을 보는 행동을 표현하는 일
	// 스레드 작업
	@Override
	public void run() {
		toilet.openDoor(this.who);
		
	}
}

public class SyncThreadEx1 {

	public static void main(String[] args) {
		
		// 화장실 객체(각 Family 보조작업스레드객체가 공용으로 사용할 메모리) 생성 
		Toilet toilet = new Toilet();
		
		// 각각의 가족구성원역할을 하는 보조작업스레드 Family 객체들(아빠, 엄마, 누나, 형, 나) 생성 
		Family father = new Family(toilet, "아버지");
		Family mother = new Family(toilet, "어머니");
		Family sister = new Family(toilet, "누나");
		Family brother = new Family(toilet, "형");
		Family me = new Family(toilet, "나");
		
		// 각각의 가족 Family 보조작업 스레드 객체들 일시키기
		father.start();
		mother.start();
		sister.start();
		brother.start();
		me.start();

	}

}
