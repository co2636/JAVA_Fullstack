/*
 	두 가지 논리 값을 비교 판단하도록 하는 논리 연산자
 	- 논리 연산자는 주어진 논리식을 판단하여, 참(true)과 거짓(false)를 결정하는 연산자이다.
 	
 	논리 연산자 종류	
 					논리연산자 종류									설명
 				&&(논리 AND 연산자)					논리식이 모두 참이면 (true)를 반환
 				||(논리 	OR 연산자)							논리식 중에서 하나라도 참(true)이면 참(true)을 반환 
 				!(논리 NOT 연산자)						논리식의 결과가 참(true)이면 거짓(false)을,
 																		거짓(false)이면 참(true)를 반환하는 연산자로
 																		!연산자는 피연산자가 단 하나뿐인 단항 연산자라고도하고
 																		피연산자의 연산순서는 오른쪽에서 왼쪽으로 연산해야함
 																		!false -> true
 																		
 	논리 연산자의 모든 동작의 결과를 보여주는 진리표
 	
 		A변수값		 B변수값			  A&&B			A||B			 !A
 			true				true					true				true			false
 			true				false				false			true			false
 			false			true					false			true			true
 			false			false				false			false		true
 			
 	예) A && B  	논리  AND연산식을 해석하면 true && true 일때 AND연산 &&을 하면 
 		  두 피연산자의 값이 모두 true 일때만 하나의 true 의 값을 되돌려 받는다.
 		  만약 두 피연산자의  값 중 하나라도 false 가 존재하면 false 의 값을 되돌려 받게 될것이다.
 		  
 	예) A | | B 논리 OR연산식을 해석하면 true || false 일때 OR 연산 || 하면 
 	   	  두 피연산자의 값 중 하나라도 true 가 존재하면 하나의 true 의 값을 되돌려 받는다.
 	   	  만약 두 피연산자의 값이 모두 true 가 존재할때도 true 으 ㅣ값을 되돌려 받게 될것이다.
 	   	  
 	  예) 
 			
 */
// 예제 : 특정 범위에 속하는 값인지를 물어보기 (변수에 저장된 나이가 10대인지 아닌지 알아보기)
// 논리연산자 중에서 && 연산자 사용  
public class Opr04 {

	public static void main(String[] args) {
		
		int a=29; //나이저장
		
		//a 변수에 저장된 나이가 10대인지 10대가 아닌지에 관한 문자열을 저장할 변수 
		String result = "몰라";
		
		//참고.	자바에서 특정 범위에 속하는 값인지를 물어보기 위해서는 논리연산자 중에서 논리 AND 연산자 &&를 사용한다. 
		
//		result = 조건식 ? 참:거짓;
//		a 	변수에 저장된 나이가 10대인지 아닌지 판단해야한다.
//		10대에 속하려면 a 변수에 저장된 나이가 10살 이상이고 19살 이하여야 한다.
//		변수 a의 값이 10보다 크거나 같냐라고 묻는 조건식		a >= 10   와
//		변수 a의 값이 19보다 작거나 같냐라고 묻는 조건식 		a <= 19 을 모두 만족해야한다.
//		두 조건식의 결과값이 모두 참(true)이어야 10대임을 판단할 것이다.
		result = ( a >= 10 && a <=19) ? "10대" : "10대가 아님 ";
//						29>= 10 && 29 <= 19
//							true					false		->  false
		
		System.out.println("a 변수에 저장된 나이 : " + a + "는 " + result);
		
	}

}
