package PB;

import PA.A;

public class B  extends A{

	void set() {
		super.pro = 2;
		super.pub = 4;
	}
	public static void main(String[] args) {
			
		B b = new B();
		b.set();
		b.print();
	}

}
