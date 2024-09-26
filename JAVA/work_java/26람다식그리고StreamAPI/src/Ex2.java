
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2 {
	public static void main(String[] args) {

		// Arrays.asList()는 제공된 배열의 요소들을 포함하는 고정 크기의 ArrayList 배열을 반환 
		// 반환된 ArrayList는 인스턴스이지만, 고정 크기의 리스트로 다룰수 있으며, 요소의 추가나 삭제는 허용되지 않는다.
		List<Integer> scores = Arrays.asList(65, 70, 80, 90, 85, 50, 40);
		// { 65, 70, 80, 90, 85, 50, 40 } <- 모두 Integer 객체들이 저장된 것 이다.
		//    	0	  1		2	   3	  4	5		6		index 
		
		// -----------------60 점 이상의 성적만 필터링(걸러내고)하고 평균을 계산 하려고 한다.
		
		// 순서1. 컬렉션 배열이나 고정크기 배열에 저장된 데이터가 흘러가는 스트림 통로 만들기 
		// scores.stream() 를 호출하면 생성되는 스트림 통로는 컬렉션(ArrayList 배열)에 저장된 요소(객체)들이 순서대로 흘러가는 입력스트림을 생성해서 반환 받음 
		Stream<Integer>  stream = scores.stream();
		/*
		 								IntegerStream 통로 
		 	 ---------------------------------------------------
					new Integer(40), 50, 85, 90, 80, 70, 65 			>>>>
		 	 ---------------------------------------------------
		 
		 */
		
		// 순서2. 중간연산 - 필터링
		// 필터링 : .filter(익명객체(람다식)) 메소드를 사용하여 각 성적을 검사하고 60점 이상인 성적만 남김 
		stream = stream.filter( score -> score >= 60 );
		
		/*
									IntegerStream 통로  ( Integer 객체들이 저장된 통로)
				---------------------------------------------------
										85, 90, 80, 70, 65 			>>>>
				---------------------------------------------------
		
		*/
		// 순서 2-1. 변환 연산  - IntegerStream 통로를 intStream 통로로 변환 
		// mapToInt() 메소드 
		// - 스트림에 있는 객체(요소)들을 정수형(int)으로 변환하여 IntStream 통로에 담아 IntStream 통로를 반환하는 메소드
		// - 일반적으로 객체가 저장된 스트림을 처리할때, 숫자 계산이나 통계처리를 하기위해 객체(요소)들을 
		// 기본자료형 스트림(IntStream, DoubleStream, LongStream)으로 변환할때 사용되는 메소드
		// score -> score                     (score) -> { return score; };
		// 이 경우, 스트림의 각 Integer 객체(요소)들을 매개변수 score 로 받아 스트림에 있는 Integer 객체들을 정수형으로 변환해서 반환할 뿐이다. 
		// 이 메소드 사용 이유 : 스트림의 요소가 객체타입(Integer) 이라면 자바에서 기본형 연산을 효율적으로 처리할 수 있도록 
		//									  IntStream 으로 변환해 주는것이 좋다. IntStream 통로는 추가적인 average(), sum(), min(), max() 등 
		// 									  숫자 연산을 더 쉽게 처리할 수 있다.
		IntStream stream2 = stream.mapToInt(score -> {  return score;}); 
		/*
								IntegerStream 통로  ( int 들이 저장된 통로)
				---------------------------------------------------
							85, 90, 80, 70, 65 			>>>>
				---------------------------------------------------
				
		*/
		// 순서3. 최종연산 결과값 산출 - 평균값 산출! 
		double average = stream2.average().orElse(0.0);
		
		System.out.println("Average Score : "+ average); // 78.0
		
	}

}
