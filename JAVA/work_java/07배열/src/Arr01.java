
// 예제 : 5명의 학생의 점수를 초기값으로 갖는 배열을 선언한 후 점의 총합을 구하고 평균을 구하는 예제 
public class Arr01 {

	public static void main(String[] args) {
		// 5명의 학생 점수들을 차례대로
		// 95, 70, 80, 75, 100 점수들의 초기값을 갖는 score 배열을 선언한다.
		int []score = {95, 70, 80, 75, 100} ;
		
		// 점수의 총합을 구해 저장할 total 변수 선언 후 0으로 초기화
		int total = 0;
		
		// 참고. 배열전체에 저장된 요소의 총 갯수 
		//			 	배열명.length;
	
		// for 반복문을 이용하여 score 배열에 각 점수를 차례로 얻어 total 변수에 누적한다.
		int i;
		for( i=0; i< score.length; i++) {
			total += score[i];
		}
		// 점수들의 평균을 구해 avg 변수 선언후 저장
		double avg = total/ (double)score.length; 
		
		System.out.println("Total = " + total);
		System.out.println("AVG = " + avg);
		
		/*
		 	출력 형식
		 	Total = 420
		 	AVG = 84.0
		 	
		 */
		
		
	}

}
