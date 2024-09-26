
// 주제 : 플래그 변수를 이용하여 현재 run 이 실행중인 보조작업스레드 강제로 중지시키기

// 보조작업스레드 객체를 생성하기 위한 일반 클래스
class StopThreadDemo1 implements Runnable{
	
	// 플래그 변수 : 스레드가 작업을 하고 있는지 하고있지 않는지 판단할 값 true 또는 false 를 저장할 변수 
	private boolean stoped = false;
	
	// 보조작업스레드 객체가 할일 구현해 놓는 메소드
	@Override
	public void run() {
		// 플래그 변수에 저장된 값이 true 일때만 계속 반복해서 일을 함 
		while( !stoped ) {
			// 메세지 출력하는 일
			System.out.println("보조작업스레드 객체는 현재 동작하고 있다.");
			
			// 보조 작업스레드 객체 0.5초 대기상태로 만들기(휴식)
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} // while
		System.out.println("보조작업스레드 객체는 현재 Dead..................");
	
	} // run
	
	// 현재 작업하고 있는 보조작업스레드 객체가 중지되었다고 판단할 값을 저장하는 기능의 메소드
	public  void stop() {
		stoped = true;
	}

	// 메인스레드가 하는일을 작성해 놓은 일반 메소드 만들기
		// 하는일 : 보조작업스레드 객체를 생성하고 작업시작시키는 일 
		public void process() {
			// 순서 1. run 메소드를 강제로 오버라이딩 해놓은 일반 StopThreadDemo1 객체 생성 
			StopThreadDemo1 std = new StopThreadDemo1();
			
			// 순서 2. 생성된 StopThreadDemo1 객체 메모리의 주소번지를 생성자로 초기화 한 실제 보조작업스레드 객체 생성 
			Thread thread = new Thread(std);

			//보조작업스레드 객체 일 시키기
			thread.start();
			
			// 보조작업스레드 작업시킨후 메인 스레드 1초 휴식
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// StopThreadDemo1 일반클래스의 객체 내부에 만들어져 있는 stop 인스턴스 메소드를 호출하여 플래그 변수값을 false 에서 true 로 변경
			// 즉! 강제로 보조작업스레드 객체 작업 중지 시키기!
			std.stop();
			
		}
	
} 

public class StopThreadEx1 {
	public static void main(String[] args) {
		
		System.out.println("## 플래그 변수를 이용한 스레드 강제 중지 기능 시작");
		new StopThreadDemo1().process();
	}
	
}
