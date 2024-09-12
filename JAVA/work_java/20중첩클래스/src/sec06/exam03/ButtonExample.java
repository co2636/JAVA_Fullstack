package sec06.exam03;

// 버튼 설계도(클래스) 만들기 
class Button{
	
	// 정적 중첩 인터페이스 만들기
	// - 외부클래스에서 접근이 불가능하도록 
	// public 이면서 Button 객체 생성없이 사용할 수 있는 static 중첩 인터페이스로 만듦
	public static interface ClickListener{
		// 클릭하는 기능의 의미를 지니고 있는 추상 메소드
		void onClick();
	}
	// 바깥 Button 클래스의 멤버(인스턴스변수) 만들기 
		//  인터페이스자료형	참조변수선언;
	private ClickListener clickListener;
										//  new OkListener(); 자식객체의 주소를 대입할 수 있을 것이다.
										//  new CancelListenner(); 
	
	// 바깥 Button 클래스의 멤버(인스턴스메소드)만들기
	// 기능 : 위 만들어 놓은 clickListener 인스턴스변수값 변경 
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	// Button 이 클릭되었을때 실행할 메소드로 click() 인스턴스메소드 만들기
	// 실행 내용 - 위 private ClickListener 인터페이스 자료형  clickListener 인스턴스 변수에 저장된 자식객체의 onClick() 추상메소드를 호출 한다.
	public void click() {
		this.clickListener.onClick();
	}
	
}


public class ButtonExample {

	public static void main(String[] args) {
		// 버튼 역할을 하는 클래스(설계도)의 객체 생성 
		// -> Button 클래스를 이용해 객체 생성 
		Button btnOk = new Button();
		
		// 클릭이벤트를 처리할 OkListener 만들기
		// 만드는 방법 : Button 클래스 내부에 중첩 ClickListener 인터페이스 내부의 추상메소드를 강제로 오버라이딩 해서 내부클래스 형태로 만든다.
		class OkListener implements Button.ClickListener{
			// 버튼을 클릭했을때 호출되는 메소드로 클릭이벤트를 했을때  이벤트 처리코드를 작성하는 곳 
			@Override
			public void onClick() {
				// 재구현 
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		} // --------> OkListener 로컬 중첩클래스 닫기 
		
		// 버튼을 클릭할때마다 이벤트 처리 메소드 onClick 을 오버라이딩 해 놓은 OkListener 중첩 로컬 클래스의 객체 생성 후 
		// Button 객체의 private  ClickListener clickListener; 변수에 저장해 놓아야 클릭이벤트가 발생했을때 이벤트 처리할 수 있다.
		btnOk.setClickListener(new OkListener());

		// Ok 버튼을 클릭하는 행위(이벤트) 하기 
		btnOk.click();
		
		
		
		Button btnCancel = new Button();
		
		class CancelListener implements Button.ClickListener{

			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다.");
			}
			
		}
		
		btnCancel.setClickListener(new CancelListener());

		btnCancel.click();
		

	}

}
