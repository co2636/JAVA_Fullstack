
// 주제 :  Thread 클래스에서 제공하는 interrupt() 메소드를 이용하여 현재 작업 중인 (run() 메소드가 실행되는 중인) 보조작업 스레드 강제로 대기 시키기 

// 보조작업스레드 객체를 생성하기 위한 run 추상메소드를 오버라이딩 해놓은 일반클래스 만들기 
class StopThreadDemo2 implements Runnable{
	// 보조작업 Thread 객체가 할일을 run 메소드에 작성 
	@Override
	public void run() {
		// 현재 보조 작업 스레드 객체를 중지(대기)해라   명령( intterupt();) 을 내리지 않았으면 계속 반복해서 출력작업하기

			try {
				while( !Thread.currentThread().isInterrupted()) {
					System.out.println("현재 보조작업 스레드 객체는 작업중이다......");
					// 보조작업 스레드 객체 0.5초 대기(휴식)
					Thread.sleep(500);
				}
				
			} catch (InterruptedException e) {
				System.out.println("interrupt() 메소드를 호출하여 보조작업스레드 객체 강제 중지 시킴");
			}finally {
				// while 반복문의 실행이 끝나면 무조건 한번 출력되는 구문 
				System.out.println("보조작업스레드객체는 현재 Dead.......");
			}
			
	}
}


public class StopThreadEx2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("--- interrupt() 메소드를 이용한 보조작업스레드 객체 강제로 중지 기능 시작");
		
		// 보조작업스레드 객체 생성 
		Thread thread = new Thread( new StopThreadDemo2());
		// 보조작업스레드 객체 일시키기
		thread.start();
		
		// 메인 스레드 1초 휴식(대기) 시킨 후 작업
		Thread.sleep(1000);
		
		// 현재 작업하고 있는 보조작업스레드객체의 run 메소드의 일을 중간에 강제로 중지하는 명령 
		thread.interrupt();
	}

}
