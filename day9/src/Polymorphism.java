
class TV{
	boolean power;
	int channel;
	
	void power() {power = !power;};
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}

class SmartTV extends TV{
	boolean caption;
	String text;
	
	void caption() {caption = !caption;}
}

class LEDTV extends TV{
	boolean led_mod;
	void led() {led_mod = !led_mod;}
}



// 매개변수 다형성의 장점 다형적 매개변수 타입
class Product{
	int price;
	int bonusPoint;
}

class PTV extends Product {}
class Computer extends Product {}
class Audio extends Product {}

class Buyer{
	int money = 1000;
	int bonusPoint = 0;
	
	// 조상 클래스를 매개변수로 받아서 사용 가능함.
	void buy(Product p) { money -= p.price;	}
}

// 추상 클래스 (꼭 필요하지만 자손마다 다르게 구현될 경우)
abstract class Player{
	// 추상 메서드 > {}이 없음
	abstract void play(int pos);
	abstract void stop(); 
}

// 추상 클래스를 상속받아 메서드 완성 후 사용
class AudioPlayer extends Player{
	void play(int pos) {}
	void stop() {}
}


//  
public class Polymorphism {
	public static void main(String[] args) {
		SmartTV s = new SmartTV();
		TV t = new SmartTV(); // 조상 타입의 참조 변수는 자손을 가리킬 수 있음.
		// SmartTV s = new TV(); // 에러 자손 타입은 조상을 가리킬 수 없음.
	
		// 참조변수의 형변환은 조상 자손 관계의 참조 변수는 형변환 가능
		SmartTV s_tv = new SmartTV();
		TV tv = (TV) s_tv;    //생략 가능
		s_tv = (SmartTV) tv;  //생략 불가능
		LEDTV led = new LEDTV();
		// LEDTV led = (LEDTV) s_tv; 에러. 상속 관계가 아닌 클래스 형변환 불가
		
		
		// instanceof 연산자 > 형변환 가능여부 확인에사용, 가능하면 true
		System.out.println((tv instanceof SmartTV));
		System.out.println(s_tv instanceof TV);
		System.out.println(led instanceof TV);

		/*
		 장점
		 1. 다형적 매개변수
		 2. 하나의 배열로 여러 종류의 객체 다루기
		 */
		// 매개변수 다형성의 장점 여러 종류의 객체를 배열로 다룸
		Product[] p = new Product[3];
		p[0] = new PTV();
		p[1] = new Computer();
		p[2] = new Audio();
		
		// Player p = new Player(); 에러. 추상클래스는 인스턴스 생성 불가
		Player pl = new AudioPlayer();
		
	}

}
