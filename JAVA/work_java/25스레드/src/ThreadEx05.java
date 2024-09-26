/*
 	스토리 : 어떤 값을 입력하여 엔터키를 누르면 출력결과가 오랜시간뒤에 출력된다고 가정할때..
 				  출력결과를 보기전에 약간의 효과를 줘서 잠시만 기다려주세요 라는 메세지를 보조작업스레드를 이용하여 처리하기 
 			
 	예) 숫자 입력 : ~~~~
 			"잠시만 기다려주세요" <- 보조작업스레드가 처리 
 		  출력 결과 : ~~~~ 
 		 	
 */
// Runnable 인터페이스의 run 추상메소드를 강제로 메소드 오버라이딩 시킨 스레드 객체를 생성하기 위한 보조작업일반클래스 만들기 

import java.util.Scanner;

class TestThread implements Runnable{
	
	// 보조 작업스레드 객체가 처리할 일 작성 
	@Override
	public void run() {
		System.out.println("\n\n잠시만 기다려주세요...\n\n");
		
	}
	
}

public class ThreadEx05 {
	public static void main(String[] args) {
		System.out.print("숫자 입력 : ");
		// 키보드 표준입력장치로 부터 입력받은 숫자를 1바이트 단위로 읽어들일 바이트 스트림 생성 
		// 읽어 들인 바이트 데이터들을 쉽게 형변환 하는 메소드를 제공하는 Scanner 객체 생성시 바이트 스트림을 넣어서 생성하자 
		Scanner scanner = new Scanner(System.in); // 키보드와 연결된 통로 
		
		// 키보드로 부터 입력받은 숫자는 System.in 입력스트림 통로로부터 바이트 단위로 읽어들이기 때문에 읽어들인 바이트 데이터들을 
		// long 데이터로 변환해서 반환받아오기 위해 Scanner 객체의 newtLong 메소드 호출 후 변환해서 반환 받아온다.
		long num = scanner.nextLong(); // 입력한 숫자가 저장되어 있음 
		
		// 보조 작업스레드 객체 생성하자
		// 순서 1. run 메소드를 강제로 오버라이딩 해놓은 TestThread 일반클래스의 객체 생성 
		// 순선 2. 생성된 TestThread 객체의 주소번지를  Thread	클래스의 생성자로 전달해 
		//				저장시킨 new Thread(new TestThread()); 실제 보조작업스레드 객체 생성 
		Thread thread = new Thread(new TestThread());
		// 실제 보조작업스레드 객체에 일 시키기 위해 대기 상태로 만들기 
		thread.start(); // run 콜백 메소드가 JVM에 의해 자동으로 호출 될것임 
		
		// --------------------------------------------
		// 0 부터 입력받은 숫자 까지의 합을 저장할 누적변수 만들기
		long total = 0;
		
		for(long i =0; i <= num; i++) {
			total += i; // 0부터 1씩 중가시키면서 total 에 입력받은 숫자까지 반복해서 누적 
		}
		
		System.out.print("출력 결과 : " + total);
		
	}
}
