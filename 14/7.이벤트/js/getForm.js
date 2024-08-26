
/*
  document.querySelector("#major")는 
  id 속성의 값이 major인 <select>요소를 선택하여 selectMenu 상수에 저장
  이 <select>요소는 사용자가 학과 선택할 수 있는 드롭다운 메뉴이다.

  */

const selectMenu = document.querySelector("#major");

//이벤트처리함수(이벤트핸들러함수)
//사용자가 선택한 option항목의 텍스트를 가져와 이를 알림창으로 표시하는 기능의 함수
function displaySelect(){

  // selectMenu.option속성을 호출하면 모든 <option>요소를 
  // 포함하는 배열과 유사한 객체를 반환해줌

  //selectMenu.selectedIndex속성을 호출하면 현재 선택된 
  // <option>요소의 index위치번호를 반환

  //  selectMenu.options[ selectMenu.selectedIndex ].innerText;
  //  선택된 <option>요소의 텍스트노드값을 가져온다.

  let selectedText = selectMenu.options[ selectMenu.selectedIndex ].innerText;

  //alert함수로 선택된 option요소의 텍스트를 알림창에 보여주자
  alert(`${selectedText}를 선택했습니다.`);
}

//select option들 중에서 하나의 option을 
// 선택하여 변경한 동작을 <select>요소에 등록
// 사용자가 만약 option중에서 하나의 option을 선택하면 
// 이벤트핸들러함수인 displaySelect함수를 호출시킨다.
selectMenu.onchange = displaySelect;




