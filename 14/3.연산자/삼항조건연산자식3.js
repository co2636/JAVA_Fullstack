/* 
    주제 : 세 개의 숫자 중 가장 큰 수를 구하는 예제
*/

// 세 개의 숫자를 각각 상수에 저장
const num1 = 10;
const num2 = 20;
const num3 = 15;

// 삼항 조건연산자식을 사용하여 가장 큰 수 찾기
const max = (num1 > num2) ? (num1 > num3 ? num1 : num3 ) : (num2 > num3 ? num2 : num3);
//             10 >  20   ? (  10 >  15  ?  10  :  15  ) : ( 20  >  15  ?  20  :  15 );  
//                                      true             :             false
/*
  순서1.  (num1 > num2) 
          ( 10  >  20 )
             false

  순서2. (num2 > num3 ? num2 : num3 )
         ( 20  >  15  ?  20  :  15  )
              true      true

  순서3. num2변수 20을 max상수에 저장시킴


*/


// (num1 > num2) 조건식을 판단한다.
// 참이면 num1이 더 크다는 것이므로 이번에는 
// num1과 num3을 비교하여 더 큰 값이 num1이면 max변수에 저장
// num1과 num3을 비교하여 더 큰 값이 num3이면 max변수에 저장 
// 
console.log(max); //20
