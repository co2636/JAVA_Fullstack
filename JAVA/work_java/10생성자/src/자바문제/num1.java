package 자바문제;

public class num1 {

	public static void main(String[] args) {
		// 문제 2
		Student s = new Student("홍길동",1,1,100,60,76);
		String str = s.info();
		System.out.println(str);

		//문제 3
		System.out.println("이름 : " +s.name);
		System.out.println("총점 : " + s.getTotal());
		System.out.println("평균 : "+ s.getAverage());
	}

}

//문제 1

class Student{
	String name; // 학생이름 
	int ban; // 반 
	int no;  // 번호 
	int kor; // 국어점수 
	int eng; //영어점수 
	int math; // 수학점수 
	
// 문제 2
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
	
	public String info() {

		
		return (name  + ", " +ban + ", " + no + ", " + kor + ", " + eng + ", " + math+  ", " + (kor+eng+math)+ ", " + (int)((kor+eng+math)/3f * 10 + 0.5f) / 10f);
		
	}
	
	// 문제 3
	public int getTotal() {
		return kor + eng + math;
	}
	
	public float getAverage() {
		return (int)(this.getTotal()/3f*10+0.5f)/10f;
		//							236        /3f			->  78
		//							int		   /int		->  int
		//  설명 : 총점의 타입이 int 이기 때문에 3으로 나누면 int 와 int 간의 연산이므로 결과를 int 로 얻는다. 즉 ! 소수점 이하는 버려지게 된다.
		//			  그래서 아래와 같이 float 타입의 리터럴의 3f 로 나누어야 소수점 이하의 값들을 얻을 수 있다.
		
		//							236		  	/   3f		->  78.66664		
		//  소수점 둘째 자리에서 반올림하려면 10을 곱하고, 0.5를 더한 다음 다시 10f로 나누면 된다.
		//	 						236			/	3f	 * 10 -> 786.66664
		//							236			/   3f * 10 + 0.5  ->  787.16664
		//							787.16664를 정수로 형변환 (int)하면 787 정수로 만듬 
		//						    787 / 10f 로 나누면 78.7
		
	}
}

