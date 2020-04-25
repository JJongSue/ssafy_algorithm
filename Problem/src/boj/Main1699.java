package boj;

import java.util.Scanner;

public class Main1699 {
	static int N, max;
	static int ans = 100_000;
	static int dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N+1];
		max = (int) Math.sqrt(N);
		for(int i=1;i<=N;i++) dp[i] = -1;
		for(int i=1;i<=max;i++) dp[i*i] = 1;
		long time = System.currentTimeMillis();
		ans = get_num(N);
		System.out.println(System.currentTimeMillis() - time);
		System.out.println(ans);
	}
	
	static int get_num(int now) {
//		System.out.println(now);
		if(dp[now] != -1) return dp[now];
		int tmp = (int) Math.sqrt(now);
		dp[now] = 1 + get_num(now - (tmp*tmp));
		for(int i=tmp-1;i>=1;i--) {
			dp[now] = Math.min(dp[now], 1+get_num(now - (i*i)));
		}
//		dp[now] = get_num(now/2) + get_num(now - now/2);
//		for(int i=(now/2)-1;i>=1;i--) {
//			dp[now] = Math.min(dp[now], get_num(now - i) + get_num(i));
//		}
		return dp[now];
		
		
	}
}
