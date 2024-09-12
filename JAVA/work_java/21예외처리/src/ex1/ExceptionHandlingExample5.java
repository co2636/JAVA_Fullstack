package ex1;

/*
 		예제 : 두 개 이상 종류의 예외를 하나의 catch 블록으로 동일한 예외처리 코드를 작성하고 싶을때 
 		catch 블록의 매개변수자리에 예외처리클래스자료형1  |  에외처리클래스자료형2 와 같이 기호 | (또는 의 의미) 를 작성하여 연결하면 된다.
 		
 		catch( NumberFormatException  | NullPointerException  ) {
 			 	
 			 	처리할 예외처리 코드 작성;
 		
 		}
 */


public class ExceptionHandlingExample5 {
	

	public static void main(String[] args) {
		
		String[] array = {"100", "1oo", null, "200"};
//						index		0			1		 2			3
		
		for(int i=0; i <= array.length; i++) {
			try {
				// array 배열에 저장된 데이터들을 얻어 숫자로 변환 시도 
				int value = Integer.parseInt(array[i]);
				System.out.println("array [" + i + "] :" + value);
			} catch(ArrayIndexOutOfBoundsException e) {				
				// 예외 정보 출력 
				System.out.println("배열 인덱스가 초과됨 : " + e.getMessage() );
				
				// 2가지 종류의 예외가 발생했을때 동일한 예외 처리 하는 곳 
			} catch(NullPointerException | NumberFormatException e) {
				// 예외 정보 출력 
				System.out.println("데이터에 문자가 있음 : " + e.getMessage());
			
			}		
		} // for
//		catch(Exception e) {  // = new ArrayIndexOfBoundsException
//											// = new NullPointerException
//											// = new NumberFormatException
//							// 동일한 예외 처리 코드 작성 
//							e.printStackTrace();
//								} 
//
//		System.out.println("프로그램 코드 끝까지 수행 하고 종료 ");
	}
}
