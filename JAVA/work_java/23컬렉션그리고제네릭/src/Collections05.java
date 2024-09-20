/*
 	주제 : 제네릭 기법이 나오게 된 배경 
 	Vector 배열에 저장된 객체들을 get 메소드를 이용하여 얻는데 부모 Object 클래스 타입으로 자식객체를 반환하기 때문에 
 */

import java.util.List;
import java.util.Vector;

public class Collections05 {

	public static void main(String[] args) {

		// 업캐스팅을 하여 Vector 배열 생성
		List vector = new Vector();
		
		// Vector 배열에 문자열 객체 추가 
		vector.add("Apple");
		vector.add("banana");
		vector.add("oRANGE");

		// 다운캐스팅을 하여 얻은 문자열 객체들을 저장할 String 변수
		String temp;
		// ["Apple", "banana", "oRANGE"] <- Vector 배열 
		//		  0				1					2
		
		for(int i =0 ; i < vector.size(); i++) {
			// 업캐스팅을 하여 부모 Object 타입의 참조변수에 Vector 배열에서 꺼내온 문자열 객체의 주소를 저장 
			Object obj = vector.get(i);
			// 			"Apple" 
			// 			"banana"
			// 			"oRANGE"
			
//			obj.toUpperCase(); // 불가능 
			
			// 다운캐스팅을 하여 String 객체 -> "Apple" 의 toUpperCase() 메소드를 호출 가능하게 해야함 
			temp = (String) obj;
			// 	"Apple".toUpperCase() ->  "APPLE"
			// 	"banana".toUpperCase() -> "BANANA"
			// 	"oRANGE".toUpperCase() -> "ORANGE"
			System.out.println(temp.toUpperCase());
			
			
			
			
			
			
			// 컴파일 에러 이유 : get 메소드는 무조건! Object 부모 자료형의 참조변수에 저장할 자식객체를 반환함 
			// temp =  vector.get(i); // 컴파일에러 
						
		}
		
	}

}
