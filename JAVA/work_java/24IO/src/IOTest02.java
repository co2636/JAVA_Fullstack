/*
 	주제 : 입력된 전체 문자열의 문자 총 갯수 출력
 	
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOTest02 {

	public static void main(String[] args) {
		// 키보드를 이용해 입력한 전체 데이터 중에서 한번 읽어 들인 한 바이트의 크기의 데이터를 저장할 data 변수 선언 
		int data = 0;
		// 읽어들인 전체 문자열의 문자 총 갯수를 계산해서 저장할 cnt 변수 선언 
		int cnt = 0;
		// 한 바이트씩 읽어올  BufferedInputStream 입력 스트림 통로 얻어 InputStream 부모추상클래스 자료형의 참조변수 myIn 에 저장
		InputStream myIn = System.in;
		// 한 바이트씩 모니터 장치(출력장치)에 한 바이트씩 내보낼 PrintStream 출력 스트림 통로 얻어 OutputStream 부모추상클래스 자료형의 참조변수 myOut에 저장 
		OutputStream myOut = System.out;
		
		System.out.print("문자를 입력하세요 : ");
	
		try {
			// 키보드로 부터 입력받은 전체 데이터 중에서 한 바이트씩 읽어 올 데이터가 존재하면 계속 반복해서 읽어들인 데이터를 data 변수에 저장시키고
			// 모니터 화면에 출력하자. 또한 입력 받은 문자의 갯수를 1 증가해서 cnt 변수에 저장 
			// 읽어 들일 데이터가 존재하지 않으면 while  반복문을 빠져나간다.
			while((data = myIn.read()) != -1) {
				// 소문자 x 나 대문자 X를 입력후 엔터를 누르면 while 반복문 빠져나감 
				if(data == 'x' || data == 'X') {
					break;
				}
				cnt++;
				myOut.write(data);
			}
		}catch(IOException e ) {
			e.printStackTrace();
		}
		System.out.println("입력받은 총 문자 갯수 -> " + cnt);
	}

}
