import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//채팅 클라이언트 프로그램

public class SimpleClient extends Thread implements ActionListener {

	//재료준비
	JFrame jframe;
	JTextArea jta;
	JTextField jtf, jtf2;
	JDialog jDialog;
	JLabel jLabel;
	
	//클라이언트 전용 소켓 통로 
	Socket s1;
	
	//IO통로 
	DataOutputStream dos;
	DataInputStream dis;
	
	//조건변수
	boolean stop;
	
	//접속할 채팅 서버의 IP주소를 저장할 변수
	String host;
	
	//생성자
	public SimpleClient() {
		launchFrame();
	}
	//메소드
	private void launchFrame() {
		jframe = new JFrame("일대일 채팅실습");
		jta = new JTextArea();
		jtf = new JTextField();
		jframe.setBackground(Color.lightGray);
		jta.setEditable(false);
		jframe.add(jta, BorderLayout.CENTER);
		jframe.add(jtf, BorderLayout.SOUTH);
		
		//JTextField에 액션이벤트가 발생하면 이벤트처리할 리스너객체 등록
		jtf.addActionListener(this);
		
		jframe.setSize(500, 300);
		jframe.setVisible(true);
		jtf.requestFocus();
		
		//JFrame창 위에 접속할 채팅서버의 IP번호를 입력할
		//다이얼로그창 생성
		jDialog = new JDialog(jframe, "서버 IP", true);
		jLabel = new JLabel("접속할 채팅서버의 IP주소를 입력하세요.");
		jtf2 = new JTextField(15);	
		//JDoalog창 영역에  JLabel과  JTextField를 배치
		jDialog.add(jLabel, BorderLayout.NORTH);
		jDialog.add(jtf2, BorderLayout.CENTER);
		
		//JDoalog창 내부에 부착된  JTextField jtf2에 액션 이벤트가 발생하면
		//이벤트를 처리할 리스너 등록
		jtf2.addActionListener(this);
		
		//JDoalog창 기본사이즈로 나오게 설정
		jDialog.pack(); //setSize(?,?)를 설정하지 않아도 된다.
		//JDoalog창 보이게 설정
		jDialog.show();
		
		//service메소드 호출! 
		service(); //클라이언트 전용 소켓 통로 생성 
				   //접속한 서버프로그램으로 부터 전달받는 메세지를 읽어들일 입력스트림 통로 생성
				   //접속한 서버프로그램에게 메세지를 전달할 출력스트림 통로 생성
				   //run메소드가 실행되도록 start메소드를 호출함
		
		//JDoalog창 내부에  부착된 JTextField jtf2에 강제 포커스 주기 
		jtf2.requestFocus();
		
	}//launchFrame()메소드 닫는 기호  
	
	//클라이언트 전용 소켓 통로 생성 
   //접속한 서버프로그램으로 부터 전달받는 메세지를 읽어들일 입력스트림 통로 생성
   //접속한 서버프로그램에게 메세지를 전달할 출력스트림 통로 생성
   //run메소드가 실행되도록 start메소드를 호출함
	public void service() {
		
		try {
			//클라이언트 프로그램에서 서버프로그램으로 통신을 하기 위해
			//클라이언트 전용 소켓 통로 생성!
			//방법 : 서버의 IP주소를 host변수값으로 전달하고,
			//      서버의 port번호 5432를 전달 하여 생성한다.
			s1 = new Socket(host, 8889);
			
			//입력스트림 통로
			dis = new DataInputStream( s1.getInputStream() );
			//출력스트림 통로
			dos = new DataOutputStream( s1.getOutputStream() );
			
			//프레임창 내부에 부착된 텍스트에어리어 영역에 "접속완료" 메세지 보내어 출력하기
			jta.append("접속완료.. \n");
			
			//stop변수가 true가되면  서버에서 전송된 데이터를 읽는 작업을 하는 스레드 동작 시키기 
			this.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//1.JTextFiled 2개 이벤트 처리 
	//첫번? JTextField -> JFrame창에 부착된 필드영역
	//두번째 JTextField -> JDialog다이얼로그창에 부착된 필드영역
	//2.입력한 메세지를 스트림을 통해 서버프로그램으로 보내기 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//JFrame창에 부착된 JTextField라면?
		if( jtf   == e.getSource() ) {
			
			try {
				//JFrame창에 부착된 JTextFiled영역에 입력한 텍스트를 얻어
				String msg = jtf.getText();
				
				//JTextFiled영역에 입력한 텍스트를 없애서 다른 텍스트를 입력할수 있도록 하기
				jtf.setText(" ");
				
				//msg변수에 저장된 JTextFiled에 입력한 텍스트를
				//JTextArea영역에 보내어 추가로 출력
				jta.append(msg + "\n");
				
				if(msg.equals("exit")) {//입력한 텍스트가 exit라면?
					//JTextArea영역에 "Bye"출력
					jta.append("Bye");
					//stop변수의 값을 false->true로 변경
					stop = true;
					//출력 스트림 닫기
					dos.close();
					//클라이언트 전용 소켓 닫기
					s1.close();
					//현재 실행되고 있는 채팅 클라이언트 프로그램 강제 정상 종료
					System.exit(0);
				}else {//exit가 아닌 다른 텍스트를 입력 했다면?
					
					//서버프로그램 프레임창에 입력한 텍스트 메세지를 스트림을 통해 보낸다
					dos.writeUTF("클라이언트 : " + msg);
					
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		//JDialog다이얼로그창에 부착된 JTextField라면?
		}else if( jtf2 == e.getSource() ){
			
		//접속할 채팅서버의 IP주소를 입력받아 저장 
			//다이얼로그창에 부착된 JTextField에 입력한 문자열을 얻어
			//양쪽 공백을 제거후 반환받아 host변수에 저장
			host = jtf2.getText().trim();
			
			if(host == "") {//접속할 채팅 서버의  IP주소를 입력하지 않았다면
				//직접 서버의 IP주소를 host변수에 저장
				host = "127.0.0.1"; //또는 localhost 또는 실제 IP주소 192.168.0.56
				//참고
				//"localhost" 와 "127.0.0.1" 주소는 자기 서버의 IP주소를 나타낸다.
			}
			//다이얼로그 창 닫기
			jDialog.dispose();
		
		}//else if
		
	}//actionPerfored메소드 닫는 기호 
	
	
	//서버프로그램에서 보내온 메세지를 읽어 들여 JTextArea영역에 출력 하는 작업
	@Override
	public void run() {
		System.out.println("Thread started....");
		
		try {
			//stop변수에 저장되는 값이 true일때 반복해서 채팅 메세지를 읽어들임
			while(!stop) {
				//서버프로그램이 보낸 메세지를 읽어서 
				String message = dis.readUTF();
				//클라이언트 채팅프로그램의 JTextArea영역에 보여준다
				jta.append(message);
				
			}
			//stop변수에 저장되는 값이 false일때
			//입력 스트림 통로 자원해제
			dis.close();
			//클라이언트 전용 소켓통로 자원해제
			s1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//run 메소드 끝
	
	public static void main(String[] args) {
		new SimpleClient(); //프레임창, 스레드 , 이벤트 리스너 
	}

}





