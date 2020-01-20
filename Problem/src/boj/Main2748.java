package boj;

import java.util.Scanner;

public class Main2748 {
	static long dp[] = new long[91];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		System.out.println(p(N));
	}
	
	static long p(int n) {
		if(dp[n] != 0) return dp[n];
		return dp[n] = p(n-1) + p(n-2);
	}
}
