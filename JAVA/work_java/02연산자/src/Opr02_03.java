
public class Opr02_03 {

	public static void main(String[] args) {
		/*
		 문제. 다음 중 형변환을 생략할 수 있는 것은 모두 고르시오 ? (모두 고르시오 )
				byte b = 10;
				char ch = 'A';
				int i = 100;
				long l = 1000L;
		 
		 
		 	   1. b = (byte)i; //int(4byte) -> byte(1byte) 이므로 반드시 형변환 필
		 	   
		 	   2. ch = (char)b; // byte(1byte) -> char (2byte) 이지만 범위가 달라서 
		 	   									10을 문자로 변경해서 저장하기위해 형변환이 필요하다.
		 	   									
		 	   3. short s = (short)ch; // char, short 는 2byte 이지만 범위가 달라서 형변환 필
		 	   
		 	   4. float f = (float)l; // float(4byte)의 범위가 long(8byte) 보다 커서 생략 가능  
		 	   
		 	   	float	-> 약 -3.40282347E+38(-2의128승) ~ 약  3.40282347E+38(2의128승)
		 	   	long 	-> -9223372036854775808 ~ 9223372036854775808
		 	   
		 	   5. i = (int)ch;  // char(2byte) -> int(4byte) 이므로 생략가능
		 	  	
		 	  	char -> 0 ~ 65535 
		 	  	int 	 ->	-2147483648 ~ 2147483648
		 	   
		 	 
		 		정답(4 , 5)
		 		1.2.3.4.5. 풀이를 각각 적으시오
		 		
		 		1. 변수 b 는 byte 형이고 i 는 int 형 이다.
		 		    byte 형은  크기가 1byte이고 int 형은 크기가 4byte이므로  
		 			byte 형 b 에 int 형  i 의 값을 넣을려면 형변환이 필요하므로 생략할 수 없다.  
		 			
		 		2.  변수 ch 는 char 형이고 b 는 byte 형이다.
		 		 	  char 형은 문자형이고 byte 형은 정수형으로 데이터형이 다르다. 따라서 형 변환이 필요하다.
		 		
		 		3.  변수  s 는 short 형이고 ch 는 char 형이다. 
		 			  short 형은 정수형이고 char 형은 문자형으로 데이터형이 다르다. 형변환 필요.
		 		
		 		4. 
		 		
		 		5. i 는 int 형이고 ch 는 문자형이다.
		 */

	}

}




