package day12;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class Day12 {
	public static void main(String[] args) {
		// 문자열 분리
		String animals = "dog,cat,bear";
		String[] arr = animals.split(",");
		for (int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		
		// 문자열 결합
		String str = String.join("-", arr);
		System.out.println(str);
		
		// 기본형 > 문자열
		int i = 100;
		String str1 = i+"";  // 편하지만 느림
		String str2 = String.valueOf(i); // 불편하지만 빠름
		
		// 문자열 > 기본형
		i = Integer.parseInt("100");
		int i2 = Integer.valueOf("100"); // 정확히는 wrapper 클래스
		
		/*
		 String Buffer
		 문자열을 저장 처리
		 String과의 차이는 가변이 가능하다
		 문자열 조작이 많은 경우 사용
		 */
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = sb.append("123"); // append는 참조를 반환
		sb2.append("4");
		System.out.println(sb); // > abc1234
		// sb2가 sb 참조를 가르키고 있으므로 sb2의 변경이 sb에 영향을 줌
		
		// equals()가 오버라이딩 되어있지 않다.
		StringBuffer sb3 = new StringBuffer("abc");
		StringBuffer sb4 = new StringBuffer("abc");
		System.out.println(sb3==sb4); // false 
		System.out.println(sb3.equals(sb4)); // false  
		
		/*
		 생성자
		 StringBuffer() > 16 길이 버퍼
		 StringBuffer(int length) > length길이 버퍼
		 StringBuffer(String str) > str 길이 + 16 버퍼
		 */
		
		/*
		 메서드
		 append() 매개변수는 타입과 상관 없음
		 int capacity() 버퍼 크기
		 int length() 저장된 문자열 길이
		 char charAt(int index) index위치의 char 반환
		 StringBuffer delete(int start, int end) end는 제외
		 StringBuffer deleteCharAt(int index) index위치만 삭제
		 StringBuffer insert(int pos, *)
		 StringBuffer replace(int start, int end, String str) > delete insert 순으로 진행
		 StringBuffer reverse()
		 void setCharAt(int index, char ch)
		 void setLength(int newLength)
		 String toString()
		 String substring(int start)
		 String substring(int start, int end)
		 */
		
		/*
		 StringBuffer >  동기화되어 있어 멀티 쓰레드에 안전
		 StringBuilder > 동기화가 안되며 싱글 쓰레드 프로그램에서 성능이 좋음
		 메서드는 동일
		 */
		
		/*
		 Math 클래스
		 수학 관련 static메서드의 집하
		 public static final double E = 2.71828...
		 public static final double PI = 3.14159...
		 abs()   절대값
		 ceil()  올림
		 floor() 버림
		 max()   큰값
		 min()   작은값
		 random() 랜덤값
		 round() 소수점 반올림 (3.5 > 3)
		 rint()  가까운 짝수 쪽으로 소수점 반올림
		 */
		
		/*
		 wrapper 클래스
		 8개의 기본형을 객체로 다루게 해줌
		 Number 클래스는 모든 숫자 wrapper 클래스의 조상
		 */
		Integer i3 = new Integer(100);
		Integer i4 = new Integer(100);
			
		System.out.println(i3==i4); // false
		System.out.println(i3.equals(i4)); // true > 오버라이딩
		
		int i5 = Integer.parseInt("100");
		
		// n진법의 문자열을 숫자로 변환
		int i6 = Integer.parseInt("100",2);
		int i7 = Integer.parseInt("FF",16);
		
		/*
		 오토박싱 : int를 자동으로 Integer로 변경
		 언박싱 : Integer를 자동으로 int로 변경 
		 */
		
		/*
		 날짜와 시간
		 java.util.Date 메서드는 거의 deprecated 되었지만 여전히 쓰임
		 java.util.Calendar로 대체됐지만 단점이 존재
		 java.time 패키지를 제공(JDK 1.8)
		 */
		
		/*
		 Calendar cal = new Calendar(); > 에러 추상 클래스는 인스턴스를 생성할 수 없다.
		 Calendar cal = Calendar.getInstance();
		 int thisYear = cal.get(Calendar.YEAR);
		 int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);
		 
		 날짜와 시간 지정
		 * 주의 month는 0이 1월임
		 void set(int field, int value)
		 void set(int year, int month, int date)
		 void set(int year, int month, int date, int hourOfDay, int minute)
		 void set(int year, int month, int date, int hourOfDay, int minute, int second)
		 
		 시간 지정하는 방법
		 void set(Calendar.HOUR_OF_DAY, 10);
		 void set(Calendar.MINUTE, 20);
		 void set(Calendar.SECOND, 30);
		 
		 void clear() // 모든 필드 초기화 > 1970년 1월 1일 00:00:00 이후 시간이 흐르지 않음
		 > 시간을 계산할 때 clear로 초기화를 해야함()
		 void clear(Calendar.SECOND) > 초를 0으로 초기화
		 
		 Calendar date = Calendar.getInstance();
		 date.clear();
		 
		 add()는 다른 필드에 영향을 주고
		 date.add(Calendar.DATE, 1);  > 날짜에서 1을 더함
		 date.add(Calendar.MONT, -8); > 월에서 8을 뺌
		 
		 roll()은 다른 필드에 영향을 주지 않음
		 date.roll(Calendar.DATE, 1);
		 date.roll(Calendar.MONTH, -8);
		 */
		
		// 형식화 클래스 > 숫자와 날짜를 원하는 형식으로 쉽게 출력 가능
		
		// 숫자 형식화 DecimalFormat
		// import java.text.DecimalFormat; 상단 확인
		double number = 1234567.89;
		DecimalFormat df = new DecimalFormat("#.#E0");
		String res = df.format(number); // > "1.2E6"
		
		DecimalFormat df2 = new DecimalFormat("#,###.##");
		try {
		Number num = df2.parse("1,234,567.89");
		double d = num.doubleValue(); // > 1234567.89
		} catch(ParseException e){
		}
	
		// 날짜와 시간 형식화
		Date today = new Date();
		SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
		String res2 = df3.format(today); // > 2024-04-20
		
		try {
		DateFormat df4 = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df5 = new SimpleDateFormat("yyyy/MM/dd");
		Date d = df4.parse("2024년 04월 20일");
		String res3 = df5.format(d);
		} catch(ParseException e) {}
	}

}
