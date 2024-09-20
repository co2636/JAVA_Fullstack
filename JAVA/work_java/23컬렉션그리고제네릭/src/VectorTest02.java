
// 주제 : Vector 배열 메모리에 저장된 객체 얻기(검색)와 객체 삭제 
import java.util.Enumeration;
import java.util.Vector;

public class VectorTest02 {
	public static void main(String[] args) {
			// 기본 생성자를  호출하여 생성된 백터배열은? 
			// 초기 용량(칸의 갯수) : 10칸의 공간을 가진다.
			// 증가량 : 용량이 가득차면 기존 용량(10)의 1.5배로 증가한다. 
			//				예) 10칸이 꽉 차면 용량이 15로, 다시 꽉 차면 22칸으로 증가한다.
			Vector vector = new Vector();
			
			// 백터 용량(칸의 갯수) 출력
			System.out.println(vector.capacity()); // 10
			
			// 기본자료형 double 실수값들을 저장시킨 고정크기 배열 6칸 생성
			double[] arr = new double[] { 38.6, 9.2, 45.3, 6.1, 4.7, 1.6 };
			
			// arr 배열에 저장된 모든 실수 데이터들을 차례대로 반복해서 얻어 위 new 로 선언한 Vector 가변길이배열 메모리에 차례대로 오토박싱하여 저장 
			for(int i=0; i < arr.length; i++) {
				vector.add(arr[i]); // 오토박싱되어 new Double(i); 객체들이 저장됨
			}
		
			System.out.println("Vector 배열에 저장된 모든 객체들을 차례로 얻어 출력"); 
			for(int i =0 ; i < vector.size(); i++){
				System.out.print(" \t " + vector.get(i) );
			}
			System.out.println();
			
			// 검색할 데이터를 변수에 저장
			double searchData = 6.1;
			
			// 참고. 
			/*
			 		int indexOf(Object o)
			 		-> 전달인자로 준 객체를 배열의 앞 index 위치에서 부터 검색해서 찾는다. 
			 			  만약 찾으면 찾은 객체의 해당 index 위치를 반환,  찾지 못하면 -1 반환 
			 
			 */
			// searchData 변수에 저장된 6.1을 오토박싱하여 indexOf 메소드의 매개변수로 전달하면
			// Vector 배열에 new Double(6.1) 객체가  저장되어 있으면 저장된 index 위치번호 3을 int 로 반환 
			//  없으면 -1을 반환한다.
			int index = vector.indexOf(searchData);
			
			// 검색되었다면? (index 변수에 저장된 값이 -1이 아니면? 찾은것이다)
			if(index != -1) {
				System.out.println("검색 성공! : " + index); // 3
			}else {
				System.out.println("검색 실패! : " + index); // -1
			}
			
			
			// Vector 배열에 저장된 삭제할 데이터 변수에 저장 
			double delData = 45.3; 
			
			 // Vector 배열에 new Double(45.3); 객체가 저장되어 있으면?
			if(vector.contains(delData)) {
				// 저장되어 있기 떄문에 삭제하자
				// 참고.  boolean remove(Object obj) 메소드
				// 			- 매개변수 obj 로 전달한 삭제할 객체를  Vector 배열 메모리에서 삭제한 후 삭제에 성공하면 true 반환 삭제에 실패하면 false 반환 
				boolean result= vector.remove(delData);
				if(result) {
					System.out.println("삭제 완료" );
				}else {
					System.out.println("삭제 실패" );
				}
				
			}
			
			System.out.println("삭제 후 Vector 배열에 저장된 객체 모습 출력 ");
			System.out.println(vector.toString()); //[38.6, 9.2, 6.1, 4.7, 1.6]
			
			// 삭제 후 벡터 용량(칸의 갯수)
			System.out.println(vector.capacity()); // 10
			
			// Vector 의 elements 메소드를 호출하여 Enumeration 인터페이스에서 제공해주는 메소드들을 활용하여
			// Vector 에 저장된 요소(객체)들을 반복해서 차례로 얻어 출력 
			Enumeration enu = vector.elements();
			while(enu.hasMoreElements()){
				System.out.print(" " + enu.nextElement());
			}
			
			
			
			
			
		}

}
