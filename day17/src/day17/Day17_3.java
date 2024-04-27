package day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MyClass {
	int v = 0;
	MyClass(){
		this(0);
	}
	
	MyClass(int v){
		this.v = v;
	}
	
}

public class Day17_3 {
	public static void main(String[] args) {
//		자주 사용되는 다양한 함수형 인터페이스
//		Supplier > 입력이 없이 반환값만 존재  /  get 메서드 사용
		Supplier<Integer> f1 = () -> (int) (Math.random()*100) +1;
//		Consumer > 입력은 있고 반환은 없음   /  accept 메서드 사용
		Consumer<Integer> f2 = i -> System.out.print(i+", "); 
//		Predicate > 입력을 받고 boolean 반환  /  test 메서드 사용
		Predicate<Integer> f3 = i-> i%2==0;
//		Function > 이력과 출력의 타이 지정  /  apply
		Function<Integer,Integer> f4 = i -> i/10*10;
		
// 		예시
		List<Integer> list = new ArrayList<>();
		makeRandomList(f1,list);
		System.out.println(list);
		printEvenNum(f3,f2,list);
		List<Integer> newList = doSomething(f4,list);
		System.out.println(newList);
		
//		매개변수가 2개인 함수형 인터페이스 Bi는 2개라는 뜻
//		BiConsumer
//		BiPredicate
//		BiFunction

// 		매개변수 타입과 반환타입이 일치
//		UnaryOperation
//		BinaryOperation
		
// 		Predicate의 결합
		Predicate<Integer> p1 = i-> i<100;
		Predicate<Integer> p2 = i-> i<200;
		Predicate<Integer> p3 = i-> i%2 == 0;
		
		Predicate<Integer> notP = p1.negate();   		//  Not
		Predicate<Integer> all = notP.and(p2);   		//  And
		Predicate<Integer> all2 = notP.and(p2.or(p3));  // Or
		
//		등가비교를 위한 Predicate의 작성에는 isEqual()을 사용
		String str1 = "test";
		Predicate<String> ep = Predicate.isEqual(str1);
		System.out.println(ep.test("test"));
		
//		두 객체 비교는
		String str2 = "test";
		boolean res = Predicate.isEqual(str1).test(str2);
		System.out.println(res);
		
//		function의 결합
		Function<String,Integer> f = (s) -> Integer.parseInt(s,16);
		Function<Integer,String> g = (i) -> Integer.toBinaryString(i);
		
		Function<String,String> h = f.andThen(g);     // f(g())
		Function<Integer,Integer> h2 = f.compose(g);  // g(f())
		Function<Integer,Integer> h3 = g.andThen(f);  // g(f())

		System.out.println(h.apply("FF"));
		System.out.println(h2.apply(2));
		
		Function<String, String> ident = x -> x; // 항등함수
		System.out.println(ident.apply("AAA"));
		
//		함수형 인터페이스를 사용하는 컬렉션 프레임웍 메서드
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i=0; i<10; i++)
			list2.add(i);
		
// 		요소 출력
		list2.forEach(i->System.out.print(i+","));
		System.out.println();
		
// 		list에서 2 또는 3의 배수 제거
		list2.removeIf(x->x%2==0 || x%3==0);
		System.out.println(list2);
		
// 		모든 요소에 10을 곱함
		list2.replaceAll(i->i*10);
		System.out.println(list2);
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
// 		map의 모든 요소 출력
		map.forEach((k,v) -> System.out.print("{"+k+","+v+"}"));
		System.out.println();
		
//		메서드 참조 > 람다식을 더욱 간단히
//		static 메서드 참조
		/*
		 * Integer method(String s){
		 * 	return Integer.parseInt(s);
		 * }
		 */
//		위 메서드를 더욱 간단하게 가능
		Function<String, Integer> f5 = (String s) -> Integer.parseInt(s);
//		이를 더욱 간단히   클래스이름::메서드이름
		Function<String, Integer> f6 = Integer::parseInt;
		
//		생성자의 메서드 참조
		Supplier<MyClass> s = () -> new MyClass();
//		더욱 간단하게
		Supplier<MyClass> s2 = MyClass::new;
		
//		매개변수 추가
		Function<Integer, MyClass> s3 = (i) -> new MyClass(i);
//		간단하게
		Function<Integer, MyClass> s4 = MyClass::new;
		
//		배열과 메서드 참조
		Function<Integer, int[]> lf1 = x -> new int[x];  // 람다식
		Function<Integer, int[]> lf2 = int[]::new;  // 메서드 참조

//		컬렉션도 표준화를 시도하였으나 List, Set, Map 특성이 다름
//		스트림 > 다양한 데이터 소스를 표준화된 방법으로 다루기 위함
//		원본은 변경하지 않음, Iterator처럼 일회용, 최종 연산에서 중간 과정을 수행, 병렬 스트림 지원, 
//		기본형 스트림을 지원하여 오토박싱&언박싱의 비효율이 제거됨 + 유용한 메서드 제공 ex) IntStream	
		
//		1. Stream 생성
		String[] strArr = {"dd","aaa","CC","cc","b"};
		Stream<String> stream = Stream.of(strArr);
//		2. 중간 연산(N번까지 가능)
//		Stream<String> filteredStream = stream.filter();      	// 걸러내기
//		Stream<String> distinctedStream = stream.distinct();  	// 중복제거
//		Stream<String> sortedStream = stream.sorted();		  	// 정렬
		Stream<String> limitedStream = stream.limit(5);      	// 자르기
//		3. 최종 연산(1번만 가능) > 스트림의 요소를 소모
		Long total = limitedStream.count();
		
//		난수 스트림
		IntStream intStream = new Random().ints();  //  무한 스트림
		intStream.limit(5).forEach(System.out::println); // 따라서 자르고 출력해야함
		
		IntStream intStream2 = new Random().ints(10);  //  무한 스트림
		intStream2.forEach(System.out::println); // 따라서 자르고 출력해야함
		
		IntStream intStream3 = IntStream.range(1, 5); // 범위 스트림
		intStream3.forEach(System.out::println); // 따라서 자르고 출력해야함
		
//		람다식 스트림
		Stream<Integer> evenStream = Stream.iterate(0,n->n+2); // {0,2,4,6,..}		
		Stream<Double> randStream = Stream.generate(Math::random); // {0,2,4,6,..}
		Stream<Integer> oneStream = Stream.generate(()->1); // {0,2,4,6,..}
		
//		빈 스트림
		Stream emptyStream = Stream.empty(); // count는 0
	}
	
	static <T> List<T> doSomething(Function<T, T> f, List<T> list){
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i));
		}
		return newList;
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for (int i=0; i<10;i++)
			list.add(s.get());
	}
	
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print('[');
		for(T i : list) {
			if(p.test(i))
				c.accept(i);
		}
		System.out.println("]");
	}
}
