/*
 		추상메소드란?
 		- 자식클래스들이 가지고 있는 공통 메소드를 뽑아내어 추상클래스로 작성할때 메소드 선언부(리턴타입, 메소드명, 매개변수)만 동일하고 
 			구현부(기능을코드로 작성하는부분)를  작성해 놓지 않는 메소드
 			
 		- 문법 
 					abstract 리턴타입 추상메소드명(매개변수,.....);
 	
 		- 일반 메소드와 차이점은 abstract 키워드가 붙고, 메소드의 실행내용인 중괄호{} 가 없다.
 		
 		얘) public abstract class Animal { // 추상클래스(미완성 설계도)
 		
 					// 추상 메소드 
 					 abstract void sound();
 					 
 				}
 	
 	
 */

// 추상클래스 이자 부모 역할을 하는 미완성 클래스
abstract class Animal{ // 동물
	
	// 상수, 변수, 일반메소드, 추상메소드 등을 작성할 수 있다.
	
	// 일반 메소드
	public void breathe() {
		// 메소드는 구현부를 가진다.
		System.out.println("숨을 쉽니다.");
	}
	
	// 추상 메소드 - 추상 메소드는 메소드의 기능을 이름으로 만들어 놓기 때문에 메소드의 중괄호{} 구현부가 없다.
	public abstract void sound();	
	
}
// Animal 부모역할을 하는 추상클래스를 상속받아 새로운 자식 Dog 클래스를 설계한다.
class Dog extends Animal{

	// 추상클래스 Animal을 상속받아 만들때는 무조건 추상메소드를 강제로 메소드 오버라이딩해야함 
	// 이유는 추상클래스 Animal 에는 아직 완성되지 않은 추상메소드가 존재하기 때문에 
	// 추상메소드의 선언부만 부모클래스 내부에 작성하되  구현부는 Dog 자식클래스에서 재구현 해서 사용해야한다.
	@Override
	public void sound() {
		// 재구현
		System.out.println("멍멍!");
		
	}
	
}

//Animal 부모역할을 하는 추상클래스를 상속받아 새로운 자식 Cat 클래스를 설계합니다.
class Cat extends Animal{

	@Override
	public void sound() {
		// 재구현
		System.out.println("야옹!");
	}
	
}


public class AbstractMethod {
	
	public static void animalSound(Animal animal) {
		animal.sound(); // 매개변수 animal 로 전달받는 자식객체의 종류에 따라 자식객체 내부에 오버라이딩 된 sound() 메소드가 실행됨
		
	}
	
	public static void main(String[] args) {
		
		AbstractMethod.animalSound(new Dog()); // 멍멍!
									  animalSound(new Cat());  // 야옹!
		
		// 자식 클래스인 Dog 클래스는 일반(실체) 클래스이므로 객체 생성가능 
		Dog dog = new Dog();
		dog.sound(); // 멍멍!
		
		// 자식 클래스인 Cat 클래스는 일반(실체) 클래스이므로 객체 생성 가능 
		Cat cat = new Cat();
		cat.sound(); // Cat 자식에 오버라이딩  된 메소드 실행  // 야옹!
		
	}

}
