package StringBufferTest;

public class Ex1 {

	public static void main(String[] args) {

		// 어떤 경우 String 클래스로 객체 메모리를 생성하여 문자열을 저장해 놓고 사용하는가?
		// -> 한번 생성한 String 객체 메모리에 변경하지 않을 문자열을 저장하고 싶을때 String 클래스의 객체 메모리 생성함 
		
		String str = "Play";
		/*
		 		[ str ]  -> [  "play" ]; 		 	
	    */
		
		str = "Life";
		/*
		  						 [ "play" ]; 	<- 컴파일러에 의해 사용하지 않는 객체 메모리 제거됨 	 	
 				[ str ]  -> [  "Life" ]; 		 	
		*/

		// 결론 : String 클래스를 이용해 객체 메모리를 여러번 생성하면 참조변수 str 은 마지막에 생성한 객체 메모리를 사용하게 된다.
		//			 처음 생성한 객체 메모리는 컴파일러에 의해 제거됨 
		
		// "Life" 문자열에 추가하고 싶은 문자열이 있을 경우 + 연산시
		str = str + " and Play";
		//	"Life and Play"
		/*
		 						["play"] <- 컴파일러에 의해 사용하지 않는 메모리 제거됨
		 						["Life" ] <- 컴파일러에 의해 사용하지 않는 메모리 제거됨
		 	[str]		->	["Life and Play"]
		
		*/
		// 결론 : 같은 String 클래스의 참조변수 str 에 문자열 객체메모리를 생성해서 주소를 넣을때마다 새로운 String 클래스에 대한 객체 메모리의 주소가 할당되기
		//			때문에 프로그램 개발을 하면 프로그램 속도가 나중에 배울 StringBuffer 보다 느리다는 단점이 있다.
		//	변경되지 않을 문자열만? 저장하려면? String 클래스를 이용해 객체메모리를 생성해서 사용하자 
		System.out.println("-----------------------------------------------------------");
		
		// StringBuffer 클래스?
		// - 변경을 많이 하게될 문자열을 저장할 용도의 객체를 생성할때 사용되는 클래스
		// 		(가변으로 늘어나서 커지게 하는 문자열을 저장)
		
		// "JAVA" 문자열을 저장 시킬 StringBuffer 클래스의 객체 생성
		StringBuffer sb =new StringBuffer("JAVA");
		/*
		 			[ sb ]  ->  [ "JAVA" ]
		 */
		// 현재 저장된 전체 "JAVA" 문자열 끝에 "Programming" 문자열 추가 
		sb.append("Programming");
		/*
					[ sb ]  ->  [ "JAVAProgramming" ]
		*/
		
		// 결론 : 
		
		
		
	}

}
