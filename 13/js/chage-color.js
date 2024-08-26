// 위 작성해 놓은 id가 heading인 <h1>한쌍을 선택해서 heading 변수메모리에 저장
var heading = document.querySelector("#heading");

// h1 한쌍에 사용자가 클릭하는 행동 하나를 등록
heading.onclick = function () {
  // h1 한쌍에 내부에 적힌 글자 색상을 빨간색으로 설정
  heading.style.color = "red";
};