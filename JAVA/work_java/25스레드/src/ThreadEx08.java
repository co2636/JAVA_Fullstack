
public class ThreadEx08 {

	// 메인 스레드를 기준으로 해서 사용자 정의 스레드 그룹 직접 만들기 
	public static void main(String[] args) {
		// 설명 : 기본적으로 메인스레드 자체가 하나의 main 스레드 그룹에 형성되어서 자동으로 main 스레드 그룹이라는 곳에 포함되어 있기 때문에
		//			  현재 실행되고 있는 main 스레드가 속해 있는 main 스레드 그룹에 대한 사용자 정의 스레드 그룹 객체 메모리의 주소 얻기 
		ThreadGroup g_main = Thread.currentThread().getThreadGroup();
		
		// 수동으로 사용자 정의 스레드 그룹 생성
												// 스레드 그룹 생성시 이름을 지정하여 만들수 있다.
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");
		
		// grp1 스레드 그룹에 subGrp1 스레드 그룹을 만들어서 포함시키자
//		ThreadGroup subGrp1 = new ThreadGroup(부모스레드그룹객체주소, "생성하는 스레드 그룹명");
		ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");
		
		// 어떤 특정 스레드를 grp1 스레드 그룹에 가입시켜야 한다.
		// 가입 시키기 전에 grp1 스레드 그룹에 가입된 스레드 객체들의 우선작업순위를 3으로 설정하자
		grp1.setMaxPriority(3);
		// 우선순위란?
		// 특정 스레드 그룹안에 포함되어 있는 스레드들이 더 많은 작업시간을 가지도록 한다.
		// 보충 설명) 현재 grp1 스레드 그룹안에 가입시킨 모든 스레드들의 우선순위값을 3으로 일괄적으로 지정한다.
		
		// grp1 참조변수가 사용하고 있는 grp1 스레드 그룹에 가입시킬 보조작업스레드 객체 생성후 가입시키기 
		Thread t1 = new Thread(grp1, "t1");
	//  Thread t1 = new Thread(가입할 스레드 그룹 객체 주소, 생성하는 보조작업스레드명);
		
		// subGrp1 	스레드 그룹에 포함 시킬 보조작업스레드 객체 생성 
		Thread t2 = new Thread(subGrp1, "t2");
		
		// grp2  스레드 그룹에 포함시킬 보조작업스레드 객체 생성 
		Thread t3 = new Thread(grp2, "t3");
		
		// 보조작업 스레드 t1, t2, t3 일시작 시키자 
		t1.start();
		t2.start();
		t3.start();
		
		// 현재 작업을 실행하고 있는(run 메소드의 코드가 실행되고 있는) main 스레드가 속해 있는 그룹에 대한 스레드그룹 이름 얻기
		System.out.println(">> List of ThreadGroup : " + g_main.getName());
		
		// 현재 생성된 스레드 그룹의 갯수 출력
		System.out.println(">> Activity ThreadGroup : " + g_main.activeGroupCount());
		
		// 스레드 그룹에 관한 모든 정보를 자세히 출력해보자
		// 참고. 이 스레드 그룹에 대한 정보를 표준 출력형식으로 받아 출력한다.
		// 이 메소드는 디버깅 테스트의 경우에만 사용한다.
		g_main.list();
		/*
		 	// main 스레드 그룹의 최대 작업 우선순위값 10 
		 	java.lang.ThreadGroup[name=main,maxpri=10]  
		 		
		 		// main 스레드의 기본 우선순위 정보 5
			    Thread[#1,main,5,main]
			    
			    // Group1 스레드그룹 내부에 가입시킨 스레드들은  최대 우선순위 값 3 
			    java.lang.ThreadGroup[name=Group1,maxpri=3]

			    	// Group1 부모 스레드 그룹의 하위 스레드 그룹 SubGroup1 도 최대 우선순위값 3을 상속받아 사용 
			     	java.lang.ThreadGroup[name=SubGroup1,maxpri=3]
			        
			    // Group2 스레드 그룹은 최대 우선순위값을 지정하지 않았으므로 부모 main 스레드 그룹의 최대우선순위값을 상속 받아 사용함 
			    java.lang.ThreadGroup[name=Group2,maxpri=10]

		 */
		
		
		
		
		
	}

}
