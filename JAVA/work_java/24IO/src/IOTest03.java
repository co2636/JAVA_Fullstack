
// 주제 : 특정 파일에 기록된(저장된) 데이터를 바이트 단위로 읽어들여서 모니터 장치 화면에 출력(내보낸다)
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOTest03 {
	public static void main(String[] args) {
		
		int data = 0; // 전체 파일의 데이터들 중에서 1byte(8bit) 메모리에 저장할 크기의 데이터를 읽어서 저장할 변수 
		
		// 읽어 들일 특정파일의 전체경로를 문자열로 변수에 저장 
		String path = "/Users/leejunhui/JAVA_Fullstack/JAVA/work_java/23컬렉션그리고제네릭/src/Collections01.java";
		
		// FileInputStream 클래스의 객체?
		// -> 지정한 전체 경로의 특정 파일의 정보를 byte 단위로 읽어들일 입력스트림 통로
		try {
								  // 문법 2. new FileInputStream("파일저장경로");
			FileInputStream fis = new FileInputStream(path);
			
			// Collections01.java 특정파일의 정보를 1바이트 단위로 읽어들여 모니터(출력장치)에 반복해서 출력
			while((data = fis.read()) != -1) {
				// 한번 읽어 들인 데이터를 출력스트림 통로를 통해 모니터에 출력(내보낸다)
				System.out.write((char)data);
			}
		}catch(Exception e) { // FileNotFoundException , IOException 모두 처리할 수 있음.
			e.printStackTrace();
		}
		
		

	}

}
