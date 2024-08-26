
// 예제 : 확장된 대입 연산자 +=

public class Opr06_02 {

	public static void main(String[] args) {
		
		int a = 10;
		
		// a 변수에 10을 누적에서 20을 저장하고 싶다.
		System.out.println(a + 10);  // 20 				-  	1번 
		System.out.println(a); // 10 							-  2번 
		// 1번은 실행결과는 20이다. 하지만 1번에서 변수 a 는 + 연산에 참여만 했으므로 
		// 변수 a 에 저장된 10값은 바뀌지 않았으므로 2번에서는 10이 출력된다.
		// 만일 변수 a 의 값이 변경되도록 하려면 a + 10으로 연산한 결과 20을 다시 a 변수에 대입(저장)해야함.
		// 식을 작성해보면 a = a + 10;이 될것이다.
		
//		a = a + 10;
//			 10 + 10;
		
//		System.out.println(a); // 20
		
//		a = a + 10; 과 동일한 식!
		a += 10;
//		순서1. 	a + 10
//					10 + 10
//						20
//		순서2. a = 20;  //a 변수에는 10이 저장되어 있다가 제거되고 
								  // 대신 +10 한  20이 대입 = 연산자를 이용해서 대입(저장)된다.
		System.out.println(a); //20
		
		// 여기서 += 플러스이퀄 이라고 읽으면 확장대입연산자라고 부른다.
		
		
	
	
	
	}

}
