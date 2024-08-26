
// 예제 : for 문을 한번만 사용해서 짝수의 합, 홀수의 합 을 각각 구하기 위해 for 문 내부에 if 문 사용하기

public class E02 {

	public static void main(String[] args) {
		
		//for 문의 시작 초깃값을 설정할 제어변수 n 을 선언
		int n;
		
		//홀수의 합을 저장할 변수
		int odd_tot;
		
		// 짝수의 합을 저장할 변수
		int even_tot;
		
		for(odd_tot = 0, even_tot = 0, n=1; n<=10; n++) {
			if(n%2==0) {
				even_tot += n;
			}
			else if(n%2 ==1 ) {
				odd_tot += n;
			}

		}
		System.out.println("even_tot 변수값 (2+4+6+8+10) =  "+ even_tot  + " \nodd_tot변수값(1+3+5+7_9)  = "+ odd_tot );
	}

}
