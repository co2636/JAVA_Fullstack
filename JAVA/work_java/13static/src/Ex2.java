
// 주제 : 자바에서 클래스안의 멤버 메소드 살펴보기 

class AAA{
	
	int num; // 인스턴스 변수
	static int staticNum; // 클래스 변수 
	
	public AAA() { }	
	
	// 멤버 메소드?  - 클래스 내부에 만들어져 있는 메소드들 전체를 말함 
	// 종류
	// 1. 인스턴스 메소드 : static 을 붙이지 않고 작성된 메소드 
	// 2. 클래스 메소드 : static 을 붙여 작성된 메소드 
	
	// 정수 하나를 매개변수로 받아 각 인스턴스 변수와 클래스 변수값 누적하는 인스턴스메소드 
	public void add(int value) {
		this.num += value;
		this.staticNum += value; // 참조변수역할을 하는 this 를 사용해도 되지만 클래스명.클래스변수명 으로 접근하는 것이 더 좋은 사용법이다.
		//AAA.staticNum += value;
		
	}
	// num 인스턴스 변수에 저장되어 있는 값을 반환하는 기능의 인스턴스 메소드 
	public int getNum( ){
		
		return this.num; // 인스턴스 변수값 반환 가능 
//		return AAA.staticNum; // 클래스 변수값 반환 가능 
	}
	// num 인스턴스 변수값을 변경하기 위한 인스턴스 메소드 만들기 
	public void setNum(int num) {
		this.num = num; // 인스턴스 변수값 변경 가능 
//		AAA.staticNum = num; // 클래스 변수값 반환 가능 
		
	}
	
	// static 을 작성해서 클래스 메소드 만들기 
	public static int getStaticNum() {
		return AAA.staticNum; // 클래스 변수값 반환 가능 
//		return this.num; // 인스턴스 변수값 반환 불가능 
	}
	
	// static 을 작성해서 클래스 메소드 만들기
	public static void setStaticNum(int staticNum) {
		AAA.staticNum = staticNum; // 클래스 변수 값 변경 가능 
		
		// 인스턴스 변수값 변경 불가능 
		// 방법 
		// this.인스턴스변수명 = 변경할값;
		// this.num = staticNum;
	}
	
	
	
}

public class Ex2 {

	public static void main(String[] args) {
		
		AAA aaa = new AAA();
		
		// 클래스 변수값 변경하는 방법 2가지 
		// 방법 1. 클래스명.클래스변수명 = 변경할값;
		AAA.staticNum = 50;
		
		// 방법 2. 클래스자료형의 참조변수명.클래스변수명 = 변경할 값;
		aaa.staticNum = 50;
		
		// 클래스 메소드 호출하는 방법 2가지 
		// 방법1. 클래스명.클래스메소드명();
		System.out.println(AAA.getStaticNum());
		
		// 방법2. 클래스자료형의 참조변수병.클래스메소드명();
		System.out.println(aaa.getStaticNum());
		
		/*
		 결론
		 1. 인스턴스변수, 인스턴스메소드 : 객체 생성시 객체 내부메모리에 존재 
		 2. 클래스변수, 클래스메소드 : 클래스가 JVM 메모리의 Method 영역에 올라가며 클래스 내부에 존재한다.
		 3. 클래스 메소드 내부에서는 인스턴스 변수에 접근 불가능 
			 그러나 인스턴스 메소드 내부에서는 인스턴스변수 뿐만 아니라 클래스변수에 접근 가능 
			
		4. ! 경고 느낌표 의 뜻
				-> 정적인 클래스변수 , 클래스메소드는 클래스명.클래스변수 또는 클래스메소드를 호출하여 접근해서 사용하라는 의미이다.
				
		 */
		
		
	}

}
