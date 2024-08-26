
//예제 : 다중 for 문에서 제어 변수의 변화 알아보기 

public class E08 {

	public static void main(String[] args) {
		
		int i; // 안쪽 for 문 제어변수
		int a; // 바깥쪽 for 문 제어변
		
		System.out.println("시침 -----------------------> 분");
		System.out.println("a (바깥 쪽 제어변수) -------> i (안쪽 제어변수)");
	
		for(a =1 ; a < 5; a++) {
			for(i=1; i<= 5; i++) {
				System.out.println(a + "--------------->>" + i);
			}
		}
	}

}
