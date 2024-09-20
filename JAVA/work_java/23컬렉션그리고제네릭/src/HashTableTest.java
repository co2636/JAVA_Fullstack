
// 주제 : Map  부모인터페이스를 구현한 자식 HashTable 클래스로 배열 만들어 사용해 보기

import java.util.Hashtable;
import java.util.Enumeration;

public class HashTableTest {
	public static void main(String[] args) {
		
		// 해쉬테이블 배열메모리에 데이털를 저장할 때 (key -value) 한쌍 형태로 묶어서 저장된다.
		// 즉 ! 해쉬테이블 공간은 표 공간이라고 보면 좋겠죠?
		Hashtable ht = new Hashtable();
		
		// 해쉬테이블 배열메모리에 데이터 (key-value)를 저장할때 put 메소드 사용 
		// key 또한 객체로 넣고
		// value 또한 객체로 넣는다.
		//			 key ,     value 
		ht.put("사과", "Apple");
		ht.put("딸기", "StrawBerry");
		ht.put("포도", "Grapes");
		
		// 해쉬테이블 배열메모리에 저장된 데이터 중 value 를 얻기 위해서는 get 메소드를 이용하자
		// key 를 get 메소드 호출시 매개변수로 전달하면 key 와 같이 한쌍으로 저장했던 value 값을 얻을 수 있다.
//		Object obj = ht.get("포도"); // 업캐스팅을 통해 저장
		//		"Grapes"
		
		// 다운 캐스팅
//		String value = (String)obj;
		
		// 업캐스팅이 일어나는 동시에 다운캐스팅 해서 저장 
		String value = (String)ht.get("포도");
		
		// key("포도") 를 통해 value("Grapes") 를 꺼내올수 있다면?
		if(value != null) {
			System.out.println("포도 key와 같이 연결되어 저장된 value -> " +  value);
		}

		/*
		 	HashTable 배열에 저장된 모든 key(객체)들을 일일이 기억하지 못하므로 모든 key(객체)들만 뽑아내서 Enumeration 배열에 담아 
		 	Enumeration 배열 주소 자체를 반환 
		 	-> keys() 메소드 
		 */
		
		 Enumeration enu = ht.keys();
		
		 while(enu.hasMoreElements()) {
			 // 1. Enumeration 배열에 저장되어 있는 key 들을 차례로 얻어 저장 
			 String key =  (String)enu.nextElement();
			 						//	"사과", "딸기", "포도"  <-- key 들
			 // 2. key 들을 이용해 HashTable 에 저장된 value 들을 차례대로 얻어 저장 
			 String val = (String)ht.get(key);
			 						// "사과"  ->  "Apple"
									// "딸기"  ->  "StrawBerry"
									// "포도"  ->  "Grapes"
			 // 3. HashTable 배열에 저장되어 있었던 key 에 대응되는 value 값을 같이 반복해서 출력 
			 System.out.println(key + " - " + val);
		 } 
		
		
	}

}
