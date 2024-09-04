package com.sup;

public class Super { // 부모 역할을 하는 클래스 
	// public 접근제어자 사용
	// 4바이트 크기의 정수를 저장할 num1 변수 선언 후 10 저장 
	public int num1 = 10;
	
	// protected 접근제어자 사용
	// 4바이트 크기의 정수를 저장할 num2 변수 선언 후 20 저장 
	protected int num2 = 20;
	
	// default 접근제어자 사용
	// 4바이트 크기의 정수를 저장할 num3 변수 선언 후 30 저장 
	int num3 = 30;
	
	// private 접근제어자 사용
	// 4바이트 크기의 정수를 저장할 num4 변수 선언 후 40 저장 
	private int num4 = 40;
	
	// public 접근제어자 사용
	// num4 변수에 저장된 40을 반환하는 getNum4 메소드 선언 
	public int getNum4() {
		return num4;
	}
	
	// public 접근제어자 사용
	// num3 변수에 저장된 30을 반환하는 getNum3 메소드 선언 
	public int getNum3() {
		return num3;
	}
}
