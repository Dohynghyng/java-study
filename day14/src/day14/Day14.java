package day14;

import java.util.*;

public class Day14 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// HashSet > 객체가 기존에 같은 객체가 있는지 확인
		// boolean add(Object o)는 저장할 객체의 equals()와 hashCode()를 호출 > 오버라이딩 필요
		
		HashSet set = new HashSet();
		set.add("abc");
		set.add("abc");
		set.add(new Person("David",10));
		set.add(new Person("David",10));
		System.out.println(set);
		// 중복 제거가 안 된 이유는 equals()와 hashCode()를 오버라이딩 하지 않았음
		// 상단 메뉴 Source에 hashCode() and equals()가 묶여있음 > 자주 쓰임
		
		// TreeSet > 이진트리로 구현 탐색과 정렬에 유리
		// 중복을 허용하지 않기 때문에 equals()와 hashCode() 오버라이딩
		TreeSet set2 = new TreeSet(); // 자동 정렬, 범위 검색에 유리
		for (int i=0; set2.size()<6; i++) {
			int num = (int)(Math.random()*45) +1;
			set2.add(num);
		}
		System.out.println(set2);
		
		//Set set3 = new TreeSet(); > 에러. 정렬 기준이 없음
		TreeSet set3 = new TreeSet(new TestComp());
		set3.add(new Test());
		set3.add(new Test());
		set3.add(new Test());
		System.out.println(set3);
		

		TreeSet set4 = new TreeSet();
		int[] score = {80,95,50,35,45,65,10,100};
		
		for (int i=0;i<score.length;i++)
			set4.add(new Integer(score[i]));
		
		System.out.println("50보다 작은 값 :" + set4.headSet(50)); // 50미포함
		System.out.println("50보다 큰 값 :" + set4.tailSet(50));  // 50포함
		System.out.println("40과 80 사이의 값 :" + set4.subSet(40,80));  // 80포함
		
		
		// HashMap(비동기화), Hashtable(동기화)
		// Map 인터페이스를 구현. 데이터의 키와 값의 쌍으로 저장 (키는 중복이 안됨)
		// HasjMap은 해싱 기버으로 데이터를 저장 > 검색이 빠름
		HashMap map = new HashMap();
		map.put("a", "A");
		map.put("a", "B"); // > A값이 B로 덮힌다.
		map.get("a");
		
		HashMap score2 = new HashMap();
		score2.put("김자바", new Integer(90));
		score2.put("김자바", new Integer(100));
		score2.put("이자바", new Integer(100));
		score2.put("강자바", new Integer(80));
		score2.put("인자바", new Integer(90));
		
		Set set5 = score2.entrySet();
		Iterator it = set5.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println("이름 : " + e.getKey() + " 점수 : " + e.getValue());
		}
		
		/*
		 Objects > Object를 위한 static 메서드를 제공
		 Arrays > Array를 위한 static 메서드를 제공
		 Collections > Collection를 위한 static 메서드를 제공
		 */
		/*
		 Collections 메서드
		 fill(), copy(), sort(), binarySearch()
		 synchronizedXXX() > 컬렉션 동기화를 위한 메서드
		 unmodifiableXXX() > 변경불가 컬렉션으로 변경
		 singletonXXX() > 객체 1개만 저장
		 checkedXXX() > 한 종류의 객체만 저장
		 */
		
		List list = new ArrayList();
		
		System.out.println(list);
		
		Collections.addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		Collections.rotate(list,2);  // 반시계 방향으로 두칸씩 회전
		System.out.println(list);
		
		Collections.swap(list,0,2);  // 첫 번째와 세 번째 교환
		System.out.println(list);
		
		Collections.shuffle(list);  // 요소 랜덤으로 섞기
		System.out.println(list);
		
		Collections.sort(list, Collections.reverseOrder()); // 역순 정렬
		System.out.println(list);
		
		Collections.sort(list); // 정렬
		System.out.println(list);

		int idx = Collections.binarySearch(list,3); // 이진 탐색으로 3index 출력
		System.out.println(idx);
		
		Collections.max(list);
		Collections.min(list);
		
		Collections.fill(list, 9); // 리스트를 9로 채움
		
		List newList = Collections.nCopies(list.size(), 2); // 크기가 같은 배열을 생성하고 2로 채움 
		
		Collections.disjoint(list, newList); // > 공동요소 검색
		Collections.replaceAll(list, 2,1); // > 2를 1로 변경
		Collections.disjoint(list, newList); // > 공동요소 검색
		
		/*
		 지네릭스
		 컴파일시 타입을 체크해주는 기능
		 타입 안정성 제공
		 형변환을 명시하지 않아 코드가 간결해짐
		 
		 Box<T> > 지네릭 클래스. T Box라고 읽는다.
		 T > 타입변수 또는 타입 매개변수 Type의 대문자
		 Box > 원시 타입(일반 클래스)
		 */
		
		// Integer 객체만 저장할 수 있는 ArrayList를 생성
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		list2.add(10);
		list2.add(20);
		// list2.add("30"); 에러. 지네릭스에 의해 컴파일 에러 발생
		
		// get은 Object를 반환하지만 지네릭스 덕분에 형변환 생략 가능
		// int value = (Integer)list.get(1);
		int value = list2.get(1); 
		
		// 지네릭스가 생긴 이후 항상 지네릭스를 작성해야함
		// ArrayList list3 = new ArrayList();
		ArrayList<Object> list3 = new ArrayList<Object>();
		
		 
		 // ArrayList<Product> list = new ArrayList<Tv>(); > 에러.
		 ArrayList<Product> productList = new ArrayList<Product>();
		 
		 // 다형성 성립
		 productList.add(new Tv());
		 productList.add(new Audio());
		 Tv tv1 = (Tv) productList.get(0); // 형변환 필요
		 
		 // HashMap 지네릭스
		 HashMap<String, Student> map2 = new HashMap<String, Student>();
		 map2.put("자바왕", new Student("자바왕",1,1,100,100,100));
		 
		 Student s = map2.get("자바왕"); // 형변환이 필요 없음
		 System.out.println(map2);
	}

}

class Student{
	String name = "";
	int ban;
	int num;
	int kor;
	int eng;
	int math;
	
	Student(String name, int ban, int num, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.num = num;
		this.kor  = kor;
		this.eng = eng;
		this.math = math;
	}
}

class Product {}
class Tv extends Product {}
class Audio extends Product {}

class Test{}

class TestComp implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 1;
	}
}

class Person{
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			return false;
		
		Person p = (Person) obj;
		return this.name.equals(p.name) && this.age==p.age;		
	}
	
	
	public String toString() {
		return name + ':' + age;
	}
}