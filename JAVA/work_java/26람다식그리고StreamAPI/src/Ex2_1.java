
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2_1 {
	public static void main(String[] args) {

		// Arrays.asList()는 제공된 배열의 요소들을 포함하는 고정 크기의 ArrayList 배열을 반환 
		// 반환된 ArrayList는 인스턴스이지만, 고정 크기의 리스트로 다룰수 있으며, 요소의 추가나 삭제는 허용되지 않는다.
		List<Integer> scores = Arrays.asList(65, 70, 80, 90, 85, 50, 40);
		// { 65, 70, 80, 90, 85, 50, 40 } <- 모두 Integer 객체들이 저장된 것 이다.
		//    	0	  1		2	   3	  4	5		6		index 
		
		// -----------------60 점 이상의 성적만 필터링(걸러내고)하고 평균을 계산 하려고 한다.
		
		double average = scores.stream().filter(score -> score >= 60).mapToInt(score -> score).average().orElse(0.0);
		System.out.println("Average Score : " + average); // 78.0
		
	}

}
