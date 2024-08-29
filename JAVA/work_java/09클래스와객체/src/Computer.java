/*
 	예제 : 객체 지향 프로그래밍의 3단계 기법을 적용하여  Computer  객체를 모델링한 예제 
 	
 	객체 지향 프로그래밍 기법 3단
 
 	1 단계.  현실에 존재하는 객체 모델링( 데이터 + 기능 추출하는 작업 )
 
 			데이터
 						제조사명 , CPU , SSD,  그래픽카드,  운영체제 
 						
 						브랜드 :  컴퓨터의 제조사 이름 
 						모델 : 컴퓨터의 모델명 
 						RAM : 컴퓨터의 메모리 용량 (단위 : GB)
 						저장 용량 : 하드 드라이브 또는 SSD의 저장 용량 (단위 :GB)
 						전원상태 : 컴퓨터의 전원 상태값 (켜짐 /꺼짐)
 						
 			
 			기능
 					전원 on/off,  모니터에 표시하는 기능 ,  검색하는 기능 ,  
 					
 					
 			
 	
 
 */

// 2단계. 컴퓨터 객체들의 공통점을 찾아 class 설계 
public class Computer {

	// 변수 (속성 , 필드) : 1단계에서 추출한 데이터들을 저장시킬 변수 
	String brand;    						 // 	브랜드 :  컴퓨터의 제조사 이름 
	String model;  						//		모델 : 컴퓨터의 모델명 
	int ram;									//		RAM : 컴퓨터의 메모리 용량 (단위 : GB)
	int storage;								//		저장 용량 : 하드 드라이브 또는 SSD의 저장 용량 (단위 :GB)
	boolean powerStatus;			//		전원상태 : 컴퓨터의 전원 상태값 (켜짐 /꺼짐)
													//		true : 켜짐 , false : 꺼짐 

	// 메소드 (함수) : 1단계에서 추출한 기능(동작)을 메소드로 표현 
	
	//		컴퓨터의 전원을 켜는 기능(동작) 
	void powerOn() {
		powerStatus = true;  // 전원 상태를 켜짐으로 설정 하기위해 true 저장
		System.out.println(model + "의 전원이 켜졌습니다.");  // 전원이 켜졌다는 메세지를 출력 
	}
	
	//		컴퓨터의 전원을 끄는 기능 
	void powerOff() {
		powerStatus = false; // 전원 상태를 꺼짐으로 설정하기 위해 false 저장 
		System.out.println(model + "의 전원이 꺼졌습니다.");  // 전원이 꺼졌다는 메세지를 출력 
	}
	
	//		메모리(RAM) 용량을  업그레이드 하는 기능 
	void upgradeRam(int additionalRAM) {
		// 기존 RAM 용량에 추가 RAM 용량을 더함 
		ram += additionalRAM;
		
		// 업그레이드된 RAM 용량을 화면에 출력 
		System.out.println(model  + "의 RAM이 " + additionalRAM + "GB 업그레이드 되었습니다.");
		System.out.println("현재 RAM : " + ram + "GB");
	}
	
	
	//		저장 용량 업그레이드 하는 기능 
	void upgradeStorage(int additionalStorage) {
		// 기존 저장 용량에 추가 저장 용량을 더함 
		storage += additionalStorage;
		
		// 업그레이드된 storage 용량을 화면에 출력 
		System.out.println(model  + "의 저장 용량이 " + additionalStorage + "GB 업그레이드 되었습니다.");
		System.out.println("현재 저장용량 : " + storage + "GB");
	}
	
	
	//	현재 컴퓨터의 정보를 출력하는 기능 
	void displayInfo() {
		System.out.println( "브랜드 명 :  " + brand + 
										  ", 모델 명 : " + model +
										  ", RAM 용량 : " + ram + "GB, " +
										  " 저장 용량 : " + storage + "GB, " +
										  " 전원 상태 : " + (powerStatus ? "켜짐" : "꺼짐") 
										);
	}
	
	public static void main(String[] args) {
		// 3단계 : 클래스 설계도 하나를 이용해 객체 메모리 생성 후 사용 
		
		// Computer 클래스 설계도를 이용해 객체 메모리 생성 
		// 단 ! 참조변수 명은 myComputer 로 만든다.
		Computer myComputer = new Computer();
		
		// 바로 위에서 생성한 myComputer 객체 메모리의 각 변수값 초기화
		// 1. brand 변수값을  "LG" 로 초기화
		myComputer.brand = "LG";
		
		// 2. model 변수값을 "Gram 15" 로 초기화 
		myComputer.model = "Gram 15";
		
		// 3. ram 변수값을 8GB로 초기화
		myComputer.ram = 8;
		
		//4. storage 변수값 저장용량을 256GB로 초기화 
		myComputer.storage = 256;
		
		//5. powerStatus 변수값을 false 로 초기화 해서 전원상태 꺼짐으로 설정함 
		myComputer.powerStatus = false;

		// 기능(동작) 수행 
		// 1. 전원 켜기 : myComputer 객체의 powerOn 메소드를 호출하여 전원을 켬 
		myComputer.powerOn(); //Gram 15의 전원이 켜졌습니다.
		
		// 2. 현재 컴퓨터의 상태를 화면에 출력 
		// : displayInfo()메소드를 호출하여 각 객체변수의 값을 엮은 문자열 출력 
		myComputer.displayInfo();
		 
		// 3. RAM을 8GB 업그레이드 기능을 수행하기 위해 
		// : upgradeRam(8); 메소드 호출하여 8GB 더 업그레이드 된 16GB 로 만듦 
		myComputer.upgradeRam(8);
		
		// 4. 저장용량을 512GB 업그레이드(추가) 기능을 수행하기 위해 
		// : upgradeStorage(512);  메소드 호출하여 512GB 더 업그레이드 된 768GB로 만듦 
		myComputer.upgradeStorage(512);

		// 5. 현재 컴퓨터의 상태를 화면에 출력 
		// : displayInfo()메소드를 호출하여 각 객체변수의 값을 엮은 문자열 출력 
		myComputer.displayInfo();
		
		// 6. 컴퓨터 전원을 끄기 위해 
		// : powerOff() 메소드를 호출한다.
		myComputer.powerOff();
		
		// 7. 현재 컴퓨터의 상태를 화면에 출력 
		// : displayInfo()메소드를 호출하여 각 객체변수의 값을 엮은 문자열 출력 
		myComputer.displayInfo();
	}

}
