package ch08.sec02;
/*
 	인터페이스(Interface) 란?
 	- 다른 자식 클래스를 새롭게 작성할 때  기본이 되는 추상메소드명 틀을 제공하면서 다른 자식 클래스 사이의 
 		중간매개 역할까지 담당하는 일종의 추상클래스보다 더 추상화된 미완성 설계도.
 
 	-	인터페이스 내부에는 추상메소드와 상수로만 이루어져 있다. 하지만 자바버전이 업데이트 됨에 따라 다른 멤버들도 추가로 작성할수 있다. 
 		
 	- 추상클래스 보다 더 추상화된 미완성 설계도.
 	
 	인터페이스가 생겨난 이유?
 	- 하나의 클래스는 다른 여러개의 클래스(추상클래스 포함)들을 다중 상속할 수 없기 때문에 인터페이스가 나왔다.
 	- 인터페이스는 다른 인터페이스를 상속할 수 있고, 다른 자식 클래스를 다중 implement 구현 할 수 있다. 
 	
 	인터페이스를 만드는 문법 
 		// default 접근 제어자를 붙여 인터페이스를 만든다.
 		 interface 인터페이스명{  ... } 
 		
 		// public  접근제어자를 붙여 인터페이스를 만든다.
 		 public interface 인터페이스명{ ... }
 	
 	
 	
 	인터페이스 내부에 작성되는 멤버들
 			
 			interface 인터페이스명{
 			
 				// public 상수선언 (final 상수 선언 가능)
 				 
 				// public 추상메소드 선언 ( 구현부가 없는 메소드 선언 가능)
 				 
 		// 참고. 자바 JDK8 부터 추가된 기능 		 
 				// public default 디폴트메소드 선언  (기본 구현부를 제공하는 메소드 선언 가능)
 			    // public static  정적메소드 선언  
 			     
 		// 참고. 자바 JDK9 부터 추가된 기능 
 				// private 은닉메소드 선언 
 				// private static 은닉정적메소드 선언 
 				  
 				  
 			}
 	
 */

interface RemoteControl{ // 미완성 설계도 
	
//	interface 내부에 상수를 선언할때 final 을 생략하면 변수는 상수메모리로 인식함 
	final int MAX_VOLUME = 10; // 상수 
			int MIN_VOLUME = 0; // 상수 
			
	// public 추상메소드 선언 
	// 참고. 추상메소드를 작성할때 abstract  생략해도 추상메소드가 된다.
	public abstract void turnOn();
	
							   void turnOff();
								
							   void setVolume(int volume);
								
	/*
	 		인터페이스는 구현 클래스(자식 클래스) 가 재정의하는 public 추상메소드를 멤버로 가질수 있다.
	 		추상메소드는 리턴타입, 메소드명, 매개변수만 기술되고 중괄호{}를 붙이지 않는 메소드를 말한다.
	 		public abstract 를 생략하더라도 컴파일 과정에서 자동으로 붙게된다. 
	 						   
	 */
	/*
	 		디폴트 메소드
	 		- 인터페이스에는 완전한 실행코드를 가진 default 메소드를 선언할 수 있다.
	 		   추상메소드는 실행부(중괄호{})가 없지만 default 메소드는 실행부가 있다.
	 		  
	 		   선언방법 
	 		   					public default 리턴타입  메소드명(매개변수, ... ){ 실행부 }
	 		
	 */
	public default void setMute(boolean mute) {
		
			if(mute) {
				System.out.println("무음 처리합니다.");
				// 추상메소드 호출하면서 상수 사용
				setVolume(MIN_VOLUME);
			}
			else {
				System.out.println("무음을 해제합니다.");
			}
			
	}
	
	/*
	 		정적 메소드
	 		- 인터페이스에는 정적메소드도 선언이 가능하다.
	 		- 추상메소드와 디폴트 메소드는 구현 객체가 필요하지만, 정적메소드는 구현객체가 없어도 인터페이스명만으로 호출 할 수 있다.
	 			선언 방법은 클래스 정적메소드(static 메소드) 와 완전 동일하다.
	 			단 , public 을 생략하더라도 자동으로 컴파일 과정에서 붙는것이 차이점이다.
	 			
	 		- 문법	
	 					public | private static 리턴타입 정적메소드명 (매개변수, ...) { 실행코드 }
	 */
		// 배터리 교환하는 기능을 가진 changeBattery() 정적메소드 선언
		static void changeBattery() {
			System.out.println("리모콘 건전지를 교환합니다.");
			
			// 정적 메소드 내부에서는 주의할 점이 있는데 
			// 상수를 제외한  추상메소드, 디폴트메소드, private 메소드등을 호출할 수 없다는 점이다.
		}
		
}
//--------------------------------------------------------------------------
/*
 		특정 인터페이스 내부에 만들어 놓은 추상메소드를 강제로 오버라이딩해서 새로운 자식클래스를 설계하는 문법
 		
 		class  자식클래스명  implements  부모인터페이스명 {
 		
 				인터페이스에 만들어 놓은 추상메소드를 강제로 메소드오버라이딩 코드 작성;
 				
 				자식 클래스의 일반메소드 선언 
 				
 		}
 		
 		implements : 인터페이스 안에 만들어 놓은 추상메소드를 강제로 재구현(오버라이딩)함 
 		
 */
// 해석 : Television 새로운 자식 클래스를 만들때 RemoteControl  인터페이스 안에 만들어 놓은 추상메소드 들을 강제로 오버라이딩해서 만들겠다.
class Television implements RemoteControl{

	// 변수 
	private int volume;
	
	// RemoteControl 부모인터페이스 내부에 만들어 놓은 추상메소드를 강제로 오버라이딩 
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
		
	}

	// RemoteControl 부모 인터페이스 내부에 만들어 놓은 추상메소드를 강제로 오버라이딩
	// 참고. 재정의 할때 주의할 점은 인터페이스의 추상메소드는 기본적으로 public 접근제어자를 가지기 때문에
	// public 보다 더 낮은 접근제어자로 재정의 할 수 없다. 그래서 재정의 되는 메소드는 모두 public 이 추가됨 
	@Override
	public void setVolume(int volume) {
		
		// 인터페이스 상수를 이용해서 volume 변수의 값을 제한 할 수 있다.
		if(volume > RemoteControl.MAX_VOLUME) {
			
			this.volume = RemoteControl.MAX_VOLUME;
			
		} else if(volume < RemoteControl.MIN_VOLUME) {
			
			this.volume = RemoteControl.MIN_VOLUME;
			
		}else {
		
			this.volume = volume;
			
		}
		
		System.out.println("현재 TV볼륨 : " + this.volume);
		
		
	}
	
}

// 해석 : 새로운 자식클래스인 Audio 클래스를 만들떄..
// 			RemoteControl 인터페이스 내부의 추상메소드를 강제로 오버라이딩해서 만들겠다.
class Audio implements RemoteControl{

	// 변수
	private int volume;
	
	private int memoryVolume;
	
	// RemoteControl 인터페이스에 만들어 놓은 default 메소드 오버라이딩 
	// - 메소드 오버라이딩시 주의할 점은 public 접근제어자는 반드시 붙여야하고 default 키워드는 생략해야한다.

	@Override
	public void setMute(boolean mute) {
		// 재구현 
		if(mute) {
			this.memoryVolume = this.volume;
			System.out.println("무음 처리 합니다.");
		}else {
			System.out.println("무음 해제 합니다.");
			// mute 가 false 일 경우 원래 볼륨으로 복원하는 코드 
			setVolume(this.memoryVolume);
		}
	} 
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
		
	}

	@Override
	public void turnOff() {

		System.out.println("Audio를 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		
		// 인터페이스 상수를 이용해서 volume 변수의 값을 제한 할 수 있다.
				if(volume > RemoteControl.MAX_VOLUME) {
					
					this.volume = RemoteControl.MAX_VOLUME;
					
				} else if(volume < RemoteControl.MIN_VOLUME) {
					
					this.volume = RemoteControl.MIN_VOLUME;
					
				}else {
				
					this.volume = volume;
					
				}
				
				System.out.println("현재 Audio 볼륨 : " + this.volume);
		
		
	}

	
	
}


public class RemoteControlExample {

	public static void main(String[] args) {

		// 인터페이스자료형으로 참조변수선언이 가능하고 업캐스팅이 가능하다.
		
		// 부모인터페이스 = RemoteControl
		//  자식클래스 = Television 
		
		// 업캐스팅
		// 문법
		// 부모인터페이스자료형 참조변수선언 = new 자식생성자();
		RemoteControl  rc = new Television();
									rc.turnOn(); // 오버라이딩된 메소드 호출
									// TV를 켭니다.
									
									rc.setVolume(5); // 오버라이딩된 메소드 호출
									// 현재 TV볼륨 : 5
									
//									rc.turnOff();  // 오버라이딩된 메소드 호출 
									// TV를 끕니다.
									
									//default 메소드 호출 
									rc.setMute(true);
									// 무음 처리합니다.
									// 현재 TV볼륨 : 0
									
									rc.setMute(false);
									// 무음을 해제합니다.
									
								System.out.println("-------------------------");
		
							// 업캐스팅
							rc = new Audio();
							rc.turnOn(); // 오버라이딩된 메소드 호출 
							rc.setVolume(5); 
//							rc.turnOff();
							
							// 디폴트 메소드 호
							rc.setMute(true);
							rc.setMute(false);
							
							// 상수는 자식 구현객체와 관련없는 인터페이스 소속멤버이므로 인터페이스명으로 바로 접근해서 상수에 저장된 값을 읽어 올수 있다.
							// 문법
							//			인터페이스명.상수명 
							System.out.println("리모콘 최대볼륨 : " + RemoteControl.MAX_VOLUME);
							System.out.println("리모콘 최소볼륨 : " + RemoteControl.MIN_VOLUME);
							
							System.out.println("--------------------------");
							
							// static 정적메소드 호출 (인터페이스 내부에 만들어 놓은)
							// 인터페이스명.정적메소드명();
							RemoteControl.changeBattery(); // 리모콘 건전지를 교환합니다. <-- 출력 
	}

}
