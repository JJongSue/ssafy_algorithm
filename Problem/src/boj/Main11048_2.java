package boj;

import java.util.Scanner;

public class Main11048_2 {
	static int N, M;
	static int map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) map[i][j]=sc.nextInt();
		}
		dp = new int[N][M];
		solve(0,0);
		System.out.println(dp[0][0]);
	}
	static int[][] dp;
	static int solve(int y, int x) {
		if( x==N-1 && y==M-1) return dp[y][x]=map[y][x];
		if(dp[y][x] != 0) return dp[y][x];
		int result = map[y][x];
		int s1=0, s2=0;
		if(y != N-1) s1=solve(y+1,x);
		if(x != M-1) s2=solve(y,x+1);
		result += Math.max(s1, s2);
		return dp[y][x]=result;
	}
}
