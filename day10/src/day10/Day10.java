package day10;

/*
 인터페이스
 추상 메서드의 집합
 구현된 것이 없는 설계도 (모든 멤버가 public, 추상 메서드만 가지고 있음 IV혹은 생성자가 없음)
 변수는 항상 public static final임 따라서 생략 가능
 메서드는 항상 public abstract임 따라서 생략 가능
 인터페이스의 조상은 인터페이스만 가능 (Object가 최고 조상이 아님)
 다중 상속이 가능(추상 메서드는 충돌해도 문제가 없음)
 다형성 적용 가능
 
 단 JDK 1.8부터 (default), static 메서드 추가
 디폴트 메서드 충돌을 방지하기 위해 조상 클래스의 상속이 우선임
 */

abstract class Unit{
	int x,y;
	abstract void move(int x, int y);
	void stop() { System.out.println("멈춥니다."); }
}

interface Fightable{
	void move(int x,int y);
	void attack(Fightable u);
}

class Fighter extends Unit implements Fightable{
	public void move(int x,int y) { System.out.println("[+x"+ ", "+y+"]로 이동"); }
	public void attack(Fightable f) {System.out.println(f+"로 공격");}
}

// 인터페이스의 장점 변경에 유리
// 아래의 경우 B메서드를 다른 클래스로 변경하는데 어려움이 있음
/*
class A{
	public void methodA(B b) {
		b.methodB();
	}
}

class B{
	public void methodB() {
		System.out.println("methodB()");
	}
}

class InterfaceTest{
	public static void main(String args[]) {
		A a = new A();
		a.methodA(new B());
	}
}
*/

// B 메서드 변경에 유리
class A{
	public void methodA(I i) {
		i.methodB();
	}
}

interface I { void methodB(); }

class B implements I{
	public void methodB() {
		System.out.println("methodB()");
	}
}

// 내부 클래스

class outter_A{
	// ...
	class inner_B{ 
		// B클래스는 A클래스 멤버 접근 가능
		// 코드 복잡성 줄일 수 있음
	}
}

/*
 내부 클래스에는 제어자가 변수와 동일하게 사용가능
 
 */

class Outer{
	class InstanceInner {
		int iv = 100;
		// static int cv = 100; 에러. static 변수를 선언할 수 없음
		final static int CONST = 100; // final static은 상수이므로 허용
		}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 200; // static class만 static 멤버 정의 가능
		}
	
	void myMethod() {
		class LocalInner {
			int iv = 300;
			// static int cv = 300; 에러. static 변수를 선언할 수 엇ㅂ음
			final static int CONST = 300; // final static은 상수이므로 허용
		}
	}
}

/*
 익명 클래스
 이름이 없는 일회용 클래스. 정의와 생성을 동시에
 */



public class Day10 {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		f.move(100,200);
		f.attack(new Fighter());
	}
}
