
// 주제 : 변수의 초기화 시기와 실행 순서 

/*
 	- 클래스 변수 (static 이 작성된 변수)  :  
 		class 가 처음 JVM 메모리의 Method 영역에 로딩될때 단 한번만 초기화 된다.
 	
 	- 인스턴스 변수 : 
 		객체(인스턴스) 가 생성 될때 마다 각 객체메모리 별로 인스턴스 변수가 로딩되며  각 객체메모리 별로 초기화가 이루어지는 변수이다.
 
 	- 클래스 변수의 초기화 순서
 		1. 변수 자료형의 기본값으로 먼저 초기화 
 		2. 명시적 초기화
 		3. 클래스 초기화 블럭 
 		
 	- 인스턴스 변수의 초기화 순서 
 		1. 변수 자료형의 기본값으로 먼저 초기화
 		2. 명시적 초기화 
 		3. 인스턴스 초기화 블럭 
 		4. 생성자를 이용한 초기화
 		
 	순서1. static int cv 클래스 변수가 JVM의 Method 영역에 클래스와 함께 올라감 
 			  cv  클래스 변수 값은 int  자료형의 기본값 0으로 초기화됨 
 			  
 	순서2. 명시적 초기화 static int cv = 1; 를 통해서 cv 클래스 변수 값은 0 에서 1로 변경됨 
 	
 	순서3. 클래스 초기화 블럭 static{ cv = 2; }을 통해서 cv 클래스 변수값은 1 에서 2로 변경됨 
 	
 	순서4. Init 클래스의 객체가 생성되면서 객체메모리가 JVM의 Heap 영역에 올라감 
 			   Init 클래스의 객체메모리 내부에는 인스턴스 변수 int iv 값은  int 의 기본값 0으로 초기화 
 			   
 	순서5. 명시적 초기화 int iv = 1; 를 통해서 0 에서 1로 변경됨 
 	
 	순서6. 인스턴스 초기화 블럭 { iv = 2; }을 통해서 1에서 2로 변경됨 
 	
 	순서7. 생성자가 호출되어 hits.iv = 3; 을 통해서 2에서 3으로 변경됨 
 				인스턴스 변수 iv 는 최종 3이 저장됨 
 		
 		
 
 */

public class Init {
	
	// 변수 초기화 방법 1.  명시적 초기화 
	static int cv = 1;
	int iv = 1;
	
	// 변수 초기환 방법 3.  초기화 블럭 이용한 초기화 
	// 클래스 초기화 블럭 이용 
	static { cv = 2; }
	
	// 인스턴스 초기화 블럭 이용 
	{ iv = 2; }
	
	// 변수 초기화 방법 2.  생성자를 이용한 초기화 
	public Init() { // 객체 생성후 객체메모리 내부에 만들어지는 인스턴스변수값 초기화 
		this.iv = 3;
	}
	
	public static void main(String[] args) {
		
		Init i = new Init();
		
		System.out.println("클래스 변수 cv : " + Init.cv); // 2
		System.out.println("인스턴스 변수 iv : " + i.iv);    // 3
		
	}

}
