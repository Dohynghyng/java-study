package day1;

public class Day1 {
	public static void main(String[] args) {
		// 변수 지정
		int A = 100;
		
		// 상수 지정
		final float pi = 3.14f;
		// pi = 3.15;  >  상수는 변경 불가
		
		boolean power = true;
		byte b = 127; // -128~127
		
		// 진법
		int oct = 010;   //8진수, 10진수로는 8
		int hex = 0x10;  //16진수, 10진수로는 16
		System.out.println(oct);
		// > 8
		System.out.println(hex);
		// > 16
		
		long l = 10_000_000_000L;
		// long l = 10_000_000_000;  >  int 타입을 벗어나는 리터럴은 접미사에 Long 타입 명시
		
		float f = 3.14f;
		double d = 3.14f;   // double 타입 > float 타입이기 때문에 가능
		// float f = 3.14d;   >  double 타입 > float 타입이기 때문에 불가능
		
		System.out.println(0b10);   // 소수점 double 타입 출력
		System.out.println(10.);   // 소수점 double 타입 출력
		System.out.println(0.10);  // 소수점 double 타입 출력
		System.out.println(10f);   // 10.0 float 타입 출력
		System.out.println(1e3);  // 10^3 e는 소수점이므로 double 타입 출력
		
		char ch = 'A';  
		int i = 'A';    // 아스키코드 65 출력
		
		// char ch = 'AB'  >  오류 발생
		String str = "";
		String str2 = "A";
		String str3 = "AB";
		String str4 = str2 + str3;  // > AAB 출력

		System.out.println(""+7+7);  // > 왼쪽부터 연산  "7"+7 > "77"
		System.out.println(7+7+"");  // > 왼쪽부터 연산  14+"" > "14"
	}

}
