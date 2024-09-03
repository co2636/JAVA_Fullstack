
public class ArrayUtils {

	// 정수들이 저장될 1차원 배열메모리 주소 하나를 매개변수로 전달 받아서 배열에 저장된 모든 데이터들의 합을 계산한 후 반환하는 기능의 sum 메소드 정의 
	public int sum(int []array ) {
		// 합을 저장할 변수 초기화 
		int total = 0;
		
		//매개변수로 전달받은 배열의 각 요소를 순회 
		for(int num : array) {
			// 현재 배열을 순회하면서 현재 요소를 total 에 더함 
			total += num;
		}
		
		return total; // 최종 합 반환 
	}
	
	// 실수들이 저장될 1차원 배열메모리 주소 하나를 매개변수로 전달 받아서 배열에 저장된 모든 데이터들의 합을 계산한 후 반환하는 기능의 sum 메소드 정의 
	public double sum(double []array) {
		// 합을 저장할 변수 초기화 
		double total =0.0;
		
		// 매개변수로 전달받은 배열의 각 요소를 순회 
		for(double num : array) {
			// 현재 배열을 순회하면서 현재 요소를 total 에 더함 
			total += num;
		}
		
		return total; // 최종 합 반환 
		
	}
	
	// 정수들이 저장될 1차원 배열메모리 주소하느를 매개변수로 전달 받아서 
	// 배열에 저장된 정수들의 합을 계산해서 출력하는 기능의 printSum 메소드 정의
			// 구현 내용
			// sum 메소드를 호출하여 결과 출력!
			// 출력 형식 "정수 배열의 합 :  숫자 "
	public void printSum(int []array) {
		System.out.println("정수 배열의 합 : " + sum(array));
	}
	
	// 실수들이 저장될 1차원 배열메모리 주소하느를 매개변수로 전달 받아서 
	// 배열에 저장된 정수들의 합을 계산해서 출력하는 기능의 printSum 메소드 정의
			// 구현 내용
			// sum 메소드를 호출하여 결과 출력!
			// 출력 형식 "실수 배열의 합 :  숫자 "
	public void printSum(double []array) {
		System.out.println("실수 배열의 합 : " + sum(array));	
	}
	
	public static void main(String[] args) {
		// ArrayUtils 클래스의 객체 생성 
		ArrayUtils arrayUtils = new ArrayUtils();
		
		// 정수들 1,2,3,4,5  가 저장된 1차원 배열 메모리 생성 
		// 참조 변수명은 intArray
		int []intArray = {1,2,3,4,5};
		
		// 실수들 1.5, 2.5, 3.5 가 저장된 1차원 배열 메모리 생성 
		// 참조 변수명은 doubleArray
		double []doubleArray = {1.5 , 2.5 , 3.5};
		
		// 위 intArray 참조변수에 저장된 배열메모리의 합을 계상해서 출력
		//출력형식 : "정수 배열의 합: 15"
		arrayUtils.printSum(intArray);
		
		// 위 doubleArray 참조변수에 저장된 배열메모리의 합을 계산해서 출력
		// 출력형식 : "실수 배열의 합 : 7.5"
		arrayUtils.printSum(doubleArray);
		
		
	}

}