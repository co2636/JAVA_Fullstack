
// 예제 : 1 부터 10사이의 짝수의 합 구하기 

public class While02 {

	public static void main(String[] args) {
		
		int number = 1;
		
		int tot = 0;
		
		while(number <= 10) { // 2+4+6+8+10 = 30
			if(number%2 == 0) {
				tot += number;
			}
			number ++;
		}
		
		System.out.println("tot = " + tot);
	}

}
