
import java.util.Enumeration;
import java.util.Vector;

public class EnumerationTest01 {

	public static void main(String[] args) {
		
		// 기본생성자로 생성하면 10칸의 Vector 배열메모리가 만들어진다.
		// Vector 배열 메모리 10칸에 객체가 모두 저장된 상태에서 add 메소드를 호출해서 하나의 객체를 추가하면 1칸씩 가변으로 늘어나서 저장되게 된다.
		Vector vector = new Vector();
		
		// Integer 객체 5개를 반복해서 만들어서 Vector 배열에 차례로 저장 
		for(int i=1; i<=5; i++) {
//			vector.add(new Integer(i*10));
			vector.add(i*10);
		}
		// Vector 배열의 elements 메소드를 호출하면 Vector  배열에 저장된 모든 Integer 객체들을 꺼내어서 Enumeration 부모인터페이스를 구현한 자식
		// Enumeration 배열메모리 모두 저장한 후 자식 Enumeration 배열메모리 자체를 반환 
		Enumeration enu = vector.elements();
		
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		
	}

}
