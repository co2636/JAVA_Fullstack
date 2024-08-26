/*
  주제 : 세개의 숫자 중 가장 큰수를 구하는 예
*/

//세 개의 숫자 를 각각 상수에 저장
const num1 = 10;
const num2 = 20;
const num3 = 15;

//삼항 조건연산자식을 사용하여 가장 큰수 찾기
// const max = 조건식      ? 조건식참_실행코드 : 조건식거짓_실행코드;

//20
const max =  (num1 > num2) ? ( num1 > num3 ? num1 : num3 ) : ( num2 > num3 ? num2 : num3 );
//             10 >  20    ? (  10  > 15   ? 10   : 15   ) : ( 20   > 15   ? 20   : 15   );
//                                        true             :       false  
/*
  순서1. (num1 > num2)
         (10   > 20 )
              false

  순서2. ( num2 > num3 ? num2 : num3 )
         ( 20   > 15   ? 20   : 15   )
              true       true

  순서3.  num2변수 20을  max상수에 저장시킴 

*/
console.log(max);
