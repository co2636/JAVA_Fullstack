
// 예제 : 반환값이 없고 여러 매개변수를 가진 메소드 

public class Example4 {

	// 문자열  1개 (학생 이름) 그리고 정수 1개 (나이) 를 매개변수로 전달받아
	//"이름 : 홍길동  , 나이 : 30" 출력하는 기능의 반환값이 없는 printStudentInfo 메소드 정
	public static void printStudentInfo(String name , int age ) {
		
		System.out.println("이름 : " + name + ",  나이 : " + age);
		
	}
	
	// 정수 2개를 매개변수로 전달받아 더한 연산결과값을 반환하는 기능의  add 메소드 정의
	public static int add(int a , int b) {
		
		return a + b;
		
	}
	
	//  실수 2개를 매개변수 전달받아 더한 연산 결과값을 반환하는 기능으  add2	 메소드 정의
	public static double add2(double c, double d) {
		
		return c + d;
		
	}
		
	public static void main(String[] args) {
		
		//"이름 : 홍길동  , 나이 : 30" 출력하기 위해 정의해 놓은 printStudentInfo 메소드 호출 !
		printStudentInfo("홍길동", 30);
		
		// 5, 10의 합 15를 구해서 얻기 위해 정의 해 놓은 add 메소드 호출!  반환 받은 15를 출력!
		
		int sum = add(5,10);
		System.out.println("add 합 :" + sum);
		
		
		//5.5, 10.5 합을 구해서 얻기 위해 정의 해놓은 add2 메소드 호출! 반환 받은 16.0을 출력!
		double sum2= add2(5.5,10.5);
		System.out.println("add2 합 :" + sum2);
		
	}

}
