package day13;

import java.util.*;

class Descending implements Comparator{
	public int compare(Object o1, Object o2) {
		if ( o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2) * -1;
		}
		return -1;
	}
}

public class Day13 {
	public static void main(String[] args) {
		/*
		 collections framework
		 컬렉션 > 여러 객체를 모아 놓은 것
		 프레임웍 > 정형화된 체계적인 프로그래밍 방식
		 컬렉션 프레임웍 > 다수의 객체를 다루기 위한 표준화된 프로그래밍 방식
		 컬렉션 프레임웍 핵심 인터페이스 > List, Set
		 Map은 파이썬의 dictionary와 비슷함
		 */
		
		// ArrayList > 동기화 X, 접근 시간이 짧다.
		// 장점 > 접근 시간이 짧다.
		// 단점 > 크기를 변경할 수 없다, 크기 변경에 메모리 낭비, 데이터 추가 삭제에 시간이 많이 걸림
		
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		// list1 > 5,4,2,0,1,3
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		// list2 > 4,2,0
		
		// Collection은 인터페이스, Collections는 유틸 클래스
		Collections.sort(list1); // > 0,1,2,3,4,5
		Collections.sort(list2); // > 0,2,4
		
		list1.add(0,"1");
		
		// 세개는 다른 의미인 것을 알아야함
		list1.remove(new Integer(1));  // 1을 삭제
		list1.remove(1);               // 인덱스 1 삭제
		list1.remove("1");             // "1"을 삭제
		
		// LinkedList > 배열의 크기변경 및 추가삭제 시간 보완
		// 단점 > 접근성이 나쁨
		
		// Stack > LIFO (push,pop)    > ArrayList가 편함
		// Queue > FIFO (offer,poll)  > LinkedList가 편함
		
		// 큐는 인터페이스기 때문에 직접 구현하거나 구현하여 사용
		
		Stack st = new Stack();
		Queue q = new LinkedList();
		
		st.push("0");
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("= Stack =");
		while (!st.empty()) {
			System.out.println(st.pop());
		}

		System.out.println("= Queue =");
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
		
		/*
		 Iterator
		 boolean hasNext() > 다음 요소가 있는지 확인
		 Object next()     > 다음 요소 반환
		 
		 ListIterator
		 Iterator와 같지만 previous()가 존재
		 
		 컬렉션 저장 요소를 읽어오는 방법을 표준화
		 
		 Enumeration
		 boolean hasMoreElements()  > 다음 요소가 있는지 확인
		 Object nextElement()       > 다음 요소 반환
		 */
		
		ArrayList list3 = new ArrayList();
		list3.add("1");
		list3.add("2");
		list3.add("3");
		list3.add("4");
		list3.add("5");
		
		Iterator it = list3.iterator();
		// list3.add("6"); > 에러. Iterator를 사용하는 경우 반복문이 끝나고 난 뒤 추가
		
		System.out.println("= Iterator =");
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		// Iterator는 일회용이라 다시 추가해줘야 출력됨
		System.out.println("= Iterator =");
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		/*
		 Arrays 
		 배열을 다루기 편리한 static 메서드 제공
		 배열의 출력 .toString(str)
		 배열의 복사 .copyOf(str, start, end)
		 배열 채우기 .fill(str, value)
		 배열 람다 채우기 .setAll(str, lambda)
		 정렬 .sort(str)
		 이진 탐색 .binarySearch(str) > 정렬된 상태만 사용
		 다차원 배열 출력 .deepToString(str)
		 다차원 배열 비교 .deepEquals(str1,str2)
		 배열을 List로 변환 .asList(Object... a)
		 */
		
		int[] arr = {0,1,2,3,4};
		int[][] arr2D = {{11,12,13},{21,22,23}};
		
		System.out.println("arr="+Arrays.toString(arr));
		System.out.println("arr2="+Arrays.deepToString(arr2D));
		
		/*
		 Comparator > 기본 정렬기준을 구현하는데 사용
		 Comparable > 기본 정렬기준 외에 다른 기준으로 정렬할 때
		 같으면 0, 오른쪽이 크면 음수, 왼쪽이 크면 양수 반환
		 */
		
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		
		Arrays.sort(strArr); // String의 Comparable 구현에 의한 정렬 (대문자 우선)
		System.out.println("arr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // Comparator 정렬 기준 제공 (대문자 무시)
		System.out.println("arr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending()); // Comparator 정렬 기준 상단에 생성 후 제공 (내림차순)
		
		// HashSet은 Set 인터페이스를 구현한 대표적인 컬렉션 클래스
		// 순서를 유지하려면 LinkedHashSet 사용
		// TreeSet 범위 검색과 정렬에 유리한 컬렉션 클래스
		
		Object[] objArr = {"1", new Integer(1),"2","2","3","3","4","4","4"};
		Set set = new HashSet();
		
		for (int i=0; i<objArr.length; i++)
			set.add(objArr[i]);
		
		System.out.println(set);
		Iterator it2 = set.iterator();
		
		while (it2.hasNext()){
			System.out.println(it2.next());
		}

		Set set2 = new HashSet();
		
		for (int i=0; set2.size()<6; i++) {
			int num = (int)(Math.random()*45)+1;
			set2.add(num);
		}

		System.out.println(set2);
		
		// Set을 정렬하기 위해서는 sort가 있는 객체로 바꿔줘야함
		List list5 = new LinkedList(set2);
		Collections.sort(list5);
		System.out.println(list5);
		
		
	}

}
