
// 주제 : 파일 복제 프로그램을 업그레이드 시키되 BufferedInputStream 입력스트림 통로와 
//				BufferedOutputStream 출력스트림 통로의 내부 버퍼메모리를 사용한 예제 

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;

public class FileCopy01 {
	// 입출력할 데이터를 수용할 만큼의 버퍼메모리 크기 설정 
	final static int BUFFER_SIZE = 256;
	
	// CMD 창에 입력 될 것
	// java FileCopy01 "원본파일명" "복사될파일명"
	// 										0						1					index
	
	public static void main(String[] args) {
		int i = 0; // 원본 파일에서 한 번 읽어 들일때마다 읽어들인 데이터수를 저장할 변수
		int len = 0; // 원본 파일에서 읽어들인 총 데이터의 수를 계산하여 저장할 변수 
		
		// 원본 파일에서 읽어들인 정보를 저장하거나 내보낼 크기의 배열 생성
		byte[] buffer = new byte[BUFFER_SIZE];
		
		// 복사될 파일명을 입력하지 않고 원본파일명 까지만 입력했을 경우
		if(args.length < 2) {
			// 입력 문법을 알려줌 
			System.out.println("java FileCopy01 원본파일명 복사될파일명");
			// FileCopy01.class  자바 실행프로그램을 강제 종료
			System.exit(0);
		}
		
		try {
			// 순서1. 원본파일의 데이터를 1바이트씩 접근해서 읽어들일 입력스트림 통로 생성 
			FileInputStream fis = new FileInputStream(new File(args[0]));
			
			// 순서2. 업그레이드
			// 	 원본 파일의 데이터를 256 바이트씩 읽어들여 BufferedInputStream 내부 기본 버퍼메모리 크기인 512 공간에 저장해 두었다가 
			//   512 바이트 크기의 데이터를 한번에 읽어들이기 위한 BufferedInputStream 입력 스트림 통로로 업그레이드 시키자 
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			//---------------------------------------------------------------------------------------------------------------------
			
			// 복사될 파일에 BufferedInputStream 입력 스트림으로 부터 읽어들인 데이터들을 1바이트 단위로 쓰기(출력) 하기위한 
			//	FileOutputStream 출력스트림 통로를 객체 생성 후  업그레이드 해서  내부 버퍼 메모리 공간 512 바이트에 모아두었다가 
			// 512 바이트씩 출력하기 위한 출력 스트림통로 객체 -> BufferedOutputStream 을 생성한다.
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(args[1])));
			
			// 위 작성해 놓은 byte[] buffer = new byte[256]; 배열을 read 메소드 호출시 매개변수로 전달하면 buffer 배열의 크기만큼 
			// 원본 파일의 전체 데이터 중에서 읽어와 buffer 배열에 저장시킨다. 그리고 읽어들인 256 바이트 크기 만큼의 int 로 형변환해 준다.
			// 만약 int 로 형변환 해서 주는 값이 -1일 경우에는 더이상 읽어들일 데이터가 없음을 알 수 있다.
			while((i = bis.read(buffer)) != -1) {
				// 256 바이트씩 읽어와 512 바이트 크기의 내부버퍼메모리를 가지고 있는 BufferedOutputStream 객체 내부의 버퍼 메모리에 모아두었다가 
				// 복사될 파일의 512 바이트 단위로 쓰기(기록, 출력)
				bos.write(buffer);
				
				// 512 바이트 내부 버퍼메모리가 가득차지 않아도 강제로 복사될 파일에 읽어들인 만큼만 쓰기(기록)
				bos.flush();
				
				len += i; // 256 바이트씩 읽어들인 바이트수를 len 변수에 누적 
				
				System.out.println("process : read[" + i +  ", " + len + "], avail[" + bis.available() + "]");
				
			}
			
			// 스트림 통로 들을 모두 사용하였으면 JVM 메모리의 heap 영역에서 객체 제거 
			bis.close();
			bos.close();
			
			System.out.println(len + "bytes are copied...........");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
