
// 예제 : 1 부터 10사이의 정수 중 3의 배수만 제외하고 출력하

/*
 	continue 보조 제어문?
 	- 반복문 내부에 작성하는 구문으로 continue 문이 실행되면 for 반복문에서는 증감식으로 제어가 옮겨진다.
 		또한 while 반복문에서는 다시 조건검사를 위해 조건식으로 제어가 옮겨진다.
 		
 		
 		반복문 {
 
 			코드 1;
 			
 			continue;
 			
 			코드2;
 		}
 
 
 */
public class F02 {

	public static void main(String[] args) {
		
		for(int n = 1; n <=10 ; n++) {
			
			// n 변수값을 3으로 나누었을때 떨어지면? 증감식 n++로 가서 다시 n 변수값 1 증가시켜! 라고 명령 
			if( n % 3 == 0 ) {
				 continue;
			}
			System.out.print(" " + n); //1 2 4 5 7 8 10
			
		}
		
	}

}
