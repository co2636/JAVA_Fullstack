package ch06.sec12.hyundai;

// 패키지란?
// - 관련된 클래스와 인터페이스를 그룹화하여 논리적으로 조직하는 디렉터리 전체 경로를 의미 

// import 
// - 다른 패키지에 만들어져 있는 클래스를 사용하기 위해 import 문을 이용해서 어떤 패키지의 클래스를 사용하는지 컴파일러에게 알려주기 위해 명시해야한다.
// - 문법 
//		import  다른 최상디렉터리명.다른하위디렉터리명.사용할클래스명;
// - import 구문은 일반적으로 package 선언문 아랫줄에 작성하되 class 설계도 윗줄에 작성해야한다. 

// com.mycompany 패키지 내부에 만들어 놓은 Car 클래스에서 ch06.sec12.hankook 패키지에 만들어놓은 Tire 클래스를 사용하기 위해 import 구문 작성하기 

//import ch06.sec12.hankook.Tire;
//import ch06.sec12.hankook.SnowTire;

//	com.mycompany 패키지 내부에 만들어 놓은 Car 클래스에서 ch06.sec12.hankook 패키지에 만들어놓은 모든 클래스를 사용하기 위해 클래스명 대신 * 기술 
//	import 구문 작성하기 
import ch06.sec12.hankook.*;
import ch06.sec12.kumho.AllSeasonTire;
import ch06.sec12.kumho.Tire;

public class Car {

	public static void main(String[] args) {
		
		//ch06.sec12.hankook 패키지 내부에 만들어져 있는 class 들을 사용해서 객체 생성 
		ch06.sec12.hankook.Tire tire = new ch06.sec12.hankook.Tire();
		
		// 두 개의 패키지 안에 만들어 놓은 Tire 클래스명이 동일할때 구분을 위해 참조변수를 만들거나 객체메모리 생성시 
		// 생성자 호출구문에 직접  외부 패키지명.사용할클래스명 을 기술하여 작성한다.
		ch06.sec12.kumho.Tire tire2 = new ch06.sec12.kumho.Tire();
	
		SnowTire tire3 = new SnowTire();
		
		AllSeasonTire tire4 = new AllSeasonTire();
		
		
	}

}
