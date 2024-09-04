
// 주제 : 상속을 사용하지 않고 Point2D, Point3D 클래스 설계시 각 클래스 내부의 코드 중복 예 

// 2 차원 평면의 좌표값을 저장하는 Point2D 클래스 설계 
//	Point2D 클래스는 변수로  x, y 를 갖고, 이 좌표값은 2차원 좌표계에서의 점을 나타낸다.
class Point2D{
	private int x;
	private int y;
	
	// x 변수 -> getX() 메소드, setX(int x) 메소드 
	
	// y 변수 -> getY() 메소드, setY(int y) 메소드 
	// get 으로 시작하는 메소드들을 getter 라고 부르고
	// set 으로 시작하는 메소드들을 setter 라고 부른다.
	
	// setter, getter 메소드들을 자동으로 만드는 단축키 
	//  alt + shift + s  r
	// Source ->  Generate Getters and Setters 
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}

// 3차원 공간상의 좌표값 한점을 나타내는 x, y, z 를 저장하는 Point3D 클래스 설계 
class Point3D{
	
	private int x; // Point2D 클래스의 x 변수 선언 코드와 중복 
	private int y; // Point2D 클래스의 y 변수 선언 코드와 중복
	private int z;
	
	// setter, getter 메소드들 만들기 
	public int getX() { // Point2D 클래스에 작성했던 코드와 중복 
		return x;
	}
	public void setX(int x) { // Point2D 클래스에 작성했던 코드와 중복
		this.x = x;
	}
	public int getY() { // Point2D 클래스에 작성했던 코드와 중복
		return y;
	}
	public void setY(int y) { // Point2D 클래스에 작성했던 코드와 중복
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
}

public class Ex2 {

	public static void main(String[] args) {
		
	}

}
