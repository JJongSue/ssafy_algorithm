package boj;

import java.util.Scanner;

public class Main1904 {
	static final int div = 15746;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N <= 0) System.out.println(0);
		else if(N == 1) System.out.println(1);
		else {
			long arr[] = new long[N+1];
			arr[1] = 1;
			arr[2] = 2;
			for(int i=3;i<=N;i++) arr[i] = (arr[i-1]+arr[i-2])%div;
			System.out.println(arr[N]);
		}
	}
}
