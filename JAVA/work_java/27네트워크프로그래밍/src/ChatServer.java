/*
	채팅 서버 구현하기
	
	- 채팅 서버를 구성하는 클래스는 ChatServer와 ChatServerThread 두개 입니다
	
	-    ChatServer 클래스에서는 반복문을 돌면서 클라이언트의 접속이 있을 때 이를 수락(accept)하는 
		 동작은 메인스레드가 담당하고 접속을 유지하면서 데이터 송수신을 하기 위해서는 
		 따로 스레드 객체(ChatServerThread)를 생성해야 하므로 채팅 서버를 구현하기 위해서 두개의 클래스가 필요합니다.
		 
	클래스 								역할
	ChatServer					    서버 소캣 생성. 접속을 계속 유지하면서 데이터 송수신 하기 위해서 스레드(ChatServerThread)객체 생성.
				 							스레드 객체 생성시 전달인자로 컬렉션 객체인 HashMap을 전달해 줌으로써 멀티 캐스팅 기능하도록 합니다.
		 					
	ChatServerThread			접속을 계속 유지하면서 데이터 송수신 하기 위한 클래스
		 									ChatServer에 있는 컬렉션 객체인 HashMap을 이용하여 멀티캐스팅할 수 있다.

 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

// 서버 채팅 프로그램 
// 		서버소켓 + 클라이언트 통신을 위한 소켓통로 
public class ChatServer {
	
	ServerSocket server; // 서버 전용소켓 통로 객체 생성후 저장할 변수 
	
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

/*
		ChatServerThread 클래스 구현하기
		
		이 클래스의 메소드 						역할
		ChatserverThread 생성자 			1. 클라이언트로부터 데이터를 송수신을 위해서 입출력 스트림을 얻음
										2. 아이디를 얻어와 아이디와 출력 스트림을 해쉬맵에 등록
										
		run 메소드 
		- 클라이언트로부터 수신받은 데이터를	1. 클라이언트로부터 보내진 메세지를 수신받아
		  클라이언트에게 송신하는 메소드 		2. 모든 클라이언트에게 브로드 캐스팅 한다.(broadcast)
		  								3. /to 가 입력되면 귓속말로 처리한다(sendMsg)
		  								4. /quit 가 입력되면  종료 메세지로 처리한다.
		  								
		broadcast 메소드					클라이언트로 부터 받은 메세지를 서버에 연결된 모든 클라이이언트에게 보냄
		
		sendMsg	메소드 					귓속말을 위해서 특정 클라이언트에게 메세지를 보냄 
		  								
		  								
		
		참고. 서버가 다른 클라이언트에게 메세지를 송수신하기 위해서  컬렉션(해쉬 맵)을 가지고 있으면서
				새로운 클라이언트가 접속해 오면 해쉬맵에서 사용자 아이디와 출력 스트림을 저장해 두고
				클라이언트가 접속을 해제하면 해쉬맵에서 해당클라이언트를 삭제 합니다.
*/

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
		}finally { // 클라이언트로 부터 /quit 종료 메세지를 받으면
			
			// 여러 스레드들이 공유하는 해쉬맵을 동기화함
			// 동기화 블록 이용 
			synchronized (hm) {
				// 종료 메세지를 보낸 클라이언트의 정보를 해쉬맵에서 삭제한 후
				hm.remove(user_id);

			}
			// 나머지 클라이언트 채팅 프로그램들 에게 종료메세지를 보낸 클라이언트가 접속 종료를 알림
			broadcast(user_id + " 님이 나가셨습니다.");
			// 서버 채팅 프로그램에도 접속 종료를 알리기 위해 출력
			System.out.println(user_id + "님이 나가셨습니다.");
			
			try {
				// 서버채팅 프로그램에 접속하여 종료메세지를 보낸 클라이언트 채팅 프로그램 전용 소켓 통로를 자원 해제
				//	( 서버 채팅 프로그램과 클라이언트 채팅프로그램 접속해제 )
				if(child != null) { 	child.close();			}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // finally
		
	} //run 
	
	// 3. 서버 채팅프로그램에 접속한 클라이언트 채팅 프로그램이 보낸 받은 메세지를 모든 클라이언트 채팅 프로그램에게
	// 메아리처럼 다시 보내는 (브로드캐스팅) 메소드 
	public void broadcast(String message) {
		
		// HashMap : 여러 클라이언트가 서버채팅프로그램에 접속할때마다 각 클라이언트의 아이디와 출력 스트림(ObjectOutputStream)을 
		//						저장하는 공유 자원 이다.
		
		// 스레드 동기화 필요성 : 다수의 클라이언트가 동시에 서버에 접속하고 메세지를 주고 받는 상황에서 
		//										여러 스레드가 이 HashMap을 동시에 수정하려고 한다면, 데이터 충돌이나 오류가 발생할 수 있다.
		// 동기화 블럭 :  synchronized(hm) 는 한번에 하나의 스레드만 이 블록{ } 내부에 진입하여, 동시에 여러 스레드가 HashMap의 
		//						  데이터를 수정하지 못하도록 막아줍니다. 이로서 데이터의 일관성을 보장한다.
		
		//		여러 스레드가 공유하는 해쉬맵을 동기화
				synchronized (hm) {
					
					try {
						
						// HashMap 에 저장된 모든 출력스트림통로를 얻어와서 클라이언트가 보낸 수신받은 메세지를 다시 송신한다.
						for( ObjectOutputStream oos : hm.values()) {
							
							// 수신받은 메세지를 다시 모든 클라이언트 채팅 프로그램에게 송신한다.
							oos.writeObject(message);
							oos.flush();
							
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				} // synchronized 동기화 블럭 
		
	}// broadcast 
	
	// 4. 귓속말을 하기 위해서 특정 클라이언트에게 메세지를 보냈다면 다음과 같은 형식으로 보냄 
		// to 아이디 대화내용
		//		beagin  end 
		public void sendMsg(String message) {
			
			// 귓속말로 넘어온 메세지 중 아이디 부분에 해당되는 문자열을 찾기 위해서 
			int beagin = message.indexOf("")+1; // 처음 공백 문자 다음 부터 
			int end = message.indexOf("",beagin); // 두번째 공백 문자 사이의 문자가 아이디임 
			
			if(end != -1) {
				// 보내진 메세지 중 아이디 부분만 잘라서 얻어냄 
				String id = message.substring(beagin, end); // 아이디 잘라서 얻기 
				// 아이디 이후 작성한 대화내용 얻어냄 
				String msg = message.substring(end+1); // 대화내용 
				
				// 해쉬맵에서 아이디로 출려스트림 통로를 얻어냄
				ObjectOutputStream oos = hm.get(id);
				
				try {
					if(oos != null) {
						oos.writeObject(id + "님이 다음과 같은 귓속말을 보내셨습니다.  :  " + msg);
						oos.flush(); 
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} // 바깥 if
			
		}//sendMsg 메소드 
	
} // ChatServerThread 일반 클래스 

