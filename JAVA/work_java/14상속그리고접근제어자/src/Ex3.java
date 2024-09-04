
// 예제 : 두 클래스의 상속 관계에서의 private 접근제어자를 지정한 멤버(변수 또는 메소드) 실습 

/* default */class A{ //  기존에 만들어 놓은 부모 클래스 
	
	public int p; // 만든 p 변수값은 어디서든지 접근 허용해서 사용할 수 있음 
	
	private int n; // 만든 n 변수값은 class A  내부에서만 접근해서 사용할 수 있음 
	
	public void setN(int n) { // public 접근제어자를 이용해 만든 메소드는 어디서든지 접근을 허용하므로 어디서든지 메소드 호출 가능 
		this.n = n;
	}
	
	public int getN() {
		return n;
	}
	
}

// A 클래스의 변수 + 메소드를 상속받아 새롭게 만드는 자식 B클래스 만들기
class B extends A{
	
	// private 으로 만든 m 변수값은 B 클래스 내부에서만 접근 가능 
	private int m;
	
	// public 으로 만든 getM 메소드는 외부 패키지의 클래스나 현재 클래스에서 접근 가능 
	public int getM() {
		return m;
	}
	
	public void setM(int m) {
		this.m = m;
	}
	
	public String toString() {
		return "n =" + super.getN() + " m = " + this.getM();
	}
	
}

public class Ex3 {

	public static void main(String[] args) {

		// 부모 역할을 하는 A 클래스의 객체 생성 
		A a = new A(); 
		
		a.p = 5;
//		a.n = 5; // A 객체 메모리의 n 인스턴스 변수는 private 으로 선언되어 있으므로 다른 Ex3 클래스 내부에서 접근 불가능 하므로 사용할 수 없다.
		/*
		  	   생성된 A 객체 메모리 그림 
		  	----------------------------
		  	
		  		public int p; [    ]
		  		
		  		private int n; [    ]
		  		
		  		public void setN(int n){ } 
		  		
		  		public int getN(){ }
		  		
		  	----------------------------
		 */

		// 자식역할을 하는 B 클래스의 객체 생성 
		B b = new B();

		b.p = 5;
//		b.n = 5; // B 객체 메모리는 클래스 단위에서 상속받아 접근하는 n 변수는 private 으로 선언되어 있기 때문에 다른 Ex3 외부 클래스에서 접근 불가능 
					  // 자바의 특징중 하나의 캡슐화 되어 있다고 할 수 있음 
		
		b.setN(10); // public  메소드 접근 가능하니 호출할 수 있음 
		
//		b.m = 20; // m 변수는 private 으로 다른 Ex3 외부 클래스에서 접근 불가능 
		
		b.setM(20); // m 변수는 private 이어 접근할 수 없으므로 대신 public 으로 만들어 놓은 setM 메소드 호출해서 m 변수에 20을 저장 
		
		System.out.println( b.toString() ); 
		// public 으로 만들어진 toString() 메소드는 외부 Ex3 클래스에서 호출이 가능함.
		// 반환받은 문자열을 이 자리에서 출력!
		//" n = 10  m = 20"
		
		
		/*
	  	   생성된 A 객체 메모리 그림 
	  	----------------------------
	  	
	  		public int p; [    ]
	  		
	  		private int n; [    ]
	  		
	  		public void setN(int n){ } 
	  		
	  		public int getN(){ }
	  		
	  	----------------------------
	  	
	  	
	  	   생성된B 객체 메모리 그림 
	  	----------------------------
	  	
	  		private int m; [    ]
	  	
	  		public int getM(){ }
	  		
	  		public void setM(int m){ } 
	  	
	  		public String toString(){ }
	  		
	  	----------------------------
	  	
	 */
	}

}
