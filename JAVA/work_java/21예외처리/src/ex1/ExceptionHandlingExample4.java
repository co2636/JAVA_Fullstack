package ex1;

/*
 		예제 : 	배열의 index 위치의 범위를 벗어나 접근했을 경우 발생하는 ArrayIndexOutOfBoundsException 예외 종류와
 					
 					숫자형태의 문자열이 아닌데 숫자로 변경하려고 할때 발생하는 NumberFormatException 예외 종류를 
 					각각 다르게 예외처리하는 코드의 예 
 					
 					
 */

// 참고. 숫자 형태 "100" 문자열을 숫자로 변환해서 반환하는 메소드 
// 		Integer 클래스의 int parseInt(String value) 메소드
//		예) Integer.parseInt("100"); --> 100 반환 

public class ExceptionHandlingExample4 {

	public static void main(String[] args) {
		// 문자열을 저장한 배열 생성 
		String[] array = {"100","1oo"};
		
		// array 배열에 저장된 문자열 2개를 얻어서 숫자로 변환 
		for(int i =0; i <=array.length; i++) {

				try {
					//											 array[2] <- 예외 발생함 
					int value = Integer.parseInt(array[i]); // "100"  ->  100   // "1oo"  -> X
					System.out.println("array[" + i + "] : " + value);
					
				} catch(ArrayIndexOutOfBoundsException e) {
					// 예외가 발생하면 예외정보 출력
					e.printStackTrace();
					// 예외처리 할 코드 
					System.out.println("array 배열에 없는 원소에 접근했음 ");
					System.out.println("배열 인덱스가 초과됨 : " + e.getMessage() );
					
				}catch(NumberFormatException e) {
					// 예외가 발생하면 예외정보 출력 
					e.printStackTrace();
					// 예외처리 할 코드 
					System.out.println("array[1] 위치에 저장된 '1oo'은 숫자로 변환 할 수 없음 ");
					System.out.println("숫자로 변환 할 수 없음 : " + e.getMessage());
					
				}
				
		}
		
	}

}
