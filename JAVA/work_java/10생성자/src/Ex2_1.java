
// 주제 : 생성자에 대해서 더 알아보기 

class X{
	
	int x;
	int y;
	
	
	/*
	  	개발자가 생성자 1개이상 만들어 놓으면  자바 컴파일러는 기본생성자를 자동으로 만들어 주지 않습니다.
	  	
	  	그러므로 개발자가 따로 기본생성자를 직접 만들어  놓아야 한다.
	  	
	 */
	
	// 개발자가 직접 기본생성자 만들기
	public X() {

		
		
	}
	
	public X(int x_ , int  y_) {
	
		x = x_;
		y = y_;
		
	}
	

	
	/*
	  
	  개발자가 아무런 생성자도 만들어 놓지 않으면 자바 컴파일러 프로그램은 기본 생성자를 자동으로 이 자리에 만들어 준다.
	  단 ! 우리 사람 눈에는 보이지 않는다.
	  
	  public X(){  							< ------ 자동으로 만들어진 기본생성자 
	  
	  }
	  
	 */
	
}

public class Ex2_1 {

	public static void main(String[] args) {
		
		// X 클래스의 객체를 생성하는 동시에 기본생성자 호출! 
		
		X x1 = new X();
		System.out.println(x1.x); //0
		System.out.println(x1.y); //0
		
		// X 클래스의 두번째 객체를 생성하는 동시에 매개변수가 있는 ( x 객체변수 = 10 ,  y 객체변수 = 20 으로 초기화 할)  생성자 호출!
		X x2 = new X(10,20);
		System.out.println(x2.x); //10
		System.out.println(x2.y); //20
		
		
	}

}
