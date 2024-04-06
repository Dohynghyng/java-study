package day4;
import java.util.Scanner;

public class Day4 {

	public static void main(String[] args) {
		// if 조건문
		int score = 70;
		if (score > 60) {
			System.out.println("합격입니다");
		}
		else {
			System.out.println("불합격입니다");
		}
		
		// 한줄은 {} 을 안 써도 된다.
		if (score > 60)
			System.out.println("합격입니다");
		else
			System.out.println("불합격입니다");
			
		// 문자열 조건문 확인
		String s1 = "yes";
		if (s1.equals("yes"))
			System.out.println("String s가 yes 입니다.");
		
		// 대소문자 무시
		String s2 = "YES";
		if (s1.equalsIgnoreCase("yes"))
			System.out.println("String s가 대소문구분 없이 yes 입니다.");
		
		// if, else if
		score=72;
		if (score>=90)
			System.out.println("학점은 \"A\"입니다. ");
		else if (score>=80)
			System.out.println("학점은 \"B\"입니다. ");
		else if (score>=70)
			System.out.println("학점은 \"C\"입니다. ");
		else
			System.out.println("학점은 \"F\"입니다. ");
			
		// switch문 (경우의 수가 많을 때) 조건식이 정수 또는 문자열 case에는 상수,문자,문자열 됨
		final int NINE = 9;
		
		System.out.print("현재 월을 입력하세요.>");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		
		switch (month) {
			case 3:
			case 4:
			case 5:
				System.out.println("현재의 계절은 봄입니다.");
				break;  // break문을 걸어주지 않으면 아래 줄까지 실행
			case 6: case 7: case 8:  // 한줄로 여러 케이스를 표현 가능
				System.out.println("현재의 계절은 여름입니다.");
				break;  // break문을 걸어주지 않으면 아래 줄까지 실행
			case NINE: case 10: case 11:  // final로 선언된 상수는 가능
				System.out.println("현재의 계절은 가을입니다.");
				break;  // break문을 걸어주지 않으면 아래 줄까지 실행
			default:
				System.out.println("현재의 계절은 겨울입니다.");
				break;
			// case 1.0    실수는 불가능
			// case month  변수도 불가능		
			}
		
		// 난수 생성
		Math.random(); // 0.0 <= Math.random() < 1.0 사이의 임의의 double값을 반환
		
		// 임의의 정수 만들기
		for (int i=1;i<=5;i++)
			System.out.println((int)(Math.random()*10));
		
		// for문
		for (int j=0,k=10; j<=10; j++,k--)
			System.out.printf("j : %d, k : %d%n", j,k);
		
		// 반복문 이름 설정
		Loop1 : for(int l=2;l<=9;l++) {
			for(int m=1;m<=10;m++) {
				if(m==0)
					break Loop1; // Loop1 반복문까지 break를 걸어준다.
			}
		}
		
		// 배열 선언과 생성
		int[] score2;
		score2 = new int[5];
		// int[] score2 = new int[5]; 동시에도 가능하다.

		//배열 초기화는 다음과 같이 할 수 있음
		int[] score3 = {50,60,70,80,90};
		
		int len = score3.length; // 배열의 길이 저장
		
		// length를 이용한 요소 출력
		for(int p=0;p<score2.length;p++) {
			System.out.printf("%d%n",score3[p]);
		}
	}
		
}
		

