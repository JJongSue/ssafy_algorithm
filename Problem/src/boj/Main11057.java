package boj;

import java.util.Scanner;

public class Main11057 {
	static final int div = 10_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[][] = new int[10][N];
		for(int i=0;i<10;i++) dp[i][0] = 1;
		for(int i=1;i<N;i++) {
			for(int j=0;j<10;j++) {
				
				for(int k=0;k<=j;k++) {
					dp[j][i] = (dp[j][i] + dp[k][i-1] ) % div;
				}
			}
		}
		int ans = 0;
		for(int i=0;i<10;i++) {
			ans = ( ans + dp[i][N-1] ) % div;
		}
		System.out.println(ans);
	}
}
