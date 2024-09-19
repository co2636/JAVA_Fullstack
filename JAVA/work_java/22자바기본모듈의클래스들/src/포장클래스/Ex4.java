package 포장클래스;

public class Ex4 {

	public static void main(String[] args) {
		// JDK 5버전 이후부터 적용되는 오토박싱, 오토언박싱
		
		int n1 = 10;
		int n2;
		
		Integer num1; 
		num1 = Integer.valueOf(n1); // 수동박싱 

		Integer num2 = new Integer(20); // 수동박싱 
	
		num1 = n1; // 오토 박싱이 일어남 
							//  Integer.valueOf(n1); 메소드 호출 구문 자동으로 작성해줌 
		
		System.out.println("오토 박싱");
		System.out.println("기본자료형 변수 n1 : " + n1); // 10
		System.out.println("참조자료형 변수 num1 : " + num1.toString()); // "10"
	
		// 오토박싱
		Integer num3 = 10;  // new Integer(10); 또는 Integer.valueOf(10);  와 같이 수동으로 박싱한 것과 같은 의미이다.
		
		// 오토언박싱
		int value = num3; // num3.intValue(); 수동으로 언박싱한 것과 같은 의미이다.
		
		// -------------------------- 오토박싱, 오토언박싱 연습 --------------------------------------------------
	
		// 정수 10을 Integer 객체에 저장하기 위한 오토박싱하기
		// 참조 변수 it
		Integer it = 10;
		
		// 오토박싱된 10을 문자열로 변환 후 반환 받아 출력 후 줄바꿈
		// "10"
		System.out.println(it.toString()); // 10
		
		// 참조변수 it 에 저장된 Integer 객체 내부의 정수 10을 오토 언박싱해서 int a 변수에 저장
		int a = it;
		
		// int a 변수에 저장된 값을  출력한 후 줄바꿈
		// 10
		System.out.println(a); // 10
		
		// 실수 3.14를 Double 객체에 저장하기 위해 오토박싱하기
		// 참조변수 du
		Double du = 3.14;
		
		// 오토박싱된 3.14를 문자열로 변환 후 반환 받아 출력 후 줄바꿈
		// "3.14"
		System.out.println(du); // 3.14
		
		// 오토언박싱하여 Double 객체에 저장된 3.14를 얻어 double b 변수를 만들어 저장 
		double b = du;
		
		// double b 변수에 저장된 값 출력 후 줄바꿈
		// 3.14
		System.out.println(b); // 3.14
		
		System.out.println("---------------------------------------");
		
		// 주제 : 오토박싱과 오토언박싱을 통해서 산술연산 가능하게 하기
		
		Integer c1 = 10; // 오토박싱 ,  수동박싱하려? ->  new Integer(10);
		
		Integer c2 = 20; // 오토박싱 
		
		c1++;
		// 순서1. c1 참조변수가 참조하고 있는 new Integer(10)에서 10을 언박싱한다.
		// 				c1.intValue(); -> 10 언박싱이 일어남 
		// 순서2. 10 + 1 -> 11로 만들어줌
		// 순서3.  11을 new Integer(11); 에 저장(박싱이 일어남)
		// 순서4. c1 = new Integer(11); 주소 저장
		System.out.println(c1.toString()); // "11" 
		
		c2 += 3; 
	//  c2 = new Integer(c2.intValue() + 3);
	// 순서1. c2.intValue(); -> 20 언박싱이 일어남
	// 순서2. 20 + 3을 하여 23으로 만들어 줌.
	// 순서3. 23을 Integer c2에 마지막으로 대입해서 저장하기 위해 new Integer(23);  ->  박싱이 일어남 
	// 순서4. c2 = new Integer(23);
		
		System.out.println(c2.toString()); //"23"
		
		// 현재 c1 참조변수 -> new Integer(11);
		// 현재 c2 참조변수 -> new Integer(23);
		
		int addResult = c1 + c2; // 각각 c1, c2 참조변수가 사용하는 Integer 객체 내부의 정수값을 오토언박싱된 후에 + 연산하게 된다.
	
		// 			c1.intValue() +  c2.intValue(); 
		//      			  11		  +			23
		//									34
		System.out.println("addResult 변수값 : " + addResult);  //34
		
		int minResult = c1 - c2; // 각각 오토언박싱된 후 - 연산하게 된다.
		//						   11 - 23
		//							-12
		System.out.println("minReault 변수값 : " + minResult); // -12
		
		// 결론 : 자동으로 발생하는 오토박싱과 오토언박싱으로 인해서 포장(래퍼)객체들에 저장된 기본자료형값 끼리 역시 산술연산이 가능하다.
		 
		
		
	}

}
