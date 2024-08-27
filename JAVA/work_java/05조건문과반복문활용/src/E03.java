
// 예제 : 2단부터 9단까지 구구단 출력하

public class E03 {

	public static void main(String[] args) {
		/*
		 	** 2 단** 
		 	2 * 1 = 2
		 	2 * 2 = 4
		 	....
		 	2* 9 =18
		 	
		 	**3단**
		 	........
		 	
		 */
		// 단을 결정하는 변수선언
		int dan; // 2단 ~9단 까지 단수를 저장. 바깥 for 에서 사용
		
		//  매단마다 곱하는 수를 저장할 변수 선언 (1 ~9). 안쪽 for 에서 사용
		int n;
		
		for(dan=2; dan < 10; dan++) { // 2~ 9 
			System.out.println("** " + dan +"단 **");
			for( n = 1; n < 10 ; n++) {	 // 1 ~ 9 곱하는 수 만큼 반
		
				System.out.println(dan + " * " + n + " = " + ( dan * n ));
		
			}
			System.out.println("\n");
		}
	}

}
