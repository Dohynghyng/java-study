package day6;

class Tv{
	String color;
	boolean power;
	int channel;
	
	
	void power() {power = !power;}
	void channelup() { ++channel; }
	void channelDown() { --channel; }
}

class Variables{
	// 클래스 영역 시작  (선언만 가능)
	int iv;           // 인스턴스 변수   (인스턴스가 생성되면)
	static int cv;    // 클래스 변수     (클래스가 메모리에 올라가면)
	
	// 메서드 영역
	void method()
	{
		int lv = 0;  // 지역 변수
	}
	// 메서드 영역 끝
	
	// 클래스 영역 끝
}

class Card{
	// 개별 속성은 인스턴스 변수
	String kind; // 무늬
	int number;  // 숫자
	
	// 공통 속성은 클래스 변수
	static int width = 100; // 너비
	static int height = 250; // 높이
}


public class Day6 {
	static void printArr(int[] numArr) {
		for (int i=0; i<10;i++)
			System.out.printf("%d", numArr[i]);
		System.out.printf("%n");
	}
	
	
	public static void main(String[] args) {
		/*
		 클래스는 객체럴 정의하는 것이고 객체를 생성하는데 사용
		 객체는 실제로 존재하는 사물 또는 개념이고 객체의 용도는 기능과 속성에 따라 다름
		 객체는 속성(변수) + 기능(메서드)로 나눌 수 있다.
		 속성 : 크기, 길이, 높이, 색상, 볼륨, 채널  >  변수로 나타낼 수 있다.
		 기능 : 켜기, 끄기, 볼륨 조절, 채널 변경  >  메서드로 나타낼 수 있다.
		 하나의 소스 파일에 하나의 class를 만드는 것이 일반적
		 */
		Tv t = new Tv();
		t.channel = 7;
		t.channelDown();
		System.out.println("현재 채널은 " + t.channel + " 입니다.");
		
		// 여러개의 객체를 생성할 때
		Tv tv1,tv2,tv3;
		tv1 = new Tv();
		tv2 = new Tv();
		tv3 = new Tv();
		
		// 배열을 통하여 생성할 수 있다.
		Tv[] tvArr = new Tv[3];
		tvArr[0] = new Tv();
		tvArr[1] = new Tv();
		tvArr[2] = new Tv();
		
		// 혹은
		Tv[] tvArr1 = {new Tv(), new Tv(), new Tv()};
		
		// 인스턴스 변수 클래스 변수 사용법
		Card c = new Card();
		c.kind = "HEART";
		c.number = 5;
		// 클래스 변수는 다음과 같이 사용 하지만 인스턴스 변수와 같이 사용도 가능하다.
		Card.width = 200;
		Card.height = 300;
		
		int[] Arr = new int[10];
		
		for (int i=0; i<10;i++)
			Arr[i] = i;

		for (int i=0; i<10;i++)
			System.out.printf("%d", Arr[i]);
		System.out.printf("%n");
		// 이후 같은 코드를 호출할 때 코드 중복 발생
		for (int i=0; i<10;i++)
			System.out.printf("%d", Arr[i]);
		System.out.printf("%n");
		
		// 이런 문제를 해결하기위해 메서드 사용
		printArr(Arr);
	}

}