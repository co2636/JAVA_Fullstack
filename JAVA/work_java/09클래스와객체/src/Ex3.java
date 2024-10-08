
// 예제 : 생성된 객체 메모리 주소들을 배열의 각 원소에 저장하여 사용하기 

// 객체 지향 프로그래밍 기법 3단계

// 1 단계 - 현실에 존재하는 사람객체 모델링
// 데이터 -> 철수(이름), 30(나이)
//  행동   -> 자신의 이름을 알려주는 행동 

// 2 단계 - 1 단계의 사람객체의 공통점을 찾아내면 사람이라는 것을 알수 있다.
//				 요약 :  사람 클래스(설계도)  정의
class Person{
	// 변수
	String name;  // 사람 이름 저장 
	int age; 			// 사람 나이 저장 

	// 메소드 
	// name 객체 변수에 저장된 이름을 반환하는 메소드 
	public String getName() {
		
		return name;
		
	}
	
	
}

public class Ex3 {

	public static void main(String[] args) {
		
		// 기본 자료형(int, float, double, boolean ... )  값을 저장하기 위한 배열 메모리를 만드는 예
		// 1. 정수들만 저장할 배열 메모리를 생성 후 배열메모리의 주소번지를 저장할 참조변수 선언 
		int[] array;
		
		// 2. 정수 3개를 저장할 배열 메모리 3칸 생성 후 배열 메모리의 주소번지는 array 참조변수에 저장 
		array = new int[3];
		
		// 3. 배열 메모리 전체 중 각 원소에 정수들 저장 
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;

		// {    10    ,    20 ,     30}
		//        0            1          2       index 
//------------------------------------------------------------------------------------------------
		
		// 객체메모리의 주소번지를 저장할 배열 메모리(객체 배열메모리) 생성 
		// - 생성된 객체 메모리의 주소값 하나하나를 값으로 갖는 배열 메모리 
		
		// Person 클래스를 이용해  Person 객체 생성 후 객체 배열  메모리 주소를 저장하기  위한 참조변수 선언 
		// 문법 
		// 클래스자료형명[]   참조변수명;
			Person[]  persons;
		
		// new  Person(); 객체들을 10개를 생성하여 각 원소에 주소를 저장할 10칸의 객체배열 메모리 생성 후 배열메모리 주소번지를 persons 참조변수에 대입 
		// 문법 
		//	참조변수 = new 클래스자료형명[칸의 갯수];
			persons = new Person[10] ;
			
//																	0x11
//			 [ 0x11 ]  = { null, null, null, null, null, null, null, null, null, null };
//								  0		1		2		3		4		5		6		7		8		9		 index
			
		
		/// 3 단계 -  2단계에서 만든 class 를 이용해 객체 메모리 생성 후 사용 
		
			// persons 객체 배열의 크기만큼 반복하여 new Person 객체 메모리 생성하여 생성된 new Person 객체 메모리들의  주소번지를 각 칸에 저장시키자 
		for(int i=0; i < persons.length ; i++) {
			
			persons[i] = new Person();
			
			persons[i].age = 30 + i;

			// i  가  0 일때  Person 객체 생성후 주소번지가 만약 0x12 한다면 persons 객체 배열의 0 index 위치 칸에 0x12가 대입되어 null 은 제거되고 저장됨 
			// i  가  1 일때  Person 객체 생성후 주소번지가 만약 0x13 한다면 persons 객체 배열의 1 index 위치 칸에 0x13가 대입되어 null 은 제거되고 저장됨 
			// i  가  2 일때  Person 객체 생성후 주소번지가 만약 0x14 한다면 persons 객체 배열의 2 index 위치 칸에 0x14가 대입되어 null 은 제거되고 저장됨 
			// ....
			// i  가  9 일때 까지 Person 객체를 10개 생성해서 주소 10개를 0 ~ 9 index 각 칸에 저장하게 됨 
	
	//			 [ 0x11 ]  = {  0x12 , 0x13, 0x14 , 0x15 , 0x16, 0x17, 0x18, 0x19, 0x20, 0x21 };
	//			 						 0			1		  2		 3			4		   5		6		  7		8		   9		 index

	//			 [ 0x11 ]  = { Person 객체 , Person, Person , Person , Person, Person, Person, Person, Person, Person };
	//			 						 	0					1			  2			 3				4			   5			6			  7			8			   9		 index

			// persons 객체 배열 메모리의 각 원소에 저장된 new Person();로 생성한  각 객체 메모리들을 차례로 얻어 객체 메모리 내부에 있는 변수값을 출력!
			
			/*
			 	persons 배열 0번째 인덱스의 Person 객체 1 의 객체변수 age = 30
			 	persons 배열 1번째 인덱스의 Person 객체 2 의 객체변수 age = 31
			 	persons 배열 2번째 인덱스의 Person 객체 3 의 객체변수 age = 32
			 	persons 배열 3번째 인덱스의 Person 객체 4의 객체변수 age = 33
			 	persons 배열 4번째 인덱스의 Person 객체 5 의 객체변수 age = 34
			 	persons 배열 5번째 인덱스의 Person 객체 6의 객체변수 age = 35
			 	persons 배열 6번째 인덱스의 Person 객체 7 의 객체변수 age = 36
			 	persons 배열 7번째 인덱스의 Person 객체 8 의 객체변수 age = 37
			 	persons 배열 8번째 인덱스의 Person 객체 9 의 객체변수 age = 38
			 	persons 배열 9번째 인덱스의 Person 객체 10 의 객체변수 age = 39

			 */
			
//			System.out.println("persons 배열 " + i + "번째 인덱스의 Person 객체 " + (i+1) + "의 객체 변수 age = " + persons[i].age);
			
		}
		
		int j = 0;
		for(Person person : persons) {
			
			System.out.println("persons 배열 " + j + "번째 인덱스의 Person 객체 " + (j+1) + "의 객체 변수 age = " + person.age);
			j++;
			
		}
	
	}

}
