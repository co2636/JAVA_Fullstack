
public class Tree {
	
	String name;
	String color;
	int age;
	
	void move() {
		System.out.print(name + " 흔들리다.  ");
	}
	void dowon() {
		System.out.println(color + "가 떨어지다.");
	}

	public static void main(String[] args) {
		
		Tree tree1 = new Tree();
		
		tree1.name = "사과나무";
		tree1.color = "빨간색 사과";
		tree1.age = 100;
		tree1.move();
		tree1.dowon();
		
		
		Tree tree2 = new Tree();
		
		tree2.name = "배나무";
		tree2.color = "파란색 배";
		tree2.age = 99;
		tree2.move();
		tree2.dowon();
	}

}
