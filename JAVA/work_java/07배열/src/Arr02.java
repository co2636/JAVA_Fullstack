
// 예제 : 5개의 실수값 중에서 최대값 구하기 

public class Arr02 {

	public static void main(String[] args) {
		
		//double 실수값들 9.5, 7.0, 13.6, 7.5, 10.0 을 초깃값으로 갖는 data 배열 생성
		double []data = new double[] { 9.5, 7.0, 13.6, 7.5, 10.0 } ;
		
		//data 배열에 최댓값 하나를 최종 저장할 변수 max 선언
		double max;
		
		// for 반복문을 수행하기 전에 data 배열에  0 index 위치의 9.5를 꺼내서 max 변수에 최대값으로 설정하기 위해 저장
		max = data[0];
		
		// for 반복문을 이용하여 5번 반복하면서 1 index ~ 4 index 위치에 저장된 값(요소)를 반복해서 얻어서 max 변수에 저장된 값보다 크면? max 변수에 다시 저장시킴
		for(int i=1 ; i<data.length; i++) {
			
			if(max < data[i]) {
				max = data[i];
			}
		}
		
		System.out.println("max = " + max);
		
		
		//출력형식
		// max = 13.6 
	}

}
// 결론
// 이 예제는 배열의 첫 번째 요소 9.5를 최대값으로 먼저 max 변수에 저장해 놓고 나머지 요소들과 비교하여 최댓값을 찾아내는 구조로 되어있는 예제이다.
