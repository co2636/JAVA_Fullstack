
// 예제 : for 문의 다양한 활

public class For03 {

	public static void main(String[] args) {
		
		//제어 변수 i 선언
		int i ;
		
		// i 의 초기값을 1로 설정하여 1씩 증가시키면서 10일때 까지 반복해서 i 변수값 출력
		// 1 2 3 4 5 6 7 8  10
		for(i = 1; i<11; i++) {
			System.out.print(i + " ");
		}
		//위 쪽 for 문 밖에 출력 한 거임.
		System.out.println("\n--------------------->> ");
		
		// i 의 초기값을 1로 설정하여 2씩 증가시키면서 10일때 까지 본박해서 i 변수값 출력
		// 1 3 5 7 9
		for(i=1; i<11; i+=2) {
			System.out.print(i + " ");
		}
		
		//위 쪽 for 문 밖에 출력 한 거임.
		System.out.println("\n--------------------->> ");
		
		//2 4 6 8 10
		for(i=2; i<11;i+=2) {
			System.out.print(i + " ");
		}
		
		//위 쪽 for 문 밖에 출력 한 거임.
		System.out.println("\n--------------------->> ");
		
		//10 9 8 7 6 5 4 3 2 1
		for(i=10; i >= 1 ; i--) {
			System.out.print(i + " ");
		}
		
		//위 쪽 for 문 밖에 출력 한 거임.
		System.out.println("\n--------------------->> ");
		
	}

}
