
// 주제 : 보조 작업 스레드 객체를 생성하기 위한 사용자 정의 스레드 클래스 만들기
// 방법1. Thread 클래스를 상속받아  ThreadDemo 라는 이름으로 스레드 클래스 만들기
class ThreadDemo extends Thread{
	// 숫자를 카운팅 해서 저장할 int count 변수 선언
	int count;
	
	// 보조 작업스레드(ThreadDemo) 객체 생성시 스레드 이름을 매개변수로 받아 초기화할 생성자 선언 
	// 단! 생성자 내부에서 run 메소드가 실행되게 start() 메소드를 호출해 주세요.
	public ThreadDemo(String name) {
		super(name);
		this.start();
	}
	
	// 보조 작업 스레드가 하는 작업을  run 메소드를 오버라이딩해서 선언
	@Override
	public void run() {
		// 재구현 내용
		// 현재 실행되고 있는 보조작업스레드객체의 이름을 얻어 일 "시작" 출력
		System.out.println(this.getName() + " 일 시작");
		
		// 0 ~ 9까지 1씩 증가시키면서 1초 간격으로 숫자를 반복해서 출력하는 일 
		do {
			// 현재 작업중인 보조스레드객체에 1초 휴식 
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			// 현재 보조작업스레드가 run 메소드를 실행하고 있으며 스레드 이름을 받아 같이 출력  
			System.out.println(this.getName() + ", 카운터 =  " + this.count);
			
			count++;
		}while(count<10);
//		for(int i = 0; i< 10; i++) {
//			System.out.println(this.getName() + " : " + count);
//			try {
//				Thread.sleep(1000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			count++;
//		}
		// 현재 실행되고 있는 보조작업스레드객체의 이름을 얻어 일 "끝" 정보 출력
		System.out.println(this.getName() + " 일 끝");
	}
}

public class ThreadEx02 {
	
	// 주(메인)스레드 : 보조작업스레드 객체 생성  0.5초 간격으로 . 을 10번 반복해서 출력함 
	public static void main(String[] args) throws InterruptedException {
		System.out.println("메인스레드 일 시작");
		
		// 보조작업스레드 객체 생성  
		new ThreadDemo("보조작업스레드객체1"); 
		
		// 메인스레드  0.5초 간격으로 . 을 10번 반복해서 출력
		int count = 0;
		
		do {
			// 메인스레드에게 0.5초 휴식
			Thread.sleep(500);
			
			System.out.print(".");
			
			count++;
		}while(count < 10);
		
//		for(int i=0; i<10; i++) {
//			System.out.println(".");
//			try {
//				Thread.sleep(500);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		System.out.println("메인스레드 일  끝");

	}
}
/*
 	 결론 : 
 	 
 	 
 */


