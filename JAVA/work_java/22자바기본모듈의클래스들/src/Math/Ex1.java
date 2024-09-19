package Math;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 	Math 클래스의 메소드들
		 	
		 	public static int abs(int num) 메소드
		 	- 매개변수로 정수 하나를 전달받아 절대값을 구해 정수로 반환하는 메소드 
		 	- abs 메소드는 실제로 실수값을 전달받게 오버로딩되어 만들어져 있다.
		 	
		 */
		// Math 클래스의 abs 메소드 호출시 매개변수로 음수 -5를 전달하면 절대값 5를 구해서 정수로 반환한다.
		int v1 = Math.abs(-5);
		
		// Math 클래스의 abs 메소드 호출시 매개변수로 음의 실수 -3.14를 전달하면 절대값 3.14를 구해서 실수로 반환한다.
		double v2 = Math.abs(-3.14);
		
		System.out.println(v1);  // 5
		System.out.println(v2); // 3.14
		
		// Math클래스의 max 메소드 호출시 5, 9 매개변수로 전달하면 두 수 중에서 큰 최댓값 9 하나를 반환 
		int v7 = Math.max(5, 9);
		// Math클래스의 max 메소드 호출시 5.3, 2.5를 매개변수로 전달하면 두 수 중에서 큰 최댓값 5.3 하나를 반환 
		double v8 = Math.max(5.3, 2.5);
		
		System.out.println(v7);  // 9
		System.out.println(v8);  // 5.3

		// Math 클래스의 min 메소드 호출시 5, 9 를 매개변수로 전달하면 두 수중에서 작은 최소값 5 하나를 반환 
		int v9 = Math.min(5, 9);
		// Math 클래스의 min 메소드 호출시 5.3 , 2.5 를 매개변수로 전달하면 두 수중에서 작은 최소값 2.5 하나를 반환 
		double v10 = Math.min(5.3, 2.5);
	
		System.out.println(v9);  // 5
		System.out.println(v10);  // 2.5
		
		/*
		 	public static double floor(double d) 메소드 
		 	- 매개변수로 전달받는 실수값을 소수점 첫번째 자리를 절사해서 버린 실수값을 만들어서 반환 
		 	
		 */
		// Math 클래스의 floor 메소드 호출시 매개변수로 5.3을 전달하면 소수점 첫번째 자리 3을 내림한 5.0을 반환 
		double v11 = Math.floor(5.3);
		System.out.println(v11); // 5.0
	
		double v12 = Math.floor(-5.3); // 소수점 첫번째에서 올림해서 -6.0을 만들어서 반환 
		System.out.println(v12);  // -6.0
		
		/*
		 	public static double ceil(double d) 메소드
		 	- 매개변수로 전달받는 실수 값을 소수점 첫번째 자리에서 무조건 올림처리한 실수값을 반환하는 메소드 
		 		음의 실수값도 처리한다.
		 		
		 */
		// Math 클래스의 ceil 메소드 호출시 매개변수로 5.3을 전달하면 소수점 첫번째 자리 3을 무조건 올림 처리한 6.0을 만들어서 반환한다.
		double v3 = Math.ceil(5.3);
		System.out.println(v3); // 6.0
	
		// 음수를 전달하면 소수점 첫번째 자리를 없앤 -5.0을 반환함
		double v4 = Math.ceil(-5.3);
		System.out.println(v4); // -5.0
		
		/*
		 	public static double random() 메소드
		 	- random 메소드를 호출하면 0.0 <=  랜덤값 < 1.0 이 범위의 랜덤값 하나를 반환 
		 	- Math.random() * 숫자 
		 		: 입력한 숫자보다 작지만 무한히 가까운 수를 랜덤으로 반환 
		 		예) Math.random() * 12
		 			: 12 보다는 작지만 무한히 가까운 수를 랜덤으로 반환 
		 			
		 	- 특정 범위 사이의 랜덤값을 정수로 발생시키는 공식 
		 		(int) Math.random() * (최대값 - 최소값 + 1 ) + 최소값 
		 		예) 특정범위가 최소값 1 ~ 최대값 12 사이의 랜덤값을 정수로 얻자 
		 			(int) (Math.random() * (12-1+1)) + 1
		 			(int) (Math.random() * 	    12 )     + 1
		 */
	
		// 1 ~ 12 랜덤값을 정수로 10개 만들어서 반복해서 출력
		for(int i = 0; i < 10 ; i++) {
			System.out.println((int)(Math.random()  * 12 ) + 1 );
		}
	
		System.out.println("---------------------------------------------------");
	
		System.out.println(Math.random() * 12);
		
		double v13 = Math.random(); // 0.0 ~ 1.0 사이의 랜덤값 하나 반환
		System.out.println(v13);
		
		/*
		 	public static int round(double d) 메소드
		 	- 매개변수로 전달받은 실수값을 소수점 첫번째 자리에서 반올림한 정수를 반환
		 */
		
		System.out.println(Math.round(10.0)); // 10
		System.out.println(Math.round(10.4)); // 10
		System.out.println(Math.round(10.5)); // 11
		
		/*
		  	public static double pow(double d, double d2) 메소드
		  	 - 매개변수 d 와 d2로 실수 2개를 전달하면 d의 d2승 값을 반환한다.
		  	 - 매개변수로 전달된 두 개의 double 형 값을 가지고 제곱 연산을 수행한다.
		  	 	예를 들어 math.pow(5, 2); -> 5의 2승 계산한 25.0 반환
		  	 	
		 */
		System.out.println(Math.pow(5,2)); //25.0
		
		/*
		 	Math 클래스의 PI 상수 메모리
		 	- 원의 원주를 지름으로 나눈 비율(원주류)값으로 약 3.14159를 제공해 준다.
		 	- public static final PI = 3.141592;
		 	
		 */
		System.out.println(Math.PI); //3.141592653589793
		
	}

}
