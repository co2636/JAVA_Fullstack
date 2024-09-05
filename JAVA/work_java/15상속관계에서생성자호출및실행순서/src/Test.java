
// 예제 :  super super() 키워드 연습 

// 직원 설계도(클래스)
// 클래스명 : Employee
class Employee{ // 부모 클래스 
	
	String name; // 이름 
	int salary;  // 급여 
	
	
	public String getEmployee() {
		return name + ", " + salary;
	}
	
	// 기본생성자 
	public Employee() {
		
	}
	
	// name , salary 인스턴스변수값 초기화할 생성자 
	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

}

// Employee 부모 클래스를 상속 받아 Manger 자식 클래스 만들기 
class Manager extends Employee{
	String depart; // 부서명 
	
	// 완성되는 Manager 객체의 이름, 급여, 부서명등의 정보를 하나의 문자열로 반환하는 기능의 인스턴스 메소드 
	public String getManager() {
		return super.name + ", " + super.salary + ", " + this.depart;
//		return this.name + ", " + this.salary + ", " + depart;
//		return name + ", " + salary + ", " + depart;
	}
	
	// 완성되는 Manager 객체의 이름, 급여, 부서명을 초기화 할 생성자 
	public Manager(String name, int salary, String depart) {
		
		super(name, salary);
//		this.name = name;
//		this.salary = salary;
		this.depart = depart;
	}
}

public class Test {

	public static void main(String[] args) {

		Employee emp = new Employee("홍길동",2000);
		
		// Manager 자식객체생성 
		Manager man = new Manager("이순신", 4000,"개발");
		
		/*
		 				 자식 Manager 객체 생성하면 전체 Manager 객체 메모리 하나가 생성되면서 
		 				 부모객체메모리도 만들어져서 포함되니 생성된 Manager 객체 메모리 주소는 하나다.
		 				
		 												0x11
		 				
		  [ 0x11 ] = --------------------------------------------------------
		  							부모 Employee 객체 메모리 영역 
		  							
		  							String name;  [ "이순신"  ]
		  							int salary;		[ 4000  ]

		  				 			public String getEmployee(){}
		  				 
		  				 --------------------------------------------------------
		  							자식 Manager 객체 메모리 영역
		  							
		  							String depart; [ "개발" ]
		  							
		  							public String getManager(){}
		  							public Manager(){}
		  							
		  				 --------------------------------------------------------
		 */
		System.out.println(emp.getEmployee());
		System.out.println(man.getManager());
		

	}

}
