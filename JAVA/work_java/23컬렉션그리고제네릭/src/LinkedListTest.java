
// 주제 : Queue 인터페이스를 구현한 자식 LinkedList 클래스에 대해 알아보고
//			  List 인터페이스를 구현한 LinkedList 클래스와 ArrayList 클래스의 차이점도 알아보자 
//				First In First Out -> FIFO 구조 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListTest {

	public static void main(String[] args) {
		// 업캐스팅을 통한 LinkedList 객체 생성 
		Queue myQue = new LinkedList();  // 터널과 같은 메모리 공간
		/*
		  	boolean offer(E o) 큐에 객체를 넣는다.
		 */
		
		myQue.offer("1-자바");
		myQue.offer("2-C++");
		myQue.offer("3-API");
		myQue.offer("4-JSP");
		
		
		
		/*
		 	출입구 
		 			------------------------------------------------
		 						"4-JSP" , "3-API" , "2-C++"	, "1-자바"			나가는곳
		 																																		
		 			------------------------------------------------													
		 */
		
		
		while(myQue.peek() != null) {
			
			// 큐에서 객체를 꺼내와 출력
			System.out.println(myQue.poll());
//						1-자바
//						2-C++
//						3-API
//						4-JSP
		}
		
		/*
		 		E poll() 메소드
		 		- 큐에서 데이터를 꺼내온다. 만일 큐가 비어있다면 null 을 반환함.
		 			큐에서 꺼내온 데이터는 제거 된다.
		 
			 	E peek() 메소드
			 	- 큐의 맨 나가는곳에 위치한 객체를 반환한다.
			 		반환하는 객체는 큐 공간에서 제거하지 않는다.
			 		만약 큐가 비어 있다면 null 을 반환한다.

		*/
		
		System.out.println("------------------------");

		// List 인터페이스를 구현한 LinkedList 클래스와 ArrayList 클래스의 차이점 알아보자 
		// -> 정수값을 저장하는 ArrayList에 객체를 추가하고 제거하는 작업을 수행하자
		
		// ArrayList 배열 사용
		List<Integer> arrayList = new ArrayList<Integer>();
		
		// ArrayList 배열에 객체(요소) 추가
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		
		// ArrayList 배열에 추가된 Integer 객체들을 얻어 출력
		System.out.println("ArrayList : ");
		
		//  향상된 for 반복문 
		for( int i : arrayList) {
			System.out.println(i);
//			[10, 20, 30]
//			   0    1    2
			
		}
		// 위 ArrayList 배열에 저장된 객체 중에서 20 삭제
		arrayList.remove(1);
		
		// 삭제 후 ArrayList 배열에 저장된 객체들을 얻어 출력 
		System.out.println("ArrayList : ");
		
		// 확장된 for 반복문
		for(int i : arrayList) {
			System.out.println(i);
		}
		// [10, 30]
		//    0    1
		
		System.out.println("------------------------");
	
		// List 부모인터페이스를 구현한 자식 LinkedList 클래스의 객체 생성
		List<Integer> linkedList = new LinkedList<Integer>();
	
		// LinkedList 가변배열에 add 메소드를 사용해 40, 50, 60 을 추가
		linkedList.add(40);
		linkedList.add(50);
		linkedList.add(60);
		/*
				[ 헤더 ] --> 	[헤더] --> 	[헤더]
				[ 40 ] 			[ 50 ] 			[ 60 ]
					0					1					2		index 
		*/
			// LinkedList 배열에 저장된 1 index 위치에 저장된 객체 하나 삭제 
			linkedList.remove(1);
			
			/*
					[ 헤더 ]   --> 	[헤더]
					[ 40 ] 				[ 60 ]
						0						1		index 
						
							연결 해제(끊음)
							
								[헤더]
								[ 50 ] 
										
			*/	
			
			for(int i : linkedList) {
				System.out.println(i);
//				40
//				60
			}
		
		
		
		
	}

}
