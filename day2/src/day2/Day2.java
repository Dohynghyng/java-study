package day2;
import java.util.*;

public class Day2 {

	public static void main(String[] args) {
		// x,y Swap
		int x = 4, y = 2;
		int tmp;
		tmp = x;
		y = x;
		x = tmp;
		System.out.println("x="+x);
		System.out.println("y="+y);
		
		System.out.println(10.0/3);          // 소수점 자리 제한 불가, 10진수로만 출력 가능
		System.out.printf("%.2f%n", 10.0/3);   // 소수점 자리 제한
		System.out.printf("%d%n", 0x1A);      // 10진수 출력
		System.out.printf("%X%n", 0x1A);      // 16진수 출력
		System.out.printf("%X%n", 11);      // 16진수 출력
		System.out.printf("%#X%n", 11);      // 접두사 포함 16진수 출력
		

		System.out.printf("%5d%n", 15);      // 자리수 오른쪽 정렬
		System.out.printf("%-5d%n", 15);      // 자리수 왼쪽 정렬
		System.out.printf("%05d%n", 15);      // 자리수 0으로 채우기
		
		double d = 1.23456789;
		System.out.printf("%14.10f%n", d);
		
		String s = "www.naver.com";
		System.out.printf("%15s%n", s);
		System.out.printf("%-15s%n", s);
		System.out.printf("%.7s%n", s);
		
		// 입력받기
		// import java.util.*;                     // import문 추가
		Scanner scanner = new Scanner(System.in);  // 객체 생성
		
		// 방법 1
//		int num1 = scanner.nextInt();         // scanner에서 바로 int 변환
//		System.out.println(num1);
		
		// 방법 2
//		String input = scanner.nextLine();         // scanner의 nextLine 메서드를 이용하여 String 입력
//		int num2 = Integer.parseInt(input);         // String을 Integer로 바꿈
//		System.out.println(num2);
		
		// 오버 플로우 
		short sMin = -32768, sMax=32767;
		
		System.out.println("sMin = " + sMin);
		System.out.println("sMin-1 = " + (short) (sMin-1));
		System.out.println("sMax = " + sMax);
		System.out.println("sMax-1 = " + (short) (sMax+1));
		
		// 타입간 변환
		
		System.out.println("3".charAt(0)-'0');  // str > int
		System.out.println(Integer.parseInt("3") + 1);  // str > int
		System.out.println('3' - '0' + 1);  // char > int
		System.out.println("3" + 1);  // int > str
		System.out.println(3 + '0');  // char > int   '0'은 숫자로 48
	}

}
