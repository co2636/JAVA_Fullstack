package ex2;

public class ThrowsExample1 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		// findClass 메소드를 호출한 장소 여기서 try 블럭으로 감싸서 예외처리 함 
		
			findClass(); // 아래의 메소드를 호출한 장소 
		
		System.out.println("프로그램을 끝까지 실행한 후 종료 ");
		
	}
	// 정적 메소드 
	
	// 							  findClass 메소드를 호출한 장소 중로 가서 예외처리 하라 
	//												 thorws 발생한처리할 종류의 예외클래스명 (ClassNotFoundException )
	public static void findClass() throws ClassNotFoundException{
			
		// 매개변수로 전달한 경로에 클래스를 찾을수 없는 ClassNotFoundException 예외가 발생할 예상 코드 작성 
			Class.forName("java.lang.String2");

	}
}
