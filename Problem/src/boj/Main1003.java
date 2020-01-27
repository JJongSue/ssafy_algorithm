package boj;

import java.util.Scanner;

public class Main1003 {
	static long dp[][] = new long[41][2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<=40;i++) {
			dp[i][0] = -1;
			dp[i][1] = -1;
		}
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][1] = 1;
		dp[1][0] = 0;
		
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			System.out.println(cnt0(N) + " " + cnt1(N));
		}
	}
	static long cnt0(int now) {
		if(dp[now][0] != -1) return dp[now][0];
		return dp[now][0] = cnt0(now-1) + cnt0(now-2);
	}
	
	static long cnt1(int now) {
		if(dp[now][1] != -1) return dp[now][1];
		return dp[now][1] = cnt1(now-1) + cnt1(now-2);
	}
	
}
