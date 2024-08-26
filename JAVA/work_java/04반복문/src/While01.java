
// 예제 : 1 부터 5 사이의 자연수 반복해서 출력하

public class While01 {

	public static void main(String[] args) {

		// for 반복문과 while 반복문을 제어할 i 변수 선언
		int i;
		
		for(i=1; i<=5; i++) {
			System.out.print(" " + i);
		}
		
		System.out.println("\n-------------------------------------");
		
		// 초기식 
		i = 1;
		
		while( i <=5) {
			
			// 반복 처리할 문장 
			System.out.print(" " + i);
			
			// 증감식 
			i++;
		}

	}

}
