package StringTest;

/*
 	 주제 : "Hello, World!" 전체 문자열에서 l 문자들을 모두 제거시킨 "Heo, Word!" 로 만들자  
 */

public class Ex4 {

	public static void main(String[] args) {
		
		// 전체 문자열 <-  검사할 대상  
		String originalString = "Hello, World!";
		// 										0123456789
		
		// 삭제 대상 문자열 
		String deleteString = "l";
		
		// 전체 문자열 중에서 " l " 특정 문자열을 제거하기 위해 subString 메소드를 이용해 잘라낸 "Heo, Word!" 를 저장할 변수
		String modifiedString = "";
		
		for(int i=0; i<originalString.length(); i++) {
			// 검사 대상 문자열이 삭제 대상문자열 ('l') 이 아니라면 ?
			if( !(originalString.substring(i, i+1).equals("l")) ) {
											//				 0,  1
											//				!"H".equals("l")
											//				  1,  2
											//  			!"e".equals("l")
				
				
				modifiedString += originalString.substring(i,i+1);
				// "H"
				//						  += "e"
				// "He"
			}
			
		}
		System.out.println("ModifiedString 변수 : " + modifiedString); // ModifiedString 변수 : Heo, Word!
	
	}

}
