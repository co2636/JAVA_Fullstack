package PA;

// 주제 : 부모클래스 A와 자식클래스 B가 다른 패키지에 있는 경우 다양한 접근 제어자를 지정한 변수에 접근하는 실습 

public class A { // PA 패키지 안에 있는 A 부모클래스 
	
					  int i;  // default 
					  
	protected int pro;
	
	private int pri;
	
	public int pub;
	
	public void print() {
		
		System.out.print("i= " + this.i + ", ");
		System.out.print("pro=" + this.pro + ", ");
		System.out.print("pri=" + this.pri + ", ");
		System.out.println("pub=" + this.pub + "입니다.");
		
	}

		// 다른 PB 패키지에 만들어 놓은 B자식클래스에서 접근해보자 
	
}
