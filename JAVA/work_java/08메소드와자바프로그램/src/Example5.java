
// 예제 : 가변길이 매개변수를 이용하여 사용자 정의  메소드 만들고 사용해보자 

public class Example5 {

	// 가변길이 매개변수 ?
	// - 매소드에서 인자의 갯수를 유동적으로 받을수 있도록 해주는 변수
	
	// 기능 : 여러개의 정수를 가변길이 매개변수로 전달받아 그 합을 계산하는 기능 
//	public static 반환타입 메소드 (자료형...가변길이매개변) {}
	public static int sum(int... numbers) {
		
		// 합계를 저장할 변수 초기화 
		int total = 0;
		
		// 가변길이 매개변수 이자 배열인 numbers 를 이용해서 sum 메소드 호출시 전달받은 데이터를 배열 numbers 에서 추출할 수 있다.
		
		// 업그레이드 된 for 문법
		// 해서 - : 콜론 뒤에 작성한 배열에 저장된 요소들의 갯수 만큼 반복해서 코드 실행!
		//				배열의 0 index  위치의 요소부터 꺼내서  : 콜론 앞에 작성한 변수에 저장한 후 
		//				반복 실행 할  코드 자리에서 사용
		
//		for(	배열에서 얻은 요소를 저장할 변수  : 배열 ) {	
//				반복실행 할 코드;
//		}
		
		for(int num : numbers) {
			
			total +=  num;	
			
		}
		return total;
	
	}
	
	public static void main(String[] args) {

		// 메소드를 호출하여 다양한 개수의 인자를 전달할 수 있다.
		// 1.		3개의 인자 전달 
		int result1 = sum(1,2,3); // 1 + 2 + 3  결과 6을 반환 받아 result1  변수에 저장 
			
		System.out.println("Sum of 1,2,3 : " + result1);
		
		// 2. 		5개의 인자 전달
		int result2 = sum(10, 20, 30, 40, 50); // 10+20+30+40+50  결과 150을 반환 받아 result2 변수에 저장 
		System.out.println("Sum of 10,20,30,40,50 : " + result2);
		
		// 3.		인자가 없는 경우 호출 가능 
		int result3 = sum();
		System.out.println("Sum with no arguments :  " +  result3);
		
	}

}
