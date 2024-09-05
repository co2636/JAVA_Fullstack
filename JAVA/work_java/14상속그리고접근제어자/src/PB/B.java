package PB; // 현재 PB 패키지에 class B가 만들어져있다고 자바컴파일러 프로그램에게 알려주는패키지 선언문 

// import 외부패키지명.사용할클래스명;
import PA.A; 

// PA 다른패키지에 만들어져 있는 부모 역할을 하는 A 부모클래스를 상속받아 새롭게 만드는 자식 B클래스 만들기 
public class B  extends A {

	void set() {
		// 다른 PA 패키지의 부모 A객체메모리에 만들어 놓은 i 인스턴스변수는 default 접근제어자를 이용해 만들어 놓았기 때문에 자식객체 메모리 내부에서 접근 불가능 
			// super.i = 1;
		
		// 다른 PA 패키지의 부모 A객체 메모리에  protected int pro 변수에 접근 가능 
		super.pro = 2;
		
		// 다른 PA  패키지의 부모 A객체 메모리에 private int pri 변수에 접근 불가능 
			//	super.pri = 3;
		
		// 다른 PA 패키지의 부모 A 객체 메모리에 public int pub 변수에 접근 가능 
		super.pub = 4;
		
	}
	public static void main(String[] args) {
		// 자식 B 클래스를 이용해 B객체 메모리 생성 코드 작성 
		B b = new B();
		// B 자식 객체 메모리 생성 구문 new B()를 작성하면 자식 B클래스의 생성자 B가 먼저 호출되고 B의 부모인 A클래스의 생성자가 바인딩되어 호출된다.
		// 그런 후 A 클래스의 생성자가 실행되어 부모A 객체 메모리가 먼저 생성되고 나중에 자식 B 클래스의 생성자B() 가 실행되어 자식 B객체 메모리가 생성된다.
		
		/*
		 
		 		A 부모객체 메모리 내부 모습 
		 
		 						  int i;  // default 
					  
				protected int pro;
				
				private int pri;
				
				public int pub;
				
				public void print() {
					
					System.out.print("i= " + this.i + ", ");
					System.out.print("pro=" + this.pro + ", ");
					System.out.print("pri=" + this.pri + ", ");
					System.out.println("pub=" + this.pub + "입니다.");
		
				}
		 	-------------------------------------------------------------------
		 	
		 		B 자식객체 메모리 내부 모습 
		 		
		 			void set() {
							super.pro = 2;
							super.pub = 4;
					}
		 		
		 */
		
		b.set();
		
		b.print();
		//    				출력 형식 
		//   i= 0, pro=2, pri=0, pub=4입니다.

		
	}

}
