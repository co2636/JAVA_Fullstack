package Random;

import java.util.Arrays;
import java.util.Random;

// 주제 : 로또의 6개 숫자를 얻는 방법
//		로또는 1 ~ 45 범위의 정수 숫자만 선택할 수 있으므로 Random 클래스의 nextInt(45) +1 연산식을 사용했다.

public class Ex1 {

	public static void main(String[] args) {
		
		// 선택한 로또번호 6개가 저장될 정수 배열 만들기
		int [] selectNumber = new int[6];
		
		// 선택한 번호를 얻기위한 Random 클래스의 객체 생성 
		Random random = new Random(3);
		
		System.out.print("선택한 번호: ");

		// 선택번호 6개를 반복해서 얻어 위 selectNumber 배열에 저장 
		for(int i=0; i < 6; i++) {
			
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		
		// 당첨 번호 정수 6개가 저장될 배열 만들기
		int []winningNumber = new int[6];
		
		random = new Random(3);
		
		System.out.print("당첨번호 : ");
		
		// 당첨번호 6개를 랜덤으로 얻어 위 winningNumber 배열에 각 인덱스자리에 저장
		for(int i = 0; i < 6; i++) {
			winningNumber[i] = random.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		
		System.out.println();
		
		// 비교하기 전에 배열 항목을 정렬 시키자.
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		
		// 선택한 6개의 번호가 저장된 selectNumber 배열의 요소들과 당첨번호 6개의 번호가 저장된 winningNumber 배열의 요소들을 비교하기
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.print("당첨여부 : ");
		if(result) {
			System.out.println("1등에 당첨되셨습니다.");
		}else {
			System.out.println("당첨되지 않았습니다.");
		}
		/*
		  	참고. java.util.Arrays 클래스
		  			- 배열과 관련된 다양한 유틸리티 메소드를 제공하는 클래스 
		  			- 자바에서 배열은 고정된 크기의 데이터 구조이기 때문에 배열을 다룰때 편리한 기능들을 제공하기위해 Arrays 클래스가 존재함
		  			- 주요 메소드들 
		  				1. Arrays.toString(배열)
		  					예) int[] arr = {1,2,3,4}
		  							// 배열에 저장된 내용을 문자열로 변환해서 반환한다.
		  						  Arrays.toString(arr);  // "[1, 2, 3, 4]"
		  						  
		  				2. Arrays.sort(배열)
		  					- 배열에 저장된 데이터들을 오름차순 정렬한 후 정렬된 배열을 반환 
		 					예) int[] arr = { 3, 1, 4, 2}
		 						Arrays.sort(arr);  ->  [1, 2, 3, 4]
		 
		 				3. Arrays.binarySearch(배열, 찾을 데이터)
		 					- 정렬된 배열에서 이진 탐색을 수행하여 특정값의 인덱스를 반환
		 					
		 					예) int[] arr = {1, 2, 3, 4}
		 											0  1  2  3
		 											
		 						Arrays.binarySearch(arr, 3);  ->  3이 저장된 index 위치번호 2를 반환 
		 						
		 				4. Arrays.equals(첫번쨰배열, 두번째배열) 메소드 
		 					- 두 배열의 각 요소가 동일한지 비교하는 메소드 
		 						배열의 각 요소가 동일하면 true 반환 
		 						
		 						예) int[] arr1 = {1,2,3}
		 							  int[] arr2 = {1,2,3}
		 							 
		 							 Arrays.equals(arr1, arr2);
		 							 배열의 각 요소 1, 2, 3 이 완전히 동일하면 true 반환 
		 					
		 			 	5. Arrays.copyOf(배열, 생성할 배열 칸 갯수)
		 					- 배열을 지정한 칸의 갯수로 만들되 복사해서 만든다.
		 					
		 					예) int[] arr = {1, 2, 3}
		 						  int[] newArr = Arrays.copyOf(arr, 5);
															// [1, 2, 3, 0, 0] 배열 반환 
		 							
		 		
		 
		 */
		
		
		
		
		
	}

}
