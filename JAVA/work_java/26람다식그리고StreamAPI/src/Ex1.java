
import java.util.function.Function; // 함수형 인터페이스 apply 추상메소드 
import java.util.function.Predicate; // 함수형 인터페이스 test 추상메소드 
import java.util.function.Consumer; // 함수형 인터페이스 accept 추상메소드 

public class Ex1 {
	public static void main(String[] args) {
		/*
		 	1. Function<T, R>  : 하나의 인자를 받아서 결과를 반환하는 함수형 인터페이스 이다.
		 		T는 입력타입, R은 반환 타입을 의미한다.
		 		여기서는 입력타입이 Integer 이고, 반환타입이 String 입니다.
		 		inToString 람다식은 정수 값 하나를 매개변수로 받아서 "숫자 : " 라는 문자열과 i 변수값을 결합하여 반환한다.
		 		
		 */
		
		// 예시. 5를 매개변수로 전달하면 "숫자 : 5" 문자열을 반환하는  람다식 작성 
//		Function<Integer, String> intToString = 자식익명객체(람다식);
		Function<Integer, String> intToString = (i) -> { return "숫자 : " + i; };
																		  //  i  ->  "숫자 : " + i;
		// 이름이 없는 익명객체 주소는 intToString 참조 변수에 자식객체로 저장되어 있다.
		// 익명객체 내부에는 Function 부모인터페이스 내부에 apply 추상메소드를 강제로 오버라이딩한 
		// 이름이 없는 익명함수 형태로 람다식을 사용하여 정의 해놓음
		System.out.println(intToString.apply(5)); // 숫자 : 5
		
		/*
		 	2. Predicate<T> : 인자를 받아서 boolean 값을 반환하는 test 추상메소드 하나를 가진 함수형 인터페이스 이다.
		 	
		 		T는 입력 타입을 의미하여, boolean 값을 반환한다.
		 		isEmpty 참조변수에 저장된 람다식은 매개변수 s 로 받은 값이 빈 문자열인지 여부를 확인하는 역할을 한다.
		 	 	매개변수 s 로 문자열을 받지 못하면 true 반환하고, 받으면 false 를 반환한다.
		 		
		 */
		// 문자열이 빈 경우 true 를 반환하고 그렇지 않으면 false 를 반환한다.
		Predicate<String> isEmpty = s -> s.isEmpty();
													//  (s) -> {return s.isEmpty(); };
													/* 
															isEmpty = new Predicate<String>() {
																@Override
																public boolean test(String t) {
																	return false;
																}
															};
													 */
		
		// test 메소드를 사용하여 빈 문자열("") 을 테스트하여 true 를 반환한다.
		System.out.println(isEmpty.test("")); // true

		/*
		 	 3. Consumer<T> : 인자를 받아서 처리하지만, 값을 반환하지 않는 accept 추상메소드를 가진 함수형 인터페이스 이다.
		 	 	
		 	 	 T는 입력 타입을 의미하며, Consumer 는 입력값을 받아서 처리만 하고, 반환값은 없습니다.
		 	 	  
		 */
		
		// print 참조변수에 저장된 람다식은 매개변수로 입력된 문자열을 그대로 출력
		Consumer<String> print = s -> System.out.println(s);
										  /* 
											   	print = new Consumer<String>() {
													@Override
													public void accept(String t) {
														System.out.println(t);
													}
												};
										*/
		// accept 메소드를 사용하여 Consumer 인터페이스를 구현한 익명객체의
		// 익명메소드를 호출할때 "Hello" 를 s 매개변수로 전달해서 출력 
		print.accept("Hello");
		
		
		
		
		
		
	}

}
