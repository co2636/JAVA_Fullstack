
// 예제 : 2차원 배열에 초기값을 지정한 후 행 단위와 열 단위로 합을 구하는 프로그랩을 작성하시오. 

public class Arr04 {

	public static void main(String[] args) {

		// 초깃값을 저장하는 동시에 배열을 생성하는 문법
		/*
		 	자료형[][] 배열명 = {
		 										{값1, 값4, 값7},  // 0행 
		 										{값2, 값5, 값8},  // 1행 
	        	 								{값3, 값6, 값9}   // 2행 
		 								  
		 								  };
		 */
		
		//학생들의 과목별 점수를 초깃값으로 갖는 2차원 배열 생성 
		int [][] score = {
									// 국어, 영어, 수학 
										{85, 60, 70},   // 0행  1번학생 
										{90, 95, 80},   // 1행  2번 학생 
										{75, 80, 100}, // 2행  3번학생
										{80, 70 , 95},  // 3행  4번학생
										{100, 65, 80}	// 4행  5번학
		
								 };
		
		
		
		int r, c;
		
		// 각 과목별 총점을 저장할 1차원 배열 생성
		int[] subject = new int[3];
		
		System.out.println(" 각 과목별 총점 구하기 " );
		
		for(c=0; c < 3; c++) {
			for(r=0; r<5; r++) {
				subject[c] += score[r][c];		
			}
			System.out.print(" " +subject[c]);
		}
		
		System.out.println();
		
		//각 학생별 총점을 저장할 1차원 배열 생성
		int[] student = new int[5];
		
		System.out.println(" \n 각 학생별 총점 구하기 " );
		
		for(r = 0; r < 5; r++) {
			for( c=0; c<3; c++) {

				student[r] += score[r][c];		
				
			}
			System.out.println(r+1 + "번 학생 -> " + student[r]);
		}
		

	}

}
