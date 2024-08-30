/*

	// 이프로그램의 문제점 2가지 
	// 1. 과일장수1,2클래스의  객체는 생성하고 난 다음에 초기화를 해야한다.
	//즉! 두줄에 걸쳐서 문장을 구성해야.. 하나의 객체생성을 완료할 수 있다.

	// 2. FruitSeller(과일장수)클래스의  인스턴스변수 APPLE_PRICE의  final 선언이 사라졌습니다. 

	//[ final이 빠진것이 왜 문제가 되는 걸까? ]
	// : 클래스 정의시 과일장수가 판매하는 사과의 가격은 
	//   변경되지 않는다는 가정을두고, 
	//   인스턴스변수 APPLE_PRICE를 final로 선언했었습니다.
	//   그러나.. 메소드 내에서 APPLE_PRICE 가격을 초기화 하려다보니
	//   어쩔수 없이 final 선언을 강제로 삭제 시켰습니다.
	//   메소드는 여러번 호출 할수 있으므로... 
	//   initMember()메소드를 여러번 호출 한다면...
	//   객체가 다시 초기화 되는 실수를 범할수도 있기때문에..
	//   딱 한번만 호출되는 메소드 를 사용해서 객체를 생성해야함.

	//이프로그램의 문제점 해결방법 : 딱한번만 호출되는 생성자!이용
---------------------------------------------------------------------
Ex1_2.java를  생성자 이용하는 방법으로 고쳐 보자

//*** FruitSeller1(과일장수)클래스 내부수정 ****
//순서1) 사과 한개당 가격 변수에 final을 붙이자.
//순서2) 추가한 메소드 initMembers메소드  지우기(삭제)
//순서3) 과일장수 이름, 사과보유개수, 사과 개당 가격을 받을 생성자 추가 

//*** FruitBuyer1(과일구매자)클래스 내부수정 ****
//순서1) 현재 소유하고 있는 현금 0원, 개수 0개 로 초기화
//순서2) 구매자의  현재 소유하고 있는 현금을  받아 저장, 및 
//		구매자의 사과보유개수를 초기화 할 생성자 추가 

//*** FruitSeller1(과일장수)클래스 내부수정 ****
//순서1) 사과 한개당 가격 변수에 final을 붙이자.
//순서2) 추가한 메소드 initMembers메소드  지우기(삭제)
//순서3) 과일장수 이름, 사과보유개수, 사과 개당 가격을 받을 생성자 추가 

*/

// 생성자를 이용하는 방법으로 업그레이드 시키자 

// FruitSeller(과일 장수) 클래스  내부 수정 
// 순서1. 사과 한개당 가격 변수에 final 을 붙여 상수로 만들어 주자.
// 			  단! 사과 한개당 가격은 객체메모리 생성시 호출되는 생성자 내부에서 초기화 하자 

// 순서2.  과일장수객체의 사과 한개당 가격,  사과 보유 수 , 판매수익을 각각 객체변수들에 초기화 시킬 생성자 추가 

// 순서3. 추가한 initMembers 메소드 지우기(삭제)

//---------------------------------------------------

// FruitBuyer(과일 구매자) 클래스 내부 수정 
// 순서1.  현재 소유하고 있는 현금 0원, 개수 0개로 초기화 

// 순서2.  구매자의 현재 소유하고 있는 현금을 매개변수로 받아 초기화,
//		       구매자의 현재 사과 보유 개수를 매개변수로 받아 초기화할 생성자 추가 



//(2단계) 클래스(설계도) 정의 : 변수 + 메소드
//과일장수 FruitSeller라는 이름의 틀(클래스)을 정의합니다.
package test;


class FruitSeller{ 

/*변수*/
//변수(상수화)
//사과 한개당 가격
final int APPLE_PRICE ;

//보유하고 있는 사과의 수 저장할 변수
int numOfApple; 

//판매수익 을 저장할 변수
int myMoney;

// 생성자
// 과일장수객체의 사과 한개당 가격,  사과 보유 수 , 판매수익을 각각 객체변수들에 초기화 시킬 생성자 추가 
public FruitSeller(int apple_price , int numOfApple_ , int myMoney_) {
	APPLE_PRICE = apple_price;
	numOfApple = numOfApple_;
	myMoney = myMoney_;
}



/*메소드*/
//사과판매 행동 메소드	
int saleApple(int money) { //사과구매액이 메소드의 매개변수로 전달받음
	
	//판 사과 개수 
	int num = money / APPLE_PRICE;
	
	//사과 판매후 사과의 수줄이기
	numOfApple -= num;
	
	//판매 수익 누적
	myMoney += money;
	
	//실제 구매(판매)가 발생한  사과의 수를 반환
	return num; 		
}


//사과판매후 남은 사과수,판매수익 출력 하는 기능의 메소드
public void showSaleResult(){
	System.out.println("남은 사과 : " + numOfApple);
	System.out.println("판매 수익 : " + myMoney);
		
}



}// FruitSeller 클래스 끝



//(2단계) 클래스(설계도) 정의 : 변수 + 메소드
//나(과일구매자) FruitBuyer라는 이름의 틀(클래스)을 정의합니다.
class FruitBuyer {
/*변수*/
//현재 소유하고 있는 현금
int myMoney;
//현재 소유하고 있는 사과수
int numOfApple = 0;
	

// 생성자 
//구매자의 현재 소유하고 있는 현금을 매개변수로 받아 초기화할 생성자 추가 	
public FruitBuyer(int myMoney_ ) {
	myMoney = myMoney_;
	numOfApple = 0;
}



/*메소드*/
//과일구매 기능 메소드
//매개변수 : 구매하기위한 판매자대상, 구매금액
public void buyApple(FruitSeller seller , int money) {
	//판매자에게 과일 구매하기 ,구매한사과수 리턴 받아와서 현재사과수에 누적 
	numOfApple += seller.saleApple(money);
	//판매자에게 과일 구매후 현재 소유하고 있는 현금
	myMoney -= money;		
}	
//과일구매후 현재 남은 현금과 사과의수 출력 기능 
public void showBuyResult() {
	System.out.println("현재잔액 : " + myMoney);
	System.out.println("사과 개수 : " + numOfApple);
}		
}




public class Ex1_2 {
public static void main(String[] args) {

	// 과일장수 2명 객체 생성 
	
	//과일장수 객체생성과 동시에 객체(인스턴스)변수 값 초기화 
	//방법 : 생성자 호출! 
	// 과일장수 1 			사과한개당 가격 1500원 사과 보유수 30개, 판매수익 0원 
	FruitSeller seller1 = new FruitSeller(1500, 30, 0);
	// 과일장수2 				사과한개당 가격 1000원 사과 보유수 20개, 판매수익 0원 
	FruitSeller seller2 = new FruitSeller(1000, 20, 0);			

			
	//과일구매자 1명 객체생성
	
	// 과일 구매자 객체 생성과 동시에 객체 변수값 초기화를 위한 생성자 호출 !
	// 과일 구매자 현재 소유하고 있는 현금 10000원 , 현재 구매한 사과 수 0개 
	FruitBuyer buyer1 = new FruitBuyer(10000);
	
	
	//과일구매자는  과일장수1에게 4500원어치 사과 구매하기
	buyer1.buyApple(seller1, 4500);
	//과일구매자는  과일장수2에게 2000원어치 사과 구매하기
	buyer1.buyApple(seller2, 2000);

	//과일 장수1의 현재상황
	System.out.println("--과일 장수1의 현재상황--");
	seller1.showSaleResult();

	//과일 장수2의 현재상황
	System.out.println("--과일 장수2의 현재상황--");
	seller2.showSaleResult();
			
	//과일 구매자의 현재상황
	System.out.println("--과일 구매자의 현재상황--");
	buyer1.showBuyResult();


	/*
 	이 프로그램은 과일 장수1 , 과일장수 2의 객체들의 사과 1개당 가격은 객체 메모리를 생성한 후 각각 1500원 , 1000원 으로 다르게 설정하는 것은 가능 했다.
 		
 		그러나 이 프로그램 문제점 2가지가 있다.
 		
 		1. 과일장수 1 과 2 객체는 생성하고 난 다음에 객체변수들의 값을 초기화해야한다.
 			즉! 두 줄에 걸쳐서 코드문장을 작성해야  하나의 객체메모리를 생성해서 완성할 수 있다. 
 			
 		2. FruitSeller(과일장수) 클래스로 객체를 생성하면 객체메모리 내부의  APPLE_PRICE 상수의 final 선언이 사라진점이 문제가 된다.
 		
 			final 선언이 사라진점이 왜 문제가 될까?
 			 : 클래스 설계시 과일장수가 판매하는 사과 한개당 가격은 변경되지 않음을 가정해 두고 
 			 	객체 변수 int  apple_price 로 변경했습니다. 
 			 	 initMembers 메소드 내부에서 구현코드로 apple_price 변수값을 초기화 하려다 보니 	어쩔수 없이 final 선언을 강제로 삭제 시켰습니다.
 			 	
 			 	메소드라는 것은 만들어 놓고 여러번 호출할 수 있으므로 
 			 	initMembers 메소드를 여러번 호출한다면 객체 메모리의 변수값 초기화 하는 작업의 실수를 범할 수도 있기 때문에
 			 	결론은 객체 메모리 생성하는 동시에 단 한번만 호출되는 생성자를 이용해 객체 메모리를 생성후 빠르게 객체변수들을 초기화  해야한다.
 			 	
 	
 		이 프로그램의 문제점들 해결방법은 클래스 설계시 내부에 생성자를 만들어 놓고 사용하자 
 	
 */
 }
}

