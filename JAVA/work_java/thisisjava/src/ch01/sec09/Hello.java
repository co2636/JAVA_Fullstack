//패키지 선언이라고 부르며 Hello.java 소스파일이 src 폴더/ch01폴더/sec08폴더에 만들어져 있다.
//라고 JVM에게 알려주는 코드 한
package ch01.sec09;

/**
 * 
 * Hello.java 파일은 기초를 알기위한 첫번째 작성된 파일이다.
 * @author 이준희
 *  
*/


/*
 	public class Hello 를 클래스선언(설계도선언)부분의 코드이고 
 	Hello 를 클래스(설계도)명이라고 한다.
 	
 	1. 클래스명은 숫자로 시작할 수 없고 , Hello.java소스파일명과 대소문자가 완전히 일치해야한다.
 	2. 그 다음에 작성된 {}를 클래스(설계도) 블록(영역)이라고 하며, 
 	   {}내부에는 클래스(설계도)의 변수 + 메소드 맴버들을 기술해서 작성할 수 있다.
 */
public class Hello {

	// 변수 + 메소드 만들어 놓는 곳
	
	// main 이라는 이름의 메소드를 정의해 놓았음
	// main 메소드 또한 {} 중괄호를 이용해 자신만의 블록(영역)을 나타낸다.
	// main 메소드는 자바프로그램 실행 진입점이라고 부른다.
	public static void main(String[] args) {
		
		// 실행 코드 -> "Hello, Java" 데이터를 이클립스의 Console 탭에 출력하는 기능 
		System.out.println("Hello, Java");
		System.out.println("안녕 오늘 처음 배움");
		
		// 정수 하나의 값을 저장할 x 라는 이름의 변수 선언
		// 자료형 변수명;
		int x;
		
		//변수 x 에 1값 저장 
		x = 1;
		
//		int y; // 변수 y 를 선
//		y = 2; // 변수 y 에 2를 대입해서 저장
		
		// 변수 y 를 선언하는 동시에 값 2를 저장
		int y = 2;
		
		//변수 result 를 선언하고 변수 x 와 y 에 저장된 값의 합을 result 변수에 저
		int result = x + y;
		//		   = 1 + 2;
		
		System.out.println(result);
		
		System.out.print(result); 
		

	}

}
