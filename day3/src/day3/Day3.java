package day3;

public class Day3 {
	public static void main(String[] args) {
		// 형변환
		double d = 85.6;
		int i = (int) d;
		System.out.println(i);
		
		int i1 = 65;
		char c = (char)i1;
		System.out.println(c);
		
		// 자동 형변환
		float f = 1234; //  > (float) 1234; 범위가 허용하는 범위에서 허용
		/*
		int i = 3.14f; // 값 손실이 발생하는 경우 자동 형변환이 불가능함
		int i = (int)3.14f; // 따라서 수동 형변환을 진행해야함
		 */
		System.out.println(f);
		
		byte b3 = 100; // => byte b3 = (byte)100
		
		int i4 = 100;
		// byte b4 = i4;  > 리터럴이 아닌 변수 삽입에 범위가 줄어들면 안됨
		byte b4 = (byte)i4;
		
		// 피연산자 타입이 int보다 작은 타입이면 int로 변환
		// byte + short > int + int > int
		// char + short > int + int > int
		
		int i6 = 1_000_000;
		int i7 = 2_000_000;
		// long l7 = a*b;  > 오버 플로우 발생
		long l7 = (long)i6 * i7;
		
		// 반올림
		long l8 = Math.round(3.141592);
		double d8 = Math.round(3.141592*1000) / 1000.0; // 원하는 자리수 반올림
		
		// 문자열 비교
		String str1 = "abc";
		String str2 = "abc";
		// str1 == str2; // True

		String str3 = new String("abc");
		String str4 = new String("abc");
		// str1 == str2; // False
		// str1.equals(str2) > True
		
		// 조건 연산자 '?'
		int i9 = 1;
		int i10 = 2;
		int result = (i9>i10) ? i9:i10;  //조건의 참 거짓 여부에 따라 값 지정
		
		
		
		
		
	}

}
