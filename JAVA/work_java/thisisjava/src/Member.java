/*
 	DTO 역할을 하는 클래스란?
 	- 데이터베이스의 테이블에서 조회한 한 행의(한 사람의) 정보를 하나의 객체 단위로 변수에 저장할 목적의 클래스 
 	- 회원가입(데이터베이스에 회원 한명 추가) 가입하거나 게시판이 있다면 게시판에 새로운 새 글 정보 하나를 작성해서 하나의 객체(레코드)단위로 데이터베이스에 추가할 목적의 클래스 
 	- DTO 역할을 하는 클래스 내부에 작성할 수 있는 멤버들은 인스턴스변수, 생성자, getter, setter 메소드들 toString() 등을 작성하면 됨. 
 	  
 */

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Data
public class Member { // 회원 한사람의 정보 저장할 설계도 
	// 인스턴스 변수 
	private String id;  // 회원 아이디 저장 
	private String name;  // 회원 이름 저장 
	private int age;  // 회원 나이 저장 
	
	public static void main(String [] args) {
		Member member = new Member();
		
		member.setAge(10);
		member.setId("admin");
		member.setName("김길동");

		System.out.println(member.age + " " + member.id + " " + member.name);
	}
}
