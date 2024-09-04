
// 주제 : 부모클래스와 자식 클래스가 같은 패키지에 있는 경우 다양한 접근제어자를 지정한 멤버(변수 또는 메소드)

// Super 라는 이름의 class 만들기 
class Super{
	//public 접근제어자를 이용해 4바이트 크기의 정수를 저장시킬 num1 이라는 이름의 변수 선언후 10 저장 
	public int num1 = 10;
	//protected 접근제어자를 이용해 4바이트 크기의 정수를 저장시킬 num2 이라는 이름의 변수 선언후 20 저장 
	protected int num2 = 20;
	// default 접근제어자를 이용해 4바이트 크기의 정수를 저장시킬 num3 이라는 이름의 변수 선언후 30 저장 
	int num3 = 30;
	//private 접근제어자를 이용해 4바이트 크기의 정수를 저장시킬 num4 이라는 이름의 변수 선언후 40 저장 
	private int num4 = 40;
	
	public int getNum4() {
		return num4;
	}
	
}

// Super 클래스를 부모로 정하여 상속받는 Sub 자식 클래스 만들기 
class Sub extends Super{
	private int num5;
	public void print() {
		System.out.println(super.num1);
		System.out.println(super.num2);
		System.out.println(super.num3);
		System.out.println(super.getNum4());
		System.out.println(this.num5);	
		
	}
}

public class Test2 {

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.print();

	}

}
