package day16;

import javax.swing.JOptionPane;

class Row extends Thread{
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.printf("-");
			for (int x=0; x<10000000; x++);
		}
	}
}

class Col extends Thread{
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.printf("l");
			for (int x=0; x<10000000; x++);
		}
	}
}

class Thread1 extends Thread{
	public void run() {
		for (int i=0;i<500;i++) {
			System.out.println(getName());  // 조상 Thread의 getNmae() 호출
		}
	}
}

class Thread2 implements Runnable{
	public void run() {
		for (int i=0;i<500;i++) {
			System.out.println(Thread.currentThread().getName()); // 현재 실행중인 Thread 반환
		}
	}
}
	
class Thread3 extends Thread{
	public void run() {
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 "+input+"입니다.");
	}
}

class Thread4 extends Thread{
	public void run() {
		int i = 10;
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for (long x=0; x<2500000000L;x++);
		}
		System.out.println("카운트가 종료되었습니다.");
	}
}

class Account{
	private int balance = 1000;
	public int getBalance() {
		return balance;
	}
	
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {Thread.sleep(1000);} catch(InterruptedException e) {}
			balance -= money;
		}
	}
}

class RunnableEx implements Runnable{
	Account acc = new Account();
	
	public void run() {
		while(acc.getBalance()>0) {
			int money = (int) (Math.random() * 3 +1) * 100;
			acc.withdraw(money);
			System.out.println("balance:"+acc.getBalance());
		}
	}
}


public class Day16 {
	static long startTime = 0;
	
	public static void main(String[] args) {
//		쓰레드 구현과 실행
// 		1.Thread 클래스를 상속
		Thread1 t1 = new Thread1();
		t1.start();
		
//		2. Runnable 인터페이스를 구현
		Runnable r = new Thread2();
		Thread t2 = new Thread(r);
		t2.start();
		startTime = System.currentTimeMillis();

// 		프로그램은 실행 중인 사용자 쓰레드가 하나도 없을 때 종료
//		멀티 쓰레드도 사용자 쓰레드에 포함 ( 메인 메서드가 먼저 끝날 수 있음 )
		try {
			t1.join(); // 쓰레드 종료를 기다림
			t2.join();
		}
		catch(InterruptedException e) {}
		System.out.print("소요시간:"+(System.currentTimeMillis() - startTime)+"%n");
		
//		멀티 쓰레드가 시간이 더 걸리지만 2가지 작업을 동시에 진행 가능

//		쓰레드의 I/O 블락킹(blocking)  > 입출력시 작업 중단
//		싱글 스레드의 경우 하나의 작업이 완료되면 다음 작업 실행
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 "+input+"입니다.");
		
		for(int i =5; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {}
		}

// 		멀티 스레드의 경우 동시에 실행 가능
		Thread3 t3 = new Thread3();
		t3.start();

		for(int i =5; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {}
		}
		
//		쓰레드의 우선순위 (1~10)까지 부여 가능 10 > 최대, 1 > 최소
//		희망 사항일 뿐 스케쥴러에 의해 결
		Row th1 = new Row();
		Col th2 = new Col();
		
		th1.setPriority(1);
		th2.setPriority(10);
		
		System.out.println("Priority of th1(-) : " + th1.getPriority());
		System.out.println("Priority of th2(l) : " + th2.getPriority());
		
		th1.start();
		th2.start();
		try {
			th1.join(); // 쓰레드 종료를 기다림
			th2.join();
		}
		catch(InterruptedException e) {}
		System.out.println("");
//		상대적으로 th2(l)가 일찍 끝나는 것을 알 수 있음

//		쓰레드 그룹 
//		서로 관련된 쓰레드를 그룹으로 묶어서 다룸
//		모든 쓰레드는 반드시 하나의 그룹에 포함 (default는 main 쓰레드 그룹)
		

		Thread th3 = new Row();
		Thread th4 = new Col();
		th3.start();
		th4.start();
		
//		쓰레드 메서드 중 sleep, yield만 static 함수, 자기 자신에게 동작
//		sleep 함수는 예외처리를 해야함 > 함수화로 작성	
		try {
//			th3.sleep(2000);    // > th1 쓰레드가 자는 것이 아닌 메인 쓰레드가 잠
			Thread.sleep(2000); // > 올바른 문장
		} catch(InterruptedException e) {}

		System.out.printf("%n<<main 종료>>%n");

		Thread th5 = new Thread4();
		th5.start();
		String input2 = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 "+input2+"입니다.");
		th5.interrupt();
		System.out.println("isInterrupted():"+th5.isInterrupted()); // ture
		
// 		.interrupted()는 사용 후 false로 바뀜
//		System.out.println("interrupted():"+th5.interrupted());     // false > .interrupted()는 스태틱 메서드임 따라서 현재 스레드 상태 표기
		System.out.println("interrupted():"+Thread.interrupted());     // false
		

//		suspend() <-> resume(), stop() > 쓰레드를 종료
//		현재 deprecated 상태. dead-lock (교착상태)를 일으킬 가능성
	
//		yield() > 쓰레드 순서 양보
//		예스로 stop()상태는 아니고 suspend() 상태라면 yield()로 양보
		
//		쓰레드 동기화
//		한 쓰레드가 진행중인 작업을 다른 쓰레드가 간섭하지 못하게 임계 영역을 설정함
//		임계영역은 락을 얻은 하나의 쓰레드만 출입 가능(객체 1개에 락 1개)
		Runnable r2 = new RunnableEx();

		// synchronized를 걸지 않으면 음수가 나올 수 있음.
		new Thread(r2).start();
		new Thread(r2).start();
	}
}

