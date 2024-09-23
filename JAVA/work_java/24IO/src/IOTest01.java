
// 주제 : 키보드로 부터 입력된 문자열의 문자 갯수 세기 

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOTest01 {
	public static void main(String[] args) {
		
		// 키보드를 이용해 입력한 전체 데이터크기 중 읽어 들인 한 바이트 크기의 데이터를 저장할 변수 
		int data = 0;
		// 읽어 들인 문자열의 문자갯수를 계산해서 저장할 변수 
		int cnt = 0;
		
		// 키보드로 부터 입력한 전체 데이터 중 1 바이트씩 읽어 들일 입력 스트림 역할의 BufferedInputStream 자식 객체 얻기 
		InputStream myIn = System.in;  // <- 입력스트림 통로 
		
		// BufferedInputStream 입력 스트림 통로를 통해 1 바이트씩 읽어들인 데이터를 모니터  등의 출력 장치에 1 바이트씩 내보낼 역할의 
		//	출력 스트림 PrintStream 객체 얻기
		OutputStream myOut = System.out; // <- 출력스트림 통
		
		System.out.println("문자를 입력하세요. IOTest01.class 프로그램을 끝내려면 x 혹은 X 나 ctrl + z 단축키를 누르세요.");
		
		try {
			// 위 입력 스트림 통로(BufferedInputStream)를 통해 1 바이트씩 읽어 들이는데 
			// 입력 스트림 통로에 읽어들일 데이터가 존재할때만 반복해서 계속해서 읽어들이자.
			while((data = myIn.read()) != -1) {
				//  소문자 x 나 대문자 X를 누르면 더 이상 읽어 들이지 않고 while 반복문 빠져나가기 
				if(data == 'x' || data == 'X') {
					break; // while 반복문 빠져나가기 
				}
				// 입력 받은 문자의 갯수 증가 
				cnt++;
				// 입력받아 1바이트씩 읽어들인 데이터를 모니터 화면에 출력시 
				// 출력 스트림 통로를 이용해 1바이트 단위로 내보내어 출력 
				myOut.write(data);
				
			}
			
		}catch(IOException e) {
			// 입출력 관련 예외가 발생하면 예외 메시지 출력 
			e.printStackTrace();
		}
		System.out.println("입력받은 총 문자 갯수 -> " + cnt);
		
	}
}
