
// 예제 : 2차원 배열을 선언한 후, 배열의 요소에 값을 대입하고, 요소의 내용을 얻어 출력하는 프로그램 

public class Arr03 {

	public static void main(String[] args) {
		
		//2차원 배열 생성 문법
		// 자료형[][] 배열명 = new 자료형[행갯수][열갯수];	
		
		
		// 정수값을 젖아시킬 5행 3열 15칸의 2차원 배열 생성 
		//int [][]score = new int[생성할 행의 개수] [생성할 열의 개수];
		int [][]score = new int[5][3];
		
		//2차원 배열 초기화 문법
		// 배열명[행위치][행에대한 열의 위치] = 저장할 값;
		
		// 행과 열의 위치를 index로 지정하여 값 대입
		score[ 0 ][ 0 ] = 10; 	 score[0][1] = 90; 	 score[0][2] = 70;
		score[ 1  ][ 0 ] = 60;  	 score[1][1]  = 80;	 score[1][2] = 65;
		score[ 2 ][ 0 ] = 55; 	 score[2][1] = 60; 	 score[2][2] = 85; 
		score[ 3 ][ 0 ] = 90; 	 score[3][1] = 75; 	 score[3][2] = 95;
		score[ 4 ][ 0 ] = 60; 	 score[4][1] = 30; 	 score[4][2] = 80;
		
		
		// 다중 for 반복문을 이용해 2차원 배열에 각 원소에 저장된 데이터 꺼내어 출 
		for(int row = 0; row < 5; row++) { // 행의 갯수 만큼 반복 
			for(int col = 0; col <  3; col++) { // 행에 대한 열의 갯수 만큼 반복 
					
//					score[행위치][행위치의 열위치 값 ];
				System.out.print(" " + score[row][col]);
				
			}
			System.out.println();
		}
		
		
		
		
	}

}
