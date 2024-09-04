package PA;

// 주제 : 부모클래스 A와 자식클래스 B가 다른 패키지에 있는 경우 다양한 접근 제어자를 지정한 변수에 접근하는 실습 

public class A {
	int i;
	protected int pro;
	private int pri;
	public int pub;
	public void print() {
		System.out.print("i= " + this.i + ", ");
		System.out.print("pro=" + this.pro + ", ");
		System.out.print("pri=" + this.pri + ", ");
		System.out.println("pub=" + this.pub + "입니다.");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
