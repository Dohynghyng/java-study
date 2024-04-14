package day7;

//모든 클래스는 반드시 생성자를 가져아한다. 생성자를 작성하지 않은 경우 매개변수가 없는 기본 생성자가 자동 사용
class Test_1{
	int value;
	Test_1() {}  // 기본 생성자가 생략됨
}

class Test_2{
	int value;
	Test_2(int x){
		value = x;
	}
}


public class Day7 {
	
	public static void main(String[] args) {
		MyMath mm = new MyMath();
		mm.printGugudan(2);
		/*
		 오버 로딩이란 같은 이름의 메서드에 여러개 정의하는 것
		 void println()
		 void println(boolean x)
		 void println(char x)
		 void println(char[] x)
		 오버로딩이 성립하기 위해서 메서드 이름이 같고 매개변수 개수 타입이 달라야함, 반환 타입은 영향이 없음
		 int add(int x, int y)     {return x+y}
		 int add(int x)            {return x+x}
		 long add(long x, long y)  {return x+y}
		 하지만 변수로 리터럴을 입력하는 경우 주의가 필요함
		 */
		Test_1 test1 = new Test_1();
		// Test_2 test2 = new Test_2(); 생성자에 매개변수가 존재한다면 오류 발생
		Test_2 test2 = new Test_2(3);
		
		
	}

}

class MyMath{
	void printGugudan(int dan)   
	{
		for (int i=1; i<10;i++)
			System.out.printf("%d X %d = %d%n",dan,i,dan*i);
		return;
	}

	/*
	 인스턴스 메서드
	 생성 후 참조변수.메서드이름()으로 호출
	 인스턴스 멤버와 작업함
	 메서드 내에서 인스턴스 변수 사용 가능
	 */
	int a,b;
	int add()
	{
		return a+b;
	}
	
	/*
	 스태틱 메서드
	 생성 후 클래스이름.메서드이름()으로 호출
	 인스턴스 멤버와 관련 없는 작업
	 메서드 내에서 인스턴스 변수 사용 불가능 하지만 클래스 변수는 사용 가능
	 
	 스태틱은 프로그램 실행과 동시에 메모리에 적재된다는 점만 유의하면 됨
	 */
	static int add(int x, int y) // 스태틱 메서드(인스터스 메서드)
	{
		return x+y;
	}






	
	
}