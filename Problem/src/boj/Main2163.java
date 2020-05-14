package boj;

import java.util.Scanner;

public class Main2163 {
	static int N, M;
	static long dp[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		dp = new long[N+1][M+1];
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=M;j++) dp[i][j] = -1;
		}
		if(N == 1) System.out.println(M-1);
		else if(M == 1) System.out.println(N-1);
		else {
			dp[2][1] = 1;
			dp[1][2] = 1;
			dp[1][1] = 0;
			System.out.println(get_num(N, M));
			
		}
	}
	
	static long get_num(int n, int m) {
		if(dp[n][m] != -1) return dp[n][m];
		if(n == 1) {
			return m-1;
		}
		if(m == 1) return n-1;
//		System.out.println(n+" "+m);
		long ret = 987654321;
		for(int i=1;i<=(n+1)/2;i++) {
			ret = Math.min(ret, get_num(i, m) + get_num(n-i, m) + 1);
		}
		for(int i=1;i<=(m+1)/2;i++) {
			ret = Math.min(ret, get_num(n, i) + get_num(n, m-i) + 1);
		}
		
		return dp[n][m]= ret;
	}
}
