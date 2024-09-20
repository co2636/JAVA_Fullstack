
// 주제 : List 부모 인터페이스의 자식 ArrayList 가변길이 배열에 저장된 객체(요소)를 index 위치번호로 접근하여 꺼내와 사용하는 예제 

import java.util.ArrayList;

public class Collections04 {

	public static void main(String[] args) {
		// 가변으로 늘어나는 배열공간인 ArrayList 클래스의 객체 생성 
		ArrayList list = new ArrayList();
									//	["하나"] [2] [3.42] [ "넷" ] [ "five" ] [ 6 ]
									//		  0		1		 2			 3			  4		   5
		list.add("하나");  // "하나" 문자열 객체 추가
		list.add(new Integer(2)); // Integer 객체 추가 
		list.add(new Double(3.42)); // Double 객체 추가 
		list.add("넷"); // "넷" 문자열 객체 추가 
		list.add("five"); // "five" 문자열 객체 추가
		list.add(6); // Integer 객체 추가 
		
		// 향상된 for 반복문을 이용해 ArrayList 가변길이배열에 저장된 객체(요소)들을 순서대로 얻어 출력 
		for( Object obj : list) {
				System.out.println(obj.toString());
//														하나
//														2
//														3.42
//														넷
//														five
//														6
		}
		

		System.out.println("----------------");
		
		// 참고. ArrayList 가변으로 늘어나는 배열 메모리의 특정 index 위치에 저장된 객체를 꺼내올때 사용되는 메소드 
		//			->  	 E			get( int index )
		//			-> Object	get( int index )
		
		// 참고. ArrayList 가변으로 늘어나는 배열메모리에 저장된 객체의 총 갯수를 정수값으로 얻을때 사용되는 메소드
		//			-> int size()
		
		// 일반 for 반복문을 이용하여 ArrayList 가변길이 배열에 저장된 객체의 갯수만큼 반복하여
		// 0 index 위치에 저장된 객체부터 5 index 위치에 저장된 객체 까지 index 위치번호를 1씩 증가하면서 객체들을 반복해 꺼내와 출력 
		for(int i = 0; i < list.size(); i++) {
			
			System.out.println(i + "번째 index칸에 저장된 객체는? " + list.get(i));
			
		}
	}

}
