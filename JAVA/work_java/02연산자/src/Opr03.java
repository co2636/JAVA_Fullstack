/*
 		삼항 조건 연산자 문법
		
			조건식 	?	 수식-1 : 수식-2
			
			해석1.	수식-1 : 조건식의 결과가 참(true)일때 수행되는 식
			해석2. 수식-2 : 조건식의 결과가 거짓(false)일때 수행되는 식 
			
			참고. 조건식이란? 
				연산결과값이 참(true)아니면 거짓(false) 둘 중에 하나의 값으로 나타나는 수식을 의미 하므로 
				조건식에 관계연산자를 사용할 수 있다.
 */
// 예제 : 삼항조건연산자를 이용해서 최대값 구하기

public class Opr03 {

	public static void main(String[] args) {
		
		int a = 5, b = 10;
		
		// 최대값을 저장할 변수 선언
		int max;
		
		//  a 변수에 저장된 5가 	b 변수에 저장된 10보다 크냐? 라고 묻는 a > b 조건식의 결과값은 false 이므로 
		//	: 콜론기호를 기준으로 뒤에 적은 10이 max 변수에 저장된다.
		max = a > b ? a : b; 
//		max = 5 >10? 5 : 10;
//		max = 10;
		System.out.println("max = " + max);

	}

}
