

//상속이란?
// 기존에 만들어져 있는 부모클래스의 변수나 메소드들을 새롭게 만드는 자식클래스에서 그대로 가져와 사용하는 개념 

// 주제 : 기존에 만들어져 있는 부모클래스 내부의 메소드를 상속 받아 새로운 자식 클래스를 만드는 예 

// 아버지 클래스(기존에 만들어져 있는 부모클래스)
class Parent{
	
	// 메소드 
	public void parentPrn() {
		System.out.println("Parent 부모클래스의 메소드는 상속된다.");
	}
	
}
// 아들 클래스(새롭게 만드는 자식클래스)
//  ->  Child 라는 아들 클래스를 새롭게 만들때 extends 예약어를 작성하여 상속을 받는데 extends 예약어 뒤에 상속받을 Parent 부모클래스명을 작성해서
//		   Parent 부모클래스에 작성되어 있는 메소드를 상속받아 새롭게 Child 클래스르 만든다.
class Child extends Parent{
	/*
	 	Parent 부모 클래스로 부터 상속받아 사용하는 메소드 
	 	
	 	public void parentPrn() {
			System.out.println("Parent 부모클래스의 메소드는 상속된다.");
		}
		
	*/
	
	//Child 클래스의 메소드 
	public void childParent(){
		System.out.println("Child 클래스의 메소드는 Parent 부모 클래스에서 사용할 수 없다.");
	}
	
}
public class Ex1 {

	public static void main(String[] args) {
		
		// 기존의 부모 클래스인 Parent 클래스의 객체 생성 
		Parent p = new Parent();
		p.parentPrn(); // Parent 자기 자신 객체 메모리 내부의 parentPrn() 메소드 호출 가능 
		
//		p.childParent(); // Child 자식 클래스의 객체 메모리가 생성되지 않아 p 참조변수로는 메소드를 호출 할 수 없음 
		
		/*
												0x11
			[ 0x11 ] = -------부모 Parent 객체 메모리----------
			
								public void parentPrn(){}	
								
							---------------------------------------
		 */



		
		//----------------------------------------------------------------------------
		
		// 자식 클래스인 아들(Child) 클래스의 객체 생성 
		Child c = new Child();
		c.parentPrn(); // 부모 Parent 객체메모리에 상속받아 접근하여 호출되는 메소드
		c.childParent(); // 자식 Child 자신 객체 메모리에 만들어진 메소드 호출 
		
		/*
		 										0x10
		 		[ 0x10] = -------부모 Parent 객체 메모리----------
		 			
		 						public void parentPrn(){}
		 			
		 				-------자식 Child 객체 메모리-----------
		 				
		 							void childParent(){}
		 				
		 */

		/*
		 		결론 
		 				상속하는 이유는 이미 만들어져 있는 변수, 메소드를 갖는 기존(부모)클래스의 변수나 메소드를 
		 				상속받은  다음 새롭게 만드는 자식 클래스에 자신의 멤버(변수, 메소드)에 + 해서 새로운 자식클래스를 완성해서 만들기 위함이다.
		 				
		 				그리고 자식클래스에 대한 객체메모리 생성 후  부모 클래스로 부터 상속 받은 멤버(변수, 메소드)들에 접근하여 사용할때 
		 				부모객체의 멤버에 접근해서 사용하기 위함 
		 		
		 */
		


	}

}
