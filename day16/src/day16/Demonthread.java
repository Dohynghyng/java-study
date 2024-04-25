package day16;



public class Demonthread implements Runnable{
	static boolean autoSave = false;
	
	public static void main(String[] args) {	
//		데몬 쓰레드
//		일반 쓰레드의 작업을 돕는 보조 역할 수행 (일반 쓰레드 종료시 자동 종료)
//		가비지 컬렉터, 자동 저장, 화면 자동갱신 등에 사용
//		무한 루프와 조건문을 이용해 실행 후 대기하다 특정 조건이 만족되면 작업을 수행하고 대기하도록 작성한다.
		Thread t = new Thread(new Demonthread());
		t.setDaemon(true);  // 데몬 스레드 설정을 안하면 main 스레드가 끝나도 종료가 안됨
		t.start();
		
		for(int i=1; i<=15; i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			System.out.println(i);
			
			if (i==5) {
				autoSave = true;
				System.out.println("Auto-Save 활성화(3초)");
			}
		}  
		
	}

	public void autoSave() {
		System.out.println("자동저장 되었습니다.");
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(3*1000);
			} catch(InterruptedException e) {}
			
			if(autoSave) autoSave();
		}
	}
	

}
