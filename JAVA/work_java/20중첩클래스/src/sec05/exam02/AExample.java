package sec05.exam02;

/*
 	  중첩클래스내부에서 바깥 외부 클래스에 대한 객체메모리에 접근 방법
 	  
 	  		바깥클래스명.this 
 	  		
 	  중첩클래스 내부에서 중첩클래스에 대한 객체 메모리에 접근 방법
 	  
 	  		this
 	  		
 	  				
 */
// 예제 : 중첩클래스와 바깥 클래스가 동일한 이름의 인스턴스변수와 메소드를 가지고 있을 경우
//			 바깥 객체 소속의 변수와 메소드를 사용하는 방법 
class A{ // 바깥 클래스 
	// A 의 인스턴스 변수
	String field = "A-field";
	
	// A의 인스턴스 메소드 
	void method() {
		System.out.println("A-method");
	}
	
	// 인스턴스 멤버 중첩클래스 B 만들기 
	class B{
		// B의 인스턴스 변수 
		String field = "B-field";
		
		// B의 인스턴스 메소드
		void method() {
			System.out.println("B-method");
		}
		
		// B의 인스턴스 메소드
		void print() {
			// B객체의 변수와 메소드 사용
			System.out.println(this.field);
			this.method();
			
			// 외부 A객체의 변수와 메소드 사용
			System.out.println(A.this.field);
			A.this.method();
			
		} // B print 메소드 닫기 
		
	} // B 닫기 
	
	// A의 인스턴스 메소드 만들기
	void useB() {
		B b = new B();
		b.print();
	}
	
	
} // A 

public class AExample {

	public static void main(String[] args) {
		// A 외부 객체 생성 
		A a = new A();
		// A 외부 객체의 인스턴스 메소드 호출 
		a.useB();
	}

}
