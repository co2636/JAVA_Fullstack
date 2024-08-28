package 연습문제;
/*
 문제. 다음은 배열을 선언하거나 초기화 한것이다.
      잘못된 것을 고르고 그 이유를 작성 하시오.
      
      1. int[] arr[];
      2. int[] arr = {1,2,3,}; 
      3. int[] arr = new int[5];
      4. int[] arr = new int[5]{1,2,3,4,5};
      5. int arr[5];
      6. int[] arr[] = new int[3][];
      
 */
public class test5 {

	public static void main(String[] args) {
		
//		잘못된 것:
//
//			1.	4번: int[] arr = new int[5]{1,2,3,4,5};
//			•	이유: 배열을 선언하면서 크기를 지정하고 동시에 값을 초기화할 때, 크기를 명시할 수 없습니다. 배열의 크기를 명시하지 않고 값만으로 초기화해야 합니다.
//			•	올바른 코드: int[] arr = {1,2,3,4,5}; 또는 int[] arr = new int[]{1,2,3,4,5};
		
//			2.	5번: int arr[5];
//			•	이유: Java에서는 C나 C++과 달리 배열을 선언할 때 크기를 대괄호 안에 명시할 수 없습니다. 배열은 반드시 new 키워드를 사용하여 동적으로 할당해야 합니다.
//			•	올바른 코드: int[] arr = new int[5];
//
	
	}

}
