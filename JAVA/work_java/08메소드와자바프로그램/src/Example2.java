
// 예제 : 반환값이 없는 메소드 정의 및 사용 

public class Example2 {

	// 사용자 정의 메소드 정의 
	// 기능 : 매개변수 message 로 전달 받은 문자열을 화면에  출력하는 기능 
	public static void printMessage(String message) {
//						  void 	 메소드를 호출한 줄로 반환할 값이 없다라는 의미의 자료형 
						//void 를 작성하면 메소드 내부에는 return 구문을 작성하지 말아야한다.
		// 출력 기능 
		System.out.println(message);
		
	}
	
	public static void main(String[] args) {

		// 위 만들어진 printMessage 라는 이름의 메소드 호출해서  "안녕하세요!" 출력하자.
		printMessage("안녕하세요!");
		
	}

}
