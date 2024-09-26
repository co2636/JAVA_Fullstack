
import java.util.Stack;

/*
 	동기화 (synchronized) : 자판기를 동시에 여러 보조작업스레드가 사용하려고 할때 데이터 일관성을 유지하기 위해 사용한다.
 											 synchronized 키워드는 특정 메소드나 블록이 여러 스레드에 의해 동시에 접근되는것을 방지 한다.
 	
 	wait() : 현재 스레드를 일시 중단시키고, 다른 스레드가 자원(자판기)에 접근할 수 있도록 합니다.
 	
 	notify() : wait() 메소드로 일시 중단 시킨 스레드를 깨워서 다시 실행 할 수 있게하는 메소드 
 	
 */
// 자판기 역할을 하는 클래스 <- 스레드가 아니고 공유데이터 역할을 하는 클래스
class AutoMachine{
	// 자판기를 스택메모리를 생성해서 사용
	Stack store = new Stack();
	
	// 소비자 스레드 객체가 자판기에서 음료를 뽑아먹는 행동의 메소드
	public synchronized String getDrink() {
		
		try {
			this.wait(); // 공급자 스레드가 음료를 공급할때까지 기다려~~ 대기해라~
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		return store.pop().toString(); // 어떤 음료수를 뽑아먹었는지 음료수 번호를 문자열로 반환 
	}
	// 공급자 스레드 객체가 자판기에 음료를 공급하는 행동의 메소드
	public synchronized void putDrink(String drink){
		
		this.notify(); // wait() 메소드를 호출하여 대기중인 소비자 스레드 객체를 깨움 
		
		// 자판기(Stack 메모리)에 음료를 집어 넣기(공급)
		store.push(drink);
	}
}

// 음료를 공급할 공급자 스레드 객체를 ()생성하기 위한 스레드 클래스 
class Producer implements Runnable{
	
	// 자판기 역할을 하는 AutoMachine 클래스의 객체 주소번지를 저장할 참조변수 선언
	private AutoMachine machine;
	
	// 생성자 
	public Producer(AutoMachine machine) {
		this.machine = machine;
	}
	// 자판기에 9개의 음료수 공급(넣자) run 메소드 오버라이딩
	@Override
	public void run() {
		// 9번 반복해서 음료 공급
		for(int i = 1; i <10 ; i++) {
			System.out.println(Thread.currentThread().getName() + " : 음료수 NO." + i + "를 공급 함 ");
			// 실제로 AutoMachine 객체 내부에 만들어져 있는 Stack 자판기 메모리에 문자열 형태의 "음료수 No.1" 등 공급 
			machine.putDrink("음료수NO." + i);
			
			// 0.1 초 공급자 스레드 휴식 후 넣자
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// 음료를 구입해서 자판기에서 뽑아 먹는 소비자 스레드 객체를 생성하기 위한 클래스 
class Consumer implements Runnable{
	
	// 자판기 역할을 하는 AutoMachine 클래스의 객체 주소번지를 저장할 참조변수 선언
	private AutoMachine machine;
	
	// 생성자
	public Consumer(AutoMachine machine) {
		this.machine = machine;
	}
	
	// 자판기에 공급된 9개의 음료수를 구입하여 뽑아 먹는 행동의 메소드
	// 스레드 작업 
	@Override
	public void run() {
		for(int i = 1; i< 10 ; i++) {
			 // 음료수를 뽑아 먹고 있다는 것을 보여주기 위해 출력
			System.out.println(Thread.currentThread().getName() + " : " + machine.getDrink());
			
			// 0.1 초 휴식후 음료수 뽑아먹는 행동 보이게 보조작업스레드 대기
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class SyncThreadEx2 {
	public static void main(String[] args) {
		
		// 자판기 객체 생성
		AutoMachine autoMachine = new AutoMachine();
		
		// 공급자스레드 (보조작업스레드객체) 생성 후 일 시키기
		new  Thread(new Producer(autoMachine), "정우 공급자").start();
		
		// 소비자스레드 (보조작업스레드객체) 생성 후 일 시키기
		new Thread(new Consumer(autoMachine), "길동 소비자").start();
		
		
	}
}
