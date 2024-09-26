//다음 싱글 스레드에서 처리하는   많은 작업들을  각각의 작업스레드들을 만드는 방식으로 바꾸시오.
//힌트! :  각각 작업스레드 클래스 따로 만들기 

// 작업 1을 위한 보조작업스레드 클래스 만들기
class Thread1 extends Thread{
	@Override
	public void run() {
		//작업1
		for(int i=0;  i<10;  i++) {
			System.out.print(i);
		}
	}
}
//작업 2을 위한 보조작업스레드 클래스 만들기
class Thread2 extends Thread{
	@Override
	public void run() {
		//작업2
		for(char i='A';  i<='Z'; i++){
			System.out.print(i);
		}
	}
}
//작업 3을 위한 보조작업스레드 클래스 만들기
class Thread3 extends Thread{
	@Override
	public void run() {
		//작업3
		for(char i='a';  i<='z'; i++){
			System.out.print(i);
		}
	}
}
//작업 4을 위한 보조작업스레드 클래스 만들기
class Thread4 extends Thread{
	@Override
	public void run() {
		//작업4
		char arr[] = {'ㄱ', 'ㄴ','ㄷ','ㄹ','ㅁ','ㅂ','ㅅ','ㅈ'};
		for(char i : arr){
			System.out.print(i);
		}
	}
}
public class MultiThreadTest {
	
	//싱글(메인)스레드
	public static void main(String[] args) {

		Thread1 thread1 = new Thread1();    
		Thread2 thread2=new Thread2();
		Thread3 thread3=new Thread3();
		Thread thread4 = new Thread(new Thread4());
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
//실행결과 
//0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzㄱㄴㄷㄹㅁㅂㅅㅈ

//과제 내용~~
/*
실행결과를 보면.. 메인(싱글)스레드에서 4가지의 작업을 하고 있다.
각각의 작업스레드 클래스를 만들어서   멀티스레딩  방식으로 바꾸세요~~~  
*/










