
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

// 서버 채팅 프로그램 
// 		서버소켓 + 클라이언트 통신을 위한 소켓통로 
public class ChatServer {
	
	ServerSocket server; // 서버 전용 소켓 통로객체 생성후 저장할 변수 
	
	final static int port = 6000; // 포트 번호 설정 
	
	// 클라이언트가 요청이 들어오면 통신할 소켓 통로 객체 생성수 저장할 변수
	Socket child;
	
	// 채팅 스레드들 간의 정보를 공유할 HashMap 배열을 생성할 변수
	HashMap<String, ObjectOutputStream> hm;  // key  아이디 ,  value  출력스트림 
	
	// 서버 전용 소켓 객체 생성 , 클라이언트 요청이 들어오면 통신할 소켓 통로 객체 생성 
	// 초기화할 생성자
	public ChatServer() {
		// 서버 전용 소켓 객체 생성시 포트번호 설정 
		try {
			server = new ServerSocket(port);
		} catch (IOException e) { // 서버 소켓 생성에 실패하면 
			e.printStackTrace(); // 예외 메세지를 출력하고
			System.exit(0); // 서버 채팅 프로그램 ChatServer.class 강제 종료 
		}
		
		System.out.println("**** 채팅 서버 ****");
		System.out.println("서버 채팅 프로그램은 클라이언트 소켓통로의 접속 요청을 기다리고 있음");
		
		// +++ 스레드 간의 정보를 공유할 HashMap 객체 생성 +++++++
		hm = new HashMap<String, ObjectOutputStream>();
		
		// 클라이언트 채팅 프로그램이 서버채팅 프로그램으로 항상 접속을 할 수 있도록 무한루프 돌림
		while(true) {
			try {
				// 클라이언트 채팅 프로그램의 접속을 기다리다가 만약 요청이 들어오면 요청을 받아들임
				// 그리고 accept 메소드는 클라이언트와 데이터를  주고 받을 요청한 클라이언트 전용 소켓통로(new Socket()) 객체를 반환 해줌 
			 	child = server.accept();
			 	
			 	// +++ 접속을 유지 하면서 데이터를 송수신하기 위해서 스레드 객체 생성 +++
			 	// Runnable 인터페이스를 구현한 일반 클래스의 객체 생성 
			 	ChatServerThread childThread = new ChatServerThread(child, hm);
			 	
			 	Thread t = new Thread(childThread); // 스레드로 만듦 
			 	t.start();
				
			} catch (IOException e) {
				e.printStackTrace(); // 예외 메세지 출력하고 
				System.exit(0); // 서버 채팅 프로그램 강제 종료 
			}
			
		}
		
	} // 생성자 

	
	// 메인 스레드 
	public static void main(String[] args) {
		new ChatServer(); // 서버 채팅프로그램 객체 생성 
		
		
	}

}

class ChatServerThread implements Runnable{

	Socket child; // 클라이언트와 통신하기 위한 소켓 

	ObjectInputStream ois; // 클라이언트로 부터 데이터를 수신받기 위한 스트림 
	ObjectOutputStream oos; // 클라이언트에게 데이터를 송신하기 위한 스트림 

	String user_id; // 서버 채팅 프로그램에 접속한 클라이언트의 아이디를 저장할 변수 
	
	// 스레드 간의 정보를 공유할 HashMap
	HashMap<String, ObjectOutputStream> hm;
	
	// 1. 생성자 : 입출력 스트림을 얻음, 아이디와 출력스트림을 해쉬맵에 등록 
	//	-> ChatServerThread 생성자로 접속 요청한 클라이언트의 소켓 객체와 해쉬맵이 매개변수로 전달된다.
	public ChatServerThread(Socket s, HashMap hm) {
		
		child = s; // 클라이언트와 통신할 수 있는 소켓 객체를 저장 
		
		this.hm = hm; 
		
		try {
			// 접속한 클라이언트의 아이피 주소를 바로 위  요청한 클라이언트 채팅 프로그램과 연결되는 클라이언트 전용소켓으로 부터 얻는다.
			System.out.println(child.getInetAddress() + " 로 부터 연결 요청 받음 ");
			
			// 클라이언트로 부터 데이터를 수신받기 위한  클라이언트 PC의 채팅프로그램과 연결된 입력스트림 통로 얻기
			ois = new ObjectInputStream(child.getInputStream());
			
			// 클라이언트 PC의 채팅프로그램에게 데이터를 송신하기 위한 출력스트림 통로 얻기 
			oos = new ObjectOutputStream(child.getOutputStream());
			
			// +++++++ 접속한 클라이언트의 아이디를 얻어와 아이디와 출력 스트림 통로를 해쉬맵에 등록 ++++++++
			user_id = (String)ois.readObject();
			
			// 이미 서버채팅프로그램에 접속되어 있는 모든 클라이언트 채팅프로그램들에게  XXX아이디가 접속되었다는 메세지 전송 
			broadcast(user_id + "님이 접속하셨습니다.");
			
			// 여러 스레드가 공유하는 해쉬맵을 동기화 
			synchronized (hm) {
				// 해쉬맵에 사용자의 아이디를 key 로 출력스트림 객체를 value 로 저장
				// 모든 클라이언트에 의해 공유되어 메세지를 브로드 캐스팅을 위해 출력스트림을 해쉬맵에 저장
				hm.put(user_id, oos);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
// 2. run 메소드 오버라이딩
	// 역할 : 클라이언트 채팅프로그램으로 부터 수신받은 데이터를 다시 모든 클라이언트에게 송신함 
	@Override
	public void run() {
		// 클라이언트 채팅 프로그램으로 부터 수신받은 데이터를 저장할 문자열 변수
		String reciveData;
		
		try {
			while(true) {
				// +++ 클라이언트가 보낸 메세지를 수신 받음 +++
				
				// 입력스트림을 통해 클라이언트가 보낸 메세지를 읽어옴 
				reciveData = (String)ois.readObject();
				
				// 클라이언트로부터 종료메세지가 들어오면 반복문을 벗어나서 finally 구문으로 가서 코드 실행함 
				if(reciveData.equals("/quit")) {
					break;
				
				// 귓속말을 위해서 특정 클라이언트에게 메세지를 보냈다면 sendMsg 메소드를 호출한다.
				}else if(reciveData.indexOf("/to") > -1) {
					sendMsg(reciveData);
				
				// 특정 클라이언트가 /quit 그리고 /to 이외 다른 채팅 메세지를 입력하면 모든 클라이언트 채팅프로그램들에게 브로드 캐스팅한다. 
				}else {
					broadcast(user_id + " : " + reciveData);
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("클라이언트 강제 종료 ");
		}finally {
			
		}
		
		
	}
	
	
	
}

