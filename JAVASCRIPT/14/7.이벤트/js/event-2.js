

// <button>Click</button> 요소를 선택해서 button 상수에 저장
const button = document.querySelector("button");

//선택해온 <button>Click</button>요소에 click이벤트 등록
// 그리고 click이벤트가 발생하면 자동으로 호출될 콜백함수 연결
button.onclick = function(){
  //body요소의 배경을 초록색으로 설정
  document.body.style.backgroundColor = "green";
  
};

//문법
//선택한요소.on등록할 이벤트종류명 = 이벤트핸들러 함수호출;