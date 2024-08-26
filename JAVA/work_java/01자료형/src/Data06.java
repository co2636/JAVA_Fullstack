
// 예제 : 실수 형태의 자료형 저장하기 

public class Data06 {

	public static void main(String[] args) {
		
		//int a = (int)23.7; // 컴파일에러
		//23.7 실수값을 23정수로 강제 형변환 하면 저장할 수 있다.
		// 그러나 자바에서는 실수형 데이터를 저장하기 위한 자료형 2가지를 제공해 준다. 
		
		// 참고 
		// 자바에서 실수 데이터를 저장하기 위한 변수를 만들때 사용하는 자료형 2가지
		// 1. float		    4byte
		// 2. double 	8byte
		
		// 컴파일에러 발생 
		//float b = 23.7; // 23.7은 자바에서 23.7D로 인식한다. 즉! double 변수에 저장된 값으로 인식한다.
	
	 //double c = 23.7D; 로 인식하기 때문에 저장 가
		double c = 23.7;
		
	// float 자료형으로 선언된 변수 d 에 float 자료형 실수가 저장되게 하려면 실수값 뒤에 접미사 f 를 붙여서 실수값을 저장해야한다
		float d = 23.7f;
		
		System.out.println("c : " + c); //23.7 <- double  c 변수에 저장된 23.7D
		System.out.println("d : " + d); //23.7 <- float  d 변수에 저장된 23.7f
		
		/*
		 	자바에서 float 자료형으로 변수 선언후 저장할 값의 허용범위
		 	
			 		약 -3.40282347E+38(-2의128승) ~ 약  3.40282347E+38(2의128승)
			 		
			 		float 자료형은 32bit(4byte) 부동소수점 숫자를 저장하는데 사용됨
		 		
		 		
		 	자바에서 double 자료형으로 변수 선언후 저장할 값의 허용범위
		 	
			 		약 -1.79769313486231570E+308(-2의1024승) ~  약 1.79769313486231570E+308(2의1024승)
			 		
			 		double 자료형은 64bit(8byte) 부동소수점 숫자를 저장하는데 사용
			 		
		 */
		
		
	}

}
