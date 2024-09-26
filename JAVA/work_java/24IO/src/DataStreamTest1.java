
// 주제 : DataOutputStream 출력스트림 통로를 통해 각 변수에 저장된 데이터들을 파일에 쓰기(기록)

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataStreamTest1 {
	public static void main(String[] args) {
		
		char c = 'a';
		byte b = 10;
		short s = 20;
		int i = 100;
		float f = 3.14f;
		double d = 1.5;
		String str = "hello";
		
		try {
			// data.txt 파일에 위 변수에 저장된 값들을 쓰기위한 메소드를 제공하는 DataOutputStream 출력스트림 객체 생성 
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
			
			// void writeChar(int i) 매개변수 i 로 전달받는 문자의 하위 16비트(2바이트)를 DataOutputStream 출력스트림 통로를 통해서 파일에 출력!
			dos.writeChar(c);
			
			// void writeByte(int i) 매개변수 i 로 전달받는 정수데이터 8비트(1바이트)를 DataOutputStream 출력스트림 통로를 통해서 파일에 출력!
			dos.writeByte(b);
		
			// void writeShort(int i) 매개변수 i 로 전달받는 정수데이터 16비트(2바이트)를 DataOutputStream 출력스트림 통로를 통해서 파일에 출력!
			dos.writeShort(s);
			
			// void writeFloat(int i) 매개변수 i 로 전달받는 100를 기본자료형인 int 의 32비트 (4바이트) 크기의 데이터를  DataOutputStream 출력스트림 통로를 통해서 파일에 출력!
			dos.writeInt(i);
			
			// void writeFloat(float f) 매개변수 f 로 전달받는 3.14를 기본자료형인 float 의 4바이트 크기의 데이터를  한 방에 파일에 출력!
			dos.writeFloat(f);
			
			// void writeDouble(double d) 매개변수 d 로 전달받는 1.5D를 기본자료형인 double 의 8바이트 크기에 저장된 실수값을  한 방에 파일에 출력!
			dos.writeDouble(d);			
			
			// void writeUTF(String str) 매개변수 str 로 전달받은  문자열 객체 메모리 내부에 저장된 "hello" 라는 문자열을 UTF-8 방식으로 문자를 인코딩 한 후'
			// 출력스트림통로를 통해 파일에 출력!
			dos.writeUTF(str);
			
			dos.close(); // 자원 해제 
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
