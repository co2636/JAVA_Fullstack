import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//1.main스레드 
//  역할1.프레임창 만들기
//  역할2.서버소켓통로를 만들어 클라이언트의 요청을 대기
//2.SimpleServer스레드 
//  역할. 서버프로그램에서 클라이언트프로그램으로 메세지 송수신 역할

//서버 채팅 프로그램
public class SimpleServer extends Thread implements ActionListener{

	//재료 준비
	JFrame jframe;
	JTextArea jta;
	JTextField jtf;
	
	//서버용 소켓통로객체를 생성해서 저장할 변수
	ServerSocket s;
	
	//서버채팅프로그램으로 요청이 들어오면 요청에 관한 클라이언트와 메세지를 주고 받을
	//클라이언트 용 소켓통로 객체를 생성해서 저장할 변수
	Socket s1;
	
	//클라이언트채팅프로그램 측으로 메세지를 보내되...
	//OutputStream통로는 메세지를 1바이트 단위로 보내기 때문에..
	//조금더 편하게 여러바이트를 기본자료형(int, double, float)바이트 크기로 묶어서
	//메세지를 보내줄수 있게 하는 DataOutputStream통로객체를 생성해서 저장할 변수 선언
	DataOutputStream dos;
	
	DataInputStream dis;
	
	//클라이언트프로그램에서 전송된 메세지를 읽어들이기 위한 조건 변수
	boolean stop;  //기본값이 false로 저장되어 있는 상태임 
	
	//생성자
	//2개의 메소드를 호출 해서 동작할수 있도록 설정
	public SimpleServer() {
		try {
			launchFrame();
		    service();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//메소드(함수)
	public void service() throws Exception  {
		                   // 서버소켓통로 생성 하고 클라이언트의 요청 기다리기 
						   // 클라이언트프로그램에서 서버프로그램으로 접속요청을 보내면
						   // 새로운 클라이언트용 소켓통로를 생성하여
						   // 그 소켓통로를 통해 입 출력 스트림통로를 만든다
						   // 그리고 실제로 채팅 메세지를 주고 받을 스레드에게 일을 시킨다
		
		jta.append("서비스를 하기 위해 준비중....\n");
		
		//5432 포트번호를 가진 서버소켓 통로 생성 
		s = new ServerSocket(8889);
		
		jta.setText("클라이언트 접속 대기중 \n");
		
		//ServerSocket객체의 accept()메소드를 이용하여 
		//클라이언트의 요청을 기다린다.
		//ServerSocket통로부터 현재 접속한 사용자(클라이언트)의 정보를 가지고 있는
		//클라이언트 용! Socket통로 객체를 리턴 받는다.
		s1 = s.accept();
		
		//서버프로그램에 접속한 클라이언트 ip주소 정보 JTextArea영역에 보여주기
		jta.append("   클라이언트가 접속하였습니다 : " + s1.getInetAddress() +"\n");
		
		//서버프로그램에 접속한 클라이언트프로그램에 메세지를 보내기 위한 출력스트림 통로 생성
		dos = new DataOutputStream(s1.getOutputStream());   
		
		//접속한 클라이언트프로그램에서 보내온 메세지를 읽어들이기 위한 입력스트림 통로 생성
		dis = new DataInputStream(s1.getInputStream());

		//실제로 채팅 메세지 주고 받는 작업을 하는 스레드 시작!
		this.start();
		
		//접속한 크랄이언트 프로그램의 프레임창에 부착된 JTextArea영역에
		//채팅 서버프로그램에 접속을 알리기 위해  메세지를 보냄
		dos.writeUTF("채팅 서버에 접속하신걸 환영합니다.");
				
	}//service메소드 닫는기호 
	
	
	//메소드(함수)
	public void launchFrame() {
		
		//JFrame클래스의 객체를 생성하여 프레임창 하나 만들기 
		//프레임창 만들때 창제목 설정
		jframe = new JFrame("일대일 채팅실습");
		
		//JTextArea클래스의 객체를 생성
		//이유는 JTextField입력공간에서 입력한 메세지를 보여주기 위한 영역이다.
		jta = new JTextArea();
		
		//JTextField클래스의 객체를 생성
		//이유는 메세지를 입력하는 공간을 만들기 위한 영역이다.
		jtf = new JTextField();
		
		//JFrame창 배경색을 지정
		jframe.setBackground(Color.lightGray);
		
		//JTextArea 영역에 데이터를 입력을 할수 없도록 막기(비활성화)
		jta.setEditable(false);
		
		//JFrame창에  JTextArea와 JTextField 배치
		jframe.add(jta, BorderLayout.CENTER);
		jframe.add(jtf, BorderLayout.SOUTH);
		
		//JTextField필드영역에서 텍스트를 입력하면 Action이벤트가 발생하므로
		//Action이벤트처리할 리스너 객체를 JTextField필드에 등록
		jtf.addActionListener(this);
		
		//JFrame창 사이즈 지정 및 보이게 설정
		jframe.setSize(500, 300);
		jframe.setVisible(true);
		
		//JTextField 입력공간에 강제로 포커스 주기
		jtf.requestFocus();
		
		
	}//launchFrame메소드 닫는 기호 
	
	
	//이벤트처리
	// JTextField에 입력한 메세지 얻어 JTextArea영역에 보여주기
	// 채팅 서버 프로그램에 입력한 메세지를 클라이언트 프로그램에 출력스트림통로로 보내기 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			//JTextFiled에 입력한 텍스트를 얻어 msg변수에 저장
			String msg = jtf.getText(); 
			//얻은 텍스트를 JTextArea영역에 보내어 출력되게 한다
			jta.append(msg + "\n");
			//JTextField영역에 텍스트를 없애기 위해 대신~ 빈공백 문자열을 넣어 준다 
			//덮어 쓰자	
			jtf.setText(" ");
			
			if(msg.equals("exit")) {//JTextField영역에 "exit"문자열을 입력?다면?
				//JTextArea영역에 "bye"문자열을 보내어 출력되게 하고
				jta.append("bye");
				//stop변수에 저장된 false->true로 설정
				stop = true;
				//접속한 클라이언트프로그램이 서버프로그램에 강제종료될수 있도록 하자
				dos.close(); s1.close();
				//현재 실행되고 있는 채팅서버 프로그램 강제 종료
				//정상종료 0 , 비정상종료 1
				System.exit(0);
						
			}else {//다른 문자열을 입력했다면?
				  //채팅서버프로그램 창에 입력한 메세지를 
				  //채팅클라이언트프로그램 창에 내보내어 출력되게 하여야 한다
				  dos.writeUTF("채팅서버 : " + msg);
						  
				  
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		
	}//actionPerformed메소드 닫는 기호 
	
	
	//채팅 메세지 받는 작업
	//-> stop변수에 저장되는 값이 true가 될때까지 클라이언트가 전송한 데이터를 읽어들인다.
	@Override
	public void run() {
		
		try {
			//stop변수에 저장되는 값이 true일때 반복
			while (!stop) {
				//채팅 클라이언트 프로그램에서 보낸 메세지를 읽어 들여서
				//채팅 서버 프로그램 창의 JTextArea영역에 보내어 출력 
				jta.append( dis.readUTF() + "\n" );
			}		
			//stop변수가 false가 되면 
			//접속한 클라이언트로 부터 메세지를 전달받아 읽어 들일 입력 스트림 통로 닫기
			dis.close();
			//클라이언트 전용 소켓 닫기 
			s1.close();
		} catch (EOFException e) {//접속이 끊어 졌을 경우 예외처리
			jta.append("클라이언트로 부터 연결이 끊어 졌습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//메인스레드
	public static void main(String[] args) {
		//프레임창 , 스레드 , 이벤트 리스너 
		new SimpleServer();

	}

}




