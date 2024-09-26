import java.util.Comparator;

public class Ex6 {

	public static void main(String[] args) {
		/*
		 	Comparator.reverseOrder()는 Comparator<T> 타입의 객체를 반환하며 
		 	이 객체는 두 값을 비교할때 사용하는 compare (값1, 값2) 메소드를 제공합니다. 
		 	
		 	compare(A, B) 메소드에서
		 		A.compareTo(B) 의 결과를 뒤집어 반환한다.
		 		즉 ! 만약 A.compareTo(B) 가 양수라면 내림차순으로 정렬한다.
		 		
		 		A.compareTo(B) 가 음수라면, reverseOrder() 는 양수를 반환하여 내림차순으로 정렬한다.
		 		
		 		A.compareTo(B)  가 0이면 동일하므로 0을 반환한다.
		 		
		 	
		 */
			
		Comparator<Integer>  reComparator = Comparator.reverseOrder();
													//	20이 더 크므로 원래는 음수 -1 
													// -> reverseOrder() 호출하여 거꾸로 판단하는 객체를 반환받아서 사용하기 때문에 양수 1이 출력 
		int result1= reComparator.compare(10, 20);
		System.out.println(result1); // 1
		
		int result2 = reComparator.compare(20,10);
		System.out.println(result2); // -1 
		
		int result3 = reComparator.compare(10, 10);
		System.out.println(result3); // 0
	}

}
