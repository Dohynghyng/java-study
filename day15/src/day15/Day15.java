package day15;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


// 제한된 지네릭스
interface Eatable {}

class Fruit implements Eatable{}

class Apple extends Fruit {}
class Grape extends Fruit {}
class Toy {}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

// 와일드 카드 <?>
class Product{}

class Tv extends Product{}
class Audio extends Product{}

// 열거형
enum Direction {EAST, SOUTH, WEST, NORTH}

// 열거형 심화
enum Direction2 {
	EAST(1,">"), SOUTH(2,"V"), WEST(3,"<"), NORTH(4,"^");
	
	 
	private final int value;
	private final String symbol;
	
	Direction2(int value, String symbol){
		this.value = value;
		this.symbol = symbol;
	}
}


public class Day15 {
	public static void main(String[] args) {
//		제한된 지네릭스
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Toy>   toyBox   = new FruitBox<Toy>();   // 에러
		
//		제안사항 static멤버에 클래스 타입 변수 사용 불가 
//		체 혹은 배열 생성할 때 타입 변수 사용 불가
		class Box2<T>{
			T[] itemArr; // OK T타입의 배열을 위한 참조변수
//			T[] toArray() {new T[itemArr.length];}   // 지네릭 배열 생성 불가
		}
		
//		와일드 카드 <?>
		/*
		 <? extends T> 와일드 카드의 상한 제한 T와 그 자손들만 가능
		 <? super T> 와일드 카드의 하한 제한. T와 그 조상들만 가능
		 <?> 제한 없음.
		 */
		ArrayList<? extends Product> list = new ArrayList<Tv>();
		ArrayList<? extends Product> list2 = new ArrayList<Audio>();
//		ArrayList<Product> list3 = new ArrayList<Tv>();   에러 타입 불일치
		
//		메서드의 매개변수에 와일드카드 사용
//		static Juice makeJuice(FruitBox<? extends Fruit> box)
		
//		지네릭 메서드 (와일드카드도 동일하게 사용 가능)
		class Temp<T>{
			static<T> void sort(List<T> list, Comparator<? super T> c) {
//			여기서 타입변수는 static 내에서만 적용
			}
		}
		
//		지네릭 타입의 형변환
		Box b = null;
		Box<String> bStr = null;
		
//		둘 다 가능하지만 경고 출력 (원시타입은 섞어쓰지 않는 것을 권장)
		b = (Box)bStr;
		bStr = (Box<String>)b;
		
//		지네릭 타인간의 형변환은 안됨
//		Box<String> b = (Box<String>) new Box<Object>();
		
//		와일드 카드가 사용된 지네릭 타입으로는 형변환 가능
//		지네릭 > 와일드카드
		FruitBox<? extends Fruit> abox = new FruitBox<Fruit>();
//		와일드카드 > 지네릭 (형변환 필수)
//		FruitBox<Apple> appleBox3 = abox;  > 에러
		FruitBox<Apple> appleBox3 = (FruitBox<Apple>) abox;
		
//		컴파일러는 지네릭 타입을 제거하고 필요한 곳에 형변환 추가
		
//		enum 정의
//                          0     1      2     3
//		enum Direction {EAST, SOUTH, WEST, NORTH}
		
//		enum 사용
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST"); // 열거형 Enum은 모든 열거형의 조상
		
		System.out.println(d1==d2); // == 비교 가능
//		System.out.println(d1>d3);  // >,< 대소비교 불가능
		System.out.println(d1.compareTo(d3));  // 대소 비교는 compareTo를 사용
		
		switch(d1) {
		case EAST:  // Direction.EAST라고 쓰지 않음
			System.out.println("EAST");
		case SOUTH:  // Direction.EAST라고 쓰지 않음
			System.out.println("SOUTH");
		}
		
		Direction[] dArr = Direction.values();
		
		for (Direction d : dArr){
			System.out.printf("%s=%d%n", d.name(), d.ordinal()); // d.ordianl()은 순서만 제시 실제 값과 다를 수 있음 
		}
		
//		애너테이션 > 주석처럼 프로그래밍 언어에 영향을 미치지 않으며, 유용한 정보 제공
		
		class Parent {
			void parentMethod() {}
		}
		
		class Child extends Parent{
//			@Override
//			void parentmethod() {} 오버라이딩 에러 발생
			@Override
			void parentMethod() {}
		
			@Deprecated // 앞으로 사용하지 않을 것을 권장하는 필드나 메서드
			public void method1() {}
			}
		Child c = new Child();
		c.method1();
		
		@FunctionalInterface // 함수형 인터페이스는 하나의 추상 메서드만 사용가능 체크
		interface Testable{
			void test();
//			void check();
		}

		@SuppressWarnings({"unchecked","deprecation"}) // 경고를 출력을 억제
		ArrayList list3 = new ArrayList();
		list3.add(1);
		
//		메타 애너테이션 > 애너테이션을 만들기 위한 애너테이션
//		@Target      애너테이션 적용대상 지정
//		@Retention   애너테이션 유지 기간 지정
//		@Documented  javadoc으로 작성한 문서에 포함
// 		@Inherited   애너테이션 상속
//		@Repeatable  ㅏ녹해서 붙일 수 있는 애너테이션 정의
		
//		모든 애너테이션의 조상은 interface임
		
// 		프로세스 : 실행 중인 프로그램, 자원과 쓰레드로 구성
//		쓰레드 : 프로세스 내에서 실제 작어을 수행.
//		프로세스 > 공장, 쓰레드 > 일꾼
//		2 프로레스 1쓰레드 < 1프로세스 2쓰레드

//		멀티 쓰레드의 장점
//		효율적 사용, 응답성 향상, 코드가 간결해짐
		
//		멀티 쓰레드의 단점
//		동기화 상태 주의, 교착상태가 발생하지 않도록 주의, 각 쓰레드를 효율적으로 고르게 실행
		
		
	}
		
		
		

}

