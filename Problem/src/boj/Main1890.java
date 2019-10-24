package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1890 {
	static long dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		dp = new long[N][N];
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[N-1][N-1] = 1;
		for(int i=N-1;i>=0;i--) {
			for(int j=N-1;j>=0;j--) {
				if(i == N-1 && j == N-1) continue;
				long min = 0;
				if(is_map(map[i][j]+j,i,N)) {
					min = dp[i][map[i][j]+j];
				}
				if(is_map(j,map[i][j]+i,N)) {
					min += dp[map[i][j]+i][j];
				}
				dp[i][j] = min;
			}
		}
		System.out.println(dp[0][0]);
		
	}
	static boolean is_map(int x, int y, int N) {
		if(x<0 || y<0 || x>=N || y>=N) return false;
		if(dp[y][x] == 0) return false;
		return true;
	}
	
	
}
