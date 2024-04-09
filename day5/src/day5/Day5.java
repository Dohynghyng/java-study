package day5;

import java.util.Arrays;

public class Day5 {
	public static void main(String[] args) {
		int[] iArr = {100,95,80,70,60};
		// 배열 출력 1.
		for(int i=0;i<iArr.length;i++)
			System.out.printf("%d ", iArr[i]);
		System.out.println();
		
		// 배열 출력 2.
		System.out.println(Arrays.toString(iArr));
		
		
		int[] score = {100,88,100,100,90};
		
		// 총합, 평균
		int sum=0;
		double average = 0.0;
		for (int i=0;i<score.length;i++)
			sum += score[i];
		average = sum / (double) score.length;
		System.out.println("총합 : "+sum);
		System.out.println("평균 : "+average);
		
		// 최대, 최소
		int max=score[0];
		int min=score[0];

		for (int i=1;i<score.length;i++) {
			if (max < score[i])
				max = score[i];
			if (min > score[i])
				min = score[i];
		}
		System.out.println("최대 : "+max);
		System.out.println("최소 : "+min);
		
		// 배열 섞기
		int[] numArr = {0,1,2,3,4,5,6,7,8,9};
		for (int i=0;i<100;i++) {
			int n = (int)(Math.random()*10);
			int temp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = temp;
		}
		System.out.println(Arrays.toString(numArr));
		
		// String 배열의 선언과 생성
		// String[] name = new String[3];
		String[] name = {"Kim", "Park", "Yi"};
		
		// 커맨드 라인을 통해 입력받기
		System.out.println("매개변수의 개수 : " + args.length);
		for (int i=0;i<args.length;i++)
			System.out.println("args[" + i +"] = \"" + args[i] + "\"");
		
		// 2차원 배열
		int[][] score2 = new int[4][3];
		int[][] arr2 = {
						{1,2,3,4},
						{5,6,7,8}
						};
		
		// 2차원 배열 합
		int sum2=0;
		int[][] score3 = {
				{100, 100, 100},
				{20, 20, 20},
				{30, 30, 30},
				{40, 40, 40}
		};
		
		for (int i=0; i<score3.length;i++) {
			for (int j=0;j<score3[i].length;j++) {
				System.out.printf("score[%d][%d]=%d%n",i,j,score3[i][j]);
				sum2 += score3[i][j];
			}
		}

		System.out.printf("총합 : %d%n",sum2);
		
		/* String 클래스 주요 메서드
		char charAt(int index) > 문자열에 해당 위치에 있는 문자 반환
		int length() > 문자열의 길이 반환
		String suubstring(int from, int to) > 문자열의 해당 범위(from~to)의 문자열 반환.(to는 포함 안됨)
		boolean equals(Object obj) > 문자열의 내용이 같은지 확인
		char[] toCharArray() > 문자열의 문자배열(char[])로 변환해서 반환
		*/
		
		int[] arr_1d = {0,1,2,3,4};
		int[][] arr_2d = {{11,12},{21,22}};
		
		System.out.println(Arrays.toString(arr_1d));
		System.out.println(Arrays.deepToString(arr_2d));  // 2차원 이상
		
		String[][] str2D_1 = {{"aaa","bbb"},{"AAA","BBB"}};
		String[][] str2D_2 = {{"aaa","bbb"},{"AAA","BBB"}};
		
		System.out.println(Arrays.equals(str2D_1,str2D_2));     //false
		System.out.println(Arrays.deepEquals(str2D_1,str2D_2)); //true
		
		int[] arr_copy = {0,1,2,3,4};
		int[] arr_copy2 = Arrays.copyOf(arr_copy, arr_copy.length);  // [0,1,2,3,4]
		int[] arr_copy3 = Arrays.copyOf(arr_copy, 3);  // [0,1,2]
		int[] arr_copy4 = Arrays.copyOf(arr_copy, 7);  // [0,1,2,3,4,0,0]
		int[] arr_copy5 = Arrays.copyOfRange(arr_copy, 2,4);  // [2,3]
		int[] arr_copy6 = Arrays.copyOfRange(arr_copy, 0,7);  // [0,1,2,3,4,0,0]
		
		// 배열의 정렬
		int[] sort_arr = {3,2,0,1,4};
		Arrays.sort(sort_arr);
		System.out.println(sort_arr);  // [0,1,2,3,4] 오름차순 정렬
		
	}	

}
