
// 주제 : 생성자 만들어 보고 사용해보기 

public class Point {

	// 	정수값을 각각 하나씩 저장 할 x, y 변수 선언 
	int x;
    int y;
	
	// 기본 생성자 선언 
	public Point() {
		
		x = 2; // x 변수값 2 초기화 
		y = 2; // y 변수값 2 초기화 
		
		// "Point 기본생성자 호출됨"  <- 출력 
		System.out.println("Point 기본생성자 호출됨");
	}
	
	// x 변수의 값만 초기화 시킬 생성자 선언 
	public Point( int x_) {
		x =  x_;
	}
	
	// x, y 변수의 값 모두를 초기화 시킬 생성자 선언  
	public Point(int x_ , int y_) {
		x = x_;
		y = y_;
	}
	
	// Point 객체 메모리 내부에 설정된 x 변수의 값을 변경할 setX 메소드 선언 
	public void setX(int x1) {
		
		x = x1;
		
	}
	
	// Point 객체 메모리 내부에 설정된 y 변수의 값을 변경할 setY 메소드 선언 
	public void setY(int y1) {
		
		y = y1;
		
	}
	
	// Point 객체 메모리 내부에 설정된 x 변수값을 얻기 위한 getX 메소드 선언 
	public int getX() {
			return x;
	}
	
	// Point 객체 메모리 내부에 설정된 x 변수값을 얻기 위한 getY 메소드 선언 
	public  int getY() {
			return y;
	}
	
	// Point 객체 메모리 내부에 설정된 x, y 변수값을 얻기 위한 prn 메소드 선언 
	// 출력형식
	// " 출력 x, y : x 변수값 , y 변수값 "
	public  void prn() {
		
		System.out.println("출력 x , y : "+  x + " , "+ y ) ;
	}
	
	
	
	public static void main(String[] args) {
		// Point 클래스 하나를 이용해 Point 객체 생성시 기본 생성자 호출해서 생성 
		Point point = new Point();
		
		// 생성된 Point  객체의 x 변수값, y 변수값 불러와서 출력
		// 출력형태
		// "객체변수 x = 2"
		// "객체변수 y = 2"
		System.out.println("객체변수 x = " + point.x);
		System.out.println("객체변수 y = " + point.y);
		
		
		// prn 메소드 호출 하여 아래와 같이 출력 
		// 출력형태 
		// "x, y : 2, 2 "
		point.prn();
		
		// 생성된 Point 객체의 x 변수값을 10으로 변경 , y 변수값은 20으로 변경
		point.x = 10;
		point.y = 20;
		//prn 메소드 호출하여 아래와 같이 출력
		// 출력형태 
		// x, y : 10, 20
		point.prn();
		
		
		// 생성된 Point 객체의 x 변수값을 100으로 변경, y 변수값은 200으로 변경
		// 단 ! set으로 시작하는 이름의 메소드들을 호출해서 변경
		point.setX(100);
		point.setY(200);

		//prn 메소드 호출하여 아래와 같이 출력
		// 출력형태
		// x, y : 100, 200
		point.prn();
		
		// 생성된 Point 객체 내부에 만들어져 있는 getX(), getY() 각각 호출해서 현재 이자리에 반환값을 각각 출력 
		// 출력형태
		// 100
		// 200
		System.out.println(point.getX());
		System.out.println(point.getY());
		
		
		System.out.println("==========================");
		
		
		// Point 객체 생성하는 동시에 x 객체 변수를 초기화할 생성자만 호출해서 x 객체 변수값만 300 으로 초기화시킴 
		// 생성된 Point 객체 내부에 만들어진 prn() 메소드를 호출해서 출력 
		// 출력형태
		// 출력 x , y : 300 , 0
	
		Point p = new Point(300);
		p.prn();
		
		// Point 객체 생성하는 동시에 x 객체 변수 그리고 y 객체변수를 각각  초기화할 생성자를 호출해서 x 객체 변수값은 300 으로 초기화시키고 y 객체 변수값은 400으로 초기화 시킴 
		// 생성된 Point 객체 내부에 만들어진 prn() 메소드를 호출해서 출력 
		// 출력형태
		// 출력 x , y : 300 , 400
	
		Point p1 = new Point(300 , 400);
		p1.prn();
		
		
		
	}

}
