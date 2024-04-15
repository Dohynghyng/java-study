package day8;   // 패키지 선언

// import java.lang.*; > 이 코드는 생략 가능 String과 같은 기본 모듈
// 패키지가 겹치는 경우 클래스 앞에 패키지 명을 써야함
import java.util.Date;

class ImportTest{
	Date today = new Date(); // 클래스를 사용할 때 ctrl + shift + o 를 사용하여 import 가능
	
}

class Car2{
	String color;
	String gearType;
	int door;
	
	// 생성자 this()
	
	// 1번 전체 디폴트 초기화
	Car2(){
		this("white","auto",4);
	}
	
	// 2번 부분 디폴트 초기화
	Car2(String color){
		this(color,"auto",4);
	}
	
	// 3번
	Car2(String color, String gearType, int door){
		this.color = color;        // 참조변수 this는 지역변수와 인스턴스 변수를 구분함
		this.gearType = gearType;
		this.door = door;
	}

	// 1번과 2번이 3번 생성자를 호출하는데 같은 클래스의 생성자는 클래스 이름 대신 this()를 사용해 호출
	// 생성자 첫번째 줄에서만 사용해야함
}

// 변수 초기화
class InitTest{
	int a = 3; // 명시적 초기화
	
	// 초기화 블럭
	static int[] arr = new int[10]; // 명시적 초기화
	// 클래스 변수 초기화 블럭
	static { 
		for(int i=0;i<arr.length;i++)
			arr[i] = (int) Math.random()*10 + 1;
	}
	
	// 생성자 초기화
	InitTest(){
		a = 10; 
	}
}

/*
 상속
 class 자식클래스 extends 부모클래스
 자손은 조상의 모든 멤버를 상속 받음(생성자, 초기화블럭 제외)
 */

class Point{   // class Point extends Object > 모든 class는 Object 클래스를 상속 받음 toString()과 같은 메서드를 상속
	int x;
	int y;
}

class Point3D extends Point{
	int z;
}

/*
 포함
 클래스의 멤버로 참조 변수를 선언
 대부분 상속보다는 포함을 쓰는 경우가 많다.
 */

class Circle{
	Point c = new Point();
	int r;
}

/*
 오버라이딩
 상속받은 조상의 메서드를 변경하는 것
 선언부(반환타입, 메서드 이름, 매개변수 목록)가 일치해야함
 접근 제어자(public, protected, private)를 조상 클래스 메서드보다 좁은 범위로 변경 불가  >  내용은 이후에 배움
 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.  >  내용은 이후에 배움
 */

// 오버 로딩은 기존에 없는 새로운 메서드를 정의

class Point2{
	int x;
	int y;
	
	String getLocation() {
		return "x :" + x + ", y :"+y;
	}
}

class Point3D2 extends Point2{
	int z;

	String getLocation() {  // 오버라이딩
		return "x :" + x + ", y :"+y+", z :"+z;
	}
}

// 참조변수 super는 this와 유사하지만 조상 멤버와 자신 멤버를 구분할 때 사용

class Parent2 {int x=10;}
class Child2 extends Parent2{
	// Parent2 의 x를 사용하려면 super.x
	int x=20; // this.x
	
}

// super() 조상의 생성자 호출할 때 사용
// 기본 생성자 작성은 필수
class Point3{
	int x,y;
	
	Point3(int x,int y){
		this.x = x;
		this.y = y;
	}
}

class Point3D3 extends Point3{
	int z;
	
	Point3D3(int x, int y, int z){
		super(x,y);
		this.z = z;
	}
}

/*
 제어자
 접근 제어자 (public, protecte, [default], private
 그 외 제어자 (static, final, abstract)
 static > 멤버 변수, 메서드
 final > 클래스(조상이 될 수 없는 클래스), 메서드(오버라이딩 재정의 불가능), 멤버 변수, 지역변수
 abstract > 선언만 된 메서드(추상 메서드, 미완성 메서드) 앞에, 미완성 메서드를 포함한 클래스(추상 클래스) > 인스턴스 생성 불가 > 상속받아 완전한 클래스 만든 뒤 객체 생성 가능
 */


public class Day8 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car2 c = new Car2();
		
	}

}
