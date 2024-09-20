
// 주제 : Stack 메모리 다루기
//			  Stack 메모리는 First In Last Out  -> FILO  구조를 가진다.

import java.util.Stack;

public class StackTest01 {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		
		stack.push("1-자바");
		stack.push("2-자바스크트");
		stack.push("3-API");
		stack.push("4-데이터베이스");
		
		//  Stack 메모리 내부에 객체가 저장되어 있느냐?
		while( !stack.isEmpty()) {
			// Stack 메모리에 저장된 객체들을 역순으로 꺼내온다.
			System.out.println(stack.pop());
//					4-데이터베이스
//					3-API
//					2-자바스크트
//					1-자바

		}
		
		// Stack 의 isEmpty() 메소드
		// Stack 메모리에 객체가 저장되어 있지 않느냐? 라고 물어보는 메소드로 저장되어 있지 않으면 true 반환, 저장되어 있으면 false 반환 
		
		
	}

}
