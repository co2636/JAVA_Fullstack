/* 주제 : 삼항조건연산자식을 이용하여 엘리베리터가 올라가고
        내려가는 동작을 구현해 보자.
        이경우 각 버튼을 누를때의 동작을 별도의 코드 로 나누어 작성할수 있음*/
let currentFloor = 1; // 엘리베이터 상태와 화살표 버튼을 정의
let button = ''; // 'up' 또는 'down'

//--------------------------------------------------------------------------------------------
// 위쪽 화살표 버튼을 눌렀을 때
button = 'up';
//위쪽 화살표 'up'눌렀으므로 direction변수에는 'up'문자열 저장 시킴
let direction = button === 'up' ? 'up' : 'down';
                //위쪽 화살표 를 눌렀다면?  2를 만들어 다시 currentFloor변수에 저장 시킴
currentFloor = direction === 'up' ? currentFloor + 1 : currentFloor - 1;
//엘리베이터가 '올라갑니다'. 현재 층: 2

console.log(`엘리베이터가 ${direction === 'up' ? '올라갑니다' : '내려갑니다'}. 
              현재 층: ${currentFloor}`);

//--------------------------------------------------------------------------------------------              

// 아래쪽 화살표 버튼을 눌렀을 때
button = 'down';
//          아래쪽화살표를 눌렀다면?  누른 down이라는 문자열을 저장
direction = button === 'up' ? 'up' : 'down';
//              아래쪽화살표는  누르면   2층에서 1층으로 만들어  1을 currentFloor변수에 저장
currentFloor = direction === 'up' ? currentFloor + 1 : currentFloor - 1;
console.log(`엘리베이터가 ${direction === 'up' ? '올라갑니다' : '내려갑니다'}. 
             현재 층: ${currentFloor}`);
