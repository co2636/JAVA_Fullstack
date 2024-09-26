import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 	distinct() 메소드
		 	- 스트림 통로에서 중복된 요소(객체)를 제거한다.
		 	  이는 equals() 메소드를 기준으로 중복을 판단별하므로, 객체의 경우 equals 메소드를 적절히 구현해야 정확하게 중복이 제거됩니다.
		 	- 내부 동작 
		 		Stream API 는 모든 객체(요소)들을 Set 구조와 유사하게 관리하여 중복을 제거 합니다. Set 은 내부적으로 해시기반이므로 성능이 좋습니다.
		 		
		 		중복 제거 과정에서 기존 순서가 유지된다.
		 		
		 	
		 */
/*
		List<String> items = Arrays.asList("apple", "banana", "apple", "orange" );
		List<String> distinctItems = items.stream()
																	.distinct() // 중복된 "apple" 제거 
																	.collect(Collectors.toList());
		System.out.println(distinctItems); // [apple, banana, orange]
*/
		/*
		 	sorted() 메소드
		 	- 스트림통로에 있는 객체(요소) 들을 오름차순 또는 지정된 Comparator 에 따라 정렬합니다.
		 		기본적으로 Comparator 인터페이스를 구현한 클래스(예 : String, Integer 등) 들이 오름차순으로 정렬됩니다. 정렬기준을 변경하려면 
		 		Comparator 인터페이스의 자식구현객체를 전달할 수 있다.
		 
		 */
		List<Integer>  numbers = Arrays.asList(3, 5, 1 ,4, 2);
		List<Integer> sortedNumbers = numbers.stream()
																				.sorted() // 기본 오름차순 정렬
																				.collect(Collectors.toList()); 
						
		System.out.println(sortedNumbers); // [1, 2, 3, 4, 5]

		List<Integer> newNumbers = numbers.stream()
																			.sorted(Comparator.reverseOrder()) // 내림차순 정렬 
																			.collect(Collectors.toList());
		
		System.out.println(newNumbers); // [5, 4, 3, 2, 1]

		
	}
}
