
// 예제 : for 문을 제어 하는 제어변수 값 반복해서 출

public class For02 {

	public static void main(String[] args) {
		//for 문을 제어할 제어변수 i 선언
		int i;
		
		// i 변수의 초기값을 1로 저장하여 1 씩 증가하면서 4가 될때 까지 반복 수행 한다.
		for(i = 1; i < 5; i++) {
			System.out.println(i);
		}
		//for 반복문을 벗어난 후에 i 제어변수 값은 조건식에 적어준 값보다 1 크다.
		System.out.println("-------------->> " + i);
	}

}
