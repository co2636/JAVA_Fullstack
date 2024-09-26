
// 참고. 스레드란? 하나의 작업 
// 예제. 자바 문법에서 제공해 주는 Thread 클래스를 상속받아 개발자가 직접 Thread01  스레드역할의 클래스 만들기

// Thread 클래스를 상속받아 스레드역할을 하는 클래스를 만드는 이유
// -> 자바에서 run 메소드의 역할은 하나의 작업을 처리하는 코드를 여기에 작성해 놓기 때문에 
//   Thread 클래스에 run 메소드가 만들어져 있으므로 상속받아서 메소드 오버라이딩 해야합니다. 

// 보조스레드(작업)
// -   0 ~ 4 까지 5번 반복하면서 sum 변수에 차례로 누적하여 sum 변수에 저장된 값을 출력하는 하나의 작업 
public class ThreadEx01_1 extends Thread{
	
	// 현재 작업중인 스레드의 이름을 저장할 변수 
	String name;
	
	// ThreadEx01 스레드 객체 생성시 스레드 이름을 매개변수로 받아 초기화 할 생성자 
	public ThreadEx01_1(String name) {
		super(name); // extends 해준 Thread 부모객체의 생성자를 호출해 전달한 매개변수값을 스레드 이름으로 저장함
	}
	
	// Thread 부모클래스의 run 메소드 오버라이딩 
	// 이유 : 스레드의 작업을 처리하는 콜백메소드 이기 때문이다.
	// 콜백메소드란? 개발자가 직접 호출하는 메소드가 아니라 거꾸로 자바컴파일러가 특정시점에 자동으로 호출해주는 메소드
	@Override
	public void run() {
		// 숫자 0 ~ 4까지 sum 변수에 누적해서 출력 
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			
			try {
				/*
				 	Thread 클래스의 public static void slepp (long milis) 메소드
				 	- 현재 작업 중인 스레드 객체를?  매개변수 milis 로 전달한 시간동안 일시적으로 정지시키는 기능의 메소드
				 		이 메소드를 호출하면 스레드를 일시적으로 정지시켜 다른 보조스레드객체에게 실행 기회를 양보 하거나, 일정한 시간 간격을 가지고 작업을 
				 		수행시킬수 있다. 
				 	- 매개변수 long milis에는 스레드 를 일시 정지할 시간을 1000분의 1초 단위값(밀리초 단원)로 지정한다.
				 	- 예외 : InterruptedException 
				 				 sleep() 메소드가 실행중에 다른 보조 스레드에 의해 인터럽트되었을때 위 예외가 발생한다.
				 				 
				 */
				Thread.sleep(3000);  // 현재 실행중인 보조작업스레드 객체에게 3초 휴식 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sum += i;
										// 현재 CPU가 점유한 보조스레드 객체의 이름을 얻기위해 상속받은 getName() 메소드를 호출하여 반환받음 
			System.out.println(this.getName()  + " : " + sum);
			
		}
	}
	
	// 주 스레드 : 주요 작업을 처리하는 주 스레드 역할을 하는 main 메소드 
	public static void main(String[] args) {
		// 보조 스레드 클래스를 이용해서 보조 스레드 역할을 하는 보조스레드 객체 생성해서 사용 
		 ThreadEx01_1 t1 = new ThreadEx01_1("첫 번째 스레드"); // 보조스레드1
		 ThreadEx01_1 t2 = new ThreadEx01_1("두 번째 스레드"); // 보조스레드2
		 
		 // 참고. 총 스레드는 3개이다. main(주스레드), 보조스레드1, 보조스레드2
		 /*
		  	Thread 클래스는 start() 메소드를 제공해 준다./
		  	start ()메소드는 직접 run() 메소드를 호출하게 하는 메소드는 아니며 자바 JVM 가상머신에게 
		  	보조스레드객체가 각각 준비가 되었으니 자바 JVM 가상머신에게 run() 메소드를 호출하라고 부탁하는 메소드이다. 
		  	요약 : run() 메소드를 호출해서 스레드 작업을 할 수 있게 보조 스레드객체를 준비 시킨다. 
		  */
		t1.start();
		t2.start();

	}


}
