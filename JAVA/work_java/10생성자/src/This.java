/*
 	this	키워드 
 	-  This class 설계도 내부에 this 를 작성하면 this 는 현재 객체 자신을 가리키는 참조변수 
 		예) new This();  <-- 0x16 객체메모리의 주소 번지 
 		 
 	- 사용목적
 		- 객체변수와 매개변수명이 같을때  this.객체변수명 = 매개변수명; 
 			this.을 작성하여 객체메모리의 객체변수를 가리킬때 사용됨 
 			
 		- 생성된 객체의 메소드나 변수에 접근 : 객체자신의 메소드나 변수에 접근할때 this 를 사용할 수 있다.
 		
 	this()
 	- 자바에서 생성자 내부에서 다른 생성자를 호출할때 사용되는 키워드이다.
 	- 같은 클래스 내부의 생성자들 끼리 코드를 재사용할수 있도록 돕는 역할을 하는 키워드.
 	
 	this() 주요 특징
 	1. 다른 생성자 호출
 	2. 생성자 내부에 작성하는 this()는 생성자의 가장 첫 줄에 작성해야한다.
 		 그렇지 않으면 컴파일 에러가 발생한다.
 	3. 오버로딩된 생성자 호출 
 		: this() 를 이용해 다른생성자를 호출 할때 전달하는 인수에 따라 호출될 생성자가 결정됨 
 		
 	
 
 */

class Car2{
	String color;
	int year;
	
	// 생성자 - 두 개의 객체변수를 모두 초기화 할 생성자 
	// 생성자 만드는 단축키 alt + shift +s o
	// 생성자 만드는 메뉴 순서
	// Source 메뉴 -> Generate Constructor using Fields...  클릭 

	public Car2(String color, int year) {
	//  this.객체변수 = 매개변수;
		this.color = color;
		this.year = year;
		
	}
	// 생성자 - 색상만 초기화 하는 생성자 
	public Car2(String color) {
		//	기본 연도를 설정하여 다른 생성자 호출!
		this(color , 2020);
	}
	
	// 생성자 - 연도만 초기화하는 생성자
	public Car2(int year) {
		// 기본 색상을 직접 작성하여 다른 생성자를 호출!
		this("검정색",  year); // 참고. 전달하는 값의 갯수에 따라 만약 갯수가 2개면 매개변수가 2개인 다른 생성자를 호출하게 됨 
	}
	
	
	// 자동차 객체 정보를 출력하는 메소드
	public void printInfo() {
														// 생성된 Car2 객체 메모리 내부의 color 객체변수의 값을 불러와서 출력
		System.out.println("자동차 색상 : " + color);
														// 생성된 Car2	객체 메모리 내부의 year 객체변수의 값을 불러와서 출력 
		System.out.println("제조 연도 : " + year);
		
	}
	
}

public class This {

	
	public static void main(String[] args) {
		// 두 개의 매개변수를 사용하는 생성장를 통해 객체 생성 
		Car2 car1 = new Car2("빨간색", 2021);
		
		car1.printInfo();
		// 자동차 색상 : 빨간색
		// 제조 연도 : 2021
		
		
		// 색상만 설정하는 생성자를 통해 객체 생성
		Car2 car2 = new Car2("파란색");
		
		car2.printInfo();
		// 자동차 색상 :파란색
		// 제조 연도 : 2020
		
		// 연도만 설정하는 생성자를 통해 객체 생성
		Car2 car3 = new Car2(2018);
		
		car3.printInfo();
		// 자동차 색상 : 검정색
		// 제조 연도 : 2018
		
		
		
		
		
		
	}

}
