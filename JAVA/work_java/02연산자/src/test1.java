
public class test1 {

	public static void main(String[] args) {
		
		// 문제 1.
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		/*
		 	z = (++x) + (y--);
		 	z = ++10 + 20--;
		 	z = 11 + 20
		 	z = 31
		 	
		 */
		System.out.println(z); // 31
		
//		------------------------------------------------------------
		
		// 문제 2.
		int score = 85;
		String result = (!(score > 90))? "가" : "나";
		/*
		 	 !(score > 90) -> ! 논리부정 연산자가 있으니까  score 가 90보다 크지 않으면 이라는 뜻이다.
		 	score 값이 90보다 크지 않다가 참이면 "가" 를 반환하고 거짓이면 "나"를 반환한다.
		 	현재 score 값이 85이므로 90보다 크지 않기때문에 "가"를 반환 한다.
		 */
		
		System.out.println(result); // "가"
		
//		------------------------------------------------------------------
		
		//문제 3.
		int pencils = 534;
		int students = 30;
		
		//학생 한명이 가지는 연필 수
		int pencilsPerStudent = ( pencils / students);
		System.out.println(pencilsPerStudent); //17
		
		// 남은 연필 수
		int pencilsLeft = (pencils % students  );
		System.out.println(pencilsLeft); //24
		
//		------------------------------------------------------------
		// 문제 4.
		int value = 356;
		
		System.out.println(value / 100 * 100); //300
		
		
//		------------------------------------------------------------
		//문제 5.
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		/*
		 1. 	(lengthTop + lengthBotton) * height / 2.0
		 2. 	(lengthTop + lengthBotton) * height  * 1.0 / 2
		 3.	(double)	(lengthTop + lengthBotton) * height / 2
		 
		 */
		double area = ( double )(lengthTop + lengthBottom )*height/2;
		
		System.out.println(area); // 52.5
		
//		------------------------------------------------------------
		//문제 6.
		int x1 = 10;
		int y1 = 5;
		
		System.out.println((x1 > 7) && (y1 <=5)); //true
//											 10 > 7  &&  5 <= 5
//											    true   &&     true				-> true
		
		System.out.println((x1 % 3 == 2) || (y1 % 2 != 1)); // false
//											 10 % 3 == 2  || 	5 % 2 != 1
//													1    == 2  ||		1	   != 1
//														false   ||		false				-> false
		
		
		
//		------------------------------------------------------------
		//문제 7.
		double x2 = 5.0;
		double y2 = 0.0;
		double z2 = 5 % y2;
		
		if(	 Double.isNaN(z2) == true)	{
			
			System.out.println("0.0으로 나눌 수 없습니다. ");
			
		}else {
			
			double result2= z2 + 10;
			
			System.out.println("결과 : " + result2);
		
			}
		
		// 0.0으로 나눌 수 없습니다.
		
		
		
//		------------------------------------------------------------
				
		
	}

}
