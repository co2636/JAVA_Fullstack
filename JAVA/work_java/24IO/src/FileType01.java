
// 주제 : 파일명을 입력받아 입력받은 파일명의 파일내용을 읽어와 모니터 화면에 출력
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class FileType01 { // javac FileType01.java 컴파일하면 
											// 			 FileType01.class 생성된다.
	
	// 명령 프롬포트 cmd 창에 입력되는 것.
	// java FileType01 FileTest02.java
	// 											0				index
	
	public static void main(String[] args) {
		
		int data = 0; // 입력받은 파일의 정보를 한 바이트씩 읽어 저장할 변수
		int size = 0; // 입력받은 파일의 크기를 계산해서 저장할 변수 
		
		// cmd(명령프롬포터) 창에 파일명을 하나만 입력했다면?
		if(args.length < 1) {
			// 입력받는 방법을 알려주기 위해 메세지 출력
			System.out.println("사용법 : java FileType01 읽어들일파일명");
			// FileType01.class 프로그램을 강제로 종료
			System.exit(0);
		}
		// cmd 창에서 입력한 첫번째 파일명을 문자열로 얻어 저장 
		String path = args[0];
		System.out.println(path); // FileTest02.java <- 읽어들일 파일 
		
		// 문법 1. FileInputStream 객체 생성 
		// 순서1.   File f = new File("읽어올파일경로");
		// 순서2.  FileInputStream fis = new FileInputStream(f);



		try {
			File f = new File(path); // File 객체 생성하여 입력한 FileTest02.java 에 접근할 수 있도록 함 
			
			FileInputStream fis = new FileInputStream(f);
			
			// FileTest02.java 파일에 저장된 데이터들을 1바이트 단위씩 읽어서 
			while((data = fis.read()) != -1) {
				// FileTest02.java 파일에서 한 바이트 단위씩 읽어들인 데이터를 모니터 화면에 출력하자 
				System.out.write(data);
				// 한번씩(1바이트 단위씩) 읽어들여 출력할때마다 문자개수 계산 
				size++;
				// 한글 한글자 -> 3바이트 크기에 저장할 데이터 
				// 영문 한글자 -> 1바이트  크기에 저장할 데이터 
			}
			System.out.println("파일크기 : " + size + "bytes");
		}catch(FileNotFoundException  e) {
			System.out.println("지정된 경로에 파일을 찾을수 없습니다.");
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("지정된 경로에 파일에서 데이터를 읽어들일수 없습니다.");
			e.printStackTrace();
		}
		
		
		
	}

}
