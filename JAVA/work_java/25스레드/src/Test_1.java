/*
 	사용자 정의 보조작업스레드 클래스 만드는 방법 2
 	- Runnable 인터페이스 내부에 만들어져 있는 추상메소드 run 을 메소드 오버라이딩 받은 일반클래스를 만들고
 	   만든 일반클래스의 객체를 생성해서 주소번지를 실제 자바문법에서 제공해주는 Thread 클래스의 객체 생성시 생성자로 전달하여 
 	   new Thread(일반 클래스의 객체 주소); 보조작업스레드 객체 만들기 
 	
 */
// 일반 클래스 : 스레드가 할일을 코드로 작성해 놓을 run 메소드를 오버라이딩 해 놓은 일반 클래스 
public class Test_1 implements Runnable {

	// 실제 보조 작업스레드 객체의 주소를 저장할 변수 선언
	Thread thread;
	
	// new Test(보조작업스레드이름); 객체 생성시 보조작업스레드 이름을 초기화할 생성자
	public Test_1(String name) { // "첫 번째 스레드"
		// 아래의 main 메소드 내부에서 Test_1 일반클래스에 대한 객체 생성시 생성자로 보조스레드객체의 이름을 전달하여 받아 저장 
		thread = new Thread(this, name);
		
		// 보조작업스레드 객체에 만들어져 있는 run 메소드 실행되게 호출 
		thread.start();
	}
	
	// 보조 작업 스레드 객체의 작업 
	@Override
	public void run() {
		// 숫자 0 ~ 4까지 sum 변수에 누적해서 출력 
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);  // 현재 실행중인 보조작업스레드 객체에게 1초 휴식 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum += i;
											// thread.getName() <- 이 방법은 현재 run 메소드로 작업중인 보조작업스레드객체 이름 반환 
			System.out.println(Thread.currentThread().getName()  + " : " + sum);
		}
	}
	
	// 주(메인)스레드 역할은 보조작업스레드 객체 생성해서 일처리하게 하기 
	public static void main(String[] args) {
		
		// run 메소드를 오버라이딩 해놓은 일반 Test 클래스의 객체 생성
		new Test_1("첫 번째 스레드");
		new Test_1("두 번째 스레드");
		
	}
}
