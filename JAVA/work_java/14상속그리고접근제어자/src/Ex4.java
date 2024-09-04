
// 주제 : 부모 클래스와 자식 클래스가 같은 패키지에 만들어져 있는 경우 다양한 접근제어자 들을 사용한 멤버의 접근 범위 

class AA{ // 기존에 만들어져 있는 부모 클래스 역할 
	// default (디폴트) 접근제어자 
	// - 부모 클래스의 변수가 default 접근제어자로 작성한  변수 이면 자식클래스 내부든 다른 일반 클래스 내부든 같은 패키지 내부에서는 모두 접근가능 
		int i;
		
	// protected(프로텍티드) 접근제어자 
	// 1.  같은 패키지에 만들어져 있는 다른 클래스에서 protected 로 만든 변수에 접근가능 
	// 2. 다른 패키지의 일반 클래스에서는 접근 불가능 
	//		단!  다른 패키지에 만들어 놓은 AA 의 자식클래스 내부에서는 ? 접근 가능 
	protected int pro;
	
	// public(퍼블릭) 접근제어자 
	// 다른 패키지 또는 같은 패키지에 만들어 놓은 모든 클래스에서 접근을 허용 
	public int pub;
	
	// private(프라이빗)  접근제어자 
	// 1. 같은 클래스 내부에  private 으로 변수를 만들어 놓으면 같은 클래스 내부에서만 변수에 접근을 허용 
	// 2. 인스턴스 변수를 선언할때 대부분의 개발자들은 private 접근제어자를 많이 사용함 
	// 3. public 메소드 또는 생성자를 통해 private 으로 선언한 변수값을 사용하거나 변경함  	
	private int pri;
	
	// public getter 메소드 (변수에 저장된 값 반환(얻기))
	public int getPri(){
		return this.pri;
	}
	
	// public setter 메소드 (변수값 변경)
	public void setPri(int pri) {
		this.pri = pri;
	}
	
	
}
/*
 	BB 자식 클래스의 객체 생성 
 	
 	BB bb = new BB();
 	
 					0x12
 	---------------------------------------
		 	int i; [  ]
		 	protected int pro; [  ]
		 	public int pub; [  ]
		 	private int pri; [  ]
		 	//getter
		 	 public int getPri(){}
		 	 //setter
		 	 public void setPri(int pri){}
 	 ---------------------------------------
 	 		 void set(){  }
 	 		 String get(){  }
 	 ---------------------------------------
 	 
 */

// 부모 AA를 상속받아 새롭게 설계하는 자식 역할의 BB 클래스 만들기 
class BB extends AA{
	//default 접근제어자를 이용하여 set 이름의 인스턴스 메소드 만들기 
	void set() {
		// 부모객체 메모리 주소를 기억하고 있는 예약어 super
		super.i = 1; // i 변수는 default 접근제어자로 만든 변수이기 때문에 같은 패키지 내부의 다른 클래스에서 객체의 변수에 접근 가능 
		
		// 같은패키지에 다른 클래스 내부에 protected 접근제어자로 만들어 놓은 부모객체메모리의 pro 인스턴스 변수에 접근 가능 
		super.pro = 2; 
		
		// 같은 패키지에 private 접근제어자로 만들어 좋은 부모객체의 pri 변수에 접근 불가능 
		// 같은 패키지 일지라도 같은 객체 메모리에서만 접근 가능 
//		super.pri = 3; // 컴파일 에러 발생  
		
		// public 접근제어자로 만들어 놓은 부모객체에 있는 setPri 메소드를 호출해서 3을 매개변수로 전달하면 private int pri 인스턴스 변수의 값을  3으로 저장 
		super.setPri(3); 
		
		// public 접근제어자로 만들어 놓은 부모객체 메모리에 있는 pub 인스턴스변수에 접근가능 
		super.pub =4;
		
	} // set 메소드  끝 
	
	public String get() {
		return super.i  + ", " +
					super.pro + ", " +
					super.pub + ", " +
					super.getPri();
	}
	
}


public class Ex4 {

	public static void main(String[] args) {

		BB bb= new BB();
		bb.set();
		System.out.println(bb.get());
		
		/*
	 	BB 자식 클래스의 객체 생성 
	 	
	 	BB bb = new BB();
	 	
	 					0x12
	 	---------------------------------------
			 	int i; [  ]
			 	protected int pro; [  ]
			 	public int pub; [  ]
			 	private int pri; [  ]
			 	//getter
			 	 public int getPri(){}
			 	 //setter
			 	 public void setPri(int pri){}
	 	 ---------------------------------------
	 	 		 void set(){  }
	 	 		 String get(){  }
	 	 ---------------------------------------
	 	 
	 */

		
		

	}

}
