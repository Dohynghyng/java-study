package day18;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class Day18 {
	public static void main(String[] args) {
//		1. Stream 생성
//		String[] strArr = {"dd","aaa","CC","cc","b"};
//		Stream<String> stream = Stream.of(strArr);
//		2. 중간 연산(N번까지 가능)
//		Stream<String> filteredStream = stream.filter("cc");      	// 걸러내기
//		Stream<String> distinctedStream = stream.distinct();  	// 중복제거
//		Stream<String> sortedStream = stream.sorted();		  	// 정렬
//		Stream<String> limitedStream = stream.limit(5);      	// 자르기
//		3. 최종 연산(1번만 가능) > 스트림의 요소를 소모
//		Long total = filteredStream.count();
		
//		스트림 자르기
//		skip(), limit()
		IntStream intStream = IntStream.rangeClosed(1, 10);    // 1~10
		// skip은 앞에서 건너 뛰기  4~10
		// limit은 maxSize이후 요소는 잘라냄 4~8
		intStream.skip(3).limit(5).forEach(System.out::print);
		System.out.println();
		
		
//		요소 걸러내기
		IntStream intStream2 = IntStream.of(1,2,2,3,3,3,4,5,5,6);    // 1~10
//		filter(), distinct()
		// filter(Predicate predicate)  조건에 맞지 않는 요소 제거
		// distinct()                   중복 제거
		intStream2.distinct().filter(i->i%2==0).forEach(System.out::print);
		System.out.println();
		
//		스트림 정렬
//		sorted(), sorted(Comparator comparator)
		Stream<Student> studentStream = Stream.of(
				new Student("이자바",3,300),
				new Student("김자바",1,200),
				new Student("안자바",2,100),
				new Student("박자바",2,150),
				new Student("소자바",1,200),
				new Student("나자바",3,290),
				new Student("감자바",3,180));
		
		// 정렬 기준이 없을 때 람다식
		// studentStream.sorted(Comparator.comparing(Student::getBan)).forEach(System.out::print);
		// 추가 정렬 기준을 제공할 때는 thenComparing()을 사용
		studentStream.sorted(Comparator.comparing(Student::getBan) // 1.반별 정렬
			.thenComparing(Comparator.naturalOrder()))              // 2.기본 정렬
			.forEach(System.out::println);
		
//		스트림 요소 변환 ex) 확장자 중복 없이 뽑아내기
//		map()
//		peek() 스트림 엿보기(중간 연산)
		Stream<File> fStream = Stream.of(new File("Day18.java"));
		fStream.map(File::getName)						// Stream<File> -> Stream<String>
				.filter(s->s.indexOf('.') != -1)		// 확장자 없는 파일 제거
				.peek(s->System.out.printf("fname = %s%n", s))  // 중간 결과 출력
				.map(s->s.substring(s.indexOf('.')+1))  // 확장자 이후 문자열만 저장
				.map(String::toUpperCase)				// 대문자 전환
				.distinct()								// 중복 제거
				.forEach(System.out::println);
		
//		스트림의 스트림을 스트림으로 ㅕㄴ환
		Stream<String[]> strArrStrm = Stream.of(new String[] {"abc","def","ghi"},
												new String[] {"ABC","DEF","GHI"});
		// 다음과 같이 변환하면 2중 스트림
		Stream<Stream<String>> strStrStrm = strArrStrm.map(Arrays::stream);
		strStrStrm.forEach(System.out::println);
		
		
		Stream<String[]> strArrStrm2 = Stream.of(new String[] {"abc","def","ghi"},
												 new String[] {"ABC","DEF","GHI"});
		// 이것을 flatten
		Stream<String> flattenStream = strArrStrm2.flatMap(Arrays::stream);
		flattenStream.forEach(System.out::println);

//		Optioonal> 래퍼 클래스
//		public final class Optional<T>{ private final T value }
//		모든 객체를 저장 가능
//		null을 직저 다루는 것은 위험 (Nullpointexception)
//		null 체크를 계속 하면 코드가 길어짐
//		Optional을 이용하여 null을 간접적으로 가르키게 만든다.
		
//		Optional 생성
		String str = "abc";
		Optional<String> optVal = Optional.of(str);
		// Optional<String> optVal2 = Optional.of(null);        불가능
		Optional<String> optVal2 = Optional.ofNullable(null); //가능
		
//		null 대신 Optional 객체를 사용.		
		Optional<String> optVal3 = Optional.<String>empty();
		
//		객체 값 가져오기
		Optional<String> optVal4 = Optional.of(str);
		String str0 = optVal4.get();				  // null이면 예외 발생
		String str1 = optVal4.orElse("");			  // null이면 빈 문자열 출력
		String str2 = optVal4.orElseGet(String::new); // 람다식 사용 가능
		String str3 = optVal4.orElseThrow(NullPointerException::new); // 예외 ㅏㄹ생
		
		if (optVal4.isPresent()) {} // isPresent는 null이면 False 반환
		
//		기본형 Optional
//		OptionalInt, OptionalLong, Optional Double > 성능 향상을 위해 사용
		OptionalInt opt = OptionalInt.of(0);
		OptionalInt opt2 = OptionalInt.empty();
		// 두가지를 비교하기 위해 isPresent()가 있음
		
		
// 		스트림 최종 연산
		System.out.println("of(0)의 isPresent > " + opt.isPresent());
		System.out.println("empty의 isPresent > " + opt2.isPresent());
		
		// 직렬 스트림
		IntStream.range(1, 10).sequential().forEach(System.out::print);
		System.out.println();
		IntStream.range(1, 10).sequential().forEachOrdered(System.out::print);
		System.out.println();
		// 병렬 스트림
		IntStream.range(1, 10).parallel().forEach(System.out::print); // 병렬은 순서 보장 X
		System.out.println();
		IntStream.range(1, 10).parallel().forEachOrdered(System.out::print); // 병럴 순서 보장을 위해 forEachOrdered 사용
		System.out.println();
		
//		요소 조건 검사
		Stream<Student> studentStream2 = Stream.of(
				new Student("이자바",3,300),
				new Student("김자바",1,200),
				new Student("안자바",2,100),
				new Student("박자바",2,150),
				new Student("소자바",1,200),
				new Student("나자바",3,290),
				new Student("감자바",3,180));
		
		boolean cond1 = studentStream2.allMatch(s->s.getScore()<=100);
//		boolean cond2 = studentStream2.anyMatch(s->s.getScore()<=100);
//		boolean cond3 = studentStream2.noneMatch(s->s.getScore()<=100);

		Stream<Student> studentStream3 = Stream.of(
				new Student("이자바",3,300),
				new Student("김자바",1,200),
				new Student("안자바",2,100),
				new Student("박자바",2,150),
				new Student("소자바",1,200),
				new Student("나자바",3,290),
				new Student("감자바",3,180));
		
//		studentStream2.findFirst(조건) // 가장 앞쪽의 요소 반환
//		studentStream2.findAny(조건) // 아무 요소 반환 ( 병렬 스트림에 사용)
		Optional<Student> res = studentStream3.filter(s->s.getScore()<=100).findFirst();
//		Optional<Student> res = studentStream3.filter(s->s.getScore()<=100).findAny();
		
//		Stream 요소를 꺼내며 누적 연산
		IntStream IStrm1 = Stream.of(6,1,34,2,6,87,5,2).mapToInt(Integer::intValue);
		IntStream IStrm2 = Stream.of(6,1,34,2,6,87,5,2).mapToInt(Integer::intValue);
		IntStream IStrm3 = Stream.of(6,1,34,2,6,87,5,2).mapToInt(Integer::intValue);
		IntStream IStrm4 = Stream.of(6,1,34,2,6,87,5,2).mapToInt(Integer::intValue);
		
		int count = IStrm1.reduce(0,(a,b) -> a+1);
		int sum   = IStrm2.reduce(0,(a,b) -> a+b);
		
		// 초기값이 없기 때문에 Null값을 방지하기위해 OptionalInt 사용
		OptionalInt max   = IStrm3.reduce(Integer::max);
		OptionalInt min   = IStrm4.reduce(Integer::min);
		
		System.out.println("count : "+count);
		System.out.println("sum : "+sum);
		
		// Optional이기 때문에 출력을 .getAsInt 사용
		System.out.println("max : "+max.getAsInt());
		System.out.println("min : "+min.getAsInt());
		
//		collect(Collector collector)는 그룹별 reducing()하는 최종 연산
//		Collector는 Collect에 필요한 메서드를 정의한 인터페이스
//		Collectors는 인터페이스를 구현한 클래스
		Stream<Student> studentStream4 = Stream.of(
				new Student("이자바",3,300),
				new Student("김자바",1,200),
				new Student("안자바",2,100),
				new Student("박자바",2,150),
				new Student("소자바",1,200),
				new Student("나자바",3,290),
				new Student("감자바",3,180));
		
		// 스트림을 컬렉션으로 변환
		//List<String> names = studentStream4.map(Student::getName).collect(Collectors.toList());
		//ArrayList<String> list = studentStream4.map(Student::getName).collect(Collectors.toCollection(ArrayList::new));
		Map<String,Student> map = studentStream4.collect(Collectors.toMap(p->p.getName(),p->p));
		
		// 스트림을 배열로 변환
		//Student[] stuNames1 = studentStream4.toArray(Student[]::new);
//		Student[] stuNames2 = studentStream4.toArray()  에러
		//Object[] stuNames3 = studentStream4.toArray(Student[]::new);
		
//		스트림 통계 정보
		long count = studentStream4.count();
		long count = studentStream4.collect(Collectors.counting());
		
		long totalScore = studentStream4.mapToInt(Student::getScore).sum();
		long totalScore = studentStream4.collect(Collectors.summingInt(Student::getScore));
		
		OptionalInt topScore = studentStream4.mapToInt(Student::getScore).max();
		
		Optional<Student> topStudent= studentStream4
				.max(Comparator.comparingInt(Student::getScore));
		Optional<Student> topStudent= studentStream4
				.collect(Collectors.maxBy(Comparator.comparingInt(Student::getScore)));		
		
//		Collectors 안에 reducing()이 존재 -> 그룹별 처리가 가능

//		스트림의 그룹화와 분할
//		Collectors.partitioningBy() 스트림을 2분할
		Stream<Student> studentStream5 = Stream.of(
				new Student("이자바",3,300,true),
				new Student("김자바",1,200,true),
				new Student("안자바",2,100,false),
				new Student("박자바",2,150,true),
				new Student("소자바",1,200,false),
				new Student("나자바",3,290,false),
				new Student("감자바",3,180,true));
		Map<Boolean, List<Student>> stuBySex = studentStream5
				.collect(Collectors.partitioningBy(Student::isMale));
		List<Student> maleStudent = stuBySex.get(true);
		List<Student> femaleStudent = stuBySex.get(false);
		
		// 분할된 Stream에 분할+통계도 가능하다
		Stream<Student> studentStream6 = Stream.of(
				new Student("이자바",3,300,true),
				new Student("김자바",1,200,true),
				new Student("안자바",2,100,false),
				new Student("박자바",2,150,true),
				new Student("소자바",1,200,false),
				new Student("나자바",3,290,false),
				new Student("감자바",3,180,true));
		Map<Boolean, Long> stuBySex2 = studentStream6
				.collect(Collectors.partitioningBy(Student::isMale, Collectors.counting()));
		List<Student> maleStudent2 = stuBySex.get(true);
		List<Student> femaleStudent2 = stuBySex.get(false);
		
		// 다중 분할도 가능
		Stream<Student> studentStream7 = Stream.of(
				new Student("이자바",3,300,true),
				new Student("김자바",1,200,true),
				new Student("안자바",2,100,false),
				new Student("박자바",2,150,true),
				new Student("소자바",1,200,false),
				new Student("나자바",3,290,false),
				new Student("감자바",3,180,true));
		Map<Boolean,Map<Boolean, List<Student>>> failedStudBySex = studentStream7
				.collect(Collectors.partitioningBy(Student::isMale,
						Collectors.partitioningBy(s -> s.getScore() <150)));
		List<Student> failedMaleStu = failedStudBySex.get(true).get(true);
		List<Student> failedFemaleStu = failedStudBySex.get(false).get(true);

//		Collectors.groupingBy()     스트림을 n분할
//		groupingBy는 사용법 같음
		
		
		
		
	}

}

class Person{}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int score;
    boolean ismale;

    Student(String name, int ban, int score) {
        this.name = name;
        this.ban = ban;
        this.score = score;
    }

    Student(String name, int ban, int score, boolean isMale) {
        this.name = name;
        this.ban = ban;
        this.score = score;
        this.ismale = isMale;
    }
    
    public boolean isMale() {
        return ismale;
    }
    
    
    public int getBan() {
        return this.ban;
    }
    public int getScore() {
        return this.score;
    }
    public String toString() {
    	return String.format("[%s, %d, %d]", name, ban, score);
    }
    public String getName() {
    	return name;
    }

	@Override
	public int compareTo(Student s) {
		return s.score - this.score;
	}
}