package boj;

import java.util.Scanner;

public class Main9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long arr[] = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
//		arr[6] = 3;
		for(int i=6;i<101;i++) {
			arr[i] = arr[i-5] + arr[i-1];
		}
		int T = sc.nextInt();
		for(int i=0;i<T;i++) {
			int tmp = sc.nextInt();
			System.out.println(arr[tmp]);
		}
	}
}
