package StringTest;
/*
 		String 클래스에서 제공해주는 lastIndexOf("문자 또는 문자열") 메소드
 		
 		- 기능 : 매개변수로 전달하는 문자 또는 문자열이 전체 문자열 내에서 마지막으로 발견된 문자 또는 문자열이 존재하면 그 문자가 위치한 index 위치 반환 
 					만약 존재하지 않으면 -1을 반환하는 메소드 
 					
 		- 반환값 
 						해당 문자의 index 위치번호 반환
 						또는
 						해당 문자가 없으면 -1 반환 
 						
 */

// 데이터베이스에 저장된 회원정보 한사람의 정보를 조회해서 가져와 저장 시킬 MemberDTO 클래스 만들기
class MemberDTO {
	
	private String name; // 회원 이름
	private String address; // 회원 주소 
	
	// 생성자 : 이름과 주소 초기화 
	public MemberDTO(String name, String address) {
		this.name = name;
		this.address = address;
	}

	// 이름을 반환하는 메소드 getter
	public String getName() { return name; }
	
	// 주소를 반환하는 메소드 getter 
	public String getAddress() { return address; }
	
	// 상세 주소를 반환하는 메소드 getter
	public String getDetailAddress() {
		
		// address 변수에 저장된 회원의 전체 주소 문자열 중에서  마지막에 작성된 ' / ' 가 포함되어 있는지 검사를 위해 ' / ' 문자의 index 위치 번호를 찾음 
		int lastIndex = address.lastIndexOf('/'); 
		

		// 상세주소가 있을 경우 전체 주소에서 ' / ' 문자 다음부터 끝까지의 주소를 잘라서 반환 
		// ' / ' 가 존재하고 그 다음에 문자가 있을 경우 
		if(lastIndex != -1 && lastIndex + 1 < address.length() ) {
			// lastIndex 가 -1 이 아니면 ' / ' 가 존재함을 의미
			// lastIndex + 1 은 ' / ' 다음 문자의 인덱스
			// lastIndex + 1 이 address.length() 보다 작으면 ' / ' 다음에 문자가 존재함을 의미 
			
			// 전체 주소 문자열에 적힌 ' / '  다음 부터 문자열의 끝까지 잘라서 반환(상세주소만 잘라서 반환)
			// subString 메소드는 시작 인덱스부터 끝까지의 문자 전체를 잘라서 반환 
			return  address.substring(lastIndex + 1 ); // 상세 주소를 잘라서 반환 
			
		}
		
		// 상세주소가 없을 경우 전체 주소를 반환 
		// ' / ' 문자가 없거나  ' / ' 다음에 문자가 없으면 전체주소를 반환 
		return address;
	}
	
}


public class Ex3 {

	public static void main(String[] args) {
		
		// 스토리 : 데이터베이스에서 조회된 회원 수 5명이라고 가정하고 작업하자 
		
		// 회원 수를 정의
		final int MEMBER_COUNT = 5; // 5명
		
		// 데이터베이스에 저장된 5명의 정보를 조회해서 가져와 한명씩 MemberDTO객체에 저장 할 것 이다.
		// new MemberDTO(); X 5
		
		// MemberDTO 객체 5개를 저장시킬 칸이 5칸인 배열 생성 
		MemberDTO[] memberArray = new MemberDTO[MEMBER_COUNT];
																	//	[ null, null, null, null, null ];
																	//		 0		  1		 2 	  3	  4 
		
		// 데이터베이스에서 회원정보 조회(여기서는 예시로 고정된 조회된 값 사용)
		memberArray[0] = new MemberDTO("홍길동", "서울시 강남구 테헤란로 123/101호");
		memberArray[1] = new MemberDTO("김철수", "부산시 해운대구 해변로 456/202호");
		memberArray[2] = new MemberDTO("이영희", "대구시 수성구 수성로 789/303호");
		memberArray[3] = new MemberDTO("박지민", "인천시 남동구 남동대로 101/404호");
		memberArray[4] = new MemberDTO("최준호", "광주시 북구 분문로 112/505호");
		
		// 각 회원(MemberDTO 객체) 의 이름과 상세주소를 출력
		for(MemberDTO member : memberArray) {
			System.out.println("이름 : " + member.getName() + ", 상세주소 : " + member.getDetailAddress());
		}
		
		
		
		
		
	/*
		 
		// 전체 문자열
		String text = "apple, banana, cherry, banana, date ";
					
		// 찾을 문자열 - "banana" 중 마지막에 작성된 "banana"를 찾으면 "banana"의 b 의 index 위치 번호 반환 
		int lastIndex = text.lastIndexOf("banana");
		
		System.out.println(lastIndex); //23 
		
 */
		
		
	}

}
