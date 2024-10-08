
// 예제 : 좌측 이동 연산자 << 와 우측 이동 연산자 >> 

public class BitShiftExample1 {

	public static void main(String[] args) {
		
		//1. 좌측 이동 연산자 << 를 사용하여 정수 1을 3비트 만큼 왼쪽으로 이동 시키자.
		int num1 = 1;
		int result1 = num1 << 3;
//		int result1 = 1 << 3;
		
//		1.1 좌측 이동 연산자 << 는 아래와 같이 Math 클래스의 pow 함수를 사용하여 2의 3승 곱한 결과 8 과 동일하다.
		int result2 = num1 * (int) Math.pow(2, 3);
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
	
		//2. 우측 이동 연산자 >> 를 사용하여 정수 -8을 3비트 만큼 오른쪽으로 이동시켜보자.
		int num2 = -8;
		int result3 = num2 >> 3;
//		int result3 = -8 >> 3;
		
		int result4 = num2 / (int) Math.pow(2,3);
		System.out.println("result3 : " + result3);
		System.out.println("result4 : " + result4);
		
		int result = -8 >>> 3;
		
		System.out.println(result);
		
	}

}
