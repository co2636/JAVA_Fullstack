
// 주제 : Vector 가변으로 늘어나는 배열메모리를 만들때 사용되는 Vector 클래스 이용하기 

import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		// 4개의 객체(요소)를 저장할 수 있는 가변으로 늘어나는 Vector 배열 메모리 생성
		// 그리고 Vector 배열 메모리에 모두 저장된 상태에서 add 메소드를 한번 호출해서 
		// 객체를 추가하면 3칸씩 가변으로 늘어나게 하는 Vector 배열 메모리 생성!
		Vector vector = new Vector(4, 3);
											// [ 10 ] [ 20 ] [ 30 ] [ 40 ]    [ 50 추가] [null] [ null ]
											//    0	 	 1			2		  3		 		4			 5	 		6		
		
		// Vector 는 몇칸 만들어져있는지 칸의 갯수(용량)을 알아내기 위해 호출하는 메소드 -> capacity()
		System.out.println("백터 칸의 갯수(용량) : "+ vector.capacity());  // 4
		
		// Vector  4칸에 저장된 객체의 갯수를 반환하는 메소드  -> size()
		System.out.println("백터 칸에 저장된 객체의 갯수 : " + vector.size()); // 0
		
		// for 반복문을 이용해 Vector 배열에 객체 추가하여 저장
		for(int i = 0; i < 5; i++) {
			vector.add(i * 10); // 오토박싱 
		}
//		[0] [10] [20] [30] [40] [null] [null]
//		  0	 1	     2	     3		  4		5		  6		index 
		
		// Vector 는 몇칸 만들어져있는지 칸의 갯수(용량)을 알아내기 위해 호출하는 메소드 -> capacity()
		System.out.println("백터 칸의 갯수(용량) : "+ vector.capacity());  // 7
		
		// Vector  칸에 저장된 객체의 갯수를 반환하는 메소드  -> size()
		System.out.println("백터 칸에 저장된 객체의 갯수 : " + vector.size()); // 5
		
		// 백터 배열에 첫 번째 칸( 0 index) 에 저장된 객체를 반환
		System.out.println(vector.firstElement().toString()); // 0
		
		// 백터 배열에 마지막 칸( 4 index) 에 저장된 객체를 반환
		System.out.println(vector.lastElement().toString()); // 40
				
		System.out.println("백터 배열에 저장된 모든 객체를 차례로 꺼내어 출력" ); 
		for(int i=0; i<vector.size(); i++) {
			System.out.print(" " + vector.get(i));
													// i = 0 일때  0
													// i = 1 일때  10
													// i = 2 일때  20
													// i = 3 일때  30
													// i = 4 일때  40
													// i = 5 일때  반복종료 
		
		}	
		
		
		/*
		 		java 에서 Vector 가변길이배열은 동적으로 크기가 조정되는 배열이다.
		 		즉 배열처럼 사용되지만, ArrayList와 달리 동기화되어 있어 멀티 스레딩 환경에서 안전하다.
		 		그러나 성능 문제로 요즘은 주로 ArrayList를 사용하는 경우가 많다.
		 
		 */
		
		
		
		
		
	}

}
