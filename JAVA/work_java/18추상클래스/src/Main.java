
// 	게시판 기능 구현에 관한 미완성 설계도(추상클래스) 선언 
// 	추상 클래스명 : Board 
abstract class Board{
//		글 제목, 글 내용, 글 작성자, 글작성날짜를 저장할 변수선언 
	protected String title, content,  name, date;
	
//		생성자를 작성하요.
//		제목, 내용, 작성자, 작성날짜를 모두 초기화 
	public Board(String title, String content, String name, String date) {
		this.title = title;
		this.content = content;
		this.name = name;
		this.date = date;
	}
	
//		게시글 정보(제목, 작성자, 작성일, 내용) 을  각각 출력 후  줄바꿈할 일반 printInfo 메소드 선언 
	public void printInfo() {
		System.out.println("제목 : " + title);
		System.out.println("글 내용 : " + content);
		System.out.println("작성자 : " + name);
		System.out.println("작성일 : "  + date);
		
	}
//		새로운 게시글을 추가하는 이름을 가진 추상메소드 addPost 선언 
	public abstract void addPost();
	
//		게시글을 수정하는 이름을 가진 추상메소드 updatePost 선언 
//		단 ! 수정한 문자열 정보 하나를 매개변수로 받아서 수정할 수있게 선언 
	public abstract void updatePost(String newContent);
	
//		게시글을 삭제하는 이름을 가진 추상메소드 deletePost 선언 
	public abstract void deletePost();
	
}

// ------------------------------------------------------------------		
	
//  	일반 게시판 자식클래스  GeneralBoard  선언 
//  	추상 클래스 Board 를 상속받아 선언 
class GeneralBoard extends Board{
//		생성자 작성
//		새글 제목, 글 내용, 작성자명, 작성 날짜를 매개변수로 받아서 위 Board 추상클래스의 멤버에 초기화 시킬 생성자 작성 
		public GeneralBoard(String title, String content, String name, String date) {
			
			super(title,content,name,date);
			
		}
//		새 게시글을 추가하는 기능의 Board 추상메소드의 addPost 메소드 오버라이딩 
//		재구현 내용 - "일반 게시판에 글을 추가했습니다" <-- 출력 
		@Override
		public void addPost() {
			System.out.println("일반 게시판에 글을 추가했습니다.");
		}
		
//		게시글을 수정하는 메소드 오버라이딩 
//		재구현 내용 - "일반 게시판의 글을 수정했습니다." <-- 출력
		@Override
		public void updatePost(String newContent) {
			System.out.println("일반 게시판의 글을 수정했습니다.");
			super.content = newContent;
		}
		
//		게시글을 삭제하는 메소드 오버라이딩 
//		재구현 내용 - "일반 게시판의 글을 삭제했습니다." <-- 출력 
		@Override
		public void deletePost() {
			System.out.println("일반 게시판의 글을 삭제했습니다.");
		}
}

 
// ------------------------------------------------------------------		
	
//  	공지 게시판 자식클래스  NoticeBoard  선언 
//  	추상 클래스 Board 를 상속받아 선언 
class NoticeBoard extends Board{
//		생성자 작성
//		새글 제목, 글 내용, 작성자명, 작성 날짜를 매개변수로 받아서 위 Board 추상클래스의 멤버에 초기화 시킬 생성자 작성 
		public NoticeBoard(String title, String content, String name, String date) {
			super(title,content,name,date);
		}
	
//		새 게시글을 추가하는 기능의 Board 추상메소드의 addPost 메소드 오버라이딩 
//		재구현 내용 - "공지사항 게시판에 글을 추가했습니다" <-- 출력 
	
		@Override
		public void addPost() {
			System.out.println("공지사항 게시판에 글을 추가했습니다");
			
		}

//		게시글을 수정하는 메소드 오버라이딩 
//		재구현 내용 - "공지사항 게시판의 글을 수정했습니다." <-- 출력
		@Override
		public void updatePost(String newContent) {
			System.out.println("공지사항 게시판의 글을 수정했습니다.");
			super.content = newContent;
			
		}

//		게시글을 삭제하는 메소드 오버라이딩 
//		재구현 내용 - "공지사항 게시판의 글을 삭제했습니다." <-- 출력 
		@Override
		public void deletePost() {
			System.out.println("공지사항 게시판의 글을 삭제했습니다.");
			
		}
	
}



public class Main {

	public static void main(String[] args) {
		// 일반 게시판 기능이 있는 클래스의 객체 생성시 
		// 생성자로 "일반 글" 글 제목 전달,
		//				" 이것은 일반 게시판의 글 내용입니다." 글 내용 전달
		//				"홍길동"  작성자명 
		// 				"2024-09-09" 글 작성 날짜를 전달해 인스턴스변수 초기화 
		
		Board board = new GeneralBoard("일반 글", "이것은 일반 게시판의 글 내용입니다.",  "홍길동",  "2024-09-09");
		
		// printInfo() 메소드 호출하여 결과를 보시오
		board.printInfo();
		/*
			 	제목 : 일반 글
				글 내용 : 이것은 일반 게시판의 글 내용입니다.
				작성자 : 홍길동
				작성일 : 2024-09-09
		 */
		
		//addPost() 메소드 호출하여 결과를 보시오
		board.addPost();   /*  일반 게시판에 글을 추가했습니다. */
		
		// 게시글 내용을 수정하기 위해 updatePost 메소드 호출!
		// 수정할 내용은 "이것은 수정된 일반 게시판의 글내용입니다" <-- 수정 
		board.updatePost("이것은 수정된 일반 게시판의 글내용입니다"); /* 일반 게시판의 글을 수정했습니다. */
		
		// printInfo() 메소드를 다시 호출하여 결과를 보세요.
		board.printInfo();
		/*
		 		제목 : 일반 글
				글 내용 : 이것은 수정된 일반 게시판의 글내용입니다
				작성자 : 홍길동
				작성일 : 2024-09-09
		 */
		
		// 게시글을 삭제하기 위해 deletePost 메소드 호출!
		board.deletePost(); /* 일반 게시판의 글을 삭제했습니다. */
		
		System.out.println();
		
		board = new NoticeBoard("공지 글","이것은 공지사항 게시판의 글 내용입니다.", "홍길동", "2024-09-09");
		
		board.printInfo();
		board.addPost();
		board.updatePost("이것은 수정된 공지사항 게시판의 글내용입니다");
		board.printInfo();
		board.deletePost();
		
	}

}
